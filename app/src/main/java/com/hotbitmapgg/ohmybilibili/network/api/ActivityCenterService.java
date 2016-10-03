package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.discover.ActivityCenterInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 2016/10/3 19:04
 * 100332338@qq.com
 * <p>
 * 活动中心数据请求
 * <p>
 * http://api.bilibili.com/event/getlist?device=phone&mobi_app=iphone&page=1&pagesize=20
 */

public interface ActivityCenterService
{

    @GET("event/getlist?device=phone&mobi_app=iphone")
    Observable<ActivityCenterInfo> getActivityCenterList(@Query("page") int page, @Query("pagesize") int pageSize);
}
