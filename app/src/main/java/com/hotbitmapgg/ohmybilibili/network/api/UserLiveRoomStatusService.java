package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.user.UserLiveRoomStatusInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 2016/10/14 11:42
 * 100332338@qq.com
 * <p>
 * 获取用户直播状态 是否在直播
 * <p>
 * http://live.bilibili.com/AppRoom/getRoomInfo?mid=37268498
 */

public interface UserLiveRoomStatusService
{

    @GET("AppRoom/getRoomInfo")
    Observable<UserLiveRoomStatusInfo> getUserLiveRoomStatus(@Query("mid") int mid);
}
