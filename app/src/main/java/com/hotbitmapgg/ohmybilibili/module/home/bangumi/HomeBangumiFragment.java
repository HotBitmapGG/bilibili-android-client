package com.hotbitmapgg.ohmybilibili.module.home.bangumi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.NewBangumiSerialAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.SeasonNewBangumiAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.SecondElementBangumiAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.helper.HeaderViewRecyclerAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiRecommend;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.SeasonNewBangumi;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.NewBangumiSerial;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.SnackbarUtil;
import com.hotbitmapgg.ohmybilibili.widget.CustomEmptyView;
import com.hotbitmapgg.ohmybilibili.widget.banner.BannerEntity;
import com.hotbitmapgg.ohmybilibili.widget.banner.BannerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 首页番剧界面
 */
public class HomeBangumiFragment extends RxLazyFragment
{

    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.empty_layout)
    CustomEmptyView mCustomEmptyView;

    private List<BangumiRecommend.RecommendsBean> recommends = new ArrayList<>();

    private List<BangumiRecommend.BannersBean> banners = new ArrayList<>();

    private List<NewBangumiSerial.ListBean> newBangumiSerials = new ArrayList<>();

    private List<SeasonNewBangumi.ListBean> seasonNewBangumis = new ArrayList<>();

    private SecondElementBangumiAdapter mAdapter;

    private HeaderViewRecyclerAdapter mHeaderViewRecyclerAdapter;

    private View headView_banner;

    private View headView_item;

    private View headView_list;

    //RecycleView是否正在刷新
    private boolean mIsRefreshing = false;


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

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new SecondElementBangumiAdapter(mRecyclerView, recommends);
        mHeaderViewRecyclerAdapter = new HeaderViewRecyclerAdapter(mAdapter);
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
                getBangumiRecommends();
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {

            @Override
            public void onRefresh()
            {

                clearData();
                getBangumiRecommends();
            }
        });
    }

    private void clearData()
    {

        mIsRefreshing = true;
        banners.clear();
        recommends.clear();
        newBangumiSerials.clear();
        seasonNewBangumis.clear();
        mHeaderViewRecyclerAdapter.removeHeadView();
    }


    /**
     * 获取番剧推荐数据
     * 包含Banner和番剧推荐内容
     * 获取二次元新番
     */
    private void getBangumiRecommends()
    {


        RetrofitHelper.getBnagumiRecommendApi()
                .getBangumiRecommended()
                .compose(this.<BangumiRecommend> bindToLifecycle())
                .flatMap(new Func1<BangumiRecommend,Observable<SeasonNewBangumi>>()
                {

                    @Override
                    public Observable<SeasonNewBangumi> call(BangumiRecommend bangumiRecommend)
                    {

                        banners.addAll(bangumiRecommend.getBanners());
                        recommends.addAll(bangumiRecommend.getRecommends());
                        return RetrofitHelper.getSeasonNewBangumiApi()
                                .getSeasonNewBangumiList();
                    }
                })
                .compose(this.<SeasonNewBangumi> bindToLifecycle())
                .flatMap(new Func1<SeasonNewBangumi,Observable<NewBangumiSerial>>()
                {

                    @Override
                    public Observable<NewBangumiSerial> call(SeasonNewBangumi seasonNewBangumi)
                    {

                        seasonNewBangumis.addAll(seasonNewBangumi.getList());
                        return RetrofitHelper.getNewBangumiSerial()
                                .getNewBangumiSerialList();
                    }
                })
                .compose(this.<NewBangumiSerial> bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewBangumiSerial>()
                {

                    @Override
                    public void call(NewBangumiSerial newBangumiSerial)
                    {

                        newBangumiSerials.addAll(newBangumiSerial.getList());
                        finishTask();
                    }
                }, new Action1<Throwable>()
                {

                    @Override
                    public void call(Throwable throwable)
                    {

                        initEmptyView();
                    }
                });
    }

    private void finishTask()
    {

        mSwipeRefreshLayout.setRefreshing(false);
        mIsRefreshing = false;
        hideEmptyView();
        createHead();
        mRecyclerView.setAdapter(mHeaderViewRecyclerAdapter);
        mAdapter.notifyDataSetChanged();
    }


    private void createHead()
    {

        headView_banner = LayoutInflater.from(getActivity())
                .inflate(R.layout.layout_banner, mRecyclerView, false);
        headView_item = LayoutInflater.from(getActivity())
                .inflate(R.layout.layout_head_bangumi_item, mRecyclerView, false);
        headView_list = LayoutInflater.from(getActivity())
                .inflate(R.layout.layout_head_recommend_bangumi, mRecyclerView, false);
        //处理头部数据
        processHeadView();
    }


    private void processHeadView()
    {

        //设置Banner
        BannerView bannerView = (BannerView) headView_banner.findViewById(R.id.home_recommended_banner);
        if (banners != null && banners.size() > 0)
        {
            int size = banners.size();
            List<BannerEntity> bannerList = new ArrayList<>();
            BannerEntity banner;
            for (int i = 0; i < size; i++)
            {
                banner = new BannerEntity();
                BangumiRecommend.BannersBean bannersBean = banners.get(i);
                banner.img = bannersBean.getImg();
                banner.link = bannersBean.getLink();
                bannerList.add(banner);
            }
            bannerView.delayTime(5).build(bannerList);
            mHeaderViewRecyclerAdapter.addHeaderView(headView_banner);
        }

        //设置Item
        TextView mNewBangumiItem = (TextView) headView_item.findViewById(R.id.layout_bangumi_new);
        TextView mWeekBangumiItem = (TextView) headView_item.findViewById(R.id.layout_bangumi_week);
        TextView mIndexBangumiItem = (TextView) headView_item.findViewById(R.id.layout_bangumi_index);
        mNewBangumiItem.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                WeekDayBangumiActivity.launch(getActivity(), "三次元新番", 3);
            }
        });
        mWeekBangumiItem.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                WeekDayBangumiActivity.launch(getActivity(), "二次元新番", 2);
            }
        });
        mIndexBangumiItem.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                startActivity(new Intent(getActivity(), BangumiIndexActivity.class));
            }
        });
        TextView mAllSerial = (TextView) headView_item.findViewById(R.id.tv_all_serial);
        mAllSerial.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                startActivity(new Intent(getActivity(), NewBangumiSerialActivity.class));
            }
        });
        mHeaderViewRecyclerAdapter.addHeaderView(headView_item);

        //设置分季新番
        RecyclerView mSeasonNewBangumiList = (RecyclerView) headView_list.findViewById(R.id.head_season_list);
        mSeasonNewBangumiList.setHasFixedSize(false);
        mSeasonNewBangumiList.setNestedScrollingEnabled(false);
        mSeasonNewBangumiList.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mSeasonNewBangumiList.setAdapter(new SeasonNewBangumiAdapter(mSeasonNewBangumiList, seasonNewBangumis, false));
        //设置新番连载
        RecyclerView mHeadRecommendList = (RecyclerView) headView_list.findViewById(R.id.head_recommend_list);
        mHeadRecommendList.setHasFixedSize(false);
        mHeadRecommendList.setNestedScrollingEnabled(false);
        mHeadRecommendList.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mHeadRecommendList.setAdapter(new NewBangumiSerialAdapter(mHeadRecommendList, newBangumiSerials, false));
        mHeaderViewRecyclerAdapter.addHeaderView(headView_list);


        //设置查看更多分季新番界面
        TextView mAllNewBangumi = (TextView) headView_list.findViewById(R.id.tv_all_new_bangumi);
        mAllNewBangumi.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                startActivity(new Intent(getActivity(), SeasonNewBangumiActivity.class));
            }
        });
    }


    public void initEmptyView()
    {

        mSwipeRefreshLayout.setRefreshing(false);
        mCustomEmptyView.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
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
        mRecyclerView.setVisibility(View.VISIBLE);
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
