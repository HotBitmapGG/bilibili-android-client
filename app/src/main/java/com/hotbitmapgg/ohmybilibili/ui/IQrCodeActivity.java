package com.hotbitmapgg.ohmybilibili.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.utils.StatusBarCompat;

/**
 * 我的二维码
 * @author Administrator
 * @hcc
 *
 */
public class IQrCodeActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_i_qrcode);

		//设置全局状态栏颜色
		StatusBarCompat.compat(this);

		initTitle();
		initView();
	}

	private void initView()
	{
		// TODO Auto-generated method stub

	}

	private void initTitle()
	{
		Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
		mToolbar.setNavigationIcon(R.drawable.action_button_back_pressed_light);
		mToolbar.setTitle("关于我");
		mToolbar.setNavigationOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				finish();
			}
		});
	}
}
