package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.video.VideoSrc;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

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
    Observable<VideoSrc> getHtml5VideoPlayerUrl(@Query("aid") int aid,
                                                @Query("page") int page);
}
