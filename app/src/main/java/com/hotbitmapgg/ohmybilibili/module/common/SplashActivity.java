package com.hotbitmapgg.ohmybilibili.module.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.utils.ConstantUtils;
import com.hotbitmapgg.ohmybilibili.utils.PreferenceUtils;

import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;

import static com.hotbitmapgg.ohmybilibili.utils.ConstantUtils.GOTO_HOME;
import static com.hotbitmapgg.ohmybilibili.utils.ConstantUtils.GOTO_LOGIN;


/**
 * Created by hcc on 16/8/7 14:12
 * 100332338@qq.com
 * <p/>
 * 欢迎页
 */
public class SplashActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        setUpSplash();
    }

    private void setUpSplash()
    {

        Observable.timer(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Func1<Long,Observable<String>>()
                {

                    @Override
                    public Observable<String> call(Long aLong)
                    {

                        boolean isLogin = PreferenceUtils.getBoolean(ConstantUtils.KEY, false);
                        if (isLogin)
                            return Observable.just(ConstantUtils.GOTO_HOME);
                        else
                            return Observable.just(ConstantUtils.GOTO_LOGIN);
                    }
                })
                .subscribe(s -> {

                    if (s.equals(ConstantUtils.GOTO_HOME))
                    {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        finish();
                    } else
                    {
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                        finish();
                    }
                });
    }
}
