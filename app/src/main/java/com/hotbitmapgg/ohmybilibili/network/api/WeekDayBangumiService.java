package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.bangumi.WeekDayBangumiResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 16/8/8 20:01
 * 100332338@qq.com
 * <p/>
 * 获取番剧放送表
 */
public interface WeekDayBangumiService
{

    @GET("bangumi")
    Observable<WeekDayBangumiResult> getWeekDayBangumi(@Query("btype") int btype,
                                                       @Query("weekday") int weekday,
                                                       @Query("appkey") String appKey,
                                                       @Query("ts") String ts);
}
