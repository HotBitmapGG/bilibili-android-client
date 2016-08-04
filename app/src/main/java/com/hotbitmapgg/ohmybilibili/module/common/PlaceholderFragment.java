package com.hotbitmapgg.ohmybilibili.module.common;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ScrollView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.BaseHomeFragment;

import butterknife.Bind;

/**
 * 占位Fragment
 *
 * @HotBitmapGG
 */
@SuppressLint("ValidFragment")
public class PlaceholderFragment extends BaseHomeFragment
{

    @Bind(R.id.scrollable)
    ScrollView mScrollView;

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
}
