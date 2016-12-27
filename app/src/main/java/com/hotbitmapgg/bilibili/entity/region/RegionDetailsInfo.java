package com.hotbitmapgg.bilibili.entity.region;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hcc on 2016/10/22 01:29
 * 100332338@qq.com
 * <p>
 * 分区类型详情模型类
 */

public class RegionDetailsInfo {

  /**
   * code : 0
   * data : {"recommend":[{"title":"【AMV/60fps】视觉的极致盛宴 Umbrella Corp【Nostromo】","cover":"http://i0.hdslb.com/bfs/archive/70315d46e396d55cc6785a1bf8caf114cef0cbcc.jpg","uri":"bilibili://video/6733923","param":"6733923","goto":"av","name":"ここにいるよ","play":224795,"danmaku":1858,"reply":1280,"favourite":40890},{"title":"[AMV]仅此一次的迷恋","cover":"http://i1.hdslb.com/bfs/archive/db961c2557f9f874b743408e135a126de0d0da09.jpg","uri":"bilibili://video/6750386","param":"6750386","goto":"av","name":"Cola141","play":12613,"danmaku":161,"reply":190,"favourite":1612},{"title":"【一拳超人/ASMV/高燃】何谓英雄？","cover":"http://i0.hdslb.com/bfs/archive/84573cebeedb945c7ebc5816a4f2b51e9494137b.jpg","uri":"bilibili://video/6737761","param":"6737761","goto":"av","name":"荀宓","play":13374,"danmaku":139,"reply":58,"favourite":332},{"title":"【疯味英雄×纳米核心】自由的微光（疯味英雄第一季完结恭贺！）","cover":"http://i0.hdslb.com/bfs/archive/a99b119d43346463d4d5decdc6acf17be0c1d4f3.jpg","uri":"bilibili://video/6753855","param":"6753855","goto":"av","name":"紫银风","play":7813,"danmaku":158,"reply":185,"favourite":279}],"new":[{"title":"【超燃/AMV】\u2022
   * Runnin ♫♪","cover":"http://i1.hdslb.com/bfs/archive/ddbd80d656994ff6d9b1250ca8da7c3fc9154fc1.jpg","uri":"bilibili://video/6770288","param":"6770288","goto":"av","name":"来自火星的小火龙"},{"title":"在没有星星的夜晚
   * 该向什么许愿呢？","cover":"http://i1.hdslb.com/bfs/archive/0225981c68a8b35b9112616a29608b0cb8850fac.jpg","uri":"bilibili://video/6770214","param":"6770214","goto":"av","name":"超非洲的盖子君"},{"title":"【FGO
   * MAD】RAGE OF DUST【另一版本】","cover":"http://i1.hdslb.com/bfs/archive/0d27917cb159fc461165c5f7b12a0baa78071cf9.jpg","uri":"bilibili://video/6770203","param":"6770203","goto":"av","name":"雷姆斯卡蕾特"},{"title":"Call
   * your name\u2014\u2014进击的巨人","cover":"http://i2.hdslb.com/bfs/archive/4686b56d703024d5862998a5f4342aeb028c19a9.jpg","uri":"bilibili://video/6770151","param":"6770151","goto":"av","name":"是兀唸不是勿念"},{"title":"背负一切罪名，就算万劫不复！又耐我何！！！","cover":"http://i1.hdslb.com/bfs/archive/04d948eacf61994101576860628cdb595274b5ca.jpg","uri":"bilibili://video/6770099","param":"6770099","goto":"av","name":"丿浅夏灬无恙丨夏殇","play":18,"reply":5},{"title":"【欢乐向AMV】六花的滑板鞋","cover":"http://i0.hdslb.com/bfs/archive/e0f43cd88bf26712a8b43d54695b4a44f751ee43.png","uri":"bilibili://video/6770054","param":"6770054","goto":"av","name":"然续","play":15,"reply":2,"favourite":2},{"title":"The
   * Truth That You Leave","cover":"http://i0.hdslb.com/bfs/archive/d65c464a32b9966e11d8d533fe8f3d447d114b41.png","uri":"bilibili://video/6770028","param":"6770028","goto":"av","name":"从零开始的新手君","play":17,"reply":1},{"title":"六花勇太虐狗日常
   * 自剪辑","cover":"http://i0.hdslb.com/bfs/archive/f4ce970cee9696821edcccee5970cb7fc4a80c66.jpg","uri":"bilibili://video/6769959","param":"6769959","goto":"av","name":"雁行歌","play":11,"reply":2},{"title":"《镇魂街》主题曲MV（不愿回头）","cover":"http://i2.hdslb.com/bfs/archive/c66f1cd9c5c39c17f41a071066e60a1ea52b1861.jpg","uri":"bilibili://video/6769873","param":"6769873","goto":"av","name":"吃草莓的苹果","play":29,"favourite":2},{"title":"【序章】六等星之夜\u2014\u2014
   *   一点综漫","cover":"http://i1.hdslb.com/bfs/archive/45a2290d430ecd47455cec2d57385cdabf19814f.png","uri":"bilibili://video/6769681","param":"6769681","goto":"av","name":"来自六等星の一点团长","play":7},{"title":"【K-ONx绝望先生】绝望的啦！【轻音少女op】","cover":"http://i0.hdslb.com/bfs/archive/848a4ab5e6bbb1e29f4cb98de0bddb9efa730c6c.png","uri":"bilibili://video/6769634","param":"6769634","goto":"av","name":"屏幕另一边迷云","play":6,"favourite":2},{"title":"【MAD】【初投稿】我只想和你一直在一起","cover":"http://i1.hdslb.com/bfs/archive/df04e2017fe5dd581a653a9fab2c15d60128c821.jpg","uri":"bilibili://video/6769564","param":"6769564","goto":"av","name":"Bitchings","play":42,"reply":2},{"title":"伪恋--一直喜欢着你","cover":"http://i1.hdslb.com/bfs/archive/29794deee070dd722c5441cc1ea3c2331d7788f1.jpg","uri":"bilibili://video/6769536","param":"6769536","goto":"av","name":"wang69","play":29,"reply":1},{"title":"[MAD][终末的伊泽塔]捏死德系","cover":"http://i1.hdslb.com/bfs/archive/c3e83ea47feb797eccfa6ea3cec876173c17d617.jpg","uri":"bilibili://video/6769529","param":"6769529","goto":"av","name":"蜜汁P0I","play":12,"reply":1,"favourite":2},{"title":"【木津千里x糸色望】
   * ～再见的记忆～","cover":"http://i0.hdslb.com/bfs/archive/393365b3786f910d8561099e49146506cbbfc65f.jpg","uri":"bilibili://video/6769488","param":"6769488","goto":"av","name":"屏幕另一边迷云","play":2,"favourite":2},{"title":"只要不曾后退
   * 慢一点又何妨？","cover":"http://i0.hdslb.com/bfs/archive/f41f6b412e8612deda326676ab3f2b5e9eec3926.jpg","uri":"bilibili://video/6769396","param":"6769396","goto":"av","name":"超非洲的盖子君","play":25,"reply":1,"favourite":2},{"title":"【K-ONx绝望先生】Don't
   * say despair！！！【轻音少女ed】","cover":"http://i0.hdslb.com/bfs/archive/dcc37a6c6528a6a3fe9d663fbd16cc2aac67c8e3.png","uri":"bilibili://video/6769362","param":"6769362","goto":"av","name":"屏幕另一边迷云","play":6},{"title":"fate混剪，新人渣作（反正我不求硬币关注收藏香蕉_(:з」∠)_","cover":"http://i2.hdslb.com/bfs/archive/ecf65f65934cb285a2117c05e3c438cf9e6901f1.jpg","uri":"bilibili://video/6769327","param":"6769327","goto":"av","name":"不同的开始","play":22},{"title":"【华语/多素材/AMV】她说
   * 林俊杰","cover":"http://i1.hdslb.com/bfs/archive/376e63b92a9fd8904773f36b33d12ca8179a1725.jpg","uri":"bilibili://video/6769313","param":"6769313","goto":"av","name":"怂Graduate","play":11},{"title":"【Fate
   * 剧情向 燃 原创】Last Stardust","cover":"http://i0.hdslb.com/bfs/archive/c7bd306db377de8700fdfb0002d04a09f174fe1c.jpg","uri":"bilibili://video/6769291","param":"6769291","goto":"av","name":"樱满辰","play":48,"reply":2}]}
   * message :
   */

  private int code;

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

    /**
     * title : 【AMV/60fps】视觉的极致盛宴 Umbrella Corp【Nostromo】
     * cover : http://i0.hdslb.com/bfs/archive/70315d46e396d55cc6785a1bf8caf114cef0cbcc.jpg
     * uri : bilibili://video/6733923
     * param : 6733923
     * goto : av
     * name : ここにいるよ
     * play : 224795
     * danmaku : 1858
     * reply : 1280
     * favourite : 40890
     */

    private List<RecommendBean> recommend;

    /**
     * title : 【超燃/AMV】• Runnin ♫♪
     * cover : http://i1.hdslb.com/bfs/archive/ddbd80d656994ff6d9b1250ca8da7c3fc9154fc1.jpg
     * uri : bilibili://video/6770288
     * param : 6770288
     * goto : av
     * name : 来自火星的小火龙
     */

    @SerializedName("new")
    private List<NewBean> newX;


    public List<RecommendBean> getRecommend() {

      return recommend;
    }


    public void setRecommend(List<RecommendBean> recommend) {

      this.recommend = recommend;
    }


    public List<NewBean> getNewX() {

      return newX;
    }


    public void setNewX(List<NewBean> newX) {

      this.newX = newX;
    }


    public static class RecommendBean {

      private String title;

      private String cover;

      private String uri;

      private String param;

      @SerializedName("goto")
      private String gotoX;

      private String name;

      private int play;

      private int danmaku;

      private int reply;

      private int favourite;


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


      public String getName() {

        return name;
      }


      public void setName(String name) {

        this.name = name;
      }


      public int getPlay() {

        return play;
      }


      public void setPlay(int play) {

        this.play = play;
      }


      public int getDanmaku() {

        return danmaku;
      }


      public void setDanmaku(int danmaku) {

        this.danmaku = danmaku;
      }


      public int getReply() {

        return reply;
      }


      public void setReply(int reply) {

        this.reply = reply;
      }


      public int getFavourite() {

        return favourite;
      }


      public void setFavourite(int favourite) {

        this.favourite = favourite;
      }
    }

    public static class NewBean {

      private String title;

      private String cover;

      private String uri;

      private String param;

      @SerializedName("goto")
      private String gotoX;

      private String name;

      private int play;

      private int danmaku;


      public int getDanmaku() {

        return danmaku;
      }


      public void setDanmaku(int danmaku) {

        this.danmaku = danmaku;
      }


      public int getPlay() {

        return play;
      }


      public void setPlay(int play) {

        this.play = play;
      }


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


      public String getName() {

        return name;
      }


      public void setName(String name) {

        this.name = name;
      }
    }
  }
}
