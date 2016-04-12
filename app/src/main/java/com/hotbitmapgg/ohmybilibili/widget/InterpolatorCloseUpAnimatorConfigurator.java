package com.hotbitmapgg.ohmybilibili.widget;

import android.animation.ObjectAnimator;
import android.view.animation.Interpolator;

/**
 * Created by Dimitry Ivanov on 23.05.2015.
 */
public class InterpolatorCloseUpAnimatorConfigurator implements CloseUpAnimatorConfigurator
{

	private final Interpolator mInterpolator;

	public InterpolatorCloseUpAnimatorConfigurator(Interpolator interpolator)
	{
		this.mInterpolator = interpolator;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void configure(ObjectAnimator animator)
	{
		animator.setInterpolator(mInterpolator);
	}
}
