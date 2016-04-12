package com.hotbitmapgg.ohmybilibili.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.PartitionMorePagerAdapter;
import com.hotbitmapgg.ohmybilibili.api.PartitionMoreApi;
import com.hotbitmapgg.ohmybilibili.model.PartitionMoreList;
import com.hotbitmapgg.ohmybilibili.model.PartitionMoreTitle;
import com.hotbitmapgg.ohmybilibili.model.PartitionMoreType;
import com.hotbitmapgg.ohmybilibili.okhttp.OkHttpClientManager;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.squareup.okhttp.Request;
import com.ypy.eventbus.EventBus;

import java.util.List;

public class PartitionMoreActivity extends AppCompatActivity
{

    private ViewPager mTabPager;

    private SlidingTabLayout mSlidingTab;

    private PartitionMoreList mIndexData;

    private PartitionMorePagerAdapter mAdapter;

    private List<PartitionMoreType> titles;

    private String typeTitle;

    protected Toolbar mToolbar;

    protected ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

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


        setContentView(R.layout.activity_partition_more);
        initView();
    }


    private void initView()
    {

        try
        {
            mToolbar = (Toolbar) findViewById(R.id.more_toolbar);
            setSupportActionBar(mToolbar);
        } catch (Exception e)
        {
            Log.e("setContentView", "Cannot find toolbar.");
        }
        mActionBar = getSupportActionBar();

        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setDisplayUseLogoEnabled(true);
        mActionBar.setDisplayShowTitleEnabled(false);

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


        mTabPager = (ViewPager) findViewById(R.id.bangumi_more_tab_pager);
        mSlidingTab = (com.flyco.tablayout.SlidingTabLayout) findViewById(R.id.bangumi_more_sliding_tabs);

        mAdapter = new PartitionMorePagerAdapter(getFragmentManager(), getApplicationContext(), titles);
        mTabPager.setAdapter(mAdapter);
        mSlidingTab.setViewPager(mTabPager);
        mTabPager.addOnPageChangeListener(new OnPageChangeListener()
        {

            @Override
            public void onPageSelected(int position)
            {

                int titleType = titles.get(position).getTitleType();
                getBangumiMoreList(titleType + "", (position + 1) + "");
                Bundle mBundle = new Bundle();
                mBundle.putString("tid", titleType + "");
                EventBus.getDefault().post(mBundle);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0)
            {
                // TODO Auto-generated method stub

            }
        });

        startGetBangumiMoreTask();
    }

    private void startGetBangumiMoreTask()
    {

        getBangumiMoreList(titles.get(0).getTitleType() + "", "1");
    }

    private void finishGetBangumiMoreTask()
    {

        mAdapter.notifyIndexDataUpdateAll(mIndexData);
    }

    public void getBangumiMoreList(String tid, String pagenum)
    {

        String url = PartitionMoreApi.getListUrl(tid, pagenum, "10", PartitionMoreApi.ORDER_DEFAULT);
        LogUtil.lsw(url);
        OkHttpClientManager.getAsyn(url, new OkHttpClientManager.ResultCallback<String>()
        {

            @Override
            public void onError(Request request, Exception e)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void onResponse(String response)
            {

                PartitionMoreList bangumiMoreList = PartitionMoreList.createFromJson(response);
                if (bangumiMoreList.lists != null && bangumiMoreList.lists.size() > 0)
                {
                    mIndexData = bangumiMoreList;
                }

                finishGetBangumiMoreTask();
            }
        });
    }

    public PartitionMoreList getIndexData()
    {

        return this.mIndexData;
    }
}
