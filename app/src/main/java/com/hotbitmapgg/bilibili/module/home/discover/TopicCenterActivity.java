package com.hotbitmapgg.bilibili.module.home.discover;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.hotbitmapgg.bilibili.adapter.TopicCenterAdapter;
import com.hotbitmapgg.bilibili.base.RxBaseActivity;
import com.hotbitmapgg.bilibili.entity.discover.TopicCenterInfo;
import com.hotbitmapgg.bilibili.module.common.BrowserActivity;
import com.hotbitmapgg.bilibili.network.RetrofitHelper;
import com.hotbitmapgg.bilibili.utils.ToastUtil;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 2016/10/3 15:47
 * 100332338@qq.com
 * <p>
 * 话题中心界面
 */

public class TopicCenterActivity extends RxBaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.recycle)
    RecyclerView mRecyclerView;

    private TopicCenterAdapter mAdapter;
    private boolean mIsRefreshing = false;
    private List<TopicCenterInfo.ListBean> topicCenters = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_topic_center;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        initRefreshLayout();
        initRecyclerView();
    }


    @Override
    public void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new TopicCenterAdapter(mRecyclerView, topicCenters);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((position, holder) -> BrowserActivity.launch(
                TopicCenterActivity.this, topicCenters.get(position).getLink(),
                topicCenters.get(position).getTitle()));
        setRecycleNoScroll();
    }


    @Override
    public void initRefreshLayout() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.post(() -> {
            mIsRefreshing = true;
            mSwipeRefreshLayout.setRefreshing(true);
            loadData();
        });
        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            mIsRefreshing = true;
            topicCenters.clear();
            loadData();
        });
    }


    @Override
    public void initToolBar() {
        mToolbar.setTitle("话题中心");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void loadData() {
        RetrofitHelper.getBiliAPI()
                .getTopicCenterList()
                .compose(bindToLifecycle())
                .map(TopicCenterInfo::getList)
                .map(listBeans -> {
                    List<TopicCenterInfo.ListBean> tempList = new ArrayList<>();
                    for (int i = 0, size = listBeans.size(); i < size; i++) {
                        TopicCenterInfo.ListBean listBean = listBeans.get(i);
                        if (!Objects.equals(listBean.getCover(), "")) {
                            tempList.add(listBean);
                        }
                    }
                    return tempList;
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listBeans -> {
                    topicCenters.addAll(listBeans);
                    finishTask();
                }, throwable -> {
                    mSwipeRefreshLayout.setRefreshing(false);
                    ToastUtil.ShortToast("加载失败啦,请重新加载~");
                });
    }


    @Override
    public void finishTask() {
        mIsRefreshing = false;
        mSwipeRefreshLayout.setRefreshing(false);
        mAdapter.notifyDataSetChanged();
    }


    private void setRecycleNoScroll() {
        mRecyclerView.setOnTouchListener((v, event) -> mIsRefreshing);
    }
}
