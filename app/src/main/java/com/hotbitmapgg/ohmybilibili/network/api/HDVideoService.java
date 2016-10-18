package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.video.HDVideoInfo;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 16/8/30 19:52
 * 100332338@qq.com
 * <p/>
 * 获取B站高清视频接口
 * http://bilibili-service.daoapp.io/video/9253164?quality=2
 * <p/>
 * quailty:清晰度(1~2，根据视频有不同)
 * type: 格式(mp4/flv)
 */
public interface HDVideoService
{

    @GET("/video/{cid}")
    Observable<HDVideoInfo> getHDVideoUrl(@Path("cid") int cid,
                                          @Query("quailty") int quailty,
                                          @Query("type") String type);
}