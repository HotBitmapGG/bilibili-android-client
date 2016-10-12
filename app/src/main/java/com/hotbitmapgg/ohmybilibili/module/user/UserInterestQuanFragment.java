package com.hotbitmapgg.ohmybilibili.module.user;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.UserInterestQuanAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.helper.EndlessRecyclerOnScrollListener;
import com.hotbitmapgg.ohmybilibili.adapter.helper.HeaderViewRecyclerAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.user.UserInterestQuanInfo;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.widget.CustomEmptyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 2016/10/12 18:17
 * 100332338@qq.com
 * <p>
 * 用户详情界面的兴趣圈
 */

public class UserInterestQuanFragment extends RxLazyFragment
{

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.empty_view)
    CustomEmptyView mCustomEmptyView;

    private int mid;

    private int pageNum = 1;

    private int pageSize = 10;

    private static final String EXTRA_MID = "extra_mid";

    private HeaderViewRecyclerAdapter mHeaderViewRecyclerAdapter;

    private View loadMoreView;

    private List<UserInterestQuanInfo.DataBean.ResultBean> userInterestQuans = new ArrayList<>();

    private UserInterestQuanAdapter mAdapter;

    public static UserInterestQuanFragment newInstance(int mid)
    {

        UserInterestQuanFragment mFragment = new UserInterestQuanFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_MID, mid);
        mFragment.setArguments(bundle);
        return mFragment;
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_user_interest_quan;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        mid = getArguments().getInt(EXTRA_MID);

        initRecyclerView();
        getUserInterestQuanData();
    }

    private void initRecyclerView()
    {

        mRecyclerView.setHasFixedSize(true);
        mAdapter = new UserInterestQuanAdapter(mRecyclerView, userInterestQuans);
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
                getUserInterestQuanData();
                loadMoreView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void getUserInterestQuanData()
    {

        RetrofitHelper.getUserInterestQuanApi()
                .getUserInterestQuanData(mid, pageNum, pageSize)
                .compose(bindToLifecycle())
                .map(userInterestQuanInfo -> userInterestQuanInfo.getData().getResult())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(resultBeans -> {

                    if (resultBeans.size() < pageSize)
                        loadMoreView.setVisibility(View.GONE);

                    userInterestQuans.addAll(resultBeans);
                    finishTask();
                }, throwable -> {
                    initEmptyLayout();
                });
    }

    private void finishTask()
    {

        loadMoreView.setVisibility(View.GONE);

        if (pageNum * pageSize - pageSize - 1 > 0)
            mAdapter.notifyItemRangeChanged(pageNum * pageSize - pageSize - 1, pageSize);
        else
            mAdapter.notifyDataSetChanged();

        if (userInterestQuans.isEmpty())
            initEmptyLayout();
    }

    private void createLoadMoreView()
    {

        loadMoreView = LayoutInflater.from(getActivity())
                .inflate(R.layout.layout_load_more, mRecyclerView, false);
        mHeaderViewRecyclerAdapter.addFooterView(loadMoreView);
        loadMoreView.setVisibility(View.GONE);
    }

    private void initEmptyLayout()
    {

        mCustomEmptyView.setEmptyImage(R.drawable.img_tips_error_space_no_data);
        mCustomEmptyView.setEmptyText("ㄟ( ▔, ▔ )ㄏ 再怎么找也没有啦");
        mCustomEmptyView.hideReloadButton();
    }
}
