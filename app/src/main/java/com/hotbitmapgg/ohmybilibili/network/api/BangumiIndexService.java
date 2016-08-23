package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiIndex;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by hcc on 16/8/4 12:03
 * 100332338@qq.com
 * <p/>
 * 番剧索引数据请求
 */
public interface BangumiIndexService
{

    @GET("index/bangumi/{year}-{month}.json")
    Observable<List<BangumiIndex>> getBangumiIndex(@Path("year") String year, @Path("month") String month);
}
