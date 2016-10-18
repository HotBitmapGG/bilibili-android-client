package com.hotbitmapgg.ohmybilibili.entity.video;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hcc on 16/8/8 10:09
 * 100332338@qq.com
 * <p/>
 * 新使用接口的视频详情数据
 * 不需要AppKey
 */
public class VideoDetails implements Parcelable
{

    /**
     * tid : 76
     * typename : 美食圈
     * arctype : Original
     * play : 772715
     * review : 2428
     * video_review : 17921
     * favorites : 2514
     * title : 【拂菻坊】中英泰三国反应大揭秘：榴莲是个什么鬼？
     * description : 自制
     * 【拂菻坊】大家好！坊糖们好！今天为了拯救世界我让英泰中三国吃榴莲以及榴莲披萨，希望你喜欢！喜欢的话给我投硬币！不要忘记在b站关注榴莲君。如果有兴趣可以在世博园参加活动有机会WIN bml的门票！
     * <p/>
     * 拂菻坊购物网站：www.fulinfang.com
     * <p/>
     * 在微博：weibo.com/u/5690970823/
     * 在微信：fulinfangcom
     * <p/>
     * tag : 泰国,英国,榴莲,防不胜防系列,拂菻坊,各位再见我要去泰国找女朋友了,上个签证视频去哪里？,全世界都在说中文系列,签证被夫人烧成渣
     * pic : http://i1.hdslb.com/bfs/archive/3bab9ce3c9f60be5e37811a90bb267866635fa4e.jpg
     * author : 拂菻坊
     * mid : 15834498
     * face : http://i0.hdslb.com/bfs/face/59caded2aa9e6f0350ec41d4d57ad7c8835265b9.jpg
     * pages : 0
     * created_at : 2016-07-04 13:01
     * coins : 6025
     * list : {"0":{"page":1,"type":"vupload","part":"","cid":8444834,"vid":0}}
     */

    private int tid;

    private String typename;

    private String arctype;

    private String play;

    private String review;

    private String video_review;

    private String favorites;

    private String title;

    private String description;

    private String tag;

    private String pic;

    private String author;

    private String mid;

    private String face;

    private int pages;

    private String created_at;

    private String coins;

    public int getTid()
    {

        return tid;
    }

    public void setTid(int tid)
    {

        this.tid = tid;
    }

    public String getTypename()
    {

        return typename;
    }

    public void setTypename(String typename)
    {

        this.typename = typename;
    }

    public String getArctype()
    {

        return arctype;
    }

    public void setArctype(String arctype)
    {

        this.arctype = arctype;
    }

    public String getReview()
    {

        return review;
    }

    public void setReview(String review)
    {

        this.review = review;
    }

    public String getPlay()
    {

        return play;
    }

    public void setPlay(String play)
    {

        this.play = play;
    }

    public String getVideo_review()
    {

        return video_review;
    }

    public void setVideo_review(String video_review)
    {

        this.video_review = video_review;
    }

    public String getFavorites()
    {

        return favorites;
    }

    public void setFavorites(String favorites)
    {

        this.favorites = favorites;
    }

    public String getTitle()
    {

        return title;
    }

    public void setTitle(String title)
    {

        this.title = title;
    }

    public String getDescription()
    {

        return description;
    }

    public void setDescription(String description)
    {

        this.description = description;
    }

    public String getTag()
    {

        return tag;
    }

    public void setTag(String tag)
    {

        this.tag = tag;
    }

    public String getAuthor()
    {

        return author;
    }

    public void setAuthor(String author)
    {

        this.author = author;
    }

    public String getPic()
    {

        return pic;
    }

    public void setPic(String pic)
    {

        this.pic = pic;
    }

    public String getMid()
    {

        return mid;
    }

    public void setMid(String mid)
    {

        this.mid = mid;
    }

    public String getFace()
    {

        return face;
    }

    public void setFace(String face)
    {

        this.face = face;
    }

    public int getPages()
    {

        return pages;
    }

    public void setPages(int pages)
    {

        this.pages = pages;
    }

    public String getCreated_at()
    {

        return created_at;
    }

    public void setCreated_at(String created_at)
    {

        this.created_at = created_at;
    }

    public String getCoins()
    {

        return coins;
    }

    public void setCoins(String coins)
    {

        this.coins = coins;
    }


    /**
     * 0 : {"page":1,"type":"vupload","part":"","cid":8444834,"vid":0}
     */

    private VideoList list;

    public class VideoList
    {

        @SerializedName("0")
        public VideoAdditional videoAdditional;

        public class VideoAdditional
        {

            public int cid;
        }
    }

    public VideoList getList()
    {

        return list;
    }

    public void setList(VideoList list)
    {

        this.list = list;
    }

    @Override
    public int describeContents()
    {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {

        dest.writeInt(this.tid);
        dest.writeString(this.typename);
        dest.writeString(this.arctype);
        dest.writeString(this.play);
        dest.writeString(this.review);
        dest.writeString(this.video_review);
        dest.writeString(this.favorites);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.tag);
        dest.writeString(this.pic);
        dest.writeString(this.author);
        dest.writeString(this.mid);
        dest.writeString(this.face);
        dest.writeInt(this.pages);
        dest.writeString(this.created_at);
        dest.writeString(this.coins);
    }

    public VideoDetails()
    {

    }

    protected VideoDetails(Parcel in)
    {

        this.tid = in.readInt();
        this.typename = in.readString();
        this.arctype = in.readString();
        this.play = in.readString();
        this.review = in.readString();
        this.video_review = in.readString();
        this.favorites = in.readString();
        this.title = in.readString();
        this.description = in.readString();
        this.tag = in.readString();
        this.pic = in.readString();
        this.author = in.readString();
        this.mid = in.readString();
        this.face = in.readString();
        this.pages = in.readInt();
        this.created_at = in.readString();
        this.coins = in.readString();
    }

    public static final Parcelable.Creator<VideoDetails> CREATOR = new Parcelable.Creator<VideoDetails>()
    {

        @Override
        public VideoDetails createFromParcel(Parcel source)
        {

            return new VideoDetails(source);
        }

        @Override
        public VideoDetails[] newArray(int size)
        {

            return new VideoDetails[size];
        }
    };
}
