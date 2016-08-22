package com.hotbitmapgg.ohmybilibili.entity.video;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hcc on 16/8/22 20:48
 * 100332338@qq.com
 * <p/>
 * 视频Item数据
 */
public class VideoItemInfo implements Serializable
{

    //视频时长
    public String duration;

    //推荐数量
    public int coins;

    //评分数量
    public int credit;

    //封面图片地址
    public String pic;

    //视频创建日期
    public String create;

    //视频简介
    public String description;

    //视频作者
    public String author;

    //视频作者ID
    public int mid;

    //收藏数
    public int favorites;

    //弹幕数
    public int video_review;

    //评论数
    public int review;

    //播放次数
    public String play;

    //视频副标题
    public String subtitle;

    //视频标题
    public String title;

    //视频分类名称
    public String typename;

    //视频分类ID
    public int typeid;

    //视频编号
    public int aid;

    //最后推荐信息
    @SerializedName("last_recommend")
    public List<LastRecommend> lastRecommends;

    public class LastRecommend
    {

        //推荐人名字
        public String uname;

        //推荐人ID
        public int mid;

        //推荐时间
        public long time;

        //推荐信息
        public String msg;

        //推荐人头像地址
        public String face;
    }

    public String toJsonString()
    {

        return new Gson().toJson(this);
    }

    public static VideoItemInfo createFromJson(String jsonStr)
    {

        return new Gson().fromJson(jsonStr, VideoItemInfo.class);
    }
}
