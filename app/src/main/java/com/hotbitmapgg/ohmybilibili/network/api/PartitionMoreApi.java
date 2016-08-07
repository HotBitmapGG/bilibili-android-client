package com.hotbitmapgg.ohmybilibili.network.api;


import com.hotbitmapgg.ohmybilibili.network.ApiHelper;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 分区详情列表查询API
 */
public class PartitionMoreApi
{

    public static final int ORDER_DEFAULT = 0, ORDER_NEW = 1, ORDER_REVIEW = 2, ORDER_HOT = 3, ORDER_DAMKU = 4, ORDER_COMMENT = 5, ORDER_PROMOTE = 6, ORDER_NONE = 0;

    private static final String[] ORDER_VALUE = new String[]{ApiHelper.RecommendOrder.DEFAULT, ApiHelper.RecommendOrder.NEW, ApiHelper.RecommendOrder.REVIEW, ApiHelper.RecommendOrder.HOT, ApiHelper.RecommendOrder.DAMKU, ApiHelper.RecommendOrder.COMMENT, ApiHelper.RecommendOrder.PROMOTE, null};

    public static String getListUrl(String tid, String pagenum, String pagesize, int order)
    {

        String url = ApiHelper.getTypeListUrl(tid, pagenum, pagesize, ORDER_VALUE[order]);
        return url;
    }
}
