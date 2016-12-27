package com.hotbitmapgg.bilibili.module.home.bangumi;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.hotbitmapgg.bilibili.adapter.ChaseBangumiAdapter;
import com.hotbitmapgg.bilibili.base.RxBaseActivity;
import com.hotbitmapgg.bilibili.entity.user.UserChaseBangumiInfo;
import com.hotbitmapgg.bilibili.widget.CircleProgressView;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.bilibili.network.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 2016/10/14 13:21
 * 100332338@qq.com
 * <p>
 * 追番界面
 */

public class ChaseBangumiActivity extends RxBaseActivity {

  @BindView(R.id.toolbar)
  Toolbar mToolbar;

  @BindView(R.id.recycle)
  RecyclerView mRecyclerView;

  @BindView(R.id.circle_progress)
  CircleProgressView mCircleProgressView;

  private static final int MID = 9467159;

  private List<UserChaseBangumiInfo.DataBean.ResultBean> chaseBangumis = new ArrayList<>();

  private ChaseBangumiAdapter mAdapter;


  @Override
  public int getLayoutId() {

    return R.layout.activity_chase_bangumi;
  }


  @Override
  public void initViews(Bundle savedInstanceState) {

    initRecyclerView();
    loadData();
  }


  @Override
  public void loadData() {

    RetrofitHelper.getUserAPI()
        .getUserChaseBangumis(MID)
        .compose(bindToLifecycle())
        .doOnSubscribe(this::showProgressBar)
        .map(userChaseBangumiInfo -> userChaseBangumiInfo.getData().getResult())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(resultBeans -> {

          chaseBangumis.addAll(resultBeans);
          finishTask();
        }, throwable -> {

        });
  }


  @Override
  public void initRecyclerView() {

    mRecyclerView.setHasFixedSize(true);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(ChaseBangumiActivity.this));
    mAdapter = new ChaseBangumiAdapter(mRecyclerView, chaseBangumis);
    mRecyclerView.setAdapter(mAdapter);
  }


  @Override
  public void finishTask() {

    hideProgressBar();
    mAdapter.notifyDataSetChanged();
  }


  @Override
  public void initToolBar() {

    mToolbar.setTitle("追番");
    setSupportActionBar(mToolbar);
    ActionBar mActionBar = getSupportActionBar();
    if (mActionBar != null) {
      mActionBar.setDisplayHomeAsUpEnabled(true);
    }
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {

    getMenuInflater().inflate(R.menu.menu_chase_bangumi, menu);
    return true;
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
