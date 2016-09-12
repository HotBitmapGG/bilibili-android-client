package com.hotbitmapgg.ohmybilibili.entity.rank;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by hcc on 16/9/12 20:22
 * 100332338@qq.com
 * <p/>
 * 全区排行榜模型类
 */
public class AllRankInfo
{

    @SerializedName("sort_name")
    private String sortName;


    private ArrayList<Videos> videos;


    public String getSortName()
    {

        return this.sortName;
    }

    public void setSortName(String sortName)
    {

        this.sortName = sortName;
    }

    public ArrayList<Videos> getVideos()
    {

        return this.videos;
    }

    public void setVideos(ArrayList<Videos> videos)
    {

        this.videos = videos;
    }


    public class Videos
    {

        private String description;

        @SerializedName("video_review")
        private int videoReview;

        private String title;

        private int favorites;

        private int mid;

        private String duration;

        private boolean badgepay;

        private String typename;

        private String create;

        private String aid;

        private String pic;

        private int play;

        private String subtitle;

        private int coins;

        private int credit;

        private int typeid;

        private String copyright;

        private int comment;

        private int review;

        private String author;

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

        public int getVideoReview()
        {

            return videoReview;
        }

        public void setVideoReview(int videoReview)
        {

            this.videoReview = videoReview;
        }

        public int getFavorites()
        {

            return favorites;
        }

        public void setFavorites(int favorites)
        {

            this.favorites = favorites;
        }

        public int getMid()
        {

            return mid;
        }

        public void setMid(int mid)
        {

            this.mid = mid;
        }

        public String getDuration()
        {

            return duration;
        }

        public void setDuration(String duration)
        {

            this.duration = duration;
        }

        public boolean isBadgepay()
        {

            return badgepay;
        }

        public void setBadgepay(boolean badgepay)
        {

            this.badgepay = badgepay;
        }

        public String getTypename()
        {

            return typename;
        }

        public void setTypename(String typename)
        {

            this.typename = typename;
        }

        public String getCreate()
        {

            return create;
        }

        public void setCreate(String create)
        {

            this.create = create;
        }

        public String getAid()
        {

            return aid;
        }

        public void setAid(String aid)
        {

            this.aid = aid;
        }

        public String getPic()
        {

            return pic;
        }

        public void setPic(String pic)
        {

            this.pic = pic;
        }

        public int getPlay()
        {

            return play;
        }

        public void setPlay(int play)
        {

            this.play = play;
        }

        public int getCoins()
        {

            return coins;
        }

        public void setCoins(int coins)
        {

            this.coins = coins;
        }

        public String getSubtitle()
        {

            return subtitle;
        }

        public void setSubtitle(String subtitle)
        {

            this.subtitle = subtitle;
        }

        public int getCredit()
        {

            return credit;
        }

        public void setCredit(int credit)
        {

            this.credit = credit;
        }

        public int getTypeid()
        {

            return typeid;
        }

        public void setTypeid(int typeid)
        {

            this.typeid = typeid;
        }

        public String getCopyright()
        {

            return copyright;
        }

        public void setCopyright(String copyright)
        {

            this.copyright = copyright;
        }

        public int getComment()
        {

            return comment;
        }

        public void setComment(int comment)
        {

            this.comment = comment;
        }

        public int getReview()
        {

            return review;
        }

        public void setReview(int review)
        {

            this.review = review;
        }

        public String getAuthor()
        {

            return author;
        }

        public void setAuthor(String author)
        {

            this.author = author;
        }
    }
}
