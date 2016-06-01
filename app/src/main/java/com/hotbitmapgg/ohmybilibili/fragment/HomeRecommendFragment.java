package com.hotbitmapgg.ohmybilibili.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.activity.BangumiIndexActivity;
import com.hotbitmapgg.ohmybilibili.activity.BangumiTimeLineActivity;
import com.hotbitmapgg.ohmybilibili.activity.RecommendMoreActivity;
import com.hotbitmapgg.ohmybilibili.activity.VideoDetailsActivity;
import com.hotbitmapgg.ohmybilibili.adapter.BannerPagerAdapter;
import com.hotbitmapgg.ohmybilibili.api.BannerApi;
import com.hotbitmapgg.ohmybilibili.api.RecommendApi;
import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.HomeBanner;
import com.hotbitmapgg.ohmybilibili.model.RecommendList;
import com.hotbitmapgg.ohmybilibili.model.VideoItemInfo;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleIndicator;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;

import butterknife.Bind;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 首页-主站
 *
 * @HotBitmapGG
 */
@SuppressLint("ValidFragment")
public class HomeRecommendFragment extends BaseHomeFragment implements Runnable
{

    @Bind(R.id.container)
    LinearLayout mContainer;

    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgress;


    @Bind(R.id.ll_update_recommend)
    LinearLayout mUpdateLayout;

    @Bind(R.id.iv_update_recommend)
    ImageView mUpdateImg;


    @Bind(R.id.tv_update_recommend)
    TextView mUpdateText;

    @Bind(R.id.banner_pager)
    ViewPager mBannerPager;


    @Bind(R.id.pager_indicator)
    CircleIndicator mBannerIndicator;


    @Bind(R.id.refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    //番剧索引
    @Bind(R.id.bangumi_index)
    FrameLayout mBangumiIndexLayout;

    //新番剧查询
    @Bind(R.id.bangumi_timeline)
    FrameLayout mBangumiTimeLine;

    private BannerPagerAdapter mBannerAdapter;

    private int size;

    private int mBannerPosition = 0;

    private boolean mIsUserTouched = false;

    private List<CardView> cards;

    private List<CardView> ranks;

    private List<CardView> hots;

    private Timer mTimer;

    private BannerTask mTimerTask;

    private int pageNum = 1;

    private ObjectAnimator animator;

    private Random mRandom = new Random();

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler()
    {

        public void handleMessage(android.os.Message msg)
        {

            if (msg.what == 0)
            {
                getUpdateRecommend();
            }
        }

        ;
    };


    public static HomeRecommendFragment newInstance()
    {

        HomeRecommendFragment fragment = new HomeRecommendFragment();
        return fragment;
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_tab_recommend;
    }

    @Override
    public void finishCreateView(Bundle state)
    {


        mSwipeRefreshLayout.setColorSchemeResources(R.color.top_bar_bg);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {

            @Override
            public void onRefresh()
            {

                getRecommend();
                getRank();
                getHots();
            }
        });


        mBangumiIndexLayout.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                startActivity(new Intent(getActivity(), BangumiIndexActivity.class));
            }
        });
        mBangumiTimeLine.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                startActivity(new Intent(getActivity(), BangumiTimeLineActivity.class));
            }
        });

        mBannerPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {

            @Override
            public void onPageSelected(int position)
            {

                mBannerPosition = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0)
            {
                // TODO Auto-generated method stub

            }
        });

        mBannerPager.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {

                int action = event.getAction();
                if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_MOVE)
                {
                    mIsUserTouched = true;
                } else if (action == MotionEvent.ACTION_UP)
                {
                    mIsUserTouched = false;
                }
                return false;
            }
        });

        mUpdateLayout.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                //点击换一波推荐 执行旋转动画
                updateRecommend();
            }
        });


        //最新推荐
        cards = new ArrayList<>();

        cards.add((CardView) $(R.id.card_frame_0));
        cards.add((CardView) $(R.id.card_frame_1));
        cards.add((CardView) $(R.id.card_frame_2));
        cards.add((CardView) $(R.id.card_frame_3));
        cards.add((CardView) $(R.id.card_frame_4));
        cards.add((CardView) $(R.id.card_frame_5));


        $(R.id.btn_recommend_more).setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                //首页推荐查看更多
                Intent mIntent = new Intent(getActivity(), RecommendMoreActivity.class);
                mIntent.putExtra("order", RecommendApi.ORDER_DEFAULT);
                startActivity(mIntent);
            }
        });

        //播放最多推荐
        ranks = new ArrayList<>();

        ranks.add((CardView) $(R.id.rank_card_frame_0));
        ranks.add((CardView) $(R.id.rank_card_frame_1));
        ranks.add((CardView) $(R.id.rank_card_frame_2));
        ranks.add((CardView) $(R.id.rank_card_frame_3));

        $(R.id.btn_rank_more).setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                //播放最多查看更多
                Intent mIntent = new Intent(getActivity(), RecommendMoreActivity.class);
                mIntent.putExtra("order", RecommendApi.ORDER_HOT);
                startActivity(mIntent);
            }
        });

        //热门推荐
        hots = new ArrayList<>();

        hots.add((CardView) $(R.id.hot_card_frame_0));
        hots.add((CardView) $(R.id.hot_card_frame_1));
        hots.add((CardView) $(R.id.hot_card_frame_2));
        hots.add((CardView) $(R.id.hot_card_frame_3));

        $(R.id.btn_hot_more).setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                //热门推荐查看更多
                Intent mIntent = new Intent(getActivity(), RecommendMoreActivity.class);
                mIntent.putExtra("order", RecommendApi.ORDER_COMMENT);
                startActivity(mIntent);
            }
        });


        startGetTask();
        startBannerGetTask();
    }

    protected void updateRecommend()
    {
        //文字修改
        mUpdateText.setText("嘿咻,嘿咻~");
        //执行动画
        startUpdateAnim();
        //获取一波推荐
        pageNum++;
        //延迟2s执行
        mHandler.sendEmptyMessageDelayed(0, 2000);
    }

    protected void startUpdateAnim()
    {

        animator = ObjectAnimator.ofFloat(mUpdateImg, "rotation", 0, 360);
        animator.setDuration(1000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatCount(2);
        animator.start();
    }

    protected void stoptUpdateAnim()
    {

        animator.end();
        animator = null;
        mUpdateText.setText("换一波推荐");
    }

    private void startGetTask()
    {

        mCircleProgress.setVisibility(View.VISIBLE);
        mCircleProgress.spin();
        mContainer.setVisibility(View.GONE);

        getRecommend();
        getRank();
        getHots();
    }

    private void finishGetTask()
    {

        mCircleProgress.setVisibility(View.GONE);
        mCircleProgress.stopSpinning();
        mContainer.setVisibility(View.VISIBLE);

        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void scrollToTop()
    {

    }

    @Override
    public boolean canScrollVertically(int direction)
    {

        return true;
    }


    @Override
    public void run()
    {

        if (mBannerPosition == size - 1)
        {
            mBannerPager.setCurrentItem(size - 1, false);
        } else
        {
            mBannerPager.setCurrentItem(mBannerPosition);
        }
    }

    private void startBannerGetTask()
    {

        getBanner();
    }

    public void startViewPagerRun()
    {
        //执行ViewPager进行轮播
        mTimer = new Timer();
        mTimerTask = new BannerTask();
        mTimer.schedule(mTimerTask, 10000, 10000);
    }


    public void getBanner()
    {

        Single<BasicMessage<ArrayList<HomeBanner>>> single = Single.fromCallable(new Callable<BasicMessage<ArrayList<HomeBanner>>>()
        {

            @Override
            public BasicMessage<ArrayList<HomeBanner>> call() throws Exception
            {

                return BannerApi.getBanner();
            }
        });

        Subscription subscribe = single.map(new Func1<BasicMessage<ArrayList<HomeBanner>>,ArrayList<HomeBanner>>()
        {

            @Override
            public ArrayList<HomeBanner> call(BasicMessage<ArrayList<HomeBanner>> arrayListBasicMessage)
            {

                return arrayListBasicMessage.getObject();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<ArrayList<HomeBanner>>()
                {

                    @Override
                    public void onSuccess(ArrayList<HomeBanner> value)
                    {

                        if (value != null && value.size() > 0)
                        {
                            mBannerIndicator.setVisibility(View.VISIBLE);
                            size = value.size();
                            mBannerAdapter = new BannerPagerAdapter(getChildFragmentManager(), value);
                            mBannerPager.setAdapter(mBannerAdapter);
                            mBannerIndicator.setViewPager(mBannerPager);

                            startViewPagerRun();
                        }
                    }

                    @Override
                    public void onError(Throwable error)
                    {

                        LogUtil.lsw("HomeBannder数据加载失败");
                    }
                });

        compositeSubscription.add(subscribe);
    }


    public void getUpdateRecommend()
    {

        Single<BasicMessage<RecommendList>> single = Single.fromCallable(new Callable<BasicMessage<RecommendList>>()
        {

            @Override
            public BasicMessage<RecommendList> call() throws Exception
            {

                return RecommendApi.getList(null, pageNum + "", "6", RecommendApi.ORDER_DEFAULT);
            }
        });

        Subscription subscribe = single.map(new Func1<BasicMessage<RecommendList>,RecommendList>()
        {

            @Override
            public RecommendList call(BasicMessage<RecommendList> recommendListBasicMessage)
            {

                return recommendListBasicMessage.getObject();
            }
        })
                .map(new Func1<RecommendList,List<VideoItemInfo>>()
                {

                    @Override
                    public List<VideoItemInfo> call(RecommendList recommendList)
                    {

                        return recommendList.lists;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<List<VideoItemInfo>>()
                {

                    @Override
                    public void onSuccess(List<VideoItemInfo> value)
                    {

                        if (value != null && value.size() > 0)
                        {
                            for (int i = 0; i < 6; i++)
                            {

                                cards.get(i).addView(createVideoCard(value.get(i)));
                            }

                            stoptUpdateAnim();
                        }
                    }

                    @Override
                    public void onError(Throwable error)
                    {

                        LogUtil.lsw("最新推荐数据加载失败");
                    }
                });

        compositeSubscription.add(subscribe);
    }


    public void getRecommend()
    {

        Single<BasicMessage<RecommendList>> single = Single.fromCallable(new Callable<BasicMessage<RecommendList>>()
        {

            @Override
            public BasicMessage<RecommendList> call() throws Exception
            {

                return RecommendApi.getList(null, pageNum + "", "6", RecommendApi.ORDER_DEFAULT);
            }
        });

        Subscription subscribe = single.map(new Func1<BasicMessage<RecommendList>,RecommendList>()
        {

            @Override
            public RecommendList call(BasicMessage<RecommendList> recommendListBasicMessage)
            {

                return recommendListBasicMessage.getObject();
            }
        })
                .map(new Func1<RecommendList,List<VideoItemInfo>>()
                {

                    @Override
                    public List<VideoItemInfo> call(RecommendList recommendList)
                    {

                        return recommendList.lists;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<List<VideoItemInfo>>()
                {

                    @Override
                    public void onSuccess(List<VideoItemInfo> value)
                    {

                        if (value != null && value.size() > 0)
                        {
                            for (int i = 0; i < 6; i++)
                            {

                                cards.get(i).addView(createVideoCard(value.get(i)));
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable error)
                    {

                        LogUtil.lsw("最新推荐数据加载失败");
                    }
                });

        compositeSubscription.add(subscribe);
    }


    public void getRank()
    {

        Single<BasicMessage<RecommendList>> single = Single.fromCallable(new Callable<BasicMessage<RecommendList>>()
        {

            @Override
            public BasicMessage<RecommendList> call() throws Exception
            {

                int nextInt = mRandom.nextInt(100);

                return RecommendApi.getList(null, nextInt + "", "4", RecommendApi.ORDER_HOT);
            }
        });

        Subscription subscribe = single.map(new Func1<BasicMessage<RecommendList>,RecommendList>()
        {

            @Override
            public RecommendList call(BasicMessage<RecommendList> recommendListBasicMessage)
            {

                return recommendListBasicMessage.getObject();
            }
        })
                .map(new Func1<RecommendList,List<VideoItemInfo>>()
                {

                    @Override
                    public List<VideoItemInfo> call(RecommendList recommendList)
                    {

                        return recommendList.lists;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<List<VideoItemInfo>>()
                {

                    @Override
                    public void onSuccess(List<VideoItemInfo> value)
                    {

                        if (value != null && value.size() > 0)
                        {
                            for (int i = 0; i < 4; i++)
                            {

                                ranks.get(i).addView(createVideoCard(value.get(i)));
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable error)
                    {

                        LogUtil.lsw("热门数据加载失败");
                    }
                });

        compositeSubscription.add(subscribe);
    }


    public void getHots()
    {

        Single<BasicMessage<RecommendList>> single = Single.fromCallable(new Callable<BasicMessage<RecommendList>>()
        {

            @Override
            public BasicMessage<RecommendList> call() throws Exception
            {

                int nextInt = mRandom.nextInt(100);

                return RecommendApi.getList(null, nextInt + "", "4", RecommendApi.ORDER_COMMENT);
            }
        });

        Subscription subscribe = single.map(new Func1<BasicMessage<RecommendList>,RecommendList>()
        {

            @Override
            public RecommendList call(BasicMessage<RecommendList> recommendListBasicMessage)
            {

                return recommendListBasicMessage.getObject();
            }
        })
                .map(new Func1<RecommendList,List<VideoItemInfo>>()
                {

                    @Override
                    public List<VideoItemInfo> call(RecommendList recommendList)
                    {

                        return recommendList.lists;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<List<VideoItemInfo>>()
                {

                    @Override
                    public void onSuccess(List<VideoItemInfo> value)
                    {

                        if (value != null && value.size() > 0)
                        {
                            for (int i = 0; i < 4; i++)
                            {

                                hots.get(i).addView(createVideoCard(value.get(i)));
                            }

                            finishGetTask();
                        }
                    }

                    @Override
                    public void onError(Throwable error)
                    {

                        LogUtil.lsw("热门数据加载失败");
                    }
                });

        compositeSubscription.add(subscribe);
    }


    @SuppressLint("InflateParams")
    private CardView createVideoCard(VideoItemInfo info)
    {

        CardView view = (CardView) getLayoutInflater().inflate(R.layout.card_item_home_common, null);

        TextView mTitle = (TextView) view.findViewById(R.id.video_title);
        TextView mPlayNum = (TextView) view.findViewById(R.id.video_play_num);
        TextView mReviewNum = (TextView) view.findViewById(R.id.video_review_count);
        mTitle.setText(info.title);
        Picasso.with(getApplicationContext()).load(info.pic).placeholder(R.drawable.bili_default_image_tv).error(R.drawable.bili_default_image_tv).into((ImageView) view.findViewById(R.id.video_preview));
        mPlayNum.setText(info.play);
        mReviewNum.setText(info.video_review + "");

        view.setTag(info);
        view.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {

                if (view.getTag() instanceof VideoItemInfo)
                {
                    VideoItemInfo info = (VideoItemInfo) view.getTag();
                    VideoDetailsActivity.launch(getSupportActivity(), info);
                }
            }
        });

        return view;
    }


    @Override
    public void onDestroy()
    {
        // TODO Auto-generated method stub
        super.onDestroy();

        if (mTimer != null)
        {
            mTimer.cancel();
            mTimer = null;
        }
        if (mTimerTask != null)
        {
            mTimerTask.cancel();
            mTimerTask = null;
        }
    }

    private class BannerTask extends TimerTask
    {

        @Override
        public void run()
        {

            if (!mIsUserTouched)
            {
                mBannerPosition = (mBannerPosition + 1) % size;
                if (getActivity() != null)
                {
                    getActivity().runOnUiThread(HomeRecommendFragment.this);
                }
            }
        }
    }
}
