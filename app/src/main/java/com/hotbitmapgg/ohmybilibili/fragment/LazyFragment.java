package com.hotbitmapgg.ohmybilibili.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.widget.AppBarLayout;
import com.hotbitmapgg.ohmybilibili.widget.StatusBarHeaderView;


public abstract class LazyFragment extends Fragment
{

	private View parentView;

	private FragmentActivity activity;

	private LayoutInflater inflater;

	private StatusBarHeaderView mStatusBarHeaderView;

	private AppBarLayout mAppBarLayout;

	public abstract @LayoutRes
	int getLayoutResId();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state)
	{

		this.inflater = inflater;
		parentView = inflater.inflate(getLayoutResId(), container, false);
		activity = getSupportActivity();
		try
		{
			mStatusBarHeaderView = $(R.id.status_bar_header_view);
		} catch (Exception e)
		{

		}
		try
		{
			mAppBarLayout = $(R.id.appbar_layout);
		} catch (Exception e)
		{

		}
		finishCreateView(state);
		return parentView;
	}

	public abstract void finishCreateView(Bundle state);

	@Override
	public void onResume()
	{

		super.onResume();
		if (mStatusBarHeaderView != null)
		{
			mStatusBarHeaderView.invalidate();
		}
		if (mAppBarLayout != null)
		{
			mAppBarLayout.invalidate();
		}
	}

	@Override
	public void onAttach(Activity activity)
	{

		super.onAttach(activity);
		this.activity = (FragmentActivity) activity;
	}

	@Override
	public void onDetach()
	{

		super.onDetach();
		this.activity = null;
	}

	public FragmentActivity getSupportActivity()
	{

		return (FragmentActivity) super.getActivity();
	}

	public android.app.ActionBar getSupportActionBar()
	{

		return getSupportActivity().getActionBar();
	}

	public Context getApplicationContext()
	{

		return this.activity == null ? (getActivity() == null ? null : getActivity().getApplicationContext()) : this.activity.getApplicationContext();
	}

	protected LayoutInflater getLayoutInflater()
	{

		return inflater;
	}

	protected View getParentView()
	{

		return parentView;
	}

	public <T extends View> T $(int id)
	{

		return (T) parentView.findViewById(id);
	}
}
