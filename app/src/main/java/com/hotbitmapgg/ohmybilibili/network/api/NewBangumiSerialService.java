package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.bangumi.NewBangumiSerial;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 16/8/6 14:19
 * 100332338@qq.com
 * <p/>
 * 新番连载Api
 * http://bilibili-service.daoapp.io/bangumi
 */
public interface NewBangumiSerialService
{

    @GET("bangumi")
    Observable<NewBangumiSerial> getNewBangumiSerialList();
}
