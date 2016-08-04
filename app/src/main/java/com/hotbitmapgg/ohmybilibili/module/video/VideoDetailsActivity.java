package com.hotbitmapgg.ohmybilibili.module.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import com.flyco.tablayout.SlidingTabLayout;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.api.VideoApi;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.model.base.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.video.VideoItemInfo;
import com.hotbitmapgg.ohmybilibili.model.video.VideoViewInfo;
import com.hotbitmapgg.ohmybilibili.network.UrlHelper;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import butterknife.Bind;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 视频详情界面
 *
 * @HotBitmapGG
 */
public class VideoDetailsActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Bind(R.id.main_content)
    CoordinatorLayout mCoordinatorLayout;

    @Bind(R.id.video_preview)
    ImageView mVideoPreview;

    @Bind(R.id.tab_layout)
    SlidingTabLayout mSlidingTabLayout;

    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    @Bind(R.id.fab)
    FloatingActionButton mFAB;

    @Bind(R.id.app_bar_layout)
    AppBarLayout mAppBarLayout;

    private List<Fragment> fragments = new ArrayList<>();

    private List<String> titles = new ArrayList<>();

    private static String EXTRA_ITEM_INFO = "extra_item_info", EXTRA_AV = "extra_av";

    private VideoItemInfo itemInfo;

    private int av;

    private VideoViewInfo viewInfo;

    private VideoDetailsPagerAdapter mAdapter;


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_video_details;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ITEM_INFO))
        {
            itemInfo = VideoItemInfo.createFromJson(intent.getStringExtra(EXTRA_ITEM_INFO));
        } else if (intent.hasExtra(EXTRA_AV))
        {
            av = intent.getIntExtra(EXTRA_AV, -1);
        }

        getVideoInfo();


        mFAB.setTranslationY(-getResources().getDimension(R.dimen.floating_action_button_size_half));
        mFAB.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                Intent mIntent = new Intent(VideoDetailsActivity.this, BiliBiliPlayerVideoActivity.class);
                if (itemInfo != null)
                {
                    int aid = itemInfo.aid;
                    mIntent.putExtra("av", aid + "");
                } else
                {
                    mIntent.putExtra("av", av + "");
                }

                mIntent.putExtra("page", "1");
                startActivity(mIntent);
            }
        });

        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener()
        {

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset)
            {

                setViewsTranslation(verticalOffset);
            }
        });


        if (itemInfo != null)
        {
            Picasso.with(this).load(UrlHelper.getClearVideoPreviewUrl(itemInfo.pic)).into(mVideoPreview);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void initToolBar()
    {

        mToolbar.setNavigationIcon(R.drawable.action_button_back_pressed_light);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                finish();
            }
        });
        //设置还没收缩时状态下字体颜色
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);
        //设置收缩后Toolbar上字体的颜色
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);

        assert mCoordinatorLayout != null;
        mCoordinatorLayout.setOnScrollChangeListener(new CoordinatorLayout.OnScrollChangeListener()
        {

            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY)
            {

                setViewsTranslation(scrollY);
            }
        });
    }


    private void setViewsTranslation(int target)
    {

        mFAB.setTranslationY(target);
        if (target == 0)
        {
            showFAB();
        } else if (target < 0)
        {
            hideFAB();
        }
    }

    public static void launch(Activity activity, VideoItemInfo itemInfo)
    {

        Intent intent = new Intent(activity, VideoDetailsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(EXTRA_ITEM_INFO, itemInfo.toJsonString());
        activity.startActivity(intent);
    }

    public static void launch(Activity activity, int aid)
    {

        Intent intent = new Intent(activity, VideoDetailsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(EXTRA_AV, aid);
        activity.startActivity(intent);
    }

    private void showFAB()
    {

        mFAB.animate().scaleX(1f).scaleY(1f).setInterpolator(new OvershootInterpolator()).start();
    }

    private void hideFAB()
    {

        mFAB.animate().scaleX(0f).scaleY(0f).setInterpolator(new AccelerateInterpolator()).start();
    }



    public void getVideoInfo()
    {

        Single<BasicMessage<VideoViewInfo>> single = Single.fromCallable(new Callable<BasicMessage<VideoViewInfo>>()
        {

            @Override
            public BasicMessage<VideoViewInfo> call() throws Exception
            {

                return VideoApi.getVideoViewInfo(itemInfo != null ? itemInfo.aid : av, 0, false);
            }
        });


        Subscription subscribe = single.map(new Func1<BasicMessage<VideoViewInfo>,VideoViewInfo>()
        {

            @Override
            public VideoViewInfo call(BasicMessage<VideoViewInfo> videoViewInfoBasicMessage)
            {

                return videoViewInfoBasicMessage.getObject();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<VideoViewInfo>()
                {

                    @Override
                    public void onSuccess(VideoViewInfo value)
                    {

                        viewInfo = value;
                        finishGetTask();
                    }

                    @Override
                    public void onError(Throwable error)
                    {

                        LogUtil.lsw("视频详情数据加载失败");
                    }
                });

        compositeSubscription.add(subscribe);
    }

    private void finishGetTask()
    {

        mCollapsingToolbarLayout.setTitle(viewInfo.title);
        Picasso.with(this).load(UrlHelper.getClearVideoPreviewUrl(viewInfo.pic)).into(mVideoPreview);

        VideoInfoFragment mVideoInfoFragment = VideoInfoFragment.newInstance(viewInfo, itemInfo != null ? itemInfo.aid : av);
        VideoCommentFragment mVideoCommentFragment = VideoCommentFragment.newInstance(itemInfo != null ? itemInfo.aid : av);

        fragments.add(mVideoInfoFragment);
        fragments.add(mVideoCommentFragment);

        setPagerTitle(viewInfo.review);
    }

    private void setPagerTitle(int num)
    {

        titles.add("简介");
        titles.add("评论" + "(" + num + ")");

        mAdapter = new VideoDetailsPagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(2);
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    public class VideoDetailsPagerAdapter extends FragmentPagerAdapter
    {

        public VideoDetailsPagerAdapter(android.support.v4.app.FragmentManager fm)
        {

            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {

            return fragments.get(position);
        }

        @Override
        public int getCount()
        {

            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position)
        {

            return titles.get(position);
        }
    }
}
