package com.hotbitmapgg.ohmybilibili.widget;

/**
 * This interface might be used to dynamically compute close-up animation time of a {@link ScrollableLayout}
 *
 * @see ScrollableLayout#setCloseUpIdleAnimationTime(CloseUpIdleAnimationTime)
 * @see SimpleCloseUpIdleAnimationTime
 * Created by Dimitry Ivanov on 22.05.2015.
 */
public interface CloseUpIdleAnimationTime
{

    /**
     * @param layout {@link ScrollableLayout}
     * @param nowY   current scroll y of the *layout*
     * @param endY   scroll y value to which *layout* would scroll to
     * @param maxY   current max scroll y value of the *layout*
     * @return animation duration for a close-up animation
     */
    long compute(ScrollableLayout layout, int nowY, int endY, int maxY);
}
