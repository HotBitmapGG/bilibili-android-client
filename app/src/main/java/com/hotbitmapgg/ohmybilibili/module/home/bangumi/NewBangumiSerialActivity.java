package com.hotbitmapgg.ohmybilibili.module.home.bangumi;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.NewBangumiSerialAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.NewBangumiSerial;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 2016/9/25 15:41
 * 100332338@qq.com
 * <p>
 * 新番连载全部界面
 */

public class NewBangumiSerialActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    private List<NewBangumiSerial.ListBean> newBangumiSerials = new ArrayList<>();

    private NewBangumiSerialAdapter mAdapter;

    @Override
    public int getLayoutId()
    {

        return R.layout.activity_new_bangumi_serial;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        initRecyclerView();
        getAllNewBangumiSerial();
    }

    private void getAllNewBangumiSerial()
    {

        RetrofitHelper.getNewBangumiSerial()
                .getNewBangumiSerialList()
                .compose(this.<NewBangumiSerial> bindToLifecycle())
                .doOnSubscribe(new Action0()
                {

                    @Override
                    public void call()
                    {

                        showProgressBar();
                    }
                })
                .map(new Func1<NewBangumiSerial,List<NewBangumiSerial.ListBean>>()
                {

                    @Override
                    public List<NewBangumiSerial.ListBean> call(NewBangumiSerial newBangumiSerial)
                    {

                        return newBangumiSerial.getList();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<NewBangumiSerial.ListBean>>()
                {

                    @Override
                    public void call(List<NewBangumiSerial.ListBean> listBeans)
                    {

                        newBangumiSerials.addAll(listBeans);
                        finishTask();
                    }
                }, new Action1<Throwable>()
                {

                    @Override
                    public void call(Throwable throwable)
                    {

                        hideProgressBar();
                    }
                });
    }

    private void finishTask()
    {

        hideProgressBar();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setTitle("全部新番连载");
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


    private void initRecyclerView()
    {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(NewBangumiSerialActivity.this, 3));
        mAdapter = new NewBangumiSerialAdapter(mRecyclerView, newBangumiSerials, true);
        mRecyclerView.setAdapter(mAdapter);
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
