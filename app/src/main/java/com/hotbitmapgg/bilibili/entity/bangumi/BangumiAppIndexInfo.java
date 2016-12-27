package com.hotbitmapgg.bilibili.entity.bangumi;

import java.util.List;

/**
 * Created by hcc on 2016/11/1 10:41
 * 100332338@qq.com
 * <p>
 * 首页番剧内容模型类
 */

public class BangumiAppIndexInfo {

  /**
   * code : 0
   * message : success
   * result : {"ad":{"body":[{"img":"http://i0.hdslb.com/bfs/bangumi/7151e449a4d670e8d26db5e3359a0e36c860dafd.png","index":1,"link":"http://bangumi.bilibili.com/moe/2016/cn/mobile","title":"国产萌战"}],"head":[{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/5ac8277af4f06a8d14374c4428403233d20ac4e4.jpg","is_ad":0,"link":"http://bangumi.bilibili.com/anime/5542","pub_time":"2016-11-01
   * 01:05:00","title":"TRICKSTER"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/17f4538384d75d9748d0d1f2e71cbb8d226a2b71.jpg","is_ad":0,"link":"http://bangumi.bilibili.com/anime/5540","pub_time":"2016-10-31
   * 22:30:00","title":"斯特拉的魔法"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/89d276e9eba37528cd847e4c609179b322450773.jpg","is_ad":0,"link":"http://bangumi.bilibili.com/anime/3253","pub_time":"2016-11-01
   * 10:00:00","title":"十万个冷笑话"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/be4b30db286b33a5fd6e044250a20eada6d8261f.jpg","is_ad":0,"link":"http://bangumi.bilibili.com/anime/5102","pub_time":"2016-11-01
   * 10:00:00","title":"灵契"}]},"previous":{"list":[{"cover":"http://i0.hdslb.com/bfs/bangumi/6b4ba7bd59be1f9de225294d18ca5e6819185c06.jpg","favourites":"1407680","is_finish":1,"last_time":1474725610,"newest_ep_index":"13","pub_time":1467468000,"season_id":5017,"season_status":2,"title":"食戟之灵
   * 贰之皿","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/6e6a7524c42efb8061985f9fe1a0448e6913c3e2.jpg","favourites":"794585","is_finish":1,"last_time":1474813810,"newest_ep_index":"13","pub_time":1467556200,"season_id":5022,"season_status":2,"title":"热诚传说X","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/6bf7624d5b688b3e916c1ae1e94c2e16cd4714a7.jpg","favourites":"748228","is_finish":1,"last_time":1474903810,"newest_ep_index":"12","pub_time":1468251000,"season_id":5056,"season_status":2,"title":"弹丸论破3
   * -未来篇-","watching_count":0}],"season":3,"year":2016},"serializing":[{"cover":"http://i0.hdslb.com/bfs/bangumi/eb4f17335f48951945fb9da47e6ee0bc65fa2fbb.jpg","favourites":"681671","is_finish":0,"is_started":1,"last_time":1477958410,"newest_ep_index":"87","pub_time":1467590400,"season_id":5070,"season_status":2,"title":"齐木楠雄的灾难（日播版）","watching_count":2591},{"cover":"http://i0.hdslb.com/bfs/bangumi/9925ece99e3458760fc074e8564f74a1d6f46e1d.jpg","favourites":"48334","is_finish":0,"is_started":1,"last_time":1477953910,"newest_ep_index":"6","pub_time":1474905600,"season_id":5504,"season_status":2,"title":"喵阿楞","watching_count":69},{"cover":"http://i0.hdslb.com/bfs/bangumi/82709ec1fb027631b1f939c9dfcc2d850ffa12a2.jpg","favourites":"60284","is_finish":0,"is_started":1,"last_time":1477935300,"newest_ep_index":"5","pub_time":1475516100,"season_id":5539,"season_status":2,"title":"灼热乒乓妹","watching_count":532},{"cover":"http://i0.hdslb.com/bfs/bangumi/3501378364ff84cbb42d2ee946334cd3b2dec453.jpg","favourites":"360053","is_finish":0,"is_started":1,"last_time":1477933500,"newest_ep_index":"5","pub_time":1475514300,"season_id":5542,"season_status":2,"title":"TRICKSTER","watching_count":1048},{"cover":"http://i0.hdslb.com/bfs/bangumi/c74ba43e76c346476c8c09e653d35de69073cc49.jpg","favourites":"112429","is_finish":0,"is_started":1,"last_time":1477929610,"newest_ep_index":"5","pub_time":1475424000,"season_id":5543,"season_status":2,"title":"学园Handsome","watching_count":149},{"cover":"http://i0.hdslb.com/bfs/bangumi/a7d604cb9024faeb775a79a95c33542e3cdd420c.jpg","favourites":"75865","is_finish":0,"is_started":1,"last_time":1477924210,"newest_ep_index":"5","pub_time":1475505000,"season_id":5540,"season_status":2,"title":"斯特拉的魔法","watching_count":383}]}
   */

  private int code;

  private String message;

  /**
   * ad : {"body":[{"img":"http://i0.hdslb.com/bfs/bangumi/7151e449a4d670e8d26db5e3359a0e36c860dafd.png","index":1,"link":"http://bangumi.bilibili.com/moe/2016/cn/mobile","title":"国产萌战"}],"head":[{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/5ac8277af4f06a8d14374c4428403233d20ac4e4.jpg","is_ad":0,"link":"http://bangumi.bilibili.com/anime/5542","pub_time":"2016-11-01
   * 01:05:00","title":"TRICKSTER"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/17f4538384d75d9748d0d1f2e71cbb8d226a2b71.jpg","is_ad":0,"link":"http://bangumi.bilibili.com/anime/5540","pub_time":"2016-10-31
   * 22:30:00","title":"斯特拉的魔法"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/89d276e9eba37528cd847e4c609179b322450773.jpg","is_ad":0,"link":"http://bangumi.bilibili.com/anime/3253","pub_time":"2016-11-01
   * 10:00:00","title":"十万个冷笑话"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/be4b30db286b33a5fd6e044250a20eada6d8261f.jpg","is_ad":0,"link":"http://bangumi.bilibili.com/anime/5102","pub_time":"2016-11-01
   * 10:00:00","title":"灵契"}]}
   * previous : {"list":[{"cover":"http://i0.hdslb.com/bfs/bangumi/6b4ba7bd59be1f9de225294d18ca5e6819185c06.jpg","favourites":"1407680","is_finish":1,"last_time":1474725610,"newest_ep_index":"13","pub_time":1467468000,"season_id":5017,"season_status":2,"title":"食戟之灵
   * 贰之皿","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/6e6a7524c42efb8061985f9fe1a0448e6913c3e2.jpg","favourites":"794585","is_finish":1,"last_time":1474813810,"newest_ep_index":"13","pub_time":1467556200,"season_id":5022,"season_status":2,"title":"热诚传说X","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/6bf7624d5b688b3e916c1ae1e94c2e16cd4714a7.jpg","favourites":"748228","is_finish":1,"last_time":1474903810,"newest_ep_index":"12","pub_time":1468251000,"season_id":5056,"season_status":2,"title":"弹丸论破3
   * -未来篇-","watching_count":0}],"season":3,"year":2016}
   * serializing : [{"cover":"http://i0.hdslb.com/bfs/bangumi/eb4f17335f48951945fb9da47e6ee0bc65fa2fbb.jpg","favourites":"681671","is_finish":0,"is_started":1,"last_time":1477958410,"newest_ep_index":"87","pub_time":1467590400,"season_id":5070,"season_status":2,"title":"齐木楠雄的灾难（日播版）","watching_count":2591},{"cover":"http://i0.hdslb.com/bfs/bangumi/9925ece99e3458760fc074e8564f74a1d6f46e1d.jpg","favourites":"48334","is_finish":0,"is_started":1,"last_time":1477953910,"newest_ep_index":"6","pub_time":1474905600,"season_id":5504,"season_status":2,"title":"喵阿楞","watching_count":69},{"cover":"http://i0.hdslb.com/bfs/bangumi/82709ec1fb027631b1f939c9dfcc2d850ffa12a2.jpg","favourites":"60284","is_finish":0,"is_started":1,"last_time":1477935300,"newest_ep_index":"5","pub_time":1475516100,"season_id":5539,"season_status":2,"title":"灼热乒乓妹","watching_count":532},{"cover":"http://i0.hdslb.com/bfs/bangumi/3501378364ff84cbb42d2ee946334cd3b2dec453.jpg","favourites":"360053","is_finish":0,"is_started":1,"last_time":1477933500,"newest_ep_index":"5","pub_time":1475514300,"season_id":5542,"season_status":2,"title":"TRICKSTER","watching_count":1048},{"cover":"http://i0.hdslb.com/bfs/bangumi/c74ba43e76c346476c8c09e653d35de69073cc49.jpg","favourites":"112429","is_finish":0,"is_started":1,"last_time":1477929610,"newest_ep_index":"5","pub_time":1475424000,"season_id":5543,"season_status":2,"title":"学园Handsome","watching_count":149},{"cover":"http://i0.hdslb.com/bfs/bangumi/a7d604cb9024faeb775a79a95c33542e3cdd420c.jpg","favourites":"75865","is_finish":0,"is_started":1,"last_time":1477924210,"newest_ep_index":"5","pub_time":1475505000,"season_id":5540,"season_status":2,"title":"斯特拉的魔法","watching_count":383}]
   */

  private ResultBean result;


  public int getCode() {

    return code;
  }


  public void setCode(int code) {

    this.code = code;
  }


  public String getMessage() {

    return message;
  }


  public void setMessage(String message) {

    this.message = message;
  }


  public ResultBean getResult() {

    return result;
  }


  public void setResult(ResultBean result) {

    this.result = result;
  }


  public static class ResultBean {

    private AdBean ad;

    /**
     * list : [{"cover":"http://i0.hdslb.com/bfs/bangumi/6b4ba7bd59be1f9de225294d18ca5e6819185c06.jpg","favourites":"1407680","is_finish":1,"last_time":1474725610,"newest_ep_index":"13","pub_time":1467468000,"season_id":5017,"season_status":2,"title":"食戟之灵
     * 贰之皿","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/6e6a7524c42efb8061985f9fe1a0448e6913c3e2.jpg","favourites":"794585","is_finish":1,"last_time":1474813810,"newest_ep_index":"13","pub_time":1467556200,"season_id":5022,"season_status":2,"title":"热诚传说X","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/6bf7624d5b688b3e916c1ae1e94c2e16cd4714a7.jpg","favourites":"748228","is_finish":1,"last_time":1474903810,"newest_ep_index":"12","pub_time":1468251000,"season_id":5056,"season_status":2,"title":"弹丸论破3
     * -未来篇-","watching_count":0}]
     * season : 3
     * year : 2016
     */

    private PreviousBean previous;

    /**
     * cover : http://i0.hdslb.com/bfs/bangumi/eb4f17335f48951945fb9da47e6ee0bc65fa2fbb.jpg
     * favourites : 681671
     * is_finish : 0
     * is_started : 1
     * last_time : 1477958410
     * newest_ep_index : 87
     * pub_time : 1467590400
     * season_id : 5070
     * season_status : 2
     * title : 齐木楠雄的灾难（日播版）
     * watching_count : 2591
     */

    private List<SerializingBean> serializing;


    public AdBean getAd() {

      return ad;
    }


    public void setAd(AdBean ad) {

      this.ad = ad;
    }


    public PreviousBean getPrevious() {

      return previous;
    }


    public void setPrevious(PreviousBean previous) {

      this.previous = previous;
    }


    public List<SerializingBean> getSerializing() {

      return serializing;
    }


    public void setSerializing(List<SerializingBean> serializing) {

      this.serializing = serializing;
    }


    public static class AdBean {

      /**
       * img : http://i0.hdslb.com/bfs/bangumi/7151e449a4d670e8d26db5e3359a0e36c860dafd.png
       * index : 1
       * link : http://bangumi.bilibili.com/moe/2016/cn/mobile
       * title : 国产萌战
       */

      private List<BodyBean> body;

      /**
       * id : 0
       * img : http://i0.hdslb.com/bfs/bangumi/5ac8277af4f06a8d14374c4428403233d20ac4e4.jpg
       * is_ad : 0
       * link : http://bangumi.bilibili.com/anime/5542
       * pub_time : 2016-11-01 01:05:00
       * title : TRICKSTER
       */

      private List<HeadBean> head;


      public List<BodyBean> getBody() {

        return body;
      }


      public void setBody(List<BodyBean> body) {

        this.body = body;
      }


      public List<HeadBean> getHead() {

        return head;
      }


      public void setHead(List<HeadBean> head) {

        this.head = head;
      }


      public static class BodyBean {

        private String img;

        private int index;

        private String link;

        private String title;


        public String getImg() {

          return img;
        }


        public void setImg(String img) {

          this.img = img;
        }


        public int getIndex() {

          return index;
        }


        public void setIndex(int index) {

          this.index = index;
        }


        public String getLink() {

          return link;
        }


        public void setLink(String link) {

          this.link = link;
        }


        public String getTitle() {

          return title;
        }


        public void setTitle(String title) {

          this.title = title;
        }
      }

      public static class HeadBean {

        private int id;

        private String img;

        private int is_ad;

        private String link;

        private String pub_time;

        private String title;


        public int getId() {

          return id;
        }


        public void setId(int id) {

          this.id = id;
        }


        public String getImg() {

          return img;
        }


        public void setImg(String img) {

          this.img = img;
        }


        public int getIs_ad() {

          return is_ad;
        }


        public void setIs_ad(int is_ad) {

          this.is_ad = is_ad;
        }


        public String getLink() {

          return link;
        }


        public void setLink(String link) {

          this.link = link;
        }


        public String getPub_time() {

          return pub_time;
        }


        public void setPub_time(String pub_time) {

          this.pub_time = pub_time;
        }


        public String getTitle() {

          return title;
        }


        public void setTitle(String title) {

          this.title = title;
        }
      }
    }

    public static class PreviousBean {

      private int season;

      private int year;

      /**
       * cover : http://i0.hdslb.com/bfs/bangumi/6b4ba7bd59be1f9de225294d18ca5e6819185c06.jpg
       * favourites : 1407680
       * is_finish : 1
       * last_time : 1474725610
       * newest_ep_index : 13
       * pub_time : 1467468000
       * season_id : 5017
       * season_status : 2
       * title : 食戟之灵 贰之皿
       * watching_count : 0
       */

      private List<ListBean> list;


      public int getSeason() {

        return season;
      }


      public void setSeason(int season) {

        this.season = season;
      }


      public int getYear() {

        return year;
      }


      public void setYear(int year) {

        this.year = year;
      }


      public List<ListBean> getList() {

        return list;
      }


      public void setList(List<ListBean> list) {

        this.list = list;
      }


      public static class ListBean {

        private String cover;

        private String favourites;

        private int is_finish;

        private int last_time;

        private String newest_ep_index;

        private int pub_time;

        private int season_id;

        private int season_status;

        private String title;

        private int watching_count;


        public String getCover() {

          return cover;
        }


        public void setCover(String cover) {

          this.cover = cover;
        }


        public String getFavourites() {

          return favourites;
        }


        public void setFavourites(String favourites) {

          this.favourites = favourites;
        }


        public int getIs_finish() {

          return is_finish;
        }


        public void setIs_finish(int is_finish) {

          this.is_finish = is_finish;
        }


        public int getLast_time() {

          return last_time;
        }


        public void setLast_time(int last_time) {

          this.last_time = last_time;
        }


        public String getNewest_ep_index() {

          return newest_ep_index;
        }


        public void setNewest_ep_index(String newest_ep_index) {

          this.newest_ep_index = newest_ep_index;
        }


        public int getPub_time() {

          return pub_time;
        }


        public void setPub_time(int pub_time) {

          this.pub_time = pub_time;
        }


        public int getSeason_id() {

          return season_id;
        }


        public void setSeason_id(int season_id) {

          this.season_id = season_id;
        }


        public int getSeason_status() {

          return season_status;
        }


        public void setSeason_status(int season_status) {

          this.season_status = season_status;
        }


        public String getTitle() {

          return title;
        }


        public void setTitle(String title) {

          this.title = title;
        }


        public int getWatching_count() {

          return watching_count;
        }


        public void setWatching_count(int watching_count) {

          this.watching_count = watching_count;
        }
      }
    }

    public static class SerializingBean {

      private String cover;

      private String favourites;

      private int is_finish;

      private int is_started;

      private int last_time;

      private String newest_ep_index;

      private int pub_time;

      private int season_id;

      private int season_status;

      private String title;

      private int watching_count;


      public String getCover() {

        return cover;
      }


      public void setCover(String cover) {

        this.cover = cover;
      }


      public String getFavourites() {

        return favourites;
      }


      public void setFavourites(String favourites) {

        this.favourites = favourites;
      }


      public int getIs_finish() {

        return is_finish;
      }


      public void setIs_finish(int is_finish) {

        this.is_finish = is_finish;
      }


      public int getIs_started() {

        return is_started;
      }


      public void setIs_started(int is_started) {

        this.is_started = is_started;
      }


      public int getLast_time() {

        return last_time;
      }


      public void setLast_time(int last_time) {

        this.last_time = last_time;
      }


      public String getNewest_ep_index() {

        return newest_ep_index;
      }


      public void setNewest_ep_index(String newest_ep_index) {

        this.newest_ep_index = newest_ep_index;
      }


      public int getPub_time() {

        return pub_time;
      }


      public void setPub_time(int pub_time) {

        this.pub_time = pub_time;
      }


      public int getSeason_id() {

        return season_id;
      }


      public void setSeason_id(int season_id) {

        this.season_id = season_id;
      }


      public int getSeason_status() {

        return season_status;
      }


      public void setSeason_status(int season_status) {

        this.season_status = season_status;
      }


      public String getTitle() {

        return title;
      }


      public void setTitle(String title) {

        this.title = title;
      }


      public int getWatching_count() {

        return watching_count;
      }


      public void setWatching_count(int watching_count) {

        this.watching_count = watching_count;
      }
    }
  }
}
