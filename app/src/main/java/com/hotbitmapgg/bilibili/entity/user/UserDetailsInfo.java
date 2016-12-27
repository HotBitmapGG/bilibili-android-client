package com.hotbitmapgg.bilibili.entity.user;

import java.util.List;

/**
 * Created by hcc on 16/8/22 20:48
 * 100332338@qq.com
 * <p/>
 * 用户详情模型类
 */
public class UserDetailsInfo {

  /**
   * code : 0
   * card : {"mid":"185546","name":"小可儿","approve":false,"sex":"保密","rank":"10000","face":"http://i1.hdslb.com/bfs/face/5022986b528c74efadb6ab4669137214e066925c.x-png","coins":0,"DisplayRank":"1036","regtime":1312561293,"spacesta":2,"birthday":"1996-06-16","place":"上海市
   * 长宁区","description":"","article":0,"attentions":[319291,690546,374377,186759,1296804,1318455,742564,311888,482524,264264,2695314,669173,375375,644202,7329,687883,99224,201434,2986310,542884,591541,776558,699049,149065,1284747,386004,546195,2848416,602496,3857249,525024,168598,270744,2740963,6881318,547008,1770706,1272598,667850,1643718,2731733,3173802,2853209,398510,477009,12434430,430031,122879,3947820,4385354,913497,699438,12464176,322892,1894748,777536,1532165,6927351,4391879,2101645,2735222,6997378,4548018,7661994,2152304,814450,4203935,622723,454636,2778733,231563,20771487,3097441,486183,2798449,71106,9550310,11684516,1438811,1951038,423442,391679,139905,20503549,442520,22965,27434809,688969,11758387,920713,26922,8585525,10552107,8688933,4440520,10414152,13736797,3379951,8332697,689753,500198,172683,515993,328212,61999,3226226,2470678,19285836,4431898,808171,25282560,592761,1963054,234256,6332228,4138198,7508296,6510526,14634764,346059,814727,14415563,12564758,1396558,453972,1936132,24314825,43536,2459948,25775194,1652288,282994,20484551,22986236,288239,329932],"fans":139476,"friend":135,"attention":135,"sign":"粉丝的支持是我创作的源泉。\r\n微博@小可儿有剁不光的手
   * 粉丝群569465513 网易云音乐:小可儿spike","level_info":{"current_level":6,"current_min":28800,"current_exp":298859,"next_exp":"-"},"pendant":{"pid":0,"name":"","image":"","expire":0},"nameplate":{"nid":1,"name":"黄金殿堂","image":"http://i2.hdslb.com/bfs/face/82896ff40fcb4e7c7259cb98056975830cb55695.png","image_small":"http://i2.hdslb.com/bfs/face/627e342851dfda6fe7380c2fa0cbd7fae2e61533.png","level":"稀有勋章","condition":"单个自制视频总播放数>=100万"},"official_verify":{"type":-1,"desc":""}}
   */

  private int code;

  /**
   * mid : 185546
   * name : 小可儿
   * approve : false
   * sex : 保密
   * rank : 10000
   * face : http://i1.hdslb.com/bfs/face/5022986b528c74efadb6ab4669137214e066925c.x-png
   * coins : 0
   * DisplayRank : 1036
   * regtime : 1312561293
   * spacesta : 2
   * birthday : 1996-06-16
   * place : 上海市 长宁区
   * description :
   * article : 0
   * attentions : [319291,690546,374377,186759,1296804,1318455,742564,311888,482524,264264,2695314,669173,375375,644202,7329,687883,99224,201434,2986310,542884,591541,776558,699049,149065,1284747,386004,546195,2848416,602496,3857249,525024,168598,270744,2740963,6881318,547008,1770706,1272598,667850,1643718,2731733,3173802,2853209,398510,477009,12434430,430031,122879,3947820,4385354,913497,699438,12464176,322892,1894748,777536,1532165,6927351,4391879,2101645,2735222,6997378,4548018,7661994,2152304,814450,4203935,622723,454636,2778733,231563,20771487,3097441,486183,2798449,71106,9550310,11684516,1438811,1951038,423442,391679,139905,20503549,442520,22965,27434809,688969,11758387,920713,26922,8585525,10552107,8688933,4440520,10414152,13736797,3379951,8332697,689753,500198,172683,515993,328212,61999,3226226,2470678,19285836,4431898,808171,25282560,592761,1963054,234256,6332228,4138198,7508296,6510526,14634764,346059,814727,14415563,12564758,1396558,453972,1936132,24314825,43536,2459948,25775194,1652288,282994,20484551,22986236,288239,329932]
   * fans : 139476
   * friend : 135
   * attention : 135
   * sign : 粉丝的支持是我创作的源泉。
   * 微博@小可儿有剁不光的手 粉丝群569465513 网易云音乐:小可儿spike
   * level_info : {"current_level":6,"current_min":28800,"current_exp":298859,"next_exp":"-"}
   * pendant : {"pid":0,"name":"","image":"","expire":0}
   * nameplate : {"nid":1,"name":"黄金殿堂","image":"http://i2.hdslb.com/bfs/face/82896ff40fcb4e7c7259cb98056975830cb55695.png","image_small":"http://i2.hdslb.com/bfs/face/627e342851dfda6fe7380c2fa0cbd7fae2e61533.png","level":"稀有勋章","condition":"单个自制视频总播放数>=100万"}
   * official_verify : {"type":-1,"desc":""}
   */

  private CardBean card;


  public int getCode() {

    return code;
  }


  public void setCode(int code) {

    this.code = code;
  }


  public CardBean getCard() {

    return card;
  }


  public void setCard(CardBean card) {

    this.card = card;
  }


  public static class CardBean {

    private String mid;

    private String name;

    private boolean approve;

    private String sex;

    private String rank;

    private String face;

    private int coins;

    private String DisplayRank;

    private int regtime;

    private int spacesta;

    private String birthday;

    private String place;

    private String description;

    private int article;

    private int fans;

    private int friend;

    private int attention;

    private String sign;

    /**
     * current_level : 6
     * current_min : 28800
     * current_exp : 298859
     * next_exp : -
     */

    private LevelInfoBean level_info;

    /**
     * pid : 0
     * name :
     * image :
     * expire : 0
     */

    private PendantBean pendant;

    /**
     * nid : 1
     * name : 黄金殿堂
     * image : http://i2.hdslb.com/bfs/face/82896ff40fcb4e7c7259cb98056975830cb55695.png
     * image_small : http://i2.hdslb.com/bfs/face/627e342851dfda6fe7380c2fa0cbd7fae2e61533.png
     * level : 稀有勋章
     * condition : 单个自制视频总播放数>=100万
     */

    private NameplateBean nameplate;

    /**
     * type : -1
     * desc :
     */

    private OfficialVerifyBean official_verify;

    private List<Integer> attentions;


    public String getMid() {

      return mid;
    }


    public void setMid(String mid) {

      this.mid = mid;
    }


    public String getName() {

      return name;
    }


    public void setName(String name) {

      this.name = name;
    }


    public boolean isApprove() {

      return approve;
    }


    public void setApprove(boolean approve) {

      this.approve = approve;
    }


    public String getSex() {

      return sex;
    }


    public void setSex(String sex) {

      this.sex = sex;
    }


    public String getRank() {

      return rank;
    }


    public void setRank(String rank) {

      this.rank = rank;
    }


    public String getFace() {

      return face;
    }


    public void setFace(String face) {

      this.face = face;
    }


    public int getCoins() {

      return coins;
    }


    public void setCoins(int coins) {

      this.coins = coins;
    }


    public String getDisplayRank() {

      return DisplayRank;
    }


    public void setDisplayRank(String DisplayRank) {

      this.DisplayRank = DisplayRank;
    }


    public int getRegtime() {

      return regtime;
    }


    public void setRegtime(int regtime) {

      this.regtime = regtime;
    }


    public int getSpacesta() {

      return spacesta;
    }


    public void setSpacesta(int spacesta) {

      this.spacesta = spacesta;
    }


    public String getBirthday() {

      return birthday;
    }


    public void setBirthday(String birthday) {

      this.birthday = birthday;
    }


    public String getPlace() {

      return place;
    }


    public void setPlace(String place) {

      this.place = place;
    }


    public String getDescription() {

      return description;
    }


    public void setDescription(String description) {

      this.description = description;
    }


    public int getArticle() {

      return article;
    }


    public void setArticle(int article) {

      this.article = article;
    }


    public int getFans() {

      return fans;
    }


    public void setFans(int fans) {

      this.fans = fans;
    }


    public int getFriend() {

      return friend;
    }


    public void setFriend(int friend) {

      this.friend = friend;
    }


    public int getAttention() {

      return attention;
    }


    public void setAttention(int attention) {

      this.attention = attention;
    }


    public String getSign() {

      return sign;
    }


    public void setSign(String sign) {

      this.sign = sign;
    }


    public LevelInfoBean getLevel_info() {

      return level_info;
    }


    public void setLevel_info(LevelInfoBean level_info) {

      this.level_info = level_info;
    }


    public PendantBean getPendant() {

      return pendant;
    }


    public void setPendant(PendantBean pendant) {

      this.pendant = pendant;
    }


    public NameplateBean getNameplate() {

      return nameplate;
    }


    public void setNameplate(NameplateBean nameplate) {

      this.nameplate = nameplate;
    }


    public OfficialVerifyBean getOfficial_verify() {

      return official_verify;
    }


    public void setOfficial_verify(OfficialVerifyBean official_verify) {

      this.official_verify = official_verify;
    }


    public List<Integer> getAttentions() {

      return attentions;
    }


    public void setAttentions(List<Integer> attentions) {

      this.attentions = attentions;
    }


    public static class LevelInfoBean {

      private int current_level;

      private int current_min;

      private int current_exp;

      private String next_exp;


      public int getCurrent_level() {

        return current_level;
      }


      public void setCurrent_level(int current_level) {

        this.current_level = current_level;
      }


      public int getCurrent_min() {

        return current_min;
      }


      public void setCurrent_min(int current_min) {

        this.current_min = current_min;
      }


      public int getCurrent_exp() {

        return current_exp;
      }


      public void setCurrent_exp(int current_exp) {

        this.current_exp = current_exp;
      }


      public String getNext_exp() {

        return next_exp;
      }


      public void setNext_exp(String next_exp) {

        this.next_exp = next_exp;
      }
    }

    public static class PendantBean {

      private int pid;

      private String name;

      private String image;

      private int expire;


      public int getPid() {

        return pid;
      }


      public void setPid(int pid) {

        this.pid = pid;
      }


      public String getName() {

        return name;
      }


      public void setName(String name) {

        this.name = name;
      }


      public String getImage() {

        return image;
      }


      public void setImage(String image) {

        this.image = image;
      }


      public int getExpire() {

        return expire;
      }


      public void setExpire(int expire) {

        this.expire = expire;
      }
    }

    public static class NameplateBean {

      private int nid;

      private String name;

      private String image;

      private String image_small;

      private String level;

      private String condition;


      public int getNid() {

        return nid;
      }


      public void setNid(int nid) {

        this.nid = nid;
      }


      public String getName() {

        return name;
      }


      public void setName(String name) {

        this.name = name;
      }


      public String getImage() {

        return image;
      }


      public void setImage(String image) {

        this.image = image;
      }


      public String getImage_small() {

        return image_small;
      }


      public void setImage_small(String image_small) {

        this.image_small = image_small;
      }


      public String getLevel() {

        return level;
      }


      public void setLevel(String level) {

        this.level = level;
      }


      public String getCondition() {

        return condition;
      }


      public void setCondition(String condition) {

        this.condition = condition;
      }
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
