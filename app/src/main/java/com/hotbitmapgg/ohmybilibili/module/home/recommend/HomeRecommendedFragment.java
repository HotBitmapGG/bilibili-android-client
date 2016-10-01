package com.hotbitmapgg.ohmybilibili.module.home.recommend;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.section.HomeRecommendActivityCenterSection;
import com.hotbitmapgg.ohmybilibili.adapter.section.HomeRecommendBannerSection;
import com.hotbitmapgg.ohmybilibili.adapter.section.HomeRecommendTopicSection;
import com.hotbitmapgg.ohmybilibili.adapter.section.HomeRecommendedSection;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.recommended.RecommendBannerInfo;
import com.hotbitmapgg.ohmybilibili.entity.recommended.RecommendInfo;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.SnackbarUtil;
import com.hotbitmapgg.ohmybilibili.widget.CustomEmptyView;
import com.hotbitmapgg.ohmybilibili.widget.banner.BannerEntity;
import com.hotbitmapgg.ohmybilibili.widget.sectioned.SectionedRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 11:58
 * 100332338@qq.com
 * <p/>
 * 主页推荐界面
 */
public class HomeRecommendedFragment extends RxLazyFragment
{

    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.empty_layout)
    CustomEmptyView mCustomEmptyView;

    private List<RecommendInfo.ResultBean> results = new ArrayList<>();

    private List<BannerEntity> banners = new ArrayList<>();

    private List<RecommendBannerInfo.DataBean> recommendBanners = new ArrayList<>();

    //RecycleView是否正在刷新
    private boolean mIsRefreshing = false;

    private SectionedRecyclerViewAdapter mSectionedAdapter;

    private static final String TYPE_TOPIC = "weblink";

    private static final String TYPE_ACTIVITY_CENTER = "activity";

    private int[] icons = new int[]{
            R.drawable.ic_header_hot,
            R.drawable.ic_head_live,
            R.drawable.ic_category_t13,
            R.drawable.ic_category_t1,
            R.drawable.ic_category_t3,
            R.drawable.ic_header_topic,
            R.drawable.ic_category_t129,
            R.drawable.ic_header_topic,
            R.drawable.ic_category_t4,
            R.drawable.ic_category_t119,
            R.drawable.ic_category_t36,
            R.drawable.ic_header_activity_center,
            R.drawable.ic_category_t160,
            R.drawable.ic_category_t155,
            R.drawable.ic_header_topic,
            R.drawable.ic_category_t5,
            R.drawable.ic_category_t11,
            R.drawable.ic_category_t23
    };

    public static HomeRecommendedFragment newInstance()
    {

        return new HomeRecommendedFragment();
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_home_recommended;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        isPrepared = true;
        lazyLoad();
    }

    @Override
    protected void lazyLoad()
    {

        if (!isPrepared || !isVisible)
            return;

        showProgressBar();
        initRecyclerView();
        isPrepared = false;
    }

    private void initRecyclerView()
    {

        mSectionedAdapter = new SectionedRecyclerViewAdapter();
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup()
        {

            @Override
            public int getSpanSize(int position)
            {

                switch (mSectionedAdapter.getSectionItemViewType(position))
                {
                    case SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER:
                        return 2;

                    case SectionedRecyclerViewAdapter.VIEW_TYPE_FOOTER:
                        return 2;

                    default:
                        return 1;
                }
            }
        });
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mSectionedAdapter);
        setRecycleNoScroll();
    }

    private void showProgressBar()
    {

        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.post(() -> {

            mSwipeRefreshLayout.setRefreshing(true);
            mIsRefreshing = true;
            getHomeRecommendedData();
        });

        mSwipeRefreshLayout.setOnRefreshListener(() -> {

            clearData();
            getHomeRecommendedData();
        });
    }


    private void getHomeRecommendedData()
    {

        RetrofitHelper.getHomeRecommendedApi()
                .getRecommendedBannerInfo()
                .compose(this.bindToLifecycle())
                .flatMap(new Func1<RecommendBannerInfo,Observable<RecommendInfo>>()
                {

                    @Override
                    public Observable<RecommendInfo> call(RecommendBannerInfo recommendBannerInfo)
                    {
                        //设置Banner数据
                        recommendBanners.addAll(recommendBannerInfo.getData());
                        convertBanner();
                        //在请求首页推荐数据
                        return RetrofitHelper.getHomeRecommendedApi().getRecommendedInfo();
                    }
                })
                .compose(this.bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(recommendInfo -> {

                    results.addAll(recommendInfo.getResult());
                    finishTask();
                }, throwable -> {

                    initEmptyView();
                });
    }

    /**
     * 设置轮播banners
     */
    private void convertBanner()
    {

        BannerEntity banner;
        for (int i = 0, size = recommendBanners.size(); i < size; i++)
        {
            RecommendBannerInfo.DataBean dataBean = recommendBanners.get(i);
            banner = new BannerEntity();
            banner.img = dataBean.getImage();
            banner.title = dataBean.getTitle();
            banner.link = dataBean.getValue();
            banners.add(banner);
        }
    }


    private void finishTask()
    {

        mSwipeRefreshLayout.setRefreshing(false);
        mIsRefreshing = false;
        hideEmptyView();
        mSectionedAdapter.addSection(new HomeRecommendBannerSection(banners));

        int size = results.size();
        for (int i = 0; i < size; i++)
        {
            String type = results.get(i).getType();
            switch (type)
            {
                case TYPE_TOPIC:
                    //话题
                    mSectionedAdapter.addSection(new HomeRecommendTopicSection(getActivity(),
                            results.get(i).getBody().get(0).getCover(),
                            results.get(i).getBody().get(0).getTitle(),
                            results.get(i).getBody().get(0).getParam()));
                    break;
                case TYPE_ACTIVITY_CENTER:
                    //活动中心
                    mSectionedAdapter.addSection(new HomeRecommendActivityCenterSection(
                            getActivity(),
                            results.get(i).getBody()));
                    break;
                default:
                    mSectionedAdapter.addSection(new HomeRecommendedSection(
                            getActivity(),
                            icons[i],
                            results.get(i).getHead().getTitle(),
                            results.get(i).getType(),
                            results.get(1).getHead().getCount(),
                            results.get(i).getBody()));
                    break;
            }
        }
        mSectionedAdapter.notifyDataSetChanged();
    }

    public void initEmptyView()
    {

        mSwipeRefreshLayout.setRefreshing(false);
        mCustomEmptyView.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
        mCustomEmptyView.setEmptyImage(R.drawable.img_tips_error_load_error);
        mCustomEmptyView.setEmptyText("加载失败~(≧▽≦)~啦啦啦.");
        SnackbarUtil.showMessage(mRecyclerView, "数据加载失败,请重新加载或者检查网络是否链接");
        mCustomEmptyView.reload(this::showProgressBar);
    }

    public void hideEmptyView()
    {

        mCustomEmptyView.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }


    private void clearData()
    {

        banners.clear();
        recommendBanners.clear();
        results.clear();
        mIsRefreshing = true;
        mSectionedAdapter.removeAllSections();
    }


    private void setRecycleNoScroll()
    {

        mRecyclerView.setOnTouchListener((v, event) -> mIsRefreshing);
    }
}
