package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.rank.OriginalRankInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 2016/9/22 18:40
 * 100332338@qq.com
 * <p>
 * 原创排行榜API
 * <p>
 * http://api.bilibili.cn/recommend
 */

public interface OriginalRankService
{

    @GET("recommend")
    Observable<OriginalRankInfo> getOriginalRank(@Query("page") int page,
                                                 @Query("pagesize") int pagesize,
                                                 @Query("order") String order);
}
