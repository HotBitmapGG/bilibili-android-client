package com.hotbitmapgg.bilibili.entity.live;

import java.util.List;

/**
 * Created by hcc on 2016/10/19 18:31
 * 100332338@qq.com
 * <p>
 * 直播模型类
 */

public class LiveAppIndexInfo {

  private int code;

  private String message;

  private DataBean data;


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


  public DataBean getData() {

    return data;
  }


  public void setData(DataBean data) {

    this.data = data;
  }


  public static class DataBean {

    /**
     * lives : [{"owner":{"face":"http://i0.hdslb.com/bfs/face/ccc601508ae54a3497500adcef7b3ca52309d42f.jpg","mid":10465808,"name":"优酱是咸鱼"},"cover":{"src":"http://i0.hdslb.com/bfs/live/ec251dcd388e0c9ffbc89c1c428894db811639e2.jpg","height":180,"width":320},"title":"话唠优陪你们看《世间奇妙物语》","room_id":330355,"check_version":0,"online":8992,"area":"生活娱乐","area_id":6,"playurl":"http://live-play.acgvideo.com/live/967/live_10465808_1182056.flv?wsSecret=417545f3a960fa159f3b59051dbc708d&wsTime=57dfcc85","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/1e31ac069058528e26b9be60b26d86c9c9a99f62.jpg","mid":227933,"name":"坂本叔"},"cover":{"src":"http://i0.hdslb.com/bfs/live/89047f3faee35d0cb095d7dfb01ec4d3a8ec4434.jpg","height":180,"width":320},"title":"【坂本】直播吧唧嘴","room_id":5067,"check_version":0,"online":8333,"area":"单机联机","area_id":1,"playurl":"http://xl.live-play.acgvideo.com/live-xl/924151/live_227933_4064547.flv?wsSecret=16e35ca73f01b98f8e5ba6a66d4909d8&wsTime=1476874877","accept_quality":"4","broadcast_type":1,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/cdecf4ce52126ad96e80ce2028fcc7c8ae497133.jpg","mid":1111078,"name":"明希kirara"},"cover":{"src":"http://i0.hdslb.com/bfs/live/2e3f5de2de6a9ea05e4b5f5b947a92ae8c1925ca.jpg","height":180,"width":320},"title":"【剑三】体验老年奶妈的日常","room_id":22361,"check_version":0,"online":2136,"area":"网络游戏","area_id":3,"playurl":"http://xl.live-play.acgvideo.com/live-xl/755073/live_1111078_4132556.flv?wsSecret=34cba52957e400be211304805c323c10&wsTime=1476874876","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/0dce98b18b705942119b322d813e651a6306bc22.jpg","mid":2066385,"name":"优璃亚"},"cover":{"src":"http://i0.hdslb.com/bfs/live/2c5f76e52f21b23b63126acd10d3195f2cf454fc.jpg","height":180,"width":320},"title":"海未cos舞娘觉醒试妆","room_id":45745,"check_version":0,"online":1823,"area":"手机直播","area_id":11,"playurl":"http://live-play.acgvideo.com/live/274/live_2066385_332_c521e483.flv?wsSecret=7b96a9c356244992d46c5266e9a59342&wsTime=57dfcc84","accept_quality":"4","broadcast_type":1,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/db834ecdd74e573e39e341048bb86ec0f9ff9e14.jpg","mid":13785381,"name":"起风了bilibili"},"cover":{"src":"http://i0.hdslb.com/bfs/live/b9a2d52925bc023cc04ddad389d0b682d39101ea.jpg","height":180,"width":320},"title":"滑天下之大稽～","room_id":1104534,"check_version":0,"online":184,"area":"手机直播","area_id":11,"playurl":"http://live-play.acgvideo.com/live/370/live_13785381_5643033.flv?wsSecret=163df8d8fb56926bc979c40642c77654&wsTime=57dfcc85","accept_quality":"4","broadcast_type":1,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/4259c7cbbc6fa947f3c2c57ddc9ecde2c2137d41.jpg","mid":15755385,"name":"兔兔兔兔兔先生"},"cover":{"src":"http://i0.hdslb.com/bfs/live/439e26906d6394ce42bc8e4d08c2182d6a0c3a1b.jpg","height":180,"width":320},"title":"智障兔兔的女生宿舍日常","room_id":904515,"check_version":0,"online":674,"area":"手机直播","area_id":11,"playurl":"http://live-play.acgvideo.com/live/256/live_15755385_8201720.flv?wsSecret=c8797c123d639aefab28363b93f012f9&wsTime=57dfcc85","accept_quality":"4","broadcast_type":1,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/30b16bd68390ec7efca1dd5e50d72b7a2358c5cc.jpg","mid":13557341,"name":"黑灵是哥哥"},"cover":{"src":"http://i0.hdslb.com/bfs/live/99112d283f84ca2f88b4886389cf66e2d5557585.jpg","height":180,"width":320},"title":"声控福利:如果我是李白白你会爱我么？","room_id":209929,"check_version":0,"online":5926,"area":"手游直播","area_id":12,"playurl":"http://live-play.acgvideo.com/live/594/live_13557341_9215495.flv?wsSecret=245a580d67400d02fd78f701323cd8ad&wsTime=57dfcc85","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/568eb2786538ddd8bddb8de1a7173712956fb11a.jpg","mid":7946235,"name":"顾顾Sama"},"cover":{"src":"http://i0.hdslb.com/bfs/live/67aaa7300b5f259bc702aee6fab9c6c5e69a9e22.jpg","height":180,"width":320},"title":"亡者农药
     *  露娜专场 深夜开车","room_id":90713,"check_version":0,"online":2024,"area":"手游直播","area_id":12,"playurl":"http://live-play.acgvideo.com/live/777/live_7946235_9935841.flv?wsSecret=067d569c9bbefa5989c8cc9c8ad6260d&wsTime=57dfcc85","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/63d71b549266e06e6994617fd8243c023b033232.jpg","mid":6092812,"name":"伤影OvO"},"cover":{"src":"http://i0.hdslb.com/bfs/live/daa3db8503b66a863a4805c4633f6097979e5448.jpg","height":180,"width":320},"title":"【耳朵怀孕】谁敢说我不帅！！！！","room_id":36501,"check_version":0,"online":1643,"area":"唱见舞见","area_id":10,"playurl":"http://dl.live-play.acgvideo.com/live-dl/929550/live_6092812_8930317.flv?wsSecret=ce575ca3d437a4f2d8b6010823d9bd15&wsTime=1476874878","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/5aece626a1f9407782c50f43c7094ffd1561cb63.jpg","mid":714742,"name":"愚者木心-冬嶙"},"cover":{"src":"http://i0.hdslb.com/bfs/live/69c1234d1b60db629c128b07cfa8956aca8a9e84.jpg","height":180,"width":320},"title":"【冬嶙】说个笑话
     * 最新版本的直播姬","room_id":100387,"check_version":0,"online":1648,"area":"绘画专区","area_id":9,"accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/47be42efd52cd09a4deaac79ca731738671a0e87.jpg","mid":2974457,"name":"你右肩停靠的蝴蝶"},"cover":{"src":"http://i0.hdslb.com/bfs/live/3b081982116f7aa34909545712ae4851bed51935.jpg","height":180,"width":320},"title":"克里尔辣舞","room_id":77410,"check_version":0,"online":234,"area":"网络游戏","area_id":3,"playurl":"http://live-play.acgvideo.com/live/838/live_2974457_8231767.flv?wsSecret=043ea4dd284b3ab176820dfcfa1c235f&wsTime=57dfcc86","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/8e060a781cb3f23a0a5c7209c9494f682b95bde9.jpg","mid":32671281,"name":"苏凉不凉"},"cover":{"src":"http://i0.hdslb.com/bfs/live/a93e55a4a1d6f5e5869c7c0f88267ca707c65a78.jpg","height":180,"width":320},"title":"上王者不如上王者","room_id":282533,"check_version":0,"online":25,"area":"电子竞技","area_id":4,"playurl":"http://live-play.acgvideo.com/live/677/live_32671281_8531648.flv?wsSecret=cf29cff6b2f007fbeb31a55bedf4b40b&wsTime=57dfcc86","accept_quality":"4","broadcast_type":0,"is_tv":0}]
     * partition : {"id":0,"name":"推荐主播","area":"hot","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/xxhdpi/-1.png?2016101804","height":"63","width":"63"},"count":2912}
     * banner_data : [{"owner":{"face":"http://i1.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg","mid":11153765,"name":"哔哩哔哩音乐台"},"cover":{"src":"http://i0.hdslb.com/bfs/live/98c268f907705241a3e3face25ae365e3120406b.png","height":180,"width":320},"title":"【官方】哔哩哔哩官方音乐台","room_id":23058,"check_version":0,"online":21399,"area":"放映厅","area_id":7,"playurl":"http://yf.live-play.acgvideo.com/live-yf/447377/live_11153765_9369560.flv?wsSecret=101bde8c6987e473119495603cd728b6&wsTime=1476874886","accept_quality":"4","broadcast_type":0,"is_tv":0}]
     */

    private RecommendDataBean recommend_data;

    /**
     * title : 红叶祭，大航海特权任你挑
     * img : http://i0.hdslb.com/bfs/live/fb21be087eba0a8b194ab412ceef42019a7c45df.jpg
     * remark : 红叶祭
     * link : http://live.bilibili.com/AppBanner/index?id=314
     */

    private List<BannerBean> banner;

    /**
     * id : 11
     * name : 手机直播
     * entrance_icon : {"src":"http://static.hdslb.com/live-static/images/mobile/android/big/xxhdpi/11_big.png?2016101804","height":"132","width":"132"}
     */

    private List<EntranceIconsBean> entranceIcons;

    /**
     * partition : {"id":9,"name":"绘画专区","area":"draw","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/xxhdpi/9.png?2016101804","height":"63","width":"63"},"count":102}
     * lives : [{"owner":{"face":"http://i1.hdslb.com/bfs/face/177eee10fbe516870c3103111a0dc4bd9477b4b5.jpg","mid":856751,"name":"Mr_Nobady"},"cover":{"src":"http://i0.hdslb.com/bfs/live/673bbb3b1f2d1460ae624fa82cf42e244a578d9a.jpg","height":180,"width":320},"title":"\\
     * Mr.Nobady /  主营：绘画，游戏，闲聊","room_id":543804,"check_version":0,"online":13,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/259/live_856751_6040403.flv?wsSecret=c4880e00d12d6d35107661f8ad9b1c16&wsTime=57dfcc85","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/5fb281e45f38ed3d26e777ff0bd568620721f348.jpg","mid":32420651,"name":"魈尧xy"},"cover":{"src":"http://i0.hdslb.com/bfs/live/6ebdb4407e5cf60505a11fda7882345e7729f3ac.jpg","height":180,"width":320},"title":"古风立绘渣渣渣","room_id":1048570,"check_version":0,"online":25,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/854/live_32420651_5931437.flv?wsSecret=dcebd0583bd1f8fb472837b1fa5a2414&wsTime=57dfcc85","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/5aece626a1f9407782c50f43c7094ffd1561cb63.jpg","mid":714742,"name":"愚者木心-冬嶙"},"cover":{"src":"http://i0.hdslb.com/bfs/live/69c1234d1b60db629c128b07cfa8956aca8a9e84.jpg","height":180,"width":320},"title":"【冬嶙】说个笑话
     * 最新版本的直播姬","room_id":100387,"check_version":0,"online":1648,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/611/live_714742_7843932.flv?wsSecret=9e55fb08c858e7a13a710c1486a960e7&wsTime=57dfcc85","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/6ee91036fcb7943769450de81d62caeae5248b71.jpg","mid":31034263,"name":"穆逢春"},"cover":{"src":"http://i0.hdslb.com/bfs/live/ff3c33bbbfe4a1c905519c300112138c1468bcf0.jpg","height":180,"width":320},"title":"斗罗漫画169话制作","room_id":258940,"check_version":0,"online":511,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/344/live_31034263_8416467.flv?wsSecret=e83caf608e15ba328b7ca5d80979868e&wsTime=57dfcc85","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/7e1730da1cf93d0ec6a90867a87efa49e367b240.jpg","mid":2148843,"name":"喵尼玛啊"},"cover":{"src":"http://i0.hdslb.com/bfs/live/e0d8be9728e2044e28fc12c8bd9748b7391f9a6c.jpg","height":180,"width":320},"title":"耽美漫\u2026直男慎入\u2026","room_id":82535,"check_version":0,"online":1146,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/171/live_2148843_6070680.flv?wsSecret=0b242e7093bd00e2f41c57d84849f166&wsTime=57dfcc85","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/91d4da4f99d8f391b3b3baf5255ea383313ed28b.jpg","mid":1904878,"name":"fedsnk"},"cover":{"src":"http://i0.hdslb.com/bfs/live/c226f4950f3a1dcd462979d395e18040cb7866e1.jpg","height":180,"width":320},"title":"不是本子舰娘温泉福利图","room_id":32731,"check_version":0,"online":239,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/826/live_1904878_1788643.flv?wsSecret=f7914635c551e6a5f6be726716149c91&wsTime=57dfcc85","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/f3a16a30bef3fd32fc5c4313bc301b31069d7afb.jpg","mid":3383805,"name":"雪代薰"},"cover":{"src":"http://i0.hdslb.com/bfs/live/30f59e8ce23620ecdc10ad69727afaaa4f84707c.jpg","height":180,"width":320},"title":"直播摸鱼","room_id":109478,"check_version":0,"online":97,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/398/live_3383805_1483272.flv?wsSecret=e646f820b33e6fe0ca6c4e5def9b5d31&wsTime=57dfcc85","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/548fe33c0f945535c40e5d070918ae4d595a75f0.gif","mid":1296509,"name":"千堂悠"},"cover":{"src":"http://i0.hdslb.com/bfs/live/349f1ef6671c60b5739ccfe724e1ac5e0a22a820.jpg","height":180,"width":320},"title":"画画","room_id":92825,"check_version":0,"online":603,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/966/live_1296509_6232518.flv?wsSecret=8d37c77c8029cc3f6aff57ac13d1c3fa&wsTime=57dfcc85","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/0f0016850de7bc978f5d600674e6df5b324ee273.jpg","mid":140328,"name":"冷场施法者"},"cover":{"src":"http://i0.hdslb.com/bfs/live/30ead017d4fcf5a1b40e15596ae20cc5f49b21d7.jpg","height":180,"width":320},"title":"专门定制B站大汇源头像及首页头图","room_id":90491,"check_version":0,"online":153,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/159/live_140328_9053316.flv?wsSecret=eb457b38e41fb00944e9324f37c0bc11&wsTime=57dfcc85","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/e054a667088c4ecc9b8f7b4cf305908d6c836c0d.jpg","mid":10768119,"name":"喵呐戈bili"},"cover":{"src":"http://i0.hdslb.com/bfs/live/66fbda9d7b9e85afd4d8eeee72b056590e55c119.jpg","height":180,"width":320},"title":"画画与游戏不可兼得。。。。。","room_id":141087,"check_version":0,"online":8,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/908/live_10768119_9035338.flv?wsSecret=9b73ea8cec3ed2e28b62fb7e85e80fb9&wsTime=57dfcc85","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/a2c42ee868b7bc2a8a3ce78bc20650b564ce153f.jpg","mid":11701895,"name":"APH王嘉龙痴汉协会"},"cover":{"src":"http://i0.hdslb.com/bfs/live/2c43fa5063f8758f5c07a2c5e805f1c29e8925dc.jpg","height":180,"width":320},"title":"［APH］耽美。。。不喜欢的千万别点","room_id":352115,"check_version":0,"online":18,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/552/live_11701895_6094681.flv?wsSecret=009bc63b099d353ed3f7eac4c7f71e5a&wsTime=57dfcc85","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/1a42f33bdf69b0c63e2ae5f375676aeae8f8b2fc.jpg","mid":2617208,"name":"KiSei2"},"cover":{"src":"http://i0.hdslb.com/bfs/live/7a9093bfb0240eae83db02b258ed4593dc152d2c.jpg","height":180,"width":320},"title":"正在成为魔法少女","room_id":1480181,"check_version":0,"online":41,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/416/live_2617208_1692230.flv?wsSecret=a9c34b447e506171bfa8a4766ecc559f&wsTime=57dfcc85","accept_quality":"4","broadcast_type":0,"is_tv":0}]
     */

    private List<PartitionsBean> partitions;


    public RecommendDataBean getRecommend_data() {

      return recommend_data;
    }


    public void setRecommend_data(RecommendDataBean recommend_data) {

      this.recommend_data = recommend_data;
    }


    public List<BannerBean> getBanner() {

      return banner;
    }


    public void setBanner(List<BannerBean> banner) {

      this.banner = banner;
    }


    public List<EntranceIconsBean> getEntranceIcons() {

      return entranceIcons;
    }


    public void setEntranceIcons(List<EntranceIconsBean> entranceIcons) {

      this.entranceIcons = entranceIcons;
    }


    public List<PartitionsBean> getPartitions() {

      return partitions;
    }


    public void setPartitions(List<PartitionsBean> partitions) {

      this.partitions = partitions;
    }


    public static class RecommendDataBean {

      /**
       * id : 0
       * name : 推荐主播
       * area : hot
       * sub_icon : {"src":"http://static.hdslb.com/live-static/images/mobile/android/small/xxhdpi/-1.png?2016101804","height":"63","width":"63"}
       * count : 2912
       */

      private PartitionBean partition;

      /**
       * owner : {"face":"http://i0.hdslb.com/bfs/face/ccc601508ae54a3497500adcef7b3ca52309d42f.jpg","mid":10465808,"name":"优酱是咸鱼"}
       * cover : {"src":"http://i0.hdslb.com/bfs/live/ec251dcd388e0c9ffbc89c1c428894db811639e2.jpg","height":180,"width":320}
       * title : 话唠优陪你们看《世间奇妙物语》
       * room_id : 330355
       * check_version : 0
       * online : 8992
       * area : 生活娱乐
       * area_id : 6
       * playurl : http://live-play.acgvideo.com/live/967/live_10465808_1182056.flv?wsSecret=417545f3a960fa159f3b59051dbc708d&wsTime=57dfcc85
       * accept_quality : 4
       * broadcast_type : 0
       * is_tv : 0
       */

      private List<LivesBean> lives;

      /**
       * owner : {"face":"http://i1.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg","mid":11153765,"name":"哔哩哔哩音乐台"}
       * cover : {"src":"http://i0.hdslb.com/bfs/live/98c268f907705241a3e3face25ae365e3120406b.png","height":180,"width":320}
       * title : 【官方】哔哩哔哩官方音乐台
       * room_id : 23058
       * check_version : 0
       * online : 21399
       * area : 放映厅
       * area_id : 7
       * playurl : http://yf.live-play.acgvideo.com/live-yf/447377/live_11153765_9369560.flv?wsSecret=101bde8c6987e473119495603cd728b6&wsTime=1476874886
       * accept_quality : 4
       * broadcast_type : 0
       * is_tv : 0
       */

      private List<BannerDataBean> banner_data;


      public PartitionBean getPartition() {

        return partition;
      }


      public void setPartition(PartitionBean partition) {

        this.partition = partition;
      }


      public List<LivesBean> getLives() {

        return lives;
      }


      public void setLives(List<LivesBean> lives) {

        this.lives = lives;
      }


      public List<BannerDataBean> getBanner_data() {

        return banner_data;
      }


      public void setBanner_data(List<BannerDataBean> banner_data) {

        this.banner_data = banner_data;
      }


      public static class PartitionBean {

        private int id;

        private String name;

        private String area;

        /**
         * src : http://static.hdslb.com/live-static/images/mobile/android/small/xxhdpi/-1.png?2016101804
         * height : 63
         * width : 63
         */

        private SubIconBean sub_icon;

        private int count;


        public int getId() {

          return id;
        }


        public void setId(int id) {

          this.id = id;
        }


        public String getName() {

          return name;
        }


        public void setName(String name) {

          this.name = name;
        }


        public String getArea() {

          return area;
        }


        public void setArea(String area) {

          this.area = area;
        }


        public SubIconBean getSub_icon() {

          return sub_icon;
        }


        public void setSub_icon(SubIconBean sub_icon) {

          this.sub_icon = sub_icon;
        }


        public int getCount() {

          return count;
        }


        public void setCount(int count) {

          this.count = count;
        }


        public static class SubIconBean {

          private String src;

          private String height;

          private String width;


          public String getSrc() {

            return src;
          }


          public void setSrc(String src) {

            this.src = src;
          }


          public String getHeight() {

            return height;
          }


          public void setHeight(String height) {

            this.height = height;
          }


          public String getWidth() {

            return width;
          }


          public void setWidth(String width) {

            this.width = width;
          }
        }
      }

      public static class LivesBean {

        /**
         * face : http://i0.hdslb.com/bfs/face/ccc601508ae54a3497500adcef7b3ca52309d42f.jpg
         * mid : 10465808
         * name : 优酱是咸鱼
         */

        private OwnerBean owner;

        /**
         * src : http://i0.hdslb.com/bfs/live/ec251dcd388e0c9ffbc89c1c428894db811639e2.jpg
         * height : 180
         * width : 320
         */

        private CoverBean cover;

        private String title;

        private int room_id;

        private int check_version;

        private int online;

        private String area;

        private int area_id;

        private String playurl;

        private String accept_quality;

        private int broadcast_type;

        private int is_tv;


        public OwnerBean getOwner() {

          return owner;
        }


        public void setOwner(OwnerBean owner) {

          this.owner = owner;
        }


        public CoverBean getCover() {

          return cover;
        }


        public void setCover(CoverBean cover) {

          this.cover = cover;
        }


        public String getTitle() {

          return title;
        }


        public void setTitle(String title) {

          this.title = title;
        }


        public int getRoom_id() {

          return room_id;
        }


        public void setRoom_id(int room_id) {

          this.room_id = room_id;
        }


        public int getCheck_version() {

          return check_version;
        }


        public void setCheck_version(int check_version) {

          this.check_version = check_version;
        }


        public int getOnline() {

          return online;
        }


        public void setOnline(int online) {

          this.online = online;
        }


        public String getArea() {

          return area;
        }


        public void setArea(String area) {

          this.area = area;
        }


        public int getArea_id() {

          return area_id;
        }


        public void setArea_id(int area_id) {

          this.area_id = area_id;
        }


        public String getPlayurl() {

          return playurl;
        }


        public void setPlayurl(String playurl) {

          this.playurl = playurl;
        }


        public String getAccept_quality() {

          return accept_quality;
        }


        public void setAccept_quality(String accept_quality) {

          this.accept_quality = accept_quality;
        }


        public int getBroadcast_type() {

          return broadcast_type;
        }


        public void setBroadcast_type(int broadcast_type) {

          this.broadcast_type = broadcast_type;
        }


        public int getIs_tv() {

          return is_tv;
        }


        public void setIs_tv(int is_tv) {

          this.is_tv = is_tv;
        }


        public static class OwnerBean {

          private String face;

          private int mid;

          private String name;


          public String getFace() {

            return face;
          }


          public void setFace(String face) {

            this.face = face;
          }


          public int getMid() {

            return mid;
          }


          public void setMid(int mid) {

            this.mid = mid;
          }


          public String getName() {

            return name;
          }


          public void setName(String name) {

            this.name = name;
          }
        }

        public static class CoverBean {

          private String src;

          private int height;

          private int width;


          public String getSrc() {

            return src;
          }


          public void setSrc(String src) {

            this.src = src;
          }


          public int getHeight() {

            return height;
          }


          public void setHeight(int height) {

            this.height = height;
          }


          public int getWidth() {

            return width;
          }


          public void setWidth(int width) {

            this.width = width;
          }
        }
      }

      public static class BannerDataBean {

        /**
         * face : http://i1.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg
         * mid : 11153765
         * name : 哔哩哔哩音乐台
         */

        private OwnerBean owner;

        /**
         * src : http://i0.hdslb.com/bfs/live/98c268f907705241a3e3face25ae365e3120406b.png
         * height : 180
         * width : 320
         */

        private CoverBean cover;

        private String title;

        private int room_id;

        private int check_version;

        private int online;

        private String area;

        private int area_id;

        private String playurl;

        private String accept_quality;

        private int broadcast_type;

        private int is_tv;


        public OwnerBean getOwner() {

          return owner;
        }


        public void setOwner(OwnerBean owner) {

          this.owner = owner;
        }


        public CoverBean getCover() {

          return cover;
        }


        public void setCover(CoverBean cover) {

          this.cover = cover;
        }


        public String getTitle() {

          return title;
        }


        public void setTitle(String title) {

          this.title = title;
        }


        public int getRoom_id() {

          return room_id;
        }


        public void setRoom_id(int room_id) {

          this.room_id = room_id;
        }


        public int getCheck_version() {

          return check_version;
        }


        public void setCheck_version(int check_version) {

          this.check_version = check_version;
        }


        public int getOnline() {

          return online;
        }


        public void setOnline(int online) {

          this.online = online;
        }


        public String getArea() {

          return area;
        }


        public void setArea(String area) {

          this.area = area;
        }


        public int getArea_id() {

          return area_id;
        }


        public void setArea_id(int area_id) {

          this.area_id = area_id;
        }


        public String getPlayurl() {

          return playurl;
        }


        public void setPlayurl(String playurl) {

          this.playurl = playurl;
        }


        public String getAccept_quality() {

          return accept_quality;
        }


        public void setAccept_quality(String accept_quality) {

          this.accept_quality = accept_quality;
        }


        public int getBroadcast_type() {

          return broadcast_type;
        }


        public void setBroadcast_type(int broadcast_type) {

          this.broadcast_type = broadcast_type;
        }


        public int getIs_tv() {

          return is_tv;
        }


        public void setIs_tv(int is_tv) {

          this.is_tv = is_tv;
        }


        public static class OwnerBean {

          private String face;

          private int mid;

          private String name;


          public String getFace() {

            return face;
          }


          public void setFace(String face) {

            this.face = face;
          }


          public int getMid() {

            return mid;
          }


          public void setMid(int mid) {

            this.mid = mid;
          }


          public String getName() {

            return name;
          }


          public void setName(String name) {

            this.name = name;
          }
        }

        public static class CoverBean {

          private String src;

          private int height;

          private int width;


          public String getSrc() {

            return src;
          }


          public void setSrc(String src) {

            this.src = src;
          }


          public int getHeight() {

            return height;
          }


          public void setHeight(int height) {

            this.height = height;
          }


          public int getWidth() {

            return width;
          }


          public void setWidth(int width) {

            this.width = width;
          }
        }
      }
    }

    public static class BannerBean {

      private String title;

      private String img;

      private String remark;

      private String link;


      public String getTitle() {

        return title;
      }


      public void setTitle(String title) {

        this.title = title;
      }


      public String getImg() {

        return img;
      }


      public void setImg(String img) {

        this.img = img;
      }


      public String getRemark() {

        return remark;
      }


      public void setRemark(String remark) {

        this.remark = remark;
      }


      public String getLink() {

        return link;
      }


      public void setLink(String link) {

        this.link = link;
      }
    }

    public static class EntranceIconsBean {

      private int id;

      private String name;

      /**
       * src : http://static.hdslb.com/live-static/images/mobile/android/big/xxhdpi/11_big.png?2016101804
       * height : 132
       * width : 132
       */

      private EntranceIconBean entrance_icon;


      public int getId() {

        return id;
      }


      public void setId(int id) {

        this.id = id;
      }


      public String getName() {

        return name;
      }


      public void setName(String name) {

        this.name = name;
      }


      public EntranceIconBean getEntrance_icon() {

        return entrance_icon;
      }


      public void setEntrance_icon(EntranceIconBean entrance_icon) {

        this.entrance_icon = entrance_icon;
      }


      public static class EntranceIconBean {

        private String src;

        private String height;

        private String width;


        public String getSrc() {

          return src;
        }


        public void setSrc(String src) {

          this.src = src;
        }


        public String getHeight() {

          return height;
        }


        public void setHeight(String height) {

          this.height = height;
        }


        public String getWidth() {

          return width;
        }


        public void setWidth(String width) {

          this.width = width;
        }
      }
    }

    public static class PartitionsBean {

      /**
       * id : 9
       * name : 绘画专区
       * area : draw
       * sub_icon : {"src":"http://static.hdslb.com/live-static/images/mobile/android/small/xxhdpi/9.png?2016101804","height":"63","width":"63"}
       * count : 102
       */

      private PartitionBean partition;

      /**
       * owner : {"face":"http://i1.hdslb.com/bfs/face/177eee10fbe516870c3103111a0dc4bd9477b4b5.jpg","mid":856751,"name":"Mr_Nobady"}
       * cover : {"src":"http://i0.hdslb.com/bfs/live/673bbb3b1f2d1460ae624fa82cf42e244a578d9a.jpg","height":180,"width":320}
       * title : \ Mr.Nobady /  主营：绘画，游戏，闲聊
       * room_id : 543804
       * check_version : 0
       * online : 13
       * area : 绘画专区
       * area_id : 9
       * playurl : http://live-play.acgvideo.com/live/259/live_856751_6040403.flv?wsSecret=c4880e00d12d6d35107661f8ad9b1c16&wsTime=57dfcc85
       * accept_quality : 4
       * broadcast_type : 0
       * is_tv : 0
       */

      private List<LivesBean> lives;


      public PartitionBean getPartition() {

        return partition;
      }


      public void setPartition(PartitionBean partition) {

        this.partition = partition;
      }


      public List<LivesBean> getLives() {

        return lives;
      }


      public void setLives(List<LivesBean> lives) {

        this.lives = lives;
      }


      public static class PartitionBean {

        private int id;

        private String name;

        private String area;

        /**
         * src : http://static.hdslb.com/live-static/images/mobile/android/small/xxhdpi/9.png?2016101804
         * height : 63
         * width : 63
         */

        private SubIconBean sub_icon;

        private int count;


        public int getId() {

          return id;
        }


        public void setId(int id) {

          this.id = id;
        }


        public String getName() {

          return name;
        }


        public void setName(String name) {

          this.name = name;
        }


        public String getArea() {

          return area;
        }


        public void setArea(String area) {

          this.area = area;
        }


        public SubIconBean getSub_icon() {

          return sub_icon;
        }


        public void setSub_icon(SubIconBean sub_icon) {

          this.sub_icon = sub_icon;
        }


        public int getCount() {

          return count;
        }


        public void setCount(int count) {

          this.count = count;
        }


        public static class SubIconBean {

          private String src;

          private String height;

          private String width;


          public String getSrc() {

            return src;
          }


          public void setSrc(String src) {

            this.src = src;
          }


          public String getHeight() {

            return height;
          }


          public void setHeight(String height) {

            this.height = height;
          }


          public String getWidth() {

            return width;
          }


          public void setWidth(String width) {

            this.width = width;
          }
        }
      }

      public static class LivesBean {

        /**
         * face : http://i1.hdslb.com/bfs/face/177eee10fbe516870c3103111a0dc4bd9477b4b5.jpg
         * mid : 856751
         * name : Mr_Nobady
         */

        private OwnerBean owner;

        /**
         * src : http://i0.hdslb.com/bfs/live/673bbb3b1f2d1460ae624fa82cf42e244a578d9a.jpg
         * height : 180
         * width : 320
         */

        private CoverBean cover;

        private String title;

        private int room_id;

        private int check_version;

        private int online;

        private String area;

        private int area_id;

        private String playurl;

        private String accept_quality;

        private int broadcast_type;

        private int is_tv;


        public OwnerBean getOwner() {

          return owner;
        }


        public void setOwner(OwnerBean owner) {

          this.owner = owner;
        }


        public CoverBean getCover() {

          return cover;
        }


        public void setCover(CoverBean cover) {

          this.cover = cover;
        }


        public String getTitle() {

          return title;
        }


        public void setTitle(String title) {

          this.title = title;
        }


        public int getRoom_id() {

          return room_id;
        }


        public void setRoom_id(int room_id) {

          this.room_id = room_id;
        }


        public int getCheck_version() {

          return check_version;
        }


        public void setCheck_version(int check_version) {

          this.check_version = check_version;
        }


        public int getOnline() {

          return online;
        }


        public void setOnline(int online) {

          this.online = online;
        }


        public String getArea() {

          return area;
        }


        public void setArea(String area) {

          this.area = area;
        }


        public int getArea_id() {

          return area_id;
        }


        public void setArea_id(int area_id) {

          this.area_id = area_id;
        }


        public String getPlayurl() {

          return playurl;
        }


        public void setPlayurl(String playurl) {

          this.playurl = playurl;
        }


        public String getAccept_quality() {

          return accept_quality;
        }


        public void setAccept_quality(String accept_quality) {

          this.accept_quality = accept_quality;
        }


        public int getBroadcast_type() {

          return broadcast_type;
        }


        public void setBroadcast_type(int broadcast_type) {

          this.broadcast_type = broadcast_type;
        }


        public int getIs_tv() {

          return is_tv;
        }


        public void setIs_tv(int is_tv) {

          this.is_tv = is_tv;
        }


        public static class OwnerBean {

          private String face;

          private int mid;

          private String name;


          public String getFace() {

            return face;
          }


          public void setFace(String face) {

            this.face = face;
          }


          public int getMid() {

            return mid;
          }


          public void setMid(int mid) {

            this.mid = mid;
          }


          public String getName() {

            return name;
          }


          public void setName(String name) {

            this.name = name;
          }
        }

        public static class CoverBean {

          private String src;

          private int height;

          private int width;


          public String getSrc() {

            return src;
          }


          public void setSrc(String src) {

            this.src = src;
          }


          public int getHeight() {

            return height;
          }


          public void setHeight(int height) {

            this.height = height;
          }


          public int getWidth() {

            return width;
          }


          public void setWidth(int width) {

            this.width = width;
          }
        }
      }
    }
  }
}
