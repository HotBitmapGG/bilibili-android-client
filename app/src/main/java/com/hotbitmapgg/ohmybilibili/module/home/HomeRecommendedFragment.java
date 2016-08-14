package com.hotbitmapgg.ohmybilibili.module.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.HomeRecommendedRecyclerAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.live.Banner;
import com.hotbitmapgg.ohmybilibili.entity.recommended.Body;
import com.hotbitmapgg.ohmybilibili.entity.recommended.Recommend;
import com.hotbitmapgg.ohmybilibili.entity.recommended.Result;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.banner.BannerView;
import com.hotbitmapgg.ohmybilibili.widget.recyclerview_helper.HeaderViewRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
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

    private List<Result> results = new ArrayList<>();

    private List<Banner> banners = new ArrayList<>();

    private HeaderViewRecyclerAdapter mHeaderViewRecyclerAdapter;

    private HomeRecommendedRecyclerAdapter mAdapter;

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

        showProgressBar();
    }

    private void showProgressBar()
    {

        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.postDelayed(new Runnable()
        {

            @Override
            public void run()
            {

                mSwipeRefreshLayout.setRefreshing(true);
                getHomeRecommendedData();
            }
        }, 500);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {

            @Override
            public void onRefresh()
            {

                mSwipeRefreshLayout.setRefreshing(true);
                getHomeRecommendedData();
            }
        });
    }


    private void getHomeRecommendedData()
    {

        RetrofitHelper.getHomeRecommendedApi()
                .getRecommended()
                .compose(this.<Recommend> bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Recommend>()
                {

                    @Override
                    public void call(Recommend recommend)
                    {


                        int size = recommend.getResult().size();
                        for (int i = 0; i < size; i++)
                        {
                            Result result = recommend.getResult().get(i);
                            Banner banner;
                            if (result.getType() != null)
                            {
                                if (result.getType().equals("weblink"))
                                {
                                    ArrayList<Body> bodys = result.getBody();
                                    Body body = bodys.get(0);
                                    banner = new Banner();
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

                        finishTask();
                    }
                }, new Action1<Throwable>()
                {

                    @Override
                    public void call(Throwable throwable)
                    {

                        LogUtil.all("首页推荐界面加载失败" + throwable.getMessage());
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
        mAdapter = new HomeRecommendedRecyclerAdapter(mRecyclerView, results);
        mHeaderViewRecyclerAdapter = new HeaderViewRecyclerAdapter(mAdapter);
        createHead();
        mRecyclerView.setAdapter(mHeaderViewRecyclerAdapter);
    }

    private void createHead()
    {

        View headView = LayoutInflater.from(getActivity())
                .inflate(R.layout.layout_head_home_recommended, mRecyclerView, false);
        BannerView bannerView = (BannerView) headView.findViewById(R.id.home_recommended_banner);
        bannerView.delayTime(5).build(banners);
        mHeaderViewRecyclerAdapter.addHeaderView(headView);
    }
}
