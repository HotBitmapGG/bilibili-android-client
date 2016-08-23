package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.recommended.RecommendInfo;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 16/8/4 12:03
 * 100332338@qq.com
 * <p/>
 * 首页推荐模块数据请求
 * http://app.bilibili.com/x/show/old?appkey=1d8b6e7d45233436&
 * build=422000&channel=xiaomi&mobi_app=android&platform=android&
 * screen=xxhdpi&ts=1469672526000&sign=8adc1eb85b3ad24700867b3dc9702655
 */
public interface RecommendedService
{

    @GET("x/show/old?platform=android&device=&build=412001")
    Observable<RecommendInfo> getRecommendedInfo();
}
