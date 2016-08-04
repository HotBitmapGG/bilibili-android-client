package com.hotbitmapgg.ohmybilibili.model.partition;

import java.io.Serializable;

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
