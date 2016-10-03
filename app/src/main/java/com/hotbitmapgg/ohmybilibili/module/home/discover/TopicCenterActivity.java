package com.hotbitmapgg.ohmybilibili.module.home.discover;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.TopicCenterAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.helper.EndlessRecyclerOnScrollListener;
import com.hotbitmapgg.ohmybilibili.adapter.helper.HeaderViewRecyclerAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.entity.discover.TopicCenterInfo;
import com.hotbitmapgg.ohmybilibili.module.common.WebActivity;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 2016/10/3 15:47
 * 100332338@qq.com
 * <p>
 * 话题中心界面
 */

public class TopicCenterActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    private int page = 0;

    private int pageSize = 10;

    private List<TopicCenterInfo.ListBean> topicCenters = new ArrayList<>();

    private View loadMoreView;

    private HeaderViewRecyclerAdapter mHeaderViewRecyclerAdapter;

    private TopicCenterAdapter mAdapter;

    @Override
    public int getLayoutId()
    {

        return R.layout.activity_topic_center;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        showProgressBar();
        initRecyclerView();
    }

    private void initRecyclerView()
    {

        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new TopicCenterAdapter(mRecyclerView, topicCenters);
        mHeaderViewRecyclerAdapter = new HeaderViewRecyclerAdapter(mAdapter);
        createLoadMoreView();
        mRecyclerView.setAdapter(mHeaderViewRecyclerAdapter);
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager)
        {

            @Override
            public void onLoadMore(int currentPage)
            {

                page++;
                getTopicCenterList();
                loadMoreView.setVisibility(View.VISIBLE);
            }
        });
        mAdapter.setOnItemClickListener((position, holder) -> WebActivity.launch(
                TopicCenterActivity.this, topicCenters.get(position).getLink(), topicCenters.get(position).getTitle()));
    }

    private void showProgressBar()
    {

        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.post(() -> mSwipeRefreshLayout.setRefreshing(true));
        mSwipeRefreshLayout.setOnRefreshListener(() -> {

            page = 1;
            topicCenters.clear();
            getTopicCenterList();
        });
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setTitle("话题中心");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    public void getTopicCenterList()
    {

        RetrofitHelper.getTopicCenterApi()
                .getTopicCenterList(page, pageSize)
                .compose(bindToLifecycle())
                .map(TopicCenterInfo::getList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listBeans -> {

                    if (listBeans.size() < pageSize)
                        loadMoreView.setVisibility(View.GONE);

                    topicCenters.addAll(listBeans);
                    finishTask();
                }, throwable -> {
                    mSwipeRefreshLayout.setRefreshing(false);
                    loadMoreView.setVisibility(View.GONE);
                    ToastUtil.ShortToast("加载失败啦,请重新加载~");
                });
    }


    private void finishTask()
    {

        mSwipeRefreshLayout.setRefreshing(false);
        loadMoreView.setVisibility(View.GONE);

        if (page * pageSize - pageSize - 1 > 0)
            mAdapter.notifyItemRangeChanged(page * pageSize - pageSize - 1, pageSize);
        else
            mAdapter.notifyDataSetChanged();
    }

    private void createLoadMoreView()
    {

        loadMoreView = LayoutInflater.from(TopicCenterActivity.this)
                .inflate(R.layout.layout_load_more, mRecyclerView, false);
        mHeaderViewRecyclerAdapter.addFooterView(loadMoreView);
        loadMoreView.setVisibility(View.GONE);
    }
}
