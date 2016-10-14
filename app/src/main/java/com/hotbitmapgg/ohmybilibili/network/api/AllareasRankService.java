package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.discover.AllareasRankInfo;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by hcc on 16/8/8 21:00
 * 100332338@qq.com
 * <p/>
 * 全区排行榜数据请求
 * <p>
 * "番剧":"http://www.bilibili.com/index/rank/all-03-13.json"
 * "动画":"http://www.bilibili.com/index/rank/all-03-1.json"
 * "音乐":"http://www.bilibili.com/index/rank/all-03-3.json"
 * "舞蹈":"http://www.bilibili.com/index/rank/all-03-129.json"
 * "游戏":"http://www.bilibili.com/index/rank/all-03-4.json"
 * "科技":"http://www.bilibili.com/index/rank/all-03-36.json"
 * "生活":"http://www.bilibili.com/index/rank/all-03-160.json"
 * "鬼畜":"http://www.bilibili.com/index/rank/all-03-155.json"
 * "时尚":"http://www.bilibili.com/index/rank/all-03-5.json"
 * "娱乐":"http://www.bilibili.com/index/rank/all-03-119.json"
 * "电影":"http://www.bilibili.com/index/rank/all-03-23.json"
 * "电视剧":"http://www.bilibili.com/index/rank/all-03-11.json"
 */
public interface AllareasRankService
{

    @GET("index/rank/{type}")
    Observable<AllareasRankInfo> getAllareasRanks(@Path("type") String type);
}
