package com.hotbitmapgg.ohmybilibili.model;

import java.util.ArrayList;

/**
 * Created by hcc on 16/3/27.
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
