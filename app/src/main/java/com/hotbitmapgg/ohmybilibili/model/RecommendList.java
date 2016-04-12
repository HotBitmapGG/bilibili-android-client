package com.hotbitmapgg.ohmybilibili.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecommendList
{

    public String code;

    public String pages;

    public String num;

    @SerializedName("list")
    public List<VideoItemInfo> lists;
}
