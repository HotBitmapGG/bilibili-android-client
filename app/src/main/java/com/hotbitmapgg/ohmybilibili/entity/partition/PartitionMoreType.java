package com.hotbitmapgg.ohmybilibili.entity.partition;

import java.io.Serializable;

/**
 * Created by hcc on 16/8/22 20:48
 * 100332338@qq.com
 * <p/>
 * 分区模块类型
 */
public class PartitionMoreType implements Serializable
{

    private String titleName;

    private int titleType;

    public PartitionMoreType(String titleName, int titleType)
    {

        super();
        this.titleName = titleName;
        this.titleType = titleType;
    }

    public String getTitleName()
    {

        return titleName;
    }

    public void setTitleName(String titleName)
    {

        this.titleName = titleName;
    }

    public int getTitleType()
    {

        return titleType;
    }

    public void setTitleType(int titleType)
    {

        this.titleType = titleType;
    }
}
