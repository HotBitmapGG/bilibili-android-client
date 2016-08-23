package com.hotbitmapgg.ohmybilibili.network.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hcc on 16/8/8 18:45
 * 100332338@qq.com
 * <p/>
 * 获取html5的视频播放地址
 * "http://www.bilibili.com/m/html5?aid=" + av + "&page=" + page;
 */
public interface Html5VideoUrlService
{

    @GET("m/html5")
    Call<ResponseBody> getHtml5VideoPlayerUrl(@Query("aid") String aid,
                                              @Query("page") String page);
}
