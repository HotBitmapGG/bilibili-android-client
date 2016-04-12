package com.hotbitmapgg.ohmybilibili.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentPagerAdapter;

import com.hotbitmapgg.ohmybilibili.fragment.PartitionMoreBaseHomeFragment;
import com.hotbitmapgg.ohmybilibili.fragment.PartitionMoreSimpleListFragment;
import com.hotbitmapgg.ohmybilibili.model.PartitionMoreList;
import com.hotbitmapgg.ohmybilibili.model.PartitionMoreType;

import java.util.List;

public class PartitionMorePagerAdapter extends FragmentPagerAdapter
{
	
	private List<PartitionMoreType> titles;

	private PartitionMoreBaseHomeFragment[] fragments;

	public PartitionMorePagerAdapter(FragmentManager fm, Context context , List<PartitionMoreType> titles)
	{
		super(fm);
		this.titles = titles;
		fragments = new PartitionMoreBaseHomeFragment[titles.size()];
	}

	@Override
	public Fragment getItem(int position)
	{
		if (fragments[position] == null)
		{
			fragments[position] = PartitionMoreSimpleListFragment.newInstance();

		}
		return fragments[position];
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

	public void notifyIndexDataUpdateAll(PartitionMoreList data)
	{
		for (PartitionMoreBaseHomeFragment fragment : fragments)
		{
			if (fragment != null)
			{
				fragment.notifyIndexDataUpdate(data);
			}
		}

	}

}
