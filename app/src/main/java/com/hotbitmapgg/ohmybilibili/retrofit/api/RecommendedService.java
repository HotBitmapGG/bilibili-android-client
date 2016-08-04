package com.hotbitmapgg.ohmybilibili.retrofit.api;

import com.hotbitmapgg.ohmybilibili.model.recommended.Recommend;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 16/8/4 12:03
 * 100332338@qq.com
 * <p/>
 * 首页推荐模块数据请求
 */
public interface RecommendedService
{

    @GET("x/show/old?platform=android&device=&build=412001")
    Observable<Recommend> getRecommended();
}
