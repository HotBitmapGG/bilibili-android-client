package com.hotbitmapgg.ohmybilibili.api;

import com.hotbitmapgg.ohmybilibili.network.ApiHelper;
import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.Index;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;

public class IndexApi
{

	public static BasicMessage<Index> getIndex()
	{
		String url = ApiHelper.getIndexUrl();
		LogUtil.lsw(url);
		return ApiHelper.getSimpleUrlResult(url, Index.class);
	}

}
