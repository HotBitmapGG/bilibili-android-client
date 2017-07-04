package com.hotbitmapgg.bilibili.adapter.pager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hotbitmapgg.bilibili.module.home.attention.HomeAttentionFragment;
import com.hotbitmapgg.bilibili.module.home.bangumi.HomeBangumiFragment;
import com.hotbitmapgg.bilibili.module.home.discover.HomeDiscoverFragment;
import com.hotbitmapgg.bilibili.module.home.live.HomeLiveFragment;
import com.hotbitmapgg.bilibili.module.home.recommend.HomeRecommendedFragment;
import com.hotbitmapgg.bilibili.module.home.region.HomeRegionFragment;
import com.hotbitmapgg.ohmybilibili.R;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 主界面Fragment模块Adapter
 */
public class HomePagerAdapter extends FragmentPagerAdapter {

  private final String[] TITLES;
  private Fragment[] fragments;

  public HomePagerAdapter(FragmentManager fm, Context context) {
    super(fm);
    TITLES = context.getResources().getStringArray(R.array.sections);
    fragments = new Fragment[TITLES.length];
  }


  @Override
  public Fragment getItem(int position) {
    if (fragments[position] == null) {
      switch (position) {
        case 0:
          fragments[position] = HomeLiveFragment.newIntance();
          break;
        case 1:
          fragments[position] = HomeRecommendedFragment.newInstance();
          break;
        case 2:
          fragments[position] = HomeBangumiFragment.newInstance();
          break;
        case 3:
          fragments[position] = HomeRegionFragment.newInstance();
          break;
        case 4:
          fragments[position] = HomeAttentionFragment.newInstance();
          break;
        case 5:
          fragments[position] = HomeDiscoverFragment.newInstance();
          break;
        default:
          break;
      }
    }
    return fragments[position];
  }


  @Override
  public int getCount() {
    return TITLES.length;
  }


  @Override
  public CharSequence getPageTitle(int position) {
    return TITLES[position];
  }
}
