package com.hotbitmapgg.ohmybilibili.module.home.recommend;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.section.HomeRecommendActivityCenterSection;
import com.hotbitmapgg.ohmybilibili.adapter.section.HomeRecommendBannerSection;
import com.hotbitmapgg.ohmybilibili.adapter.section.HomeRecommendTopicSection;
import com.hotbitmapgg.ohmybilibili.adapter.section.HomeRecommendedSection;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.BaseBanner;
import com.hotbitmapgg.ohmybilibili.entity.recommended.RecommendInfo;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.utils.SnackbarUtil;
import com.hotbitmapgg.ohmybilibili.widget.CustomEmptyView;
import com.hotbitmapgg.ohmybilibili.widget.sectioned.SectionedRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
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

    private List<BaseBanner> banners = new ArrayList<>();

    private static final String BANNER_TYPE = "weblink";

    //RecycleView是否正在刷新
    private boolean mIsRefreshing = false;

    private SectionedRecyclerViewAdapter mSectionedAdapter;

    private int[] icons = new int[]{
            R.drawable.ic_header_hot,
            R.drawable.ic_head_live,
            R.drawable.ic_category_t13,
            R.drawable.ic_category_t1,
            R.drawable.ic_category_t3,
            R.drawable.ic_category_t129,
            R.drawable.ic_category_t4,
            R.drawable.ic_category_t119,
            R.drawable.ic_category_t36,
            R.drawable.ic_header_activity_center,
            R.drawable.ic_category_t160,
            R.drawable.ic_category_t155,
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
        mSwipeRefreshLayout.post(new Runnable()
        {

            @Override
            public void run()
            {

                mSwipeRefreshLayout.setRefreshing(true);
                mIsRefreshing = true;
                getHomeRecommendedData();
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {

            @Override
            public void onRefresh()
            {

                banners.clear();
                results.clear();
                mIsRefreshing = true;
                mSectionedAdapter.removeAllSections();
                getHomeRecommendedData();
            }
        });
    }


    private void getHomeRecommendedData()
    {

        RetrofitHelper.getHomeRecommendedApi()
                .getRecommendedInfo()
                .compose(this.<RecommendInfo> bindToLifecycle())
                .flatMap(new Func1<RecommendInfo,Observable<String>>()
                {

                    @Override
                    public Observable<String> call(RecommendInfo recommendInfo)
                    {

                        int size = recommendInfo.getResult().size();
                        for (int i = 0; i < size; i++)
                        {
                            RecommendInfo.ResultBean result = recommendInfo.getResult().get(i);
                            BaseBanner banner;
                            if (result.getType() != null)
                            {
                                if (result.getType().equals(BANNER_TYPE))
                                {
                                    List<RecommendInfo.ResultBean.BodyBean> bodys = result.getBody();
                                    RecommendInfo.ResultBean.BodyBean body = bodys.get(0);
                                    banner = new BaseBanner();
                                    banner.img = body.getCover();
                                    banner.title = body.getTitle();
                                    banner.link = body.getParam();
                                    banners.add(banner);
                                } else
                                {
                                    results.add(result);
                                }
                            }
                        }

                        return Observable.just("onNext");
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>()
                {

                    @Override
                    public void call(String s)
                    {

                        finishTask();
                    }
                }, new Action1<Throwable>()
                {

                    @Override
                    public void call(Throwable throwable)
                    {

                        initEmptyView();
                        LogUtil.all("首页推荐界面加载失败" + throwable.getMessage());
                    }
                });
    }


    private void finishTask()
    {

        mSwipeRefreshLayout.setRefreshing(false);
        mIsRefreshing = false;
        hideEmptyView();

        mSectionedAdapter.addSection(new HomeRecommendBannerSection(banners));
        for (int i = 0, size = results.size() + 2; i < size; i++)
        {

            if (i == 9)
            {
                mSectionedAdapter.addSection(new HomeRecommendActivityCenterSection(
                        getActivity(),
                        results.get(9).getBody()));
            } else if (i == size - 2)
            {
                mSectionedAdapter.addSection(new HomeRecommendTopicSection(getActivity(),
                        banners.get(banners.size() - 2).img,
                        banners.get(banners.size() - 2).title));
            }
            else if(i == size - 1)
            {
                mSectionedAdapter.addSection(new HomeRecommendTopicSection(getActivity(),
                        banners.get(banners.size() - 1).img,
                        banners.get(banners.size() - 1).title));
            }
            else
            {
                mSectionedAdapter.addSection(new HomeRecommendedSection(
                        getActivity(),
                        icons[i],
                        results.get(i).getHead().getTitle(),
                        results.get(i).getType(),
                        results.get(1).getHead().getCount(),
                        results.get(i).getBody()));
            }
        }
        mSectionedAdapter.notifyDataSetChanged();
    }

    public void initEmptyView()
    {

        mSwipeRefreshLayout.setRefreshing(false);
        mCustomEmptyView.setVisibility(View.VISIBLE);
        mCustomEmptyView.setEmptyImage(R.drawable.img_tips_error_load_error);
        mCustomEmptyView.setEmptyText("加载失败~(≧▽≦)~啦啦啦.");
        SnackbarUtil.showMessage(mRecyclerView, "数据加载失败,请重新加载或者检查网络是否链接");
        mCustomEmptyView.reload(new CustomEmptyView.ReloadOnClickListener()
        {

            @Override
            public void reloadClick()
            {

                showProgressBar();
            }
        });
    }

    public void hideEmptyView()
    {

        mCustomEmptyView.setVisibility(View.GONE);
    }


    private void setRecycleNoScroll()
    {

        mRecyclerView.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {


                if (mIsRefreshing)
                {
                    return true;
                } else
                {
                    return false;
                }
            }
        });
    }
}
