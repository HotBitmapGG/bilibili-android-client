package com.hotbitmapgg.ohmybilibili.model.recommended;

import com.google.gson.annotations.SerializedName;
import com.hotbitmapgg.ohmybilibili.model.video.VideoItemInfo;

import java.util.List;

public class RecommendList
{

    public String code;

    public String pages;

    public String num;

    @SerializedName("list")
    public List<VideoItemInfo> lists;
}
