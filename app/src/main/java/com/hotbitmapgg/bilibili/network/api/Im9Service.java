package com.hotbitmapgg.bilibili.network.api;

import com.hotbitmapgg.bilibili.entity.user.UserInterestQuanInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 2016/10/12 19:36
 * 100332338@qq.com
 */

public interface Im9Service {

    /**
     * 用户兴趣圈
     */
    @GET("api/query.community.list.do?access_key=c8455e3e73a29e2c451a2695dc77410b&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3710&data_type=4&device=phone&mobi_app=iphone&platform=ios&sign=38d9bc710fd5d1c9a4e35d0bff545388&ts=1474365557")
    Observable<UserInterestQuanInfo> getUserInterestQuanData(
            @Query("mid") int mid, @Query("page_no") int page, @Query("page_size") int pageSize);
}
