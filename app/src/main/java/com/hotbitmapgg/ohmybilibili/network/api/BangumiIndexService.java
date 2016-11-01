package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiIndexInfo;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 16/8/4 12:03
 * 100332338@qq.com
 * <p/>
 * 获取番剧索引api
 */
public interface BangumiIndexService
{

    @GET("api/bangumi_index_cond?access_key=19946e1ef3b5cad1a756c475a67185bb&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3940&device=phone&mobi_app=iphone&platform=ios&sign=cfc6903a13ba89e81c904b4c589e5369&ts=1477974966&type=0")
    Observable<BangumiIndexInfo> getBangumiIndex();
}
