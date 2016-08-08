package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.base.BasicMessage;
import com.hotbitmapgg.ohmybilibili.entity.recommended.RecommendList;
import com.hotbitmapgg.ohmybilibili.network.ApiHelper;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 推荐视频查询API
 * 根据类型进行查询
 */
public class RecommendApi
{

    public static final int ORDER_DEFAULT = 0, ORDER_NEW = 1, ORDER_REVIEW = 2, ORDER_HOT = 3, ORDER_DAMKU = 4, ORDER_COMMENT = 5, ORDER_PROMOTE = 6, ORDER_NONE = 0;

    private static final String[] ORDER_VALUE = new String[]{ApiHelper.RecommendOrder.DEFAULT, ApiHelper.RecommendOrder.NEW, ApiHelper.RecommendOrder.REVIEW, ApiHelper.RecommendOrder.HOT, ApiHelper.RecommendOrder.DAMKU, ApiHelper.RecommendOrder.COMMENT, ApiHelper.RecommendOrder.PROMOTE, null};

    public static BasicMessage<RecommendList> getList(String tid, String pagenum, String pagesize, int order)
    {

        String url = ApiHelper.getRecommendUrl(tid, pagenum, pagesize, ORDER_VALUE[order]);
        return ApiHelper.getSimpleUrlResult(url, RecommendList.class);
    }
}
