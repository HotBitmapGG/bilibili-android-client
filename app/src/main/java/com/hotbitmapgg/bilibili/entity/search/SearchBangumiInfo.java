package com.hotbitmapgg.bilibili.entity.search;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hcc on 2016/10/24 21:12
 * 100332338@qq.com
 * <p>
 * 番剧搜索模型类
 */

public class SearchBangumiInfo {

  /**
   * code : 0
   * data : {"pages":1,"items":[{"title":"房东妹子青春期","cover":"http://i0.hdslb.com/bfs/bangumi/2c4612ae6f880172826a4e974407777dc2b06bb1.jpg","uri":"bilibili://bangumi/season/3116","param":"3116","goto":"bangumi","finish":1,"index":"12","newest_cat":"tv","newest_season":"TV","cat_desc":"TV(1)
   * ","total_count":12,"official_verify":{"type":0,"desc":""},"status":0},{"title":"小森同学拒绝不了！","cover":"http://i0.hdslb.com/bfs/bangumi/f7aa7c3f93ff41127992e0487e4ec1db3128d643.jpg","uri":"bilibili://bangumi/season/2744","param":"2744","goto":"bangumi","finish":1,"index":"12","newest_cat":"tv","newest_season":"TV","cat_desc":"TV(1)
   * ","total_count":12,"official_verify":{"type":0,"desc":""},"status":0},{"title":"不思议美眉","cover":"http://i0.hdslb.com/bfs/bangumi/1b2dc503a4d0aa06581d757061371df3cd5600ea.jpg","uri":"bilibili://bangumi/season/2733","param":"2733","goto":"bangumi","finish":1,"index":"12","newest_cat":"tv","newest_season":"TV","cat_desc":"TV(1)
   * ","total_count":12,"official_verify":{"type":0,"desc":""},"status":0}]}
   * message :
   */

  private int code;

  /**
   * pages : 1
   * items : [{"title":"房东妹子青春期","cover":"http://i0.hdslb.com/bfs/bangumi/2c4612ae6f880172826a4e974407777dc2b06bb1.jpg","uri":"bilibili://bangumi/season/3116","param":"3116","goto":"bangumi","finish":1,"index":"12","newest_cat":"tv","newest_season":"TV","cat_desc":"TV(1)
   * ","total_count":12,"official_verify":{"type":0,"desc":""},"status":0},{"title":"小森同学拒绝不了！","cover":"http://i0.hdslb.com/bfs/bangumi/f7aa7c3f93ff41127992e0487e4ec1db3128d643.jpg","uri":"bilibili://bangumi/season/2744","param":"2744","goto":"bangumi","finish":1,"index":"12","newest_cat":"tv","newest_season":"TV","cat_desc":"TV(1)
   * ","total_count":12,"official_verify":{"type":0,"desc":""},"status":0},{"title":"不思议美眉","cover":"http://i0.hdslb.com/bfs/bangumi/1b2dc503a4d0aa06581d757061371df3cd5600ea.jpg","uri":"bilibili://bangumi/season/2733","param":"2733","goto":"bangumi","finish":1,"index":"12","newest_cat":"tv","newest_season":"TV","cat_desc":"TV(1)
   * ","total_count":12,"official_verify":{"type":0,"desc":""},"status":0}]
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
     * title : 房东妹子青春期
     * cover : http://i0.hdslb.com/bfs/bangumi/2c4612ae6f880172826a4e974407777dc2b06bb1.jpg
     * uri : bilibili://bangumi/season/3116
     * param : 3116
     * goto : bangumi
     * finish : 1
     * index : 12
     * newest_cat : tv
     * newest_season : TV
     * cat_desc : TV(1)
     * total_count : 12
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

      private int finish;

      private String index;

      private String newest_cat;

      private String newest_season;

      private String cat_desc;

      private int total_count;

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


      public int getFinish() {

        return finish;
      }


      public void setFinish(int finish) {

        this.finish = finish;
      }


      public String getIndex() {

        return index;
      }


      public void setIndex(String index) {

        this.index = index;
      }


      public String getNewest_cat() {

        return newest_cat;
      }


      public void setNewest_cat(String newest_cat) {

        this.newest_cat = newest_cat;
      }


      public String getNewest_season() {

        return newest_season;
      }


      public void setNewest_season(String newest_season) {

        this.newest_season = newest_season;
      }


      public String getCat_desc() {

        return cat_desc;
      }


      public void setCat_desc(String cat_desc) {

        this.cat_desc = cat_desc;
      }


      public int getTotal_count() {

        return total_count;
      }


      public void setTotal_count(int total_count) {

        this.total_count = total_count;
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
