package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiAppIndexInfo;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 2016/11/1 10:43
 * 100332338@qq.com
 * <p>
 * 首页番剧内容请求api
 */

public interface BangumiAppIndexService
{

    @GET("api/app_index_page_v4?build=3940&device=phone&mobi_app=iphone&platform=ios")
    Observable<BangumiAppIndexInfo> getBangumiAppIndex();
}
