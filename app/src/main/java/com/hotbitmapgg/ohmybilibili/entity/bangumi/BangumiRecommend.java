package com.hotbitmapgg.ohmybilibili.entity.bangumi;

import java.util.List;

/**
 * Created by hcc on 16/8/6 11:08
 * 100332338@qq.com
 * <p/>
 * 新番推荐
 */
public class BangumiRecommend
{


    /**
     * title : 弹丸论破3
     * link : http://www.bilibili.com/bangumi/i/5057
     * img : http://i0.hdslb.com/bfs/archive/2544570de993a38263bef30878cc5f825d361098.jpg
     * simg :
     * aid : 0
     * type : link
     * platform : 0
     * pid : 0
     */

    private List<BannersBean> banners;

    /**
     * aid : 5652556
     * title : 【OVA】无头骑士异闻录×2 结 19.5话【豌豆】
     * subtitle :
     * play : 6927
     * review : 164
     * video_review : 2327
     * favorites : 1093
     * mid : 223902
     * author : 空灵雨迹
     * description : ~ 19.5话
     * create : 2016-08-04 22:35
     * pic : http://i1.hdslb.com/bfs/archive/0b617369d627d3e7f618587dbdd02d6dfee06fbe.jpg_320x200.jpg
     * coins : 174
     * duration : 23:48
     */

    private List<RecommendsBean> recommends;

    public List<BannersBean> getBanners()
    {

        return banners;
    }

    public void setBanners(List<BannersBean> banners)
    {

        this.banners = banners;
    }

    public List<RecommendsBean> getRecommends()
    {

        return recommends;
    }

    public void setRecommends(List<RecommendsBean> recommends)
    {

        this.recommends = recommends;
    }

    public static class BannersBean
    {

        private String title;

        private String link;

        private String img;

        private String simg;

        private int aid;

        private String type;

        private int platform;

        private int pid;

        public String getTitle()
        {

            return title;
        }

        public void setTitle(String title)
        {

            this.title = title;
        }

        public String getLink()
        {

            return link;
        }

        public void setLink(String link)
        {

            this.link = link;
        }

        public String getImg()
        {

            return img;
        }

        public void setImg(String img)
        {

            this.img = img;
        }

        public String getSimg()
        {

            return simg;
        }

        public void setSimg(String simg)
        {

            this.simg = simg;
        }

        public int getAid()
        {

            return aid;
        }

        public void setAid(int aid)
        {

            this.aid = aid;
        }

        public String getType()
        {

            return type;
        }

        public void setType(String type)
        {

            this.type = type;
        }

        public int getPlatform()
        {

            return platform;
        }

        public void setPlatform(int platform)
        {

            this.platform = platform;
        }

        public int getPid()
        {

            return pid;
        }

        public void setPid(int pid)
        {

            this.pid = pid;
        }
    }

    public static class RecommendsBean
    {

        private String aid;

        private String title;

        private String subtitle;

        private int play;

        private int review;

        private int video_review;

        private int favorites;

        private int mid;

        private String author;

        private String description;

        private String create;

        private String pic;

        private int coins;

        private String duration;

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

        public String getSubtitle()
        {

            return subtitle;
        }

        public void setSubtitle(String subtitle)
        {

            this.subtitle = subtitle;
        }

        public int getPlay()
        {

            return play;
        }

        public void setPlay(int play)
        {

            this.play = play;
        }

        public int getReview()
        {

            return review;
        }

        public void setReview(int review)
        {

            this.review = review;
        }

        public int getVideo_review()
        {

            return video_review;
        }

        public void setVideo_review(int video_review)
        {

            this.video_review = video_review;
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

        public String getAuthor()
        {

            return author;
        }

        public void setAuthor(String author)
        {

            this.author = author;
        }

        public String getDescription()
        {

            return description;
        }

        public void setDescription(String description)
        {

            this.description = description;
        }

        public String getCreate()
        {

            return create;
        }

        public void setCreate(String create)
        {

            this.create = create;
        }

        public String getPic()
        {

            return pic;
        }

        public void setPic(String pic)
        {

            this.pic = pic;
        }

        public int getCoins()
        {

            return coins;
        }

        public void setCoins(int coins)
        {

            this.coins = coins;
        }

        public String getDuration()
        {

            return duration;
        }

        public void setDuration(String duration)
        {

            this.duration = duration;
        }
    }
}
