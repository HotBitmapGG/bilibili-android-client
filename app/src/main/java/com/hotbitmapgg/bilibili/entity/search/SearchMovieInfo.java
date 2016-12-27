package com.hotbitmapgg.bilibili.entity.search;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hcc on 2016/10/24 21:17
 * 100332338@qq.com
 * <p>
 * 影视搜索模型类
 */

public class SearchMovieInfo {

  /**
   * code : 0
   * data : {"pages":1,"items":[{"title":"Bilibili我是勇者","cover":"http://i0.hdslb.com/sp/85/85bf7fea9cf3132e41ef536463d799a3.jpg","uri":"bilibili://splist/57492","param":"57492","goto":"sp","total_count":0,"desc":"《哔哩哔哩-我是勇者》是2015年暑期游戏区活动。邀请了各个游戏区Up主和观众一起来讲述一个被魔王侵蚀的世界里的故事\u2026\u2026","official_verify":{"type":0,"desc":""},"status":0},{"title":"少年24","cover":"http://i1.hdslb.com/sp/48/48f8de1cfd73b85f194acf9b160a9a2c.jpg","uri":"bilibili://splist/69373","param":"69373","goto":"sp","total_count":0,"desc":"...哔哩哔哩每周一12:00中字上线。","official_verify":{"type":0,"desc":""},"status":0},{"title":"说的就是你
   * 第2季","cover":"http://i0.hdslb.com/sp/86/86504a3ab7d987c9f16c985d5e0d1a59.jpg","uri":"bilibili://splist/57004","param":"57004","goto":"sp","total_count":0,"desc":"《说的就是你II》是由BILIBILI弹幕网出品发行，由青豆结冰公司制作完成的原创网络自制剧。在第一季获得超高人气和巨大成功后，第二季再次来袭！延续第一季轻松欢脱的故事风格，新一季中蠢萌演员宋小卿与中国好室友杨天琪之间精彩纷呈，爆笑不断的同居生活还在继续。","official_verify":{"type":0,"desc":""},"status":0},{"title":"说的就是你","cover":"http://i0.hdslb.com/sp/61/61f7a313c424daea983f015558b90059.jpg","uri":"bilibili://splist/57003","param":"57003","goto":"sp","total_count":0,"desc":"　bilibili出品迷你剧《说的就是你》讲述的是在缤纷的世界中平淡的一角，蠢萌的男主宋小卿刚刚步入社会，与好友过着合租的生活。然而宋小卿的命运似乎被一只看不见的手捉弄着，希望总是伴随着无奈，但悲催中却又暗藏着光明。另一方面，透过独特的第二人称视角叙述方式，作为看客的你会
   * 发现，无厘头的人生蕴含着它 的道理，在强烈的共鸣和既视感下，你慢慢明白，其实这生活，说的就是你。 ","official_verify":{"type":0,"desc":""},"status":0},{"title":"和之美","cover":"http://i1.hdslb.com/sp/17/1719bb6d232cda5f3a1de26ee935d8c5.jpg","uri":"bilibili://splist/43189","param":"43189","goto":"sp","total_count":0,"desc":"Bilibili正版纪录片《和之美》系列，介绍日本文化传统等，每周日更新哦！！","official_verify":{"type":0,"desc":""},"status":0}]}
   * message :
   */

  private int code;

  /**
   * pages : 1
   * items : [{"title":"Bilibili我是勇者","cover":"http://i0.hdslb.com/sp/85/85bf7fea9cf3132e41ef536463d799a3.jpg","uri":"bilibili://splist/57492","param":"57492","goto":"sp","total_count":0,"desc":"《哔哩哔哩-我是勇者》是2015年暑期游戏区活动。邀请了各个游戏区Up主和观众一起来讲述一个被魔王侵蚀的世界里的故事\u2026\u2026","official_verify":{"type":0,"desc":""},"status":0},{"title":"少年24","cover":"http://i1.hdslb.com/sp/48/48f8de1cfd73b85f194acf9b160a9a2c.jpg","uri":"bilibili://splist/69373","param":"69373","goto":"sp","total_count":0,"desc":"...哔哩哔哩每周一12:00中字上线。","official_verify":{"type":0,"desc":""},"status":0},{"title":"说的就是你
   * 第2季","cover":"http://i0.hdslb.com/sp/86/86504a3ab7d987c9f16c985d5e0d1a59.jpg","uri":"bilibili://splist/57004","param":"57004","goto":"sp","total_count":0,"desc":"《说的就是你II》是由BILIBILI弹幕网出品发行，由青豆结冰公司制作完成的原创网络自制剧。在第一季获得超高人气和巨大成功后，第二季再次来袭！延续第一季轻松欢脱的故事风格，新一季中蠢萌演员宋小卿与中国好室友杨天琪之间精彩纷呈，爆笑不断的同居生活还在继续。","official_verify":{"type":0,"desc":""},"status":0},{"title":"说的就是你","cover":"http://i0.hdslb.com/sp/61/61f7a313c424daea983f015558b90059.jpg","uri":"bilibili://splist/57003","param":"57003","goto":"sp","total_count":0,"desc":"　bilibili出品迷你剧《说的就是你》讲述的是在缤纷的世界中平淡的一角，蠢萌的男主宋小卿刚刚步入社会，与好友过着合租的生活。然而宋小卿的命运似乎被一只看不见的手捉弄着，希望总是伴随着无奈，但悲催中却又暗藏着光明。另一方面，透过独特的第二人称视角叙述方式，作为看客的你会
   * 发现，无厘头的人生蕴含着它 的道理，在强烈的共鸣和既视感下，你慢慢明白，其实这生活，说的就是你。 ","official_verify":{"type":0,"desc":""},"status":0},{"title":"和之美","cover":"http://i1.hdslb.com/sp/17/1719bb6d232cda5f3a1de26ee935d8c5.jpg","uri":"bilibili://splist/43189","param":"43189","goto":"sp","total_count":0,"desc":"Bilibili正版纪录片《和之美》系列，介绍日本文化传统等，每周日更新哦！！","official_verify":{"type":0,"desc":""},"status":0}]
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
     * title : Bilibili我是勇者
     * cover : http://i0.hdslb.com/sp/85/85bf7fea9cf3132e41ef536463d799a3.jpg
     * uri : bilibili://splist/57492
     * param : 57492
     * goto : sp
     * total_count : 0
     * desc : 《哔哩哔哩-我是勇者》是2015年暑期游戏区活动。邀请了各个游戏区Up主和观众一起来讲述一个被魔王侵蚀的世界里的故事……
     * official_verify : {"type":0,"desc":""}
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

      private String desc;

      /**
       * type : 0
       * desc :
       */

      private OfficialVerifyBean official_verify;

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


      public String getDesc() {

        return desc;
      }


      public void setDesc(String desc) {

        this.desc = desc;
      }


      public OfficialVerifyBean getOfficial_verify() {

        return official_verify;
      }


      public void setOfficial_verify(OfficialVerifyBean official_verify) {

        this.official_verify = official_verify;
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
