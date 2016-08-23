package com.hotbitmapgg.ohmybilibili.entity.bangumi;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hcc on 16/8/6 11:08
 * 100332338@qq.com
 * <p/>
 * 番剧放送表(专题视频)
 */
public class WeekDayBangumi
{

    // 标题
    public String title;

    // 封面图片地址
    public String cover;

    // 番剧当前总集数
    public int bgmcount;

    // 番剧周信息
    public int weekday;

    // 最后更新时间 UNIX 时间戳
    public int lastupdate;

    // 最后更新时间
    public String lastupdate_at;

    // 是否最近有更新
    @SerializedName("new")
    public boolean isnew;

    //番剧id
    public String spid;

    //专题详情id
    public int season_id;
}