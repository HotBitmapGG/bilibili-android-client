package com.hotbitmapgg.ohmybilibili.module.home.partition;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextPaint;
import android.view.MenuItem;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.PartitionMorePagerAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.entity.partition.PartitionMoreTitle;
import com.hotbitmapgg.ohmybilibili.entity.partition.PartitionMoreType;

import java.util.List;

import butterknife.Bind;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 分区详情界面
 */
public class PartitionMoreActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    @Bind(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTab;

    private PartitionMorePagerAdapter mAdapter;

    private List<PartitionMoreType> titles;

    private String typeTitle;

    private static final String EXTRA_TITLES = "titles";

    private static final String EXTRA_TYPE_TITLE = "typeTitle";


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_partition_more;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        Bundle mBundle = getIntent().getExtras();
        PartitionMoreTitle mPartitionMoreTitle = mBundle.getParcelable(EXTRA_TITLES);
        if (mPartitionMoreTitle != null)
            titles = mPartitionMoreTitle.titles;
        typeTitle = mBundle.getString(EXTRA_TYPE_TITLE);


        mAdapter = new PartitionMorePagerAdapter(getSupportFragmentManager(), this.titles);
        mViewPager.setAdapter(mAdapter);
        mSlidingTab.setViewPager(mViewPager);
        //动态设置tabView的下划线宽度
        measureTabLayoutTextWidth(0);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int position)
            {

                measureTabLayoutTextWidth(position);
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setTitle(typeTitle);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }


    public void measureTabLayoutTextWidth(int position)
    {

        String titleName = titles.get(position).getTitleName();
        TextView titleView = mSlidingTab.getTitleView(position);
        TextPaint paint = titleView.getPaint();
        float v = paint.measureText(titleName);
        mSlidingTab.setIndicatorWidth(v / 3);
    }

    public static void launch(Activity activity, PartitionMoreTitle titles, String typeTitle)
    {

        Intent mIntent = new Intent(activity, PartitionMoreActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_TITLES, titles);
        bundle.putString(EXTRA_TYPE_TITLE, typeTitle);
        mIntent.putExtras(bundle);
        activity.startActivity(mIntent);
    }
}
