package com.hotbitmapgg.ohmybilibili.api;

import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.UserInfo;

import java.util.ArrayList;


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
