package com.hotbitmapgg.ohmybilibili.module.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.ConstantUtil;
import com.hotbitmapgg.ohmybilibili.utils.PreferenceUtil;
import com.trello.rxlifecycle.components.RxActivity;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Created by hcc on 16/8/7 14:12
 * 100332338@qq.com
 * <p/>
 * 启动页界面
 */
public class SplashActivity extends RxActivity
{

    @BindView(R.id.splash_iv)
    ImageView mSplashImage;

    @BindView(R.id.splash_logo)
    ImageView mSplashLogo;

    @BindView(R.id.splash_default_iv)
    ImageView mSplashDefaultIv;

    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        bind = ButterKnife.bind(this);
        hideStatusBar(true);
    }


    @Override
    protected void onResume()
    {

        super.onResume();
        setUpSplash();
    }

    private void setUpSplash()
    {

        RetrofitHelper.getSplashApi()
                .getSplashImage()
                .compose(bindToLifecycle())
                .map(splashInfo -> splashInfo.getData().get(0).getThumbUrl())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Func1<String,Observable<Long>>()
                {

                    @Override
                    public Observable<Long> call(String s)
                    {

                        loadImageUrl(s);
                        return Observable.timer(2000, TimeUnit.MILLISECONDS);
                    }
                })
                .compose(bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {

                    finishTask();
                }, throwable -> {

                    showDefaultSplashImage();
                    Observable.timer(2, TimeUnit.SECONDS)
                            .compose(bindToLifecycle())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(aLong -> {
                                finishTask();
                            });
                });
    }

    private void showDefaultSplashImage()
    {

        mSplashLogo.setVisibility(View.VISIBLE);
        mSplashDefaultIv.setVisibility(View.VISIBLE);
        mSplashImage.setVisibility(View.GONE);
    }

    private void loadImageUrl(String s)
    {

        Glide.with(SplashActivity.this)
                .load(s)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mSplashImage);
        mSplashLogo.setVisibility(View.GONE);
        mSplashDefaultIv.setVisibility(View.GONE);
    }

    private void finishTask()
    {

        boolean isLogin = PreferenceUtil.getBoolean(ConstantUtil.KEY, false);
        if (isLogin)
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        else
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));

        SplashActivity.this.finish();
    }


    /**
     * 显示或隐藏StatusBar
     *
     * @param enable false 显示，true 隐藏
     */
    private void hideStatusBar(boolean enable)
    {

        WindowManager.LayoutParams p = this.getWindow().getAttributes();
        if (enable)
            //|=：或等于，取其一
            p.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        else
            //&=：与等于，取其二同时满足，     ~ ： 取反
            p.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getWindow().setAttributes(p);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }


    @Override
    protected void onDestroy()
    {

        super.onDestroy();
        bind.unbind();
    }
}
