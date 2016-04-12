package com.hotbitmapgg.ohmybilibili.model;

import cn.bmob.v3.BmobObject;

public class FeedBackBean extends BmobObject
{
	private String content;

	public FeedBackBean(String content)
	{
		super();
		this.content = content;
	}

	public FeedBackBean()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	@Override
	public String toString()
	{
		return "FeekBckBean [content=" + content + "]";
	}

}
