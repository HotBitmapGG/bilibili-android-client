package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.user.UserDetailsInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 16/8/8 20:48
 * 100332338@qq.com
 * <p/>
 * 查询用户详情数据
 * <p/>
 * https://account.bilibili.com/api/member/getCardByMid?mid=279463
 */
public interface UserInfoDetailsService
{

    @GET("api/member/getCardByMid")
    Observable<UserDetailsInfo> getUserInfoById(@Query("mid") int mid);
}
