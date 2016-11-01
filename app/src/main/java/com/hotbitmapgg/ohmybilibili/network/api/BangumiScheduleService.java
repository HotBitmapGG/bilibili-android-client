package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiScheduleInfo;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 16/8/8 20:01
 * 100332338@qq.com
 * <p/>
 * 番剧放送表api
 */
public interface BangumiScheduleService
{

    @GET("api/timeline_v4?access_key=19946e1ef3b5cad1a756c475a67185bb&actionKey=appkey&appkey=27eb53fc9058f8c3&area_id=2&build=3940&device=phone&mobi_app=iphone&platform=ios&see_mine=0&sign=d8cbbacab2e5fd0196b4883201e2103e&ts=1477981526")
    Observable<BangumiScheduleInfo> getBangumiSchedules();
}
