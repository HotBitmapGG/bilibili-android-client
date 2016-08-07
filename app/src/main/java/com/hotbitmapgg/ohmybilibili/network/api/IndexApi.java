package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.model.base.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.index.Index;
import com.hotbitmapgg.ohmybilibili.network.ApiHelper;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 9个热门视频排行查询API
 */
public class IndexApi
{

    public static BasicMessage<Index> getIndex()
    {

        String url = ApiHelper.getIndexUrl();
        return ApiHelper.getSimpleUrlResult(url, Index.class);
    }
}
