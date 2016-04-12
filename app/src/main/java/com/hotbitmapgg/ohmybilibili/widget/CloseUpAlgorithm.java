package com.hotbitmapgg.ohmybilibili.widget;


/**
 * Use this interface to handle specific *close-up* logic for {@link ScrollableLayout},
 * use with {@link ScrollableLayout#setCloseUpAlgorithm(CloseUpAlgorithm)}
 *
 * @see DefaultCloseUpAlgorithm
 * Created by Dimitry Ivanov on 22.05.2015.
 */
public interface CloseUpAlgorithm
{

    /**
     * This method computes end scroll y after fling event was detected
     *
     * @param layout            {@link ScrollableLayout}
     * @param isScrollingBottom whether {@link ScrollableLayout} would scroll to top or bottom
     * @param nowY              current scroll y of the *layout*
     * @param suggestedY        scroll y that is suggested
     * @param maxY              current max scroll y of the *layout*
     * @return end scroll y value for the *layout* to animate to
     */
    int getFlingFinalY(ScrollableLayout layout, boolean isScrollingBottom, int nowY, int suggestedY, int maxY);

    /**
     * This method will be fired after scroll state of a {@link ScrollableLayout} would be considered idle
     *
     * @param layout {@link ScrollableLayout}
     * @param nowY   current scroll y of the *layout*
     * @param maxY   current max scroll y of the *layout*
     * @return end scroll y value for the *layout* to animate to
     * @see ScrollableLayout#getConsiderIdleMillis()
     * @see ScrollableLayout#setConsiderIdleMillis(long)
     */
    int getIdleFinalY(ScrollableLayout layout, int nowY, int maxY);
}
