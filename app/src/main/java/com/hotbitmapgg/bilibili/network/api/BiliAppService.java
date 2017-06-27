package com.hotbitmapgg.bilibili.network.api;

import com.hotbitmapgg.bilibili.entity.recommend.RecommendBannerInfo;
import com.hotbitmapgg.bilibili.entity.recommend.RecommendInfo;
import com.hotbitmapgg.bilibili.entity.region.RegionDetailsInfo;
import com.hotbitmapgg.bilibili.entity.region.RegionRecommendInfo;
import com.hotbitmapgg.bilibili.entity.search.SearchArchiveInfo;
import com.hotbitmapgg.bilibili.entity.search.SearchBangumiInfo;
import com.hotbitmapgg.bilibili.entity.search.SearchSpInfo;
import com.hotbitmapgg.bilibili.entity.search.SearchMovieInfo;
import com.hotbitmapgg.bilibili.entity.search.SearchUpperInfo;
import com.hotbitmapgg.bilibili.entity.video.VideoDetailsInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 16/8/4 12:03
 * 100332338@qq.com
 */
public interface BiliAppService {

    /**
     * 首页推荐数据
     */
    @GET("x/show/old?platform=android&device=&build=412001")
    Observable<RecommendInfo> getRecommendedInfo();

    /**
     * 首页推荐banner
     */
    @GET("x/banner?plat=4&build=411007&channel=bilih5")
    Observable<RecommendBannerInfo> getRecommendedBannerInfo();

    /**
     * 视频详情数据
     */
    @GET("x/view?access_key=19946e1ef3b5cad1a756c475a67185bb&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3940&device=phone&mobi_app=iphone&platform=ios&sign=1206255541e2648c1badb87812458046&ts=1478349831")
    Observable<VideoDetailsInfo> getVideoDetails(@Query("aid") int aid);

    /**
     * 综合搜索
     */
    @GET("x/v2/search?actionKey=appkey&appkey=27eb53fc9058f8c3&build=3710&device=phone&duration=0&mobi_app=iphone&order=default&platform=ios&rid=0")
    Observable<SearchArchiveInfo> searchArchive(
            @Query("keyword") String content, @Query("pn") int page, @Query("ps") int pagesize);

    /**
     * 番剧搜索
     */
    @GET("x/v2/search/type?actionKey=appkey&appkey=27eb53fc9058f8c3&build=3710&device=phone&mobi_app=iphone&platform=ios&type=1")
    Observable<SearchBangumiInfo> searchBangumi(
            @Query("keyword") String content, @Query("pn") int page, @Query("ps") int pagesize);

    /**
     * up主搜索
     */
    @GET("x/v2/search/type?actionKey=appkey&appkey=27eb53fc9058f8c3&build=3710&device=phone&mobi_app=iphone&platform=ios&type=2")
    Observable<SearchUpperInfo> searchUpper(
            @Query("keyword") String content, @Query("pn") int page, @Query("ps") int pagesize);

    /**
     * 影视搜索
     */
    @GET("x/v2/search/type?actionKey=appkey&appkey=27eb53fc9058f8c3&build=3710&device=phone&mobi_app=iphone&platform=ios&type=3")
    Observable<SearchMovieInfo> searchMovie(
            @Query("keyword") String content, @Query("pn") int page, @Query("ps") int pagesize);

    /**
     * 专题搜索
     */
    @GET("x/v2/search/type?actionKey=appkey&appkey=27eb53fc9058f8c3&build=3710&device=phone&mobi_app=iphone&platform=ios&type=4")
    Observable<SearchSpInfo> searchSp(
            @Query("keyword") String content, @Query("pn") int page, @Query("ps") int pagesize);

    /**
     * 分区推荐
     */
    @GET("x/v2/region/show?access_key=67cbf6a1e9ad7d7f11bfbd918e50c837&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3600&device=phone&mobi_app=iphone&plat=1&platform=ios&sign=959d7b8c09c65e7a66f7e58b1a2bdab9&ts=1472310694")
    Observable<RegionRecommendInfo> getRegionRecommends(@Query("rid") int rid);

    /**
     * 分区类型详情
     */
    @GET("x/v2/region/show/child?build=3600")
    Observable<RegionDetailsInfo> getRegionDetails(@Query("rid") int rid);
}
