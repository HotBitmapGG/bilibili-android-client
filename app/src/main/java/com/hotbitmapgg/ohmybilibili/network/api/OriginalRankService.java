package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.discover.OriginalRankInfo;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by hcc on 2016/9/22 18:40
 * 100332338@qq.com
 * <p>
 * 原创排行榜API
 * <p>
 * "原创":"http://www.bilibili.com/index/rank/origin-03.json"
 * <p>
 * "全站":"http://www.bilibili.com/index/rank/all-03.json"
 * <p>
 * "番剧":"http://www.bilibili.com/index/rank/all-03-13.json"
 */

public interface OriginalRankService
{

    @GET("index/rank/{type}")
    Observable<OriginalRankInfo> getOriginalRanks(@Path("type") String type);
}
