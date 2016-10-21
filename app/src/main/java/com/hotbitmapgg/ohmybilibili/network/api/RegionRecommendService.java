package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.region.RegionRecommendInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 2016/10/21 20:32
 * 100332338@qq.com
 * <p>
 * 分区推荐页面请求api
 * <p>
 * http://app.bilibili.com/x/v2/region/show?access_key=67cbf6a1e9ad7d7f11bfbd918e50c837&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3600&device=phone&mobi_app=iphone&plat=1&platform=ios&rid=1&sign=959d7b8c09c65e7a66f7e58b1a2bdab9&ts=1472310694
 */

public interface RegionRecommendService
{

    @GET("x/v2/region/show?access_key=67cbf6a1e9ad7d7f11bfbd918e50c837&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3600&device=phone&mobi_app=iphone&plat=1&platform=ios&sign=959d7b8c09c65e7a66f7e58b1a2bdab9&ts=1472310694")
    Observable<RegionRecommendInfo> getRegionRecommends(@Query("rid") int rid);
}
