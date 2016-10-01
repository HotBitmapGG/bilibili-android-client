package com.hotbitmapgg.ohmybilibili.module.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.UserFansAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.helper.EndlessRecyclerOnScrollListener;
import com.hotbitmapgg.ohmybilibili.adapter.helper.HeaderViewRecyclerAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.entity.user.UserFans;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;

import java.util.ArrayList;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 用户粉丝界面
 */
public class UserFansActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;


    private static final String EXTRA_MID = "mid";

    private static final String EXTRA_USERNAME = "userName";

    private String mid;

    private String userName;

    private ArrayList<UserFans.FansInfo> userfansList = new ArrayList<>();

    private HeaderViewRecyclerAdapter mAdapter;

    private int pageNum = 1;

    private int pageSize = 50;

    private View loadMoreView;


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_user_fans;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        Intent intent = getIntent();
        if (intent != null)
        {
            mid = intent.getStringExtra("mid");
            userName = intent.getStringExtra("userName");
        }


        showProgressBar();
        initRecyclerView();
        getFans();
    }

    private void initRecyclerView()
    {

        UserFansAdapter mRecyclerAdapter = new UserFansAdapter(mRecyclerView, userfansList);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mAdapter = new HeaderViewRecyclerAdapter(mRecyclerAdapter);
        mRecyclerView.setAdapter(mAdapter);
        createLoadMoreView();
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(mLinearLayoutManager)
        {

            @Override
            public void onLoadMore(int i)
            {

                pageNum++;
                getFans();
                loadMoreView.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setTitle(userName + "的粉丝");
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

    public void getFans()
    {

        RetrofitHelper.getUserFansApi()
                .getUserFans(mid, pageNum, pageSize)
                .compose(this.bindToLifecycle())
                .map(userFans -> userFans.list)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(fansInfos -> {

                    if (fansInfos.size() < pageSize)
                        loadMoreView.setVisibility(View.GONE);

                    userfansList.addAll(fansInfos);
                    finishTask();
                }, throwable -> {

                    loadMoreView.setVisibility(View.GONE);
                    hideProgressBar();
                });
    }

    private void finishTask()
    {

        hideProgressBar();
        loadMoreView.setVisibility(View.GONE);

        if (pageNum * pageSize - pageSize - 1 > 0)
            mAdapter.notifyItemRangeChanged(pageNum * pageSize - pageSize - 1, pageSize);
        else
            mAdapter.notifyDataSetChanged();
    }

    private void createLoadMoreView()
    {

        loadMoreView = LayoutInflater.from(UserFansActivity.this)
                .inflate(R.layout.layout_load_more, mRecyclerView, false);
        mAdapter.addFooterView(loadMoreView);
        loadMoreView.setVisibility(View.GONE);
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


    public static void launch(Activity activity, String mid, String userName)
    {

        Intent intent = new Intent(activity, UserFansActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(EXTRA_MID, mid);
        intent.putExtra(EXTRA_USERNAME, userName);
        activity.startActivity(intent);
    }
}
