package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiDetailsVideos;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 16/8/22 21:09
 * 100332338@qq.com
 * <p/>
 * 获取番剧详情的视频列表
 * <p/>
 * bangumi: 取得番剧视频:1，其他视频:0
 * http://bilibili-service.daoapp.io/spvideos/56749?bangumi=0
 */
public interface BangumiDetailsVideosService
{

    @GET("spvideos/{spid}")
    Observable<BangumiDetailsVideos> getBangumiDetailsVideos(@Path("spid") int spid,
                                                             @Query("bangumi") int type);
}
