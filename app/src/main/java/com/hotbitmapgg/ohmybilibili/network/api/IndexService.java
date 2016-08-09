package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.index.Index;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 16/8/8 21:00
 * 100332338@qq.com
 * <p/>
 * 9个热门视频排行数据
 */
public interface IndexService
{

    @GET("index")
    Observable<Index> getIndex(@Query("platform") String platform);
}
