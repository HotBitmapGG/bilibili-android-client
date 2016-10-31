package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.splash.SplashInfo;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 2016/10/31 10:34
 * 100332338@qq.com
 * <p>
 * 启动页图片请求api
 * http://app.bilibili.com/x/splash/old?platformType=1&width=1242&height=2148
 */

public interface SplashService
{

    @GET("x/splash/old?platformType=1&width=1242&height=2148")
    Observable<SplashInfo> getSplashImage();
}
