package com.hotbitmapgg.ohmybilibili.utils;

import android.util.Log;

/**
 * 日志打印工具类
 *
 * @author hcc
 */
public class LogUtil
{

	private static final String TAG = "LogUtil";

	private static boolean isShow = true;

	public static boolean isShow()
	{
		return isShow;
	}

	public static void setShow(boolean show)
	{
		isShow = show;
	}

	public static void i(String tag, String msg)
	{
		if (isShow)
			Log.i(tag, msg);
	}

	public static void w(String tag, String msg)
	{
		if (isShow)
			Log.w(tag, msg);
	}

	public static void e(String tag, String msg)
	{
		if (isShow)
			Log.e(tag, msg);
	}

	public static void lsw(String msg)
	{
		if (isShow)
			Log.e("lsw", msg);
	}

	public static void i(String msg)
	{
		if (isShow)
			Log.i(TAG, msg);
	}

	public static void w(String msg)
	{
		if (isShow)
			Log.w(TAG, msg);
	}

	public static void e(String msg)
	{
		if (isShow)
			Log.e(TAG, msg);
	}

	public static void v(String msg)
	{
		e(msg);
	}

	public static void d(String msg)
	{
		v(msg);
	}
}
