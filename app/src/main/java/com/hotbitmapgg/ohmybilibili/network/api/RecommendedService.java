package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.recommend.RecommendBannerInfo;
import com.hotbitmapgg.ohmybilibili.entity.recommend.RecommendInfo;

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
 * <p>
 * 首页Banner推荐数据请求
 * http://app.bilibili.com/x/banner?plat=4&build=411007&channel=bilih5"
 */
public interface RecommendedService
{

    @GET("x/show/old?platform=android&device=&build=412001")
    Observable<RecommendInfo> getRecommendedInfo();

    @GET("x/banner?plat=4&build=411007&channel=bilih5")
    Observable<RecommendBannerInfo> getRecommendedBannerInfo();
}
