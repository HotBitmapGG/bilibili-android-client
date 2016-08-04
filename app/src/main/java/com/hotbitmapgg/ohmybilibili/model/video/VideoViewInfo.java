package com.hotbitmapgg.ohmybilibili.model.video;

import com.google.gson.Gson;

import java.io.Serializable;

public class VideoViewInfo implements Serializable
{

    public int play; // 播放次数

    public int review; // 评论数

    public int video_review; // 弹幕数

    public int favorites; // 收藏数

    public int credit; // 评分数量

    public int coins; // 硬币数

    public String title; // 标题

    public String description; // 简介

    public String tag; // 关键字

    public String pic; // 封面图片 URL 地址

    public String pages; // 返回记录的总页数

    public String from; // 视频来源

    public String author; // 投稿人

    public int mid; // 投稿人ID

    public String face; // 投稿人头像

    public int cid; // 视频源及弹幕编号

    public String offsite; // Flash 播放调用地址

    public int created; // 视频创建时间

    public String created_at; // 视频创建日期

    public boolean favorited; // 是否已收藏

    public String partname; // 分区名称

    public int tid; //视频类型ID

    public String toJsonString()
    {

        return new Gson().toJson(this);
    }

    public static VideoViewInfo createFromJson(String jsonStr)
    {

        return new Gson().fromJson(jsonStr, VideoViewInfo.class);
    }
}
