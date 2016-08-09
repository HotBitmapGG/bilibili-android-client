package com.hotbitmapgg.ohmybilibili.network.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 16/8/8 12:31
 * 100332338@qq.com
 * <p/>
 * 获取直播地址URl
 * http://live.bilibili.com/api/playurl?player=1&quality=0&cid=" + cid
 */
public interface LiveUrlService
{

    @GET("api/playurl?player=1&quality=0")
    Observable<ResponseBody> getLiveUrl(@Query("cid") int cid);
}
