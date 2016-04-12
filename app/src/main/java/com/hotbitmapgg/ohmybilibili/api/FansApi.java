package com.hotbitmapgg.ohmybilibili.api;

import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.UserFans;
import com.hotbitmapgg.ohmybilibili.network.ApiHelper;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;

/**
 * Created by hcc on 16/3/27.
 */
public class FansApi
{

    public static BasicMessage<UserFans> getUserFans(String mid, int page, int pagesize)
    {

        String url = ApiHelper.getUserFansList(mid, page, pagesize);
        LogUtil.lsw(url + "!!!!");
        BasicMessage<UserFans> msg = ApiHelper.getSimpleUrlResult(url, UserFans.class);
        if (msg.getCode() == BasicMessage.CODE_SUCCEED)
        {
            return msg;
        }

        return null;
    }
}
