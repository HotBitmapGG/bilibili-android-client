package com.hotbitmapgg.ohmybilibili.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.fragment.VideoCommentFragment;
import com.hotbitmapgg.ohmybilibili.fragment.VideoHotCommentFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/3/27.
 */
public class VideoCommentActivity extends AppCompatActivity
{

    private Toolbar mToolbar;

    private ActionBar mActionBar;

    private ViewPager mTabPager;

    private SlidingTabLayout mSlidingTab;

    private String[] titles = new String[]{"热门评论", "最新评论"};

    private List<Fragment> fragments = new ArrayList<>();

    private int aid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if(intent != null)
        {
           aid = intent.getIntExtra("aid" , 0);
        }
        setContentView(R.layout.activity_video_comment);

        initTitle();
        initView();
    }

    private void initView()
    {

        mTabPager = (ViewPager) findViewById(R.id.comment_tab_pager);
        mSlidingTab = (com.flyco.tablayout.SlidingTabLayout) findViewById(R.id.comment_sliding_tabs);

        VideoHotCommentFragment mVideoHotCommentFragment = VideoHotCommentFragment.newInstance(aid);
        VideoCommentFragment mVideoCommentFragment = VideoCommentFragment.newInstance(aid);
        fragments.add(mVideoHotCommentFragment);
        fragments.add(mVideoCommentFragment);


        CommentPagerAdapter mAdapter = new CommentPagerAdapter(getFragmentManager());

        mTabPager.setAdapter(mAdapter);
        mTabPager.setOffscreenPageLimit(2);
        mSlidingTab.setViewPager(mTabPager);
    }

    private void initTitle()
    {

        try
        {
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
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
        mToolbar.setTitle("评论");
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


    public class CommentPagerAdapter extends FragmentPagerAdapter
    {

        public CommentPagerAdapter(FragmentManager fm)
        {

            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {

            return fragments.get(position);
        }

        @Override
        public int getCount()
        {

            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position)
        {

            return titles[position];
        }
    }
}
