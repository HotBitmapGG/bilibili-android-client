package com.hotbitmapgg.ohmybilibili.entity.search;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 2016/10/24 20:11
 * 100332338@qq.com
 * <p>
 * 综合搜索模型类
 */

public class SearchArchiveInfo
{

    /**
     * code : 0
     * data : {"page":1,"nav":[{"name":"番剧","total":0,"pages":1,"type":1},{"name":"UP主","total":50,"pages":17,"type":2},{"name":"影视","total":0,"pages":1,"type":3},{"name":"专题","total":0,"pages":1,"type":4}],"items":{"season":[],"upper":[],"movie":[],"sp":[],"archive":[{"title":" 【夏一可】守望先锋：《夏家三千菜》第十期","cover":"http://i0.hdslb.com/bfs/archive/21ebde727c4ab549b1a0cf26102ad34add7aa345.jpg","uri":"bilibili://video/6796458","param":"6796458","goto":"av","play":120172,"danmaku":938,"author":"夏一可","total_count":0,"desc":"当你要惩罚一个屁股的时候，往往需要另一个屁股。","official_verify":{"type":0,"desc":""},"duration":"8:24","status":0},{"title":"[守望先锋]好莱坞的万圣后宫\u2014逗川","cover":"http://i0.hdslb.com/bfs/archive/2904317e319d260b3dfeb0b2540a148d010cc862.jpg","uri":"bilibili://video/6779287","param":"6779287","goto":"av","play":124249,"danmaku":1048,"author":"逗川kshadow","total_count":0,"desc":"自制 感谢收看 万圣节小剧场~\nBGM：尸体派对-恐るべき暗暗\n内心毫无恐怖，甚至还想笑~","official_verify":{"type":0,"desc":""},"duration":"3:45","status":0},{"title":"《守望先锋》动画短片\u2014\u2014最后的堡垒","cover":"http://i0.hdslb.com/bfs/archive/1c9960a90d8a2cd15894c9f970f80223745cce86.jpg","uri":"bilibili://video/5891295","param":"5891295","goto":"av","play":1296480,"danmaku":16871,"author":"网易暴雪游戏视频","total_count":0,"desc":"《最后的堡垒》为大家讲述的是充满好奇心的变形机器人\u201c堡垒\u201d的身世。这台战斗机器人在荒野中沉眠了十几年，之后又被意外激活。本集，我们将跟随它的脚步，一起探寻未知却又充满魅力的世界。虽然这位充满探索欲的智械渐渐迷上了周围的环境 ，但很快却发现，其核心战斗程序正指引它踏上另一条道路\u2026\u2026","official_verify":{"type":0,"desc":""},"duration":"7:2","status":0},{"title":"【种族天赋rap】千万别玩守望先锋！","cover":"http://i0.hdslb.com/bfs/archive/3dd09bd1bde6127ce441f452ee6b3e20bfc3726b.jpg","uri":"bilibili://video/5021215","param":"5021215","goto":"av","play":2841491,"danmaku":8737,"author":"小可儿","total_count":0,"desc":"自制曲！ etika小哥rap种族天赋满点！\r\n感谢@凯玟桑 的和声\r\n","official_verify":{"type":0,"desc":""},"duration":"1:9","status":0},{"title":"【老E】守望先锋！教你如何制裁外挂！","cover":"http://i0.hdslb.com/bfs/archive/4c139fa94a2b912030fa7fcbce615235601a42e6.jpg","uri":"bilibili://video/5452366","param":"5452366","goto":"av","play":1247823,"danmaku":28956,"author":"EdmundDZhang","total_count":0,"desc":"正义！\n【直播间】www.zhanqi.tv/edmunddzhang\n【微博】@老E_EdmundDZhang","official_verify":{"type":0,"desc":""},"duration":"29:54","status":0},{"title":"【MMD】欢迎来到守望先锋【LOL预告还原再现】","cover":"http://i0.hdslb.com/bfs/archive/4010e2f88189792c18fcc08d1ff8c8d2c9fd75f3.jpg","uri":"bilibili://video/6747898","param":"6747898","goto":"av","play":60448,"danmaku":254,"author":"幻想乡的新月","total_count":0,"desc":"sm29869992 \n嘛~Mahlazer的新作，依然很棒，虽然我个人是没玩守望先锋的\n前作-Miku对于有毒视频的反应：av5910085","official_verify":{"type":0,"desc":""},"duration":"2:49","status":0},{"title":"【A路人】千万别玩守望先锋！！","cover":"http://i0.hdslb.com/bfs/archive/8bb02be4c2aae89686d30788c2074c5a73d0e776.jpg","uri":"bilibili://video/5049950","param":"5049950","goto":"av","play":1896253,"danmaku":16914,"author":"A路人","total_count":0,"desc":"本家：av5021215  原作：小可儿\n你们怎么都开始玩这毁青春的游戏了？！NOOOOOOOOOOOOOOO！！","official_verify":{"type":0,"desc":""},"duration":"1:51","status":0},{"title":"守望先锋：亮剑全场最佳","cover":"http://i0.hdslb.com/bfs/archive/b4a121f317e3fa6a51648f2d84d26e09f2dd7f5a.jpg","uri":"bilibili://video/5041671","param":"5041671","goto":"av","play":2200841,"danmaku":8440,"author":"撸龙","total_count":0,"desc":"自制 最近中毒 看什么都联想屁股于是这个视频诞生咯\r\n 堡垒狂鼠死神麦爹源氏卢西奥 \r\n是的，这个世界需要更多的屁股\r\n群号:543669626 欢迎拉稀 /来吸","official_verify":{"type":0,"desc":""},"duration":"2:57","status":0},{"title":"【60帧超级燃】欢迎来到守望屁股【守望先锋高能MMD】【60fps大片向】","cover":"http://i0.hdslb.com/bfs/archive/46fe3496fd44c6a5e5cbe6c4860ff031fdb397c7.jpg","uri":"bilibili://video/6748238","param":"6748238","goto":"av","play":55984,"danmaku":163,"author":"missrin","total_count":0,"desc":"youtube 首先，先膜拜下mahlazer巨巨~然后，mahlazer巨巨这次给大家带来的是，守望先锋的高能剧情向~根据mahlazer的说明，片段有些部分仿拟了 LOL 电影预告片【Welcome to League of Legends】，想深入了解的可以去看看原版预告~源地址https://www.youtube.com/watch?v=rV_OnNBo5mo  其她合集：【舞蹈】mylist430693 【剧情】mylist636322 【舞蹈】mylist601988","official_verify":{"type":0,"desc":""},"duration":"2:49","status":0},{"title":"【守望先锋】全角色【投篮】究极教学 一局双响","cover":"http://i0.hdslb.com/bfs/archive/3ed23a7693fc530521a77f502bcfe2d956118784.jpg","uri":"bilibili://video/5861052","param":"5861052","goto":"av","play":721950,"danmaku":4305,"author":"天青树","total_count":0,"desc":"自制 只有占点图的重生点才有投篮彩蛋，一个点2个桌子可以投2次，回合结束篮球会重置位置，每个角色都有特殊的投篮♂技巧，主要根据身高区分。学会了可以一局触发2次彩蛋，没人干扰百发百中。推荐使用76，死神，麦克雷，路霸，查莉亚，和尚来投篮。初次投稿，多有不足还请多多包涵。","official_verify":{"type":0,"desc":""},"duration":"16:14","status":0},{"title":"【守望先锋】你渴望学习吗？（一只沉迷学习的小钻风）","cover":"http://i0.hdslb.com/bfs/archive/f641d124386ddaa47b628a8dc2bb0c6c9087ec2c.jpg","uri":"bilibili://video/5235961","param":"5235961","goto":"av","play":1186935,"danmaku":8531,"author":"裸奔的爱毛","total_count":0,"desc":"最近沉迷学习成了一只咸毛，所以这个视频详述了一只沉迷学习的小钻风的故事。\n花了几百个小时后最终还是把这个视频做好啦！\n关于梦想，原本想到的是能有一个自己安静听音乐的房间，里面有一流的设备。但是这太世俗了。和呆毛聊了一会后，我才想起来我真正可谓之为梦想的愿望：\n听见数万人为我欢呼的声音！（S级）","official_verify":{"type":0,"desc":""},"duration":"4:14","status":0},{"title":"【RAP】守望先锋×全明星","cover":"http://i0.hdslb.com/bfs/archive/aeb4a06f0d6b0a2e573c8eae801203dffb2531b1.jpg","uri":"bilibili://video/5020663","param":"5020663","goto":"av","play":1587691,"danmaku":6414,"author":"吃素的狮子","total_count":0,"desc":"看到短裙的新作想到了做这么个鬼畜，第一次做全程RAP的就当试水了，好想玩屁股啊。","official_verify":{"type":0,"desc":""},"duration":"2:29","status":0},{"title":"【老E】守望先锋！教你如何用死神偷人！","cover":"http://i0.hdslb.com/bfs/archive/299a0ef39b726b29e216104ea722e42448e66594.jpg","uri":"bilibili://video/5659056","param":"5659056","goto":"av","play":1134211,"danmaku":13618,"author":"EdmundDZhang","total_count":0,"desc":"500强了！这游戏可以毕业了！\n【直播间】www.zhanqi.tv/edmunddzhang\n【微博】@老E_EdmundDZhang","official_verify":{"type":0,"desc":""},"duration":"22:48","status":0},{"title":"守望先锋MV《半藏 VS 源氏 (HANZO VS GENJI)》","cover":"http://i0.hdslb.com/bfs/archive/7f4fe246e626012b229dc773bcc945fa170c057b.jpg","uri":"bilibili://video/6027751","param":"6027751","goto":"av","play":704329,"danmaku":3233,"author":"M.Scarlet","total_count":0,"desc":"优酷 搬运","official_verify":{"type":0,"desc":""},"duration":"12:2","status":0},{"title":"【守望先锋】这才是守望先锋的正确玩法","cover":"http://i0.hdslb.com/bfs/archive/9998f370277147606923a4de87ce70fbd86b82f2.jpg","uri":"bilibili://video/5841738","param":"5841738","goto":"av","play":806369,"danmaku":12394,"author":"奶茶☆","total_count":0,"desc":"【请问你虐菜开心吗？】 【废话！当然开心了！】  （分量很足 大家慢慢食用 (๑\u2022̀ㅂ\u2022́)و✧） 【新浪微博@奶茶桑_","official_verify":{"type":0,"desc":""},"duration":"49:56","status":0},{"title":"守望先锋《PUMP♀IT》","cover":"http://i0.hdslb.com/bfs/archive/fc2831ef1e98757089b95526cab9b77369187c82.jpg","uri":"bilibili://video/4814985","param":"4814985","goto":"av","play":1812575,"danmaku":7040,"author":"吃素的狮子","total_count":0,"desc":"玩屁股中毒了，做了个守望屁股的鬼畜，真是太IMBA了~！不多说了，我继续玩屁股去~关注并转发微博可以抽一份典藏版哦~","official_verify":{"type":0,"desc":""},"duration":"3:41","status":0},{"title":"在其他游戏中来玩守望先锋【2p制作视角已更新】","cover":"http://i0.hdslb.com/bfs/archive/d43c104f1f7a8be7f24b96e3056d1f40cc0e7f2a.jpg","uri":"bilibili://video/6063474","param":"6063474","goto":"av","play":745273,"danmaku":5148,"author":"梅森MonSe","total_count":0,"desc":"因为断网了，，所以就一直拖欠，拖到了现在。昨天就做好了，今天蹭中国移动营业厅的网制作完成并且上传成功的。。up要开学了，做的不好请见谅、、、、\n之前就录好了，因为一直没有网没上传，今天接老师办公室的网上传了2p。可能会有音画不同步，没时间剪了。见谅，上一次作者版权忘记录了，今天改了一下。\n视频3:40处的漫画已由LOFTER上面的作者：Dagger授权","official_verify":{"type":0,"desc":""},"duration":"5:15","status":0},{"title":"守望先锋国语配音和声优们","cover":"http://i0.hdslb.com/bfs/archive/bddddb9cc9edcd0cd1e6ddc4c9dfbaff9376066f.jpg","uri":"bilibili://video/5246794","param":"5246794","goto":"av","play":1250488,"danmaku":36803,"author":"仟水君","total_count":0,"desc":"自制 资料来自新浪微博@落枕武士猁释然   一切素材来自网络\n目前找不到源氏CV的照片，堡垒是电脑合成，请尊重每个CV请不要将CV带入角色\n大锤的CV配图配错了，原先的是翟巍老师，现在已经修改，对不起袁国庆老师QAQ\n以下是CV们的新浪微博\n@北辰是也 半藏\n@笨笨笂_彭博 源氏\n@洪海天了个咪 猎空、毛妹\n@刘茫儿 士兵76\n@贾邱 死神\n@陶典oO 天使，D.VA\n@昱头Yolanda 小美\n@孙晔Gary DJ\n@杨梦露ada 黒百合\n@张欣1970 狂鼠\n@孟祥龙福大命大造化大 温斯顿","official_verify":{"type":0,"desc":""},"duration":"11:52","status":0},{"title":"【守望先锋CG宣传片合集】","cover":"http://i0.hdslb.com/bfs/archive/4e25a931306f5fa3cb8481b58562fa418f743062.jpg","uri":"bilibili://video/4873874","param":"4873874","goto":"av","play":1653510,"danmaku":28017,"author":"Bilibili丶南北","total_count":0,"desc":"没有守望先锋玩我要死了~~~~~\n这里有最全的守望先锋cg(￣ε(#￣) Σ \n喜欢的话就点个收藏吧(｡･ω･｡)\n网盘资源：https://yun.baidu.com/s/1c2kaiiO\n","official_verify":{"type":0,"desc":""},"duration":"110:39","status":0},{"title":"【老E】守望先锋！教你如何用半藏坑队友！","cover":"http://i0.hdslb.com/bfs/archive/1630ae3b3cf12a9e747ee43f206751bf3b8a9d2b.jpg","uri":"bilibili://video/5155077","param":"5155077","goto":"av","play":1465674,"danmaku":12084,"author":"EdmundDZhang","total_count":0,"desc":"10个半藏9个坑。\n使用前【半藏！谁玩这个辣鸡英雄！】\n使用后【半藏真TMD好玩】（杀了1个，死了10次）\n【直播间】www.zhanqi.tv/edmunddzhang\n【微博】@老E_EdmundDZhang","official_verify":{"type":0,"desc":""},"duration":"26:12","status":0}]}}
     * message :
     */

    private int code;

    /**
     * page : 1
     * nav : [{"name":"番剧","total":0,"pages":1,"type":1},{"name":"UP主","total":50,"pages":17,"type":2},{"name":"影视","total":0,"pages":1,"type":3},{"name":"专题","total":0,"pages":1,"type":4}]
     * items : {"season":[],"upper":[],"movie":[],"sp":[],"archive":[{"title":" 【夏一可】守望先锋：《夏家三千菜》第十期","cover":"http://i0.hdslb.com/bfs/archive/21ebde727c4ab549b1a0cf26102ad34add7aa345.jpg","uri":"bilibili://video/6796458","param":"6796458","goto":"av","play":120172,"danmaku":938,"author":"夏一可","total_count":0,"desc":"当你要惩罚一个屁股的时候，往往需要另一个屁股。","official_verify":{"type":0,"desc":""},"duration":"8:24","status":0},{"title":"[守望先锋]好莱坞的万圣后宫\u2014逗川","cover":"http://i0.hdslb.com/bfs/archive/2904317e319d260b3dfeb0b2540a148d010cc862.jpg","uri":"bilibili://video/6779287","param":"6779287","goto":"av","play":124249,"danmaku":1048,"author":"逗川kshadow","total_count":0,"desc":"自制 感谢收看 万圣节小剧场~\nBGM：尸体派对-恐るべき暗暗\n内心毫无恐怖，甚至还想笑~","official_verify":{"type":0,"desc":""},"duration":"3:45","status":0},{"title":"《守望先锋》动画短片\u2014\u2014最后的堡垒","cover":"http://i0.hdslb.com/bfs/archive/1c9960a90d8a2cd15894c9f970f80223745cce86.jpg","uri":"bilibili://video/5891295","param":"5891295","goto":"av","play":1296480,"danmaku":16871,"author":"网易暴雪游戏视频","total_count":0,"desc":"《最后的堡垒》为大家讲述的是充满好奇心的变形机器人\u201c堡垒\u201d的身世。这台战斗机器人在荒野中沉眠了十几年，之后又被意外激活。本集，我们将跟随它的脚步，一起探寻未知却又充满魅力的世界。虽然这位充满探索欲的智械渐渐迷上了周围的环境 ，但很快却发现，其核心战斗程序正指引它踏上另一条道路\u2026\u2026","official_verify":{"type":0,"desc":""},"duration":"7:2","status":0},{"title":"【种族天赋rap】千万别玩守望先锋！","cover":"http://i0.hdslb.com/bfs/archive/3dd09bd1bde6127ce441f452ee6b3e20bfc3726b.jpg","uri":"bilibili://video/5021215","param":"5021215","goto":"av","play":2841491,"danmaku":8737,"author":"小可儿","total_count":0,"desc":"自制曲！ etika小哥rap种族天赋满点！\r\n感谢@凯玟桑 的和声\r\n","official_verify":{"type":0,"desc":""},"duration":"1:9","status":0},{"title":"【老E】守望先锋！教你如何制裁外挂！","cover":"http://i0.hdslb.com/bfs/archive/4c139fa94a2b912030fa7fcbce615235601a42e6.jpg","uri":"bilibili://video/5452366","param":"5452366","goto":"av","play":1247823,"danmaku":28956,"author":"EdmundDZhang","total_count":0,"desc":"正义！\n【直播间】www.zhanqi.tv/edmunddzhang\n【微博】@老E_EdmundDZhang","official_verify":{"type":0,"desc":""},"duration":"29:54","status":0},{"title":"【MMD】欢迎来到守望先锋【LOL预告还原再现】","cover":"http://i0.hdslb.com/bfs/archive/4010e2f88189792c18fcc08d1ff8c8d2c9fd75f3.jpg","uri":"bilibili://video/6747898","param":"6747898","goto":"av","play":60448,"danmaku":254,"author":"幻想乡的新月","total_count":0,"desc":"sm29869992 \n嘛~Mahlazer的新作，依然很棒，虽然我个人是没玩守望先锋的\n前作-Miku对于有毒视频的反应：av5910085","official_verify":{"type":0,"desc":""},"duration":"2:49","status":0},{"title":"【A路人】千万别玩守望先锋！！","cover":"http://i0.hdslb.com/bfs/archive/8bb02be4c2aae89686d30788c2074c5a73d0e776.jpg","uri":"bilibili://video/5049950","param":"5049950","goto":"av","play":1896253,"danmaku":16914,"author":"A路人","total_count":0,"desc":"本家：av5021215  原作：小可儿\n你们怎么都开始玩这毁青春的游戏了？！NOOOOOOOOOOOOOOO！！","official_verify":{"type":0,"desc":""},"duration":"1:51","status":0},{"title":"守望先锋：亮剑全场最佳","cover":"http://i0.hdslb.com/bfs/archive/b4a121f317e3fa6a51648f2d84d26e09f2dd7f5a.jpg","uri":"bilibili://video/5041671","param":"5041671","goto":"av","play":2200841,"danmaku":8440,"author":"撸龙","total_count":0,"desc":"自制 最近中毒 看什么都联想屁股于是这个视频诞生咯\r\n 堡垒狂鼠死神麦爹源氏卢西奥 \r\n是的，这个世界需要更多的屁股\r\n群号:543669626 欢迎拉稀 /来吸","official_verify":{"type":0,"desc":""},"duration":"2:57","status":0},{"title":"【60帧超级燃】欢迎来到守望屁股【守望先锋高能MMD】【60fps大片向】","cover":"http://i0.hdslb.com/bfs/archive/46fe3496fd44c6a5e5cbe6c4860ff031fdb397c7.jpg","uri":"bilibili://video/6748238","param":"6748238","goto":"av","play":55984,"danmaku":163,"author":"missrin","total_count":0,"desc":"youtube 首先，先膜拜下mahlazer巨巨~然后，mahlazer巨巨这次给大家带来的是，守望先锋的高能剧情向~根据mahlazer的说明，片段有些部分仿拟了 LOL 电影预告片【Welcome to League of Legends】，想深入了解的可以去看看原版预告~源地址https://www.youtube.com/watch?v=rV_OnNBo5mo  其她合集：【舞蹈】mylist430693 【剧情】mylist636322 【舞蹈】mylist601988","official_verify":{"type":0,"desc":""},"duration":"2:49","status":0},{"title":"【守望先锋】全角色【投篮】究极教学 一局双响","cover":"http://i0.hdslb.com/bfs/archive/3ed23a7693fc530521a77f502bcfe2d956118784.jpg","uri":"bilibili://video/5861052","param":"5861052","goto":"av","play":721950,"danmaku":4305,"author":"天青树","total_count":0,"desc":"自制 只有占点图的重生点才有投篮彩蛋，一个点2个桌子可以投2次，回合结束篮球会重置位置，每个角色都有特殊的投篮♂技巧，主要根据身高区分。学会了可以一局触发2次彩蛋，没人干扰百发百中。推荐使用76，死神，麦克雷，路霸，查莉亚，和尚来投篮。初次投稿，多有不足还请多多包涵。","official_verify":{"type":0,"desc":""},"duration":"16:14","status":0},{"title":"【守望先锋】你渴望学习吗？（一只沉迷学习的小钻风）","cover":"http://i0.hdslb.com/bfs/archive/f641d124386ddaa47b628a8dc2bb0c6c9087ec2c.jpg","uri":"bilibili://video/5235961","param":"5235961","goto":"av","play":1186935,"danmaku":8531,"author":"裸奔的爱毛","total_count":0,"desc":"最近沉迷学习成了一只咸毛，所以这个视频详述了一只沉迷学习的小钻风的故事。\n花了几百个小时后最终还是把这个视频做好啦！\n关于梦想，原本想到的是能有一个自己安静听音乐的房间，里面有一流的设备。但是这太世俗了。和呆毛聊了一会后，我才想起来我真正可谓之为梦想的愿望：\n听见数万人为我欢呼的声音！（S级）","official_verify":{"type":0,"desc":""},"duration":"4:14","status":0},{"title":"【RAP】守望先锋×全明星","cover":"http://i0.hdslb.com/bfs/archive/aeb4a06f0d6b0a2e573c8eae801203dffb2531b1.jpg","uri":"bilibili://video/5020663","param":"5020663","goto":"av","play":1587691,"danmaku":6414,"author":"吃素的狮子","total_count":0,"desc":"看到短裙的新作想到了做这么个鬼畜，第一次做全程RAP的就当试水了，好想玩屁股啊。","official_verify":{"type":0,"desc":""},"duration":"2:29","status":0},{"title":"【老E】守望先锋！教你如何用死神偷人！","cover":"http://i0.hdslb.com/bfs/archive/299a0ef39b726b29e216104ea722e42448e66594.jpg","uri":"bilibili://video/5659056","param":"5659056","goto":"av","play":1134211,"danmaku":13618,"author":"EdmundDZhang","total_count":0,"desc":"500强了！这游戏可以毕业了！\n【直播间】www.zhanqi.tv/edmunddzhang\n【微博】@老E_EdmundDZhang","official_verify":{"type":0,"desc":""},"duration":"22:48","status":0},{"title":"守望先锋MV《半藏 VS 源氏 (HANZO VS GENJI)》","cover":"http://i0.hdslb.com/bfs/archive/7f4fe246e626012b229dc773bcc945fa170c057b.jpg","uri":"bilibili://video/6027751","param":"6027751","goto":"av","play":704329,"danmaku":3233,"author":"M.Scarlet","total_count":0,"desc":"优酷 搬运","official_verify":{"type":0,"desc":""},"duration":"12:2","status":0},{"title":"【守望先锋】这才是守望先锋的正确玩法","cover":"http://i0.hdslb.com/bfs/archive/9998f370277147606923a4de87ce70fbd86b82f2.jpg","uri":"bilibili://video/5841738","param":"5841738","goto":"av","play":806369,"danmaku":12394,"author":"奶茶☆","total_count":0,"desc":"【请问你虐菜开心吗？】 【废话！当然开心了！】  （分量很足 大家慢慢食用 (๑\u2022̀ㅂ\u2022́)و✧） 【新浪微博@奶茶桑_","official_verify":{"type":0,"desc":""},"duration":"49:56","status":0},{"title":"守望先锋《PUMP♀IT》","cover":"http://i0.hdslb.com/bfs/archive/fc2831ef1e98757089b95526cab9b77369187c82.jpg","uri":"bilibili://video/4814985","param":"4814985","goto":"av","play":1812575,"danmaku":7040,"author":"吃素的狮子","total_count":0,"desc":"玩屁股中毒了，做了个守望屁股的鬼畜，真是太IMBA了~！不多说了，我继续玩屁股去~关注并转发微博可以抽一份典藏版哦~","official_verify":{"type":0,"desc":""},"duration":"3:41","status":0},{"title":"在其他游戏中来玩守望先锋【2p制作视角已更新】","cover":"http://i0.hdslb.com/bfs/archive/d43c104f1f7a8be7f24b96e3056d1f40cc0e7f2a.jpg","uri":"bilibili://video/6063474","param":"6063474","goto":"av","play":745273,"danmaku":5148,"author":"梅森MonSe","total_count":0,"desc":"因为断网了，，所以就一直拖欠，拖到了现在。昨天就做好了，今天蹭中国移动营业厅的网制作完成并且上传成功的。。up要开学了，做的不好请见谅、、、、\n之前就录好了，因为一直没有网没上传，今天接老师办公室的网上传了2p。可能会有音画不同步，没时间剪了。见谅，上一次作者版权忘记录了，今天改了一下。\n视频3:40处的漫画已由LOFTER上面的作者：Dagger授权","official_verify":{"type":0,"desc":""},"duration":"5:15","status":0},{"title":"守望先锋国语配音和声优们","cover":"http://i0.hdslb.com/bfs/archive/bddddb9cc9edcd0cd1e6ddc4c9dfbaff9376066f.jpg","uri":"bilibili://video/5246794","param":"5246794","goto":"av","play":1250488,"danmaku":36803,"author":"仟水君","total_count":0,"desc":"自制 资料来自新浪微博@落枕武士猁释然   一切素材来自网络\n目前找不到源氏CV的照片，堡垒是电脑合成，请尊重每个CV请不要将CV带入角色\n大锤的CV配图配错了，原先的是翟巍老师，现在已经修改，对不起袁国庆老师QAQ\n以下是CV们的新浪微博\n@北辰是也 半藏\n@笨笨笂_彭博 源氏\n@洪海天了个咪 猎空、毛妹\n@刘茫儿 士兵76\n@贾邱 死神\n@陶典oO 天使，D.VA\n@昱头Yolanda 小美\n@孙晔Gary DJ\n@杨梦露ada 黒百合\n@张欣1970 狂鼠\n@孟祥龙福大命大造化大 温斯顿","official_verify":{"type":0,"desc":""},"duration":"11:52","status":0},{"title":"【守望先锋CG宣传片合集】","cover":"http://i0.hdslb.com/bfs/archive/4e25a931306f5fa3cb8481b58562fa418f743062.jpg","uri":"bilibili://video/4873874","param":"4873874","goto":"av","play":1653510,"danmaku":28017,"author":"Bilibili丶南北","total_count":0,"desc":"没有守望先锋玩我要死了~~~~~\n这里有最全的守望先锋cg(￣ε(#￣) Σ \n喜欢的话就点个收藏吧(｡･ω･｡)\n网盘资源：https://yun.baidu.com/s/1c2kaiiO\n","official_verify":{"type":0,"desc":""},"duration":"110:39","status":0},{"title":"【老E】守望先锋！教你如何用半藏坑队友！","cover":"http://i0.hdslb.com/bfs/archive/1630ae3b3cf12a9e747ee43f206751bf3b8a9d2b.jpg","uri":"bilibili://video/5155077","param":"5155077","goto":"av","play":1465674,"danmaku":12084,"author":"EdmundDZhang","total_count":0,"desc":"10个半藏9个坑。\n使用前【半藏！谁玩这个辣鸡英雄！】\n使用后【半藏真TMD好玩】（杀了1个，死了10次）\n【直播间】www.zhanqi.tv/edmunddzhang\n【微博】@老E_EdmundDZhang","official_verify":{"type":0,"desc":""},"duration":"26:12","status":0}]}
     */

    private DataBean data;

    private String message;

    public int getCode()
    {

        return code;
    }

    public void setCode(int code)
    {

        this.code = code;
    }

    public DataBean getData()
    {

        return data;
    }

    public void setData(DataBean data)
    {

        this.data = data;
    }

    public String getMessage()
    {

        return message;
    }

    public void setMessage(String message)
    {

        this.message = message;
    }

    public static class DataBean
    {

        private int page;

        private ItemsBean items;

        /**
         * name : 番剧
         * total : 0
         * pages : 1
         * type : 1
         */

        private List<NavBean> nav;

        public int getPage()
        {

            return page;
        }

        public void setPage(int page)
        {

            this.page = page;
        }

        public ItemsBean getItems()
        {

            return items;
        }

        public void setItems(ItemsBean items)
        {

            this.items = items;
        }

        public List<NavBean> getNav()
        {

            return nav;
        }

        public void setNav(List<NavBean> nav)
        {

            this.nav = nav;
        }

        public static class ItemsBean implements Parcelable
        {

            /**
             * title :  【夏一可】守望先锋：《夏家三千菜》第十期
             * cover : http://i0.hdslb.com/bfs/archive/21ebde727c4ab549b1a0cf26102ad34add7aa345.jpg
             * uri : bilibili://video/6796458
             * param : 6796458
             * goto : av
             * play : 120172
             * danmaku : 938
             * author : 夏一可
             * total_count : 0
             * desc : 当你要惩罚一个屁股的时候，往往需要另一个屁股。
             * official_verify : {"type":0,"desc":""}
             * duration : 8:24
             * status : 0
             */

            private List<ArchiveBean> archive;

            public List<ArchiveBean> getArchive()
            {

                return archive;
            }

            public void setArchive(List<ArchiveBean> archive)
            {

                this.archive = archive;
            }

            public static class ArchiveBean
            {

                private String title;

                private String cover;

                private String uri;

                private String param;

                @SerializedName("goto")
                private String gotoX;

                private int play;

                private int danmaku;

                private String author;

                private int total_count;

                private String desc;

                /**
                 * type : 0
                 * desc :
                 */

                private OfficialVerifyBean official_verify;

                private String duration;

                private int status;

                public String getTitle()
                {

                    return title;
                }

                public void setTitle(String title)
                {

                    this.title = title;
                }

                public String getCover()
                {

                    return cover;
                }

                public void setCover(String cover)
                {

                    this.cover = cover;
                }

                public String getUri()
                {

                    return uri;
                }

                public void setUri(String uri)
                {

                    this.uri = uri;
                }

                public String getParam()
                {

                    return param;
                }

                public void setParam(String param)
                {

                    this.param = param;
                }

                public String getGotoX()
                {

                    return gotoX;
                }

                public void setGotoX(String gotoX)
                {

                    this.gotoX = gotoX;
                }

                public int getPlay()
                {

                    return play;
                }

                public void setPlay(int play)
                {

                    this.play = play;
                }

                public int getDanmaku()
                {

                    return danmaku;
                }

                public void setDanmaku(int danmaku)
                {

                    this.danmaku = danmaku;
                }

                public String getAuthor()
                {

                    return author;
                }

                public void setAuthor(String author)
                {

                    this.author = author;
                }

                public int getTotal_count()
                {

                    return total_count;
                }

                public void setTotal_count(int total_count)
                {

                    this.total_count = total_count;
                }

                public String getDesc()
                {

                    return desc;
                }

                public void setDesc(String desc)
                {

                    this.desc = desc;
                }

                public OfficialVerifyBean getOfficial_verify()
                {

                    return official_verify;
                }

                public void setOfficial_verify(OfficialVerifyBean official_verify)
                {

                    this.official_verify = official_verify;
                }

                public String getDuration()
                {

                    return duration;
                }

                public void setDuration(String duration)
                {

                    this.duration = duration;
                }

                public int getStatus()
                {

                    return status;
                }

                public void setStatus(int status)
                {

                    this.status = status;
                }

                public static class OfficialVerifyBean
                {

                    private int type;

                    private String desc;

                    public int getType()
                    {

                        return type;
                    }

                    public void setType(int type)
                    {

                        this.type = type;
                    }

                    public String getDesc()
                    {

                        return desc;
                    }

                    public void setDesc(String desc)
                    {

                        this.desc = desc;
                    }
                }
            }

            @Override
            public int describeContents()
            {

                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags)
            {

                dest.writeList(this.archive);
            }

            public ItemsBean()
            {

            }

            protected ItemsBean(Parcel in)
            {

                this.archive = new ArrayList<ArchiveBean>();
                in.readList(this.archive, ArchiveBean.class.getClassLoader());
            }

            public static final Parcelable.Creator<ItemsBean> CREATOR = new Parcelable.Creator<ItemsBean>()
            {

                @Override
                public ItemsBean createFromParcel(Parcel source)
                {

                    return new ItemsBean(source);
                }

                @Override
                public ItemsBean[] newArray(int size)
                {

                    return new ItemsBean[size];
                }
            };
        }

        public static class NavBean
        {

            private String name;

            private int total;

            private int pages;

            private int type;

            public String getName()
            {

                return name;
            }

            public void setName(String name)
            {

                this.name = name;
            }

            public int getTotal()
            {

                return total;
            }

            public void setTotal(int total)
            {

                this.total = total;
            }

            public int getPages()
            {

                return pages;
            }

            public void setPages(int pages)
            {

                this.pages = pages;
            }

            public int getType()
            {

                return type;
            }

            public void setType(int type)
            {

                this.type = type;
            }
        }
    }
}
