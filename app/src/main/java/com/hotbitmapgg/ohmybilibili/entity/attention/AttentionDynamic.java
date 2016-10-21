package com.hotbitmapgg.ohmybilibili.entity.attention;

/**
 * Created by hcc on 2016/9/28 19:49
 * 100332338@qq.com
 * <p>
 * 关注动态模型类
 */

public class AttentionDynamic
{

    private String avatar;

    private String name;

    private String uploadTime;

    private String pic;

    private String title;

    private String play;

    private String danmaku;


    public String getAvatar()
    {

        return avatar;
    }

    public void setAvatar(String avatar)
    {

        this.avatar = avatar;
    }

    public String getName()
    {

        return name;
    }

    public void setName(String name)
    {

        this.name = name;
    }

    public String getUploadTime()
    {

        return uploadTime;
    }

    public void setUploadTime(String uploadTime)
    {

        this.uploadTime = uploadTime;
    }

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

    public String getPlay()
    {

        return play;
    }

    public void setPlay(String play)
    {

        this.play = play;
    }

    public String getDanmaku()
    {

        return danmaku;
    }

    public void setDanmaku(String danmaku)
    {

        this.danmaku = danmaku;
    }

    @Override
    public String toString()
    {

        return "FocusOnDynamic{" +
                "avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", uploadTime='" + uploadTime + '\'' +
                ", pic='" + pic + '\'' +
                ", title='" + title + '\'' +
                ", play='" + play + '\'' +
                ", danmaku='" + danmaku + '\'' +
                '}';
    }
}
