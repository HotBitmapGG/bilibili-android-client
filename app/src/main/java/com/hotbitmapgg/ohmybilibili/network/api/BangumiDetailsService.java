package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiDetailsInfo;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 16/8/22 21:06
 * 100332338@qq.com
 * <p/>
 * 获取番剧详情数据
 * http://bangumi.bilibili.com/api/season_v4?access_key=19946e1ef3b5cad1a756c475a67185bb&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3940&device=phone&mobi_app=iphone&platform=ios&season_id=5070&sign=3e5d4d7460961d9bab5da2341fd98dc1&ts=1477898526&type=bangumi
 */
public interface BangumiDetailsService
{

    @GET("api/season_v4?access_key=19946e1ef3b5cad1a756c475a67185bb&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3940&device=phone&mobi_app=iphone&platform=ios&season_id=5070&sign=3e5d4d7460961d9bab5da2341fd98dc1&ts=1477898526&type=bangumi")
    Observable<BangumiDetailsInfo> getBangumiDetails();
}
