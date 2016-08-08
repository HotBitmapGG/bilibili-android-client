package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.base.BasicMessage;
import com.hotbitmapgg.ohmybilibili.entity.user.UserInfo;

import java.util.ArrayList;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 关注的人查询API
 */
public class FriendApi
{

    public static BasicMessage<ArrayList<UserInfo>> getUserList(ArrayList<Integer> uids)
    {

        BasicMessage<ArrayList<UserInfo>> msg = new BasicMessage<>();
        ArrayList<UserInfo> list = new ArrayList<>();

        for (int i : uids)
        {
            BasicMessage<UserInfo> result = UserInfoApi.getUserInfoById(i);
            if (result != null && result.getCode() == BasicMessage.CODE_SUCCEED)
            {
                list.add(result.getObject());
            }
        }

        msg.setObject(list);
        msg.setCode(BasicMessage.CODE_SUCCEED);

        return msg;
    }
}
