package com.hotbitmapgg.ohmybilibili.module.home.bangumi;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.SeasonNewBangumiAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.helper.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.SeasonNewBangumi;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 2016/9/25 15:08
 * 100332338@qq.com
 * <p>
 * 更多新番列表界面
 */

public class SeasonNewBangumiActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    private List<SeasonNewBangumi.ListBean> seasonNewBangumis = new ArrayList<>();

    private SeasonNewBangumiAdapter mAdapter;

    @Override
    public int getLayoutId()
    {

        return R.layout.activity_season_new_bangumi;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        initRecyclerView();
        getAllNewBangumis();
    }

    private void getAllNewBangumis()
    {

        RetrofitHelper.getSeasonNewBangumiApi()
                .getSeasonNewBangumiList()
                .compose(this.bindToLifecycle())
                .doOnSubscribe(this::showProgressBar)
                .map(SeasonNewBangumi::getList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listBeans -> {

                    seasonNewBangumis.addAll(listBeans);
                    finishTask();
                }, throwable -> {

                    hideProgressBar();
                });
    }

    private void finishTask()
    {

        mAdapter.notifyDataSetChanged();
        hideProgressBar();
    }

    private void initRecyclerView()
    {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(SeasonNewBangumiActivity.this, 3));
        mAdapter = new SeasonNewBangumiAdapter(mRecyclerView, seasonNewBangumis, true);
        mAdapter.setOnItemClickListener(new AbsRecyclerViewAdapter.OnItemClickListener()
        {

            @Override
            public void onItemClick(int position, AbsRecyclerViewAdapter.ClickableViewHolder holder)
            {

            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setTitle("分季全部新番");
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

    public void showProgressBar()
    {

        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();
    }

    public void hideProgressBar()
    {

        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
    }
}
