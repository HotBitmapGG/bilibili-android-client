package com.hotbitmapgg.ohmybilibili.module.partition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.PartitionMorePagerAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.model.partition.PartitionMoreTitle;
import com.hotbitmapgg.ohmybilibili.model.partition.PartitionMoreType;

import java.util.List;

import butterknife.Bind;

/**
 * 分区界面
 *
 * @HotBitmapGG
 */
public class PartitionMoreActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.more_toolbar)
    Toolbar mToolbar;

    @Bind(R.id.bangumi_more_tab_pager)
    ViewPager mTabPager;

    @Bind(R.id.bangumi_more_sliding_tabs)
    SlidingTabLayout mSlidingTab;

    private PartitionMorePagerAdapter mAdapter;

    private List<PartitionMoreType> titles;

    private String typeTitle;

    protected ActionBar mActionBar;


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_partition_more;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        Intent intent = getIntent();
        if (intent != null)
        {
            Bundle bundle = intent.getExtras();
            if (bundle != null)
            {
                PartitionMoreTitle mTitle = (PartitionMoreTitle) bundle.getSerializable("titles");
                typeTitle = bundle.getString("typeTitle");
                if (mTitle != null)
                {
                    titles = mTitle.titles;
                }
            }
        }


        mAdapter = new PartitionMorePagerAdapter(getSupportFragmentManager(), getApplicationContext(), titles);
        mTabPager.setAdapter(mAdapter);
        mSlidingTab.setViewPager(mTabPager);
    }

    @Override
    public void initToolBar()
    {

        try
        {
            setSupportActionBar(mToolbar);
        } catch (Exception e)
        {
            Log.e("setContentView", "Cannot find toolbar.");
        }
        mActionBar = getSupportActionBar();
        if (mActionBar != null)
        {
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setDisplayUseLogoEnabled(true);
            mActionBar.setDisplayShowTitleEnabled(false);
        }

        mToolbar.setNavigationIcon(R.drawable.action_button_back_pressed_light);
        mToolbar.setTitle(typeTitle);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
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
