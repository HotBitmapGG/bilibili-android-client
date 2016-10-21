package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.region.RegionDetailsInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 2016/10/22 01:35
 * 100332338@qq.com
 * <p>
 * 获取分区类型详情api
 * <p>
 * http://app.bilibili.com/x/v2/region/show/child?build=3600&rid=24
 */

public interface RegionDetailsService
{

    @GET("x/v2/region/show/child?build=3600")
    Observable<RegionDetailsInfo> getRegionDetails(@Query("rid") int rid);
}
