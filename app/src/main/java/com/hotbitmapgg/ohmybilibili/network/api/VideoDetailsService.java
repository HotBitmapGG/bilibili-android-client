package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.video.VideoDetails;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by hcc on 16/8/8 10:18
 * 100332338@qq.com
 * <p/>
 * 获取视频详情信息
 * <p/>
 * http://bilibili-service.daoapp.io/view/aid
 */
public interface VideoDetailsService
{

    @GET("view/{aid}")
    Observable<VideoDetails> getVideoDetails(@Path("aid") int aid);
}
