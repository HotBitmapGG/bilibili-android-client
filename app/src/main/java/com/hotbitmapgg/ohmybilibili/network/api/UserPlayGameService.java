package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.user.UserPlayGameInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 2016/10/12 22:40
 * 100332338@qq.com
 * <p>
 * 用户详情所玩游戏请求数据
 * http://space.bilibili.com/ajax/game/GetLastPlay?mid=181891
 */

public interface UserPlayGameService
{

    @GET("ajax/game/GetLastPlay")
    Observable<UserPlayGameInfo> getUserPlayGames(@Query("mid") int mid);
}
