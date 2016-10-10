package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiIndex;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 16/8/4 12:03
 * 100332338@qq.com
 * <p/>
 * 番剧索引数据请求
 * <p>
 * http://bangumi.bilibili.com/api/app_index_page?actionKey=appkey&appkey=27eb53fc9058f8c3&build=2310&device=phone&platform=ios&sign=55c99772ca87ed4720201d2f0429d9c2&ts=1466676873
 */
public interface BangumiIndexService
{

    @GET("api/app_index_page?actionKey=appkey&appkey=27eb53fc9058f8c3&build=2310&device=phone&platform=ios&sign=55c99772ca87ed4720201d2f0429d9c2&ts=1466676873")
    Observable<BangumiIndex> getBangumiIndex();
}
