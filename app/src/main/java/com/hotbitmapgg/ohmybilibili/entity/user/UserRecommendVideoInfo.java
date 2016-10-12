package com.hotbitmapgg.ohmybilibili.entity.user;

import java.util.List;

/**
 * Created by hcc on 16/8/22 20:48
 * 100332338@qq.com
 * <p/>
 * 用户推荐视频模型类
 */
public class UserRecommendVideoInfo
{

    public int code;

    public List<AuthorData> list;


    public class AuthorData
    {

        public int aid;

        public int click;

        public String cover;

        public int favorites;

        public int review;

        public String title;

        public int video_review;
    }
}
