package com.hotbitmapgg.ohmybilibili.module.user;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.UserContributeVideoAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.helper.EndlessRecyclerOnScrollListener;
import com.hotbitmapgg.ohmybilibili.adapter.helper.HeaderViewRecyclerAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.user.UserUpVideoInfo;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 2016/10/12 13:30
 * 100332338@qq.com
 * <p>
 * 用户详情界面的投稿
 */

public class UserInfoContributeFragment extends RxLazyFragment
{


    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    private static final String EXTRA_MID = "extra_mid";

    private int mid;

    private int pageNum = 1;

    private int pageSize = 10;

    private HeaderViewRecyclerAdapter mHeaderViewRecyclerAdapter;

    private UserContributeVideoAdapter mAdapter;

    private View loadMoreView;

    private List<UserUpVideoInfo.VlistBean> userVideoList = new ArrayList<>();


    public static UserInfoContributeFragment newInstance(int mid)
    {

        UserInfoContributeFragment mFragment = new UserInfoContributeFragment();
        Bundle mBundle = new Bundle();
        mBundle.putInt(EXTRA_MID, mid);
        mFragment.setArguments(mBundle);
        return mFragment;
    }


    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_user_info_contribute;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        mid = getArguments().getInt(EXTRA_MID);

        showProgressBar();
        getUserVideoList();
        initRecyclerView();
    }

    private void getUserVideoList()
    {

        RetrofitHelper.getUserUpVideoListApi()
                .getUserUpVideos(mid, pageNum, pageSize)
                .compose(this.bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userUpVideoInfo -> {

                    List<UserUpVideoInfo.VlistBean> vlist =
                            userUpVideoInfo.getVlist();
                    if (vlist.size() < pageSize)
                        loadMoreView.setVisibility(View.GONE);

                    userVideoList.addAll(vlist);
                    finishTask();
                }, throwable -> {

                    loadMoreView.setVisibility(View.GONE);
                    hideProgressBar();
                });
    }


    private void initRecyclerView()
    {

        mRecyclerView.setHasFixedSize(true);
        mAdapter = new UserContributeVideoAdapter(mRecyclerView, userVideoList);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mHeaderViewRecyclerAdapter = new HeaderViewRecyclerAdapter(mAdapter);
        mRecyclerView.setAdapter(mHeaderViewRecyclerAdapter);
        createLoadMoreView();
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(mLinearLayoutManager)
        {

            @Override
            public void onLoadMore(int i)
            {

                pageNum++;
                getUserVideoList();
                loadMoreView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void finishTask()
    {

        hideProgressBar();
        loadMoreView.setVisibility(View.GONE);

        if (pageNum * pageSize - pageSize - 1 > 0)
            mAdapter.notifyItemRangeChanged(pageNum * pageSize - pageSize - 1, pageSize);
        else
            mAdapter.notifyDataSetChanged();
    }

    private void createLoadMoreView()
    {

        loadMoreView = LayoutInflater.from(getActivity())
                .inflate(R.layout.layout_load_more, mRecyclerView, false);
        mHeaderViewRecyclerAdapter.addFooterView(loadMoreView);
        loadMoreView.setVisibility(View.GONE);
    }

    public void showProgressBar()
    {

        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();
    }

    public void hideProgressBar()
    {

        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
    }
}
