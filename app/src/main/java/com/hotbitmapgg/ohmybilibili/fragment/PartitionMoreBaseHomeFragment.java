package com.hotbitmapgg.ohmybilibili.fragment;

import com.hotbitmapgg.ohmybilibili.model.PartitionMoreList;


public abstract class PartitionMoreBaseHomeFragment extends LazyFragment
{

	public abstract void scrollToTop();

	public abstract boolean canScrollVertically(int direction);

	public abstract void notifyIndexDataUpdate(PartitionMoreList data);

}
