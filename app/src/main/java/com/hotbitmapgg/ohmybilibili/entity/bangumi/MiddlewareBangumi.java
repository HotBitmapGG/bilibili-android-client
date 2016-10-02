package com.hotbitmapgg.ohmybilibili.entity.bangumi;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hcc on 2016/10/2 15:08
 * 100332338@qq.com
 * <p>
 * 跳转番剧详情中间模型类
 * 根据不同接口传递需要的参数
 */

public class MiddlewareBangumi implements Parcelable
{

    //aid
    private String aid;

    //标题
    private String title;

    //播放数量
    private int play;

    //追番数量
    private int favorites;

    //番剧详情
    private String description;

    //番剧图片
    private String pic;

    //番剧season_id
    private int season_id;

    //番剧spid
    private int spid;

    //番剧更新星期日期
    private int weekday;

    //番剧创建时间
    private String create;

    //番剧总集数
    private int count;

    public String getAid()
    {

        return aid;
    }

    public void setAid(String aid)
    {

        this.aid = aid;
    }

    public String getTitle()
    {

        return title;
    }

    public void setTitle(String title)
    {

        this.title = title;
    }

    public int getPlay()
    {

        return play;
    }

    public void setPlay(int play)
    {

        this.play = play;
    }

    public int getFavorites()
    {

        return favorites;
    }

    public void setFavorites(int favorites)
    {

        this.favorites = favorites;
    }

    public String getDescription()
    {

        return description;
    }

    public void setDescription(String description)
    {

        this.description = description;
    }

    public int getSeason_id()
    {

        return season_id;
    }

    public void setSeason_id(int season_id)
    {

        this.season_id = season_id;
    }

    public String getPic()
    {

        return pic;
    }

    public void setPic(String pic)
    {

        this.pic = pic;
    }

    public int getSpid()
    {

        return spid;
    }

    public void setSpid(int spid)
    {

        this.spid = spid;
    }

    public int getWeekday()
    {

        return weekday;
    }

    public void setWeekday(int weekday)
    {

        this.weekday = weekday;
    }

    public String getCreate()
    {

        return create;
    }

    public void setCreate(String create)
    {

        this.create = create;
    }

    public int getCount()
    {

        return count;
    }

    public void setCount(int count)
    {

        this.count = count;
    }


    @Override
    public int describeContents()
    {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {

        dest.writeString(this.aid);
        dest.writeString(this.title);
        dest.writeInt(this.play);
        dest.writeInt(this.favorites);
        dest.writeString(this.description);
        dest.writeString(this.pic);
        dest.writeInt(this.season_id);
        dest.writeInt(this.spid);
        dest.writeInt(this.weekday);
        dest.writeString(this.create);
        dest.writeInt(this.count);
    }

    public MiddlewareBangumi()
    {

    }

    protected MiddlewareBangumi(Parcel in)
    {

        this.aid = in.readString();
        this.title = in.readString();
        this.play = in.readInt();
        this.favorites = in.readInt();
        this.description = in.readString();
        this.pic = in.readString();
        this.season_id = in.readInt();
        this.spid = in.readInt();
        this.weekday = in.readInt();
        this.create = in.readString();
        this.count = in.readInt();
    }

    public static final Parcelable.Creator<MiddlewareBangumi> CREATOR = new Parcelable.Creator<MiddlewareBangumi>()
    {

        @Override
        public MiddlewareBangumi createFromParcel(Parcel source)
        {

            return new MiddlewareBangumi(source);
        }

        @Override
        public MiddlewareBangumi[] newArray(int size)
        {

            return new MiddlewareBangumi[size];
        }
    };
}
