package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.search.SearchResult;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by hcc on 16/8/29 19:13
 * 100332338@qq.com
 * <p/>
 * B站全站搜索Api
 */
public interface TotalStationSearchService
{

    @FormUrlEncoded
    @POST("search")
    Observable<SearchResult> search(@Field("content") String content,
                                    @Field("page") int page,
                                    @Field("count") int count);
}
