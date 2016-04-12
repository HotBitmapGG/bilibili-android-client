package com.hotbitmapgg.ohmybilibili.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ScrollView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.model.Index;

@SuppressLint("ValidFragment")
public class PlaceholderFragment extends BaseHomeFragment
{

	private ScrollView mScrollView;

	public static PlaceholderFragment newInstance()
	{
		PlaceholderFragment fragment = new PlaceholderFragment();
		return fragment;
	}

	@Override
	public int getLayoutResId()
	{
		return R.layout.fragment_tab_placeholder;
	}

	@Override
	public void finishCreateView(Bundle state)
	{
		mScrollView = $(R.id.scrollable);

	}

	@Override
	public void scrollToTop()
	{
		mScrollView.smoothScrollTo(mScrollView.getScrollX(), 0);
	}

	@Override
	public boolean canScrollVertically(int direction)
	{
		return mScrollView != null && mScrollView.canScrollVertically(direction);
	}

	@Override
	public void notifyIndexDataUpdate(Index data)
	{

	}

}
