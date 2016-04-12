package com.hotbitmapgg.ohmybilibili.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.hotbitmapgg.ohmybilibili.R;


public class StatusBarHeaderView extends View
{

	private int colorNormal, colorDark, enableMode;

	public static final int MODE_KITKAT = 1, MODE_LOLLIPOP = 2, MODE_ALL = 3;

	public StatusBarHeaderView(Context context)
	{
		this(context, null);
	}

	public StatusBarHeaderView(Context context, AttributeSet attrs)
	{
		this(context, attrs, 0);
	}

	public StatusBarHeaderView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.StatusBarHeaderView, defStyle, R.style.Widget_StatusBarHeaderView);
		colorNormal = a.getColor(R.styleable.StatusBarHeaderView_colorNormal, Color.TRANSPARENT);
		if (a.hasValue(R.styleable.StatusBarHeaderView_colorDark))
		{
			colorDark = a.getColor(R.styleable.StatusBarHeaderView_colorDark, Color.TRANSPARENT);
		}
		else
		{
			colorDark = ViewHelper.getMiddleColor(colorNormal, Color.BLACK, 0.2f);
		}
		enableMode = a.getInt(R.styleable.StatusBarHeaderView_enableMode, MODE_ALL);
		init();
		a.recycle();
	}

	public StatusBarHeaderView(Context context, int colorNormal, int colorDark, int enableMode)
	{
		this(context);
		this.colorNormal = colorNormal;
		this.colorDark = colorDark;
		this.enableMode = enableMode;
		init();
	}

	@Override
	public void onMeasure(int widthSpec, int heightSpec)
	{
		super.onMeasure(widthSpec, heightSpec);
		adjustHeight();
	}

	@Override
	public void invalidate()
	{
		super.invalidate();
		adjustHeight();
	}

	public void adjustHeight()
	{
		ViewGroup.LayoutParams params = getLayoutParams();
		params.height = ViewHelper.getStatusBarHeight(getContext());
	}

	void init()
	{
		int SDK_INT = Build.VERSION.SDK_INT;
		this.setBackgroundColor(SDK_INT == 19 ? colorNormal : colorDark);
		this.setVisibility(!ViewHelper.isChrome() && ((((enableMode == MODE_KITKAT) && (SDK_INT == 19)) || ((enableMode == MODE_LOLLIPOP) && (SDK_INT == 21)) || ((enableMode == MODE_ALL) && (SDK_INT >= 19)))) ? View.VISIBLE : View.GONE);
	}

	public void setNormalColor(int colorNormal)
	{
		this.colorNormal = colorNormal;
		init();
	}

	public void setDarkColor(int colorDark)
	{
		this.colorDark = colorDark;
		init();
	}

	public int getNormalColor()
	{
		return this.colorNormal;
	}

	public int getDarkColor()
	{
		return this.colorDark;
	}

	public void setMode(int mode)
	{
		this.enableMode = mode;
		init();
	}

	public int getMode()
	{
		return this.enableMode;
	}

}
