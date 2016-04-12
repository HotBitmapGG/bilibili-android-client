package com.hotbitmapgg.ohmybilibili.api;

import com.hotbitmapgg.ohmybilibili.model.AuthorRecommend;
import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.network.ApiHelper;

/**
 * Created by hcc on 16/3/13.
 */
public class AuthorRecommendApi
{

    public static BasicMessage<AuthorRecommend> getAuthorRecommendList(String aid)
    {

        String url = ApiHelper.getAuthorRecommendVideo(aid);
        return ApiHelper.getSimpleUrlResult(url, AuthorRecommend.class);
    }
}
