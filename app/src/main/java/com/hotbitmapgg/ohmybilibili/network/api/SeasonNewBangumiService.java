package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.bangumi.SeasonNewBangumi;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 2016/9/25 14:30
 * 100332338@qq.com
 * <p>
 * 分季新番数据请求
 * http://app.bilibili.com/bangumi/operation_module?_device=
 * android&_hwid=ac538400c68784bb&_ulv=10000&module=bangumi&platform=android&screen=xxhdpi
 */

public interface SeasonNewBangumiService
{

    @GET("bangumi/operation_module?_device=android&_hwid=ac538400c68784bb&_ulv=10000&module=bangumi&platform=android&screen=xxhdpi")
    Observable<SeasonNewBangumi> getSeasonNewBangumiList();
}
