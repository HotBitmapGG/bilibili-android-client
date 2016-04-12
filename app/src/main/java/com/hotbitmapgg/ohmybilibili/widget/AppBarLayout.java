package com.hotbitmapgg.ohmybilibili.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hotbitmapgg.ohmybilibili.R;

@SuppressLint("NewApi")
public class AppBarLayout extends LinearLayout
{

	private int colorNormal, colorDark, enableMode;

	private boolean enableElevation;

	private StatusBarHeaderView headerView;

	public static final int MODE_KITKAT = 1, MODE_LOLLIPOP = 2, MODE_ALL = 3;

	public AppBarLayout(Context context)
	{
		this(context, null);
	}

	public AppBarLayout(Context context, AttributeSet attrs)
	{
		this(context, attrs, 0);
	}

	public AppBarLayout(Context context, AttributeSet attrs, int defStyle)
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
		headerView = new StatusBarHeaderView(context, colorNormal, colorDark, enableMode);

		ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
		headerView.setLayoutParams(lp);

		this.setOrientation(LinearLayout.VERTICAL);
		this.addView(headerView);
		a.recycle();

		TypedArray a1 = context.obtainStyledAttributes(attrs, R.styleable.AppBarLayout, defStyle, R.style.Widget_FengMoe_AppBarLayout);
		this.setEnableElevation(a1.getBoolean(R.styleable.AppBarLayout_enableElevation, true));
	}

	@Override
	public void invalidate()
	{
		super.invalidate();
		headerView.invalidate();
	}

	public void setNormalColor(int colorNormal)
	{
		this.colorNormal = colorNormal;
		this.setBackgroundColorWithoutAlpha(colorNormal);
		headerView.setNormalColor(colorNormal);
		headerView.init();
	}

	public void setDarkColor(int colorDark)
	{
		this.colorDark = colorDark;
		headerView.setDarkColor(colorDark);
		headerView.init();
	}

	public void setColor(int colorNormal, int colorDark)
	{
		this.colorNormal = colorNormal;
		this.colorDark = colorDark;
		this.setBackgroundColorWithoutAlpha(colorNormal);
		headerView.setNormalColor(colorNormal);
		headerView.setDarkColor(colorDark);
		headerView.init();
	}

	public void setColorResources(@ColorRes int colorNormal, @ColorRes int colorDark)
	{
		this.setColor(getResources().getColor(colorNormal), getResources().getColor(colorDark));
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
		headerView.setMode(mode);
		headerView.init();
	}

	public int getMode()
	{
		return this.enableMode;
	}

	private void setBackgroundColorWithoutAlpha(int color)
	{
		this.setBackgroundColor(Color.argb(255, Color.red(color), Color.green(color), Color.blue(color)));
	}

	public boolean isEnableElevation()
	{
		return enableElevation;
	}

	public void setEnableElevation(boolean enableElevation)
	{
		this.setEnableElevation(enableElevation, 5f);
	}

	public void setEnableElevation(boolean enableElevation, float dp)
	{
		this.enableElevation = enableElevation;
		if (enableElevation && Build.VERSION.SDK_INT >= 21)
		{
			this.setBackgroundColorWithoutAlpha(colorNormal);
			this.setElevation(ViewHelper.dpToPx(getContext(), dp));
		}
		else
		{
			this.setBackgroundColor(colorNormal);
		}
	}

}
