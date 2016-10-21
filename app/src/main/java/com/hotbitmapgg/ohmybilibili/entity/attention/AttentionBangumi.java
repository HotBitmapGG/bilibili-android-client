package com.hotbitmapgg.ohmybilibili.entity.attention;

/**
 * Created by hcc on 2016/9/28 19:48
 * 100332338@qq.com
 * <p>
 * 关注番剧模型类
 */

public class AttentionBangumi
{

    private String pic;

    private String title;

    private String desc;


    public String getPic()
    {

        return pic;
    }

    public void setPic(String pic)
    {

        this.pic = pic;
    }

    public String getTitle()
    {

        return title;
    }

    public void setTitle(String title)
    {

        this.title = title;
    }

    public String getDesc()
    {

        return desc;
    }

    public void setDesc(String desc)
    {

        this.desc = desc;
    }

    @Override
    public String toString()
    {

        return "FocusOnBangumi{" +
                "pic='" + pic + '\'' +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
