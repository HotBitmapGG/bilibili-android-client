package com.hotbitmapgg.ohmybilibili.retrofit.api;


import com.hotbitmapgg.ohmybilibili.model.base.Result;
import com.hotbitmapgg.ohmybilibili.model.live.LiveIndex;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 16/8/4 12:03
 * 100332338@qq.com
 * <p/>
 * 首页直播模块数据请求
 */
public interface LiveService
{

    @GET("appindex")
    Observable<Result<LiveIndex>> getIndexRx();
}
