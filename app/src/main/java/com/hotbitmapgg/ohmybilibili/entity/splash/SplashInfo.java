package com.hotbitmapgg.ohmybilibili.entity.splash;

import java.util.List;

/**
 * Created by hcc on 2016/10/31 10:31
 * 100332338@qq.com
 * <p>
 * 启动页模型类
 */

public class SplashInfo
{

    /**
     * code : 0
     * data : [{"id":166,"animate":1,"duration":2,"platform":"IOS","startTime":1477843200,"endTime":1477929600,"thumbUrl":"http://i0.hdslb.com/bfs/archive/9c86271b367f4ac6dbe1d7037e61a9f1b8bc48f8.jpg?/872eb9d1933ac6ff5b90c66275c78850.","times":5,"type":"opertion"}]
     */

    private int code;

    /**
     * id : 166
     * animate : 1
     * duration : 2
     * platform : IOS
     * startTime : 1477843200
     * endTime : 1477929600
     * thumbUrl : http://i0.hdslb.com/bfs/archive/9c86271b367f4ac6dbe1d7037e61a9f1b8bc48f8.jpg?/872eb9d1933ac6ff5b90c66275c78850.
     * times : 5
     * type : opertion
     */

    private List<DataBean> data;

    public int getCode()
    {

        return code;
    }

    public void setCode(int code)
    {

        this.code = code;
    }

    public List<DataBean> getData()
    {

        return data;
    }

    public void setData(List<DataBean> data)
    {

        this.data = data;
    }

    public static class DataBean
    {

        private int id;

        private int animate;

        private int duration;

        private String platform;

        private int startTime;

        private int endTime;

        private String thumbUrl;

        private int times;

        private String type;

        public int getId()
        {

            return id;
        }

        public void setId(int id)
        {

            this.id = id;
        }

        public int getAnimate()
        {

            return animate;
        }

        public void setAnimate(int animate)
        {

            this.animate = animate;
        }

        public int getDuration()
        {

            return duration;
        }

        public void setDuration(int duration)
        {

            this.duration = duration;
        }

        public String getPlatform()
        {

            return platform;
        }

        public void setPlatform(String platform)
        {

            this.platform = platform;
        }

        public int getStartTime()
        {

            return startTime;
        }

        public void setStartTime(int startTime)
        {

            this.startTime = startTime;
        }

        public int getEndTime()
        {

            return endTime;
        }

        public void setEndTime(int endTime)
        {

            this.endTime = endTime;
        }

        public String getThumbUrl()
        {

            return thumbUrl;
        }

        public void setThumbUrl(String thumbUrl)
        {

            this.thumbUrl = thumbUrl;
        }

        public int getTimes()
        {

            return times;
        }

        public void setTimes(int times)
        {

            this.times = times;
        }

        public String getType()
        {

            return type;
        }

        public void setType(String type)
        {

            this.type = type;
        }
    }
}
