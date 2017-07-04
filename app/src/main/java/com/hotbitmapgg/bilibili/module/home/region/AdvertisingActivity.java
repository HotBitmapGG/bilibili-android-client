package com.hotbitmapgg.bilibili.module.home.region;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.hotbitmapgg.bilibili.adapter.section.RegionRecommendDynamicSection;
import com.hotbitmapgg.bilibili.adapter.section.RegionRecommendHotSection;
import com.hotbitmapgg.bilibili.adapter.section.RegionRecommendNewSection;
import com.hotbitmapgg.bilibili.base.RxBaseActivity;
import com.hotbitmapgg.bilibili.entity.region.RegionRecommendInfo;
import com.hotbitmapgg.bilibili.utils.ConstantUtil;
import com.hotbitmapgg.bilibili.utils.LogUtil;
import com.hotbitmapgg.bilibili.widget.banner.BannerEntity;
import com.hotbitmapgg.bilibili.widget.sectioned.SectionedRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.bilibili.adapter.section.RegionRecommendBannerSection;
import com.hotbitmapgg.bilibili.network.RetrofitHelper;
import com.hotbitmapgg.bilibili.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 2016/10/23 12:09
 * 100332338@qq.com
 * <p>
 * 分区广告界面
 */

public class AdvertisingActivity extends RxBaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.recycle)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mRefreshLayout;

    private boolean mIsRefreshing = false;
    private List<BannerEntity> bannerEntities = new ArrayList<>();
    private SectionedRecyclerViewAdapter mSectionedRecyclerViewAdapter;
    private List<RegionRecommendInfo.DataBean.BannerBean.TopBean> banners = new ArrayList<>();
    private List<RegionRecommendInfo.DataBean.RecommendBean> recommends = new ArrayList<>();
    private List<RegionRecommendInfo.DataBean.NewBean> news = new ArrayList<>();
    private List<RegionRecommendInfo.DataBean.DynamicBean> dynamics = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_advertising;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        initRefreshLayout();
        initRecyclerView();
    }

    @Override
    public void initToolBar() {
        mToolbar.setTitle("广告");
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_region, menu);
        return true;
    }

    @Override
    public void initRefreshLayout() {
        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRecyclerView.post(() -> {
            mRefreshLayout.setRefreshing(true);
            mIsRefreshing = true;
            loadData();
        });
        mRefreshLayout.setOnRefreshListener(() -> {
            clearData();
            loadData();
        });
    }


    private void clearData() {
        bannerEntities.clear();
        banners.clear();
        recommends.clear();
        news.clear();
        dynamics.clear();
        mIsRefreshing = true;
        mSectionedRecyclerViewAdapter.removeAllSections();
    }


    @Override
    public void initRecyclerView() {
        mSectionedRecyclerViewAdapter = new SectionedRecyclerViewAdapter();
        GridLayoutManager mLayoutManager = new GridLayoutManager(AdvertisingActivity.this, 2);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (mSectionedRecyclerViewAdapter.getSectionItemViewType(position)) {
                    case SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER:
                        return 2;
                    default:
                        return 1;
                }
            }
        });
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mSectionedRecyclerViewAdapter);
        setRecycleNoScroll();
    }


    @Override
    public void loadData() {
        RetrofitHelper.getBiliAppAPI()
                .getRegionRecommends(ConstantUtil.ADVERTISING_RID)
                .compose(bindToLifecycle())
                .map(RegionRecommendInfo::getData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(dataBean -> {
                    banners.addAll(dataBean.getBanner().getTop());
                    recommends.addAll(dataBean.getRecommend());
                    news.addAll(dataBean.getNewX());
                    dynamics.addAll(dataBean.getDynamic());
                    finishTask();
                }, throwable -> {
                    LogUtil.all(throwable.getMessage());
                    mRefreshLayout.setRefreshing(false);
                    ToastUtil.ShortToast("加载失败啦,请重新加载~");
                });
    }


    @Override
    public void finishTask() {
        setBanner();
        mSectionedRecyclerViewAdapter.addSection(new RegionRecommendBannerSection(bannerEntities));
        mSectionedRecyclerViewAdapter.addSection(new RegionRecommendHotSection(AdvertisingActivity.this, ConstantUtil.ADVERTISING_RID, recommends));
        mSectionedRecyclerViewAdapter.addSection(new RegionRecommendNewSection(AdvertisingActivity.this, ConstantUtil.ADVERTISING_RID, news));
        mSectionedRecyclerViewAdapter.addSection(new RegionRecommendDynamicSection(AdvertisingActivity.this, dynamics));
        mIsRefreshing = false;
        mRefreshLayout.setRefreshing(false);
        mSectionedRecyclerViewAdapter.notifyDataSetChanged();
    }


    private void setBanner() {
        Observable.from(banners)
                .compose(bindToLifecycle())
                .forEach(topBean -> bannerEntities.add(new BannerEntity(
                        topBean.getUri(), topBean.getTitle(), topBean.getImage())));
    }


    private void setRecycleNoScroll() {
        mRecyclerView.setOnTouchListener((v, event) -> mIsRefreshing);
    }
}
