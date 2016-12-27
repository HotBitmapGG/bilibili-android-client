package com.hotbitmapgg.bilibili.entity.discover;

import java.util.List;

/**
 * Created by hcc on 2016/10/3 19:03
 * 100332338@qq.com
 * <p>
 * 活动中心模型类
 */

public class ActivityCenterInfo {

  /**
   * code : 0
   * list : [{"title":"「大鱼海棠」剧情重生Project","cover":"http://i0.hdslb.com/group1/M00/B8/17/oYYBAFfvGRKAVOWgAAJvfCILnj4536.jpg","link":"http://www.bilibili.com/html/activity-dayuhaitang-m.html","state":0},{"title":"[夏日延长线2]本家争霸赛","cover":"http://i0.hdslb.com/group1/M00/B8/0E/oYYBAFfo3iCAT6atAALttyYanS4370.jpg","link":"http://www.bilibili.com/html/activity-VocaloidCover-m.html","state":0},{"title":"中秋来看天降月饼","cover":"http://i0.hdslb.com/group1/M00/B8/04/oYYBAFfZPIiAMV3_AAD-fjINt54887.jpg","link":"http://www.bilibili.com/html/activity-midautumn2016.html","state":1},{"title":"TGS2016之去了没去","cover":"http://i1.hdslb.com/event/24771327191327145087ac802c5d6d95.jpg","link":"http://www.bilibili.com/html/activity-TGS2016-m.html","state":1},{"title":"2233的一天","cover":"http://i1.hdslb.com/event/efe38f9905e4b4b022930ed0af87609f.jpg","link":"http://www.bilibili.com/html/activity-2233birthday-m.html","state":1},{"title":"噗尼噗尼之小电视来袭","cover":"http://i2.hdslb.com/event/7152b7d7a36997215dcec5225bbc1088.jpg","link":"http://www.bilibili.com/html/activity-punipuni3-m.html","state":1},{"title":"「我来说电影」影评杂谈大赛","cover":"http://i0.hdslb.com/group1/M00/B7/B7/oYYBAFePFzaARpF2AAIitDzIF-g511.jpg","link":"http://www.bilibili.com/html/activity-cinecism-m.html","state":1},{"title":"【番剧异闻录】秘技·我有姿势我自豪","cover":"http://i0.hdslb.com/group1/M00/B7/AE/oYYBAFeFrOOATVKwAAQCbARIANc340.jpg","link":"http://www.bilibili.com/html/activity-coolest-m.html","state":1},{"title":"2016夏夜鬼畜大赏","cover":"http://i0.hdslb.com/group1/M00/B7/A4/oYYBAFd-BQOAWxN8AAD5HjQ0iZ8565.jpg","link":"http://www.bilibili.com/html/activity-Kichiku2016-m.html","state":1},{"title":"bilibili
   * MAD 创作大赛 2016","cover":"http://i0.hdslb.com/group1/M00/B7/EB/oYYBAFfD0K6AMhxZAAO6Eg12OEg632.jpg","link":"http://www.bilibili.com/html/activity-MAD2016-m.html","state":1},{"title":"Kira☆Kira
   * COS仿妆大比拼","cover":"http://i0.hdslb.com/group1/M00/B7/A4/oYYBAFd-BmuAUrojAAQqbkZoyHw829.jpg","link":"http://www.bilibili.com/html/activity-KiraKira-m.html","state":1},{"title":"黄绿合战","cover":"http://i0.hdslb.com/group1/M00/B7/A4/oYYBAFd-BtCAKuxiAAUQJRin_w0597.jpg","link":"http://www.bilibili.com/html/activity-yellow_VS_green-m.html","state":1},{"title":"天下第一发呆大会","cover":"http://i0.hdslb.com/group1/M00/B7/A4/oYYBAFd-BxWAcQSSAAQmGQ07lFM163.jpg","link":"http://www.bilibili.com/html/activity-spaceout-m.html","state":1},{"title":"五一脑洞节","cover":"http://i0.hdslb.com/group1/M00/B7/A4/oYYBAFd-B4OABihzAAKgqVX54Mk208.jpg","link":"http://www.bilibili.com/html/activity-Mindblowing-m.html","state":1},{"title":"AnimeJapan2016现场报道","cover":"http://i0.hdslb.com/group1/M00/B7/A4/oYYBAFd-CBWADZm-AAQxbjHiAUY948.jpg","link":"http://www.bilibili.com/html/activity-animejp2016-m.html","state":1},{"title":"Bilibili
   * Dancing Festival 2016","cover":"http://i0.hdslb.com/group1/M00/B7/A4/oYYBAFd-CD-AOZ9jAAkzQjnp7mg350.jpg","link":"http://www.bilibili.com/html/BDF2016-m.html","state":1},{"title":"西洋乐器演奏大赛","cover":"http://i0.hdslb.com/group1/M00/B7/A4/oYYBAFd-CGmAKMkDAAWpyHL0S7Y276.jpg","link":"http://www.bilibili.com/html/m-instruments.html","state":1},{"title":"表情还原大作战","cover":"http://i0.hdslb.com/group1/M00/B7/A4/oYYBAFd-CICANbi-AASnkk0V-ks536.jpg","link":"http://www.bilibili.com/html/emotiom-m.html","state":1},{"title":"元宵赏灯会","cover":"http://i0.hdslb.com/group1/M00/B7/A4/oYYBAFd-CKCAMO5hAASwUGalOoY237.jpg","link":"http://www.bilibili.com/html/m-tlf2016.html","state":1},{"title":"Bilibili&MCbbs擂台赛","cover":"http://i0.hdslb.com/group1/M00/B7/A4/oYYBAFd-CT2ACqaZAAMfUhj_7Po081.jpg","link":"http://www.bilibili.com/html/m-mcbattle.html","state":1}]
   * total : 28
   * pages : 2
   */

  private int code;

  private int total;

  private int pages;

  /**
   * title : 「大鱼海棠」剧情重生Project
   * cover : http://i0.hdslb.com/group1/M00/B8/17/oYYBAFfvGRKAVOWgAAJvfCILnj4536.jpg
   * link : http://www.bilibili.com/html/activity-dayuhaitang-m.html
   * state : 0
   */

  private List<ListBean> list;


  public int getCode() {

    return code;
  }


  public void setCode(int code) {

    this.code = code;
  }


  public int getTotal() {

    return total;
  }


  public void setTotal(int total) {

    this.total = total;
  }


  public int getPages() {

    return pages;
  }


  public void setPages(int pages) {

    this.pages = pages;
  }


  public List<ListBean> getList() {

    return list;
  }


  public void setList(List<ListBean> list) {

    this.list = list;
  }


  public static class ListBean {

    private String title;

    private String cover;

    private String link;

    private int state;


    public String getTitle() {

      return title;
    }


    public void setTitle(String title) {

      this.title = title;
    }


    public String getCover() {

      return cover;
    }


    public void setCover(String cover) {

      this.cover = cover;
    }


    public String getLink() {

      return link;
    }


    public void setLink(String link) {

      this.link = link;
    }


    public int getState() {

      return state;
    }


    public void setState(int state) {

      this.state = state;
    }
  }
}
