package com.hotbitmapgg.ohmybilibili.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * 时间相关工具类
 *
 * @HotBitmapGG
 */
public class WeekDayUtils
{

    /**
     * * 获取指定日期是星期几
     * <p/>
     * 参数为null时表示获取当前日期是星期几
     *
     * @param date
     * @return
     */

    public static String getWeekOfDate(Date date)
    {

        String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

        Calendar calendar = Calendar.getInstance();

        if (date != null)
        {

            calendar.setTime(date);
        }

        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        if (w < 0)
        {

            w = 0;
        }

        return weekOfDays[w];
    }
}
