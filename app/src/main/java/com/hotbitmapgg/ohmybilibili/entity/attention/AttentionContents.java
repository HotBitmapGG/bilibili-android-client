package com.hotbitmapgg.ohmybilibili.entity.attention;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 2016/9/28 19:22
 * 100332338@qq.com
 * <p>
 * 关注界面数据生成
 */

public class AttentionContents
{

    /**
     * 关注番剧数据
     * <p>
     * 番剧imageUrl
     * 番剧Titlte
     * 番剧更新集数
     */

    //Love Live! Sunshine!!
    private static final String BANGUMI_ONE_IMAGE_URL = "http://i0.hdslb.com/bfs/bangumi/248e9cc5b73cc3a276acf92eaf6651a7b3c90d10.jpg_200x268.jpg";

    //火影忍者 疾风传
    private static final String BANGUMI_TWO_IMAGE_URL = "http://i0.hdslb.com/bfs/bangumi/212345f11472cd39d6209652ca926f2249fdff36.jpg_200x268.jpg";

    //三年E班 第二季
    private static final String BANGUMI_THREE_IMAGE_URL = "http://i0.hdslb.com/bfs/bangumi/6c75efdf0aa04931d5f9fd9eab3836d6f35ecfc6.jpg_200x268.jpg";


    private static final String BANGUMI_ONE_TITLE = "Love Live! Sunshine!!";

    private static final String BANGUMI_TWO_TITLE = "火影忍者 疾风传";

    private static final String BANGUMI_THREE_TITLE = "三年E班 第二季";


    private static final String BANGUMI_ONE_DESC = "更新至第13话";

    private static final String BANGUMI_TWO_DESC = "更新至695话";

    private static final String BANGUMI_THREE_DESC = "更新至第25话";


    private List<AttentionBangumi> attentionBangumis = new ArrayList<>();

    /**
     * 添加关注番剧数据
     */
    public List<AttentionBangumi> fillBangumiData()
    {

        AttentionBangumi one = new AttentionBangumi();
        AttentionBangumi two = new AttentionBangumi();
        AttentionBangumi three = new AttentionBangumi();

        one.setPic(BANGUMI_ONE_IMAGE_URL);
        one.setTitle(BANGUMI_ONE_TITLE);
        one.setDesc(BANGUMI_ONE_DESC);

        two.setPic(BANGUMI_TWO_IMAGE_URL);
        two.setTitle(BANGUMI_TWO_TITLE);
        two.setDesc(BANGUMI_TWO_DESC);


        three.setPic(BANGUMI_THREE_IMAGE_URL);
        three.setTitle(BANGUMI_THREE_TITLE);
        three.setDesc(BANGUMI_THREE_DESC);

        attentionBangumis.add(one);
        attentionBangumis.add(two);
        attentionBangumis.add(three);

        return attentionBangumis;
    }


    /**
     * 关注动态数据
     * <p>
     * 用户头像
     * 用户名称
     * 用户上传时间
     * 动态imageUrl
     * 动态Title
     * 动态播放数
     * 动态弹幕数
     */

    private static final String DYNAMIC_ONE_IMAGE_URL = "http://i0.hdslb.com/bfs/archive/cdec1953709626ce7494e9c07570146e71019d95.jpg_320x200.jpg";

    private static final String DYNAMIC_ONE_TITLE = "被袜子熏蒙的猫！拍猫技巧课！[猫奴的日常]";

    private static final String DYNAMIC_ONE_PLAY = "6897";

    private static final String DYNAMIC_ONE_DAMUKU = "241";

    private static final String DYNAMIC_ONE_USER_AVATAR = "http://i1.hdslb.com/bfs/face/6039bee2f6267e01559a6d67a283d0a552105740.jpg";

    private static final String DYNAMIC_ONE_USER_NAME = "猫奴的日常";

    private static final String DYNAMIC_ONE_UP_TIME = "2016-09-28 07:54";


    private static final String DYNAMIC_TWO_IMAGE_URL = "http://i0.hdslb.com/bfs/archive/4a06455c64e466265cf1b8a376d924ba09bb0d72.jpg_320x200.jpg";

    private static final String DYNAMIC_TWO_TITLE = "【暴走玩啥游戏第二季】03热血传奇 姑娘请留步，我们好像见过";

    private static final String DYNAMIC_TWO_PLAY = "18.8万";

    private static final String DYNAMIC_TWO_DAMUKU = "1325";

    private static final String DYNAMIC_TWO_USER_AVATAR = "http://i2.hdslb.com/bfs/face/7f51ff6f4ff3ad7a5ac8893aab75a67cd1850e5a.jpg";

    private static final String DYNAMIC_TWO_USER_NAME = "暴走漫画";

    private static final String DYNAMIC_TWO_UP_TIME = "2016-09-24 15:12";


    private static final String DYNAMIC_THREE_IMAGE_URL = "http://i0.hdslb.com/bfs/archive/91db03666896f2a324ca0a99cb27b294d63ee453.jpg_320x200.jpg";

    private static final String DYNAMIC_THREE_TITLE = "延安！传说的洋芋擦擦什么鬼？[叨咕叨咕]全国旅行计划";

    private static final String DYNAMIC_THREE_PLAY = "2.1万";

    private static final String DYNAMIC_THREE_DAMUKU = "1325";

    private static final String DYNAMIC_THREE_USER_AVATAR = "http://i1.hdslb.com/bfs/face/6039bee2f6267e01559a6d67a283d0a552105740.jpg";

    private static final String DYNAMIC_THREE_USER_NAME = "猫奴的日常";

    private static final String DYNAMIC_THREE_UP_TIME = "2016-09-24 13:39";


    private static final String DYNAMIC_FOUR_IMAGE_URL = "http://i0.hdslb.com/bfs/archive/052138104d1b5ad46ed5198ded66eb93fe1937aa.jpg_320x200.jpg";

    private static final String DYNAMIC_FOUR_TITLE = "【父爱如山】小萝莉：爸爸再不起床的话，我就陪着一起睡了哦！";

    private static final String DYNAMIC_FOUR_PLAY = "3.2万";

    private static final String DYNAMIC_FOUR_DAMUKU = "2348";

    private static final String DYNAMIC_FOUR_USER_AVATAR = "http://i1.hdslb.com/bfs/face/f1ad802cce265d2df655a1ec560c416c4ac325a9.jpg";

    private static final String DYNAMIC_FOUR_USER_NAME = "约谈人参";

    private static final String DYNAMIC_FOUR_UP_TIME = "2016-09-25 13:59";


    private static final String DYNAMIC_FIVE_IMAGE_URL = "http://i0.hdslb.com/bfs/archive/dd21acd97e8f46ac2beb9a9e6b689c9d81fca1e4.jpg_320x200.jpg";

    private static final String DYNAMIC_FIVE_TITLE = "我妈终于接受了这个设定，看见我戴假发毫无波动~甚至还笑了起来";

    private static final String DYNAMIC_FIVE_PLAY = "12.5万";

    private static final String DYNAMIC_FIVE_DAMUKU = "3245";

    private static final String DYNAMIC_FIVE_USER_AVATAR = "http://i0.hdslb.com/bfs/face/ccc601508ae54a3497500adcef7b3ca52309d42f.jpg";

    private static final String DYNAMIC_FIVE_USER_NAME = "优酱是咸鱼";

    private static final String DYNAMIC_FIVE_UP_TIME = "2016-09-24 21:36";


    private static final String DYNAMIC_SIX_IMAGE_URL = "http://i0.hdslb.com/bfs/archive/153918d01d12cfe39a74e0f09cb08cd6ac09d1f2.jpg_320x200.jpg";

    private static final String DYNAMIC_SIX_TITLE = "某暴死的冷番推荐 II";

    private static final String DYNAMIC_SIX_PLAY = "27.4万";

    private static final String DYNAMIC_SIX_DAMUKU = "5345";

    private static final String DYNAMIC_SIX_USER_AVATAR = "http://i1.hdslb.com/bfs/face/dd4dd291d3e099038faa94408de06f3c8121ea46.jpg";

    private static final String DYNAMIC_SIX_USER_NAME = "名作之壁吧";

    private static final String DYNAMIC_SIX_UP_TIME = "2016-09-24 10:08";


    private static final String DYNAMIC_SEVEN_IMAGE_URL = "http://i0.hdslb.com/bfs/archive/60c8c7d30d8f3b824a4571dd152b3493e2a61cb8.jpg_320x200.jpg";

    private static final String DYNAMIC_SEVEN_TITLE = "男装yunyun 玩伴猫耳娘ED 花泽香菜 （）木吉他加强";

    private static final String DYNAMIC_SEVEN_PLAY = "197";

    private static final String DYNAMIC_SEVEN_DAMUKU = "4";

    private static final String DYNAMIC_SEVEN_USER_AVATAR = "http://i0.hdslb.com/bfs/face/6364e36eb3774a05275ba00a99cde44e747cda59.jpg";

    private static final String DYNAMIC_SEVEN_USER_NAME = "結ぶ祈りyunyun";

    private static final String DYNAMIC_SEVEN_UP_TIME = "2016-09-23 23:15";


    private static final String DYNAMIC_EIGHT_IMAGE_URL = "http://i0.hdslb.com/bfs/archive/d23292aebb3ecd265f28b8e6771898aac1fd4357.jpg_320x200.jpg";

    private static final String DYNAMIC_EIGHT_TITLE = "【BiuBiu】极乐净土 羞耻度爆表 烤熟的金丝雀带你游新加坡 内含高能花絮";

    private static final String DYNAMIC_EIGHT_PLAY = "42.3万";

    private static final String DYNAMIC_EIGHT_DAMUKU = "3722";

    private static final String DYNAMIC_EIGHT_USER_AVATAR = "http://i2.hdslb.com/bfs/face/2994fa5dc395a0c939b9eb43400abb1deffdfcfb.jpg";

    private static final String DYNAMIC_EIGHT_USER_NAME = "biubiu宅舞团";

    private static final String DYNAMIC_EIGHT_UP_TIME = "2016-09-23 16:03";


    private static final String DYNAMIC_NINE_IMAGE_URL = "http://i0.hdslb.com/bfs/archive/5e6188053f793f3ae1c0f79e81cb86477cb28dde.jpg_320x200.jpg";

    private static final String DYNAMIC_NINE_TITLE = "【Re:0异世界】从零开始的劈腿生活（泪目向）";

    private static final String DYNAMIC_NINE_PLAY = "37.3万";

    private static final String DYNAMIC_NINE_DAMUKU = "6455";

    private static final String DYNAMIC_NINE_USER_AVATAR = "http://i1.hdslb.com/bfs/face/df19598c56c26e253fc381df2c083dcbb598ca6b.jpg";

    private static final String DYNAMIC_NINE_USER_NAME = "死病娇XiaoFeng";

    private static final String DYNAMIC_NINE_UP_TIME = "2016-09-23 09:35";


    private static final String DYNAMIC_TEN_IMAGE_URL = "http://i0.hdslb.com/bfs/archive/116b06a3bea672e6553db5812c8ed9b1baf4ffd1.jpg_320x200.jpg";

    private static final String DYNAMIC_TEN_TITLE = "【王尼美快报】26男人和女人的究极对比";

    private static final String DYNAMIC_TEN_PLAY = "20.1万";

    private static final String DYNAMIC_TEN_DAMUKU = "1060";

    private static final String DYNAMIC_TEN_USER_AVATAR = "http://i2.hdslb.com/bfs/face/7f51ff6f4ff3ad7a5ac8893aab75a67cd1850e5a.jpg";

    private static final String DYNAMIC_TEN_USER_NAME = "暴走漫画";

    private static final String DYNAMIC_TEN_UP_TIME = "2016-09-22 09:58";


    private List<AttentionDynamic> attentionDynamics = new ArrayList<>();

    public List<AttentionDynamic> fillDynamicData()
    {

        AttentionDynamic one = new AttentionDynamic();
        AttentionDynamic two = new AttentionDynamic();
        AttentionDynamic three = new AttentionDynamic();
        AttentionDynamic four = new AttentionDynamic();
        AttentionDynamic five = new AttentionDynamic();
        AttentionDynamic six = new AttentionDynamic();
        AttentionDynamic seven = new AttentionDynamic();
        AttentionDynamic eight = new AttentionDynamic();
        AttentionDynamic nine = new AttentionDynamic();
        AttentionDynamic ten = new AttentionDynamic();

        one.setAvatar(DYNAMIC_ONE_USER_AVATAR);
        one.setName(DYNAMIC_ONE_USER_NAME);
        one.setUploadTime(DYNAMIC_ONE_UP_TIME);
        one.setPic(DYNAMIC_ONE_IMAGE_URL);
        one.setTitle(DYNAMIC_ONE_TITLE);
        one.setPlay(DYNAMIC_ONE_PLAY);
        one.setDanmaku(DYNAMIC_ONE_DAMUKU);


        two.setAvatar(DYNAMIC_TWO_USER_AVATAR);
        two.setName(DYNAMIC_TWO_USER_NAME);
        two.setUploadTime(DYNAMIC_TWO_UP_TIME);
        two.setPic(DYNAMIC_TWO_IMAGE_URL);
        two.setTitle(DYNAMIC_TWO_TITLE);
        two.setPlay(DYNAMIC_TWO_PLAY);
        two.setDanmaku(DYNAMIC_TWO_DAMUKU);


        three.setAvatar(DYNAMIC_THREE_USER_AVATAR);
        three.setName(DYNAMIC_THREE_USER_NAME);
        three.setUploadTime(DYNAMIC_THREE_UP_TIME);
        three.setPic(DYNAMIC_THREE_IMAGE_URL);
        three.setTitle(DYNAMIC_THREE_TITLE);
        three.setPlay(DYNAMIC_THREE_PLAY);
        three.setDanmaku(DYNAMIC_THREE_DAMUKU);


        four.setAvatar(DYNAMIC_FOUR_USER_AVATAR);
        four.setName(DYNAMIC_FOUR_USER_NAME);
        four.setUploadTime(DYNAMIC_FOUR_UP_TIME);
        four.setPic(DYNAMIC_FOUR_IMAGE_URL);
        four.setTitle(DYNAMIC_FOUR_TITLE);
        four.setPlay(DYNAMIC_FOUR_PLAY);
        four.setDanmaku(DYNAMIC_FOUR_DAMUKU);


        five.setAvatar(DYNAMIC_FIVE_USER_AVATAR);
        five.setName(DYNAMIC_FIVE_USER_NAME);
        five.setUploadTime(DYNAMIC_FIVE_UP_TIME);
        five.setPic(DYNAMIC_FIVE_IMAGE_URL);
        five.setTitle(DYNAMIC_FIVE_TITLE);
        five.setPlay(DYNAMIC_FIVE_PLAY);
        five.setDanmaku(DYNAMIC_FIVE_DAMUKU);


        six.setAvatar(DYNAMIC_SIX_USER_AVATAR);
        six.setName(DYNAMIC_SIX_USER_NAME);
        six.setUploadTime(DYNAMIC_SIX_UP_TIME);
        six.setPic(DYNAMIC_SIX_IMAGE_URL);
        six.setTitle(DYNAMIC_SIX_TITLE);
        six.setPlay(DYNAMIC_SIX_PLAY);
        six.setDanmaku(DYNAMIC_SIX_DAMUKU);


        seven.setAvatar(DYNAMIC_SEVEN_USER_AVATAR);
        seven.setName(DYNAMIC_SEVEN_USER_NAME);
        seven.setUploadTime(DYNAMIC_SEVEN_UP_TIME);
        seven.setPic(DYNAMIC_SEVEN_IMAGE_URL);
        seven.setTitle(DYNAMIC_SEVEN_TITLE);
        seven.setPlay(DYNAMIC_SEVEN_PLAY);
        seven.setDanmaku(DYNAMIC_SEVEN_DAMUKU);

        eight.setAvatar(DYNAMIC_EIGHT_USER_AVATAR);
        eight.setName(DYNAMIC_EIGHT_USER_NAME);
        eight.setUploadTime(DYNAMIC_EIGHT_UP_TIME);
        eight.setPic(DYNAMIC_EIGHT_IMAGE_URL);
        eight.setTitle(DYNAMIC_EIGHT_TITLE);
        eight.setPlay(DYNAMIC_EIGHT_PLAY);
        eight.setDanmaku(DYNAMIC_EIGHT_DAMUKU);

        nine.setAvatar(DYNAMIC_NINE_USER_AVATAR);
        nine.setName(DYNAMIC_NINE_USER_NAME);
        nine.setUploadTime(DYNAMIC_NINE_UP_TIME);
        nine.setPic(DYNAMIC_NINE_IMAGE_URL);
        nine.setTitle(DYNAMIC_NINE_TITLE);
        nine.setPlay(DYNAMIC_NINE_PLAY);
        nine.setDanmaku(DYNAMIC_NINE_DAMUKU);


        ten.setAvatar(DYNAMIC_TEN_USER_AVATAR);
        ten.setName(DYNAMIC_TEN_USER_NAME);
        ten.setUploadTime(DYNAMIC_TEN_UP_TIME);
        ten.setPic(DYNAMIC_TEN_IMAGE_URL);
        ten.setTitle(DYNAMIC_TEN_TITLE);
        ten.setPlay(DYNAMIC_TEN_PLAY);
        ten.setDanmaku(DYNAMIC_TEN_DAMUKU);


        attentionDynamics.add(one);
        attentionDynamics.add(two);
        attentionDynamics.add(three);
        attentionDynamics.add(four);
        attentionDynamics.add(five);
        attentionDynamics.add(six);
        attentionDynamics.add(seven);
        attentionDynamics.add(eight);
        attentionDynamics.add(nine);
        attentionDynamics.add(ten);

        return attentionDynamics;
    }
}
