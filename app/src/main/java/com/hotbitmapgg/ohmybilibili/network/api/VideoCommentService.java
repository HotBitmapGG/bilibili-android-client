package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.video.VideoComment;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 16/8/8 21:08
 * 100332338@qq.com
 * <p/>
 * 获取视频评论数据
 */
public interface VideoCommentService
{

    @GET("feedback")
    Observable<VideoComment> getVideoComment(@Query("aid") int aid,
                                             @Query("page") int page,
                                             @Query("pagesize") int pageSize,
                                             @Query("ver") int ver);
}
