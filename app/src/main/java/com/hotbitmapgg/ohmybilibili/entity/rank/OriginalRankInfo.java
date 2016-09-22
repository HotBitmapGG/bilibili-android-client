package com.hotbitmapgg.ohmybilibili.entity.rank;

import com.google.gson.annotations.SerializedName;
import com.hotbitmapgg.ohmybilibili.entity.video.VideoItemInfo;

import java.util.List;

/**
 * Created by hcc on 2016/9/22 18:44
 * 100332338@qq.com
 * <p>
 * 原创排行榜模型类
 */

public class OriginalRankInfo
{

    public String code;

    public String pages;

    public String num;

    @SerializedName("list")
    public List<VideoItemInfo> videos;
}
