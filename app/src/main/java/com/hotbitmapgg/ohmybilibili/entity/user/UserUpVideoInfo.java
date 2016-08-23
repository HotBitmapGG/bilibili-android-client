package com.hotbitmapgg.ohmybilibili.entity.user;

import java.util.List;

/**
 * Created by hcc on 16/8/15 21:06
 * 100332338@qq.com
 * <p/>
 * 用户上传的所有视频
 */
public class UserUpVideoInfo
{

    /**
     * aid : 5682645
     * copyright : Original
     * typeid : 154
     * title : 【咬人猫】落花情❤ o(*≧▽≦)ツ
     * subtitle :
     * play : 806713
     * review : 6553
     * video_review : 9918
     * favorites : 26975
     * mid : 116683
     * author : =咬人猫=
     * description : 也许是有史以来最忐忑的一次投稿，这次尝试的风格对我来说挑战很大，完全没有这类舞蹈的基础，所以当时这支舞挖坑填了一段时间因为实在是能力有限，被我搁置了很久～后来因为确实是太喜欢这种感觉的舞蹈了，又重新鼓起劲去学，也尝试了不同的服装版本录制了很多次，非常想完成这一支舞，虽然还有很多地方不够好，也希望大家多多包涵，谢谢大家的支持和等待～
     * 服装：七秀萝莉定国套
     * 舞蹈歌曲：七朵组合（一代）的作品《落花情》。
     * created : 2016-08-06 20:20:45
     * pic : http://i0.hdslb.com/bfs/archive/a96729ac9e0a14544d1fcdb1471d23cf7ac1e61b.jpg
     * comment : 9918
     * length : 03:46
     */

    private List<VlistBean> vlist;

    public List<VlistBean> getVlist()
    {

        return vlist;
    }

    public void setVlist(List<VlistBean> vlist)
    {

        this.vlist = vlist;
    }

    public static class VlistBean
    {

        private int aid;

        private String copyright;

        private int typeid;

        private String title;

        private String subtitle;

        private int play;

        private int review;

        private int video_review;

        private int favorites;

        private int mid;

        private String author;

        private String description;

        private String created;

        private String pic;

        private int comment;

        private String length;

        public int getAid()
        {

            return aid;
        }

        public void setAid(int aid)
        {

            this.aid = aid;
        }

        public String getCopyright()
        {

            return copyright;
        }

        public void setCopyright(String copyright)
        {

            this.copyright = copyright;
        }

        public int getTypeid()
        {

            return typeid;
        }

        public void setTypeid(int typeid)
        {

            this.typeid = typeid;
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

        public String getCreated()
        {

            return created;
        }

        public void setCreated(String created)
        {

            this.created = created;
        }

        public String getPic()
        {

            return pic;
        }

        public void setPic(String pic)
        {

            this.pic = pic;
        }

        public int getComment()
        {

            return comment;
        }

        public void setComment(int comment)
        {

            this.comment = comment;
        }

        public String getLength()
        {

            return length;
        }

        public void setLength(String length)
        {

            this.length = length;
        }
    }
}
