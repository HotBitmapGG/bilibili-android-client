package com.hotbitmapgg.ohmybilibili.widget;

import android.animation.ObjectAnimator;

/**
 * This interface might be used to customize {@link ObjectAnimator} behavior during close-up animation
 *
 * @see ObjectAnimator
 * @see InterpolatorCloseUpAnimatorConfigurator
 * Created by Dimitry Ivanov on 22.05.2015.
 */
public interface CloseUpAnimatorConfigurator
{

    /**
     * Note that {@link ObjectAnimator#setDuration(long)} would erase current value set by {@link CloseUpIdleAnimationTime} if any present
     *
     * @param animator current {@link ObjectAnimator} object to animate close-up animation of a {@link ScrollableLayout}
     */
    void configure(ObjectAnimator animator);
}
