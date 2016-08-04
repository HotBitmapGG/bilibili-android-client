package com.hotbitmapgg.ohmybilibili.module.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.module.home.HomeActivity;
import com.hotbitmapgg.ohmybilibili.utils.PreferenceUtils;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 欢迎页
 *
 * @HotBitmapGG
 */
public class SplashActivity extends Activity
{

    /**
     * 随机切换欢迎页图片资源
     * , R.drawable.ic_splash_happybirthday  R.drawable.ic_splash_default_smail ,
     */

    @Bind(R.id.splash_iv)
    ImageView mSplashImage;


    private static final int[] SPLASH_PIC = new int[]{R.drawable.ic_splash_default};

    private static final int GO_HOME = 100;

    private static final int GO_LOGIN = 200;


    // 动画执行时间
    private static final int ANIMATION_DURATION = 2000;

    // 缩放动画的结束值
    private static final float SCALE_END = 1.13F;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        //Random random = new Random(SystemClock.elapsedRealtime());
        //mSplashImage.setImageResource(SPLASH_PIC[random.nextInt(SPLASH_PIC.length)]);
    }


    /**
     * 执行欢迎页加载动画
     */
    private void animateImage(final int flag)
    {

        ObjectAnimator animatorX = ObjectAnimator.ofFloat(mSplashImage, "scaleX", 1f, SCALE_END);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(mSplashImage, "scaleY", 1f, SCALE_END);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(ANIMATION_DURATION).play(animatorX).with(animatorY);
        set.start();

        set.addListener(new AnimatorListenerAdapter()
        {

            @Override
            public void onAnimationEnd(Animator animation)
            {

                if (flag == 0)
                {
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                    finish();
                } else
                {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }
            }
        });
    }

    @Override
    protected void onResume()
    {
        // TODO Auto-generated method stub
        super.onResume();
        boolean login = PreferenceUtils.getBoolean("login", false);
        if (login)
        {
            mHandler.sendEmptyMessageDelayed(GO_HOME, 1000);
        } else
        {
            mHandler.sendEmptyMessageDelayed(GO_LOGIN, 1000);
        }
    }


    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler()
    {

        @Override
        public void handleMessage(Message msg)
        {

            switch (msg.what)
            {
                case GO_HOME:
                    animateImage(0);
                    break;
                case GO_LOGIN:
                    animateImage(1);
                    break;
            }
        }
    };


    @Override
    protected void onDestroy()
    {

        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}
