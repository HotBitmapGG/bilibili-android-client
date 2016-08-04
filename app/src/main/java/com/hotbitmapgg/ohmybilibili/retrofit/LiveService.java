package com.hotbitmapgg.ohmybilibili.retrofit;


import com.hotbitmapgg.ohmybilibili.model.live.LiveIndex;
import com.hotbitmapgg.ohmybilibili.model.base.Result;

import retrofit.http.GET;
import rx.Observable;

/**
 * B站直播请求
 * <p/>
 * http://bilibili-service.daoapp.io/appindex
 *
 * @HotBitmapGG
 */
public interface LiveService
{

    @GET("appindex")
    Observable<Result<LiveIndex>> getIndexRx();
}
