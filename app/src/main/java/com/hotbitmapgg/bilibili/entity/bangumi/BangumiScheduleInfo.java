package com.hotbitmapgg.bilibili.entity.bangumi;

import java.util.List;

/**
 * Created by hcc on 2016/10/11 10:48
 * 100332338@qq.com
 * <p>
 * 番剧放送表模型类
 */

public class BangumiScheduleInfo {

  /**
   * code : 0
   * message : success
   * result : [{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/4588937c1f0118af6cec14f55eca43bf1141f328.jpg","date":1477756800,"delay":0,"ep_id":96600,"ep_index":"5","follow":0,"is_published":1,"ontime":"00:00","pub_date":"2016-10-30","season_id":5507,"season_status":2,"title":"WWW.迷糊餐厅"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/5d1364ae198c6e29c2daa64e48ad539fe5094496.jpg","date":1477756800,"delay":0,"ep_id":96480,"ep_index":"4","follow":0,"is_published":1,"ontime":"00:30","pub_date":"2016-10-30","season_id":5526,"season_status":2,"title":"超自然9人组"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/7bfd5b9a4aabee8df09df12939d2f32c2f41a0d7.jpg","date":1477756800,"delay":0,"ep_id":96668,"ep_index":"4","follow":0,"is_published":1,"ontime":"00:30","pub_date":"2016-10-30","season_id":5523,"season_status":2,"title":"3月的狮子"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/b1ca6d66fd00f16f13055f6de06b05f5bd9f22c2.jpg","date":1477756800,"delay":0,"ep_id":96444,"ep_index":"4","follow":0,"is_published":1,"ontime":"00:57","pub_date":"2016-10-30","season_id":5527,"season_status":2,"title":"战国鸟兽戏画"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/927fc75f3f044d4115392ffdad8fbcce9dbe2f95.jpg","date":1477756800,"delay":0,"ep_id":96144,"ep_index":"5","follow":0,"is_published":1,"ontime":"01:00","pub_date":"2016-10-30","season_id":5506,"season_status":2,"title":"魔法少女育成计划"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/0549ae837ee1ceed546f518d1452d4b797735a52.jpg","date":1477756800,"delay":0,"ep_id":96157,"ep_index":"5","follow":0,"is_published":1,"ontime":"02:00","pub_date":"2016-10-30","season_id":5514,"season_status":2,"title":"ViVid
   * Strike!"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/20f05ecc4c50d560814e511ced4205f37e640501.jpg","date":1477756800,"delay":0,"ep_id":91024,"ep_index":"17","follow":0,"is_published":1,"ontime":"02:58","pub_date":"2016-10-30","season_id":5063,"season_status":2,"title":"DAYS"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/3c3f4544bb6f8175d24c6022a23fc9bd4bc4ce59.jpg","date":1477756800,"delay":0,"ep_id":96492,"ep_index":"4","follow":0,"is_published":1,"ontime":"03:30","pub_date":"2016-10-30","season_id":5525,"season_status":2,"title":"乌冬面之国的金色毛球"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/e4eaa21feb4449abe887ca50618638e953d05413.jpg","date":1477756800,"delay":0,"ep_id":96505,"ep_index":"5","follow":0,"is_published":1,"ontime":"12:00","pub_date":"2016-10-30","season_id":5563,"season_status":2,"title":"甜甜私房猫
   * 第三季"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/4ed80d634a035e1e5420f474300f8fa6b9870b20.jpg","date":1477756800,"delay":0,"ep_id":96612,"ep_index":"5","follow":0,"is_published":1,"ontime":"22:30","pub_date":"2016-10-30","season_id":5522,"season_status":2,"title":"超心动！艺术之星"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/c07c737bdf538db56509e9008bb3f90738c7dce8.jpg","date":1477756800,"delay":0,"ep_id":96182,"ep_index":"5","follow":0,"is_published":1,"ontime":"23:30","pub_date":"2016-10-30","season_id":5564,"season_status":2,"title":"雨色可可
   * in Hawaii"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/8f67ccb853ce59adbe233da59ff6cd644a05d453.jpg","date":1477843200,"delay":0,"ep_id":96194,"ep_index":"5","follow":0,"is_published":1,"ontime":"00:00","pub_date":"2016-10-31","season_id":5515,"season_status":2,"title":"刀剑乱舞-花丸-"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/6618b149eefa875982d86827b0abc4b2d3b1726a.jpg","date":1477843200,"delay":0,"ep_id":96169,"ep_index":"5","follow":0,"is_published":1,"ontime":"00:15","pub_date":"2016-10-31","season_id":5520,"season_status":2,"title":"SHOW
   * BY ROCK!! 第二季"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/d1d6774866c5bb897a2edb6f3fe7de0fc8bc5e8f.jpg","date":1477843200,"delay":0,"ep_id":96206,"ep_index":"5","follow":0,"is_published":1,"ontime":"00:30","pub_date":"2016-10-31","season_id":5486,"season_status":2,"title":"星梦手记"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/01c5841d99185a6778ab1cfd44e2bccc3d6eca42.jpg","date":1477843200,"delay":0,"ep_id":96624,"ep_index":"5","follow":0,"is_published":1,"ontime":"00:30","pub_date":"2016-10-31","season_id":5524,"season_status":2,"title":"我老婆是学生会长
   * 第二季"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/7449bdd3c8067fec587a0cf2a8f7f1f5275b757f.jpg","date":1477843200,"delay":0,"ep_id":95967,"ep_index":"17","follow":0,"is_published":1,"ontime":"01:35","pub_date":"2016-10-31","season_id":5069,"season_status":2,"title":"齐木楠雄的灾难"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/dcbf3c193f4f8c0433d8dee2ee02580de15948b6.jpg","date":1477843200,"delay":0,"ep_id":96218,"ep_index":"5","follow":0,"is_published":1,"ontime":"02:05","pub_date":"2016-10-31","season_id":5538,"season_status":2,"title":"青鬼"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/eb4f17335f48951945fb9da47e6ee0bc65fa2fbb.jpg","date":1477843200,"delay":0,"ep_id":97070,"ep_index":"86","follow":0,"is_published":1,"ontime":"08:00","pub_date":"2016-10-31","season_id":5070,"season_status":2,"title":"齐木楠雄的灾难（日播版）"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/e7f7e5b07441da16e382ea4563f82f63f8632626.jpg","date":1477843200,"delay":0,"ep_id":91072,"ep_index":"18","follow":0,"is_published":1,"ontime":"18:25","pub_date":"2016-10-31","season_id":5025,"season_status":2,"title":"智龙迷城X"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/c2d312d73a8a237a523146b5423d3fc01689d237.jpg","date":1477843200,"delay":0,"ep_id":96230,"ep_index":"17","follow":0,"is_published":1,"ontime":"18:30","pub_date":"2016-10-31","season_id":5544,"season_status":2,"title":"12岁。第二季"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/f907574470e1edf0bf5a89054a6026c4533c7d92.jpg","date":1477843200,"delay":0,"ep_id":96051,"ep_index":"44","follow":0,"is_published":1,"ontime":"19:00","pub_date":"2016-10-31","season_id":5545,"season_status":2,"title":"怪盗Joker
   * 第四季"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/a7d604cb9024faeb775a79a95c33542e3cdd420c.jpg","date":1477843200,"delay":0,"ep_id":96242,"ep_index":"5","follow":0,"is_published":1,"ontime":"22:30","pub_date":"2016-10-31","season_id":5540,"season_status":2,"title":"斯特拉的魔法"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/c74ba43e76c346476c8c09e653d35de69073cc49.jpg","date":1477929600,"delay":0,"ep_id":96265,"ep_index":"5","follow":0,"is_published":1,"ontime":"00:00","pub_date":"2016-11-01","season_id":5543,"season_status":2,"title":"学园Handsome"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/3501378364ff84cbb42d2ee946334cd3b2dec453.jpg","date":1477929600,"delay":0,"ep_id":96457,"ep_index":"5","follow":0,"is_published":1,"ontime":"01:05","pub_date":"2016-11-01","season_id":5542,"season_status":2,"title":"TRICKSTER"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/82709ec1fb027631b1f939c9dfcc2d850ffa12a2.jpg","date":1477929600,"delay":0,"ep_id":96277,"ep_index":"5","follow":0,"is_published":1,"ontime":"01:35","pub_date":"2016-11-01","season_id":5539,"season_status":2,"title":"灼热乒乓妹"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/9925ece99e3458760fc074e8564f74a1d6f46e1d.jpg","date":1477929600,"delay":0,"ep_id":96119,"ep_index":"6","follow":0,"is_published":1,"ontime":"06:45","pub_date":"2016-11-01","season_id":5504,"season_status":2,"title":"喵阿楞"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/eb4f17335f48951945fb9da47e6ee0bc65fa2fbb.jpg","date":1477929600,"delay":0,"ep_id":97071,"ep_index":"87","follow":0,"is_published":1,"ontime":"08:00","pub_date":"2016-11-01","season_id":5070,"season_status":2,"title":"齐木楠雄的灾难（日播版）"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/a161fc71b37116889eced3ad79733d07d47acc65.jpg","date":1477929600,"delay":0,"ep_id":89031,"ep_index":"31","follow":0,"is_published":0,"ontime":"17:55","pub_date":"2016-11-01","season_id":3532,"season_status":2,"title":"美妙天堂
   *  第三季"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/acf304f06f3503ed4d829411f2b39db6c59e7b05.jpg","date":1477929600,"delay":0,"ep_id":90045,"ep_index":"21","follow":0,"is_published":0,"ontime":"20:00","pub_date":"2016-11-01","season_id":4771,"season_status":2,"title":"少年阿贝
   * GO!GO!小芝麻"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/6b4a565e9c06fa7368f97254bfe5ad2db61cf9d1.jpg","date":1477929600,"delay":0,"ep_id":96289,"ep_index":"5","follow":0,"is_published":0,"ontime":"21:55","pub_date":"2016-11-01","season_id":5549,"season_status":2,"title":"信长的忍者"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/7f5889f75d29435ab09c78de97fa52c776bf4fe0.jpg","date":1477929600,"delay":0,"ep_id":96301,"ep_index":"5","follow":0,"is_published":0,"ontime":"23:30","pub_date":"2016-11-01","season_id":5552,"season_status":2,"title":"神装少女小缠"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/2673ac643b48eb5bda64c960a2ca850fbebb839d.jpg","date":1478016000,"delay":0,"ep_id":96039,"ep_index":"5","follow":0,"is_published":0,"ontime":"03:00","pub_date":"2016-11-02","season_id":5550,"season_status":2,"title":"夏目友人帐
   * 伍"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/2ed6be9050dfa4afe6e2651741d81843a0e81c67.jpg","date":1478016000,"delay":0,"ep_id":96313,"ep_index":"5","follow":0,"is_published":0,"ontime":"03:30","pub_date":"2016-11-02","season_id":5548,"season_status":2,"title":"黑白来看守所"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/eb4f17335f48951945fb9da47e6ee0bc65fa2fbb.jpg","date":1478016000,"delay":0,"ep_id":97072,"ep_index":"88","follow":0,"is_published":0,"ontime":"08:00","pub_date":"2016-11-02","season_id":5070,"season_status":2,"title":"齐木楠雄的灾难（日播版）"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/4d06e660b8da9cb5335552f4ebde89bbcb2e9d4f.jpg","date":1478016000,"delay":0,"ep_id":89086,"ep_index":"30","follow":0,"is_published":0,"ontime":"18:25","pub_date":"2016-11-02","season_id":3462,"season_status":2,"title":"双星之阴阳师"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/eecc67dc1f1c1fecbb299ae2c450f337dcf0fcdb.jpg","date":1478016000,"delay":0,"ep_id":96337,"ep_index":"5","follow":0,"is_published":0,"ontime":"21:30","pub_date":"2016-11-02","season_id":5561,"season_status":2,"title":"网球并不可笑嘛
   * 第八季"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/15c587a046c6fa135410a978d00be87972c4cf66.jpg","date":1478016000,"delay":0,"ep_id":96636,"ep_index":"5","follow":0,"is_published":0,"ontime":"21:33","pub_date":"2016-11-02","season_id":5556,"season_status":2,"title":"奇异太郎少年的妖怪绘日记"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/4c271a028729d576a4f7e71eb1baf9145c9c39b6.jpg","date":1478016000,"delay":0,"ep_id":96349,"ep_index":"5","follow":0,"is_published":0,"ontime":"21:38","pub_date":"2016-11-02","season_id":5560,"season_status":2,"title":"魔法少女什么的已经够了啦。第二季"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/32b173fbb55ca90b39eb68d94492eed725d0c61e.jpg","date":1478016000,"delay":0,"ep_id":96361,"ep_index":"5","follow":0,"is_published":0,"ontime":"21:55","pub_date":"2016-11-02","season_id":5558,"season_status":2,"title":"动画锻炼！XX
   * 同一屋檐下"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/6814d147a842deb2e69bcd9d2cd59067e55fb347.jpg","date":1478016000,"delay":0,"ep_id":96325,"ep_index":"5","follow":0,"is_published":0,"ontime":"23:15","pub_date":"2016-11-02","season_id":5555,"season_status":2,"title":"Crane
   * Game Girls 第二季"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/468aadca9251f06013256719934e5cd5689a44d9.jpg","date":1478016000,"delay":0,"ep_id":96522,"ep_index":"5","follow":0,"is_published":0,"ontime":"23:28","pub_date":"2016-11-02","season_id":5557,"season_status":2,"title":"解谜之音"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/18a9dc72417d9c25717f7bdc7e8f1577557f2b96.jpg","date":1478102400,"delay":0,"ep_id":96707,"ep_index":"5","follow":0,"is_published":0,"ontime":"00:00","pub_date":"2016-11-03","season_id":5551,"season_status":2,"title":"吹響吧！上低音號
   * 第二季（僅限台灣地區）"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/375067c6f49a706855595a32f4bd9f007bb60e7b.jpg","date":1478102400,"delay":0,"ep_id":96372,"ep_index":"4","follow":0,"is_published":0,"ontime":"02:05","pub_date":"2016-11-03","season_id":5562,"season_status":2,"title":"无畏魔女"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/eb4f17335f48951945fb9da47e6ee0bc65fa2fbb.jpg","date":1478102400,"delay":0,"ep_id":97073,"ep_index":"89","follow":0,"is_published":0,"ontime":"08:00","pub_date":"2016-11-03","season_id":5070,"season_status":2,"title":"齐木楠雄的灾难（日播版）"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/212345f11472cd39d6209652ca926f2249fdff36.jpg","date":1478102400,"delay":0,"ep_id":90175,"ep_index":"702","follow":0,"is_published":0,"ontime":"19:30","pub_date":"2016-11-03","season_id":3287,"season_status":2,"title":"火影忍者
   * 疾风传"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/e9cdf37e3d724a970baf73d47648d8f061f63e06.jpg","date":1478188800,"delay":0,"ep_id":96469,"ep_index":"5","follow":0,"is_published":0,"ontime":"00:00","pub_date":"2016-11-04","season_id":5537,"season_status":2,"title":"伯纳德小姐说。"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/eb4f17335f48951945fb9da47e6ee0bc65fa2fbb.jpg","date":1478188800,"delay":0,"ep_id":97074,"ep_index":"90","follow":0,"is_published":0,"ontime":"08:00","pub_date":"2016-11-04","season_id":5070,"season_status":2,"title":"齐木楠雄的灾难（日播版）"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/b3633d2e5cafa0d048f4beef63618c92cfac4c4c.jpg","date":1478188800,"delay":0,"ep_id":96385,"ep_index":"5","follow":0,"is_published":0,"ontime":"12:00","pub_date":"2016-11-04","season_id":5534,"season_status":2,"title":"我太受欢迎了该怎么办"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/783bcdb50d9702b23e3aef2e6a5bbd0508465a87.jpg","date":1478188800,"delay":0,"ep_id":96397,"ep_index":"5","follow":0,"is_published":0,"ontime":"12:00","pub_date":"2016-11-04","season_id":5532,"season_status":2,"title":"少女编号"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/827bded62f4932174ba33e044492464ad80dd2fe.jpg","date":1478188800,"delay":0,"ep_id":96106,"ep_index":"6","follow":0,"is_published":0,"ontime":"21:00","pub_date":"2016-11-04","season_id":5512,"season_status":2,"title":"梦之祭"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/83ed2a4ef9be7ad4fda5957c77ed0d86a7e39707.jpg","date":1478275200,"delay":0,"ep_id":96409,"ep_index":"5","follow":0,"is_published":0,"ontime":"00:35","pub_date":"2016-11-05","season_id":5530,"season_status":2,"title":"Lostorage
   * incited WIXOSS"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/fad5803cfd9cf02be68cbc38eaa6948a15e9b862.jpg","date":1478275200,"delay":0,"ep_id":96065,"ep_index":"6","follow":0,"is_published":0,"ontime":"19:00","pub_date":"2016-11-05","season_id":5510,"season_status":2,"title":"时间飞船24"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/4299d1751b85a7fc14cedb2c1ffc4f2ef2b9af60.jpg","date":1478275200,"delay":0,"ep_id":96421,"ep_index":"5","follow":0,"is_published":0,"ontime":"19:00","pub_date":"2016-11-05","season_id":5521,"season_status":2,"title":"Classica
   * Loid"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/e0ee2b7700f3eef6a66aa29c98e8db59189d1ff8.jpg","date":1478275200,"delay":0,"ep_id":96433,"ep_index":"4","follow":0,"is_published":0,"ontime":"21:30","pub_date":"2016-11-05","season_id":5518,"season_status":2,"title":"长骑美眉"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/dd07bc96db8e03256b46feec89b6f69b2c3034f6.jpg","date":1478275200,"delay":0,"ep_id":96132,"ep_index":"6","follow":0,"is_published":0,"ontime":"22:00","pub_date":"2016-11-05","season_id":5508,"season_status":2,"title":"舞武器舞乱伎
   * 星之巨人"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/27b426240a5cef004b98ba9825cc1dced1f3e8ea.jpg","date":1478275200,"delay":0,"ep_id":96589,"ep_index":"6","follow":0,"is_published":0,"ontime":"23:00","pub_date":"2016-11-05","season_id":5513,"season_status":2,"title":"终末的伊泽塔"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/4588937c1f0118af6cec14f55eca43bf1141f328.jpg","date":1478361600,"delay":0,"ep_id":96601,"ep_index":"6","follow":0,"is_published":0,"ontime":"00:00","pub_date":"2016-11-06","season_id":5507,"season_status":2,"title":"WWW.迷糊餐厅"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/5d1364ae198c6e29c2daa64e48ad539fe5094496.jpg","date":1478361600,"delay":0,"ep_id":96481,"ep_index":"5","follow":0,"is_published":0,"ontime":"00:30","pub_date":"2016-11-06","season_id":5526,"season_status":2,"title":"超自然9人组"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/7bfd5b9a4aabee8df09df12939d2f32c2f41a0d7.jpg","date":1478361600,"delay":0,"ep_id":96669,"ep_index":"5","follow":0,"is_published":0,"ontime":"00:30","pub_date":"2016-11-06","season_id":5523,"season_status":2,"title":"3月的狮子"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/b1ca6d66fd00f16f13055f6de06b05f5bd9f22c2.jpg","date":1478361600,"delay":0,"ep_id":96445,"ep_index":"5","follow":0,"is_published":0,"ontime":"00:42","pub_date":"2016-11-06","season_id":5527,"season_status":2,"title":"战国鸟兽戏画"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/927fc75f3f044d4115392ffdad8fbcce9dbe2f95.jpg","date":1478361600,"delay":0,"ep_id":96145,"ep_index":"6","follow":0,"is_published":0,"ontime":"01:00","pub_date":"2016-11-06","season_id":5506,"season_status":2,"title":"魔法少女育成计划"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/0549ae837ee1ceed546f518d1452d4b797735a52.jpg","date":1478361600,"delay":0,"ep_id":96158,"ep_index":"6","follow":0,"is_published":0,"ontime":"02:00","pub_date":"2016-11-06","season_id":5514,"season_status":2,"title":"ViVid
   * Strike!"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/20f05ecc4c50d560814e511ced4205f37e640501.jpg","date":1478361600,"delay":0,"ep_id":91025,"ep_index":"18","follow":0,"is_published":0,"ontime":"02:58","pub_date":"2016-11-06","season_id":5063,"season_status":2,"title":"DAYS"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/3c3f4544bb6f8175d24c6022a23fc9bd4bc4ce59.jpg","date":1478361600,"delay":0,"ep_id":96493,"ep_index":"5","follow":0,"is_published":0,"ontime":"03:30","pub_date":"2016-11-06","season_id":5525,"season_status":2,"title":"乌冬面之国的金色毛球"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/e4eaa21feb4449abe887ca50618638e953d05413.jpg","date":1478361600,"delay":0,"ep_id":96506,"ep_index":"6","follow":0,"is_published":0,"ontime":"12:00","pub_date":"2016-11-06","season_id":5563,"season_status":2,"title":"甜甜私房猫
   * 第三季"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/4ed80d634a035e1e5420f474300f8fa6b9870b20.jpg","date":1478361600,"delay":0,"ep_id":96613,"ep_index":"6","follow":0,"is_published":0,"ontime":"22:30","pub_date":"2016-11-06","season_id":5522,"season_status":2,"title":"超心动！艺术之星"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/c07c737bdf538db56509e9008bb3f90738c7dce8.jpg","date":1478361600,"delay":0,"ep_id":96183,"ep_index":"6","follow":0,"is_published":0,"ontime":"23:30","pub_date":"2016-11-06","season_id":5564,"season_status":2,"title":"雨色可可
   * in Hawaii"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/8f67ccb853ce59adbe233da59ff6cd644a05d453.jpg","date":1478448000,"delay":0,"ep_id":96195,"ep_index":"6","follow":0,"is_published":0,"ontime":"00:00","pub_date":"2016-11-07","season_id":5515,"season_status":2,"title":"刀剑乱舞-花丸-"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/6618b149eefa875982d86827b0abc4b2d3b1726a.jpg","date":1478448000,"delay":0,"ep_id":96170,"ep_index":"6","follow":0,"is_published":0,"ontime":"00:15","pub_date":"2016-11-07","season_id":5520,"season_status":2,"title":"SHOW
   * BY ROCK!! 第二季"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/d1d6774866c5bb897a2edb6f3fe7de0fc8bc5e8f.jpg","date":1478448000,"delay":0,"ep_id":96207,"ep_index":"6","follow":0,"is_published":0,"ontime":"00:30","pub_date":"2016-11-07","season_id":5486,"season_status":2,"title":"星梦手记"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/01c5841d99185a6778ab1cfd44e2bccc3d6eca42.jpg","date":1478448000,"delay":0,"ep_id":96625,"ep_index":"6","follow":0,"is_published":0,"ontime":"00:30","pub_date":"2016-11-07","season_id":5524,"season_status":2,"title":"我老婆是学生会长
   * 第二季"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/7449bdd3c8067fec587a0cf2a8f7f1f5275b757f.jpg","date":1478448000,"delay":0,"ep_id":95968,"ep_index":"18","follow":0,"is_published":0,"ontime":"01:35","pub_date":"2016-11-07","season_id":5069,"season_status":2,"title":"齐木楠雄的灾难"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/dcbf3c193f4f8c0433d8dee2ee02580de15948b6.jpg","date":1478448000,"delay":0,"ep_id":96219,"ep_index":"6","follow":0,"is_published":0,"ontime":"03:05","pub_date":"2016-11-07","season_id":5538,"season_status":2,"title":"青鬼"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/e7f7e5b07441da16e382ea4563f82f63f8632626.jpg","date":1478448000,"delay":0,"ep_id":91073,"ep_index":"19","follow":0,"is_published":0,"ontime":"18:25","pub_date":"2016-11-07","season_id":5025,"season_status":2,"title":"智龙迷城X"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/c2d312d73a8a237a523146b5423d3fc01689d237.jpg","date":1478448000,"delay":0,"ep_id":96231,"ep_index":"18","follow":0,"is_published":0,"ontime":"18:30","pub_date":"2016-11-07","season_id":5544,"season_status":2,"title":"12岁。第二季"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/f907574470e1edf0bf5a89054a6026c4533c7d92.jpg","date":1478448000,"delay":0,"ep_id":96052,"ep_index":"45","follow":0,"is_published":0,"ontime":"19:00","pub_date":"2016-11-07","season_id":5545,"season_status":2,"title":"怪盗Joker
   * 第四季"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/a7d604cb9024faeb775a79a95c33542e3cdd420c.jpg","date":1478448000,"delay":0,"ep_id":96243,"ep_index":"6","follow":0,"is_published":0,"ontime":"22:30","pub_date":"2016-11-07","season_id":5540,"season_status":2,"title":"斯特拉的魔法"}]
   */

  private int code;

  private String message;

  /**
   * area_id : 2
   * cover : http://i0.hdslb.com/bfs/bangumi/4588937c1f0118af6cec14f55eca43bf1141f328.jpg
   * date : 1477756800
   * delay : 0
   * ep_id : 96600
   * ep_index : 5
   * follow : 0
   * is_published : 1
   * ontime : 00:00
   * pub_date : 2016-10-30
   * season_id : 5507
   * season_status : 2
   * title : WWW.迷糊餐厅
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

    private int area_id;

    private String cover;

    private int date;

    private int delay;

    private int ep_id;

    private String ep_index;

    private int follow;

    private int is_published;

    private String ontime;

    private String pub_date;

    private int season_id;

    private int season_status;

    private String title;


    public int getArea_id() {

      return area_id;
    }


    public void setArea_id(int area_id) {

      this.area_id = area_id;
    }


    public String getCover() {

      return cover;
    }


    public void setCover(String cover) {

      this.cover = cover;
    }


    public int getDate() {

      return date;
    }


    public void setDate(int date) {

      this.date = date;
    }


    public int getDelay() {

      return delay;
    }


    public void setDelay(int delay) {

      this.delay = delay;
    }


    public int getEp_id() {

      return ep_id;
    }


    public void setEp_id(int ep_id) {

      this.ep_id = ep_id;
    }


    public String getEp_index() {

      return ep_index;
    }


    public void setEp_index(String ep_index) {

      this.ep_index = ep_index;
    }


    public int getFollow() {

      return follow;
    }


    public void setFollow(int follow) {

      this.follow = follow;
    }


    public int getIs_published() {

      return is_published;
    }


    public void setIs_published(int is_published) {

      this.is_published = is_published;
    }


    public String getOntime() {

      return ontime;
    }


    public void setOntime(String ontime) {

      this.ontime = ontime;
    }


    public String getPub_date() {

      return pub_date;
    }


    public void setPub_date(String pub_date) {

      this.pub_date = pub_date;
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
  }
}
