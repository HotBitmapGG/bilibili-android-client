package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.bangumi.TwoDimensional;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 16/8/6 14:19
 * 100332338@qq.com
 * <p/>
 * 二次元新番Api
 * http://bilibili-service.daoapp.io/bangumi
 */
public interface TwoDimensionalService
{

    @GET("bangumi")
    Observable<TwoDimensional> getTwoDimensional();
}
