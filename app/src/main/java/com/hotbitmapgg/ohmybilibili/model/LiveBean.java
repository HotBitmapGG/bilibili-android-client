package com.hotbitmapgg.ohmybilibili.model;

import java.util.List;

public class LiveBean
{

    public int code;

    public String msg;

    public List<LiveData> data;

    @Override
    public String toString()
    {

        return "LiveBean [code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }

    public class LiveData
    {

        // 分区号码
        public int area;

        // 封面
        public String cover;

        // 主播头像
        public String face;

        // 房间链接
        public String link;

        // 开播时间
        public String live_time;

        // 在线人数
        public int online;

        // 房间ID
        public int roomid;

        // 房间短id
        public int short_id;

        // 标题
        public String title;

        // uid
        public int uid;

        // 主播名称
        public String uname;

        // 主播封面
        public String user_cover;

        @Override
        public String toString()
        {

            return "LiveData [area=" + area + ", cover=" + cover + ", face=" + face + ", link=" + link + ", live_time=" + live_time + ", online=" + online + ", roomid=" + roomid + ", short_id=" + short_id + ", title=" + title + ", uid=" + uid + ", uname=" + uname + ", user_cover=" + user_cover + "]";
        }
    }
}
