package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.attention.AttentionDynamicInfo;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 2016/11/1 19:00
 * 100332338@qq.com
 * <p>
 * 获取关注的动态api
 */

public interface AttentionDynamicService
{

    @GET("http://api.bilibili.com/x/feed/pull?access_key=19946e1ef3b5cad1a756c475a67185bb&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3940&device=phone&mobi_app=iphone&platform=ios&pn=1&ps=30&sign=4ab1598d07506c09e3dbab800d331a6a&ts=1477997574&type=0")
    Observable<AttentionDynamicInfo> getAttentionDynamic();
}
