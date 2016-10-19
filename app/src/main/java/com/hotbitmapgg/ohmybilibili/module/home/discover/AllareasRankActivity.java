package com.hotbitmapgg.ohmybilibili.module.home.discover;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.flyco.tablayout.SlidingTabLayout;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxBaseActivity;

import butterknife.BindView;

/**
 * Created by hcc on 16/8/7 14:12
 * 100332338@qq.com
 * <p/>
 * 全区排行榜界面
 */
public class AllareasRankActivity extends RxBaseActivity
{

    @BindView(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTabLayout;

    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private String[] titles = new String[]{
            "番剧", "动画", "音乐", "舞蹈", "游戏",
            "科技", "生活", "鬼畜", "时尚", "娱乐", "电影", "电视剧"
    };

    private String[] types = new String[]{
            "all-03-13.json", "all-03-1.json", "all-03-3.json",
            "all-03-129.json", "all-03-4.json", "all-03-36.json",
            "all-03-160.json", "all-03-155.json", "all-03-5.json",
            "all-03-119.json", "all-03-23.json", "all-03-11.json"
    };

    @Override
    public int getLayoutId()
    {

        return R.layout.activity_all_areas_rank;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        AllareasRankPagerAdapter mAdapter =
                new AllareasRankPagerAdapter(getSupportFragmentManager(), titles, types);
        mViewPager.setAdapter(mAdapter);
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setTitle("全区排行榜");
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        getMenuInflater().inflate(R.menu.menu_rank, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }


    private static class AllareasRankPagerAdapter extends FragmentStatePagerAdapter
    {

        private String[] titles;

        private String[] types;

        AllareasRankPagerAdapter(FragmentManager fm, String[] titles, String[] types)
        {

            super(fm);
            this.titles = titles;
            this.types = types;
        }

        @Override
        public Fragment getItem(int position)
        {

            return AllareasRankFragment
                    .newInstance(types[position]);
        }

        @Override
        public int getCount()
        {

            return types.length;
        }

        @Override
        public CharSequence getPageTitle(int position)
        {

            return titles[position];
        }
    }
}
