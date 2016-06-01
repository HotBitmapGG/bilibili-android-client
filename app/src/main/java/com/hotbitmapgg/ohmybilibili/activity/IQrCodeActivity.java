package com.hotbitmapgg.ohmybilibili.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.AbsBaseActivity;

import butterknife.Bind;

/**
 * 我的二维码
 *
 * @HotBitmapGG
 */
public class IQrCodeActivity extends AbsBaseActivity
{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_i_qrcode;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

    }

    @Override
    public void initToolBar()
    {

        mToolbar.setNavigationIcon(R.drawable.action_button_back_pressed_light);
        mToolbar.setTitle("我的二维码");
        mToolbar.setNavigationOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                finish();
            }
        });
    }
}
