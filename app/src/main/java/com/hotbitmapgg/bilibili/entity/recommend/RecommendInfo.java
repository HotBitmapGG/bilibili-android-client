package com.hotbitmapgg.bilibili.entity.recommend;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hcc on 16/8/20 12:38
 * 100332338@qq.com
 * <p/>
 * 首页推荐界面数据
 */
public class RecommendInfo {

  /**
   * code : 0
   * result : [{"type":"recommend",
   * "head":{"param":"","goto":"","style":"gm_av","title":"热门焦点"},
   * "body":[{"title":"蓝孩纸没有女朋友怎么办？自己化一个啊！可爱性感小辣妹妆~",
   * "style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/4b12a91a93953c919b395e83aea0308e6976db8f.png",
   * "param":"5883487","goto":"av","width":350,"height":219,"play":"19.1万","danmaku":"5404"},
   * {"title":"海贼王路飞最爱(⊙o⊙)棒骨大肉丨绵羊料理","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/6890bdeaa4048bb481ca16f09fb3845d9ea33397.png","param":"5891254","goto":"av","width":350,"height":219,"play":"6.7万","danmaku":"506"},{"title":"《少女前线》夏活版本-魔方行动","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/9df847ca084954ddbc5a677a0896272ef4e2fda8.png",
   * "param":"5825983","goto":"av","width":350,"height":219,"play":"6.4万","danmaku":"315"},
   * {"title":"【百家歌坛】易中天品「演员」","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/543bf62d3b33ada01be9fce8c3fb533349daab80.jpg","param":"5807917","goto":"av","width":350,"height":219,"play":"14.4万","danmaku":"5401"}]},{"type":"live","head":{"param":"","goto":"live","style":"gm_av","title":"热门直播","count":2950},"body":[{"title":"心暖：送团扇和刨冰抽5500元以内任意买","style":"gm_live","cover":"http://i0.hdslb.com/group1/M00/5B/CA/oYYBAFbUcV6AGzDRAACZOjUnJWg140.jpg","param":"27532","goto":"live","width":580,"height":364,"up_face":"http://i0.hdslb.com/bfs/face/5057877d829c44c0f63d9e416b3d3eedb79d9d9d.gif","up":"心暖西瓜君","online":13677,"area":"电子竞技","area_id":4},{"title":"CSGO
   * 突突突","style":"gm_live","cover":"http://i0.hdslb.com/bfs/live/228029966cdc3f05f8d748e4ffb33034788b4756.jpg",
   * "param":"79558","goto":"live","width":580,"height":364,"up_face":"http://i0.hdslb.com/bfs/face/ae8aea930b21e86a83313dd3ad12cd8192e8bf49.jpg","up":"AnKe-Poi","online":4250,"area":"网络游戏","area_id":3},{"title":"【橘砸】点个关注一起拯救世界吧？","style":"gm_live","cover":"http://i0.hdslb.com/bfs/live/29df6baf6b42de30d4f751c13608e8b77e9e1cf3.jpg","param":"52507","goto":"live","width":580,"height":364,"up_face":"http://i0.hdslb.com/bfs/face/e61fd305b43aa13010ed3898546a08d874fae013.jpg","up":"语酱Poi","online":3773,"area":"御宅文化","area_id":2},{"title":"电竞死歌","style":"gm_live","cover":"http://i0.hdslb.com/bfs/live/247eaad83bf16695d2022c114a1c43291891e940.jpg","param":"57076","goto":"live","width":580,"height":364,"up_face":"http://i2.hdslb.com/bfs/face/c5b2e2db5be446212c9602a6fddb8d9b80281374.jpg","up":"啾啾❤安安","online":1018,"area":"电子竞技","area_id":4}]},{"type":"bangumi_2","head":{"param":"13","goto":"subarea","style":"gs_bangumi","title":"番剧推荐"},"body":[{"title":"时间旅行少女",
   * "style":"gs_bangumi","cover":"http://i0.hdslb.com/bfs/archive/da70545e6062a1cfae6d2918d8771a1db7ddc524.jpg","param":"5049","goto":"bangumi_list","width":320,"height":422,"desc1":"更新到第7话"},{"title":"发条精灵战记
   * 天镜的极北之星","style":"gs_bangumi","cover":"http://i1.hdslb.com/bfs/archive/a8a515227acebb62aa81c3ad49d2191c98e01cdf.jpg","param":"5047","goto":"bangumi_list","width":320,"height":422,"desc1":"更新到第7话"},{"title":"小桃小栗Love
   * Love物语","style":"gs_bangumi","cover":"http://i1.hdslb.com/bfs/archive/6348c5f85428508cb58207dc30cd718e53ca7eb6.jpg","param":"5016","goto":"bangumi_list","width":320,"height":422,"desc1":"更新到第8话"},{"title":"Thunderbolt
   * Fantasy 东离剑游纪","style":"gs_bangumi","cover":"http://i2.hdslb.com/bfs/archive/5f90692f910c52839278bcd568aad31db0eeae8f.jpg","param":"5064","goto":"bangumi_list","width":320,"height":422,"desc1":"更新到第7话"}]},{"type":"region","head":{"param":"1","goto":"subarea","style":"gm_av","title":"动画区"},
   * "body":[{"title":"【手书】黑塔利亚大家的欢乐集合【未完成的stride】","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/ca4bd864cf94ba552eed1623606dd4eb502e79ea.jpg_320x200.jpg","param":"5875415","goto":"av","width":350,"height":219,"play":"8894","danmaku":"849"},{"title":"【橙心动漫速报】死神来了？我要成为神奇宝贝大师","style":"gm_av","cover":"http://i1.hdslb.com/bfs/archive/237399819b54fdeb046be08c2858665a2ac3bafd.jpg_320x200.jpg","param":"5882586","goto":"av","width":350,"height":219,"play":"1.4万","danmaku":"226"},{"title":"全程爆笑高能系列【剧情向MMD】大神犬娘化了【萌王
   * EX-大神犬PV付】","style":"gm_av","cover":"http://i2.hdslb.com/bfs/archive/fa573cccb912069d30c0c4e452a7d301caf7f80d.jpg_320x200.jpg","param":"5867580","goto":"av","width":350,"height":219,"play":"1.2万","danmaku":"214"},{"title":"【APH/MMD寸剧】如果灵魂互换的话（中）","style":"gm_av","cover":"http://i2.hdslb.com/bfs/archive/5bcd83bb1fc90bcf6c58fa7c86b660efaa929133.jpg_320x200.jpg","param":"5897912","goto":"av","width":350,"height":219,"play":"5995","danmaku":"957"}]},{"type":"region",
   * "head":{"param":"3","goto":"subarea","style":"gm_av","title":"音乐区"},
   * "body":[{"title":"【白止&三七】散场【盗笔十一年】","style":"gm_av","cover":"http://i2.hdslb.com/bfs/archive/9a05dcd451b97bb17e3aa876ad9642959130686b.jpg_320x200.jpg","param":"5883564","goto":"av","width":350,"height":219,"play":"1.8万","danmaku":"1606"},{"title":"【字幕版】Bon
   * Jovi - This House Is Not For Sale @柚子木字幕组","style":"gm_av","cover":"http://i1.hdslb.com/bfs/archive/d64d59b20815e7ba053836f7e31ae10fdef344e0.jpg_320x200.jpg","param":"5863667","goto":"av","width":350,"height":219,"play":"6739","danmaku":"112"},{"title":"【奇然】【盗墓笔记】张起灵\u2022此生","style":"gm_av","cover":"http://i2.hdslb.com/bfs/archive/440d8967f6e0a7e57ede149ca15085d721b1e432.jpg_320x200.jpg","param":"5873958","goto":"av","width":350,"height":219,"play":"4.5万","danmaku":"6191"},{"title":"【井一】埃及方块","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/e7276c5f669e08d21d87c57d992b8fa834bb19a1.jpg_320x200.jpg","param":"5873740","goto":"av","width":350,"height":219,"play":"4211","danmaku":"154"}]},
   * {"type":"region","head":{"param":"129","goto":"subarea","style":"gm_av","title":"舞蹈区"},
   * "body":[{"title":"【极乐辣眼】变态的裙子下有大宝藏？沉入大海吧！","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/b365ea6396a567f8c66e8938fe6de37fdbdb724b.jpg_320x200.jpg","param":"5885219","goto":"av","width":350,"height":219,"play":"9409","danmaku":"330"},{"title":"极乐净土正式版","style":"gm_av","cover":"http://i2.hdslb.com/bfs/archive/78fc3d09d68c561544093542bd6c2d44bb1c9dae.jpg_320x200.jpg","param":"5888760","goto":"av","width":350,"height":219,"play":"6930","danmaku":"170"},{"title":"【伢伢】极乐净土♥
   * 两周年 ♥潜水告别作","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/0c23fb05d234bb0c8520918991856db2deca8bc3.jpg_320x200.jpg","param":"5912713","goto":"av","width":350,"height":219,"play":"2702","danmaku":"129"},{"title":"【萌萌】呆呆兽X吉利蛋
   * AOA-GOOD LUCK 翻跳（这次没高跟鞋！是高跟拖鞋！！）",
   * "style":"gm_av","cover":"http://i1.hdslb.com/bfs/archive/ee77a348fe3d83c00679681f66ebdbb91f432a4a.jpg_320x200.jpg","param":"5870052","goto":"av","width":350,"height":219,"play":"5177","danmaku":"52"}]},{"type":"region","head":{"param":"4","goto":"subarea","style":"gm_av","title":"游戏区"},"body":[{"title":"DOTA2
   * miracle 43杀5死4助攻","style":"gm_av","cover":"http://i1.hdslb.com/bfs/archive/a9a7effe2e00ec98113b44d2ac27ce0362d8f711.jpg_320x200.jpg","param":"5890497","goto":"av","width":350,"height":219,"play":"2.4万","danmaku":"819"},{"title":"【守望先锋】史上最短的一场守望先锋排位赛","style":"gm_av","cover":"http://i1.hdslb.com/bfs/archive/13101a05e78b2f5af48a08dc99ebf0af16868062.jpg_320x200.jpg","param":"5868589","goto":"av","width":350,"height":219,"play":"11.1万","danmaku":"525"},{"title":"主播真会玩52：一张海苔绽放的禁忌之恋！","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/197b32edaff69b58c91c972809bfd0531ddfc016.jpg_320x200.jpg",
   * "param":"5891145","goto":"av","width":350,"height":219,"play":"47.2万","danmaku":"1.1万"},
   * {"title":"老E 日常直播【2016.8.17下午录播】Lisa完结！30把大宝剑！进化！","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/4f749073b7320cacba8c6cf73c3830aabc204163.jpg_320x200.jpg","param":"5882601","goto":"av","width":350,"height":219,"play":"3.0万","danmaku":"1494"}]},{"type":"weblink","head":{"param":"","goto":"","style":"","title":""},"body":[{"title":"","style":"gl_normal","cover":"http://i0.hdslb.com/bfs/archive/306b8ef78af8b38569db3a87da0e6f75ab4b46cb.jpg","param":"http://www.bilibili.com/topic/v2/phone1456.html","goto":"weblink","width":714,"height":211}]},{"type":"region","head":{"param":"119","goto":"subarea","style":"gm_av","title":"鬼畜区"},"body":[{"title":"【鬼畜】刘梓晨宝宝
   * 小鸡小鸡","style":"gm_av","cover":"http://i1.hdslb.com/bfs/archive/1d3646c3a10bebc256a8aab492311496cca70e2a.jpg_320x200.jpg","param":"5883969","goto":"av","width":350,"height":219,"play":"3.6万","danmaku":"237"},{"title":"兄贵♂突击！！！
   * 王宝强加油！！！","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/c5ae67b23f46c7bbfabb5637e8760a8d3d02d3cb.jpg_320x200.jpg","param":"5906681","goto":"av","width":350,"height":219,"play":"2980","danmaku":"101"},{"title":"【卡黄单曲】饥饿之战！","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/eb47bb79483b1f90268bc41d63db01a6c834885d.jpg_320x200.jpg","param":"5863530","goto":"av","width":350,"height":219,"play":"4790","danmaku":"299"},{"title":"【哲♂学】史诗级现代哲♂学音乐（two
   * steps from van）","style":"gm_av","cover":"http://i2.hdslb.com/bfs/archive/604f15e166705fa6ee371516ffcf9ce23c136af3.jpg_320x200.jpg","param":"5886081","goto":"av","width":350,"height":219,"play":"1.6万","danmaku":"590"}]},{"type":"weblink","head":{"param":"","goto":"","style":"","title":""},"body":[{"title":"","style":"gl_normal","cover":"http://i0.hdslb.com/bfs/archive/2f22fa1c27e87238c26f211d5d8fb22668b2f7d4.jpg","param":"http://www.bilibili.com/topic/v2/phone1451.html","goto":"weblink","width":714,"height":211}]},{"type":"region","head":{"param":"36","goto":"subarea","style":"gm_av","title":"科技区"},"body":[{"title":"世界上有趣的工程失误","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/b7efea8a28a1bb6504d451abba13abbdea6b3ba8.jpg_320x200.jpg","param":"5866808","goto":"av","width":350,"height":219,"play":"9518","danmaku":"186"},{"title":"魔术大揭秘【全13集】","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/c8337e84b29f9ead2678d72135a0fde0a6739e42.jpg_320x200.jpg","param":"5875795","goto":"av","width":350,"height":219,"play":"9913","danmaku":"704"},{"title":"粘土食堂！食戟之灵第三弹
   *  鸡蛋拌饭","style":"gm_av","cover":"http://i2.hdslb.com/bfs/archive/9b386098bf0731755597d5df2b934ed48d072fa8.jpg_320x200.jpg","param":"5864046","goto":"av","width":350,"height":219,"play":"1.2万","danmaku":"177"},{"title":"18张你不会相信的照片","style":"gm_av","cover":"http://i2.hdslb.com/bfs/archive/17e7d55e4374297a5fbfb6607d34b10f0aca5f3b.jpg_320x200.jpg","param":"5893873","goto":"av","width":350,"height":219,"play":"1.4万","danmaku":"402"}]},{"type":"activity","head":{"param":"subarea","goto":"activity","style":"","title":"活动中心"},"body":[{"title":"快看，野生的大触手！
   * (´・ω・｀)","style":"gl_act","cover":"http://i0.hdslb.com/bfs/archive/bc813429915d43a5bf9fe3c5ffc8e259289fd042.jpg","param":"http://www.bilibili.com/html/activity-MAD2016-m.html","goto":"weblink","width":714,"height":211},{"title":"厨房被小电视们占领了？꒰꒪д꒪|||","style":"gl_act","cover":"http://i0.hdslb.com/bfs/archive/a440a225cb8b53e897490254568d0f6d02dccd41.jpg","param":"http://www.bilibili.com/html/activity-punipuni3-m.html","goto":"weblink","width":714,"height":211},{"title":"可以，这很影评","style":"gl_act","cover":"http://i0.hdslb.com/bfs/archive/4b10531f3e1a0e6f5e9c25d78849b69d5b7f56a5.png","param":"http://www.bilibili.com/html/activity-cinecism-m.html","goto":"weblink","width":714,"height":211}]},{"type":"region","head":{"param":"160","goto":"subarea","style":"gm_av","title":"生活区"},"body":[{"title":"2016年8月第三周悲剧傻缺视频集锦","style":"gm_av","cover":"http://i1.hdslb.com/bfs/archive/fe9f37340f799e46ca5e89897f4f47ab61d52906.jpg_320x200.jpg","param":"5909330","goto":"av","width":350,"height":219,"play":"3.3万","danmaku":"610"},{"title":"【拂菻坊】外国人VS中国人\u2014\u2014中文水平考试","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/81a81ea09e32878b3bea3a6b5cfd4d10a6d49880.jpg_320x200.jpg","param":"5908276","goto":"av","width":350,"height":219,"play":"6.7万","danmaku":"2709"},{"title":"【中国乒乓球队】国胖们的逗比萌向＆友爱日常采撷【持更ing】","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/337a6ff3ca2674086cf134c4f531b843e2f0d870.jpg_320x200.jpg","param":"5862848","goto":"av","width":350,"height":219,"play":"4.4万","danmaku":"1796"},{"title":"【虫虫的料理日记05】吃完你就收藏了","style":"gm_av","cover":"http://i1.hdslb.com/bfs/archive/ce1328abac984890cab73588273bb9af2cab24ae.jpg_320x200.jpg","param":"5862944","goto":"av","width":350,"height":219,"play":"5.6万","danmaku":"1128"}]},{"type":"region","head":{"param":"155","goto":"subarea","style":"gm_av","title":"时尚区"},"body":[{"title":"@粥安宙安
   * | 替你种草拔草的鞋子合集分享","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/90e2dbe7772f8e6d19a9d1d95e4dccb111a1482d.jpg_320x200.jpg","param":"5867445","goto":"av","width":350,"height":219,"play":"1.8万","danmaku":"864"},{"title":"【夏木】【伪娘】男孩子的海未
   *   福利向妆面流程","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/d200e91e348dd7cfcfc1729159bf3063591316ba.jpg_320x200.jpg","param":"5889423","goto":"av","width":350,"height":219,"play":"4473","danmaku":"322"},{"title":"美白针和美白丸到底有效么？？还有最火的美白产品大揭秘！！","style":"gm_av","cover":"http://i2.hdslb.com/bfs/archive/60b9b230b681531727510611519565be5127fc7c.jpg_320x200.jpg","param":"5888937","goto":"av","width":350,"height":219,"play":"3956","danmaku":"675"},{"title":"【仓大王】可爱性感小辣妹妆~没有女朋友怎么办？自己化一个啊！","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/ca390a0295a80b89d6b73b6dfd5de3d2f2aa4b08.jpg_320x200.jpg","param":"5883487","goto":"av","width":350,"height":219,"play":"18.1万","danmaku":"5279"}]},{"type":"region","head":{"param":"5","goto":"subarea","style":"gm_av","title":"娱乐区"},"body":[{"title":"三周年庆祝视频【马鹿】永远都在","style":"gm_av","cover":"http://i1.hdslb.com/bfs/archive/49a20911908a5947fbdc326bb64641b8227fa3ec.jpg_320x200.jpg","param":"5890072","goto":"av","width":350,"height":219,"play":"3647","danmaku":"194"},{"title":"【孟瑞×王博文】不可抗力2上海官方首次见面会【彩排】
   *  热波直播录制","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/764afe28366c8dc52a93a367eef3ff767b99a0ba.jpg_320x200.jpg","param":"5900724","goto":"av","width":350,"height":219,"play":"1.3万","danmaku":"380"},{"title":"不可抗力2016.08.19上海见面会热波直播录屏91分钟（非完整版）","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/34a2fc967035ba13e86ee14c34abd9b1c3f9d989.jpg_320x200.jpg","param":"5910898","goto":"av","width":350,"height":219,"play":"2623","danmaku":"79"},{"title":"【乃木坂】白石麻衣24岁生诞OPV【麻衣样一途字幕组】","style":"gm_av","cover":"http://i1.hdslb.com/bfs/archive/5c783fc8c43af47c05b68c3af35d98ed2351624b.jpg_320x200.jpg","param":"5904879","goto":"av","width":350,"height":219,"play":"2484","danmaku":"267"}]},{"type":"region","head":{"param":"11","goto":"subarea","style":"gm_av","title":"电视剧区"},"body":[{"title":"【王凯】《悸动》2016生贺","style":"gm_av","cover":"http://i2.hdslb.com/bfs/archive/9b1ffc1ae140820af9bb4ec868004ea6b5b321bc.jpg_320x200.jpg","param":"5887451","goto":"av","width":350,"height":219,"play":"395","danmaku":"35"},{"title":"【山田凉介】【金田一】
   * 如果让哈吉咩酱演纯爱","style":"gm_av","cover":"http://i1.hdslb.com/bfs/archive/05deabd6b9ed9c082172eacee85cc589c3967499.jpg_320x200.jpg","param":"5876160","goto":"av","width":350,"height":219,"play":"752","danmaku":"21"},{"title":"【王凯kkw】《宠儿》","style":"gm_av","cover":"http://i1.hdslb.com/bfs/archive/b393dc6f1392dfb6c8d53569451af68c1fb0dd65.jpg_320x200.jpg","param":"5874278","goto":"av","width":350,"height":219,"play":"1353","danmaku":"143"},{"title":"【羽还真X雪飞霜】上邪【姐弟】","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/40cd00f11cad3d3bae1b6d27781b015c0aee4216.jpg_320x200.jpg","param":"5887770","goto":"av","width":350,"height":219,"play":"898","danmaku":"45"}]},{"type":"region","head":{"param":"23","goto":"subarea","style":"gm_av","title":"电影区"},"body":[{"title":"【视频混剪】【中元节】小店打烊了，客官请回吧","style":"gm_av","cover":"http://i1.hdslb.com/bfs/archive/bfc6b6f8c4cc32f67e53d9be40d69c5a6df0b20f.jpg_320x200.jpg","param":"5864096","goto":"av","width":350,"height":219,"play":"1.4万","danmaku":"2158"},{"title":"【上校制造】不义联盟：第三年
   * 魔法与恶魔",
   * "style":"gm_av","cover":"http://i1.hdslb.com/bfs/archive/05f45e8c286dc74d6ceba96a7d903172cd93d589.jpg_320x200.jpg","param":"5895864","goto":"av","width":350,"height":219,"play":"8533","danmaku":"289"},{"title":"推荐电影
   * 《他是龙》","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/142795aeca2f2fccd6ec21f93effc470cd66174c.jpg_320x200.jpg","param":"5870944","goto":"av","width":350,"height":219,"play":"2048"},{"title":"当二次元神作变成真人电影","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/5af82c04c747d332b74fe76e1e321e20217414ee.jpg_320x200.jpg","param":"5877645","goto":"av","width":350,"height":219,"play":"4680","danmaku":"66"}]},{"type":"weblink","head":{"param":"","goto":"","style":"","title":""},"body":[{"title":"周末放映室
   * 第103期复古季 ","style":"gl_normal","cover":"http://i0.hdslb.com/bfs/archive/b6dfcc97fb71612bd3927ca70f4e52d5e7ff872e.jpg","param":"http://www.bilibili.com/html/activity-20160819movieweekend.html","goto":"weblink","width":714,"height":211}]}]
   */

  private int code;

  /**
   * type : recommend
   * head : {"param":"","goto":"","style":"gm_av","title":"热门焦点"}
   * body : [{"title":"蓝孩纸没有女朋友怎么办？自己化一个啊！可爱性感小辣妹妆~","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/4b12a91a93953c919b395e83aea0308e6976db8f.png","param":"5883487","goto":"av","width":350,"height":219,"play":"19.1万","danmaku":"5404"},{"title":"海贼王路飞最爱(⊙o⊙)棒骨大肉丨绵羊料理","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/6890bdeaa4048bb481ca16f09fb3845d9ea33397.png","param":"5891254","goto":"av","width":350,"height":219,"play":"6.7万","danmaku":"506"},{"title":"《少女前线》夏活版本-魔方行动","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/9df847ca084954ddbc5a677a0896272ef4e2fda8.png","param":"5825983","goto":"av","width":350,"height":219,"play":"6.4万","danmaku":"315"},{"title":"【百家歌坛】易中天品「演员」","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/543bf62d3b33ada01be9fce8c3fb533349daab80.jpg","param":"5807917","goto":"av","width":350,"height":219,"play":"14.4万","danmaku":"5401"}]
   */

  private List<ResultBean> result;


  public int getCode() {

    return code;
  }


  public void setCode(int code) {

    this.code = code;
  }


  public List<ResultBean> getResult() {

    return result;
  }


  public void setResult(List<ResultBean> result) {

    this.result = result;
  }


  public static class ResultBean {

    private String type;

    /**
     * param :
     * goto :
     * style : gm_av
     * title : 热门焦点
     */

    private HeadBean head;

    /**
     * title : 蓝孩纸没有女朋友怎么办？自己化一个啊！可爱性感小辣妹妆~
     * style : gm_av
     * cover : http://i0.hdslb.com/bfs/archive/4b12a91a93953c919b395e83aea0308e6976db8f.png
     * param : 5883487
     * goto : av
     * width : 350
     * height : 219
     * play : 19.1万
     * danmaku : 5404
     */

    private List<BodyBean> body;


    public String getType() {

      return type;
    }


    public void setType(String type) {

      this.type = type;
    }


    public HeadBean getHead() {

      return head;
    }


    public void setHead(HeadBean head) {

      this.head = head;
    }


    public List<BodyBean> getBody() {

      return body;
    }


    public void setBody(List<BodyBean> body) {

      this.body = body;
    }


    public static class HeadBean {

      private String param;

      @SerializedName("goto")
      private String gotoX;

      private String style;

      private String title;

      private int count;


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


      public String getStyle() {

        return style;
      }


      public void setStyle(String style) {

        this.style = style;
      }


      public String getTitle() {

        return title;
      }


      public void setTitle(String title) {

        this.title = title;
      }


      public int getCount() {

        return count;
      }


      public void setCount(int count) {

        this.count = count;
      }
    }

    public static class BodyBean {

      private String title;

      private String style;

      private String cover;

      private String param;

      @SerializedName("goto")
      private String gotoX;

      private int width;

      private int height;

      private String play;

      private String danmaku;

      private String up;

      @SerializedName("up_face")
      private String upFace;

      private int online;

      private String desc1;


      public String getTitle() {

        return title;
      }


      public void setTitle(String title) {

        this.title = title;
      }


      public String getStyle() {

        return style;
      }


      public void setStyle(String style) {

        this.style = style;
      }


      public String getCover() {

        return cover;
      }


      public void setCover(String cover) {

        this.cover = cover;
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


      public int getWidth() {

        return width;
      }


      public void setWidth(int width) {

        this.width = width;
      }


      public int getHeight() {

        return height;
      }


      public void setHeight(int height) {

        this.height = height;
      }


      public String getPlay() {

        return play;
      }


      public void setPlay(String play) {

        this.play = play;
      }


      public String getDanmaku() {

        return danmaku;
      }


      public void setDanmaku(String danmaku) {

        this.danmaku = danmaku;
      }


      public String getUp() {

        return up;
      }


      public void setUp(String up) {

        this.up = up;
      }


      public String getUpFace() {

        return upFace;
      }


      public void setUpFace(String upFace) {

        this.upFace = upFace;
      }


      public int getOnline() {

        return online;
      }


      public void setOnline(int online) {

        this.online = online;
      }


      public String getDesc1() {

        return desc1;
      }


      public void setDesc1(String desc1) {

        this.desc1 = desc1;
      }
    }
  }
}
