package com.hotbitmapgg.bilibili.network.api;

import com.hotbitmapgg.bilibili.entity.user.UserChaseBangumiInfo;
import com.hotbitmapgg.bilibili.entity.user.UserCoinsInfo;
import com.hotbitmapgg.bilibili.entity.user.UserContributeInfo;
import com.hotbitmapgg.bilibili.entity.user.UserPlayGameInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 2016/10/12 22:40
 * 100332338@qq.com
 * <p>
 * 用户相关api
 */

public interface UserService
{

    /**
     * 用户所玩游戏
     *
     * @param mid
     * @return
     */
    @GET("ajax/game/GetLastPlay")
    Observable<UserPlayGameInfo> getUserPlayGames(@Query("mid") int mid);


    /**
     * 用户投币视频
     *
     * @param mid
     * @return
     */
    @GET("ajax/member/getCoinVideos")
    Observable<UserCoinsInfo> getUserCoinVideos(@Query("mid") int mid);


    /**
     * 用户追番
     *
     * @param mid
     * @return
     */
    @GET("ajax/Bangumi/getList")
    Observable<UserChaseBangumiInfo> getUserChaseBangumis(@Query("mid") int mid);


    /**
     * 用户投稿视频
     *
     * @param mid
     * @param page
     * @param pageSize
     * @return
     */
    @GET("ajax/member/getSubmitVideos")
    Observable<UserContributeInfo> getUserContributeVideos(@Query("mid") int mid, @Query("page") int page, @Query("pagesize") int pageSize);
}
