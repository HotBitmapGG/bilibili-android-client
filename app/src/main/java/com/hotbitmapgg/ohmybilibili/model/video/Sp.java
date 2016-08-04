package com.hotbitmapgg.ohmybilibili.model.video;

public class Sp
{

    public int spid; // 专题ID

    public String title; // 专题名

    public int pubdate; // 发布日期 UNIX 时间戳

    public String created_at; // 发布日期

    public int lastupdate; // 最后更新日期 UNIX 时间戳

    public String lastupdate_at; // 最后更新日期

    public String alias; // 同义词

    public String cover; // 封面

    public int isbangumi; // 是否为新番 1=2次元新番 2=3次元新番

    public int isbangumi_end; // 是否已经播放结束

    public String bangumi_date; // 开播日期

    public String description; // 专题简介

    public int view; // 点击次数

    public int favourite; // 专题收藏次数

    public int attention; // 专题被关注的次数

    public int count; // 专题视频数量

    public static class Item
    {

        public String title; // 标题

        public String cover; // 封面图片地址

        public int aid; // 视频ID

        public int click; // 点击次数

        public String episode; //第几集
    }
}