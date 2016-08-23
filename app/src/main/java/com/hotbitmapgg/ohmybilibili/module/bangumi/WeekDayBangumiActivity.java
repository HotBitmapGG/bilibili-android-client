package com.hotbitmapgg.ohmybilibili.module.bangumi;


import android.app.Activity;
import android.content.Intent;
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

    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    @Bind(R.id.sliding_tabs)
    SlidingTabLayout mTabLayout;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    private static final String EXTRA_TITLE = "extra_title";

    private static final String EXTRA_TYPE = "extra_type";

    private BangumiFragmentAdapter mAdapter;

    private String[] titles = new String[]{"一", "二", "三", "四", "五", "六", "日"};

    private int[] wids = new int[]{1, 2, 3, 4, 5, 6, 0};

    private String title;

    private int type;

    @Override
    public int getLayoutId()
    {

        return R.layout.activity_bangumi_timeline;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        Intent intent = getIntent();
        title = intent.getStringExtra(EXTRA_TITLE);
        type = intent.getIntExtra(EXTRA_TYPE, 0);

        mAdapter = new BangumiFragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setViewPager(mViewPager);
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setTitle(title);
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


    public static void launch(Activity activity, String title, int type)
    {

        Intent mIntent = new Intent(activity, WeekDayBangumiActivity.class);
        mIntent.putExtra(EXTRA_TITLE, title);
        mIntent.putExtra(EXTRA_TYPE, type);
        activity.startActivity(mIntent);
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

            return WeekDayBangumiFragment.newInstance(wids[position], type);
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

        @Override
        public int getItemPosition(Object object)
        {

            return POSITION_NONE;
        }
    }
}
