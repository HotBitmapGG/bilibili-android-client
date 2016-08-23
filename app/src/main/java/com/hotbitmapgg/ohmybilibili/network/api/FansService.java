package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.user.UserFans;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 16/8/8 20:25
 * 100332338@qq.com
 * <p/>
 * 获取用户粉丝列表
 */
public interface FansService
{

    @GET("friend/fans")
    Observable<UserFans> getUserFans(@Query("mid") String mid,
                                     @Query("page") int page,
                                     @Query("pagesize") int pageSize);
}
