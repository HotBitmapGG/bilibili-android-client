package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.base.BasicMessage;
import com.hotbitmapgg.ohmybilibili.entity.user.UserFans;
import com.hotbitmapgg.ohmybilibili.network.ApiHelper;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 用户粉丝查询API
 */
public class FansApi
{

    public static BasicMessage<UserFans> getUserFans(String mid, int page, int pagesize)
    {

        String url = ApiHelper.getUserFansList(mid, page, pagesize);
        BasicMessage<UserFans> msg = ApiHelper.getSimpleUrlResult(url, UserFans.class);
        if (msg.getCode() == BasicMessage.CODE_SUCCEED)
        {
            return msg;
        }

        return null;
    }
}
