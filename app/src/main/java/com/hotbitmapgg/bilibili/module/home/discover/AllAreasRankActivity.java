package com.hotbitmapgg.bilibili.module.home.discover;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.flyco.tablayout.SlidingTabLayout;
import com.hotbitmapgg.bilibili.base.RxBaseActivity;
import com.hotbitmapgg.bilibili.utils.ConstantUtil;
import com.hotbitmapgg.bilibili.widget.NoScrollViewPager;
import com.hotbitmapgg.ohmybilibili.R;

import butterknife.BindView;

/**
 * Created by hcc on 16/8/7 14:12
 * 100332338@qq.com
 * <p/>
 * 全区排行榜界面
 */
public class AllAreasRankActivity extends RxBaseActivity {
    @BindView(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTabLayout;
    @BindView(R.id.view_pager)
    NoScrollViewPager mViewPager;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private int position;
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
    public int getLayoutId() {
        return R.layout.activity_all_areas_rank;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        Intent intent = getIntent();
        if (intent != null) {
            position = intent.getIntExtra(ConstantUtil.EXTRA_POSITION, 0);
        }
        AllAreasRankPagerAdapter mAdapter = new AllAreasRankPagerAdapter(getSupportFragmentManager(), titles, types);
        mViewPager.setAdapter(mAdapter);
        mSlidingTabLayout.setViewPager(mViewPager);
        switchPager();
    }


    private void switchPager() {
        switch (position) {
            case 0:
                mViewPager.setCurrentItem(0);
                break;
            case 1:
                mViewPager.setCurrentItem(1);
                break;
            case 2:
                mViewPager.setCurrentItem(2);
                break;
            case 3:
                mViewPager.setCurrentItem(3);
                break;
            case 4:
                mViewPager.setCurrentItem(4);
                break;
            case 5:
                mViewPager.setCurrentItem(5);
                break;
            case 6:
                mViewPager.setCurrentItem(6);
                break;
            case 7:
                mViewPager.setCurrentItem(7);
                break;
            case 8:
                mViewPager.setCurrentItem(8);
                break;
            case 9:
                mViewPager.setCurrentItem(9);
                break;
            case 10:
                mViewPager.setCurrentItem(10);
                break;
            case 11:
                mViewPager.setCurrentItem(11);
                break;
        }
    }


    @Override
    public void initToolBar() {
        mToolbar.setTitle("全区排行榜");
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_rank, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


    public static void launch(Activity activity, int position) {
        Intent intent = new Intent(activity, AllAreasRankActivity.class);
        intent.putExtra(ConstantUtil.EXTRA_POSITION, position);
        activity.startActivity(intent);
    }


    private static class AllAreasRankPagerAdapter extends FragmentStatePagerAdapter {
        private String[] titles;
        private String[] types;

        AllAreasRankPagerAdapter(FragmentManager fm, String[] titles, String[] types) {
            super(fm);
            this.titles = titles;
            this.types = types;
        }

        @Override
        public Fragment getItem(int position) {
            return AllAreasRankFragment.newInstance(types[position]);
        }

        @Override
        public int getCount() {
            return types.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
