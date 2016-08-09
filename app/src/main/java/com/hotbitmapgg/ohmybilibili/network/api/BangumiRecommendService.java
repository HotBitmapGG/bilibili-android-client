package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiRecommend;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 16/8/6 11:06
 * 100332338@qq.com
 * <p/>
 * 新番推荐Api
 * http://bilibili-service.daoapp.io/bangumiindex
 */
public interface BangumiRecommendService
{

    @GET("bangumiindex")
    Observable<BangumiRecommend> getBangumiRecommended();
}
