package com.hotbitmapgg.bilibili.entity.discover;

import java.util.List;

/**
 * Created by hcc on 2016/10/3 14:32
 * 100332338@qq.com
 * <p>
 * 全区排行榜数据模型类
 */

public class AllareasRankInfo {

  /**
   * note : 统计3日内新投稿的数据综合得分，每十分钟更新一次。
   * code : 0
   * pages : 1
   * num : 100
   * list : [{"aid":6481205,"typename":"综合","title":"【呜喵王ACG】52-一拳超人第二季，骨傲天剧场版","subtitle":"","play":241163,"review":1,"video_review":2219,"favorites":8101,"mid":346059,"author":"小M呜喵王","description":"ACG资讯类杂谈","create":"2016-10-01
   * 12:35","pic":"http://i1.hdslb.com/bfs/archive/6a2d493a6d4baaadadd4eee21ae63e1d5d8472a9.jpg_320x200.jpg","coins":6113,"duration":"11:28","badgepay":false,"pts":293794},{"aid":6480777,"typename":"MMD·3D","title":"【APH/MMD】【耀诞】你从未停过的脚步","subtitle":"","play":45820,"review":7,"video_review":5958,"favorites":11907,"mid":876424,"author":"王氏矢量蔚蓝","description":"渣自制，借用见视频内。\n好几次怕自己做不出来，不过做出来了就好~诶嘿~~将就看_(:з」∠)_\n那~祖国生日快乐！~~~耀爷生日快乐！~~~大家国庆快乐~~\n剧情简单介绍见评论。","create":"2016-10-01
   * 12:00","pic":"http://i2.hdslb.com/bfs/archive/4258dea4cc5c94527ca88efb4b2d4955c508037b.jpg_320x200.jpg","coins":10076,"duration":"7:50","badgepay":false,"pts":166054},{"aid":6470850,"typename":"短片·手书·配音","title":"【APH/手书】龙殇
   * 王耀中心史向手书（2016耀诞）","subtitle":"","play":43878,"review":0,"video_review":4048,"favorites":8667,"mid":14038662,"author":"智障儿童子安","description":"前奏BGM：[永遠の一瞬]-伊藤賢治\n正片BGM：[存在]-汪峰\n\n2016耀诞贺，历史向，后妈作，高清图包下载在微博_(:з」∠)_","create":"2016-09-30
   * 17:55","pic":"http://i2.hdslb.com/bfs/archive/3bcdd47f9efad3f0fb96e2dcbcfb9b1c77b88648.jpg_320x200.jpg","coins":5203,"duration":"5:29","badgepay":false,"pts":130082},{"aid":6477889,"typename":"综合","title":"【看完你就收藏了25】听我给你说个锅盖头超能力者的故事","subtitle":"","play":124162,"review":5,"video_review":2120,"favorites":1102,"mid":7349,"author":"史丹利Studio","description":"国庆快乐！\n\n小天：就算看了秋季新番，也不要忘记我们哦。\n虚沧：一旦习惯了这种画风\u2026\u2026","create":"2016-10-01
   * 05:10","pic":"http://i2.hdslb.com/bfs/archive/967a5ca7ae0dc1d650379d9308eecf211e2f6f4a.jpg_320x200.jpg","coins":1808,"duration":"15:16","badgepay":false,"pts":130022},{"aid":6500286,"typename":"MAD·AMV","title":"【火影/最终决战】鸣人vs佐助\u2014\u2014因为我是你的「唯一」","subtitle":"","play":54107,"review":2,"video_review":915,"favorites":4586,"mid":63231,"author":"泛式","description":"火影TV最新的这个鸣佐终结谷决战的作画质量简直逆天，不做一发实在可惜。于是百忙之中抽了周末两天时间做了这样一个视频，希望大家也能回想起当年的那些热血和感动。\n\nBGM：ありがとう
   * - SUPER BEAVER\n\n泛式的微博  http://www.weibo.com/FunShiki/","create":"2016-10-02
   * 16:28","pic":"http://i1.hdslb.com/bfs/archive/e7adccc07d122166cee6b1f0e4cb641930ebbc7c.jpg_320x200.jpg","coins":4199,"duration":"6:48","badgepay":false,"pts":95464},{"aid":6472137,"typename":"MMD·3D","title":"【萌】小萝莉真是太棒了【弱音幼齿X2】【俄罗斯套娃】【60fps】","subtitle":"","play":42173,"review":0,"video_review":349,"favorites":5335,"mid":836738,"author":"missrin","description":"首先，辛苦审核君，在假期来临之际还要加班审稿~~然后这是本人的第N次二次创作；希望这个充满元气的，萌萌的小舞蹈，能够在国庆假期里，给诸位添加些欢快的气氛~【请各位多多支持~】~~借物表请详片尾~~
   * 其她合辑：【舞蹈】mylist430693 【剧情】mylist636322 【舞蹈】mylist601988","create":"2016-09-30
   * 19:30","pic":"http://i0.hdslb.com/bfs/archive/b8f65f3225876a68ce1a1efa4c58adb50ca70fbe.jpg_320x200.jpg","coins":1238,"duration":"3:39","badgepay":false,"pts":91653},{"aid":6478701,"typename":"MMD·3D","title":"【APH/MMD】于是大家愉快讨论王耀生日（耀诞寸剧）","subtitle":"","play":31290,"review":2,"video_review":3607,"favorites":5996,"mid":13955129,"author":"红色组痴汉协会","description":"借物表见视频末尾。\n耀君生日快乐！忙里偷闲做了一个月，终于在昨晚做完了，约计110张静画，但还是有些仓促，做得不好请不要嫌弃我⊙ω⊙\n祝大家国庆快乐！吃粮开心！但别忘了自己的作业哦～【某纸的邪恶笑容】","create":"2016-10-01
   * 08:59","pic":"http://i0.hdslb.com/bfs/archive/3c72b55b6d2be19c36d06eb9f28faeb690103145.jpg_320x200.jpg","coins":1875,"duration":"8:07","badgepay":false,"pts":91586},{"aid":6479302,"typename":"MMD·3D","title":"【APH/MMD】联五丨[A]ddiction【耀诞】","subtitle":"","play":29346,"review":2,"video_review":1587,"favorites":6185,"mid":1431604,"author":"Little朔北","description":"·借用在视频内丨借用在视频内丨借用在视频内\n·祝大家国庆快乐\u2014\u2014\u2014\u2014\u2014\u2014祝祖国和祖国君生日快乐\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\n·很\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014久没有摸过mmd惹，已经忘记怎么撸了【打人别打脸！毕竟我还是要靠脸撩妹的！【ntm\n·身高是因为站位的原因！再问供养！！！！【bu\n·今年大事依旧没干完，明年耀诞再干吧【说得好像明年就真的干完了一样【×\n·辣鸡网速......如果没有在十点零一分投稿一定不是我的锅【。","create":"2016-10-01
   * 10:01","pic":"http://i0.hdslb.com/bfs/archive/e0bf9a7c59dbc909260116e84646f5a4f678f2c5.jpg_320x200.jpg","coins":2199,"duration":"3:14","badgepay":false,"pts":89821},{"aid":6479297,"typename":"MAD·AMV","title":"【Re：从零开始的异世界生活/MAD】
   * 履行诺言！！！","subtitle":"","play":47307,"review":7,"video_review":2129,"favorites":4345,"mid":306805,"author":"小小☆精灵","description":"时间真快不知不觉就完结了，总之感谢从零的一直陪伴，艾米赛高莉娅最美。\n第一章：死亡即是开始
   * av4908017\n第二章：傲慢与怠惰    av5528491\n第三章：履行诺言\n外篇一：你是我的英雄 av6109882\nBGM：ナノ - SAVIOR OF SONG，MYTH
   * &amp;amp; ROID - STYX HELIX","create":"2016-10-01 10:00","pic":"http://i1.hdslb.com/bfs/archive/c9501c311bec7d4f9eb9fea168cb0f415569dc93.jpg_320x200.jpg","coins":3536,"duration":"8:51","badgepay":false,"pts":88107},{"aid":6469732,"typename":"综合","title":"美队钢铁侠都变成僵尸了？漫威丧尸英雄传！
   * 第一章【Lorre】","subtitle":"","play":75140,"review":1,"video_review":706,"favorites":1324,"mid":7487399,"author":"努力的Lorre","description":"微信公众号：努力的Lorre
   * \nQQ公众号：努力的Lorre\n微博：努力的Lorre\n商务合作QQ：767757887","create":"2016-09-30
   * 16:29","pic":"http://i2.hdslb.com/bfs/archive/ad2bf49146860c8940aed10ac97710620f6d280b.jpg_320x200.jpg","coins":2061,"duration":"9:36","badgepay":false,"pts":81566},{"aid":6487358,"typename":"MMD·3D","title":"【APH/MMD】耀诞·礼","subtitle":"","play":24512,"review":2,"video_review":5488,"favorites":5273,"mid":2036187,"author":"零豆汤°","description":"
   * NINI我爱你啊( ˘ ³˘)♡与你一同送出的祝福\n29号回来 30号一天做的起飞才赶上耀诞\n*本视频是耀中心\n*因为只有一天时间 所以还想做的耀相关组合 放在第四章第五章啦
   * 给我留个空喘口气（）\n非常匆忙 海涵\n\n借用见视频1P最后\n","create":"2016-10-01 19:47","pic":"http://i1.hdslb.com/bfs/archive/d25384bcea894e24f06bf6433658567cbbfbbefb.jpg_320x200.jpg","coins":5176,"duration":"10:56","badgepay":false,"pts":79902},{"aid":6477774,"typename":"MAD·AMV","title":"【MAD】鸣人VS佐助「Black
   * and Blue」","subtitle":"","play":56844,"review":0,"video_review":333,"favorites":2199,"mid":381738,"author":"M.Scarlet","description":"
   *  搬运 https://www.youtube.com/watch?v=KrV3xrjTq1k  Naruto vs. Sasuke 「AMV」 - Black and Blue
   * &amp;amp;quot;Final&amp;amp;quot; [ Full Fight ] ","create":"2016-10-01
   * 04:19","pic":"http://i2.hdslb.com/bfs/archive/357da802f1a591de0b94d7a8661b408bde6c0835.jpg_320x200.jpg","coins":452,"duration":"3:16","badgepay":false,"pts":73481},{"aid":6471269,"typename":"综合","title":"【毒药漫谈】东方Project是什么？","subtitle":"","play":29653,"review":5,"video_review":3152,"favorites":4371,"mid":28832,"author":"短刀与毒药","description":"自制
   * 终于填上这个坑了 前段时间因为工作原因拖更跳票了数次 真是不好意思 身为一个浑身是叼的UP主让大家操心了\n东方真好啊 成都东方乐祭真好啊 能有喜欢东方的朋友真好啊
   * \n觉得还可以的话就硬币关注一波吧 \n个人ACG群：390020311\n","create":"2016-09-30 18:24","pic":"http://i1.hdslb.com/bfs/archive/57cf14cc88e74285b43d9b63ffbe1c7ae6b2332f.jpg_320x200.jpg","coins":3949,"duration":"18:06","badgepay":false,"pts":73415},{"aid":6479468,"typename":"MMD·3D","title":"【MMD】旗袍眼花缭乱？！其四
   *   腿玩年福利向~【Girls 】","subtitle":"","play":23450,"review":0,"video_review":708,"favorites":5142,"mid":11555954,"author":"Wuranke","description":"这次增加了许多，来看看有你认识的大白腿吗_(:3
   * 」∠)_  至于歌曲的字幕就没做了（怠惰了一下）还有就是祝大家国庆节快乐！！(´・ω・)ﾉ   视频高清下载http://pan.baidu.com/s/1hs2UYRM
   * 1080P超清封面下载http://pan.baidu.com/s/1geB4tUF （借物表在视频开头）","create":"2016-10-01
   * 10:15","pic":"http://i0.hdslb.com/bfs/archive/8723f497df50384cb7df52e3a6a1f14798a8c972.jpg_320x200.jpg","coins":859,"duration":"3:51","badgepay":false,"pts":73226},{"aid":6469025,"typename":"综合","title":"描画口袋妖怪进化过程的插画
   * 第二弹 @柚子木字幕组","subtitle":"","play":59891,"review":0,"video_review":300,"favorites":1456,"mid":221648,"author":"柚子木字幕组","description":"2
   * https://www.youtube.com/watch?v=F3xgXEQ6Hmc【柚子木字幕组论坛正式开放 www.youzimu.com 招募翻译、听译、校对、时间轴】
   * 更多精彩视频请 微信公众号Youzimu 微博搜索@柚子木字幕组 http://weibo.com/youzimucom","create":"2016-09-30
   * 15:25","pic":"http://i0.hdslb.com/bfs/archive/2cce695e0d50e7e5e5007f1ce765eed535186cf0.jpg_320x200.jpg","coins":130,"duration":"2:28","badgepay":false,"pts":68760},{"aid":6468981,"typename":"短片·手书·配音","title":"【全职高手】暗黑向同人\u2014无信者【荣耀剧组】","subtitle":"","play":40350,"review":4,"video_review":1916,"favorites":2659,"mid":4534176,"author":"荣耀剧组","description":"《全职高手》暗黑向同人作品\n\n当一直引以为豪的默契，成为互相伤害的筹码；当一直坚持遵从的信仰，化作追寻真相的障碍\u2026\u2026\n你最熟悉的他，会是这一切罪恶的源泉么？事情的真相，？？？的身份，你，准备好揭开谜底了么？\n\n如果你能接受这种残忍，请欣赏荣耀剧组年度巨制【划掉】\u2014无信者","create":"2016-09-30
   * 15:20","pic":"http://i1.hdslb.com/bfs/archive/bc657673a968f57c9f3d0d6cbaa9dbdae0539452.jpg_320x200.jpg","coins":778,"duration":"5:00","badgepay":false,"pts":64765},{"aid":6471530,"typename":"综合","title":"《你的名字》百亿票房背后：改变而非进化","subtitle":"","play":56524,"review":5,"video_review":516,"favorites":1290,"mid":904827,"author":"机智的咸鱼","description":"自制，哈哈哈哈哈哈哈EDG，我们都欠老干爹一个对不起","create":"2016-09-30
   * 18:44","pic":"http://i2.hdslb.com/bfs/archive/9e3a3d8fdfc8e02722cfba0e8666f71c68c3a9b6.jpg_320x200.jpg","coins":700,"duration":"8:01","badgepay":false,"pts":64287},{"aid":6495066,"typename":"短片·手书·配音","title":"【黑榜社】【火柴人】IMITATE
   * MORE【墨色大陆】","subtitle":"","play":33334,"review":1,"video_review":339,"favorites":2987,"mid":27171942,"author":"Lsquido","description":"给火柴人模仿者联合(av2134250)的致敬作品\n\n虽然是致敬作品,不过用的全是我自己的人设....\n人设介绍可以去翻我的lofter
   * :3\nhttp://lsquido.lofter.com/\n\n(明确一下更新间隔大概半年....因为马上要准备很多考试...比如司考GRE什么的)","create":"2016-10-02
   * 10:20","pic":"http://i0.hdslb.com/bfs/archive/90e4b46e29c7c4f93eafa236cb51b96f7c6a0336.jpg_320x200.jpg","coins":3231,"duration":"1:17","badgepay":false,"pts":60208},{"aid":6471151,"typename":"短片·手书·配音","title":"【动画短片合集】看到是喜仔的合集你就点进来了","subtitle":"","play":33028,"review":3,"video_review":1569,"favorites":2461,"mid":7760828,"author":"喜仔的世界","description":"vimeo.com/user3502790/likes
   * 五个风格不同的动画短片，希望你能看的开心。如果你喜欢这个系列的视频，请投一枚硬币吧，你的支持可以带给我给我更大的动力，非常感谢大家的鼓励和支持。欢迎加入喜仔QQ轰趴群：531829163
   * PS：祝大家国庆节玩的开心，我们不放假_(:3 」∠)_   ","create":"2016-09-30 18:16","pic":"http://i1.hdslb.com/bfs/archive/c10ba98f7c0b614c034c59ca0d94e43903cd60a7.jpg_320x200.jpg","coins":651,"duration":"25:49","badgepay":false,"pts":55861},{"aid":6472638,"typename":"综合","title":"【木鱼微剧场】几分钟看完《浪客剑心追忆篇》","subtitle":"","play":46393,"review":2,"video_review":632,"favorites":1135,"mid":927587,"author":"木鱼水心","description":"世界如此艰难，每天生活只有一声叹息，但人们还是在努力的追求美好，只是这过程中总是伴随着悲伤与离别。想想剑心在这个故事之后，一直保持着那种微笑的温柔，却又在心里流着理想主义的血，凭借自己的全力去保护身边的人，正因为剑心历经如此的痛苦，所以他才最能理解幸福的意义。","create":"2016-09-30
   * 20:07","pic":"http://i2.hdslb.com/bfs/archive/21586921c6b412e6759280e67482be08f2cb6be7.jpg_320x200.jpg","coins":2136,"duration":"12:58","badgepay":false,"pts":53729},{"aid":6482943,"typename":"综合","title":"描写口袋妖怪进化过程的优秀插画
   * #3 @柚子木字幕组","subtitle":"","play":45497,"review":0,"video_review":520,"favorites":1168,"mid":221648,"author":"柚子木字幕组","description":"2
   * https://www.youtube.com/watch?v=zvKaUOZP1mM【柚子木字幕组论坛正式开放 www.youzimu.com 招募翻译、听译、校对、时间轴】
   * 更多精彩视频请 微信公众号Youzimu 微博搜索@柚子木字幕组 http://weibo.com/youzimucom","create":"2016-10-01
   * 14:49","pic":"http://i2.hdslb.com/bfs/archive/d21a5117a7cc1ff0a2b406aacbd4cf8298c02347.jpg_320x200.jpg","coins":119,"duration":"4:40","badgepay":false,"pts":53142},{"aid":6470912,"typename":"MMD·3D","title":"【深夜福利】初音酱的颜艺！！？？","subtitle":"","play":33170,"review":1,"video_review":212,"favorites":1870,"mid":14256806,"author":"脱俗君","description":"bgm;Bangarang\n借物表见视频末\n国庆深夜福利系列第一弹0.0\n久违了，谢谢现在还没取关的朋友23333","create":"2016-09-30
   * 17:59","pic":"http://i2.hdslb.com/bfs/archive/0f704d4a1435157c2239bb0998b99f7d6a9ae402.jpg_320x200.jpg","coins":469,"duration":"0:46","badgepay":false,"pts":48764},{"aid":6486460,"typename":"综合","title":"【废柴君】盘点动画中装逼失败被打脸的情节！
   *   一天不装我浑身难受","subtitle":"","play":42386,"review":0,"video_review":1594,"favorites":886,"mid":2846448,"author":"机智的废柴君","description":"以前也做过一期这样的视频，av4951402
   *  这次算是续集吧\n做装逼的很多，做装逼失败的就很少了，也算是新领域的尝试。\n话说我最近高产过头了，实在是想好好休息一段时间，国庆可能只会再发一个混剪了。\n好想出去旅游啊，国庆不想一直窝在家里，我快变成死宅了。\n新浪微博：机智的废柴君\n动漫扯淡群：567845573\n\n","create":"2016-10-01
   * 18:46","pic":"http://i2.hdslb.com/bfs/archive/1212b475be8a3bc4f002feecce70040ceab743bc.jpg_320x200.jpg","coins":259,"duration":"22:00","badgepay":false,"pts":48549},{"aid":6501418,"typename":"MMD·3D","title":"【唯美向】前奏征服你系列【歌曲超赞】","subtitle":"","play":14349,"review":1,"video_review":380,"favorites":3468,"mid":277257,"author":"初音社","description":"自制：\n提示:因为码率限制
   * 原画质可以下载原文件观看\n视频下载地址: 见评论\n如果喜欢UP主的自制 欢迎弹幕硬币支援\n借物表 : 模型:Revised樣 动作：Miky Rei様
   * 场景：怪獣対若大将P樣MME：ExcellentShadow2 MotionBlur3 AutoLuminous4 CheapLens そぼろ様HgSAO HgPointLight
   * 針金P様  ikeno様 下腹P樣\n交流Q群: 200413781\n周边小店: http://mikuclub.taobao.com","create":"2016-10-02
   * 17:41","pic":"http://i2.hdslb.com/bfs/archive/8ec62530c9537c37873fefcd85430fc182c9f7f6.jpg_320x200.jpg","coins":1064,"duration":"4:38","badgepay":false,"pts":47971},{"aid":6480926,"typename":"短片·手书·配音","title":"【中文配音】某科学的超电磁炮S
   * 第二话","subtitle":"","play":31327,"review":6,"video_review":2011,"favorites":1413,"mid":79,"author":"saber酱","description":"自制
   * 大家期待已久的中文配音版 某三年的见异思迁 终于宣告完成 有硬币的都砸过来吧~ 感谢辛勤耕耘的CV们 同时鸣谢文静可爱的后期君 你们辛苦了 CAST/STAFF见OP
   * P.S：国庆快乐~献给喜欢超电磁炮的你","create":"2016-10-01 12:12","pic":"http://i0.hdslb.com/bfs/archive/4911b65d177250b6ebc80ec6c2c201e7cd67a0c8.jpg_320x200.jpg","coins":2366,"duration":"23:30","badgepay":false,"pts":44244},{"aid":6473444,"typename":"MMD·3D","title":"【MMD】弱音：\u201c好想告诉你，喵~\u201d，染上你的颜色","subtitle":"","play":20981,"review":0,"video_review":168,"favorites":2477,"mid":2455539,"author":"Number7","description":"祝大家国庆节快乐~\n视频禁止转载以及二次上传。\n借物表：请看片尾。","create":"2016-09-30
   * 21:02","pic":"http://i1.hdslb.com/bfs/archive/4a04258aebbc06c0027e0345d881f4d5a06ee716.jpg_320x200.jpg","coins":302,"duration":"3:17","badgepay":false,"pts":43820},{"aid":6480435,"typename":"综合","title":"【何必点评呢】后宫漫特别个人向点评
   *  不是推荐哦","subtitle":"","play":29488,"review":0,"video_review":1959,"favorites":1532,"mid":2829782,"author":"何必Hebee","description":"自制
   * 小伙伴们国庆快乐 大家又到了放假的日子 不来群里玩吗 创群一周年 想想有点小激动\n这次视频是个人向 个人向 特别个人向 仅代表我自己看法~","create":"2016-10-01
   * 11:35","pic":"http://i1.hdslb.com/bfs/archive/ced02ecffc799c9de5fec6b71fae1483a9a3fb42.jpg_320x200.jpg","coins":542,"duration":"15:43","badgepay":false,"pts":43730},{"aid":6476163,"typename":"MMD·3D","title":"【APH/MMD】少主Logic【耀诞2016】","subtitle":"","play":10025,"review":0,"video_review":672,"favorites":2809,"mid":746775,"author":"树十五五","description":"耀君生日快乐~感谢台风假（。）终于赶上了\u2026!!!","create":"2016-10-01
   * 00:00","pic":"http://i2.hdslb.com/bfs/archive/cc8fb79c9cf58e2626572ff4b7f434c7b7f9df30.jpg_320x200.jpg","coins":883,"duration":"3:47","badgepay":false,"pts":37772},{"aid":6480108,"typename":"综合","title":"猫和老鼠鬼畜配音46：网球并不可笑嘛~","subtitle":"","play":30467,"review":0,"video_review":852,"favorites":882,"mid":7019628,"author":"滑音未来","description":"算是做完了\u2026\u2026最近真是忙啊，忙到无心鬼畜凑合着配了个音~","create":"2016-10-01
   * 11:08","pic":"http://i0.hdslb.com/bfs/archive/cc8b4b1595d55aaf168ab7edc05a0fda5f0e0c20.jpg_320x200.jpg","coins":1226,"duration":"8:38","badgepay":false,"pts":37072},{"aid":6471612,"typename":"综合","title":"【动漫这个啥】8分半带你看完RE从零开始的异世界生活","subtitle":"","play":32297,"review":1,"video_review":335,"favorites":726,"mid":570395,"author":"路人甲at提不起劲","description":"重发，上次推送炸了，凸(艹皿艹
   * )","create":"2016-09-30 18:50","pic":"http://i0.hdslb.com/bfs/archive/ed09737bef029a408bc289261ed0f18a6e854345.jpg_320x200.jpg","coins":713,"duration":"8:34","badgepay":false,"pts":36660},{"aid":6473145,"typename":"短片·手书·配音","title":"PPAP正式中文版","subtitle":"","play":33058,"review":0,"video_review":174,"favorites":644,"mid":5681,"author":"DCZLD","description":"最近有个苹果大菠萝的歌挺火的，我看没有中文正式版，我就做了一个。我真是中外文化交流小天使。全人声纯天然没添加剂。没错我就是闲的。\n微博：@肉饼家的DC
   * ","create":"2016-09-30 20:43","pic":"http://i0.hdslb.com/bfs/archive/cf4323f9813c341c5640f0128941bc484b1c1b4e.png_320x200.png","coins":542,"duration":"0:39","badgepay":false,"pts":36365},{"aid":6506897,"typename":"综合","title":"【H萌漫讯】一拳超人第二季，银魂动画连载再开","subtitle":"","play":34634,"review":2,"video_review":1034,"favorites":317,"mid":18030567,"author":"H萌团队","description":"国庆照常更新，快夸我！\n本期的话题是：十月新番也是马上就要开播了，大家最想看的，觉得人气会最火的是哪一部呢？","create":"2016-10-02
   * 23:09","pic":"http://i0.hdslb.com/bfs/archive/e5baf71a5a42ca493a42d152036482ee3f74f961.jpg_320x200.jpg","coins":467,"duration":"8:46","badgepay":false,"pts":35345},{"aid":6487982,"typename":"MMD·3D","title":"【APH/MMD】坚定的爱【耀誕2016】","subtitle":"","play":9067,"review":1,"video_review":981,"favorites":2598,"mid":6315047,"author":"王司徒爱吃辣条","description":"给最爱的仙人永远坚定的爱！耀君生日快乐！✿\n\n是比较匆忙的制作，不足之处请见谅，总之。爱意传达到了给你就好^
   * ^","create":"2016-10-01 20:22","pic":"http://i1.hdslb.com/bfs/archive/ef59abded2a54320fed71c0122be7abe38b9d0b4.jpg_320x200.jpg","coins":1263,"duration":"3:57","badgepay":false,"pts":35094},{"aid":6468735,"typename":"综合","title":"【我就不信了第2季第8期】
   * 勇者喜欢巨乳魔王有什么错","subtitle":"","play":31283,"review":0,"video_review":257,"favorites":575,"mid":25522709,"author":"被窝工作室","description":"魔王与勇者，上古时代就不断战斗的两个对手，传言两人不仅是父子还可能是夫妻，更有甚者传出了其实魔王是勇者的女儿身份？!事实的真相是什么，勇者到底和魔王什么关系，两人敌对的火花最终迎向的结局真是表面上的讲的那么美好吗？","create":"2016-09-30
   * 14:51","pic":"http://i1.hdslb.com/bfs/archive/3d140007a296bc668ab86b61536a6496fb1e8f36.jpg_320x200.jpg","coins":75,"duration":"9:47","badgepay":false,"pts":34159},{"aid":6502222,"typename":"综合","title":"那些描写神奇宝贝进化过程的优秀插画
   * 第4弹 @柚子木字幕组","subtitle":"","play":29701,"review":1,"video_review":334,"favorites":688,"mid":221648,"author":"柚子木字幕组","description":"2
   * https://www.youtube.com/watch?v=Bbn0JJm5qWs【柚子木字幕组论坛正式开放 www.youzimu.com 招募翻译、听译、校对、时间轴】
   * 更多精彩视频请 微信公众号Youzimu 微博搜索@柚子木字幕组 http://weibo.com/youzimucom","create":"2016-10-02
   * 18:31","pic":"http://i1.hdslb.com/bfs/archive/43610bccc82551cbd9509d3736a0ffd6cf10dd89.jpg_320x200.jpg","coins":103,"duration":"3:10","badgepay":false,"pts":33942},{"aid":6476561,"typename":"综合","title":"【动画萌太奇】10月新番推荐","subtitle":"","play":28462,"review":4,"video_review":901,"favorites":552,"mid":310709,"author":"带码菌","description":"自制的一档以动画评论为主的自媒体节目，立志为大家带来好看，好玩，涨姿势的内容，做一个有态度的动画评论人。合作邮箱
   * ： amdaimajun@qq.com   微博：@带码菌  ","create":"2016-10-01 00:30","pic":"http://i0.hdslb.com/bfs/archive/1fa89be8cd8d3f971d3141f7ce46d51344eeb38f.jpg_320x200.jpg","coins":848,"duration":"12:19","badgepay":false,"pts":32013},{"aid":6503029,"typename":"综合","title":"成人版葫芦娃，我亲手毁掉了经典，抱歉！（待完结）","subtitle":"","play":24874,"review":1,"video_review":445,"favorites":672,"mid":2797650,"author":"平胸狂魔Max","description":"还有一期就完结了，就先整理了合集吧！","create":"2016-10-02
   * 19:18","pic":"http://i1.hdslb.com/bfs/archive/d5ed22db804a9267fa41f735a3e3c706f8384dff.jpg_320x200.jpg","coins":696,"duration":"33:19","badgepay":false,"pts":29545},{"aid":6492649,"typename":"短片·手书·配音","title":"【乱斗60秒】浩克VS布罗利【One
   * Minute Melee】","subtitle":"","play":30805,"review":2,"video_review":311,"favorites":143,"mid":10350985,"author":"Racoonamatata","description":"转自YouTube，Hyun's
   * Dojo频道 \n这期做得真的不错耶！\n肌肉猛男啪啪啪的打，太刺激了\n原标题：One Minute Melee S4 EP2 - Hulk Vs Broly (Marvel vs
   * DBZ)\n原地址：https://www.youtube.com/watch?v=Pr5poGAZ9Tk","create":"2016-10-02
   * 01:52","pic":"http://i0.hdslb.com/bfs/archive/4cc4889ad5683d718f172678f920e1d334b7c195.jpg_320x200.jpg","coins":56,"duration":"3:19","badgepay":false,"pts":29463},{"aid":6481112,"typename":"综合","title":"【动漫短评】你还没看过《一人之下》！？那我快速的带你看前6集","subtitle":"","play":28960,"review":2,"video_review":315,"favorites":275,"mid":9136870,"author":"LeeAJie","description":"你们懂得\n\n本期节目有抽奖活动
   * 记得看到最后","create":"2016-10-01 12:27","pic":"http://i0.hdslb.com/bfs/archive/6de174af57eeb1719be8ce8e2fb6b92e5d50fba2.jpg_320x200.jpg","coins":343,"duration":"5:28","badgepay":false,"pts":29127},{"aid":6480358,"typename":"MMD·3D","title":"【MMD】成熟小姐姐弱音
   * 黑色连衣裙的PINK CAT","subtitle":"","play":14968,"review":1,"video_review":78,"favorites":1507,"mid":513254,"author":"饺子鸡","description":"依然是泛青的复古色调，幼月的镜头实在是厉害，得好好学习。最近在筹备一个大（zha）作，在辛苦K帧中，所以没什么时间投别的稿了，漫漫填坑路，说出来都是泪。动作：アガちん
   * 镜头：永远赤红的幼月 模型：TDA/Akero-K 特效：ikPolishShader ikGhostLens diffusion7 Autoluminous svSSAO
   * lightbloom powerDOF ","create":"2016-10-01 11:29","pic":"http://i0.hdslb.com/bfs/archive/6e0fe9e3ecfca1557e9c2a2330467ebb4a538257.jpg_320x200.jpg","coins":105,"duration":"1:13","badgepay":false,"pts":28619},{"aid":6476815,"typename":"MMD·3D","title":"【APH/MMD】小小的耀诞企划【耀诞2016】","subtitle":"","play":6172,"review":0,"video_review":1318,"favorites":2045,"mid":7417280,"author":"北辰North","description":"肝要炸了............不管了\n耀耀生日快乐！！！！！！！！！！！！！！\n各位国庆快乐！！！！！！！！\n好了就这么多(￣ε(#￣)弹幕和评论区请遵守视频开头的规定，借物见视频末尾","create":"2016-10-01
   * 00:59","pic":"http://i0.hdslb.com/bfs/archive/eea574fd3da6055cd3c876a79175e1365b41efde.jpg_320x200.jpg","coins":676,"duration":"32:26","badgepay":false,"pts":27259},{"aid":6483262,"typename":"短片·手书·配音","title":"[动态漫画]伊吹五月-不可泳思02","subtitle":"","play":19769,"review":0,"video_review":421,"favorites":699,"mid":397508,"author":"_越真","description":"祝大家国庆快乐~~~","create":"2016-10-01
   * 15:11","pic":"http://i2.hdslb.com/bfs/archive/a7e1f82197a0731838a557801fb2d3e554a68145.jpg_320x200.jpg","coins":974,"duration":"5:11","badgepay":false,"pts":25196},{"aid":6470904,"typename":"MMD·3D","title":"第二次二货战争系列【萌王EX-二货组】Elect【大神犬PV付】","subtitle":"第二次二货战争系列【萌王EX-二货组】Elect【大神犬PV付】","play":13089,"review":0,"video_review":122,"favorites":1267,"mid":895617,"author":"CME6大神犬","description":"自制
   * 虽然之前说要很认真的做视频，但是发现太认真后，特效放太多码率根本压不下去Orz（然后终于想起了自己为啥喜欢搞简单背景的原因了），如果大家想看清晰还是自己下吧
   * 下载点：https://pan.baidu.com/s/1nuSSXZz（---借物列表在视频开头了---）","create":"2016-09-30
   * 17:59","pic":"http://i1.hdslb.com/bfs/archive/46a130935b8ed9c1adabfbf4be40699452630151.jpg_320x200.jpg","coins":212,"duration":"3:11","badgepay":false,"pts":24571},{"aid":6472758,"typename":"MMD·3D","title":"【MMD绅士福利】PINK
   * CAT 「弱音&巡音&洛天依」","subtitle":"","play":8088,"review":1,"video_review":93,"favorites":1586,"mid":5311645,"author":"绯音凉太","description":"YouTube
   * 作者：tpo2120\n网站：https://www.youtube.com/watch?v=8aljTjple7Q","create":"2016-09-30
   * 20:15","pic":"http://i2.hdslb.com/bfs/archive/8523ea730338eae00b27708d3a4aabebb806d6ab.jpg_320x200.jpg","coins":58,"duration":"3:52","badgepay":false,"pts":23232},{"aid":6483107,"typename":"MMD·3D","title":"【APH/MMD】绛红色的轨迹（给耀君的红色企划）","subtitle":"","play":4139,"review":2,"video_review":1758,"favorites":1783,"mid":1809317,"author":"鬼獅","description":"红色耀诞企划完美收工。拖延到现在实在非常抱歉，视频一共分为4p。\n感谢参与的各位！感谢各位的支持！\n请遵守规则观看视频哦。\n王耀生日快乐！！！\n贺文网盘地址【
   * https://pan.baidu.com/s/1geF7ZYN?qq-pf-to=pcqq.c2c 】感谢您的观看！\n活动见微博。","create":"2016-10-01
   * 14:58","pic":"http://i0.hdslb.com/bfs/archive/5c640febbb9ccc336db89892e180bba7e4a13910.jpg_320x200.jpg","coins":829,"duration":"32:45","badgepay":false,"pts":23179},{"aid":6511369,"typename":"综合","title":"周刊哔哩哔哩排行榜#328","subtitle":"","play":19878,"review":5,"video_review":2042,"favorites":162,"mid":288239,"author":"虐猫狂人薛定谔","description":"自制
   * 16年10月第1周 | 【PICK UP】栏目欢迎继续推荐，私信@虐猫狂人薛定谔 ，附上推荐投稿的av号与理由。请勿刷屏、引战【@周刊哔哩哔哩排行榜 微博→
   * http://weibo.com/biliran","create":"2016-10-03 11:00","pic":"http://i0.hdslb.com/bfs/archive/3215657d2f67f246990bf618a157d245723ecf07.jpg_320x200.jpg","coins":134,"duration":"22:29","badgepay":false,"pts":21354},{"aid":6496282,"typename":"综合","title":"【呜喵说】菜月昴，一个有点智商的\u2026\u2026嗯\u2026\u2026（我大概是H萌最后一个说的吧）","subtitle":"","play":18515,"review":0,"video_review":263,"favorites":327,"mid":346059,"author":"小M呜喵王","description":"最终还是做了这个漫评。比起说剧情，更多的是对菜月昴这个角色的有感而发。长月塑造的还算不错，可惜动画只有25集。（修改了一些地方，片头的小剧场是玩的日和梗）","create":"2016-10-02
   * 11:51","pic":"http://i0.hdslb.com/bfs/archive/81c7c7458e71edc688cbf30d70fb76307fa4ad7a.jpg_320x200.jpg","coins":347,"duration":"12:21","badgepay":false,"pts":20193},{"aid":6469989,"typename":"综合","title":"【橙心动漫速报】银魂人气登顶
   *  《你的名字。》国内确认引进","subtitle":"","play":17604,"review":3,"video_review":313,"favorites":244,"mid":28822227,"author":"橙心资讯","description":"《你的名字。》国内确认引进；overload重大发表就是个总集篇；《飙速宅男》第三季PV公开；《精灵宝可梦》将走搞笑路线；银魂人气登顶
   * ，赤井秀一反超柯南\n官博@橙心社 淘宝Id:橙心社动漫周边 官网：cxacg.com","create":"2016-09-30
   * 16:49","pic":"http://i2.hdslb.com/bfs/archive/7807e0c639cc9b6170316d6dc5136fc1701a763a.jpg_320x200.jpg","coins":153,"duration":"3:45","badgepay":false,"pts":18593},{"aid":6470517,"typename":"MMD·3D","title":"MMD
   * PINK CAT 猫猫内衣弱音HAKU","subtitle":"","play":"--","review":0,"video_review":100,"favorites":1339,"mid":7287761,"author":"最爱缘兔子","description":"Video
   * DL:pan.baidu.com/s/1bp5NdGb\nmotion:sm28055630\ncamera:in motion\nmodel:(神帝宇)tieba.baidu.com/p/4564238417\nstage:(DiemDo-Shiruhane)diemdo-shiruhane.deviantart.com/art/EnvyCatwalk-UnhappyRefrain-pack-MMD-stage-DL-468967597\nMME:nil、針金P、そぼろ、TK","create":"2016-09-30
   * 17:28","pic":"http://i2.hdslb.com/bfs/archive/1c4fc7222e9f8a7d6de76f0bde30f0c558f71d55.jpg_320x200.jpg","coins":226,"duration":"3:50","badgepay":false,"pts":17854},{"aid":6471440,"typename":"MMD·3D","title":"【东方MMD】红魔小不点【全程高萌】","subtitle":"","play":14037,"review":0,"video_review":216,"favorites":473,"mid":149592,"author":"幻想乡的新月","description":"sm29736950
   * \nヨエ団：才不是萝莉控呢，只有这一点的真相咱必须说出来","create":"2016-09-30 18:37","pic":"http://i1.hdslb.com/bfs/archive/41654abe478c81f19213dea96e3e04d28525cf77.jpg_320x200.jpg","coins":55,"duration":"3:15","badgepay":false,"pts":17576},{"aid":6474171,"typename":"综合","title":"【唯物语】音乐动漫你看过BECK吗？","subtitle":"","play":15365,"review":1,"video_review":211,"favorites":326,"mid":387549,"author":"南家小唯","description":"妙蛙种子微博地址http://weibo.com/minamikeyui/\n让我们来一起撩动耳朵，让你的灵魂受到了洗礼吧！来听一曲BECK的音乐~~","create":"2016-09-30
   * 21:50","pic":"http://i0.hdslb.com/bfs/archive/01d343b384784adcd143cffabd7a870137a51213.jpg_320x200.jpg","coins":362,"duration":"7:50","badgepay":false,"pts":17297},{"aid":6473980,"typename":"MMD·3D","title":"（MMD）我的两个女秘书，只可远观而不可亵玩焉","subtitle":"","play":"--","review":0,"video_review":60,"favorites":1246,"mid":773873,"author":"喜欢巡音的CL君","description":"这种让人流鼻血的秘书你想要么？想要？不给你~！\nmodle：ONEiROLogY様（微改一个巡音）\nmotion/cam：アガちん様\nstage：シロクマ様
   * 直升机：phamser様 坦克：E-25 地图：sangekikuma様 游戏机：シロ様 漫画书：onimau619様\nmme：下っ腹P様 そぼろ様 おたもん様 針金P様
   * Elle/データP様 nil様 ビームマンP様 化身バレッタ様 TK様 ussy様o_SelfOverlay_v0_6\nBGM：PINK CAT -
   * GARNiDELiA","create":"2016-09-30 21:38","pic":"http://i2.hdslb.com/bfs/archive/ac401525ddf9720bb3efdddca47c19c20c582093.jpg_320x200.jpg","coins":214,"duration":"3:50","badgepay":false,"pts":17198},{"aid":6481276,"typename":"综合","title":"RS带你看《甲贺忍法帖》","subtitle":"","play":15159,"review":1,"video_review":352,"favorites":168,"mid":2196632,"author":"RushSong","description":"=
   * =","create":"2016-10-01 12:42","pic":"http://i1.hdslb.com/bfs/archive/2e299ff1318950fecd450cd0ce5ba6a862862885.jpg_320x200.jpg","coins":986,"duration":"7:48","badgepay":false,"pts":15667},{"aid":6471163,"typename":"MMD·3D","title":"【国庆福利
   * - 改模配布】3只携带 ♂ 汁的黑丝，还不够你pr吗？(๑°⌓°๑)","subtitle":"","play":7999,"review":3,"video_review":55,"favorites":725,"mid":25183186,"author":"MMD大狐狸丶","description":"这3只军装大狐狸，欧派好大呀！(╯°口°)╯\n配布地址：https://bowlroll.net/file/116094\n（DL
   * - 解压码，都在视频内，请仔细观看。）\n米娜，国庆节快乐。(｡･ω･｡)\n借物表在视频结尾。\n原画链接不公开。（配布视频：不可转载，不可搬运。）","create":"2016-09-30
   * 18:17","pic":"http://i2.hdslb.com/bfs/archive/65f598a8fe3df0865c04a10ac18e3f3ddfd59964.jpg_320x200.jpg","coins":84,"duration":"3:08","badgepay":false,"pts":14506},{"aid":6479100,"typename":"MMD·3D","title":"凹凸世界MMD（模型全公开，一起来调教！）","subtitle":"","play":8257,"review":1,"video_review":489,"favorites":625,"mid":15770782,"author":"七创社凹凸世界","description":"谁都相当up主！凹凸世界MMD模型全公开，活动详情查看七创社官网：http://7doc.cn/mmdactivity.html
   *  十一期间剧集停更什么的我才不告诉你们呢！","create":"2016-10-01 09:43","pic":"http://i0.hdslb.com/bfs/archive/d7e907e13eac5dae4cec7f689727f8626d32f0d4.jpg_320x200.jpg","coins":632,"duration":"3:21","badgepay":false,"pts":14153},{"aid":6488247,"typename":"短片·手书·配音","title":"【魔道祖师】《锦鲤抄》\u2014\u2014三尊剧情向手书MAD","subtitle":"","play":4751,"review":2,"video_review":452,"favorites":723,"mid":5483773,"author":"妙蛙橘","description":"第一次做手书多有不足
   * 大噶包涵！\n爱生活爱亲妈：墨香铜臭\n导演/绘图：苜菽蔬\n视频制作：妙蛙橘子\n感谢女神们授权《锦鲤抄》！【视频禁转载】","create":"2016-10-01
   * 20:38","pic":"http://i1.hdslb.com/bfs/archive/83ffecc452196b05f501f49be5da60489ba6ff37.jpg_320x200.jpg","coins":466,"duration":"4:49","badgepay":false,"pts":11941},{"aid":6480882,"typename":"MAD·AMV","title":"【多素材/节奏向/AMV】我已经迷失于云端，此刻你能否拯救我～You
   * were my gravity","subtitle":"","play":6244,"review":0,"video_review":139,"favorites":606,"mid":4855394,"author":"恐恐","description":"联动mad区扛把子
   * hx神的：av6480685\n无意间听到了这首歌，听的时候脑子里浮现了穿梭于宇宙的飞行画面23333，然后就填了一个。\n又正好是国庆节，算是国庆特别作了，嘿嘿。\n祝大家国庆快乐哦！！！！\nBGM:Against
   * the Current - Gravity\n封面p站id=48269530\n感谢大家一直以来的支持！！","create":"2016-10-01
   * 12:08","pic":"http://i0.hdslb.com/bfs/archive/1abc24c2c626bb4e8e0928a256666597ea21064c.jpg_320x200.jpg","coins":409,"duration":"3:26","badgepay":false,"pts":11816},{"aid":6499534,"typename":"短片·手书·配音","title":"【创想动画片】向我的狗狗学习
   * @柚子木字幕组","subtitle":"","play":7794,"review":1,"video_review":41,"favorites":410,"mid":221648,"author":"柚子木字幕组","description":"2
   * https://www.youtube.com/watch?v=i2ilPnhE4fs【柚子木字幕组论坛正式开放 www.youzimu.com 招募翻译、听译、校对、时间轴】
   * 更多精彩视频请 微信公众号Youzimu 微博搜索@柚子木字幕组 http://weibo.com/youzimucom","create":"2016-10-02
   * 15:37","pic":"http://i2.hdslb.com/bfs/archive/5d92b955447de91826e1e405b32a7453c67dba11.jpg_320x200.jpg","coins":82,"duration":"1:54","badgepay":false,"pts":11156},{"aid":6471470,"typename":"短片·手书·配音","title":"【东方妖妖梦】Bloomin\u2019Blossom
   * 紺碧studio【东方Vocal PV】【强烈推荐！】","subtitle":"","play":4436,"review":0,"video_review":76,"favorites":687,"mid":149592,"author":"幻想乡的新月","description":"sm29745635
   * \n紺碧studio：\n◆原曲:東方妖々夢/幽雅に咲かせ、墨染の桜 〜 Border of Life+ネクロファンタジア\n◆曲名:Bloomin\u2019
   * Blossom\n◆社团：紺碧Studio\n◆Vocal\nあまろ\n◆Arrangement\nアルノ\n◆Lyrics\n栃栗毛\n◆Illustration\nにわし\n◆Movie\n栃栗毛\n\n秋季例大祭上发布的新曲中的先行公开乐曲！\n\n\u2015\u2015\u2015儚き夢、一花弁舞い","create":"2016-09-30
   * 18:40","pic":"http://i1.hdslb.com/bfs/archive/2fe28a076bef2ee025a585b32ac489c56a05fd78.jpg_320x200.jpg","coins":154,"duration":"4:19","badgepay":false,"pts":10937},{"aid":6493378,"typename":"综合","title":"【不信有人会看完】为什么我听到的月歌插曲有点不一样（第三弹）","subtitle":"","play":3633,"review":1,"video_review":566,"favorites":700,"mid":3283843,"author":"捡肥皂death","description":"肥皂从9月28日开始到9月30日晚一直处于看海模式，断电、断网、禁足（划掉），直到10月1日才看到月歌的最后一话，所以晚了几天。这次十分感谢@莫倾歌Conuta
   * 授权的中文填词，这里也可以看到月歌里其他歌曲的填词http://tieba.baidu.com/p/4377215436?pn=1。\n视频中循环的音乐为月歌13话的最后一首插入歌「ツキノウタ」，黑白组一起合作，一本已足！\n2P彩弹，千万别点开！！！","create":"2016-10-02
   * 04:31","pic":"http://i1.hdslb.com/bfs/archive/babf3a9f1f702aa313f7b901219e38d193483591.png_320x200.png","coins":409,"duration":"3709","badgepay":false,"pts":10806},{"aid":6479027,"typename":"综合","title":"备战MAD-硬软件的选择及圈内风气新人误区（MAD教程第0.5期）","subtitle":"","play":2705,"review":4,"video_review":762,"favorites":747,"mid":131111,"author":"柏吃支醉","description":"自制
   * 距第0期有知有觉已经两年了啊\u2026\u2026这次学术性东西不多，看起来或觉干货不足，内容也还是杂，但完成度相较上一作还是高一些，上一作我都没想到会有那么多人看加上又赶，所以最后那版没检查就上传了Orz；而这期，做的时候没觉着，做完后连着看才发现，语速略快，可能在弹幕分心的情况下信息量有点爆炸。。。有需要自行暂停观看；精简后的教案近8万字，做成视频仍有超过两部电影的长度，还望大家有所收获；当然正片教程就不会语速那么赶内容那么长啦~
   *  下载地址：pan.baidu.com/s/1jIEwo4I","create":"2016-10-01 09:37","pic":"http://i2.hdslb.com/bfs/archive/2769260e6f1b57d4da799509e8471b9481ccbcdb.jpg_320x200.jpg","coins":805,"duration":"300:00","badgepay":false,"pts":10610},{"aid":6508654,"typename":"MMD·3D","title":"【东方MMD】因为是爱丽丝所以极乐净土","subtitle":"","play":5053,"review":1,"video_review":112,"favorites":589,"mid":149592,"author":"幻想乡的新月","description":"sm29763833
   * 虽然是极乐净土，不过是因为是490Power桑，所以就搬了\n作者490Power：DOMO~\n偶尔也想和爱丽丝亲热亲热所以制作的动作镜头\n依然是奇怪的动作镜头，所以要让身体远离屏幕观看哦~","create":"2016-10-03
   * 01:50","pic":"http://i1.hdslb.com/bfs/archive/c88bf5cf0307a0e2a2b4adb19c476a69a37b13f5.jpg_320x200.jpg","coins":104,"duration":"3:38","badgepay":false,"pts":10549},{"aid":6469720,"typename":"MAD·AMV","title":"【ED改编/AMV】未闻花名
   * 特辑 治愈系列第三弹~不一样的Secret！","subtitle":"","play":3709,"review":0,"video_review":4089,"favorites":405,"mid":36255833,"author":"EZ-Mitchell","description":"感谢叮酱在我监听下不厌其烦的录了五小时，辛苦辛苦！当时答应了一个小伙伴做花名的特辑，嗯！我没有食言！这次的风格跟原版完全不一样，而且翻唱原版的歌手那么多也不差我一个，词曲真的是好听，所以我相信改编了大家也可以接受～另外剪辑到最后又泪崩了，果然名场景不管看几次都那么感人！喜欢的小伙伴就投币收藏吧~\n\n微博：EZ_Mitchell
   * \n网易云音乐：EZ-Mitchell\n5sing音乐：EZ_Mitchell","create":"2016-09-30 16:28","pic":"http://i2.hdslb.com/bfs/archive/f87ed3d955e8ff3d0334473ea962d3702d8034d2.jpg_320x200.jpg","coins":250,"duration":"4:51","badgepay":false,"pts":10020},{"aid":6494596,"typename":"综合","title":"【补番推荐】那些被誉为神作的动画，你看过几个？","subtitle":"","play":5801,"review":0,"video_review":1174,"favorites":343,"mid":432230,"author":"雪和风","description":"自制
   * 本次为大家整理推荐的是大部分宅们所认同的神作动画中\r\n我所认同的神作，算是个人向吧\r\n都是需要一定心理承受能力观看的，最好慎重选择哦","create":"2016-10-02
   * 09:31","pic":"http://i1.hdslb.com/bfs/archive/fd80f1c2c7e6c967f235537a91fab4d89d27a5fb.jpg_320x200.jpg","coins":89,"duration":"25:05","badgepay":false,"pts":9684},{"aid":6477723,"typename":"短片·手书·配音","title":"【大角虫X月声配音社】全职高手有声漫画第三话·醉卧沙场君莫笑（国庆快乐！）","subtitle":"","play":5047,"review":0,"video_review":1022,"favorites":408,"mid":1735047,"author":"♂♂斋藤一","description":"月声配音社|
   * 交流群：29735134 | 官方微博：@大角虫_漫画 @常盘勇者@月声配音社代言小晴 @叶蓝_斋藤一\n感谢大角虫APP以及常盘勇者的大大们的授权，让我们能够参与全职高手官方漫画的有声漫画制作。\n第三期如期献上！！祝大家国庆节快乐！\n这次新加入了新美工【慕小容】！\n因为已经开始新学期了\n我们会适当调整进度时间，还请大家能够理解和见谅！\n【CAST/STAFF详细见官博/海报】","create":"2016-10-01
   * 04:02","pic":"http://i2.hdslb.com/bfs/archive/c640e65cba23308a5330daf84d772822305664d9.jpg_320x200.jpg","coins":340,"duration":"28:28","badgepay":false,"pts":9535},{"aid":6495629,"typename":"综合","title":"每月最佳作画片段\u2014\u20142016年9月","subtitle":"","play":7663,"review":1,"video_review":140,"favorites":213,"mid":11357018,"author":"AnimeTamashii","description":"详细：http://www.anitama.cn/article/888c5fd7cd9f9f36
   * BGM：Linkin Park - Faint","create":"2016-10-02 11:05","pic":"http://i1.hdslb.com/bfs/archive/79f278d0700ee34d5d249cf57a07b6b54217917b.jpg_320x200.jpg","coins":331,"duration":"3:52","badgepay":false,"pts":9165},{"aid":6481978,"typename":"MMD·3D","title":"【APHMMD】惩罚游戏【耀·耀】","subtitle":"","play":2846,"review":2,"video_review":195,"favorites":619,"mid":2308592,"author":"超威蓝猫王三水","description":"借物见视频尾\n这是给麻麻@慕少商
   * 的双耀粮！不过不是很好吃就是了x！！祝少商麻麻国庆快乐！！！！也祝大家国庆快乐x","create":"2016-10-01 13:37","pic":"http://i1.hdslb.com/bfs/archive/50f6e0c6f07c2c5415d0f4f489437c0b7838cd80.jpg_320x200.jpg","coins":133,"duration":"4:06","badgepay":false,"pts":8943},{"aid":6476170,"typename":"MMD·3D","title":"【APHMMD】自伤无色","subtitle":"","play":2329,"review":0,"video_review":222,"favorites":661,"mid":525983,"author":"慕少商","description":"重点：视频内的花是康乃馨，黄色康乃馨的花语是你让我感到失望，桃红色康乃馨是热爱着你，
   * 看视频请配合花语和歌词食用\n\n这次的耀诞在几天前就准备好了！我是不是很积极！\n这次的视频大概有红色组（虽然露熊只出现一点），双耀组（UP深爱双耀），中华组（还是老样子带着走）还有大概也许应该叫古国组。我已经不知道打什么TAG了，只打了一个双耀，其他的\u2026\u2026厄姆，你们看着打吧，但是不要吧TAG玩坏了，我会生气的。\n最后的重点就是：这真的是糖！是糖！是糖！！！说不是糖的！我们来谈人生！！！！！","create":"2016-10-01
   * 00:00","pic":"http://i0.hdslb.com/bfs/archive/8dab431e9ba7f441d39a8c15989e034320ae59a0.jpg_320x200.jpg","coins":212,"duration":"3:34","badgepay":false,"pts":8922},{"aid":6502936,"typename":"MMD·3D","title":"【髒懓、傢镞】（葬爱家族）第三分堂-超活泼小公主Miku","subtitle":"","play":2743,"review":0,"video_review":77,"favorites":634,"mid":17703106,"author":"四季音","description":"自制
   * 莪冩晥標禵、唞吥荟、哒茡了&amp;amp;amp;\u2026\u2026借物表在片尾，此次配方有参考罪城提供的方案，希望能喜欢。本次写成这样的标题是有难言之隐w","create":"2016-10-02
   * 19:12","pic":"http://i0.hdslb.com/bfs/archive/5de876798290e93a4a65be773c518b1858903cb8.jpg_320x200.jpg","coins":178,"duration":"2:09","badgepay":false,"pts":8885},{"aid":6472621,"typename":"MMD·3D","title":"【MMD】紧身黑丝皮衣加皮袜裸足加弱音姐姐黑丝加情趣乳摇来撩人啦！","subtitle":"","play":3659,"review":0,"video_review":22,"favorites":537,"mid":586521,"author":"奈瑠丶","description":"自制
   * 场景：stage3 \n✿model：by A_Nonon  TDA Leisure Holidays HAKU Ver1.00\nMME：N渲染  Diffusion7
   * 空中に漂う埃エフェクトby化身バレッタ WorkingFloor2  \n需要高清下载的私信我    场景什么的就不要吐槽了  ","create":"2016-09-30
   * 20:06","pic":"http://i0.hdslb.com/bfs/archive/2d532ff9a276fe0b178bcdea3cf3cf6792881f03.jpg_320x200.jpg","coins":44,"duration":"3:20","badgepay":false,"pts":8685},{"aid":6471966,"typename":"MMD·3D","title":"【MMD】RQ小悪魔
   * 初音 重音 亚北 镜音铃『Follow the Leader』","subtitle":"","play":"--","review":0,"video_review":46,"favorites":649,"mid":14972,"author":"炎髪夏娜","description":"https://www.youtube.com/watch?v=fIl9E_9e_iQ
   * 作者 Alex Parker","create":"2016-09-30 19:18","pic":"http://i2.hdslb.com/bfs/archive/d7a7c149824fe764228967b6b7365b8a98cb2e1b.jpg_320x200.jpg","coins":28,"duration":"4:06","badgepay":false,"pts":8324},{"aid":6487667,"typename":"MMD·3D","title":"【剑网三MMD】【明】KILLER","subtitle":"","play":4465,"review":2,"video_review":142,"favorites":359,"mid":1433861,"author":"奶油味妙脆角","description":"借物见视频，视频下载见简介的度盘","create":"2016-10-01
   * 20:05","pic":"http://i2.hdslb.com/bfs/archive/9d1e41efb92f338e5da359f75a1c8078545dd4c2.jpg_320x200.jpg","coins":238,"duration":"1:13","badgepay":false,"pts":7749},{"aid":6497150,"typename":"MMD·3D","title":"【王者荣耀MMD】庄周的Classic【私设狐狸】","subtitle":"","play":3100,"review":2,"video_review":175,"favorites":445,"mid":8093531,"author":"萤丸","description":"不接受KY，刷APH或者一期一振的全家爆炸。帶好腦子再過來，打你我還嫌費藍呢。\n原本的會聲會影炸了，這次改了後期軟件不知道視頻能不能看····審核君你看看我呀\n這套依舊不開放COS授權。服裝設定參考千年之狐\u2014李白，\n關於字幕，偶爾賣賣萌也是沒問題的對吧？\n\n借物表\nModel：切な顔P/R\nMotion：
   *   支店チョ。\nCamera：永远赤红的幼月\nMME：IKENO NILL 針金P 鯖\nStage：万年寝不足（改变）\n\n ","create":"2016-10-02
   * 12:53","pic":"http://i0.hdslb.com/bfs/archive/22230428fcc832e4cba8643b28fedac76b624ef9.jpg_320x200.jpg","coins":253,"duration":"1:52","badgepay":false,"pts":7411},{"aid":6475763,"typename":"MMD·3D","title":"【APH/MMD】COLORFUL
   * WORLD【耀诞】","subtitle":"","play":1828,"review":0,"video_review":195,"favorites":500,"mid":3794600,"author":"仓灼想要抱住爱人","description":"●王耀生日快乐！！！我爱你一辈子！！！\n\n●技艺不精，而且题目不小心写错了，没有做出想象中的效果，还请多包容。\n\n●因为已经高二了，所以更新会超级低产，抱歉。\n\n●借物见视频。●补记（敬称略）：stage：智沙都
   * /ムキムキの人/大葉真琴/山田淀子/まままやー/こちらへ tool：FaceAndLips\n\n请审核君务必检查下有没有延迟，拜托了！！QwQ辛苦了！\n","create":"2016-09-30
   * 23:31","pic":"http://i1.hdslb.com/bfs/archive/2f057090b641344d417bb28b596695a6b9eb36c5.jpg_320x200.jpg","coins":168,"duration":"11:14","badgepay":false,"pts":6834},{"aid":6491165,"typename":"MMD·3D","title":"【东方MMD】寻找捏它的红魔馆（前篇）【高能】","subtitle":"","play":4660,"review":0,"video_review":261,"favorites":225,"mid":149592,"author":"幻想乡的新月","description":"sm29553613
   * \nrhythm：真的不认为红魔馆的居民是有常识的人....当然是有好的意思也有坏的意思......\n时间太长了分成两部分了\n白玉楼残念的来客：av4299275→毒舌是师匠传授的：av4321437→为了保护幻想乡：av5375797→外表能欺骗人的家伙很坏：av5713577→地底之主很在意：av5713774→本篇→寻找捏它的红魔馆（后篇）av6491342\n第三话了\n一点点的动作练习，想着什么时候能把动作用在MMD制作呢。","create":"2016-10-01
   * 23:36","pic":"http://i2.hdslb.com/bfs/archive/5e06334ca8a540eeae16ff27cab3639dbc4b8d9e.jpg_320x200.jpg","coins":24,"duration":"10:26","badgepay":false,"pts":6694},{"aid":6480685,"typename":"MAD·AMV","title":"【一拳超人/混合系】不屈的正义与最强之男","subtitle":"","play":4990,"review":0,"video_review":69,"favorites":213,"mid":5743846,"author":"hx073269","description":"联动MAD区扛把子\u2014mu猪·恐恐：av6480882\nBGM：ONE
   * OK ROCK - The Beginning\n入坑半年了，还是发个MAD纪念下，不说所有mad做的质量如何，但是每个作品我都想表现出mad的灵魂\u2014\u2014即强烈的情感共鸣，今后我也会继续寻找mad的灵魂，喜欢我的mad话希望能关注下UP给点鼓励。\n","create":"2016-10-01
   * 11:53","pic":"http://i1.hdslb.com/bfs/archive/5dc5ec971a6c8cecf72b9aeedc6d82ea63656c4f.jpg_320x200.jpg","coins":193,"duration":"3:13","badgepay":false,"pts":6689},{"aid":6479844,"typename":"MAD·AMV","title":"【FATE/燃】今夜，战斗进入高潮！！","subtitle":"","play":4444,"review":0,"video_review":61,"favorites":248,"mid":2930093,"author":"万年の銀","description":"感觉我再纯碱下去就真的咸鱼了.........学习压力越来越重，鬼知道什么时候就停更全身心准备高考了\n最后，我是闪黑别介意...\n联动av6499459\nBGM：The
   * Glitch Mob - Our Demons\n封面：http://pan.baidu.com/s/1geQZbiV","create":"2016-10-01
   * 10:49","pic":"http://i0.hdslb.com/bfs/archive/15ea929528ea01752a7cdfaf08014c5fc70a9640.jpg_320x200.jpg","coins":81,"duration":"3:47","badgepay":false,"pts":6540},{"aid":6498360,"typename":"综合","title":"海贼王专题：全三系恶魔果实能力者","subtitle":"","play":6202,"review":1,"video_review":181,"favorites":73,"mid":27669924,"author":"外行员","description":"微信公众号：外行员
   *  微博：外行员 秒拍：外行员\n爱奇艺地址：http://www.iqiyi.com/u/2397687687\n优酷地址：http://i.youku.com/i/UMzQzNjg4ODgxNg==\n腾讯地址：http://v.qq.com/vplus/37ea7972c5642e32374b388a03b2358f\n哔哩哔哩地址：http://space.bilibili.com/27669924","create":"2016-10-02
   * 14:15","pic":"http://i0.hdslb.com/bfs/archive/221ab774bcbbe48939bfeb292953a877a47a4f76.jpg_320x200.jpg","coins":352,"duration":"9:27","badgepay":false,"pts":6488},{"aid":6505049,"typename":"MMD·3D","title":"【MMD】猫耳弱音『Sweet
   * Devil 』","subtitle":"","play":"--","review":0,"video_review":26,"favorites":529,"mid":14972,"author":"炎髪夏娜","description":"https://www.youtube.com/watch?v=PqyfgeNamGU
   *  作者 hydra dragon","create":"2016-10-02 21:20","pic":"http://i1.hdslb.com/bfs/archive/c93847cf2d31e3847e95daa9ad7cff22202338bf.jpg_320x200.jpg","coins":12,"duration":"2:46","badgepay":false,"pts":6473},{"aid":6473768,"typename":"MMD·3D","title":"【弱音MMD】Number9镜头自制","subtitle":"","play":2608,"review":0,"video_review":30,"favorites":379,"mid":1441766,"author":"疯de天使","description":"失踪人口回归一下\u2026\u2026其实这个作品的主体早在Toxic前做好了，之后忙了一阵子很久没碰MMD了嘤嘤嘤\n借物表见视频末尾，首次尝试K镜头~当时做成了是很有成就感的，虽然没有什么章法hhh\n然后抖动的镜头实在是多此一举了，抖得并不好，何况其实可以后期的呐~\n希望大家欣赏愉快~(≧▽≦)/~","create":"2016-09-30
   * 21:24","pic":"http://i0.hdslb.com/bfs/archive/097c008ad7c7e911a6df1c157d781d042b6c469e.jpg_320x200.jpg","coins":23,"duration":"3:48","badgepay":false,"pts":6167},{"aid":6493358,"typename":"短片·手书·配音","title":"【刀剑乱舞】短片集【手书】","subtitle":"","play":1858,"review":0,"video_review":79,"favorites":432,"mid":424141,"author":"Orsuan","description":"sm29751292
   * 三则短小的合集。@作者：pin","create":"2016-10-02 04:27","pic":"http://i1.hdslb.com/bfs/archive/2f70491e342a339527d7792db3766cbfeea1327c.jpg_320x200.jpg","coins":61,"duration":"1:56","badgepay":false,"pts":6070},{"aid":6483924,"typename":"MAD·AMV","title":"NO
   * Endlos NO Life  【ANIME众观线MTV第三期】","subtitle":"","play":4840,"review":0,"video_review":1012,"favorites":81,"mid":11259421,"author":"Endlos·welt","description":"(｡･∀･)ﾉﾞ嗨，我又来了，这次听取观众的意见，减少了不必要的特效，极大增强了动画的表现形式，某些方面还是初次尝试，不知道大家看了感觉怎么样，觉得可以的话希望大家多多支持投个硬币啊，点个关注啊，收藏一下啊，都是可以的哦，嘻嘻！好好欣赏吧！","create":"2016-10-01
   * 16:00","pic":"http://i0.hdslb.com/bfs/archive/990b21d8953f378f9b309015086339f852ba1898.png_320x200.png","coins":54,"duration":"212","badgepay":false,"pts":6012},{"aid":6472939,"typename":"综合","title":"【老外看动漫】东离剑游纪
   * 第十二話 现场反应-开黑板","subtitle":"","play":6117,"review":2,"video_review":120,"favorites":29,"mid":63425,"author":"夜明黔","description":"第十三話\n第十一話av6449916\n素材av6404120\n可惜Son
   * Wukong和Makenshi沒有,就先開車了\n今天是最後一集了,時間過得好快","create":"2016-09-30 20:28","pic":"http://i0.hdslb.com/bfs/archive/9f8d3968975a36ea4e2e15d9bb4e31f01de9c8b1.png_320x200.png","coins":41,"duration":"22:35","badgepay":false,"pts":5914},{"aid":6477263,"typename":"短片·手书·配音","title":"【2016国庆贺-APH手书】王耀中心DONUT
   * HOLE","subtitle":"","play":1735,"review":0,"video_review":144,"favorites":387,"mid":1977876,"author":"Seancakie","description":"历史梗含\n服装简略\n画风模仿失败，画风突变有，画质渣有\n*请勿抹黑角色\n*由于原作等的限制，可能存在表达不确切之处，请海涵~\n\n王老板生快！\n第一次做视频难免有瑕疵，压死线勉强画完了最后的ed
   * card（可能之后会改吧），回头有空写一些科普\n感谢美术和剧情顾问@Sdown太太亲自帮我修改绘制了提升整个手书画技水平那一段的草稿；\n感谢技术顾问@Gnoliyil；\n感谢内测的几位小伙伴；\n最后祝大家国庆快乐啦~希望中华组早日真正大团圆！和世界上的大家一起相亲相爱下去^_^\nCa
   * 2016.10.1\n","create":"2016-10-01 02:06","pic":"http://i1.hdslb.com/bfs/archive/d2b947ce830d1592dce801fbe916422f283f7596.jpg_320x200.jpg","coins":240,"duration":"3:30","badgepay":false,"pts":5571},{"aid":6491659,"typename":"MMD·3D","title":"【MMD剧场】CircumzenithArc【推荐】","subtitle":"","play":2762,"review":0,"video_review":38,"favorites":296,"mid":149592,"author":"幻想乡的新月","description":"sm29755527
   * \n作者さわやりどみ：\n分镜制作达成的话,也许能成为MMD原创电视剧的先导\n类型:人类电视剧\n树在日后","create":"2016-10-02
   * 00:10","pic":"http://i1.hdslb.com/bfs/archive/dff3da7bfeed80caf38398343b33668d2e0b5bc9.jpg_320x200.jpg","coins":51,"duration":"3:40","badgepay":false,"pts":5483},{"aid":6471850,"typename":"短片·手书·配音","title":"【漫配Undertale】传说之下-新宠物（中字搬运）","subtitle":"","play":2522,"review":0,"video_review":21,"favorites":310,"mid":3866155,"author":"馒馒头头兽","description":"原视频：https://youtu.be/h3vepDOgRZw
   *  原影片：https://www.youtube.com/watch?v=L_FBde0cEyM\n漫画：http://nikko-milk.tumblr.com/\n注：此视频属于youtube上的大大，单纯分享，侵删。\n","create":"2016-09-30
   * 19:08","pic":"http://i0.hdslb.com/bfs/archive/46337f6e82c7165ecdfc080cc2cf6d5ced178b39.jpg_320x200.jpg","coins":28,"duration":"0:52","badgepay":false,"pts":5390},{"aid":6470318,"typename":"综合","title":"凉风TV05-这个美术社的恋爱物语大有问题","subtitle":"","play":4483,"review":0,"video_review":242,"favorites":101,"mid":14110780,"author":"凉风有性胖次君","description":"微博@凉风有性胖次君
   * http://weibo.com/10112015\n一直想给喜欢的美术社做个视频，结局看了急死人。啊，你说标题为什么是折木？因为冰菓也很急啊！\n另外：死活没做到10分钟，拖时间我尽力了！","create":"2016-09-30
   * 17:14","pic":"http://i1.hdslb.com/bfs/archive/b4443e0bc1976de1d0e78942efdc713bb9f3deb2.jpg_320x200.jpg","coins":274,"duration":"9:49","badgepay":false,"pts":5275},{"aid":6477601,"typename":"MMD·3D","title":"【MMD】PiNK
   * CAT [LUKA公式服黑丝版]","subtitle":"","play":"--","review":0,"video_review":53,"favorites":313,"mid":3855298,"author":"ExcaliburMX","description":"自制
   * 首次尝试试制黑丝，难度不小。。 感谢各位绅士指点正确的黑丝质感。\r\n\r\n音乐：【GARNiDELiA】PiNK CAT【とく×メイリア】\r\n动作/镜头：【sm28055630】\r\n借物：TDA/WYKP/aga/hzeo/coa\r\n渲染：Diffusion7/AutoLuminous4/ikPolishShader/ikBokeh/HgSAO/HgSSAO/SvSSAO\r\n场景：ヌルテカP/Helipad_Afternoon","create":"2016-10-01
   * 03:22","pic":"http://i1.hdslb.com/bfs/archive/a4b7f18e5200edbc97e3ac928093c4d16fbfb4f5.jpg_320x200.jpg","coins":56,"duration":"3:48","badgepay":false,"pts":5234},{"aid":6501183,"typename":"综合","title":"【新番推荐】你要看的秋季番？福利和续作都太受欢迎了怎么办！","subtitle":"","play":3751,"review":1,"video_review":310,"favorites":154,"mid":216844,"author":"玩偶菌","description":"夏目和文豪终于回归
   * 迷糊餐厅新入阿库亚 杀人下巴学园Handsome究竟是部多么魔性的番？！欢迎收看大型一口气新番推荐 这回的MAD联合了四位翻译把所有台词都翻译了！希望大家能喜欢
   * 结尾独家整理各平台新番承包情况 欢迎收藏和硬币。 ","create":"2016-10-02 17:27","pic":"http://i0.hdslb.com/bfs/archive/c1ae9746b36ce8c45ac6814f387183b54286b7f8.jpg_320x200.jpg","coins":235,"duration":"18:38","badgepay":false,"pts":5207},{"aid":6487111,"typename":"短片·手书·配音","title":"【东方原创小品集】探女探女快说话
   * 作品集【第三部】","subtitle":"","play":3019,"review":2,"video_review":216,"favorites":212,"mid":1879254,"author":"帕瓦双子","description":"前作
   * 第一部av6308648 第二部av6401161 感谢@夢記子 提供的油库里配音，感谢 帕瓦双子 给予的支持。探女探女快说话/新浪微博：http://weibo.com/sagume，欢迎来投稿！","create":"2016-10-01
   * 19:32","pic":"http://i0.hdslb.com/bfs/archive/7419b087470ca570d02a94aa46c3c001eaf09254.jpg_320x200.jpg","coins":242,"duration":"7:29","badgepay":false,"pts":5044},{"aid":6470800,"typename":"综合","title":"口袋妖怪的进化过程
   *  的插图描绘择优 6P","subtitle":"","play":3022,"review":0,"video_review":214,"favorites":200,"mid":2662274,"author":"柒柒Mangan","description":"youtube
   * https://www.youtube.com/watch?v=zvKaUOZP1mM","create":"2016-09-30
   * 17:51","pic":"http://i0.hdslb.com/bfs/archive/c62be54c3862bc9ab57de9b9d2525296765acc4d.jpg_320x200.jpg","coins":17,"duration":"19:09","badgepay":false,"pts":4924},{"aid":6488984,"typename":"MMD·3D","title":"【MMD】YYB初音
   * 巡音 『classic』","subtitle":"","play":"--","review":0,"video_review":23,"favorites":332,"mid":14972,"author":"炎髪夏娜","description":"https://www.youtube.com/watch?v=nT9TdoqOLfE
   * 作者 SiBar","create":"2016-10-01 21:23","pic":"http://i2.hdslb.com/bfs/archive/d87f7dbde33a1a0f92f9da5d9e0a34cb7b73875a.jpg_320x200.jpg","coins":11,"duration":"1:54","badgepay":false,"pts":4864},{"aid":6470762,"typename":"MMD·3D","title":"【国庆贺礼】[FATE/MMD]群体石化！美杜莎的致命诱惑！","subtitle":"","play":2352,"review":0,"video_review":29,"favorites":271,"mid":3076566,"author":"AiErix","description":"首先庆贺国服FGO开服！从去年开服起一直在玩日服，国服开了也打算来看看剧情什么的，希望能一直稳定运营下去。\n视频自制，模型自改。原模型身体骨瘦如柴，动作也有点僵硬，于是所幸直接替换成了我常用的素体，感觉R姐还是性感丰满一点比较好哈233......视频内穿模破皮现象略多，还请多多谅解~\n借物：\n【模型】Drumaster\n【动作】アガちん\n【镜头】虚無ｗ\n【场景】NOB","create":"2016-09-30
   * 17:48","pic":"http://i0.hdslb.com/bfs/archive/c61d0787a216721ce83901949f8d3f21de493a47.jpg_320x200.jpg","coins":45,"duration":"3:52","badgepay":false,"pts":4855},{"aid":6473306,"typename":"MMD·3D","title":"【MMD
   * / 改模测试】樱花下的紫魅舞姬❤ 我才不告诉你们胖次是紫白条纹的呢【贺国庆】","subtitle":"","play":1534,"review":0,"video_review":19,"favorites":338,"mid":18775736,"author":"sceneryQAQ","description":"表示沉默....改了这个模型，感觉这种风格还不错~\n\n感觉画质不咋地，做的也不是很好，希望你们别吐槽\n\n借物在视频结尾，至于mmd下载就算了...反正我做的东西也没什么人喜欢看","create":"2016-09-30
   * 20:54","pic":"http://i2.hdslb.com/bfs/archive/25c919f196e4e7bf6c9d31f4a260f3182f6c1960.jpg_320x200.jpg","coins":30,"duration":"1:56","badgepay":false,"pts":4779},{"aid":6483194,"typename":"MMD·3D","title":"【MMD】幻彩九尾妖狐初音『Lupin』","subtitle":"","play":1653,"review":0,"video_review":38,"favorites":324,"mid":14972,"author":"炎髪夏娜","description":"https://www.youtube.com/watch?v=ftiymm1IOpk
   * 作者 Kuro Ynk","create":"2016-10-01 15:05","pic":"http://i1.hdslb.com/bfs/archive/f7cb79ad90c5cba2219a43d2545a5984ae6fb227.jpg_320x200.jpg","coins":10,"duration":"3:13","badgepay":false,"pts":4765},{"aid":6470009,"typename":"MMD·3D","title":"【MMD】长腿弱音的【疑心暗鬼】","subtitle":"","play":"--","review":0,"video_review":21,"favorites":355,"mid":2126449,"author":"神涯君","description":"\n\n这次是第二弹，中途遇到点情况，所以就晚点发布了。。\n高清版见评论！","create":"2016-09-30
   * 16:50","pic":"http://i0.hdslb.com/bfs/archive/10042dfafa6395261408e927f9043e78b597ff65.jpg_320x200.jpg","coins":30,"duration":"2:55","badgepay":false,"pts":4681},{"aid":6504157,"typename":"MMD·3D","title":"【MMD】时崎狂三黑丝裸足『疑心暗鬼』","subtitle":"","play":1307,"review":0,"video_review":23,"favorites":324,"mid":14972,"author":"炎髪夏娜","description":"https://www.youtube.com/watch?v=aX3vAUSB0y8
   * 作者 tpo2120","create":"2016-10-02 20:27","pic":"http://i2.hdslb.com/bfs/archive/2151d49db2afcd7e2ecabd8b4690c3e5a209dad1.jpg_320x200.jpg","coins":21,"duration":"8:27","badgepay":false,"pts":4439},{"aid":6488792,"typename":"MMD·3D","title":"【露背旗袍天依】拜托你了，今晚请陪在我身边【Hifi
   * Raver】【香肩婀娜】","subtitle":"","play":1139,"review":0,"video_review":86,"favorites":324,"mid":1523132,"author":"bysATT","description":"自制\n天依：绫，抱我\n绫：天依\u2026\u2026\n天依：嗯\u2026绫的怀里\u2026好香\u2026\u2026好温暖\u2026快要融化了、\n
   *      绫，今晚，陪我，不要走\u2026\u2026\n绫：嗯、我哪也不去，只和你在一起\n\n封面在最后\n\nMotion  \nアガちん \nCamara  \n妮谷丹
   * \nModel  \nSamsink  \n花僧逗奶君  \nBW酱  \nStage  \n怪獣対若大将P  \nDir.bysATT  ","create":"2016-10-01
   * 21:12","pic":"http://i1.hdslb.com/bfs/archive/6673dbfd7a0907a77e05513ae77f5ef511a7d1e8.jpg_320x200.jpg","coins":110,"duration":"3:54","badgepay":false,"pts":4349},{"aid":6494174,"typename":"MAD·AMV","title":"被选中的魔法少女们~~~~
   * BUTTER FLY ~~~~","subtitle":"","play":3207,"review":0,"video_review":661,"favorites":89,"mid":40092455,"author":"圆神の怒吼","description":"BGM：BUTTER
   * FLY \n歌手：和田光司\n背景动画：魔法少女伊莉雅3rei\nBGM出自动画：数码宝贝第一季主题曲","create":"2016-10-02
   * 08:40","pic":"http://i2.hdslb.com/bfs/archive/9e135cdbeb7fdffc7fd1823105054a8f7315fc3f.jpg_320x200.jpg","coins":22,"duration":"4:15","badgepay":false,"pts":4338},{"aid":6470919,"typename":"MMD·3D","title":"电子歌姬不会窒息
   * Haku Ur-Style V2（重制版）","subtitle":"","play":1218,"review":0,"video_review":30,"favorites":296,"mid":86796,"author":"沉睡の夏日","description":"av4770784之前版本的重制，调整了发光和增加手臂划开气泡的效果，其他部位就懒得去搞了，顺便换了背景\n在线高清：https://youtu.be/d-GI9s6fULs\n\nModel:COA\nMotion:黄昏好魅\nBackGround:かにひら
   * 怪獣対若大将P\nMME:ikeno そぼろ おたもん データP 針金P \nBGM:Ur-Style\nTools:Mikumikudance Adobe Premiere
   * \nDir:沉睡の夏日\n","create":"2016-09-30 18:00","pic":"http://i2.hdslb.com/bfs/archive/2518a720145fb7bbc7954c98033c64ff6abb11d3.jpg_320x200.jpg","coins":78,"duration":"3:50","badgepay":false,"pts":4085}]
   */

  private RankBean rank;


  public RankBean getRank() {

    return rank;
  }


  public void setRank(RankBean rank) {

    this.rank = rank;
  }


  public static class RankBean {

    private String note;

    private int code;

    private int pages;

    private int num;

    /**
     * aid : 6481205
     * typename : 综合
     * title : 【呜喵王ACG】52-一拳超人第二季，骨傲天剧场版
     * subtitle :
     * play : 241163
     * review : 1
     * video_review : 2219
     * favorites : 8101
     * mid : 346059
     * author : 小M呜喵王
     * description : ACG资讯类杂谈
     * create : 2016-10-01 12:35
     * pic : http://i1.hdslb.com/bfs/archive/6a2d493a6d4baaadadd4eee21ae63e1d5d8472a9.jpg_320x200.jpg
     * coins : 6113
     * duration : 11:28
     * badgepay : false
     * pts : 293794
     */

    private List<ListBean> list;


    public String getNote() {

      return note;
    }


    public void setNote(String note) {

      this.note = note;
    }


    public int getCode() {

      return code;
    }


    public void setCode(int code) {

      this.code = code;
    }


    public int getPages() {

      return pages;
    }


    public void setPages(int pages) {

      this.pages = pages;
    }


    public int getNum() {

      return num;
    }


    public void setNum(int num) {

      this.num = num;
    }


    public List<ListBean> getList() {

      return list;
    }


    public void setList(List<ListBean> list) {

      this.list = list;
    }


    public static class ListBean {

      private int aid;

      private String typename;

      private String title;

      private String subtitle;

      private String play;

      private int review;

      private int video_review;

      private int favorites;

      private int mid;

      private String author;

      private String description;

      private String create;

      private String pic;

      private int coins;

      private String duration;

      private boolean badgepay;

      private int pts;


      public int getAid() {

        return aid;
      }


      public void setAid(int aid) {

        this.aid = aid;
      }


      public String getTypename() {

        return typename;
      }


      public void setTypename(String typename) {

        this.typename = typename;
      }


      public String getTitle() {

        return title;
      }


      public void setTitle(String title) {

        this.title = title;
      }


      public String getSubtitle() {

        return subtitle;
      }


      public void setSubtitle(String subtitle) {

        this.subtitle = subtitle;
      }


      public String getPlay() {

        return play;
      }


      public void setPlay(String play) {

        this.play = play;
      }


      public int getReview() {

        return review;
      }


      public void setReview(int review) {

        this.review = review;
      }


      public int getVideo_review() {

        return video_review;
      }


      public void setVideo_review(int video_review) {

        this.video_review = video_review;
      }


      public int getFavorites() {

        return favorites;
      }


      public void setFavorites(int favorites) {

        this.favorites = favorites;
      }


      public int getMid() {

        return mid;
      }


      public void setMid(int mid) {

        this.mid = mid;
      }


      public String getAuthor() {

        return author;
      }


      public void setAuthor(String author) {

        this.author = author;
      }


      public String getDescription() {

        return description;
      }


      public void setDescription(String description) {

        this.description = description;
      }


      public String getCreate() {

        return create;
      }


      public void setCreate(String create) {

        this.create = create;
      }


      public String getPic() {

        return pic;
      }


      public void setPic(String pic) {

        this.pic = pic;
      }


      public int getCoins() {

        return coins;
      }


      public void setCoins(int coins) {

        this.coins = coins;
      }


      public String getDuration() {

        return duration;
      }


      public void setDuration(String duration) {

        this.duration = duration;
      }


      public boolean isBadgepay() {

        return badgepay;
      }


      public void setBadgepay(boolean badgepay) {

        this.badgepay = badgepay;
      }


      public int getPts() {

        return pts;
      }


      public void setPts(int pts) {

        this.pts = pts;
      }
    }
  }
}
