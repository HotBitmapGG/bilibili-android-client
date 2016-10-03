package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.discover.TopicCenterInfo;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 2016/10/3 15:54
 * 100332338@qq.com
 * <p>
 * 话题中心请求数据
 * http://api.bilibili.com/topic/getlist?device=phone&mobi_app=iphone&page=1&pagesize=20
 */

public interface TopicCenterService
{

    @GET("topic/getlist?device=phone&mobi_app=iphone&page=1&pagesize=137")
    Observable<TopicCenterInfo> getTopicCenterList();
}
