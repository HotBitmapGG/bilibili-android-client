package com.hotbitmapgg.bilibili.module.home.bangumi;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.hotbitmapgg.bilibili.base.RxBaseActivity;
import com.hotbitmapgg.bilibili.widget.CircleProgressView;
import com.hotbitmapgg.bilibili.widget.sectioned.SectionedRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.bilibili.adapter.section.SeasonNewBangumiSection;
import com.hotbitmapgg.bilibili.entity.bangumi.SeasonNewBangumiInfo;
import com.hotbitmapgg.bilibili.network.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 2016/9/25 15:08
 * 100332338@qq.com
 * <p>
 * 更多新番列表界面
 */

public class SeasonNewBangumiActivity extends RxBaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.recycle)
    RecyclerView mRecyclerView;
    @BindView(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    private SectionedRecyclerViewAdapter mSectionedRecyclerViewAdapter;
    private List<SeasonNewBangumiInfo.ResultBean> results = new ArrayList<>();


    @Override
    public int getLayoutId() {
        return R.layout.activity_season_new_bangumi;
    }


    @Override
    public void initViews(Bundle savedInstanceState) {
        initRecyclerView();
        loadData();
    }


    @Override
    public void loadData() {
        RetrofitHelper.getBangumiAPI()
                .getSeasonNewBangumiList()
                .compose(bindToLifecycle())
                .doOnSubscribe(this::showProgressBar)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(seasonNewBangumiInfo -> {
                    results.addAll(seasonNewBangumiInfo.getResult().subList(0,50));
                    finishTask();
                }, throwable -> hideProgressBar());
    }


    @Override
    public void finishTask() {
        Observable.from(results)
                .compose(bindToLifecycle())
                .forEach(resultBean -> mSectionedRecyclerViewAdapter.addSection(
                        new SeasonNewBangumiSection(SeasonNewBangumiActivity.this,
                                resultBean.getSeason(), resultBean.getYear(), resultBean.getList())));
        mSectionedRecyclerViewAdapter.notifyDataSetChanged();
        hideProgressBar();
    }


    @Override
    public void initRecyclerView() {
        mSectionedRecyclerViewAdapter = new SectionedRecyclerViewAdapter();
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(SeasonNewBangumiActivity.this, 3);
        mGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (mSectionedRecyclerViewAdapter.getSectionItemViewType(position)) {
                    case SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER:
                        return 3;
                    default:
                        return 1;
                }
            }
        });
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(true);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mRecyclerView.setAdapter(mSectionedRecyclerViewAdapter);
    }


    @Override
    public void initToolBar() {
        mToolbar.setTitle("分季全部新番");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showProgressBar() {
        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();
    }


    @Override
    public void hideProgressBar() {
        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
    }
}
