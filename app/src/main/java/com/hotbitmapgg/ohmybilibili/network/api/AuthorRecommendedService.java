package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.user.UserRecommend;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 16/8/8 19:47
 * 100332338@qq.com
 * <p/>
 * 获取Up主推荐的更多视频
 */
public interface AuthorRecommendedService
{

    @GET("author_recommend")
    Observable<UserRecommend> getAuthorRecommended(@Query("aid") String aid);
}
