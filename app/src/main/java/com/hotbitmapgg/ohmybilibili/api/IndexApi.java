package com.hotbitmapgg.ohmybilibili.api;

import com.hotbitmapgg.ohmybilibili.network.ApiHelper;
import com.hotbitmapgg.ohmybilibili.model.base.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.index.Index;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;

/**
 * 首页分区推荐查询Api
 *
 * @HotBitmapGG
 */
public class IndexApi
{

	public static BasicMessage<Index> getIndex()
	{
		String url = ApiHelper.getIndexUrl();
		LogUtil.lsw(url);
		return ApiHelper.getSimpleUrlResult(url, Index.class);
	}

}
