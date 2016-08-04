package com.hotbitmapgg.ohmybilibili.module.bangumi;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.api.BangumiApi;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 新番推荐
 *
 * @HotBitmapGG
 */
public class BangumiTimeLineActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.bangumi_tab_pager)
    ViewPager mTabPager;

    @Bind(R.id.bangumi_sliding_tabs)
    SlidingTabLayout mSlidingTab;

    @Bind(R.id.sp_toolbar)
    Toolbar mToolbar;

    private ActionBar mActionBar;

    private List<Fragment> fragments = new ArrayList<>();

    private BangumiFragmentAdapter mAdapter;

    private String[] titles = new String[]{"一", "二", "三", "四", "五", "六", "日"};

    @Override
    public int getLayoutId()
    {

        return R.layout.activity_bangumi_timeline;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {
        initFragment();
        mAdapter = new BangumiFragmentAdapter(getSupportFragmentManager());

        mTabPager.setAdapter(mAdapter);
        mSlidingTab.setViewPager(mTabPager);
        mTabPager.setOffscreenPageLimit(2);
    }

    private void initFragment()
    {

        WeekDayBangumiFragment monDay = WeekDayBangumiFragment.newInstance(BangumiApi.WD_MON);
        WeekDayBangumiFragment tueDay = WeekDayBangumiFragment.newInstance(BangumiApi.WD_TUE);
        WeekDayBangumiFragment wedDay = WeekDayBangumiFragment.newInstance(BangumiApi.WD_WED);
        WeekDayBangumiFragment thuDay = WeekDayBangumiFragment.newInstance(BangumiApi.WD_THU);
        WeekDayBangumiFragment friDay = WeekDayBangumiFragment.newInstance(BangumiApi.WD_FRI);
        WeekDayBangumiFragment satDay = WeekDayBangumiFragment.newInstance(BangumiApi.WD_SAT);
        WeekDayBangumiFragment sunDay = WeekDayBangumiFragment.newInstance(BangumiApi.WD_SUN);

        fragments.add(monDay);
        fragments.add(tueDay);
        fragments.add(wedDay);
        fragments.add(thuDay);
        fragments.add(friDay);
        fragments.add(satDay);
        fragments.add(sunDay);

    }

    @Override
    public void initToolBar()
    {

        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
        if (mActionBar != null)
        {
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setDisplayUseLogoEnabled(true);
            mActionBar.setDisplayShowTitleEnabled(false);
        }


        mToolbar.setNavigationIcon(R.drawable.action_button_back_pressed_light);
        mToolbar.setTitle("新番放送");
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                finish();
            }
        });
    }


    private class BangumiFragmentAdapter extends FragmentStatePagerAdapter
    {


        public BangumiFragmentAdapter(android.support.v4.app.FragmentManager fm)
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

            return titles[position];
        }
    }
}
