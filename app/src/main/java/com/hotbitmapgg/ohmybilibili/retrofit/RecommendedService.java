package com.hotbitmapgg.ohmybilibili.retrofit;

import com.hotbitmapgg.ohmybilibili.model.recommended.Recommend;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by hcc on 16/8/4 12:03
 * 100332338@qq.com
 */
public interface RecommendedService
{

    @GET("x/show/old?platform=android&device=&build=412001")
    Observable<Recommend> getRecommended();
}
