package com.hotbitmapgg.ohmybilibili.module.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.BangumiRecommendAdapter;
import com.hotbitmapgg.ohmybilibili.base.BaseHomeFragment;
import com.hotbitmapgg.ohmybilibili.model.bangumi.BangumiRecommend;
import com.hotbitmapgg.ohmybilibili.model.live.Banner;
import com.hotbitmapgg.ohmybilibili.retrofit.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.banner.BannerView;
import com.hotbitmapgg.ohmybilibili.widget.swiperefresh.HeaderViewRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 首页番剧界面
 */
public class HomeBangumiFragment extends BaseHomeFragment
{

    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    private List<BangumiRecommend.RecommendsBean> recommends;

    private List<BangumiRecommend.BannersBean> banners;

    private BangumiRecommendAdapter mAdapter;

    private HeaderViewRecyclerAdapter mHeaderViewRecyclerAdapter;

    private BannerView bannerView;

    private View headView_banner;

    private View headView_item;


    public static HomeBangumiFragment newInstance()
    {

        return new HomeBangumiFragment();
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_home_bangumi;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        showProgressBar();
    }

    private void showProgressBar()
    {

        mSwipeRefreshLayout.setColorSchemeResources(R.color.primary);
        mSwipeRefreshLayout.postDelayed(new Runnable()
        {

            @Override
            public void run()
            {

                mSwipeRefreshLayout.setRefreshing(true);
                getBangumiRecommends();
            }
        }, 500);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {

            @Override
            public void onRefresh()
            {

                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void getBangumiRecommends()
    {

        RetrofitHelper.getBnagumiRecommendApi()
                .getBangumiRecommended()
                .compose(this.<BangumiRecommend> bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BangumiRecommend>()
                {


                    @Override
                    public void call(BangumiRecommend bangumiRecommend)
                    {

                        banners = bangumiRecommend.getBanners();
                        recommends = bangumiRecommend.getRecommends();
                        finishTask();
                    }
                }, new Action1<Throwable>()
                {

                    @Override
                    public void call(Throwable throwable)
                    {

                        LogUtil.lsw("新番推荐获取失败" + throwable.getMessage());
                        mSwipeRefreshLayout.post(new Runnable()
                        {

                            @Override
                            public void run()
                            {

                                mSwipeRefreshLayout.setRefreshing(false);
                            }
                        });
                    }
                });
    }

    private void finishTask()
    {

        mSwipeRefreshLayout.setRefreshing(false);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new BangumiRecommendAdapter(mRecyclerView, recommends);
        mHeaderViewRecyclerAdapter = new HeaderViewRecyclerAdapter(mAdapter);
        createHead();
        mRecyclerView.setAdapter(mHeaderViewRecyclerAdapter);
    }

    private void createHead()
    {

        headView_banner = LayoutInflater.from(getActivity()).inflate(R.layout.layout_head_home_recommended, mRecyclerView, false);
        bannerView = (BannerView) headView_banner.findViewById(R.id.home_recommended_banner);
        headView_item = LayoutInflater.from(getActivity()).inflate(R.layout.layout_head_bangumi_item, mRecyclerView, false);
        converBanner();


    }

    private void converBanner()
    {

        if (banners != null && banners.size() > 0)
        {
            int size = banners.size();
            List<Banner> bannerList = new ArrayList<>();
            Banner banner;
            for (int i = 0; i < size; i++)
            {
                banner = new Banner();
                BangumiRecommend.BannersBean bannersBean = banners.get(i);
                banner.img = bannersBean.getImg();
                banner.link = bannersBean.getLink();
                bannerList.add(banner);
            }
            bannerView.delayTime(5).build(bannerList);
            mHeaderViewRecyclerAdapter.addHeaderView(headView_banner);
            mHeaderViewRecyclerAdapter.addHeaderView(headView_item);
        }
    }

    @Override
    public void scrollToTop()
    {

    }

    @Override
    public boolean canScrollVertically(int direction)
    {

        return false;
    }
}
