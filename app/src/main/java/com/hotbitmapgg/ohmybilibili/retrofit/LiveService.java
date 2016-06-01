package com.hotbitmapgg.ohmybilibili.retrofit;


import com.hotbitmapgg.ohmybilibili.model.LiveIndex;
import com.hotbitmapgg.ohmybilibili.model.Result;

import retrofit.http.GET;
import rx.Observable;

/**
 * B站直播请求
 *
 * @HotBitmapGG
 */
public interface LiveService
{

    @GET("AppIndex/home?_device=android&_hwid=51e96f5f2f54d5f9&_ulv=10000&access_key=563d6046f06289cbdcb472601ce5a761&appkey=c1b107428d337928&build=410000&platform=android&scale=xxhdpi&sign=fbdcfe141853f7e2c84c4d401f6a8758")
    Observable<Result<LiveIndex>> getIndexRx();
}
