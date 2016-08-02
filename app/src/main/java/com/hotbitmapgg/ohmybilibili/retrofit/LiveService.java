package com.hotbitmapgg.ohmybilibili.retrofit;


import com.hotbitmapgg.ohmybilibili.model.LiveIndex;
import com.hotbitmapgg.ohmybilibili.model.Result;

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
