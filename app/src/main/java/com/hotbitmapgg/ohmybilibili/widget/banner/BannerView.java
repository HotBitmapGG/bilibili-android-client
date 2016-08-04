package com.hotbitmapgg.ohmybilibili.widget.banner;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.model.live.Banner;
import com.hotbitmapgg.ohmybilibili.utils.DisplayUtil;
import com.squareup.picasso.Picasso;

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

public class BannerView extends RelativeLayout
{

    @Bind(R.id.widget_banner_viewpager)
    ViewPager viewPager;

    @Bind(R.id.widget_banner_points_group)
    LinearLayout points;

    private CompositeSubscription compositeSubscription;

    private int delayTime = 10;     //默认轮播时间，10s

    private List<ImageView> imageViewList;

    private BannerAdapter bannerAdapter;

    private Context context;

    private List<Banner> bannerList;

    private int selectRes = R.color.white;      //选中显示Indicator

    private int unSelcetRes = R.color.black_alpha;    //非选中显示Indicator

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
        LayoutInflater.from(context).inflate(R.layout.widget_banner_layout, this, true);
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
    public void build(List<Banner> list)
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
                    DisplayUtil.dip2px(context, 10),
                    DisplayUtil.dip2px(context, 10));
            params.leftMargin = 10;
            dot.setLayoutParams(params);
            dot.setEnabled(false);
            points.addView(dot);
        }

        points.getChildAt(0).setBackgroundResource(selectRes);

        for (int i = 0; i < bannerList.size(); i++)
        {
            ImageView hImageView = new ImageView(context);
            Picasso.with(context).load(bannerList.get(i).img).into(hImageView);
            //hImageView.setUrl(bannerList.get(i).img);
            imageViewList.add(hImageView);
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
        Log.d("start Scroll", "start");
        Log.d("Subscription sub", compositeSubscription.toString());
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

                        Log.e("rxjava error", e.getCause().toString());
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
                        Log.d("banner scroll", "第" + viewPager.getCurrentItem() + "页");
                    }
                });
        compositeSubscription.add(subscription);
    }

    /**
     * 图片停止轮播
     */
    private void stopScroll()
    {

        Log.d("stop Scroll", "stop");
        isStopScroll = true;
    }

    public void destory()
    {

        if (compositeSubscription != null)
        {
            Log.d("Subscription unsub", compositeSubscription.toString());
            compositeSubscription.unsubscribe();
        }
    }
}
