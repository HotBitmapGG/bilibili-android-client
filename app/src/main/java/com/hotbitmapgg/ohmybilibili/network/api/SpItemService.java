package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.video.SpItemResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 16/8/9 20:56
 * 100332338@qq.com
 * <p/>
 * 获取专题视频列表
 */
public interface SpItemService
{

    @GET("spview")
    Observable<SpItemResult> getSpItemList(@Query("spid") int spid,
                                           @Query("season_id") int season_id,
                                           @Query("bangumi") int bangumi);
}
