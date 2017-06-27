package com.hotbitmapgg.bilibili.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

/**
 * Created by hcc on 16/8/7 21:18
 * 100332338@qq.com
 * <p/>
 * 带弹性滑动的ScrollView
 */
public class SpringScrollView extends ScrollView {
    // 移动因子,手指移动100px,那么View就只移动50px
    private static final float MOVE_FACTOR = 0.5f;
    // 松开手指后, 界面回到正常位置需要的动画时间
    private static final int ANIM_TIME = 300;
    // 手指按下时的Y值, 用于在移动时计算移动距离,如果按下时不能上拉和下拉，会在手指移动时更新为当前手指的Y值
    private float startY;
    // ScrollView的唯一内容控件
    private View contentView;
    // 用于记录正常的布局位置
    private Rect originalRect = new Rect();
    // 是否可以继续下拉
    private boolean canPullDown = false;
    // 是否可以继续上拉
    private boolean canPullUp = false;
    // 记录是否移动了布局
    private boolean isMoved = false;

    public SpringScrollView(Context context) {
        super(context);
    }

    public SpringScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SpringScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            contentView = getChildAt(0);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (contentView == null) {
            return;
        }
        // ScrollView中的唯一子控件的位置信息, 这个位置信息在整个控件的生命周期中保持不变
        originalRect.set(contentView.getLeft(), contentView.getTop(), contentView.getRight(),
                contentView.getBottom());
    }

    /**
     * 在触摸事件中, 处理上拉和下拉的逻辑
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (contentView == null) {
            return super.dispatchTouchEvent(ev);
        }
        // 手指是否移动到了当前ScrollView控件之外
        boolean isTouchOutOfScrollView = ev.getY() >= this.getHeight() || ev.getY() <= 0;
        // 如果移动到了当前ScrollView控件之外
        if (isTouchOutOfScrollView) {
            // 如果当前contentView已经被移动, 首先把布局移到原位置, 然后消费点这个事件
            if (isMoved) {
                boundBack();
            }
            return true;
        }
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                // 判断是否可以上拉和下拉
                canPullDown = isCanPullDown();
                canPullUp = isCanPullUp();
                // 记录按下时的Y值
                startY = ev.getY();
                break;
            case MotionEvent.ACTION_UP:
                boundBack();
                break;
            case MotionEvent.ACTION_MOVE:
                // 在移动的过程中， 既没有滚动到可以上拉的程度， 也没有滚动到可以下拉的程度
                if (!canPullDown && !canPullUp) {
                    startY = ev.getY();
                    canPullDown = isCanPullDown();
                    canPullUp = isCanPullUp();
                    break;
                }
                // 计算手指移动的距离
                float nowY = ev.getY();
                int deltaY = (int) (nowY - startY);

                // 是否应该移动布局
                boolean shouldMove = (canPullDown && deltaY > 0) // 可以下拉， 并且手指向下移动
                        || (canPullUp && deltaY < 0) // 可以上拉， 并且手指向上移动
                        || (canPullUp && canPullDown); // 既可以上拉也可以下拉（这种情况出现在ScrollView包裹的控件比ScrollView还小）
                if (shouldMove) {
                    // 计算偏移量
                    int offset = (int) (deltaY * MOVE_FACTOR);
                    // 随着手指的移动而移动布局
                    contentView.layout(originalRect.left, originalRect.top + offset, originalRect.right,
                            originalRect.bottom + offset);
                    isMoved = true; // 记录移动了布局
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }


    /**
     * 将内容布局移动到原位置 可以在UP事件中调用, 也可以在其他需要的地方调用, 如手指移动到当前ScrollView外时
     */
    private void boundBack() {
        if (!isMoved) {
            return; // 如果没有移动布局， 则跳过执行
        }
        // 开启动画
        TranslateAnimation anim = new TranslateAnimation(0, 0, contentView.getTop(), originalRect.top);
        anim.setDuration(ANIM_TIME);
        contentView.startAnimation(anim);
        // 设置回到正常的布局位置
        contentView.layout(originalRect.left, originalRect.top, originalRect.right,
                originalRect.bottom);
        // 将标志位设回false
        canPullDown = false;
        canPullUp = false;
        isMoved = false;
    }


    /**
     * 判断是否滚动到顶部
     */
    private boolean isCanPullDown() {
        return getScrollY() == 0 || contentView.getHeight() < getHeight() + getScrollY();
    }


    /**
     * 判断是否滚动到底部
     */
    private boolean isCanPullUp() {
        return contentView.getHeight() <= getHeight() + getScrollY();
    }
}