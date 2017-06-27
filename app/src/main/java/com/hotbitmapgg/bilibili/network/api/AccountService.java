package com.hotbitmapgg.bilibili.network.api;

import com.hotbitmapgg.bilibili.entity.user.UserDetailsInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 16/8/8 20:48
 * 100332338@qq.com
 * <p>
 * 用户个人账号相关api
 */
public interface AccountService {

    /**
     * 用户详情数据
     */
    @GET("api/member/getCardByMid")
    Observable<UserDetailsInfo> getUserInfoById(@Query("mid") int mid);
}
