package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiDetails;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by hcc on 16/8/22 21:06
 * 100332338@qq.com
 * <p/>
 * 获取番剧详情数据
 * http://bilibili-service.daoapp.io/spinfo/56749
 */
public interface BangumiDetailsService
{

    @GET("spinfo/{spid}")
    Observable<BangumiDetails> getBangumiDetails(@Path("spid") int spid);
}
