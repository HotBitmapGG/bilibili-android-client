package com.hotbitmapgg.bilibili.entity.discover;

import java.util.List;

/**
 * Created by hcc on 2016/10/3 15:47
 * 100332338@qq.com
 * <p>
 * 话题中心模型类
 */

public class TopicCenterInfo {

  /**
   * code : 0
   * list : [{"title":"bilibili 2017元宵晚会 征稿安利书","cover":"http://i0.hdslb.com/group1/M00/B8/19/oYYBAFfwvkSAOYRgAAUjD1nfH7Y262.jpg","link":"http://www.bilibili.com/topic/v2/phone1551.html"},{"title":"国庆七天躁起来\u2014\u2014单身vs现充","cover":"http://i0.hdslb.com/group1/M00/B8/16/oYYBAFfuVD6AS7txAAMm9XeR5zo160.jpg","link":"http://www.bilibili.com/topic/v2/phone1548.html"},{"title":"频道精选
   * 生活区 No.31","cover":"","link":""},{"title":"频道精选  鬼畜区 No.29","cover":"","link":""},{"title":"鬼畜区冷门作品推荐No.007","cover":"","link":""},{"title":"国漫振兴
   *  青春助力","cover":"http://i0.hdslb.com/group1/M00/B8/15/oYYBAFft_3aANMrPAAW2CWe3dgI937.jpg","link":"http://www.bilibili.com/topic/v2/phone1543.html"},{"title":"国庆七天嗨起来\u2014\u2014宅家派vs驴友派","cover":"http://i0.hdslb.com/group1/M00/B8/12/oYYBAFfsqMmAOEb3AAHN2Hnol18304.jpg","link":"http://www.bilibili.com/topic/v2/phone1540.html"},{"title":"紧张刺激的地球OL
   * \u2014\u2014世界各服高手玩家们的大比拼","cover":"http://i0.hdslb.com/group1/M00/B8/12/oYYBAFfrwNmACVOaAANsHhhyVcE444.jpg","link":"http://www.bilibili.com/topic/v2/phone1538.html"},{"title":"来一场狂野派对biubiubiu","cover":"http://i0.hdslb.com/group1/M00/B8/0E/oYYBAFfoy_2AAWCuAAU4Ik8UEvM174.jpg","link":"http://www.bilibili.com/topic/v2/phone1537.html"},{"title":"和地板来个亲密接触吧","cover":"http://i0.hdslb.com/group1/M00/B8/0E/oYYBAFfnkIyAIIURAAGld3qs_hA390.jpg","link":"http://www.bilibili.com/topic/v2/phone1535.html"},{"title":"论黑人的RAP天赋②","cover":"http://i0.hdslb.com/group1/M00/B8/0C/oYYBAFfmOQmAaEP2AANxFmyeoBM983.jpg","link":"http://www.bilibili.com/topic/v2/phone1534.html"},{"title":"鬼畜区冷门作品推荐No.006","cover":"","link":""},{"title":"Fate/Infinite
   * Tales EP.3 伪物真传","cover":"http://i0.hdslb.com/group1/M00/B8/0B/oYYBAFfkzN-AbfwkAASdb0tv_fY221.jpg","link":"http://www.bilibili.com/html/activity-20160923fgo.html"},{"title":"频道精选
   *  鬼畜区 No.28","cover":"","link":""},{"title":"这是一个简单V家科普帖(里面没有活动预告)","cover":"http://i0.hdslb.com/group1/M00/B8/0A/oYYBAFfjrkaANvveAAI1ZGA5y2w125.jpg","link":"http://www.bilibili.com/topic/v2/phone1528.html"},{"title":"不科学的B站广告","cover":"http://i0.hdslb.com/group1/M00/B8/09/oYYBAFfiWXaAQM4aAALSWRGQarI993.jpg","link":"http://www.bilibili.com/topic/v2/phone1526.html"},{"title":"频道精选
   * 生活区 No.30","cover":"","link":""},{"title":"回归动画本身\u2014\u2014浅谈作画MAD","cover":"","link":""},{"title":"你喜欢哪只旗袍娘？","cover":"http://i0.hdslb.com/group1/M00/B8/07/oYYBAFffoX-ACDVqAAVuPR0ZqwY873.jpg","link":"http://www.bilibili.com/topic/v2/phone1522.html"},{"title":"BDC
   * EP41","cover":"http://i0.hdslb.com/group1/M00/B8/05/oYYBAFfdEfyAHEgxAAGMBy31fNQ427.jpg","link":"http://www.bilibili.com/topic/v2/phone1520.html"}]
   * total : 137
   * pages : 7
   */

  private int code;

  private int total;

  private int pages;

  /**
   * title : bilibili 2017元宵晚会 征稿安利书
   * cover : http://i0.hdslb.com/group1/M00/B8/19/oYYBAFfwvkSAOYRgAAUjD1nfH7Y262.jpg
   * link : http://www.bilibili.com/topic/v2/phone1551.html
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
  }
}
