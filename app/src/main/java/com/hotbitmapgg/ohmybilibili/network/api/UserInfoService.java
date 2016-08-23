package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.user.UserInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 16/8/8 20:48
 * 100332338@qq.com
 * <p/>
 * 查询用户详情数据
 * <p/>
 * 备用API
 * http://bilibili-service.daoapp.io/user/{mid}
 */
public interface UserInfoService
{

    /**
     * 根据用户名查询
     *
     * @param name
     * @return
     */
    @GET("userinfo")
    Observable<UserInfo> getUserInfoByName(@Query("user") String name);

    /**
     * 根据用户ID查询
     *
     * @param uid
     * @return
     */
    @GET("userinfo")
    Observable<UserInfo> getUserInfoById(@Query("uid") int uid);
}
