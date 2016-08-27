package com.hotbitmapgg.ohmybilibili.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.hotbitmapgg.ohmybilibili.entity.partition.PartitionMoreType;
import com.hotbitmapgg.ohmybilibili.module.home.partition.PartitionListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 分区界面PagerAdapter
 */
public class PartitionMorePagerAdapter extends FragmentStatePagerAdapter
{

    private List<PartitionMoreType> titles;

    private List<Fragment> fragments = new ArrayList<>();

    public PartitionMorePagerAdapter(FragmentManager fm, List<PartitionMoreType> titles)
    {

        super(fm);
        this.titles = titles;
        initFragments();
    }

    private void initFragments()
    {

        for (int i = 0; i < titles.size(); i++)
        {
            fragments.add(PartitionListFragment.newInstance(titles.get(i).getTitleType() + ""));
        }
    }

    @Override
    public Fragment getItem(int position)
    {


        return fragments.get(position);
    }

    @Override
    public int getCount()
    {
        // TODO Auto-generated method stub
        return titles.size();
    }

    @Override
    public CharSequence getPageTitle(int position)
    {

        return titles.get(position).getTitleName();
    }
}
