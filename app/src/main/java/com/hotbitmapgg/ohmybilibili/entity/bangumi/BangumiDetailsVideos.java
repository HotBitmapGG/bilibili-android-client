package com.hotbitmapgg.ohmybilibili.entity.bangumi;

import java.util.List;

/**
 * Created by hcc on 16/8/22 21:08
 * 100332338@qq.com
 * <p/>
 * 番剧详情视频列表数据
 */
public class BangumiDetailsVideos
{


    /**
     * count : 17
     * results : 17
     * list : [{"aid":2330598,"cid":3638258,"cover":"http://i2.hdslb.com/video/51/512fc7fce5bb04a42fe116eb5500af20.jpg","title":"「终结的炽天使」OP ED专辑","click":544988,"page":0},{"aid":2425245,"cid":3796297,"cover":"http://i0.hdslb.com/video/4c/4cf6be151a858c200e4aa5ac07c2ccd1.jpg","title":"让我们的炽天使燃起来吧Answer is near【MAD】","click":104972,"page":0},{"aid":2518947,"cid":3936915,"cover":"http://i0.hdslb.com/video/b7/b71f20c167ac0bc0af10b5908f1d098a.jpg","title":"【漫评】终结的炽天使，论把智商上交国家的正确姿势","click":535379,"page":0},{"aid":2590431,"cid":4045728,"cover":"http://i0.hdslb.com/video/4b/4ba107ac5926aac2e45973276c5b83c9.jpg","title":"【澤野弘之】「终结的炽天使」原声集专辑","click":54748,"page":0},{"aid":2410898,"cid":3772820,"cover":"http://i1.hdslb.com/video/8b/8b00552c445123cdf6d9bb7d6940ed04.jpg","title":"【终结的炽天使】X.U. (ETIA. Hardcore Bootleg Remix)","click":27711,"page":0},{"aid":2458030,"cid":4273258,"cover":"http://i1.hdslb.com/video/33/33e1a6922a2da5197f48b84f963bb75d.jpg","title":"听说大家都在看终结的炽天使，那就让我们一起来吐槽它把","click":1644766,"page":0},{"aid":3297706,"cid":5211801,"cover":"http://i0.hdslb.com/video/56/5688e15ba5fb6500fa21f67f8ce3dee9.jpg","title":"【中字】fripSide 10th single「Two souls \u2013toward the truth-」PV+C/W","click":57770,"page":0},{"aid":2182624,"cid":3420290,"cover":"http://i2.hdslb.com/video/92/924e759cd10bc99c5cd1761f12ec49ff.jpg","title":"【4月】终结的炽天使 01","click":2574060,"page":0},{"aid":2210512,"cid":3433499,"cover":"http://i2.hdslb.com/video/55/55f5d81cfa3cda63dc373f5547ddc6ab.jpg","title":"《终结的炽天使》OP/ED  TV size","click":167711,"page":0},{"aid":2414397,"cid":3779395,"cover":"http://i1.hdslb.com/video/fa/fac7fbab48817301b51436f59671ddad.jpg","title":"【完整版】「终结的炽天使」ED MV【720P】","click":37550,"page":0},{"aid":2469551,"cid":3866626,"cover":"http://i1.hdslb.com/video/c0/c073b043923d9823560ad09fae82228d.jpg","title":"【MAD】 only my railgun【终结的炽天使】","click":13315,"page":0},{"aid":2850064,"cid":4452754,"cover":"http://i1.hdslb.com/video/5d/5d11c843e0b50123d09ebcd024fe459e.jpg","title":"终结的炽天使 迷你原声集OST","click":8483,"page":0},{"aid":2939092,"cid":4599885,"cover":"http://i0.hdslb.com/video/84/84eff9d183517b5674b7fa64d4266519.jpg","title":"【10月】终结的炽天使 第2季 名古屋決戦編 PV","click":427984,"page":0},{"aid":3064022,"cid":4811085,"cover":"http://i1.hdslb.com/video/06/066bc7bdb47a5dc4951c3cdd11c5c312.jpg","title":"【Drama】「终结的炽天使」BD特典CD2","click":7146,"page":0},{"aid":3074754,"cid":4830656,"cover":"http://i2.hdslb.com/video/bd/bde2a8c356cc10452bc46bd0c2a1e2eb.jpg","title":"【10月】终结的炽天使 名古屋決戦編 OP+ED TV.Size","click":28576,"page":0},{"aid":3315076,"cid":5259625,"cover":"http://i0.hdslb.com/video/0d/0dd064782c691b10775cdb54084afebb.jpg","title":"【中字】【fripSide】「Two souls \u2013toward the truth-」【PV+Making+SPOT】","click":61099,"page":0},{"aid":3398012,"cid":5384144,"cover":"http://i2.hdslb.com/video/87/87a3ea75e9e0f0d5ae4cf7b5f196baf6.jpg","title":"终结的炽天使 第二季特典01【F宅】","click":86056,"page":0}]
     */

    private int count;

    private int results;

    /**
     * aid : 2330598
     * cid : 3638258
     * cover : http://i2.hdslb.com/video/51/512fc7fce5bb04a42fe116eb5500af20.jpg
     * title : 「终结的炽天使」OP ED专辑
     * click : 544988
     * page : 0
     */

    private List<ListBean> list;

    public int getCount()
    {

        return count;
    }

    public void setCount(int count)
    {

        this.count = count;
    }

    public int getResults()
    {

        return results;
    }

    public void setResults(int results)
    {

        this.results = results;
    }

    public List<ListBean> getList()
    {

        return list;
    }

    public void setList(List<ListBean> list)
    {

        this.list = list;
    }

    public static class ListBean
    {

        private int aid;

        private int cid;

        private String cover;

        private String title;

        private int click;

        private int page;

        public int getAid()
        {

            return aid;
        }

        public void setAid(int aid)
        {

            this.aid = aid;
        }

        public int getCid()
        {

            return cid;
        }

        public void setCid(int cid)
        {

            this.cid = cid;
        }

        public String getCover()
        {

            return cover;
        }

        public void setCover(String cover)
        {

            this.cover = cover;
        }

        public String getTitle()
        {

            return title;
        }

        public void setTitle(String title)
        {

            this.title = title;
        }

        public int getClick()
        {

            return click;
        }

        public void setClick(int click)
        {

            this.click = click;
        }

        public int getPage()
        {

            return page;
        }

        public void setPage(int page)
        {

            this.page = page;
        }
    }
}
