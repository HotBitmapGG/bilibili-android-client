package com.hotbitmapgg.ohmybilibili.model.user;

import java.util.ArrayList;

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
