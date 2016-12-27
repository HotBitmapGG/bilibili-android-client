package com.hotbitmapgg.bilibili.entity.search;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hcc on 2016/10/24 21:15
 * 100332338@qq.com
 * <p>
 * up主搜索模型类
 */

public class SearchUpperInfo {

  /**
   * code : 0
   * data : {"pages":3,"items":[{"title":"努巴尼守望先锋","cover":"http://i0.hdslb.com/bfs/face/e57e1b1fb1f6c237e336454f436f2667b4844685.jpg","uri":"bilibili://author/20990353","param":"20990353","goto":"author","total_count":0,"sign":"努巴尼守望先锋俱乐部：numbani.cn。是专业的守望先锋玩家社区，为玩家提供守望先锋最新资讯动态，游戏资料，攻略心得，视频，图片。专注，专业，这里只有守望先锋。
   * ","fans":265184,"official_verify":{"type":-1,"desc":""},"archives":239,"status":0},{"title":"NGA守望先锋区","cover":"http://i0.hdslb.com/bfs/face/c16b6701ef1cd6d63b86202431fd403ded7127af.jpg","uri":"bilibili://author/8004440","param":"8004440","goto":"author","total_count":0,"sign":"NGA守望先锋区，国内最专业最全面的守望先锋玩家讨论区。\r\nhttp://bbs.ngacn.cc/thread.php?fid=459","fans":21691,"official_verify":{"type":-1,"desc":""},"archives":1073,"status":0},{"title":"守望先锋查询助手","cover":"http://i0.hdslb.com/bfs/face/f27018c9f23ad3a3d2003730585f36588a3e8fba.jpg","uri":"bilibili://author/31974736","param":"31974736","goto":"author","total_count":0,"sign":"每天搬运youtube的苦力。","fans":13734,"official_verify":{"type":-1,"desc":""},"archives":749,"status":0},{"title":"守望先锋铭欣酱","cover":"http://i0.hdslb.com/bfs/face/4e6683d9a448c021361881d64ed9cce121059f89.jpg","uri":"bilibili://author/25580185","param":"25580185","goto":"author","total_count":0,"sign":"这里是创造快乐的小天使！关注我吧~休闲娱乐茶余饭后，攻略视频爆笑解说就是铭欣酱啦！","fans":4880,"official_verify":{"type":-1,"desc":""},"archives":112,"status":0},{"title":"守望先锋瑟米君","cover":"http://i0.hdslb.com/bfs/face/2bc3fdc36fe82aa26a85ff8187d903d3e5987c35.jpg","uri":"bilibili://author/1110776","param":"1110776","goto":"author","total_count":0,"sign":"主观色彩会影响客观存在的味觉","fans":3850,"official_verify":{"type":-1,"desc":""},"archives":16,"status":0},{"title":"守望先锋丶肉卷","cover":"http://i0.hdslb.com/bfs/face/f78f964b98a759233c582a075e1eb53dc16d301c.jpg","uri":"bilibili://author/252543","param":"252543","goto":"author","total_count":0,"sign":"追名逐利是一个褒义词","fans":2430,"official_verify":{"type":-1,"desc":""},"archives":9,"status":0},{"title":"守望先锋--泪瞳丷","cover":"http://i0.hdslb.com/bfs/face/bccb1035279782544a002bdb474b08c71720a5e6.jpg","uri":"bilibili://author/18946411","param":"18946411","goto":"author","total_count":0,"sign":"每天直播都会给你们带来欢乐，求关注，求瓜子~
   *   每天给你们卖萌哦(｡\u2022́__ก̀｡)","fans":2125,"official_verify":{"type":-1,"desc":""},"archives":2,"status":0},{"title":"守望先锋冷漠","cover":"http://i0.hdslb.com/bfs/face/80d73ede46ae456550a5de1a9b14265dfd5363be.jpg","uri":"bilibili://author/8970285","param":"8970285","goto":"author","total_count":0,"sign":"打扰一下？
   * ","fans":1627,"official_verify":{"type":-1,"desc":""},"archives":13,"status":0},{"title":"守望先锋赛事","cover":"http://i0.hdslb.com/bfs/face/cceb8c3038696de54f49e0fff2238a93dd16202c.jpg","uri":"bilibili://author/33784562","param":"33784562","goto":"author","total_count":0,"sign":"我们是努巴尼守望先锋的赛事视频分帐号，专门搬运与发布国内外重大赛事的视频系列。分享给希望学习国内外战队比赛套路跟经验的玩家。","fans":1502,"official_verify":{"type":-1,"desc":""},"archives":22,"status":0},{"title":"守望先锋白河愁","cover":"http://i0.hdslb.com/bfs/face/24b197d1c0c43b8e25b83a65eea3821a64f9bc3b.jpg","uri":"bilibili://author/34646754","param":"34646754","goto":"author","total_count":0,"sign":"白河愁代练，排位想上分的私聊我，买了笔记本被坑了，打算赚钱买台式直播\n欢迎加入狂鼠爆炸学院，群号码：310836724","fans":1086,"official_verify":{"type":-1,"desc":""},"archives":40,"status":0},{"title":"守望先锋-夏虫工作室","cover":"http://i0.hdslb.com/bfs/face/c6d5fd87afbbeb4fac7c266cebcbce3cf2743c74.gif","uri":"bilibili://author/29335586","param":"29335586","goto":"author","total_count":0,"sign":"欢迎来到我的主页！求关注求投喂！每周都会更新视频，每天（大概）都会有精彩直播！快来关注我啊，还等啥呢？直播间互撩Q群：193305258\r\n","fans":745,"official_verify":{"type":-1,"desc":""},"archives":54,"status":0},{"title":"守望先锋小学生","cover":"http://i0.hdslb.com/bfs/face/ef7e0670a13326fbf7e9d726f504eb29419c6e2a.jpg","uri":"bilibili://author/36326699","param":"36326699","goto":"author","total_count":0,"sign":"守望先锋逗比小视频！新浪微博
   * @守望先锋小学生","fans":745,"official_verify":{"type":-1,"desc":""},"archives":54,"status":0},{"title":"守望先锋抉择先生","cover":"http://i0.hdslb.com/bfs/face/c182a8e0a164aab221a03af37076797c95dae95a.jpg","uri":"bilibili://author/12667709","param":"12667709","goto":"author","total_count":0,"sign":"可以
   *  这很简介","fans":528,"official_verify":{"type":-1,"desc":""},"archives":1,"status":0},{"title":"守望先锋五百弱","cover":"http://i0.hdslb.com/bfs/face/36bb9339e5d8d48fdc7e7e19a1e355fce9e8473b.jpg","uri":"bilibili://author/23371801","param":"23371801","goto":"author","total_count":0,"sign":"从油管转译守望先锋相关视频或者科普冷知识，攻略等等
   * 想要up翻译什么类型的视频在评论中说哦！你的订阅是我的动力！","fans":498,"official_verify":{"type":-1,"desc":""},"archives":10,"status":0},{"title":"守望先锋傲娇日常","cover":"http://i0.hdslb.com/bfs/face/7379142bbeba85bb9b4308f730742f1cb63c419c.jpg","uri":"bilibili://author/12168705","param":"12168705","goto":"author","total_count":0,"sign":"辣鸡主播
   * - -！娱乐主播！可以一起玩玩，主要是开心！","fans":424,"official_verify":{"type":-1,"desc":""},"archives":1,"status":0},{"title":"守望先锋忒忒","cover":"http://i0.hdslb.com/bfs/face/847816e56fde880b99c4b24be7f73a1ab3026a43.jpg","uri":"bilibili://author/15726744","param":"15726744","goto":"author","total_count":0,"sign":"猫奴一枚\u2026设计狗一个...咸鱼一条","fans":331,"official_verify":{"type":-1,"desc":""},"archives":4,"status":0},{"title":"守望先锋君","cover":"http://i0.hdslb.com/bfs/face/a9b455ca33d488a48df4089ed68d903d92d8bb38.jpg","uri":"bilibili://author/34932803","param":"34932803","goto":"author","total_count":0,"sign":"微博：守望先锋君","fans":322,"official_verify":{"type":-1,"desc":""},"archives":8,"status":0},{"title":"守望先锋小二郎","cover":"http://i0.hdslb.com/bfs/face/a09c6d386ec37d5457fa74c4f1ca1339fc106fdc.jpg","uri":"bilibili://author/39742569","param":"39742569","goto":"author","total_count":0,"sign":"感谢大家的支持！关注守望先锋，关注小二郎！","fans":221,"official_verify":{"type":-1,"desc":""},"archives":6,"status":0},{"title":"守望先锋-TheBlondie","cover":"http://i0.hdslb.com/bfs/face/4c4ac0f35409b87b869b9e2e15d598b689b6d754.jpg","uri":"bilibili://author/422971","param":"422971","goto":"author","total_count":0,"sign":"力微任重久神疲~","fans":186,"official_verify":{"type":-1,"desc":""},"archives":8,"status":0},{"title":"守望先锋™","cover":"http://i0.hdslb.com/bfs/face/d528643f2efffd8da262d7c027c90759afa3aab8.jpg","uri":"bilibili://author/1523926","param":"1523926","goto":"author","total_count":0,"sign":"YOUR
   * WATCH BEGINS NOW","fans":160,"official_verify":{"type":-1,"desc":""},"archives":19,"status":0}]}
   * message :
   */

  private int code;

  /**
   * pages : 3
   * items : [{"title":"努巴尼守望先锋","cover":"http://i0.hdslb.com/bfs/face/e57e1b1fb1f6c237e336454f436f2667b4844685.jpg","uri":"bilibili://author/20990353","param":"20990353","goto":"author","total_count":0,"sign":"努巴尼守望先锋俱乐部：numbani.cn。是专业的守望先锋玩家社区，为玩家提供守望先锋最新资讯动态，游戏资料，攻略心得，视频，图片。专注，专业，这里只有守望先锋。
   * ","fans":265184,"official_verify":{"type":-1,"desc":""},"archives":239,"status":0},{"title":"NGA守望先锋区","cover":"http://i0.hdslb.com/bfs/face/c16b6701ef1cd6d63b86202431fd403ded7127af.jpg","uri":"bilibili://author/8004440","param":"8004440","goto":"author","total_count":0,"sign":"NGA守望先锋区，国内最专业最全面的守望先锋玩家讨论区。\r\nhttp://bbs.ngacn.cc/thread.php?fid=459","fans":21691,"official_verify":{"type":-1,"desc":""},"archives":1073,"status":0},{"title":"守望先锋查询助手","cover":"http://i0.hdslb.com/bfs/face/f27018c9f23ad3a3d2003730585f36588a3e8fba.jpg","uri":"bilibili://author/31974736","param":"31974736","goto":"author","total_count":0,"sign":"每天搬运youtube的苦力。","fans":13734,"official_verify":{"type":-1,"desc":""},"archives":749,"status":0},{"title":"守望先锋铭欣酱","cover":"http://i0.hdslb.com/bfs/face/4e6683d9a448c021361881d64ed9cce121059f89.jpg","uri":"bilibili://author/25580185","param":"25580185","goto":"author","total_count":0,"sign":"这里是创造快乐的小天使！关注我吧~休闲娱乐茶余饭后，攻略视频爆笑解说就是铭欣酱啦！","fans":4880,"official_verify":{"type":-1,"desc":""},"archives":112,"status":0},{"title":"守望先锋瑟米君","cover":"http://i0.hdslb.com/bfs/face/2bc3fdc36fe82aa26a85ff8187d903d3e5987c35.jpg","uri":"bilibili://author/1110776","param":"1110776","goto":"author","total_count":0,"sign":"主观色彩会影响客观存在的味觉","fans":3850,"official_verify":{"type":-1,"desc":""},"archives":16,"status":0},{"title":"守望先锋丶肉卷","cover":"http://i0.hdslb.com/bfs/face/f78f964b98a759233c582a075e1eb53dc16d301c.jpg","uri":"bilibili://author/252543","param":"252543","goto":"author","total_count":0,"sign":"追名逐利是一个褒义词","fans":2430,"official_verify":{"type":-1,"desc":""},"archives":9,"status":0},{"title":"守望先锋--泪瞳丷","cover":"http://i0.hdslb.com/bfs/face/bccb1035279782544a002bdb474b08c71720a5e6.jpg","uri":"bilibili://author/18946411","param":"18946411","goto":"author","total_count":0,"sign":"每天直播都会给你们带来欢乐，求关注，求瓜子~
   *   每天给你们卖萌哦(｡\u2022́__ก̀｡)","fans":2125,"official_verify":{"type":-1,"desc":""},"archives":2,"status":0},{"title":"守望先锋冷漠","cover":"http://i0.hdslb.com/bfs/face/80d73ede46ae456550a5de1a9b14265dfd5363be.jpg","uri":"bilibili://author/8970285","param":"8970285","goto":"author","total_count":0,"sign":"打扰一下？
   * ","fans":1627,"official_verify":{"type":-1,"desc":""},"archives":13,"status":0},{"title":"守望先锋赛事","cover":"http://i0.hdslb.com/bfs/face/cceb8c3038696de54f49e0fff2238a93dd16202c.jpg","uri":"bilibili://author/33784562","param":"33784562","goto":"author","total_count":0,"sign":"我们是努巴尼守望先锋的赛事视频分帐号，专门搬运与发布国内外重大赛事的视频系列。分享给希望学习国内外战队比赛套路跟经验的玩家。","fans":1502,"official_verify":{"type":-1,"desc":""},"archives":22,"status":0},{"title":"守望先锋白河愁","cover":"http://i0.hdslb.com/bfs/face/24b197d1c0c43b8e25b83a65eea3821a64f9bc3b.jpg","uri":"bilibili://author/34646754","param":"34646754","goto":"author","total_count":0,"sign":"白河愁代练，排位想上分的私聊我，买了笔记本被坑了，打算赚钱买台式直播\n欢迎加入狂鼠爆炸学院，群号码：310836724","fans":1086,"official_verify":{"type":-1,"desc":""},"archives":40,"status":0},{"title":"守望先锋-夏虫工作室","cover":"http://i0.hdslb.com/bfs/face/c6d5fd87afbbeb4fac7c266cebcbce3cf2743c74.gif","uri":"bilibili://author/29335586","param":"29335586","goto":"author","total_count":0,"sign":"欢迎来到我的主页！求关注求投喂！每周都会更新视频，每天（大概）都会有精彩直播！快来关注我啊，还等啥呢？直播间互撩Q群：193305258\r\n","fans":745,"official_verify":{"type":-1,"desc":""},"archives":54,"status":0},{"title":"守望先锋小学生","cover":"http://i0.hdslb.com/bfs/face/ef7e0670a13326fbf7e9d726f504eb29419c6e2a.jpg","uri":"bilibili://author/36326699","param":"36326699","goto":"author","total_count":0,"sign":"守望先锋逗比小视频！新浪微博
   * @守望先锋小学生","fans":745,"official_verify":{"type":-1,"desc":""},"archives":54,"status":0},{"title":"守望先锋抉择先生","cover":"http://i0.hdslb.com/bfs/face/c182a8e0a164aab221a03af37076797c95dae95a.jpg","uri":"bilibili://author/12667709","param":"12667709","goto":"author","total_count":0,"sign":"可以
   *  这很简介","fans":528,"official_verify":{"type":-1,"desc":""},"archives":1,"status":0},{"title":"守望先锋五百弱","cover":"http://i0.hdslb.com/bfs/face/36bb9339e5d8d48fdc7e7e19a1e355fce9e8473b.jpg","uri":"bilibili://author/23371801","param":"23371801","goto":"author","total_count":0,"sign":"从油管转译守望先锋相关视频或者科普冷知识，攻略等等
   * 想要up翻译什么类型的视频在评论中说哦！你的订阅是我的动力！","fans":498,"official_verify":{"type":-1,"desc":""},"archives":10,"status":0},{"title":"守望先锋傲娇日常","cover":"http://i0.hdslb.com/bfs/face/7379142bbeba85bb9b4308f730742f1cb63c419c.jpg","uri":"bilibili://author/12168705","param":"12168705","goto":"author","total_count":0,"sign":"辣鸡主播
   * - -！娱乐主播！可以一起玩玩，主要是开心！","fans":424,"official_verify":{"type":-1,"desc":""},"archives":1,"status":0},{"title":"守望先锋忒忒","cover":"http://i0.hdslb.com/bfs/face/847816e56fde880b99c4b24be7f73a1ab3026a43.jpg","uri":"bilibili://author/15726744","param":"15726744","goto":"author","total_count":0,"sign":"猫奴一枚\u2026设计狗一个...咸鱼一条","fans":331,"official_verify":{"type":-1,"desc":""},"archives":4,"status":0},{"title":"守望先锋君","cover":"http://i0.hdslb.com/bfs/face/a9b455ca33d488a48df4089ed68d903d92d8bb38.jpg","uri":"bilibili://author/34932803","param":"34932803","goto":"author","total_count":0,"sign":"微博：守望先锋君","fans":322,"official_verify":{"type":-1,"desc":""},"archives":8,"status":0},{"title":"守望先锋小二郎","cover":"http://i0.hdslb.com/bfs/face/a09c6d386ec37d5457fa74c4f1ca1339fc106fdc.jpg","uri":"bilibili://author/39742569","param":"39742569","goto":"author","total_count":0,"sign":"感谢大家的支持！关注守望先锋，关注小二郎！","fans":221,"official_verify":{"type":-1,"desc":""},"archives":6,"status":0},{"title":"守望先锋-TheBlondie","cover":"http://i0.hdslb.com/bfs/face/4c4ac0f35409b87b869b9e2e15d598b689b6d754.jpg","uri":"bilibili://author/422971","param":"422971","goto":"author","total_count":0,"sign":"力微任重久神疲~","fans":186,"official_verify":{"type":-1,"desc":""},"archives":8,"status":0},{"title":"守望先锋™","cover":"http://i0.hdslb.com/bfs/face/d528643f2efffd8da262d7c027c90759afa3aab8.jpg","uri":"bilibili://author/1523926","param":"1523926","goto":"author","total_count":0,"sign":"YOUR
   * WATCH BEGINS NOW","fans":160,"official_verify":{"type":-1,"desc":""},"archives":19,"status":0}]
   */

  private DataBean data;

  private String message;


  public int getCode() {

    return code;
  }


  public void setCode(int code) {

    this.code = code;
  }


  public DataBean getData() {

    return data;
  }


  public void setData(DataBean data) {

    this.data = data;
  }


  public String getMessage() {

    return message;
  }


  public void setMessage(String message) {

    this.message = message;
  }


  public static class DataBean {

    private int pages;

    /**
     * title : 努巴尼守望先锋
     * cover : http://i0.hdslb.com/bfs/face/e57e1b1fb1f6c237e336454f436f2667b4844685.jpg
     * uri : bilibili://author/20990353
     * param : 20990353
     * goto : author
     * total_count : 0
     * sign : 努巴尼守望先锋俱乐部：numbani.cn。是专业的守望先锋玩家社区，为玩家提供守望先锋最新资讯动态，游戏资料，攻略心得，视频，图片。专注，专业，这里只有守望先锋。
     * fans : 265184
     * official_verify : {"type":-1,"desc":""}
     * archives : 239
     * status : 0
     */

    private List<ItemsBean> items;


    public int getPages() {

      return pages;
    }


    public void setPages(int pages) {

      this.pages = pages;
    }


    public List<ItemsBean> getItems() {

      return items;
    }


    public void setItems(List<ItemsBean> items) {

      this.items = items;
    }


    public static class ItemsBean {

      private String title;

      private String cover;

      private String uri;

      private String param;

      @SerializedName("goto")
      private String gotoX;

      private int total_count;

      private String sign;

      private int fans;

      /**
       * type : -1
       * desc :
       */

      private OfficialVerifyBean official_verify;

      private int archives;

      private int status;


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


      public String getUri() {

        return uri;
      }


      public void setUri(String uri) {

        this.uri = uri;
      }


      public String getParam() {

        return param;
      }


      public void setParam(String param) {

        this.param = param;
      }


      public String getGotoX() {

        return gotoX;
      }


      public void setGotoX(String gotoX) {

        this.gotoX = gotoX;
      }


      public int getTotal_count() {

        return total_count;
      }


      public void setTotal_count(int total_count) {

        this.total_count = total_count;
      }


      public String getSign() {

        return sign;
      }


      public void setSign(String sign) {

        this.sign = sign;
      }


      public int getFans() {

        return fans;
      }


      public void setFans(int fans) {

        this.fans = fans;
      }


      public OfficialVerifyBean getOfficial_verify() {

        return official_verify;
      }


      public void setOfficial_verify(OfficialVerifyBean official_verify) {

        this.official_verify = official_verify;
      }


      public int getArchives() {

        return archives;
      }


      public void setArchives(int archives) {

        this.archives = archives;
      }


      public int getStatus() {

        return status;
      }


      public void setStatus(int status) {

        this.status = status;
      }


      public static class OfficialVerifyBean {

        private int type;

        private String desc;


        public int getType() {

          return type;
        }


        public void setType(int type) {

          this.type = type;
        }


        public String getDesc() {

          return desc;
        }


        public void setDesc(String desc) {

          this.desc = desc;
        }
      }
    }
  }
}
