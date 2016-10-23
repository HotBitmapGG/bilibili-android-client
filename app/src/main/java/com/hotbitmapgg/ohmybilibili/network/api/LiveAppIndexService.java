package com.hotbitmapgg.ohmybilibili.network.api;


import com.hotbitmapgg.ohmybilibili.entity.live.LiveAppIndexInfo;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 16/8/4 12:03
 * 100332338@qq.com
 * <p/>
 * 直播模块数据请求
 * <p/>
 * 备用API
 * http://bilibili-service.daoapp.io/appindex
 */
public interface LiveAppIndexService
{

    @GET("AppIndex/home?_device=android&_hwid=51e96f5f2f54d5f9&_ulv=10000&access_key=563d6046f06289cbdcb472601ce5a761&appkey=c1b107428d337928&build=410000&platform=android&scale=xxhdpi&sign=fbdcfe141853f7e2c84c4d401f6a8758")
    Observable<LiveAppIndexInfo> getLiveAppIndex();
}
