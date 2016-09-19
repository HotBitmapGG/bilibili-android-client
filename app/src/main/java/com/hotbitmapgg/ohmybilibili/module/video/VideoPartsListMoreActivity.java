package com.hotbitmapgg.ohmybilibili.module.video;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.VideoPartListAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.entity.user.UserRecommend;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 视频详情查看更多
 */
public class VideoPartsListMoreActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    private List<UserRecommend.AuthorData> authorRecommendList = new ArrayList<>();

    private String aid;

    private static final String EXTRA_AV = "extra_av";


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_video_parts_list_more;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        Intent intent = getIntent();
        if (intent != null)
            aid = intent.getStringExtra("aid");


        startTask();
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setTitle("Up主推荐视频");
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

    private void startTask()
    {

        showProgressBar();
        getAuthorRecommendVideoList();
    }

    public void getAuthorRecommendVideoList()
    {

        RetrofitHelper.getAuthorRecommendedApi()
                .getAuthorRecommended(aid)
                .compose(this.<UserRecommend> bindToLifecycle())
                .map(new Func1<UserRecommend,List<UserRecommend.AuthorData>>()
                {

                    @Override
                    public List<UserRecommend.AuthorData> call(UserRecommend userRecommend)
                    {

                        return userRecommend.list;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<UserRecommend.AuthorData>>()
                {

                    @Override
                    public void call(List<UserRecommend.AuthorData> authorDatas)
                    {

                        authorRecommendList.addAll(authorDatas);
                        finishGetAuthorRecommendListTask();
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


    private void finishGetAuthorRecommendListTask()
    {

        VideoPartListAdapter mPartListAdapter = new VideoPartListAdapter(mRecyclerView, authorRecommendList);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(VideoPartsListMoreActivity.this, 2));
        mRecyclerView.setAdapter(mPartListAdapter);
        mPartListAdapter.setOnItemClickListener(new AbsRecyclerViewAdapter.OnItemClickListener()
        {

            @Override
            public void onItemClick(int position, AbsRecyclerViewAdapter.ClickableViewHolder holder)
            {

                UserRecommend.AuthorData authorData = authorRecommendList.get(position);
                int aid = authorData.aid;
                Intent mIntent = new Intent(VideoPartsListMoreActivity.this, VideoDetailsActivity.class);
                mIntent.putExtra(EXTRA_AV, aid);
                startActivity(mIntent);
            }
        });

        hideProgressBar();
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
