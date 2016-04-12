package com.hotbitmapgg.ohmybilibili.widget;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class TranslucentSBActivity extends FragmentActivity
{

	boolean needSetTranslucent = true, isCreated = false;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		if (needSetTranslucent)
		{
			StatusBarCompat.setUpActivity(this);
		}
		isCreated = true;
	}

	public void setStatusBarTranslucent(boolean should) throws ShouldSetBeforeActivityCreatedException
	{
		if (isCreated)
		{
			throw new ShouldSetBeforeActivityCreatedException();
		}
		else
		{
			this.needSetTranslucent = should;
		}
	}

	public class ShouldSetBeforeActivityCreatedException extends Exception
	{
	}

}
