package com.hotbitmapgg.ohmybilibili.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentPagerAdapter;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.fragment.BaseHomeFragment;
import com.hotbitmapgg.ohmybilibili.fragment.HomeDiscoverFragment;
import com.hotbitmapgg.ohmybilibili.fragment.HomeMoreFragment;
import com.hotbitmapgg.ohmybilibili.fragment.HomeLiveFragment;
import com.hotbitmapgg.ohmybilibili.fragment.HomeListFragment;
import com.hotbitmapgg.ohmybilibili.fragment.PlaceholderFragment;
import com.hotbitmapgg.ohmybilibili.fragment.HomeRecommendFragment;

public class HomePagerAdapter extends FragmentPagerAdapter
{

    private final String[] TITLES;

    private BaseHomeFragment[] fragments;

    public HomePagerAdapter(FragmentManager fm, Context context)
    {

        super(fm);
        TITLES = context.getResources().getStringArray(R.array.sections);
        fragments = new BaseHomeFragment[TITLES.length];
    }

    @Override
    public Fragment getItem(int position)
    {

        if (fragments[position] == null)
        {
            switch (position)
            {
                case 0:
                    fragments[position] = HomeRecommendFragment.newInstance();
                    break;
                case 1:
                    fragments[position] = HomeListFragment.newInstance();
                    break;
                case 2:
                    fragments[position] = HomeLiveFragment.newIntance();
                    break;
                case 3:
                    fragments[position] = HomeMoreFragment.newInstance();
                    break;
                case 4:
                    fragments[position] = HomeDiscoverFragment.newInstance();
                    break;
                default:
                    fragments[position] = PlaceholderFragment.newInstance();
            }
        }
        return fragments[position];
    }

    @Override
    public int getCount()
    {

        return TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {

        return TITLES[position];
    }

    public void scrollToTop(int pos)
    {

        if (fragments[pos] != null)
        {
            fragments[pos].scrollToTop();
        }
    }

    public boolean canScrollVertically(int position, int direction)
    {

        return fragments[position] != null && fragments[position].canScrollVertically(direction);
    }
}
