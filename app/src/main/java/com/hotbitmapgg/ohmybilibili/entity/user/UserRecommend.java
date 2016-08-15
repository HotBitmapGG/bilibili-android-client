package com.hotbitmapgg.ohmybilibili.entity.user;

import java.util.List;

public class UserRecommend
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
