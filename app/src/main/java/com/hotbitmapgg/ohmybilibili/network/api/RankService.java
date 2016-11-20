package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.discover.AllareasRankInfo;
import com.hotbitmapgg.ohmybilibili.entity.discover.OriginalRankInfo;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by hcc on 2016/9/22 18:40
 * 100332338@qq.com
 * <p>
 * 排行榜相关api
 */

public interface RankService
{

    /**
     * 原创排行榜请求
     *
     * @param type
     * @return
     */
    @GET("index/rank/{type}")
    Observable<OriginalRankInfo> getOriginalRanks(@Path("type") String type);


    /**
     * 全区排行榜数据请求
     *
     * @param type
     * @return
     */
    @GET("index/rank/{type}")
    Observable<AllareasRankInfo> getAllareasRanks(@Path("type") String type);
}
