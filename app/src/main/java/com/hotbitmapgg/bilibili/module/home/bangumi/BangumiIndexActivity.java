package com.hotbitmapgg.bilibili.module.home.bangumi;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.hotbitmapgg.bilibili.adapter.BangumiIndexAdapter;
import com.hotbitmapgg.bilibili.adapter.helper.HeaderViewRecyclerAdapter;
import com.hotbitmapgg.bilibili.base.RxBaseActivity;
import com.hotbitmapgg.bilibili.entity.bangumi.BangumiIndexInfo;
import com.hotbitmapgg.bilibili.network.RetrofitHelper;
import com.hotbitmapgg.bilibili.widget.CircleProgressView;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 番剧索引界面
 */
public class BangumiIndexActivity extends RxBaseActivity {
  @BindView(R.id.recycle)
  RecyclerView mRecyclerView;
  @BindView(R.id.toolbar)
  Toolbar mToolbar;
  @BindView(R.id.circle_progress)
  CircleProgressView mCircleProgressView;

  private GridLayoutManager mGridLayoutManager;
  private HeaderViewRecyclerAdapter mHeaderViewRecyclerAdapter;
  private List<BangumiIndexInfo.ResultBean.CategoryBean> categorys = new ArrayList<>();

  @Override
  public int getLayoutId() {
    return R.layout.activity_bangumi_index;
  }

  @Override
  public void initViews(Bundle savedInstanceState) {
    loadData();
  }


  @Override
  public void initRecyclerView() {
    mRecyclerView.setHasFixedSize(true);
    mGridLayoutManager = new GridLayoutManager(BangumiIndexActivity.this, 3);
    mGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
      @Override
      public int getSpanSize(int position) {
        return (0 == position) ? mGridLayoutManager.getSpanCount() : 1;
      }
    });
    mRecyclerView.setLayoutManager(mGridLayoutManager);
    BangumiIndexAdapter mAdapter = new BangumiIndexAdapter(mRecyclerView, categorys);
    mHeaderViewRecyclerAdapter = new HeaderViewRecyclerAdapter(mAdapter);
    createHeadLayout();
    mRecyclerView.setAdapter(mHeaderViewRecyclerAdapter);
  }


  @Override
  public void initToolBar() {
    mToolbar.setTitle("番剧索引");
    setSupportActionBar(mToolbar);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
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
  public void loadData() {
    RetrofitHelper.getBangumiAPI()
        .getBangumiIndex()
        .compose(this.bindToLifecycle())
        .doOnSubscribe(this::showProgressBar)
        .subscribeOn(Schedulers.io())
        .delay(2000, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(bangumiIndexInfo -> {
          categorys.addAll(bangumiIndexInfo.getResult().getCategory());
          finishTask();
        }, throwable -> hideProgressBar());
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


  @Override
  public void finishTask() {
    initRecyclerView();
    hideProgressBar();
  }


  private void createHeadLayout() {
    View headView = LayoutInflater.from(this).inflate(R.layout.layout_bangumi_index_head, mRecyclerView, false);
    mHeaderViewRecyclerAdapter.addHeaderView(headView);
  }
}
