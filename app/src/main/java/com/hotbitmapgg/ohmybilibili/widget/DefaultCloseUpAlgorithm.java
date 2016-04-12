package com.hotbitmapgg.ohmybilibili.widget;

/**
 * Default implementation of the {@link CloseUpAlgorithm} With this
 * implementation {@link ScrollableLayout} would have only two states -
 * collapsed &amp; expanded
 *
 * @see ScrollableLayout#setCloseUpAlgorithm(CloseUpAlgorithm) Created by
 * Dimitry Ivanov on 23.05.2015.
 */
public class DefaultCloseUpAlgorithm implements CloseUpAlgorithm
{

    /**
     * {@inheritDoc}
     */
    @Override
    public int getFlingFinalY(ScrollableLayout layout, boolean isScrollingBottom, int nowY, int suggestedY, int maxY)
    {

        return isScrollingBottom ? 0 : maxY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getIdleFinalY(ScrollableLayout layout, int nowY, int maxY)
    {

        final boolean shouldScrollToTop = nowY < (maxY / 2);
        return shouldScrollToTop ? 0 : maxY;
    }
}
