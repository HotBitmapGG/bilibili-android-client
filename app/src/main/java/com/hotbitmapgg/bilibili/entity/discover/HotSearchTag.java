package com.hotbitmapgg.bilibili.entity.discover;

import java.util.List;

/**
 * Created by hcc on 2016/10/3 11:49
 * 100332338@qq.com
 * <p>
 * 热搜标签模型类
 */

public class HotSearchTag {

  /**
   * code : 0
   * seid : 13221345400259876795
   * message : success
   * timestamp : 1474882939
   * list : [{"keyword":"釜山行","status":"keep"},{"keyword":"极乐净土","status":"keep"},{"keyword":"吃货木下","status":"keep"},{"keyword":"一年生","status":"keep"},{"keyword":"re：从零开始的异世界生活","status":"up"},{"keyword":"麻雀","status":"down"},{"keyword":"守望先锋","status":"up"},{"keyword":"张继科","status":"up"},{"keyword":"暴走大事件","status":"up"},{"keyword":"不可抗力","status":"down"},{"keyword":"你的名字","status":"down"},{"keyword":"刺客列传","status":"down"},{"keyword":"主播真会玩","status":"up"},{"keyword":"蜡笔小新","status":"down"},{"keyword":"主播炸了","status":"up"},{"keyword":"亲爱的公主病","status":"down"},{"keyword":"识汝不识丁","status":"keep"},{"keyword":"玻璃芦苇","status":"up"},{"keyword":"贤者之爱","status":"keep"},{"keyword":"敖厂长","status":"up"},{"keyword":"谷阿莫","status":"up"},{"keyword":"起小点","status":"up"},{"keyword":"杨洋","status":"down"},{"keyword":"逗鱼时刻","status":"up"},{"keyword":"食戟之灵","status":"up"},{"keyword":"一人之下","status":"down"},{"keyword":"阴阳师","status":"up"},{"keyword":"抗韩中年人","status":"up"},{"keyword":"snh48","status":"up"},{"keyword":"陈玘","status":"down"},{"keyword":"火影忍者","status":"keep"},{"keyword":"我们战斗吧","status":"up"},{"keyword":"马男波杰克","status":"up"},{"keyword":"徐老师来巡山","status":"up"},{"keyword":"隧道","status":"keep"},{"keyword":"老e","status":"up"},{"keyword":"大胃王密子君","status":"up"},{"keyword":"污咚采访间","status":"down"},{"keyword":"齐木楠雄的灾难","status":"down"},{"keyword":"马龙","status":"up"},{"keyword":"日剧","status":"down"},{"keyword":"狐妖小红娘","status":"down"},{"keyword":"薛之谦","status":"up"},{"keyword":"w两个世界","status":"down"},{"keyword":"微微一笑很倾城","status":"up"},{"keyword":"镇魂街","status":"down"},{"keyword":"乔任梁","status":"down"},{"keyword":"流感","status":"up"},{"keyword":"张若昀","status":"up"},{"keyword":"张继科丁宁","status":"down"}]
   * cost : {"timer":"hotword","total":"0.000244","read file":"0.000167"}
   */

  private int code;

  private String seid;

  private String message;

  private int timestamp;

  /**
   * keyword : 釜山行
   * status : keep
   */

  private List<ListBean> list;


  public List<ListBean> getList() {

    return list;
  }


  public void setList(List<ListBean> list) {

    this.list = list;
  }


  public static class ListBean {

    private String keyword;

    private String status;


    public String getKeyword() {

      return keyword;
    }


    public void setKeyword(String keyword) {

      this.keyword = keyword;
    }


    public String getStatus() {

      return status;
    }


    public void setStatus(String status) {

      this.status = status;
    }
  }
}
