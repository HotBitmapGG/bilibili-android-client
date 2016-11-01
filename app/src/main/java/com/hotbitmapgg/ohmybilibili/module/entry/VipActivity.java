package com.hotbitmapgg.ohmybilibili.module.entry;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxBaseActivity;
import com.hotbitmapgg.ohmybilibili.utils.ConstantUtil;
import com.hotbitmapgg.ohmybilibili.utils.SystemBarHelper;

import butterknife.BindView;

/**
 * Created by hcc on 2016/10/16 13:49
 * 100332338@qq.com
 * <p>
 * 大会员界面
 */

public class VipActivity extends RxBaseActivity
{

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    @BindView(R.id.webView)
    WebView mWebView;


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_vip;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        mWebView.loadUrl(ConstantUtil.VIP_URL);
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.setDisplayHomeAsUpEnabled(true);

        //设置StatusBar透明
        SystemBarHelper.immersiveStatusBar(this);
        SystemBarHelper.setHeightAndPadding(this, mToolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
