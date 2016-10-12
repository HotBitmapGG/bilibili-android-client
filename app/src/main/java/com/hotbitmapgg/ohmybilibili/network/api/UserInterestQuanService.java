package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.user.UserInterestQuanInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 2016/10/12 19:36
 * 100332338@qq.com
 * <p>
 * 获取用户兴趣圈数据
 * http://www.im9.com/api/query.community.list.do?access_key=c8455e3e73a29e2c451a2695dc77410b&
 * actionKey=appkey&appkey=27eb53fc9058f8c3&build=3710&data_type=4&device=phone
 * &mid=2752388&mobi_app=iphone&page_no=1&page_size=2&platform=ios&sign=38d9bc710fd5d1c9a4e35d0bff545388&ts=1474365557
 */

public interface UserInterestQuanService
{

    @GET("api/query.community.list.do?access_key=c8455e3e73a29e2c451a2695dc77410b&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3710&data_type=4&device=phone&mobi_app=iphone&platform=ios&sign=38d9bc710fd5d1c9a4e35d0bff545388&ts=1474365557")
    Observable<UserInterestQuanInfo> getUserInterestQuanData(@Query("mid") int mid, @Query("page_no") int page, @Query("page_size") int pageSize);
}
