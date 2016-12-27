package com.hotbitmapgg.bilibili.entity.user;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 2016/10/12 17:11
 * 100332338@qq.com
 * <p>
 * 用户投稿视频模型类
 */

public class UserContributeInfo implements Parcelable {

  /**
   * status : true
   * data : {"vlist":[{"aid":6624924,"copyright":"Original","typeid":47,"title":"【平纪】齐木楠雄的灾难第一弹（上海话）","subtitle":"","play":35401,"review":263,"video_review":251,"favorites":413,"mid":4835752,"author":"真纪","description":"平纪公众号搜索：平纪工作室","created":"2016-10-10
   * 18:49:01","pic":"http://i0.hdslb.com/bfs/archive/28fb49ad13679e841239b85907194043446fac75.jpg","comment":251,"length":"05:13"},{"aid":6585652,"copyright":"Original","typeid":138,"title":"【平纪】老板！我要上班！（上海话）","subtitle":"","play":39125,"review":234,"video_review":337,"favorites":564,"mid":4835752,"author":"真纪","description":"平纪公众号搜索：平纪工作室","created":"2016-10-07
   * 18:11:05","pic":"http://i0.hdslb.com/bfs/archive/60412346892b5e20cbccf2f5cfd3c2984836c3ab.jpg","comment":337,"length":"01:16"},{"aid":6436271,"copyright":"Original","typeid":47,"title":"【平纪】Pokemon第三弹
   *  不爆肝想玩好国产游戏？（上海话）","subtitle":"","play":367242,"review":759,"video_review":2535,"favorites":8404,"mid":4835752,"author":"真纪","description":"平纪公众号搜索：平纪工作室","created":"2016-09-27
   * 16:10:02","pic":"http://i0.hdslb.com/bfs/archive/c2aad69c27567260ce4a309f78ceb0241a9a3f67.jpg","comment":2535,"length":"05:14"},{"aid":6273716,"copyright":"Original","typeid":47,"title":"【平纪】你大概会买东西（上海话）","subtitle":"","play":62745,"review":177,"video_review":590,"favorites":570,"mid":4835752,"author":"真纪","description":"平纪公众号搜索:
   * 平纪工作室","created":"2016-09-14 16:45:19","pic":"http://i0.hdslb.com/bfs/archive/d919c9c479b86777b9fd2b9a955776ddbbec17a8.jpg","comment":590,"length":"07:48"},{"aid":6227637,"copyright":"Original","typeid":82,"title":"【平纪】坑特弄\u2014\u2014\u201c阿扎·李\u201d（上海话）","subtitle":"","play":28313,"review":145,"video_review":272,"favorites":207,"mid":4835752,"author":"真纪","description":"平纪公众号搜索：平纪工作室","created":"2016-09-10
   * 19:18:02","pic":"http://i0.hdslb.com/bfs/archive/e92b0753c1dc38c2b3554e79adb5b5da0ad80b15.jpg","comment":272,"length":"06:02"},{"aid":5729983,"copyright":"Original","typeid":47,"title":"【平纪】想不充钱玩国产游戏？Pokemon
   * Keng第二弹(上海话)","subtitle":"","play":494664,"review":1221,"video_review":8653,"favorites":13177,"mid":4835752,"author":"真纪","description":"平纪公众号搜索：平纪工作室","created":"2016-08-09
   * 16:41:42","pic":"http://i0.hdslb.com/bfs/archive/c95803a64d16437e189aa1d95840fda61e0c1300.jpg","comment":8653,"length":"08:09"},{"aid":5558709,"copyright":"Original","typeid":47,"title":"【平纪】灌篮高手沪语版第二十一集（上海话）","subtitle":"","play":28235,"review":44,"video_review":471,"favorites":146,"mid":4835752,"author":"真纪","description":"平纪微博：平纪_真纪
   * 平纪讨论群：276739793 平纪公众号搜索：平纪工作室","created":"2016-07-30 05:57:01","pic":"http://i0.hdslb.com/bfs/archive/cc8a076866e82cbff46e23a5a79f6b2061bd9d29.jpg","comment":471,"length":"23:08"},{"aid":5447715,"copyright":"Original","typeid":47,"title":"【平纪】想不充钱玩国产游戏？你们太年轻了~~（上海话）","subtitle":"","play":602725,"review":1396,"video_review":7875,"favorites":20377,"mid":4835752,"author":"真纪","description":"平纪公众号搜索：平纪工作室","created":"2016-07-22
   * 21:10:36","pic":"http://i0.hdslb.com/bfs/archive/6954648348b5e5d6087b0cc55136efac56195b0c.jpg","comment":7875,"length":"06:07"},{"aid":5328373,"copyright":"Original","typeid":47,"title":"【平纪】灌篮高手沪语版第二十集（上海话）","subtitle":"","play":28869,"review":36,"video_review":417,"favorites":101,"mid":4835752,"author":"真纪","description":"平纪公众号搜索：平纪工作室","created":"2016-07-14
   * 14:12:43","pic":"http://i0.hdslb.com/bfs/archive/f10462c66d089e3ca9e66b03faf73377c6d728ca.jpg","comment":417,"length":"23:08"},{"aid":5255641,"copyright":"Original","typeid":82,"title":"【平纪】足球是22个人追1个球（上海话）","subtitle":"","play":41657,"review":33,"video_review":388,"favorites":278,"mid":4835752,"author":"真纪","description":"公众号搜索：平纪工作室","created":"2016-07-08
   * 23:11:20","pic":"http://i0.hdslb.com/bfs/archive/b59847ce4b257c608f34983f6815eba7ba8e7ab5.png","comment":388,"length":"05:42"},{"aid":5224899,"copyright":"Original","typeid":47,"title":"【平纪】高中老师绝对不会教你的高考专业选择指南（上海话）","subtitle":"","play":35096,"review":24,"video_review":514,"favorites":307,"mid":4835752,"author":"真纪","description":"平纪公众号搜索：平纪工作室","created":"2016-07-06
   * 18:03:16","pic":"http://i0.hdslb.com/bfs/archive/b29d9db7fb8c7638d8f07b2de8c904a3e29dd787.jpg","comment":514,"length":"06:19"},{"aid":5158688,"copyright":"Original","typeid":47,"title":"【平纪】灌篮高手沪语版第十九集（上海话）","subtitle":"","play":7183,"review":13,"video_review":161,"favorites":24,"mid":4835752,"author":"真纪","description":"公众号搜索：平纪工作室","created":"2016-07-01
   * 14:53:24","pic":"http://i0.hdslb.com/bfs/archive/72141df0f045b0e6e537a047d77ccc73f99db4b8.jpg","comment":161,"length":"23:08"},{"aid":5077340,"copyright":"Original","typeid":128,"title":"【平纪】尼采老师（上海话）","subtitle":"","play":11736,"review":26,"video_review":282,"favorites":105,"mid":4835752,"author":"真纪","description":"公众号搜索：平纪工作室","created":"2016-06-24
   * 17:04:22","pic":"http://i0.hdslb.com/bfs/archive/33363ace8aa819583ffd8b1391a8c2d29e2a31d0.jpg","comment":282,"length":"08:49"},{"aid":5006953,"copyright":"Original","typeid":47,"title":"【平纪】灌篮高手沪语版第十八集（上海话）","subtitle":"","play":8968,"review":17,"video_review":170,"favorites":28,"mid":4835752,"author":"真纪","description":"自制
   * 公众号搜索：平纪工作室","created":"2016-06-18 06:07:29","pic":"http://i0.hdslb.com/bfs/archive/f07fc897e3272b2d05034733305d1704de217ae3.jpg","comment":170,"length":"23:08"},{"aid":4987993,"copyright":"Original","typeid":47,"title":"【平纪】熊孩子们还有30秒到达乐园（上海话）","subtitle":"","play":16652,"review":33,"video_review":234,"favorites":166,"mid":4835752,"author":"真纪","description":"自制
   * 公众号搜索：平纪工作室","created":"2016-06-16 11:51:37","pic":"http://i0.hdslb.com/bfs/archive/addb50cb681a787f624378c9278518998743e61e.jpg","comment":234,"length":"04:25"},{"aid":4951586,"copyright":"Original","typeid":82,"title":"【平纪】高考不是唯一（上海话）","subtitle":"","play":20705,"review":29,"video_review":293,"favorites":240,"mid":4835752,"author":"真纪","description":"自制
   * 公证号：平纪工作室","created":"2016-06-12 17:39:21","pic":"http://i0.hdslb.com/bfs/archive/c2134f4189ce177271ae4a9e5c3662df5d7e830b.jpg","comment":293,"length":"06:09"},{"aid":4884219,"copyright":"Original","typeid":82,"title":"【平纪】为了部落！为了联盟！我们的魔兽世界（上海话）","subtitle":"","play":52578,"review":38,"video_review":490,"favorites":614,"mid":4835752,"author":"真纪","description":"自制
   * 公众号搜索：平纪工作室","created":"2016-06-06 18:04:19","pic":"http://i0.hdslb.com/bfs/archive/8116b5e7a160a536d32a05853849da00b272dd7a.jpg","comment":490,"length":"05:00"},{"aid":4850033,"copyright":"Original","typeid":47,"title":"【平纪】灌篮高手沪语版第十七集（上海话）","subtitle":"","play":5176,"review":16,"video_review":103,"favorites":23,"mid":4835752,"author":"真纪","description":"自制
   * 公众号搜索：平纪工作室","created":"2016-06-03 16:00:15","pic":"http://i0.hdslb.com/bfs/archive/f0dc238b661c169b23aa6f8d4fe8cbf8a88d98a9.jpg","comment":103,"length":"23:08"},{"aid":4830338,"copyright":"Original","typeid":47,"title":"【平纪】708090后的爷叔阿姨们来过儿童节了（上海话）","subtitle":"","play":15055,"review":38,"video_review":529,"favorites":205,"mid":4835752,"author":"真纪","description":"自制
   * 公众号搜索：平纪工作室","created":"2016-06-01 13:14:03","pic":"http://i0.hdslb.com/bfs/archive/388ab9e9f67e637120cd79048ce34474722cf956.jpg","comment":529,"length":"10:32"},{"aid":4778954,"copyright":"Original","typeid":47,"title":"【平纪】监狱学园第四弹（上海话）喜欢屁股的人都是好人","subtitle":"","play":10345,"review":24,"video_review":93,"favorites":65,"mid":4835752,"author":"真纪","description":"自制
   * 喜欢屁股的人都是好人\r\n公众号搜索：平纪工作室","created":"2016-05-27 16:38:51","pic":"http://i0.hdslb.com/bfs/archive/6f0a3200cab13f548235dcd81153773053997442.jpg","comment":93,"length":"07:12"}],"count":58,"pages":3}
   */

  private boolean status;

  /**
   * vlist : [{"aid":6624924,"copyright":"Original","typeid":47,"title":"【平纪】齐木楠雄的灾难第一弹（上海话）","subtitle":"","play":35401,"review":263,"video_review":251,"favorites":413,"mid":4835752,"author":"真纪","description":"平纪公众号搜索：平纪工作室","created":"2016-10-10
   * 18:49:01","pic":"http://i0.hdslb.com/bfs/archive/28fb49ad13679e841239b85907194043446fac75.jpg","comment":251,"length":"05:13"},{"aid":6585652,"copyright":"Original","typeid":138,"title":"【平纪】老板！我要上班！（上海话）","subtitle":"","play":39125,"review":234,"video_review":337,"favorites":564,"mid":4835752,"author":"真纪","description":"平纪公众号搜索：平纪工作室","created":"2016-10-07
   * 18:11:05","pic":"http://i0.hdslb.com/bfs/archive/60412346892b5e20cbccf2f5cfd3c2984836c3ab.jpg","comment":337,"length":"01:16"},{"aid":6436271,"copyright":"Original","typeid":47,"title":"【平纪】Pokemon第三弹
   *  不爆肝想玩好国产游戏？（上海话）","subtitle":"","play":367242,"review":759,"video_review":2535,"favorites":8404,"mid":4835752,"author":"真纪","description":"平纪公众号搜索：平纪工作室","created":"2016-09-27
   * 16:10:02","pic":"http://i0.hdslb.com/bfs/archive/c2aad69c27567260ce4a309f78ceb0241a9a3f67.jpg","comment":2535,"length":"05:14"},{"aid":6273716,"copyright":"Original","typeid":47,"title":"【平纪】你大概会买东西（上海话）","subtitle":"","play":62745,"review":177,"video_review":590,"favorites":570,"mid":4835752,"author":"真纪","description":"平纪公众号搜索:
   * 平纪工作室","created":"2016-09-14 16:45:19","pic":"http://i0.hdslb.com/bfs/archive/d919c9c479b86777b9fd2b9a955776ddbbec17a8.jpg","comment":590,"length":"07:48"},{"aid":6227637,"copyright":"Original","typeid":82,"title":"【平纪】坑特弄\u2014\u2014\u201c阿扎·李\u201d（上海话）","subtitle":"","play":28313,"review":145,"video_review":272,"favorites":207,"mid":4835752,"author":"真纪","description":"平纪公众号搜索：平纪工作室","created":"2016-09-10
   * 19:18:02","pic":"http://i0.hdslb.com/bfs/archive/e92b0753c1dc38c2b3554e79adb5b5da0ad80b15.jpg","comment":272,"length":"06:02"},{"aid":5729983,"copyright":"Original","typeid":47,"title":"【平纪】想不充钱玩国产游戏？Pokemon
   * Keng第二弹(上海话)","subtitle":"","play":494664,"review":1221,"video_review":8653,"favorites":13177,"mid":4835752,"author":"真纪","description":"平纪公众号搜索：平纪工作室","created":"2016-08-09
   * 16:41:42","pic":"http://i0.hdslb.com/bfs/archive/c95803a64d16437e189aa1d95840fda61e0c1300.jpg","comment":8653,"length":"08:09"},{"aid":5558709,"copyright":"Original","typeid":47,"title":"【平纪】灌篮高手沪语版第二十一集（上海话）","subtitle":"","play":28235,"review":44,"video_review":471,"favorites":146,"mid":4835752,"author":"真纪","description":"平纪微博：平纪_真纪
   * 平纪讨论群：276739793 平纪公众号搜索：平纪工作室","created":"2016-07-30 05:57:01","pic":"http://i0.hdslb.com/bfs/archive/cc8a076866e82cbff46e23a5a79f6b2061bd9d29.jpg","comment":471,"length":"23:08"},{"aid":5447715,"copyright":"Original","typeid":47,"title":"【平纪】想不充钱玩国产游戏？你们太年轻了~~（上海话）","subtitle":"","play":602725,"review":1396,"video_review":7875,"favorites":20377,"mid":4835752,"author":"真纪","description":"平纪公众号搜索：平纪工作室","created":"2016-07-22
   * 21:10:36","pic":"http://i0.hdslb.com/bfs/archive/6954648348b5e5d6087b0cc55136efac56195b0c.jpg","comment":7875,"length":"06:07"},{"aid":5328373,"copyright":"Original","typeid":47,"title":"【平纪】灌篮高手沪语版第二十集（上海话）","subtitle":"","play":28869,"review":36,"video_review":417,"favorites":101,"mid":4835752,"author":"真纪","description":"平纪公众号搜索：平纪工作室","created":"2016-07-14
   * 14:12:43","pic":"http://i0.hdslb.com/bfs/archive/f10462c66d089e3ca9e66b03faf73377c6d728ca.jpg","comment":417,"length":"23:08"},{"aid":5255641,"copyright":"Original","typeid":82,"title":"【平纪】足球是22个人追1个球（上海话）","subtitle":"","play":41657,"review":33,"video_review":388,"favorites":278,"mid":4835752,"author":"真纪","description":"公众号搜索：平纪工作室","created":"2016-07-08
   * 23:11:20","pic":"http://i0.hdslb.com/bfs/archive/b59847ce4b257c608f34983f6815eba7ba8e7ab5.png","comment":388,"length":"05:42"},{"aid":5224899,"copyright":"Original","typeid":47,"title":"【平纪】高中老师绝对不会教你的高考专业选择指南（上海话）","subtitle":"","play":35096,"review":24,"video_review":514,"favorites":307,"mid":4835752,"author":"真纪","description":"平纪公众号搜索：平纪工作室","created":"2016-07-06
   * 18:03:16","pic":"http://i0.hdslb.com/bfs/archive/b29d9db7fb8c7638d8f07b2de8c904a3e29dd787.jpg","comment":514,"length":"06:19"},{"aid":5158688,"copyright":"Original","typeid":47,"title":"【平纪】灌篮高手沪语版第十九集（上海话）","subtitle":"","play":7183,"review":13,"video_review":161,"favorites":24,"mid":4835752,"author":"真纪","description":"公众号搜索：平纪工作室","created":"2016-07-01
   * 14:53:24","pic":"http://i0.hdslb.com/bfs/archive/72141df0f045b0e6e537a047d77ccc73f99db4b8.jpg","comment":161,"length":"23:08"},{"aid":5077340,"copyright":"Original","typeid":128,"title":"【平纪】尼采老师（上海话）","subtitle":"","play":11736,"review":26,"video_review":282,"favorites":105,"mid":4835752,"author":"真纪","description":"公众号搜索：平纪工作室","created":"2016-06-24
   * 17:04:22","pic":"http://i0.hdslb.com/bfs/archive/33363ace8aa819583ffd8b1391a8c2d29e2a31d0.jpg","comment":282,"length":"08:49"},{"aid":5006953,"copyright":"Original","typeid":47,"title":"【平纪】灌篮高手沪语版第十八集（上海话）","subtitle":"","play":8968,"review":17,"video_review":170,"favorites":28,"mid":4835752,"author":"真纪","description":"自制
   * 公众号搜索：平纪工作室","created":"2016-06-18 06:07:29","pic":"http://i0.hdslb.com/bfs/archive/f07fc897e3272b2d05034733305d1704de217ae3.jpg","comment":170,"length":"23:08"},{"aid":4987993,"copyright":"Original","typeid":47,"title":"【平纪】熊孩子们还有30秒到达乐园（上海话）","subtitle":"","play":16652,"review":33,"video_review":234,"favorites":166,"mid":4835752,"author":"真纪","description":"自制
   * 公众号搜索：平纪工作室","created":"2016-06-16 11:51:37","pic":"http://i0.hdslb.com/bfs/archive/addb50cb681a787f624378c9278518998743e61e.jpg","comment":234,"length":"04:25"},{"aid":4951586,"copyright":"Original","typeid":82,"title":"【平纪】高考不是唯一（上海话）","subtitle":"","play":20705,"review":29,"video_review":293,"favorites":240,"mid":4835752,"author":"真纪","description":"自制
   * 公证号：平纪工作室","created":"2016-06-12 17:39:21","pic":"http://i0.hdslb.com/bfs/archive/c2134f4189ce177271ae4a9e5c3662df5d7e830b.jpg","comment":293,"length":"06:09"},{"aid":4884219,"copyright":"Original","typeid":82,"title":"【平纪】为了部落！为了联盟！我们的魔兽世界（上海话）","subtitle":"","play":52578,"review":38,"video_review":490,"favorites":614,"mid":4835752,"author":"真纪","description":"自制
   * 公众号搜索：平纪工作室","created":"2016-06-06 18:04:19","pic":"http://i0.hdslb.com/bfs/archive/8116b5e7a160a536d32a05853849da00b272dd7a.jpg","comment":490,"length":"05:00"},{"aid":4850033,"copyright":"Original","typeid":47,"title":"【平纪】灌篮高手沪语版第十七集（上海话）","subtitle":"","play":5176,"review":16,"video_review":103,"favorites":23,"mid":4835752,"author":"真纪","description":"自制
   * 公众号搜索：平纪工作室","created":"2016-06-03 16:00:15","pic":"http://i0.hdslb.com/bfs/archive/f0dc238b661c169b23aa6f8d4fe8cbf8a88d98a9.jpg","comment":103,"length":"23:08"},{"aid":4830338,"copyright":"Original","typeid":47,"title":"【平纪】708090后的爷叔阿姨们来过儿童节了（上海话）","subtitle":"","play":15055,"review":38,"video_review":529,"favorites":205,"mid":4835752,"author":"真纪","description":"自制
   * 公众号搜索：平纪工作室","created":"2016-06-01 13:14:03","pic":"http://i0.hdslb.com/bfs/archive/388ab9e9f67e637120cd79048ce34474722cf956.jpg","comment":529,"length":"10:32"},{"aid":4778954,"copyright":"Original","typeid":47,"title":"【平纪】监狱学园第四弹（上海话）喜欢屁股的人都是好人","subtitle":"","play":10345,"review":24,"video_review":93,"favorites":65,"mid":4835752,"author":"真纪","description":"自制
   * 喜欢屁股的人都是好人\r\n公众号搜索：平纪工作室","created":"2016-05-27 16:38:51","pic":"http://i0.hdslb.com/bfs/archive/6f0a3200cab13f548235dcd81153773053997442.jpg","comment":93,"length":"07:12"}]
   * count : 58
   * pages : 3
   */

  private DataBean data;


  public boolean isStatus() {

    return status;
  }


  public void setStatus(boolean status) {

    this.status = status;
  }


  public DataBean getData() {

    return data;
  }


  public void setData(DataBean data) {

    this.data = data;
  }


  public static class DataBean implements Parcelable {

    private int count;

    private int pages;

    /**
     * aid : 6624924
     * copyright : Original
     * typeid : 47
     * title : 【平纪】齐木楠雄的灾难第一弹（上海话）
     * subtitle :
     * play : 35401
     * review : 263
     * video_review : 251
     * favorites : 413
     * mid : 4835752
     * author : 真纪
     * description : 平纪公众号搜索：平纪工作室
     * created : 2016-10-10 18:49:01
     * pic : http://i0.hdslb.com/bfs/archive/28fb49ad13679e841239b85907194043446fac75.jpg
     * comment : 251
     * length : 05:13
     */

    private List<VlistBean> vlist;


    public int getCount() {

      return count;
    }


    public void setCount(int count) {

      this.count = count;
    }


    public int getPages() {

      return pages;
    }


    public void setPages(int pages) {

      this.pages = pages;
    }


    public List<VlistBean> getVlist() {

      return vlist;
    }


    public void setVlist(List<VlistBean> vlist) {

      this.vlist = vlist;
    }


    public static class VlistBean implements Parcelable {

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


      public int getAid() {

        return aid;
      }


      public void setAid(int aid) {

        this.aid = aid;
      }


      public String getCopyright() {

        return copyright;
      }


      public void setCopyright(String copyright) {

        this.copyright = copyright;
      }


      public int getTypeid() {

        return typeid;
      }


      public void setTypeid(int typeid) {

        this.typeid = typeid;
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


      public int getPlay() {

        return play;
      }


      public void setPlay(int play) {

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


      public String getCreated() {

        return created;
      }


      public void setCreated(String created) {

        this.created = created;
      }


      public String getPic() {

        return pic;
      }


      public void setPic(String pic) {

        this.pic = pic;
      }


      public int getComment() {

        return comment;
      }


      public void setComment(int comment) {

        this.comment = comment;
      }


      public String getLength() {

        return length;
      }


      public void setLength(String length) {

        this.length = length;
      }


      @Override
      public int describeContents() {

        return 0;
      }


      @Override
      public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(this.aid);
        dest.writeString(this.copyright);
        dest.writeInt(this.typeid);
        dest.writeString(this.title);
        dest.writeString(this.subtitle);
        dest.writeInt(this.play);
        dest.writeInt(this.review);
        dest.writeInt(this.video_review);
        dest.writeInt(this.favorites);
        dest.writeInt(this.mid);
        dest.writeString(this.author);
        dest.writeString(this.description);
        dest.writeString(this.created);
        dest.writeString(this.pic);
        dest.writeInt(this.comment);
        dest.writeString(this.length);
      }


      public VlistBean() {

      }


      protected VlistBean(Parcel in) {

        this.aid = in.readInt();
        this.copyright = in.readString();
        this.typeid = in.readInt();
        this.title = in.readString();
        this.subtitle = in.readString();
        this.play = in.readInt();
        this.review = in.readInt();
        this.video_review = in.readInt();
        this.favorites = in.readInt();
        this.mid = in.readInt();
        this.author = in.readString();
        this.description = in.readString();
        this.created = in.readString();
        this.pic = in.readString();
        this.comment = in.readInt();
        this.length = in.readString();
      }


      public static final Creator<VlistBean> CREATOR = new Creator<VlistBean>() {

        @Override
        public VlistBean createFromParcel(Parcel source) {

          return new VlistBean(source);
        }


        @Override
        public VlistBean[] newArray(int size) {

          return new VlistBean[size];
        }
      };
    }


    @Override
    public int describeContents() {

      return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {

      dest.writeInt(this.count);
      dest.writeInt(this.pages);
      dest.writeList(this.vlist);
    }


    public DataBean() {

    }


    protected DataBean(Parcel in) {

      this.count = in.readInt();
      this.pages = in.readInt();
      this.vlist = new ArrayList<VlistBean>();
      in.readList(this.vlist, VlistBean.class.getClassLoader());
    }


    public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {

      @Override
      public DataBean createFromParcel(Parcel source) {

        return new DataBean(source);
      }


      @Override
      public DataBean[] newArray(int size) {

        return new DataBean[size];
      }
    };
  }


  @Override
  public int describeContents() {

    return 0;
  }


  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeByte(this.status ? (byte) 1 : (byte) 0);
    dest.writeParcelable(this.data, flags);
  }


  public UserContributeInfo() {

  }


  protected UserContributeInfo(Parcel in) {

    this.status = in.readByte() != 0;
    this.data = in.readParcelable(DataBean.class.getClassLoader());
  }


  public static final Parcelable.Creator<UserContributeInfo> CREATOR
      = new Parcelable.Creator<UserContributeInfo>() {

    @Override
    public UserContributeInfo createFromParcel(Parcel source) {

      return new UserContributeInfo(source);
    }


    @Override
    public UserContributeInfo[] newArray(int size) {

      return new UserContributeInfo[size];
    }
  };
}
