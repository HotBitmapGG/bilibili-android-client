package com.hotbitmapgg.bilibili.entity.bangumi;

import java.util.List;

/**
 * Created by hcc on 2016/10/2 16:49
 * 100332338@qq.com
 * <p>
 * 首页番剧推荐模型类
 */

public class BangumiRecommendInfo {

  /**
   * code : 0
   * message : success
   * result : [{"cover":"http://i0.hdslb.com/bfs/bangumi/bca4ece2e58b577d0ff9bca146efd8b4e47e948b.jpg","cursor":1475316000700,"desc":"青春只有一次，既不能倒带，又不能重新剪辑。\n有喜欢的人有想说的话，就快点鼓起勇气告诉对方吧！","id":1840,"is_new":1,"link":"http://bangumi.bilibili.com/anime/5575","title":"从很久以前就喜欢你了。~告白实行委员会~"},{"cover":"http://i0.hdslb.com/bfs/bangumi/338b4a048bc64098e4becc47febf65f40bb2d67b.jpg","cursor":1475229600371,"desc":"失去的记忆里包含的真相是？","id":1809,"is_new":1,"link":"http://bangumi.bilibili.com/anime/638","title":"Amnesia"},{"cover":"http://i0.hdslb.com/bfs/bangumi/c9efb2c7e6c55ae2e4329bf0a03dbc1afbfd5021.jpg","cursor":1475122560483,"desc":"I
   * am the bone of my sword.\nSteel is my body, and fire is my blood.\n\u2026\u2026","id":1818,"link":"http://bangumi.bilibili.com/anime/1586","title":"FSN
   * [UBW]"},{"cover":"http://i0.hdslb.com/bfs/bangumi/00f132c7865a0460ac060135ea65df4550e4f070.jpg","cursor":1475056800016,"desc":"未来尚未决定\n不要被绝望击垮\n希望会在未来中实现","id":1793,"link":"http://bangumi.bilibili.com/anime/5056","title":"弹丸论破3
   * -未来篇-  12"},{"cover":"http://i0.hdslb.com/bfs/bangumi/1623a26d47ad873a82cb8a20dd77d0b869b9c0de.jpg","cursor":1474970400399,"desc":"有一种青梅竹马\n叫做\u201c希望TA知道我的心意\u201d","id":1756,"link":"http://bangumi.bilibili.com/anime/2315","title":"近所物语"},{"cover":"http://i0.hdslb.com/bfs/bangumi/e17d3526ef6d67211819e1d8c07d898b48d3e30d.jpg","cursor":1474884000886,"desc":"世界的终结(ﾟДﾟ≡ﾟДﾟ)\n各种可能性的其中之一\nRewrite
   * 我们明年一月见","id":1776,"link":"http://bangumi.bilibili.com/anime/5020","title":"Rewrite
   * 13"},{"cover":"http://i0.hdslb.com/bfs/bangumi/c36b9023905f661c7632eb66be28df7a74c6bd60.jpg","cursor":1474768920759,"desc":"一位是不可一世的英雄王，一位是摒弃理想的守护者。他们都是Archer，真伪无关乎胜败。本期Fate/IT已张弦引箭。","id":1775,"link":"http://www.bilibili.com/html/activity-20160923fgo.html","title":"Fate/Infinite
   * Tales EP.3 伪物真传"},{"cover":"http://i0.hdslb.com/bfs/bangumi/f65f1d4ac0479cf438de674897ec5566c5c6ed24.jpg","cursor":1474538400044,"desc":"以绝望收尾的希望物语\nBad
   * End？本来就没有什么Happy End\n如果绝望从世上消失 那也是一种绝望吧","id":1758,"link":"http://bangumi.bilibili.com/anime/5057","title":"弹丸论破3
   * -绝望篇- 11"},{"cover":"http://i1.hdslb.com/u_user/5483832db3106345be5d1f73eacc2041.png","cursor":1474452000003,"desc":"改编自日本漫画家森薰的作品《艾玛》，是一部以19世纪的英国伦敦为舞台背景，叙说了女仆和绅士相邂逅的上流社会爱情故事。","id":23,"link":"http://bangumi.bilibili.com/anime/2998","title":"英国恋物语艾玛"},{"cover":"http://i0.hdslb.com/bfs/bangumi/a09f8d159869efacd8c6f1e83012fd4f7ebcbcf6.jpg","cursor":1474168560871,"desc":"她参加了两次圣杯战争，她是骑士精神的代表。也有人指责她\u201c不懂人心\u201d\u2026她是Saber，阿尔托莉雅·潘德拉贡。本次Fate/IT给您带来她的故事。","id":1709,"link":"http://www.bilibili.com/html/activity-20160918fgo.html","title":"Fate/Infinite
   * Tales EP.2 孤独的王者巡礼"}]
   */

  private int code;

  private String message;

  /**
   * cover : http://i0.hdslb.com/bfs/bangumi/bca4ece2e58b577d0ff9bca146efd8b4e47e948b.jpg
   * cursor : 1475316000700
   * desc : 青春只有一次，既不能倒带，又不能重新剪辑。
   * 有喜欢的人有想说的话，就快点鼓起勇气告诉对方吧！
   * id : 1840
   * is_new : 1
   * link : http://bangumi.bilibili.com/anime/5575
   * title : 从很久以前就喜欢你了。~告白实行委员会~
   */

  private List<ResultBean> result;


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


  public List<ResultBean> getResult() {

    return result;
  }


  public void setResult(List<ResultBean> result) {

    this.result = result;
  }


  public static class ResultBean {

    private String cover;

    private long cursor;

    private String desc;

    private int id;

    private int is_new;

    private String link;

    private String title;


    public String getCover() {

      return cover;
    }


    public void setCover(String cover) {

      this.cover = cover;
    }


    public long getCursor() {

      return cursor;
    }


    public void setCursor(long cursor) {

      this.cursor = cursor;
    }


    public String getDesc() {

      return desc;
    }


    public void setDesc(String desc) {

      this.desc = desc;
    }


    public int getId() {

      return id;
    }


    public void setId(int id) {

      this.id = id;
    }


    public int getIs_new() {

      return is_new;
    }


    public void setIs_new(int is_new) {

      this.is_new = is_new;
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
}
