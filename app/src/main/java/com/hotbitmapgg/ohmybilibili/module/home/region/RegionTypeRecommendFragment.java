package com.hotbitmapgg.ohmybilibili.module.home.region;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.section.RegionRecommendBannerSection;
import com.hotbitmapgg.ohmybilibili.adapter.section.RegionRecommendDynamicSection;
import com.hotbitmapgg.ohmybilibili.adapter.section.RegionRecommendHotSection;
import com.hotbitmapgg.ohmybilibili.adapter.section.RegionRecommendNewSection;
import com.hotbitmapgg.ohmybilibili.adapter.section.RegionRecommendTypesSection;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.region.RegionRecommendInfo;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.ConstantUtil;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.utils.ToastUtil;
import com.hotbitmapgg.ohmybilibili.widget.banner.BannerEntity;
import com.hotbitmapgg.ohmybilibili.widget.sectioned.SectionedRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 2016/10/21 20:39
 * 100332338@qq.com
 * <p>
 * 分区推荐页面
 */

public class RegionTypeRecommendFragment extends RxLazyFragment
{


    @BindView(R.id.recycle)
    RecyclerView mRecyclerView;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mRefreshLayout;

    private int rid;

    private boolean mIsRefreshing = false;

    private SectionedRecyclerViewAdapter mSectionedRecyclerViewAdapter;

    private List<BannerEntity> bannerEntities = new ArrayList<>();

    private List<RegionRecommendInfo.DataBean.BannerBean.TopBean> banners = new ArrayList<>();

    private List<RegionRecommendInfo.DataBean.RecommendBean> recommends = new ArrayList<>();

    private List<RegionRecommendInfo.DataBean.NewBean> news = new ArrayList<>();

    private List<RegionRecommendInfo.DataBean.DynamicBean> dynamics = new ArrayList<>();

    public static RegionTypeRecommendFragment newInstance(int rid)
    {

        RegionTypeRecommendFragment fragment = new RegionTypeRecommendFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ConstantUtil.EXTRA_RID, rid);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_region_recommend;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        rid = getArguments().getInt(ConstantUtil.EXTRA_RID);
        initRefreshLayout();
        initRecyclerView();
    }

    @Override
    protected void initRefreshLayout()
    {

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

    private void clearData()
    {

        bannerEntities.clear();
        banners.clear();
        recommends.clear();
        news.clear();
        dynamics.clear();
        mIsRefreshing = true;
        mSectionedRecyclerViewAdapter.removeAllSections();
    }

    @Override
    protected void initRecyclerView()
    {

        mSectionedRecyclerViewAdapter = new SectionedRecyclerViewAdapter();
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup()
        {

            @Override
            public int getSpanSize(int position)
            {

                switch (mSectionedRecyclerViewAdapter.getSectionItemViewType(position))
                {
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
    protected void loadData()
    {

        RetrofitHelper.getRegionRecommendApi()
                .getRegionRecommends(rid)
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
    protected void finishTask()
    {

        converBanner();
        mSectionedRecyclerViewAdapter.addSection(new RegionRecommendBannerSection(bannerEntities));
        mSectionedRecyclerViewAdapter.addSection(new RegionRecommendTypesSection(getActivity(), rid));
        mSectionedRecyclerViewAdapter.addSection(new RegionRecommendHotSection(getActivity(), rid, recommends));
        mSectionedRecyclerViewAdapter.addSection(new RegionRecommendNewSection(getActivity(), rid, news));
        mSectionedRecyclerViewAdapter.addSection(new RegionRecommendDynamicSection(getActivity(), dynamics));

        mIsRefreshing = false;
        mRefreshLayout.setRefreshing(false);
        mSectionedRecyclerViewAdapter.notifyDataSetChanged();
    }

    private void converBanner()
    {

        Observable.from(banners)
                .compose(bindToLifecycle())
                .forEach(topBean -> bannerEntities.add(new BannerEntity(topBean.getUri(),
                        topBean.getTitle(), topBean.getImage())));
    }

    private void setRecycleNoScroll()
    {

        mRecyclerView.setOnTouchListener((v, event) -> mIsRefreshing);
    }
}
