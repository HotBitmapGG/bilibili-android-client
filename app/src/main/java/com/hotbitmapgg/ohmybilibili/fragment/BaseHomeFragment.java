package com.hotbitmapgg.ohmybilibili.fragment;


import com.hotbitmapgg.ohmybilibili.model.Index;

public abstract class BaseHomeFragment extends LazyFragment
{

	public abstract void scrollToTop();

	public abstract boolean canScrollVertically(int direction);

	public abstract void notifyIndexDataUpdate(Index data);

}
