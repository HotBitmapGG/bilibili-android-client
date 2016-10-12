package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.user.UserCoinsInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 2016/10/12 22:14
 * 100332338@qq.com
 * <p>
 * 获取用户投币视频数据
 * http://space.bilibili.com/ajax/member/getCoinVideos?mid=872665&page22size=100
 */

public interface UserCoinsVideoService
{

    @GET("ajax/member/getCoinVideos")
    Observable<UserCoinsInfo> getUserCoinVideos(@Query("mid") int mid);
}
