package com.hotbitmapgg.ohmybilibili.widget.recycle;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * RecycleView嵌套重写列表展示
 *
 * @HotBitmapGG
 */
public class WrappingLinearLayoutManager extends LinearLayoutManager
{

    public WrappingLinearLayoutManager(Context context)
    {

        super(context);
    }

    private int[] mMeasuredDimension = new int[2];

    @Override
    public boolean canScrollVertically()
    {

        return false;
    }

    @Override
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec)
    {

        final int widthMode = View.MeasureSpec.getMode(widthSpec);
        final int heightMode = View.MeasureSpec.getMode(heightSpec);

        final int widthSize = View.MeasureSpec.getSize(widthSpec);
        final int heightSize = View.MeasureSpec.getSize(heightSpec);

        int width = 0;
        int height = 0;
        for (int i = 0; i < getItemCount(); i++)
        {
            if (getOrientation() == HORIZONTAL)
            {
                measureScrapChild(recycler, i,
                        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                        heightSpec,
                        mMeasuredDimension);

                width = width + mMeasuredDimension[0];
                if (i == 0)
                {
                    height = mMeasuredDimension[1];
                }
            } else
            {
                measureScrapChild(recycler, i,
                        widthSpec,
                        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                        mMeasuredDimension);

                height = height + mMeasuredDimension[1];
                if (i == 0)
                {
                    width = mMeasuredDimension[0];
                }
            }
        }

        switch (widthMode)
        {
            case View.MeasureSpec.EXACTLY:
                width = widthSize;
            case View.MeasureSpec.AT_MOST:
            case View.MeasureSpec.UNSPECIFIED:
        }

        switch (heightMode)
        {
            case View.MeasureSpec.EXACTLY:
                height = heightSize;
            case View.MeasureSpec.AT_MOST:
            case View.MeasureSpec.UNSPECIFIED:
        }

        setMeasuredDimension(width, height);
    }

    private void measureScrapChild(RecyclerView.Recycler recycler, int position, int widthSpec, int heightSpec, int[] measuredDimension)
    {

        View view = recycler.getViewForPosition(position);
        if (view.getVisibility() == View.GONE)
        {
            measuredDimension[0] = 0;
            measuredDimension[1] = 0;
            return;
        }
        // For adding Item Decor Insets to view
        super.measureChildWithMargins(view, 0, 0);
        RecyclerView.LayoutParams p = (RecyclerView.LayoutParams) view.getLayoutParams();
        int childWidthSpec = ViewGroup.getChildMeasureSpec(
                widthSpec,
                getPaddingLeft() + getPaddingRight() + getDecoratedLeft(view) + getDecoratedRight(view),
                p.width);
        int childHeightSpec = ViewGroup.getChildMeasureSpec(
                heightSpec,
                getPaddingTop() + getPaddingBottom() + getDecoratedTop(view) + getDecoratedBottom(view),
                p.height);
        view.measure(childWidthSpec, childHeightSpec);

        // Get decorated measurements
        measuredDimension[0] = getDecoratedMeasuredWidth(view) + p.leftMargin + p.rightMargin;
        measuredDimension[1] = getDecoratedMeasuredHeight(view) + p.bottomMargin + p.topMargin;
        recycler.recycleView(view);
    }
}
