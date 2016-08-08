package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.user.AuthorRecommend;
import com.hotbitmapgg.ohmybilibili.entity.base.BasicMessage;
import com.hotbitmapgg.ohmybilibili.network.ApiHelper;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * Up主推荐视频查询API
 */
public class AuthorRecommendApi
{

    public static BasicMessage<AuthorRecommend> getAuthorRecommendList(String aid)
    {

        String url = ApiHelper.getAuthorRecommendVideo(aid);
        return ApiHelper.getSimpleUrlResult(url, AuthorRecommend.class);
    }
}
