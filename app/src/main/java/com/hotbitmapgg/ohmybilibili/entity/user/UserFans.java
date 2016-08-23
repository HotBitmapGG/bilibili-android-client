package com.hotbitmapgg.ohmybilibili.entity.user;

import java.util.ArrayList;

/**
 * Created by hcc on 16/8/22 20:48
 * 100332338@qq.com
 * <p/>
 * 用户粉丝数据
 */
public class UserFans
{

    public int code;

    public ArrayList<FansInfo> list;


    public class FansInfo
    {

        public int addtime;

        public int attentioned;

        public String face;

        public int fid;

        public int record_id;

        public String uname;
    }
}
