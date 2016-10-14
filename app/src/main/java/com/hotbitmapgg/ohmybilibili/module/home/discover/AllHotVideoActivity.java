package com.hotbitmapgg.ohmybilibili.module.home.discover;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.section.AllHotVideoItemSection;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.entity.discover.AllHotVideoInfo;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.ToastUtil;
import com.hotbitmapgg.ohmybilibili.widget.sectioned.SectionedRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/9/12 20:19
 * 100332338@qq.com
 * <p/>
 * 全区热门视频排行榜界面
 */
public class AllHotVideoActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private List<AllHotVideoInfo> allRankList = new ArrayList<>();

    private SectionedRecyclerViewAdapter mSectionedAdapter;

    private int[] icons = new int[]{
            R.drawable.ic_category_t1,
            R.drawable.ic_category_t13,
            R.drawable.ic_category_t3,
            R.drawable.ic_category_t129,
            R.drawable.ic_category_t5,
            R.drawable.ic_category_t4,
            R.drawable.ic_category_t119,
            R.drawable.ic_category_t36,
            };


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_all_hot_video;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        showProgressBar();
        initRecyclerView();
    }

    private void showProgressBar()
    {

        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.post(() -> {

            mSwipeRefreshLayout.setRefreshing(true);
            getAllHotVideos();
        });
        mSwipeRefreshLayout.setOnRefreshListener(() -> mSwipeRefreshLayout.setRefreshing(false));
    }

    private void initRecyclerView()
    {

        mSectionedAdapter = new SectionedRecyclerViewAdapter();
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(AllHotVideoActivity.this, 2);
        mGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup()
        {

            @Override
            public int getSpanSize(int position)
            {

                switch (mSectionedAdapter.getSectionItemViewType(position))
                {
                    case SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER:
                        return 2;

                    default:
                        return 1;
                }
            }
        });

        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mRecyclerView.setAdapter(mSectionedAdapter);
    }

    private void getAllHotVideos()
    {

        RetrofitHelper.getAllHotVideoApi()
                .getAllRankInfos()
                .compose(this.bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(allRankInfos -> {

                    allRankList.addAll(allRankInfos);
                    finishTask();
                }, throwable -> {

                    mSwipeRefreshLayout.setRefreshing(false);
                    ToastUtil.ShortToast("加载失败啦,请重新加载~");
                });
    }

    private void finishTask()
    {

        mSwipeRefreshLayout.setRefreshing(false);
        for (int i = 0; i < allRankList.size(); i++)
        {
            mSectionedAdapter.addSection(new AllHotVideoItemSection(AllHotVideoActivity.this,
                    allRankList.get(i).getVideos(),
                    allRankList.get(i).getSortName(),
                    icons[i]));
        }
        mSectionedAdapter.notifyDataSetChanged();
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setTitle("全区热门视频");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
