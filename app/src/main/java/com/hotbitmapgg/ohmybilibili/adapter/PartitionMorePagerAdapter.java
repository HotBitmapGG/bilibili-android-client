package com.hotbitmapgg.ohmybilibili.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentPagerAdapter;

import com.hotbitmapgg.ohmybilibili.fragment.PartitionMoreSimpleListFragment;
import com.hotbitmapgg.ohmybilibili.model.PartitionMoreType;

import java.util.ArrayList;
import java.util.List;

public class PartitionMorePagerAdapter extends FragmentPagerAdapter
{

    private List<PartitionMoreType> titles;

    private List<Fragment> fragments = new ArrayList<>();

    public PartitionMorePagerAdapter(FragmentManager fm, Context context, List<PartitionMoreType> titles)
    {

        super(fm);
        this.titles = titles;
        initFragments();
    }

    private void initFragments()
    {

        for (int i = 0; i < titles.size(); i++)
        {
            fragments.add(PartitionMoreSimpleListFragment.newInstance(titles.get(i).getTitleType() + ""));
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
