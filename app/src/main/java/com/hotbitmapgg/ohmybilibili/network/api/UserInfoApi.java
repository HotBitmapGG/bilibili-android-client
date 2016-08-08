package com.hotbitmapgg.ohmybilibili.network.api;


import com.hotbitmapgg.ohmybilibili.entity.base.BasicMessage;
import com.hotbitmapgg.ohmybilibili.entity.user.UserInfo;
import com.hotbitmapgg.ohmybilibili.network.ApiHelper;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 用户个人中心查询API
 */
public class UserInfoApi
{

    public static final String TAG = UserInfoApi.class.getSimpleName();

    public static BasicMessage<UserInfo> getUserInfoById(int uid)
    {

        String url = ApiHelper.getUserInfoUrl(uid);
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
