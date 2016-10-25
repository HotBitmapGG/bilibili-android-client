package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.search.SearchArchiveInfo;
import com.hotbitmapgg.ohmybilibili.entity.search.SearchBangumiInfo;
import com.hotbitmapgg.ohmybilibili.entity.search.SearchMovieInfo;
import com.hotbitmapgg.ohmybilibili.entity.search.SearchSpInfo;
import com.hotbitmapgg.ohmybilibili.entity.search.SearchUpperInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 16/8/29 19:13
 * 100332338@qq.com
 * <p/>
 * 全站搜索请求api
 */
public interface TotalStationSearchService
{

    /**
     * 综合搜索
     *
     * @param content
     * @param page
     * @param pagesize
     * @return
     */
    @GET("x/v2/search?actionKey=appkey&appkey=27eb53fc9058f8c3&build=3710&device=phone&duration=0&mobi_app=iphone&order=default&platform=ios&rid=0")
    Observable<SearchArchiveInfo> searchArchive(@Query("keyword") String content, @Query("pn") int page, @Query("ps") int pagesize);


    /**
     * 番剧搜索
     *
     * @param content
     * @param page
     * @param pagesize
     * @return
     */
    @GET("x/v2/search/type?actionKey=appkey&appkey=27eb53fc9058f8c3&build=3710&device=phone&mobi_app=iphone&platform=ios&type=1")
    Observable<SearchBangumiInfo> searchBangumi(@Query("keyword") String content, @Query("pn") int page, @Query("ps") int pagesize);

    /**
     * up主搜索
     *
     * @param content
     * @param page
     * @param pagesize
     * @return
     */
    @GET("x/v2/search/type?actionKey=appkey&appkey=27eb53fc9058f8c3&build=3710&device=phone&mobi_app=iphone&platform=ios&type=2")
    Observable<SearchUpperInfo> searchUpper(@Query("keyword") String content, @Query("pn") int page, @Query("ps") int pagesize);

    /**
     * 影视搜索
     *
     * @param content
     * @param page
     * @param pagesize
     * @return
     */
    @GET("x/v2/search/type?actionKey=appkey&appkey=27eb53fc9058f8c3&build=3710&device=phone&mobi_app=iphone&platform=ios&type=3")
    Observable<SearchMovieInfo> searchMovie(@Query("keyword") String content, @Query("pn") int page, @Query("ps") int pagesize);


    /**
     * 专题搜索
     *
     * @param content
     * @param page
     * @param pagesize
     * @return
     */
    @GET("x/v2/search/type?actionKey=appkey&appkey=27eb53fc9058f8c3&build=3710&device=phone&mobi_app=iphone&platform=ios&type=4")
    Observable<SearchSpInfo> searchSp(@Query("keyword") String content, @Query("pn") int page, @Query("ps") int pagesize);
}
