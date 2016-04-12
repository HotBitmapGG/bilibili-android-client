package com.hotbitmapgg.ohmybilibili.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.fragment.AontherBangumiFragment;
import com.hotbitmapgg.ohmybilibili.fragment.ThreeDBangumiFragment;
import com.hotbitmapgg.ohmybilibili.utils.WeekDayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/3/26.
 */
public class BangumiTimeLineActivity extends AppCompatActivity
{

    private Toolbar mToolbar;

    private ActionBar mActionBar;

    private ViewPager mTabPager;

    private SlidingTabLayout mSlidingTab;

    private List<Fragment> fragments = new ArrayList<>();

    private BangumiFragmentAdapter mAdapter;

    private String[] titles = new String[]{"二次元新番", "三次元新番"};

    private AontherBangumiFragment mAontherBangumiFragment;

    private ThreeDBangumiFragment mThreeDBangumiFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangumi_timeline);

        initTitle();
        initView();
    }

    private void initView()
    {

        mTabPager = (ViewPager) findViewById(R.id.bangumi_tab_pager);
        mSlidingTab = (SlidingTabLayout) findViewById(R.id.bangumi_sliding_tabs);

        //初始化数据
        mAontherBangumiFragment = new AontherBangumiFragment();
        mThreeDBangumiFragment = new ThreeDBangumiFragment();
        fragments.add(mAontherBangumiFragment);
        fragments.add(mThreeDBangumiFragment);
        mAdapter = new BangumiFragmentAdapter(getFragmentManager());


        mTabPager.setAdapter(mAdapter);
        mSlidingTab.setViewPager(mTabPager);
        mTabPager.setOffscreenPageLimit(2);
    }

    private void initTitle()
    {

        try
        {
            mToolbar = (Toolbar) findViewById(R.id.sp_toolbar);
            setSupportActionBar(mToolbar);
        } catch (Exception e)
        {
            Log.e("setContentView", "Cannot find toolbar.");
        }
        mActionBar = getSupportActionBar();

        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setDisplayUseLogoEnabled(true);
        mActionBar.setDisplayShowTitleEnabled(false);

        mToolbar.setNavigationIcon(R.drawable.action_button_back_pressed_light);
        String weekOfDate = WeekDayUtils.getWeekOfDate(null);
        mToolbar.setTitle(weekOfDate + "更新");
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


    private class BangumiFragmentAdapter extends FragmentPagerAdapter
    {

        public BangumiFragmentAdapter(FragmentManager fm)
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
