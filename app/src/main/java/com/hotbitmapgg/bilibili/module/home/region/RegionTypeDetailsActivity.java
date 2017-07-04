package com.hotbitmapgg.bilibili.module.home.region;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextPaint;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.hotbitmapgg.bilibili.adapter.pager.RegionPagerAdapter;
import com.hotbitmapgg.bilibili.base.RxBaseActivity;
import com.hotbitmapgg.bilibili.entity.region.RegionTypesInfo;
import com.hotbitmapgg.bilibili.rx.RxBus;
import com.hotbitmapgg.bilibili.utils.ConstantUtil;
import com.hotbitmapgg.bilibili.widget.NoScrollViewPager;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 分区类型详情界面
 */
public class RegionTypeDetailsActivity extends RxBaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.view_pager)
    NoScrollViewPager mViewPager;
    @BindView(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTab;

    private RegionTypesInfo.DataBean mDataBean;
    private List<String> titles = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_region_details;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mDataBean = mBundle.getParcelable(ConstantUtil.EXTRA_PARTITION);
        }
        initViewPager();
        initRxBus();
    }

    private void initRxBus() {
        RxBus.getInstance().toObserverable(Integer.class)
                .compose(bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::switchPager);
    }

    private void initViewPager() {
        titles.add("推荐");
        Observable.from(mDataBean.getChildren())
                .subscribe(childrenBean -> titles.add(childrenBean.getName()));
        RegionPagerAdapter mAdapter = new RegionPagerAdapter(getSupportFragmentManager(), mDataBean.getTid(), titles, mDataBean.getChildren());
        mViewPager.setOffscreenPageLimit(titles.size());
        mViewPager.setAdapter(mAdapter);
        mSlidingTab.setViewPager(mViewPager);
        //动态设置tabView的下划线宽度
        measureTabLayoutTextWidth(0);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                measureTabLayoutTextWidth(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }


    @Override
    public void initToolBar() {
        mToolbar.setTitle(mDataBean.getName());
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_region, menu);
        return true;
    }


    public void measureTabLayoutTextWidth(int position) {
        String titleName = titles.get(position);
        TextView titleView = mSlidingTab.getTitleView(position);
        TextPaint paint = titleView.getPaint();
        float v = paint.measureText(titleName);
        mSlidingTab.setIndicatorWidth(v / 3);
    }


    public static void launch(Activity activity, RegionTypesInfo.DataBean dataBean) {
        Intent mIntent = new Intent(activity, RegionTypeDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(ConstantUtil.EXTRA_PARTITION, dataBean);
        mIntent.putExtras(bundle);
        activity.startActivity(mIntent);
    }

    private void switchPager(int position) {
        switch (position) {
            case 0:
                mViewPager.setCurrentItem(1);
                break;
            case 1:
                mViewPager.setCurrentItem(2);
                break;
            case 2:
                mViewPager.setCurrentItem(3);
                break;
            case 3:
                mViewPager.setCurrentItem(4);
                break;
            case 4:
                mViewPager.setCurrentItem(5);
                break;
            case 5:
                mViewPager.setCurrentItem(6);
                break;
            case 6:
                mViewPager.setCurrentItem(7);
                break;
        }
    }
}
