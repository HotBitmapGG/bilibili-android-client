package com.hotbitmapgg.ohmybilibili.entity.user;

import java.util.List;

/**
 * Created by hcc on 2016/10/12 22:39
 * 100332338@qq.com
 * <p>
 * 用户详情所玩游戏模型类
 */

public class UserPlayGameInfo
{

    /**
     * status : true
     * data : {"games":[{"website":"http://yys.biligame.com/","image":"http://i0.hdslb.com/bfs/game/3b205675d44bbd90e6ea46d4baec9674bda6e642.png","name":"阴阳师"},{"website":"http://djsy.biligame.com/","image":"http://i0.hdslb.com/bfs/game/80008bbf4cb9b0343fd6e4325127645b2323c1a3.png","name":"刀剑神域黑衣剑士"},{"website":"http://acg.tv/u1g3","image":"http://i0.hdslb.com/u_user/7baceb341073fe823faad36d2e1c805e.png","name":"ICHU偶像进行曲"},{"website":"http://100p.biligame.com/","image":"http://i0.hdslb.com/bfs/game/3e8f079c18c2f81627703c0914e3c285f6d1a7b2.png","name":"梦100"},{"website":"http://xsqst.biligame.com/","image":"http://i2.hdslb.com/u_user/b3c01eb5b7d9925e4488f581baef8006.jpg","name":"像素骑士团"}],"count":5}
     */

    private boolean status;

    /**
     * games : [{"website":"http://yys.biligame.com/","image":"http://i0.hdslb.com/bfs/game/3b205675d44bbd90e6ea46d4baec9674bda6e642.png","name":"阴阳师"},{"website":"http://djsy.biligame.com/","image":"http://i0.hdslb.com/bfs/game/80008bbf4cb9b0343fd6e4325127645b2323c1a3.png","name":"刀剑神域黑衣剑士"},{"website":"http://acg.tv/u1g3","image":"http://i0.hdslb.com/u_user/7baceb341073fe823faad36d2e1c805e.png","name":"ICHU偶像进行曲"},{"website":"http://100p.biligame.com/","image":"http://i0.hdslb.com/bfs/game/3e8f079c18c2f81627703c0914e3c285f6d1a7b2.png","name":"梦100"},{"website":"http://xsqst.biligame.com/","image":"http://i2.hdslb.com/u_user/b3c01eb5b7d9925e4488f581baef8006.jpg","name":"像素骑士团"}]
     * count : 5
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

        /**
         * website : http://yys.biligame.com/
         * image : http://i0.hdslb.com/bfs/game/3b205675d44bbd90e6ea46d4baec9674bda6e642.png
         * name : 阴阳师
         */

        private List<GamesBean> games;

        public int getCount()
        {

            return count;
        }

        public void setCount(int count)
        {

            this.count = count;
        }

        public List<GamesBean> getGames()
        {

            return games;
        }

        public void setGames(List<GamesBean> games)
        {

            this.games = games;
        }

        public static class GamesBean
        {

            private String website;

            private String image;

            private String name;

            public String getWebsite()
            {

                return website;
            }

            public void setWebsite(String website)
            {

                this.website = website;
            }

            public String getImage()
            {

                return image;
            }

            public void setImage(String image)
            {

                this.image = image;
            }

            public String getName()
            {

                return name;
            }

            public void setName(String name)
            {

                this.name = name;
            }
        }
    }
}
