package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiSchedule;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 16/8/8 20:01
 * 100332338@qq.com
 * <p/>
 * 番剧时间表数据
 * <p>
 * http://bangumi.bilibili.com/api/get_season_by_tag?actionKey=appkey&appkey=27eb53fc9058f8c3
 * &build=2310&device=phone&indexType=0&page=1&pagesize=10&platform=ios
 * &sign=500cb8598bc53d2775dcf32daf5c9249&tag_id=109&ts=1466677926
 */
public interface BangumiScheduleService
{

    @GET("api/get_season_by_tag?actionKey=appkey&appkey=27eb53fc9058f8c3&build=2310&device=phone&indexType=0&page=1&pagesize=50&platform=ios&sign=500cb8598bc53d2775dcf32daf5c9249&tag_id=109&ts=1466677926")
    Observable<BangumiSchedule> getBangumiSchedules();
}
