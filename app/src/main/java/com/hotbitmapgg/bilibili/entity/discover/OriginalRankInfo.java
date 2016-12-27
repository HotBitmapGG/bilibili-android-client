package com.hotbitmapgg.bilibili.entity.discover;

import java.util.List;

/**
 * Created by hcc on 2016/9/22 18:44
 * 100332338@qq.com
 * <p>
 * 原创排行榜模型类
 */

public class OriginalRankInfo {

  private RankBean rank;


  public RankBean getRank() {

    return rank;
  }


  public void setRank(RankBean rank) {

    this.rank = rank;
  }


  public static class RankBean {

    private String note;

    private int code;

    private int pages;

    private int num;

    /**
     * aid : 6482189
     * typename : 鬼畜调教
     * title : 【高能Rap】你从未看过的家有儿女
     * subtitle :
     * play : 642497
     * review : 48
     * video_review : 12428
     * favorites : 43142
     * mid : 375375
     * author : 伊丽莎白鼠
     * description : 花了2个多月终于把这个大坑填完了，顺便也把小时候很喜欢的家有儿女复习了一遍，果然小时候还是太纯洁，长大之后发现了许多有意思的地方，       *
     * 值得当代年轻人细细回味学习。只可惜自己已经不如晚年，不知道下次做鬼畜又是什么时候了，不得不说，做鬼畜真有意思。
     * <p>
     * BGM：Unity - TheFatRat
     * <p>
     * 营销号简直要逼死我，这次上了动态水印，转载请勿遮挡水印并注明出处。
     * create : 2016-10-01 13:52
     * pic : http://i1.hdslb.com/bfs/archive/4e812d44fcfd9fcadcaf1195d28eb24bc63eaccc.jpg_320x200.jpg
     * coins : 65355
     * duration : 2:30
     * badgepay : false
     * pts : 880957
     */

    private List<ListBean> list;


    public String getNote() {

      return note;
    }


    public void setNote(String note) {

      this.note = note;
    }


    public int getCode() {

      return code;
    }


    public void setCode(int code) {

      this.code = code;
    }


    public int getPages() {

      return pages;
    }


    public void setPages(int pages) {

      this.pages = pages;
    }


    public int getNum() {

      return num;
    }


    public void setNum(int num) {

      this.num = num;
    }


    public List<ListBean> getList() {

      return list;
    }


    public void setList(List<ListBean> list) {

      this.list = list;
    }


    public static class ListBean {

      private int aid;

      private String typename;

      private String title;

      private String subtitle;

      private String play;

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

      private boolean badgepay;

      private int pts;


      public int getAid() {

        return aid;
      }


      public void setAid(int aid) {

        this.aid = aid;
      }


      public String getTypename() {

        return typename;
      }


      public void setTypename(String typename) {

        this.typename = typename;
      }


      public String getTitle() {

        return title;
      }


      public void setTitle(String title) {

        this.title = title;
      }


      public String getSubtitle() {

        return subtitle;
      }


      public void setSubtitle(String subtitle) {

        this.subtitle = subtitle;
      }


      public String getPlay() {

        return play;
      }


      public void setPlay(String play) {

        this.play = play;
      }


      public int getReview() {

        return review;
      }


      public void setReview(int review) {

        this.review = review;
      }


      public int getVideo_review() {

        return video_review;
      }


      public void setVideo_review(int video_review) {

        this.video_review = video_review;
      }


      public int getFavorites() {

        return favorites;
      }


      public void setFavorites(int favorites) {

        this.favorites = favorites;
      }


      public int getMid() {

        return mid;
      }


      public void setMid(int mid) {

        this.mid = mid;
      }


      public String getAuthor() {

        return author;
      }


      public void setAuthor(String author) {

        this.author = author;
      }


      public String getDescription() {

        return description;
      }


      public void setDescription(String description) {

        this.description = description;
      }


      public String getCreate() {

        return create;
      }


      public void setCreate(String create) {

        this.create = create;
      }


      public String getPic() {

        return pic;
      }


      public void setPic(String pic) {

        this.pic = pic;
      }


      public int getCoins() {

        return coins;
      }


      public void setCoins(int coins) {

        this.coins = coins;
      }


      public String getDuration() {

        return duration;
      }


      public void setDuration(String duration) {

        this.duration = duration;
      }


      public boolean isBadgepay() {

        return badgepay;
      }


      public void setBadgepay(boolean badgepay) {

        this.badgepay = badgepay;
      }


      public int getPts() {

        return pts;
      }


      public void setPts(int pts) {

        this.pts = pts;
      }
    }
  }
}
