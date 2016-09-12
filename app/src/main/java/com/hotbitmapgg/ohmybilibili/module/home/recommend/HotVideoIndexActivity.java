package com.hotbitmapgg.ohmybilibili.module.home.recommend;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.entity.index.Index;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/7 14:12
 * 100332338@qq.com
 * <p/>
 * 9个热门视频排行榜界面 从首页排行榜按钮进入
 */
public class HotVideoIndexActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTabLayout;

    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    List<Index.FuckList> indexs = new ArrayList<>();

    private Index mTypeIndex;

    public static final int TYPE_CARTOON = 1, TYPE_MUSIC = 3,
            TYPE_GAME = 4, TYPE_ENTERTAINMENT = 5,
            TYPE_TV_SERIES = 11, TYPE_ANIME = 13,
            TYPE_MOVIE = 23, TYPE_TECHNOLOGY = 36,
            TYPE_DANCE = 129, TYPE_FUNNY = 119;

    @Override
    public int getLayoutId()
    {

        return R.layout.activity_hot_video_index;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        getIndexVideos();
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setTitle("热门视频排行榜");
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    public void getIndexVideos()
    {

        RetrofitHelper.getIndexApi()
                .getIndex("android")
                .compose(this.<Index> bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0()
                {

                    @Override
                    public void call()
                    {

                        mCircleProgressView.setVisibility(View.VISIBLE);
                        mCircleProgressView.spin();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Index>()
                {

                    @Override
                    public void call(Index index)
                    {

                        mTypeIndex = index;
                        finishTask();
                    }
                }, new Action1<Throwable>()
                {

                    @Override
                    public void call(Throwable throwable)
                    {

                        mCircleProgressView.setVisibility(View.GONE);
                        mCircleProgressView.stopSpinning();
                    }
                });
    }


    private void finishTask()
    {

        if (mTypeIndex != null)
        {
            indexs.add(mTypeIndex.typeAnime);
            indexs.add(mTypeIndex.typeCartoon);
            indexs.add(mTypeIndex.typeMusic);
            indexs.add(mTypeIndex.typeDance);
            indexs.add(mTypeIndex.typeEntertainment);
            indexs.add(mTypeIndex.typeFunny);
            indexs.add(mTypeIndex.typeGame);
            indexs.add(mTypeIndex.typeMovie);
            indexs.add(mTypeIndex.typeTechnology);
            indexs.add(mTypeIndex.typeTvSeries);


            HotVideoIndexPagerAdapter mAdapter =
                    new HotVideoIndexPagerAdapter(getSupportFragmentManager(), indexs);
            mViewPager.setAdapter(mAdapter);
            mSlidingTabLayout.setViewPager(mViewPager);
        }

        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
    }


    private static class HotVideoIndexPagerAdapter extends FragmentStatePagerAdapter
    {

        private List<Index.FuckList> indexs = new ArrayList<>();

        private String[] titles = new String[]{
                "番剧", "动画", "音乐", "舞蹈", "娱乐",
                "鬼畜", "游戏", "电影", "科技", "电视剧"
        };

        public HotVideoIndexPagerAdapter(FragmentManager fm, List<Index.FuckList> indexs)
        {

            super(fm);
            this.indexs = indexs;
        }

        @Override
        public Fragment getItem(int position)
        {

            return HotVideoIndexDetailsFragment
                    .newInstance(indexs.get(position));
        }

        @Override
        public int getCount()
        {

            return indexs.size();
        }

        @Override
        public CharSequence getPageTitle(int position)
        {

            return titles[position];
        }
    }
}
