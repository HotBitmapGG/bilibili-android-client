package com.hotbitmapgg.ohmybilibili.network.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 16/8/8 17:26
 * 100332338@qq.com
 * <p/>
 * 查询分区列表数据
 * 该接口需要AppKey才可正常查询
 */
public interface PartitionMoreService
{

    @GET("list")
    Observable<ResponseBody> getPartitionMore(@Query("tid") String tid,
                                              @Query("page") int page,
                                              @Query("pagesize") int pageSize,
                                              @Query("order") int order,
                                              @Query("appkey") String appkey,
                                              @Query("ts") String ts);
}
