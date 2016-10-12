package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.user.UserContributeInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 2016/10/12 17:16
 * 100332338@qq.com
 * <p>
 * 获取用户投稿视频数量
 * http://space.bilibili.com/ajax/member/getSubmitVideos?mid=2610184&tid=0&pagesize=25
 */

public interface UserContributeVideoService
{

    @GET("ajax/member/getSubmitVideos")
    Observable<UserContributeInfo> getUserContributeVideos(@Query("mid") int mid,
                                                           @Query("page") int page,
                                                           @Query("pagesize") int pageSize);
}
