package com.hotbitmapgg.bilibili.widget.livelike;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hotbitmapgg.ohmybilibili.R;

import java.util.Random;

/**
 * Created by hcc on 16/9/14 21:37
 * 100332338@qq.com
 * <p/>
 * 直播送礼物特效自定义控件
 */
public class LoveLikeLayout extends RelativeLayout {
    //线性插值器
    private Interpolator line = new LinearInterpolator();
    //加速插值器
    private Interpolator acc = new AccelerateInterpolator();
    //减速插值器
    private Interpolator dce = new DecelerateInterpolator();
    //先加速后减速插值器
    private Interpolator accdec = new AccelerateDecelerateInterpolator();
    //插值器数组
    private Interpolator[] interpolators;
    //随机数
    private Random mRandom = new Random();
    //爱心图片数组
    private Drawable[] drawables;
    //爱心图片的高度
    private int drawableHeight;
    //爱心图片的宽度
    private int drawableWidth;
    //参数值
    private LayoutParams layoutParams;
    //layout高度
    private int measuredHeight;
    //layout宽度
    private int measuredWidth;

    public LoveLikeLayout(Context context) {
        this(context, null);
    }

    public LoveLikeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoveLikeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        //初始化爱心图片
        drawables = new Drawable[7];
        Drawable one = getResources().getDrawable(R.drawable.ic_live_like_01);
        Drawable two = getResources().getDrawable(R.drawable.ic_live_like_02);
        Drawable three = getResources().getDrawable(R.drawable.ic_live_like_03);
        Drawable four = getResources().getDrawable(R.drawable.ic_live_like_04);
        Drawable five = getResources().getDrawable(R.drawable.ic_live_like_05);
        drawables[0] = one;
        drawables[1] = two;
        drawables[2] = three;
        drawables[3] = four;
        drawables[4] = five;
        //获取爱心的宽高
        drawableHeight = one.getIntrinsicHeight();
        drawableWidth = one.getIntrinsicWidth();
        //设置爱心的显示位置
        layoutParams = new LayoutParams(drawableWidth, drawableHeight);
        layoutParams.addRule(CENTER_HORIZONTAL, TRUE);
        layoutParams.addRule(ALIGN_PARENT_BOTTOM, TRUE);
        //初始化动画插值器
        interpolators = new Interpolator[4];
        interpolators[0] = line;
        interpolators[1] = acc;
        interpolators[2] = dce;
        interpolators[3] = accdec;
    }

    /**
     * 测量layout的宽高
     * 用于计算爱心的显示位置
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measuredHeight = getMeasuredHeight();
        measuredWidth = getMeasuredWidth();
    }


    /**
     * 显示爱心
     */
    public void addLove() {
        final ImageView imageView = new ImageView(getContext());
        //随机生成爱心颜色
        imageView.setImageDrawable(drawables[mRandom.nextInt(3)]);
        imageView.setLayoutParams(layoutParams);
        addView(imageView);
        Animator animtor = getAnimtor(imageView);
        animtor.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                removeView(imageView);
                super.onAnimationEnd(animation);
            }
        });
        animtor.start();
    }


    /**
     * 爱心的显示和运行轨迹动画组合实现
     */
    private Animator getAnimtor(View target) {
        AnimatorSet enterAnimtorSet = getEnterAnimtorSet(target);
        ValueAnimator bezierAnimtor = getBezierAnimtor(target);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(enterAnimtorSet);
        animatorSet.playSequentially(enterAnimtorSet, bezierAnimtor);
        animatorSet.setInterpolator(interpolators[mRandom.nextInt(4)]);
        animatorSet.setTarget(target);
        return animatorSet;
    }


    /**
     * 爱心的显示动画实现
     */
    private AnimatorSet getEnterAnimtorSet(View target) {
        //爱心的3中动画组合 透明度 x，y轴的缩放
        ObjectAnimator alpha = ObjectAnimator.ofFloat(target, View.ALPHA, 0.2f, 1f);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(target, View.SCALE_X, 0.2f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(target, View.SCALE_Y, 0.2f, 1f);
        //组合动画
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new LinearInterpolator());
        set.playTogether(alpha, scaleX, scaleY);
        set.setTarget(target);
        return set;
    }


    /**
     * 爱心运动轨迹的动画实现
     */
    private ValueAnimator getBezierAnimtor(final View target) {
        BezierEvaluator evaluator = new BezierEvaluator(getPoint(2), getPoint(1));
        ValueAnimator animator = ValueAnimator.ofObject(evaluator,
                new PointF((measuredWidth - drawableWidth) / 2, measuredHeight - drawableHeight),
                new PointF(mRandom.nextInt(getWidth()), 0));
        animator.setDuration(3000);
        animator.setTarget(target);
        animator.addUpdateListener(valueAnimator -> {
            //获取贝塞尔曲线的运动轨迹 让爱心跟随着移动
            PointF animatedValue = (PointF) valueAnimator.getAnimatedValue();
            target.setX(animatedValue.x);
            target.setY(animatedValue.y);
            //增加透明度的变化
            target.setAlpha(1 - valueAnimator.getAnimatedFraction());
        });
        return animator;
    }


    /**
     * 获取中间的两个点
     */
    private PointF getPoint(int scale) {
        PointF pointF = new PointF();
        pointF.x = mRandom.nextInt((measuredWidth - 100));
        pointF.y = mRandom.nextInt((measuredHeight - 100)) / scale;
        return pointF;
    }
}
