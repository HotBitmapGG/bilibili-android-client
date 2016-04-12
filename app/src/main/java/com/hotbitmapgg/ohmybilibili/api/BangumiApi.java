package com.hotbitmapgg.ohmybilibili.api;

import com.hotbitmapgg.ohmybilibili.network.ApiHelper;
import com.hotbitmapgg.ohmybilibili.model.Bangumi;
import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.utils.WeekDayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *  番剧专题查询
 *
 */
public class BangumiApi
{

	public static final int BTYPE_ALL = -1, BTYPE_2D = 2, BTYPE_RETINA = 3;
	public static final int WD_ALL = -1, WD_SUN = 0, WD_MON = 1, WD_TUE = 2, WD_WED = 3, WD_THU = 4, WD_FRI = 5, WD_SAT = 6;

	public static int getToDayByWeekDay(String weekDay)
	{
		int num = -1;

		if (weekDay.equals("星期日"))
		{
			num = 00;

			return num;
		}
		else if (weekDay.equals("星期一"))
		{
			num = 1;

			return num;
		}
		else if (weekDay.equals("星期二"))
		{
			num = 2;

			return num;
		}

		else if (weekDay.equals("星期三"))
		{
			num = 3;

			return num;
		}

		else if (weekDay.equals("星期四"))
		{
			num = 4;

			return num;
		}

		else if (weekDay.equals("星期五"))
		{
			num = 5;

			return num;
		}

		else if (weekDay.equals("星期六"))
		{
			num = 6;

			return num;
		}

		return num;

	}

	public static BasicMessage<ArrayList<Bangumi>> getBangumi(int type)
	{
		// 根据今天的日期去请求对应的数据
		String weekOfDate = WeekDayUtils.getWeekOfDate(null);
		LogUtil.lsw(weekOfDate);
		int weekDay = getToDayByWeekDay(weekOfDate);
		LogUtil.lsw(weekDay + "");

		return getBangumi(type, weekDay);
	}

	public static BasicMessage<ArrayList<Bangumi>> getBangumi(int btype, int weekday)
	{
		String url = ApiHelper.getBangumiUrl(btype, weekday);
		LogUtil.lsw(url);
		BasicMessage<BangumiResult> result = ApiHelper.getSimpleUrlResult(url, BangumiResult.class);
		BasicMessage<ArrayList<Bangumi>> msg = new BasicMessage<>();
		if (result.getCode() == BasicMessage.CODE_SUCCEED)
		{
			msg.setObject(new ArrayList<>(result.getObject().list));
			msg.setCode(BasicMessage.CODE_SUCCEED);
		}
		else
		{
			msg.setCode(BasicMessage.CODE_ERROR);
		}
		return msg;
	}

	private class BangumiResult
	{

		public int results;
		public List<Bangumi> list;

	}

}
