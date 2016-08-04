package com.hotbitmapgg.ohmybilibili.model.bangumi;

import com.google.gson.annotations.SerializedName;

public class Bangumi
{

    public String title; // 标题

    public String cover; // 封面图片地址

    public int bgmcount; // 番剧当前总集数

    public int weekday; // 番剧周信息

    public int lastupdate; // 最后更新时间 UNIX 时间戳

    public String lastupdate_at; // 最后更新时间

    @SerializedName("new")
    public boolean isnew; // 是否最近有更新

    public String spid;  //番剧id

    public int season_id; //专题详情id
}