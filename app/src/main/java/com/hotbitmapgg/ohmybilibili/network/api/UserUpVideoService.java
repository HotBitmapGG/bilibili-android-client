package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.user.UserUpVideoInfo;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 16/8/8 18:25
 * 100332338@qq.com
 * <p/>
 * 获取该Up主上传的所有视频 该API不需要Appkey
 * http://bilibili-service.daoapp.io/uservideos/mid/page/count
 */
public interface UserUpVideoService
{

    @GET("uservideos/{mid}")
    Observable<UserUpVideoInfo> getUserUpVideos(@Path("mid") int mid,
                                                @Query("page") int page,
                                                @Query("count") int count);
}
