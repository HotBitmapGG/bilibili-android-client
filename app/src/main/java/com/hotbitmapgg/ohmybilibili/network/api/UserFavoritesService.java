package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.user.UserFavoritesInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 2016/10/13 15:40
 * 100332338@qq.com
 * <p>
 * 用户收藏夹请求数据
 * http://api.bilibili.com/x/app/favourite/folder?&vmid=159122
 */

public interface UserFavoritesService
{

    @GET("x/app/favourite/folder?")
    Observable<UserFavoritesInfo> getUserFavorites(@Query("mid") int mid);
}
