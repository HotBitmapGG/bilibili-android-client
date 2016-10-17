package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.bangumi.HomeBangumiRecommend;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 16/8/6 11:06
 * 100332338@qq.com
 * <p/>
 * 首页番剧获取Api
 * http://bangumi.bilibili.com/api/app_index_page_v3?access_key=f5bd4e793b82fba5aaf5b91fb549910a&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3470&device=phone&mobi_app=iphone&platform=ios&sign=716eb95b22774147de092249c4605e30&ts=1469613339
 */
public interface HomeBangumiRecommendService
{

    @GET("api/app_index_page_v3?access_key=f5bd4e793b82fba5aaf5b91fb549910a&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3470&device=phone&mobi_app=iphone&platform=ios&sign=716eb95b22774147de092249c4605e30&ts=1469613339")
    Observable<HomeBangumiRecommend> getHomeBangumiRecommended();
}
