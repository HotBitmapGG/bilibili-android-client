package com.hotbitmapgg.ohmybilibili.api;


import com.hotbitmapgg.ohmybilibili.network.ApiHelper;
import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.UserInfo;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;

public class UserInfoApi
{

    public static final String TAG = UserInfoApi.class.getSimpleName();

    public static BasicMessage<UserInfo> getUserInfoById(int uid)
    {

        String url = ApiHelper.getUserInfoUrl(uid);
        LogUtil.lsw(url + "@@@");
        BasicMessage<UserInfo> msg = ApiHelper.getSimpleUrlResult(url, UserInfo.class);
        if (msg.getCode() == BasicMessage.CODE_SUCCEED && msg.getObject().code == UserInfo.CODE_NOT_EXIST)
        {
            msg.setCode(UserInfo.CODE_NOT_EXIST);
        }
        return msg;
    }

    public static BasicMessage<UserInfo> getUserInfoByName(String user)
    {

        String url = ApiHelper.getUserInfoUrl(user);
        BasicMessage<UserInfo> msg = ApiHelper.getSimpleUrlResult(url, UserInfo.class);
        if (msg.getCode() == BasicMessage.CODE_SUCCEED && msg.getObject().code == UserInfo.CODE_NOT_EXIST)
        {
            msg.setCode(UserInfo.CODE_NOT_EXIST);
        }
        return msg;
    }
}
