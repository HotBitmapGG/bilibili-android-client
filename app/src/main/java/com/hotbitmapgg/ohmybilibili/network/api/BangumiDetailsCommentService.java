package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiDetailsCommentInfo;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 2016/11/1 21:22
 * 100332338@qq.com
 * <p>
 * 番剧详情番剧评论api
 */

public interface BangumiDetailsCommentService
{

    @GET("x/v2/reply?_device=iphone&_hwid=c84c067f8d99f9d3&_ulv=10000&access_key=19946e1ef3b5cad1a756c475a67185bb&appkey=27eb53fc9058f8c3&appver=3940&build=3940&nohot=0&oid=5189987&platform=ios&pn=1&ps=20&sign=c3b059e907f5c1d3416daa9fcc6396bf&sort=0&type=1")
    Observable<BangumiDetailsCommentInfo> getBangumiDetailsComments();
}
