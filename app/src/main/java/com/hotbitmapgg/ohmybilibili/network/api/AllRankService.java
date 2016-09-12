package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.rank.AllRankInfo;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 16/9/12 20:51
 * 100332338@qq.com
 * <p/>
 * 获取全区排行榜数据
 */
public interface AllRankService
{

    @GET("allrank")
    Observable<List<AllRankInfo>> getAllRankInfos();
}
