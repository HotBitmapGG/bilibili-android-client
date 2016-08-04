package com.hotbitmapgg.ohmybilibili.retrofit;

import com.hotbitmapgg.ohmybilibili.model.bangumi.BangumiIndex;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * B站番剧索引请求
 *
 * @HotBitmapGG
 */
public interface BangumiIndexService
{

    @GET("/index/bangumi/{year}-{month}.json")
    Observable<List<BangumiIndex>> getBangumiIndex(@Path("year") String year, @Path("month") String month);
}
