package com.hotbitmapgg.ohmybilibili.entity.bangumi;

import java.util.List;

/**
 * Created by hcc on 2016/9/25 14:32
 * 100332338@qq.com
 * <p>
 * 分季新番
 */

public class SeasonNewBangumi
{

    private int code;

    private String ver;

    private String screen;

    private int count;

    /**
     * title : Re：从零开始的异世界生活
     * remark : Re：从零开始的异世界生活
     * remark2 :
     * style : medium
     * imagekey : a38fdd1a07a3d4ab21a6eaa251f2fd74
     * imageurl : http://i2.hdslb.com/320_452/u_user/a0a21991e1f7761642f5e950c898ba68.jpg
     * width : 320
     * height : 452
     * type : bangumi
     * spname : Re：从零开始的异世界生活
     * spid : 66139
     */

    private List<ListBean> list;

    public int getCode()
    {

        return code;
    }

    public void setCode(int code)
    {

        this.code = code;
    }

    public String getVer()
    {

        return ver;
    }

    public void setVer(String ver)
    {

        this.ver = ver;
    }

    public String getScreen()
    {

        return screen;
    }

    public void setScreen(String screen)
    {

        this.screen = screen;
    }

    public int getCount()
    {

        return count;
    }

    public void setCount(int count)
    {

        this.count = count;
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

        private String title;

        private String remark;

        private String remark2;

        private String style;

        private String imagekey;

        private String imageurl;

        private int width;

        private int height;

        private String type;

        private String spname;

        private int spid;

        public String getTitle()
        {

            return title;
        }

        public void setTitle(String title)
        {

            this.title = title;
        }

        public String getRemark()
        {

            return remark;
        }

        public void setRemark(String remark)
        {

            this.remark = remark;
        }

        public String getRemark2()
        {

            return remark2;
        }

        public void setRemark2(String remark2)
        {

            this.remark2 = remark2;
        }

        public String getStyle()
        {

            return style;
        }

        public void setStyle(String style)
        {

            this.style = style;
        }

        public String getImagekey()
        {

            return imagekey;
        }

        public void setImagekey(String imagekey)
        {

            this.imagekey = imagekey;
        }

        public String getImageurl()
        {

            return imageurl;
        }

        public void setImageurl(String imageurl)
        {

            this.imageurl = imageurl;
        }

        public int getWidth()
        {

            return width;
        }

        public void setWidth(int width)
        {

            this.width = width;
        }

        public int getHeight()
        {

            return height;
        }

        public void setHeight(int height)
        {

            this.height = height;
        }

        public String getType()
        {

            return type;
        }

        public void setType(String type)
        {

            this.type = type;
        }

        public String getSpname()
        {

            return spname;
        }

        public void setSpname(String spname)
        {

            this.spname = spname;
        }

        public int getSpid()
        {

            return spid;
        }

        public void setSpid(int spid)
        {

            this.spid = spid;
        }
    }
}
