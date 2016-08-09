package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.video.Sp;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 16/8/9 20:50
 * 100332338@qq.com
 * <p/>
 * 获取专题详情数据
 */
public interface SpInfoService
{

    @GET("sp")
    Observable<Sp> getSpInfo(@Query("spid") int spid, @Query("title") String title);
}
