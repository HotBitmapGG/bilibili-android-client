package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.discover.AllHotVideoInfo;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 16/9/12 20:51
 * 100332338@qq.com
 * <p/>
 * 获取全区热门视频数据
 */
public interface AllHotVideoService
{

    @GET("allrank")
    Observable<List<AllHotVideoInfo>> getAllRankInfos();
}
