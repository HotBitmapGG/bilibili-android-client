package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.user.UserChaseBangumiInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 2016/10/12 18:44
 * 100332338@qq.com
 * <p>
 * 获取用户追番数据
 * http://space.bilibili.com/ajax/Bangumi/getList?mid=872665
 */

public interface UserChaseBangumiService
{

    @GET("ajax/Bangumi/getList")
    Observable<UserChaseBangumiInfo> getUserChaseBangumis(@Query("mid") int mid);
}
