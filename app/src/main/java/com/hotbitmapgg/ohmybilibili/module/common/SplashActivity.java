package com.hotbitmapgg.ohmybilibili.module.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.ConstantUtils;
import com.hotbitmapgg.ohmybilibili.utils.PreferenceUtils;
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

                    Observable.timer(2, TimeUnit.SECONDS)
                            .compose(bindToLifecycle())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(aLong -> {
                                finishTask();
                            });
                });
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

        boolean isLogin = PreferenceUtils.getBoolean(ConstantUtils.KEY, false);
        if (isLogin)
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        else
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));


        SplashActivity.this.finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    protected void onDestroy()
    {

        super.onDestroy();
        bind.unbind();
    }
}
