package com.hotbitmapgg.ohmybilibili.module.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.HomePagerAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;

import butterknife.Bind;

/**
 * 主界面Fragment
 * 对应下边:
 * 主站，推荐，直播，分区，发现
 *
 * @HotBitmapGG
 */
public class HomePageFragment extends RxLazyFragment
{

    @Bind(R.id.tab_pager)
    ViewPager mTabPager;

    @Bind(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTab;

    private HomePagerAdapter mHomeAdapter;


    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_home_sprout;
    }

    @SuppressLint({"NewApi", "ClickableViewAccessibility"})
    @Override
    public void finishCreateView(Bundle state)
    {

        mHomeAdapter = new HomePagerAdapter(getChildFragmentManager(), getApplicationContext());
        mTabPager.setOffscreenPageLimit(4);
        mTabPager.setAdapter(mHomeAdapter);
        mSlidingTab.setViewPager(mTabPager);
    }


    @Override
    public void onDestroy()
    {
        // TODO Auto-generated method stub
        super.onDestroy();
    }
}
