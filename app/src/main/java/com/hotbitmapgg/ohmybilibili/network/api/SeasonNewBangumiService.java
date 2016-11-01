package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.bangumi.SeasonNewBangumiInfo;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 2016/9/25 14:30
 * 100332338@qq.com
 * <p>
 * 分季新番数据请求
 * http://bangumi.bilibili.com/api/season_group.json?build=3940&device=phone&mobi_app=iphone&platform=ios
 */

public interface SeasonNewBangumiService
{

    @GET("api/season_group.json?build=3940&device=phone&mobi_app=iphone&platform=ios")
    Observable<SeasonNewBangumiInfo> getSeasonNewBangumiList();
}
