package com.hotbitmapgg.ohmybilibili.model.video;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class VideoItemInfo implements Serializable
{

    public String duration; /* 视频时长 */

    public int coins; /* 推荐数量 */

    public int credit; /* 评分数量 */

    public String pic; /* 封面图片地址 */

    public String create; /* 视频创建日期 */

    public String description; /* 视频简介 */

    public String author; /* 视频作者 */

    public int mid; /* 视频作者ID */

    public int favorites; /* 收藏数 */

    public int video_review; /* 弹幕数 */

    public int review; /* 评论数 */

    public String play; /* 播放次数 */

    public String subtitle; /* 视频副标题 */

    public String title; /* 视频标题 */

    public String typename; /* 视频分类名称 */

    public int typeid; /* 视频分类ID */

    public int aid; /* 视频编号 */

    @SerializedName("last_recommend")
    public List<LastRecommend> lastRecommends; /* 最后推荐信息 */

    public class LastRecommend
    {

        public String uname; /* 推荐人名字 */

        public int mid; /* 推荐人ID */

        public long time; /* 推荐时间 */

        public String msg; /* 推荐信息 */

        public String face; /* 推荐人头像地址 */
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
