package com.hotbitmapgg.ohmybilibili.widget;

/**
 * Created by Dimitry Ivanov on 23.05.2015.
 */
public class SimpleCloseUpIdleAnimationTime implements CloseUpIdleAnimationTime
{

	private final long mDuration;

	public SimpleCloseUpIdleAnimationTime(long duration)
	{
		this.mDuration = duration;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long compute(ScrollableLayout layout, int nowY, int endY, int maxY)
	{
		return mDuration;
	}

	public long getDuration()
	{
		return mDuration;
	}
}
