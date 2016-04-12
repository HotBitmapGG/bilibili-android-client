package com.hotbitmapgg.ohmybilibili.widget;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;

import java.util.ArrayList;

public class ObservableScrollView extends NestedScrollView
{

	private ArrayList<OnScrollChangeListener> listeners = new ArrayList<>();

	public ObservableScrollView(Context context)
	{
		super(context);
	}

	public ObservableScrollView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public ObservableScrollView(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
	}

	public void addOnScrollChangeListener(OnScrollChangeListener listener)
	{
		this.listeners.add(listener);
	}

	public boolean removeOnScrollChangeListener(OnScrollChangeListener listener)
	{
		return this.listeners.remove(listener);
	}

	@Override
	protected void onScrollChanged(int x, int y, int oldx, int oldy)
	{
		super.onScrollChanged(x, y, oldx, oldy);
		for (OnScrollChangeListener listener : listeners)
		{
			listener.onScrollChanged(this, x, y, oldx, oldy);
		}
	}

	public interface OnScrollChangeListener
	{

		void onScrollChanged(ObservableScrollView view, int x, int y, int oldx, int oldy);

	}

}