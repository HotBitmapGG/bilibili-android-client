package com.hotbitmapgg.ohmybilibili.module.common;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxBaseActivity;

import butterknife.BindView;


/**
 * Created by hcc on 16/8/7 14:12
 * 100332338@qq.com
 * <p/>
 * App介绍界面
 */
public class AppIntroduceActivity extends RxBaseActivity
{


    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.tv_version)
    TextView mVersion;


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_app_introduce;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void initViews(Bundle savedInstanceState)
    {

        mVersion.setText("v" + getVersion());
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setTitle("关于");
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private String getVersion()
    {

        try
        {
            PackageInfo pi = getPackageManager()
                    .getPackageInfo(getPackageName(), 0);
            return pi.versionName;
        } catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
            return getString(R.string.about_version);
        }
    }
}
