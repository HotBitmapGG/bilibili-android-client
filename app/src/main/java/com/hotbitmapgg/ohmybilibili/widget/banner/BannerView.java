package com.hotbitmapgg.ohmybilibili.widget.banner;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.entity.BaseBanner;
import com.hotbitmapgg.ohmybilibili.module.common.WebActivity;
import com.hotbitmapgg.ohmybilibili.utils.DisplayUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 自定义Banner无限轮播控件
 */
public class BannerView extends RelativeLayout implements BannerAdapter.ViewPagerOnItemClickListener
{

    @Bind(R.id.layout_banner_viewpager)
    ViewPager viewPager;

    @Bind(R.id.layout_banner_points_group)
    LinearLayout points;

    private CompositeSubscription compositeSubscription;

    //默认轮播时间，10s
    private int delayTime = 10;

    private List<ImageView> imageViewList;

    private BannerAdapter bannerAdapter;

    private Context context;

    private List<BaseBanner> bannerList;

    //选中显示Indicator
    private int selectRes = R.drawable.shape_dots_select;

    //非选中显示Indicator
    private int unSelcetRes = R.drawable.shape_dots_default;

    public BannerView(Context context)
    {

        this(context, null);
    }

    public BannerView(Context context, AttributeSet attrs)
    {

        this(context, attrs, 0);
    }

    public BannerView(Context context, AttributeSet attrs, int defStyleAttr)
    {

        super(context, attrs, defStyleAttr);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.layout_custom_banner, this, true);
        ButterKnife.bind(this);

        imageViewList = new ArrayList<>();
    }

    private LinearLayout.LayoutParams params;

    /**
     * 设置轮播间隔时间
     *
     * @param time 轮播间隔时间，单位秒
     */
    public BannerView delayTime(int time)
    {

        this.delayTime = time;
        return this;
    }

    /**
     * 设置Points资源 Res
     *
     * @param selectRes   选中状态
     * @param unselcetRes 非选中状态
     */
    public void setPointsRes(int selectRes, int unselcetRes)
    {

        this.selectRes = selectRes;
        this.unSelcetRes = unselcetRes;
    }

    /**
     * 图片轮播需要传入参数
     */
    public void build(List<BaseBanner> list)
    {

        destory();

        if (list.size() == 0)
        {
            this.setVisibility(GONE);
            return;
        }

        bannerList = new ArrayList<>();
        bannerList.addAll(list);
        final int pointSize;
        pointSize = bannerList.size();

        if (pointSize == 2)
        {
            bannerList.addAll(list);
        }
        //判断是否清空 指示器点
        if (points.getChildCount() != 0)
        {
            points.removeAllViewsInLayout();
        }

        //初始化与个数相同的指示器点
        for (int i = 0; i < pointSize; i++)
        {
            View dot = new View(context);
            dot.setBackgroundResource(unSelcetRes);
            params = new LinearLayout.LayoutParams(
                    DisplayUtil.dp2px(context, 5),
                    DisplayUtil.dp2px(context, 5));
            params.leftMargin = 10;
            dot.setLayoutParams(params);
            dot.setEnabled(false);
            points.addView(dot);
        }

        points.getChildAt(0).setBackgroundResource(selectRes);

        for (int i = 0; i < bannerList.size(); i++)
        {
            ImageView mImageView = new ImageView(context);
            Glide.with(context)
                    .load(bannerList.get(i).img)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.bili_default_image_tv)
                    .into(mImageView);
            imageViewList.add(mImageView);
        }

        //监听图片轮播，改变指示器状态
        viewPager.clearOnPageChangeListeners();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int pos)
            {

                pos = pos % pointSize;
                for (int i = 0; i < points.getChildCount(); i++)
                {
                    points.getChildAt(i).setBackgroundResource(unSelcetRes);
                }
                points.getChildAt(pos).setBackgroundResource(selectRes);
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

                switch (state)
                {
                    case ViewPager.SCROLL_STATE_IDLE:
                        if (isStopScroll)
                        {
                            startScroll();
                        }
                        break;
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        stopScroll();
                        compositeSubscription.unsubscribe();
                        break;
                }
            }
        });

        bannerAdapter = new BannerAdapter(imageViewList);
        viewPager.setAdapter(bannerAdapter);
        bannerAdapter.notifyDataSetChanged();
        bannerAdapter.setmViewPagerOnItemClickListener(this);

        //图片开始轮播
        startScroll();
    }

    private boolean isStopScroll = false;

    /**
     * 图片开始轮播
     */
    private void startScroll()
    {

        compositeSubscription = new CompositeSubscription();
        isStopScroll = false;
        Subscription subscription = Observable.timer(delayTime, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>()
                {

                    @Override
                    public void onCompleted()
                    {

                    }

                    @Override
                    public void onError(Throwable e)
                    {


                    }

                    @Override
                    public void onNext(Long aLong)
                    {

                        if (isStopScroll)
                        {
                            return;
                        }
                        isStopScroll = true;
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    }
                });
        compositeSubscription.add(subscription);
    }

    /**
     * 图片停止轮播
     */
    private void stopScroll()
    {
        isStopScroll = true;
    }

    public void destory()
    {

        if (compositeSubscription != null)
        {
            compositeSubscription.unsubscribe();
        }
    }

    /**
     * 设置ViewPager的Item点击回调事件
     *
     * @param position
     */
    @Override
    public void onItemClick(int position)
    {

        if (position == 0)
        {
            position = bannerList.size() - 1;
        } else
        {
            position -= 1;
        }
        WebActivity.launch((Activity) context, bannerList.get(position).link, bannerList.get(position).title);
    }
}
