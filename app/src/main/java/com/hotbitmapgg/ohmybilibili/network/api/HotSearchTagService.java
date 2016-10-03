package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.discover.HotSearchTag;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 2016/10/3 11:53
 * 100332338@qq.com
 * <p>
 * 发现页面热搜词标签请求
 * http://s.search.bilibili.com/main/hotword?access_key=ec0f54fc369d8c104ee1068672975d6a
 * &actionKey=appkey&appkey=27eb53fc9058f8c3
 */

public interface HotSearchTagService
{

    @GET("main/hotword?access_key=ec0f54fc369d8c104ee1068672975d6a&actionKey=appkey&appkey=27eb53fc9058f8c3")
    Observable<HotSearchTag> getHotSearchTags();
}
