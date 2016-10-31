package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiDetailsRecommendInfo;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 16/8/22 21:09
 * 100332338@qq.com
 * <p/>
 * 获取番剧详情番剧推荐
 */
public interface BangumiDetailsRecommendService
{

    @GET("api/season/recommend/5070.json?access_key=19946e1ef3b5cad1a756c475a67185bb&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3940&device=phone&mobi_app=iphone&platform=ios&season_id=5070&sign=744e3a3f52829e4344c33908f7a0c1ef&ts=1477898527")
    Observable<BangumiDetailsRecommendInfo> getBangumiDetailsRecommend();
}
