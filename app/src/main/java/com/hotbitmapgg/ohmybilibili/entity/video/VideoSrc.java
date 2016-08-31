package com.hotbitmapgg.ohmybilibili.entity.video;

/**
 * Created by hcc on 16/8/22 20:48
 * 100332338@qq.com
 * <p/>
 * 视频地址数据
 */
public class VideoSrc
{

    // 视频预览
    private String img;

    // 弹幕文件
    private String cid;

    // 视频源地址
    private String src;

    public String getImg()
    {

        return img;
    }

    public void setImg(String img)
    {

        this.img = img;
    }

    public String getCid()
    {

        return cid;
    }

    public void setCid(String cid)
    {

        this.cid = cid;
    }

    public String getSrc()
    {

        return src;
    }

    public void setSrc(String src)
    {

        this.src = src;
    }

    @Override
    public String toString()
    {

        return "VideoSrc{" +
                "img='" + img + '\'' +
                ", cid='" + cid + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
