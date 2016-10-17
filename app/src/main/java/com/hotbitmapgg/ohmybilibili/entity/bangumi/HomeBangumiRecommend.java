package com.hotbitmapgg.ohmybilibili.entity.bangumi;

import java.util.List;

/**
 * Created by hcc on 16/8/6 11:08
 * 100332338@qq.com
 * <p/>
 * 首页番剧数据
 */
public class HomeBangumiRecommend
{

    /**
     * code : 0
     * message : success
     * result : {"banners":[{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/17f4538384d75d9748d0d1f2e71cbb8d226a2b71.jpg","is_ad":0,"link":"http://bangumi.bilibili.com/anime/5540","title":"斯特拉的魔法"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/08235ce5c340b15e19cb397299d199cb0838a2d3.jpg","is_ad":0,"link":"http://bangumi.bilibili.com/anime/5486","title":"星梦手记"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/0433e3d1de0707475ae29d914cb0549e51b64029.jpg","is_ad":0,"link":"http://bangumi.bilibili.com/anime/3253","title":"十万个冷笑话"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/6ceb529d6788814ac8f6db819f2a2e32d275dc4e.jpg","is_ad":0,"link":"http://bangumi.bilibili.com/anime/5301","title":"墓王之王"}],"ends":[{"cover":"http://i0.hdslb.com/bfs/bangumi/23ffac3faaadddedbb8ef47b84329946d306174f.jpg","last_time":"1450892161","newest_ep_id":"81949","newest_ep_index":"12","season_id":"2724","title":"对魔导学园35试验小队","total_count":"12","watchingCount":"0"},{"cover":"http://i0.hdslb.com/bfs/bangumi/1cc08a1f81b6241b31afa90b8ebd62c5b3c75e09.jpg","last_time":"1465873646","newest_ep_id":"89786","newest_ep_index":"24","season_id":"4779","title":"罗密欧与朱丽叶","total_count":"24","watchingCount":"0"},{"cover":"http://i0.hdslb.com/bfs/bangumi/f023cbe53828f0a9a8e4894f446d34427655b3fa.jpg","last_time":"1464858302","newest_ep_id":"88831","newest_ep_index":"19","season_id":"2581","title":"黑塔利亚 The World Twinkle 第6期","total_count":"15","watchingCount":"0"},{"cover":"http://i0.hdslb.com/bfs/bangumi/97009d6d9ca5fa9c48cfe99245ec026b1c0683ca.jpg","last_time":"1451966996","newest_ep_id":"82491","newest_ep_index":"26","season_id":"3260","title":"绝对少年","total_count":"26","watchingCount":"0"},{"cover":"http://i0.hdslb.com/bfs/bangumi/260f63bd8dd23ca71a92c6453863d453d17ee55f.jpg","last_time":"1451048459","newest_ep_id":"82112","newest_ep_index":"13","season_id":"2589","title":"青春×机关枪","total_count":"12","watchingCount":"0"},{"cover":"http://i0.hdslb.com/bfs/bangumi/c53c6d891115ae783e57bc4cb0c8a456f8788fef.jpg","last_time":"1450530055","newest_ep_id":"81748","newest_ep_index":"12","season_id":"2722","title":"学战都市Asterisk","total_count":"12","watchingCount":"0"}],"latestUpdate":{"list":[{"cover":"http://i2.hdslb.com/bfs/archive/f97441e17c305bf5a4c26ea536c527818239f7a3.jpg","last_time":"1476714610","newest_ep_id":"96240","newest_ep_index":"3","season_id":"5540","title":"斯特拉的魔法","total_count":"12","watchingCount":"929"},{"cover":"http://i0.hdslb.com/bfs/archive/fa95dde22bb1647fe3a5e48aedaae4e3cb22e4a5.jpg","last_time":"1476702010","newest_ep_id":"96049","newest_ep_index":"42","season_id":"5545","title":"怪盗Joker 第四季","total_count":"13","watchingCount":"229"},{"cover":"http://i0.hdslb.com/bfs/archive/20d7b0e7c86196b2a5434f576faa6d26c6f1d11d.jpg","last_time":"1476700210","newest_ep_id":"96228","newest_ep_index":"15","season_id":"5544","title":"12岁。第二季","total_count":"12","watchingCount":"658"},{"cover":"http://i1.hdslb.com/bfs/archive/581810a9119b1f7323512e8627bad11040c63d8b.jpg","last_time":"1476699910","newest_ep_id":"91070","newest_ep_index":"16","season_id":"5025","title":"智龙迷城X","total_count":"50","watchingCount":"168"},{"cover":"http://i2.hdslb.com/bfs/archive/805c813a27c6fb846c3abf6c583714cf4d11ec9f.jpg","last_time":"1476662449","newest_ep_id":"96841","newest_ep_index":"76","season_id":"5070","title":"齐木楠雄的灾难（日播版）","total_count":"26","watchingCount":"2585"},{"cover":"http://i1.hdslb.com/bfs/archive/e2627185c73e2f0f7239d38605284969f27c121b.jpg","last_time":"1476644710","newest_ep_id":"96216","newest_ep_index":"3","season_id":"5538","title":"青鬼","total_count":"12","watchingCount":"309"},{"cover":"http://i1.hdslb.com/bfs/archive/c12164bcb20996f6f6e4b913ed95140aa955681c.jpg","last_time":"1476639310","newest_ep_id":"95965","newest_ep_index":"15","season_id":"5069","title":"齐木楠雄的灾难","total_count":"12","watchingCount":"2983"},{"cover":"http://i2.hdslb.com/bfs/archive/aba9ba4380ce3ef2c92552e58dd81de301e08e09.jpg","last_time":"1476635401","newest_ep_id":"96622","newest_ep_index":"3","season_id":"5524","title":"我老婆是学生会长 第二季","total_count":"12","watchingCount":"1027"}],"updateCount":"11"}}
     */

    private int code;

    private String message;

    /**
     * banners : [{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/17f4538384d75d9748d0d1f2e71cbb8d226a2b71.jpg","is_ad":0,"link":"http://bangumi.bilibili.com/anime/5540","title":"斯特拉的魔法"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/08235ce5c340b15e19cb397299d199cb0838a2d3.jpg","is_ad":0,"link":"http://bangumi.bilibili.com/anime/5486","title":"星梦手记"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/0433e3d1de0707475ae29d914cb0549e51b64029.jpg","is_ad":0,"link":"http://bangumi.bilibili.com/anime/3253","title":"十万个冷笑话"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/6ceb529d6788814ac8f6db819f2a2e32d275dc4e.jpg","is_ad":0,"link":"http://bangumi.bilibili.com/anime/5301","title":"墓王之王"}]
     * ends : [{"cover":"http://i0.hdslb.com/bfs/bangumi/23ffac3faaadddedbb8ef47b84329946d306174f.jpg","last_time":"1450892161","newest_ep_id":"81949","newest_ep_index":"12","season_id":"2724","title":"对魔导学园35试验小队","total_count":"12","watchingCount":"0"},{"cover":"http://i0.hdslb.com/bfs/bangumi/1cc08a1f81b6241b31afa90b8ebd62c5b3c75e09.jpg","last_time":"1465873646","newest_ep_id":"89786","newest_ep_index":"24","season_id":"4779","title":"罗密欧与朱丽叶","total_count":"24","watchingCount":"0"},{"cover":"http://i0.hdslb.com/bfs/bangumi/f023cbe53828f0a9a8e4894f446d34427655b3fa.jpg","last_time":"1464858302","newest_ep_id":"88831","newest_ep_index":"19","season_id":"2581","title":"黑塔利亚 The World Twinkle 第6期","total_count":"15","watchingCount":"0"},{"cover":"http://i0.hdslb.com/bfs/bangumi/97009d6d9ca5fa9c48cfe99245ec026b1c0683ca.jpg","last_time":"1451966996","newest_ep_id":"82491","newest_ep_index":"26","season_id":"3260","title":"绝对少年","total_count":"26","watchingCount":"0"},{"cover":"http://i0.hdslb.com/bfs/bangumi/260f63bd8dd23ca71a92c6453863d453d17ee55f.jpg","last_time":"1451048459","newest_ep_id":"82112","newest_ep_index":"13","season_id":"2589","title":"青春×机关枪","total_count":"12","watchingCount":"0"},{"cover":"http://i0.hdslb.com/bfs/bangumi/c53c6d891115ae783e57bc4cb0c8a456f8788fef.jpg","last_time":"1450530055","newest_ep_id":"81748","newest_ep_index":"12","season_id":"2722","title":"学战都市Asterisk","total_count":"12","watchingCount":"0"}]
     * latestUpdate : {"list":[{"cover":"http://i2.hdslb.com/bfs/archive/f97441e17c305bf5a4c26ea536c527818239f7a3.jpg","last_time":"1476714610","newest_ep_id":"96240","newest_ep_index":"3","season_id":"5540","title":"斯特拉的魔法","total_count":"12","watchingCount":"929"},{"cover":"http://i0.hdslb.com/bfs/archive/fa95dde22bb1647fe3a5e48aedaae4e3cb22e4a5.jpg","last_time":"1476702010","newest_ep_id":"96049","newest_ep_index":"42","season_id":"5545","title":"怪盗Joker 第四季","total_count":"13","watchingCount":"229"},{"cover":"http://i0.hdslb.com/bfs/archive/20d7b0e7c86196b2a5434f576faa6d26c6f1d11d.jpg","last_time":"1476700210","newest_ep_id":"96228","newest_ep_index":"15","season_id":"5544","title":"12岁。第二季","total_count":"12","watchingCount":"658"},{"cover":"http://i1.hdslb.com/bfs/archive/581810a9119b1f7323512e8627bad11040c63d8b.jpg","last_time":"1476699910","newest_ep_id":"91070","newest_ep_index":"16","season_id":"5025","title":"智龙迷城X","total_count":"50","watchingCount":"168"},{"cover":"http://i2.hdslb.com/bfs/archive/805c813a27c6fb846c3abf6c583714cf4d11ec9f.jpg","last_time":"1476662449","newest_ep_id":"96841","newest_ep_index":"76","season_id":"5070","title":"齐木楠雄的灾难（日播版）","total_count":"26","watchingCount":"2585"},{"cover":"http://i1.hdslb.com/bfs/archive/e2627185c73e2f0f7239d38605284969f27c121b.jpg","last_time":"1476644710","newest_ep_id":"96216","newest_ep_index":"3","season_id":"5538","title":"青鬼","total_count":"12","watchingCount":"309"},{"cover":"http://i1.hdslb.com/bfs/archive/c12164bcb20996f6f6e4b913ed95140aa955681c.jpg","last_time":"1476639310","newest_ep_id":"95965","newest_ep_index":"15","season_id":"5069","title":"齐木楠雄的灾难","total_count":"12","watchingCount":"2983"},{"cover":"http://i2.hdslb.com/bfs/archive/aba9ba4380ce3ef2c92552e58dd81de301e08e09.jpg","last_time":"1476635401","newest_ep_id":"96622","newest_ep_index":"3","season_id":"5524","title":"我老婆是学生会长 第二季","total_count":"12","watchingCount":"1027"}],"updateCount":"11"}
     */

    private ResultBean result;

    public int getCode()
    {

        return code;
    }

    public void setCode(int code)
    {

        this.code = code;
    }

    public String getMessage()
    {

        return message;
    }

    public void setMessage(String message)
    {

        this.message = message;
    }

    public ResultBean getResult()
    {

        return result;
    }

    public void setResult(ResultBean result)
    {

        this.result = result;
    }

    public static class ResultBean
    {

        /**
         * list : [{"cover":"http://i2.hdslb.com/bfs/archive/f97441e17c305bf5a4c26ea536c527818239f7a3.jpg","last_time":"1476714610","newest_ep_id":"96240","newest_ep_index":"3","season_id":"5540","title":"斯特拉的魔法","total_count":"12","watchingCount":"929"},{"cover":"http://i0.hdslb.com/bfs/archive/fa95dde22bb1647fe3a5e48aedaae4e3cb22e4a5.jpg","last_time":"1476702010","newest_ep_id":"96049","newest_ep_index":"42","season_id":"5545","title":"怪盗Joker 第四季","total_count":"13","watchingCount":"229"},{"cover":"http://i0.hdslb.com/bfs/archive/20d7b0e7c86196b2a5434f576faa6d26c6f1d11d.jpg","last_time":"1476700210","newest_ep_id":"96228","newest_ep_index":"15","season_id":"5544","title":"12岁。第二季","total_count":"12","watchingCount":"658"},{"cover":"http://i1.hdslb.com/bfs/archive/581810a9119b1f7323512e8627bad11040c63d8b.jpg","last_time":"1476699910","newest_ep_id":"91070","newest_ep_index":"16","season_id":"5025","title":"智龙迷城X","total_count":"50","watchingCount":"168"},{"cover":"http://i2.hdslb.com/bfs/archive/805c813a27c6fb846c3abf6c583714cf4d11ec9f.jpg","last_time":"1476662449","newest_ep_id":"96841","newest_ep_index":"76","season_id":"5070","title":"齐木楠雄的灾难（日播版）","total_count":"26","watchingCount":"2585"},{"cover":"http://i1.hdslb.com/bfs/archive/e2627185c73e2f0f7239d38605284969f27c121b.jpg","last_time":"1476644710","newest_ep_id":"96216","newest_ep_index":"3","season_id":"5538","title":"青鬼","total_count":"12","watchingCount":"309"},{"cover":"http://i1.hdslb.com/bfs/archive/c12164bcb20996f6f6e4b913ed95140aa955681c.jpg","last_time":"1476639310","newest_ep_id":"95965","newest_ep_index":"15","season_id":"5069","title":"齐木楠雄的灾难","total_count":"12","watchingCount":"2983"},{"cover":"http://i2.hdslb.com/bfs/archive/aba9ba4380ce3ef2c92552e58dd81de301e08e09.jpg","last_time":"1476635401","newest_ep_id":"96622","newest_ep_index":"3","season_id":"5524","title":"我老婆是学生会长 第二季","total_count":"12","watchingCount":"1027"}]
         * updateCount : 11
         */

        private LatestUpdateBean latestUpdate;

        /**
         * id : 0
         * img : http://i0.hdslb.com/bfs/bangumi/17f4538384d75d9748d0d1f2e71cbb8d226a2b71.jpg
         * is_ad : 0
         * link : http://bangumi.bilibili.com/anime/5540
         * title : 斯特拉的魔法
         */

        private List<BannersBean> banners;

        /**
         * cover : http://i0.hdslb.com/bfs/bangumi/23ffac3faaadddedbb8ef47b84329946d306174f.jpg
         * last_time : 1450892161
         * newest_ep_id : 81949
         * newest_ep_index : 12
         * season_id : 2724
         * title : 对魔导学园35试验小队
         * total_count : 12
         * watchingCount : 0
         */

        private List<EndsBean> ends;

        public LatestUpdateBean getLatestUpdate()
        {

            return latestUpdate;
        }

        public void setLatestUpdate(LatestUpdateBean latestUpdate)
        {

            this.latestUpdate = latestUpdate;
        }

        public List<BannersBean> getBanners()
        {

            return banners;
        }

        public void setBanners(List<BannersBean> banners)
        {

            this.banners = banners;
        }

        public List<EndsBean> getEnds()
        {

            return ends;
        }

        public void setEnds(List<EndsBean> ends)
        {

            this.ends = ends;
        }

        public static class LatestUpdateBean
        {

            private String updateCount;

            /**
             * cover : http://i2.hdslb.com/bfs/archive/f97441e17c305bf5a4c26ea536c527818239f7a3.jpg
             * last_time : 1476714610
             * newest_ep_id : 96240
             * newest_ep_index : 3
             * season_id : 5540
             * title : 斯特拉的魔法
             * total_count : 12
             * watchingCount : 929
             */

            private List<ListBean> list;

            public String getUpdateCount()
            {

                return updateCount;
            }

            public void setUpdateCount(String updateCount)
            {

                this.updateCount = updateCount;
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

                private String cover;

                private String last_time;

                private String newest_ep_id;

                private String newest_ep_index;

                private String season_id;

                private String title;

                private String total_count;

                private String watchingCount;

                public String getCover()
                {

                    return cover;
                }

                public void setCover(String cover)
                {

                    this.cover = cover;
                }

                public String getLast_time()
                {

                    return last_time;
                }

                public void setLast_time(String last_time)
                {

                    this.last_time = last_time;
                }

                public String getNewest_ep_id()
                {

                    return newest_ep_id;
                }

                public void setNewest_ep_id(String newest_ep_id)
                {

                    this.newest_ep_id = newest_ep_id;
                }

                public String getNewest_ep_index()
                {

                    return newest_ep_index;
                }

                public void setNewest_ep_index(String newest_ep_index)
                {

                    this.newest_ep_index = newest_ep_index;
                }

                public String getSeason_id()
                {

                    return season_id;
                }

                public void setSeason_id(String season_id)
                {

                    this.season_id = season_id;
                }

                public String getTitle()
                {

                    return title;
                }

                public void setTitle(String title)
                {

                    this.title = title;
                }

                public String getTotal_count()
                {

                    return total_count;
                }

                public void setTotal_count(String total_count)
                {

                    this.total_count = total_count;
                }

                public String getWatchingCount()
                {

                    return watchingCount;
                }

                public void setWatchingCount(String watchingCount)
                {

                    this.watchingCount = watchingCount;
                }
            }
        }

        public static class BannersBean
        {

            private int id;

            private String img;

            private int is_ad;

            private String link;

            private String title;

            public int getId()
            {

                return id;
            }

            public void setId(int id)
            {

                this.id = id;
            }

            public String getImg()
            {

                return img;
            }

            public void setImg(String img)
            {

                this.img = img;
            }

            public int getIs_ad()
            {

                return is_ad;
            }

            public void setIs_ad(int is_ad)
            {

                this.is_ad = is_ad;
            }

            public String getLink()
            {

                return link;
            }

            public void setLink(String link)
            {

                this.link = link;
            }

            public String getTitle()
            {

                return title;
            }

            public void setTitle(String title)
            {

                this.title = title;
            }
        }

        public static class EndsBean
        {

            private String cover;

            private String last_time;

            private String newest_ep_id;

            private String newest_ep_index;

            private String season_id;

            private String title;

            private String total_count;

            private String watchingCount;

            public String getCover()
            {

                return cover;
            }

            public void setCover(String cover)
            {

                this.cover = cover;
            }

            public String getLast_time()
            {

                return last_time;
            }

            public void setLast_time(String last_time)
            {

                this.last_time = last_time;
            }

            public String getNewest_ep_id()
            {

                return newest_ep_id;
            }

            public void setNewest_ep_id(String newest_ep_id)
            {

                this.newest_ep_id = newest_ep_id;
            }

            public String getNewest_ep_index()
            {

                return newest_ep_index;
            }

            public void setNewest_ep_index(String newest_ep_index)
            {

                this.newest_ep_index = newest_ep_index;
            }

            public String getSeason_id()
            {

                return season_id;
            }

            public void setSeason_id(String season_id)
            {

                this.season_id = season_id;
            }

            public String getTitle()
            {

                return title;
            }

            public void setTitle(String title)
            {

                this.title = title;
            }

            public String getTotal_count()
            {

                return total_count;
            }

            public void setTotal_count(String total_count)
            {

                this.total_count = total_count;
            }

            public String getWatchingCount()
            {

                return watchingCount;
            }

            public void setWatchingCount(String watchingCount)
            {

                this.watchingCount = watchingCount;
            }
        }
    }
}
