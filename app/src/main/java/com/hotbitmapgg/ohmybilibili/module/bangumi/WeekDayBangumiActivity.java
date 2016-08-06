package com.hotbitmapgg.ohmybilibili.module.bangumi;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.flyco.tablayout.SlidingTabLayout;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;

import butterknife.Bind;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 新番放送表界面
 */
public class WeekDayBangumiActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.bangumi_tab_pager)
    ViewPager mTabPager;

    @Bind(R.id.bangumi_sliding_tabs)
    SlidingTabLayout mSlidingTab;

    @Bind(R.id.sp_toolbar)
    Toolbar mToolbar;

    private BangumiFragmentAdapter mAdapter;

    private String[] titles = new String[]{"周一", "周二", "周三", "周四", "周五", "周六", "周日"};

    private int[] wids = new int[]{1, 2, 3, 4, 5, 6, 0};

    @Override
    public int getLayoutId()
    {

        return R.layout.activity_bangumi_timeline;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        mAdapter = new BangumiFragmentAdapter(getSupportFragmentManager());
        mTabPager.setAdapter(mAdapter);
        mSlidingTab.setViewPager(mTabPager);
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setTitle("新番放送表");
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null)
        {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    private class BangumiFragmentAdapter extends FragmentStatePagerAdapter
    {


        public BangumiFragmentAdapter(FragmentManager fm)
        {

            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {

            return WeekDayBangumiFragment.newInstance(wids[position]);
        }

        @Override
        public int getCount()
        {

            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position)
        {

            return titles[position];
        }
    }
}
