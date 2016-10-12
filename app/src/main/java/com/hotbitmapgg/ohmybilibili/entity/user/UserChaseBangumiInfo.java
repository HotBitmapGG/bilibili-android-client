package com.hotbitmapgg.ohmybilibili.entity.user;

import java.util.List;

/**
 * Created by hcc on 2016/10/12 18:43
 * 100332338@qq.com
 * <p>
 * 用户详情追番模型类
 */

public class UserChaseBangumiInfo
{

    /**
     * status : true
     * data : {"count":3,"pages":1,"result":[{"season_id":"5523","share_url":"http://bangumi.bilibili.com/anime/5523/","title":"3月的狮子","is_finish":0,"favorites":201926,"newest_ep_index":1,"last_ep_index":0,"total_count":22,"cover":"http://i0.hdslb.com/bfs/bangumi/7bfd5b9a4aabee8df09df12939d2f32c2f41a0d7.jpg","evaluate":"","brief":"独自居住在东京旧市街的17岁职业将棋棋士\u2014\u2014桐山零。\n他是个幼时就因为意外失去家人，怀抱着深沉孤独的..."},{"season_id":"5063","share_url":"http://bangumi.bilibili.com/anime/5063/","title":"DAYS","is_finish":0,"favorites":177725,"newest_ep_index":14,"last_ep_index":0,"total_count":24,"cover":"http://i0.hdslb.com/bfs/bangumi/20f05ecc4c50d560814e511ced4205f37e640501.jpg","evaluate":"","brief":"【本周更新的13话将改为10月2日播出】电视动画《DAYS》改编自日本漫画家安田刚士原作的同名漫画。..."},{"season_id":"5029","share_url":"http://bangumi.bilibili.com/anime/5029/","title":"天真与闪电","is_finish":1,"favorites":410969,"newest_ep_index":12,"last_ep_index":0,"total_count":12,"cover":"http://i0.hdslb.com/bfs/bangumi/5626f7afbd39a0b4561dea5bd267ba1ef2248c0d.jpg","evaluate":"","brief":"妻子亡故后，独自努力养育女儿的数学教师·犬冢。不擅长料理又是个味觉白痴的他，在偶然之下和学生·饭田小..."}]}
     */

    private boolean status;

    /**
     * count : 3
     * pages : 1
     * result : [{"season_id":"5523","share_url":"http://bangumi.bilibili.com/anime/5523/","title":"3月的狮子","is_finish":0,"favorites":201926,"newest_ep_index":1,"last_ep_index":0,"total_count":22,"cover":"http://i0.hdslb.com/bfs/bangumi/7bfd5b9a4aabee8df09df12939d2f32c2f41a0d7.jpg","evaluate":"","brief":"独自居住在东京旧市街的17岁职业将棋棋士\u2014\u2014桐山零。\n他是个幼时就因为意外失去家人，怀抱着深沉孤独的..."},{"season_id":"5063","share_url":"http://bangumi.bilibili.com/anime/5063/","title":"DAYS","is_finish":0,"favorites":177725,"newest_ep_index":14,"last_ep_index":0,"total_count":24,"cover":"http://i0.hdslb.com/bfs/bangumi/20f05ecc4c50d560814e511ced4205f37e640501.jpg","evaluate":"","brief":"【本周更新的13话将改为10月2日播出】电视动画《DAYS》改编自日本漫画家安田刚士原作的同名漫画。..."},{"season_id":"5029","share_url":"http://bangumi.bilibili.com/anime/5029/","title":"天真与闪电","is_finish":1,"favorites":410969,"newest_ep_index":12,"last_ep_index":0,"total_count":12,"cover":"http://i0.hdslb.com/bfs/bangumi/5626f7afbd39a0b4561dea5bd267ba1ef2248c0d.jpg","evaluate":"","brief":"妻子亡故后，独自努力养育女儿的数学教师·犬冢。不擅长料理又是个味觉白痴的他，在偶然之下和学生·饭田小..."}]
     */

    private DataBean data;

    public boolean isStatus()
    {

        return status;
    }

    public void setStatus(boolean status)
    {

        this.status = status;
    }

    public DataBean getData()
    {

        return data;
    }

    public void setData(DataBean data)
    {

        this.data = data;
    }

    public static class DataBean
    {

        private int count;

        private int pages;

        /**
         * season_id : 5523
         * share_url : http://bangumi.bilibili.com/anime/5523/
         * title : 3月的狮子
         * is_finish : 0
         * favorites : 201926
         * newest_ep_index : 1
         * last_ep_index : 0
         * total_count : 22
         * cover : http://i0.hdslb.com/bfs/bangumi/7bfd5b9a4aabee8df09df12939d2f32c2f41a0d7.jpg
         * evaluate :
         * brief : 独自居住在东京旧市街的17岁职业将棋棋士——桐山零。
         * 他是个幼时就因为意外失去家人，怀抱着深沉孤独的...
         */

        private List<ResultBean> result;

        public int getCount()
        {

            return count;
        }

        public void setCount(int count)
        {

            this.count = count;
        }

        public int getPages()
        {

            return pages;
        }

        public void setPages(int pages)
        {

            this.pages = pages;
        }

        public List<ResultBean> getResult()
        {

            return result;
        }

        public void setResult(List<ResultBean> result)
        {

            this.result = result;
        }

        public static class ResultBean
        {

            private String season_id;

            private String share_url;

            private String title;

            private int is_finish;

            private int favorites;

            private int newest_ep_index;

            private int last_ep_index;

            private int total_count;

            private String cover;

            private String evaluate;

            private String brief;

            public String getSeason_id()
            {

                return season_id;
            }

            public void setSeason_id(String season_id)
            {

                this.season_id = season_id;
            }

            public String getShare_url()
            {

                return share_url;
            }

            public void setShare_url(String share_url)
            {

                this.share_url = share_url;
            }

            public String getTitle()
            {

                return title;
            }

            public void setTitle(String title)
            {

                this.title = title;
            }

            public int getIs_finish()
            {

                return is_finish;
            }

            public void setIs_finish(int is_finish)
            {

                this.is_finish = is_finish;
            }

            public int getFavorites()
            {

                return favorites;
            }

            public void setFavorites(int favorites)
            {

                this.favorites = favorites;
            }

            public int getNewest_ep_index()
            {

                return newest_ep_index;
            }

            public void setNewest_ep_index(int newest_ep_index)
            {

                this.newest_ep_index = newest_ep_index;
            }

            public int getLast_ep_index()
            {

                return last_ep_index;
            }

            public void setLast_ep_index(int last_ep_index)
            {

                this.last_ep_index = last_ep_index;
            }

            public int getTotal_count()
            {

                return total_count;
            }

            public void setTotal_count(int total_count)
            {

                this.total_count = total_count;
            }

            public String getCover()
            {

                return cover;
            }

            public void setCover(String cover)
            {

                this.cover = cover;
            }

            public String getEvaluate()
            {

                return evaluate;
            }

            public void setEvaluate(String evaluate)
            {

                this.evaluate = evaluate;
            }

            public String getBrief()
            {

                return brief;
            }

            public void setBrief(String brief)
            {

                this.brief = brief;
            }
        }
    }
}
