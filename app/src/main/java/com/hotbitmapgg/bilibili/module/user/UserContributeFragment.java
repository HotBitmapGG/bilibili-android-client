package com.hotbitmapgg.bilibili.module.user;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.hotbitmapgg.bilibili.adapter.UserContributeVideoAdapter;
import com.hotbitmapgg.bilibili.adapter.helper.EndlessRecyclerOnScrollListener;
import com.hotbitmapgg.bilibili.adapter.helper.HeaderViewRecyclerAdapter;
import com.hotbitmapgg.bilibili.base.RxLazyFragment;
import com.hotbitmapgg.bilibili.entity.user.UserContributeInfo;
import com.hotbitmapgg.bilibili.module.video.VideoDetailsActivity;
import com.hotbitmapgg.bilibili.network.RetrofitHelper;
import com.hotbitmapgg.bilibili.utils.ConstantUtil;
import com.hotbitmapgg.bilibili.widget.CustomEmptyView;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 2016/10/12 13:30
 * 100332338@qq.com
 * <p>
 * 用户详情界面的投稿
 */

public class UserContributeFragment extends RxLazyFragment {
    @BindView(R.id.recycle)
    RecyclerView mRecyclerView;
    @BindView(R.id.empty_view)
    CustomEmptyView mCustomEmptyView;

    private int mid;
    private int pageNum = 1;
    private int pageSize = 10;
    private View loadMoreView;
    private UserContributeVideoAdapter mAdapter;
    private HeaderViewRecyclerAdapter mHeaderViewRecyclerAdapter;
    private List<UserContributeInfo.DataBean.VlistBean> userContributes = new ArrayList<>();


    public static UserContributeFragment newInstance(int mid, UserContributeInfo userContributeInfo) {
        UserContributeFragment mFragment = new UserContributeFragment();
        Bundle mBundle = new Bundle();
        mBundle.putInt(ConstantUtil.EXTRA_MID, mid);
        mBundle.putParcelable(ConstantUtil.EXTRA_DATA, userContributeInfo);
        mFragment.setArguments(mBundle);
        return mFragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_user_contribute;
    }


    @Override
    public void finishCreateView(Bundle state) {
        mid = getArguments().getInt(ConstantUtil.EXTRA_MID);
        UserContributeInfo userContributeInfo = getArguments().getParcelable(ConstantUtil.EXTRA_DATA);
        if (userContributeInfo != null) {
            userContributes.addAll(userContributeInfo.getData().getVlist());
        }
        initRecyclerView();
    }


    @Override
    protected void loadData() {
        RetrofitHelper.getUserAPI()
                .getUserContributeVideos(mid, pageNum, pageSize)
                .compose(this.bindToLifecycle())
                .map(userContributeInfo -> userContributeInfo.getData().getVlist())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(vlistBeans -> {
                    if (vlistBeans.size() < pageSize) {
                        loadMoreView.setVisibility(View.GONE);
                        mHeaderViewRecyclerAdapter.removeFootView();
                    }
                })
                .subscribe(vlistBeans -> {
                    userContributes.addAll(vlistBeans);
                    finishTask();
                }, throwable -> loadMoreView.setVisibility(View.GONE));
    }


    @Override
    protected void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new UserContributeVideoAdapter(mRecyclerView, userContributes);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mHeaderViewRecyclerAdapter = new HeaderViewRecyclerAdapter(mAdapter);
        mRecyclerView.setAdapter(mHeaderViewRecyclerAdapter);
        createHeadView();
        createLoadMoreView();
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(mLinearLayoutManager) {
            @Override
            public void onLoadMore(int i) {
                pageNum++;
                loadData();
                loadMoreView.setVisibility(View.VISIBLE);
            }
        });
        if (userContributes.isEmpty()) {
            initEmptyLayout();
        }
        mAdapter.setOnItemClickListener((position, holder) -> VideoDetailsActivity.launch(getActivity(),
                userContributes.get(position).getAid(), userContributes.get(position).getPic()));
    }


    @Override
    protected void finishTask() {
        loadMoreView.setVisibility(View.GONE);
        if (pageNum * pageSize - pageSize - 1 > 0) {
            mAdapter.notifyItemRangeChanged(pageNum * pageSize - pageSize - 1, pageSize);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private void createHeadView() {
        View headView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_user_chase_bangumi_head, mRecyclerView, false);
        mHeaderViewRecyclerAdapter.addHeaderView(headView);
    }


    private void createLoadMoreView() {
        loadMoreView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_load_more, mRecyclerView, false);
        mHeaderViewRecyclerAdapter.addFooterView(loadMoreView);
        loadMoreView.setVisibility(View.GONE);
    }

    private void initEmptyLayout() {
        mCustomEmptyView.setEmptyImage(R.drawable.img_tips_error_space_no_data);
        mCustomEmptyView.setEmptyText("ㄟ( ▔, ▔ )ㄏ 再怎么找也没有啦");
    }
}
