package com.hotbitmapgg.ohmybilibili.network.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 16/8/8 18:25
 * 100332338@qq.com
 * <p/>
 * 获取该Up主上传的所有视频
 */
public interface UserUpVideoService
{

    @GET("list")
    Observable<ResponseBody> getUserUpVideoList(@Query("mid") int mid,
                                                @Query("page") int page,
                                                @Query("pagesize") int pageSize,
                                                @Query("appkey") String appKey,
                                                @Query("ts") String ts);
}
