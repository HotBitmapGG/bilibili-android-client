package com.hotbitmapgg.ohmybilibili.module.bangumi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.SpecialVideoRecyclerAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.entity.video.Sp;
import com.hotbitmapgg.ohmybilibili.entity.video.SpItemResult;
import com.hotbitmapgg.ohmybilibili.module.video.VideoDetailsActivity;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 专题详情界面(二三次元番剧进入)
 */
public class SpecialDetailsActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.sp_preview)
    ImageView mPreviewImage;

    @Bind(R.id.sp_title)
    TextView mTitleText;

    @Bind(R.id.sp_last_update_at)
    TextView mLastUpdateText;

    @Bind(R.id.sp_desc)
    TextView mDescText;

    @Bind(R.id.tv_play_time)
    TextView mPlayTimeText;

    @Bind(R.id.tv_video_count)
    TextView mVideoCountText;

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.tv_favourite)
    TextView mFavourite;

    @Bind(R.id.tv_attention)
    TextView mAttention;

    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    @Bind(R.id.root_layout)
    LinearLayout mRootLayout;

    private int spid;

    private String title;

    private Sp mSp;

    private int season_id;

    private static final String EXTRA_SPID = "spid";

    private static final String EXTRA_TITLE = "title";

    private static final String EXTRA_SEASON_ID = "season_id";

    private ArrayList<Sp.Item> spList = new ArrayList<Sp.Item>();


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_special_details;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        Intent intent = getIntent();
        if (intent != null)
        {
            spid = Integer.parseInt(intent.getStringExtra(EXTRA_SPID));
            title = intent.getStringExtra(EXTRA_TITLE);
            season_id = intent.getIntExtra(EXTRA_SEASON_ID, 0);
        }


        startGetSpInfoTask();
    }

    @Override
    public void initToolBar()
    {

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

    private void startGetSpInfoTask()
    {

        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();

        getSpInfo();
    }

    public void getSpInfo()
    {

        RetrofitHelper.getSpInfoApi()
                .getSpInfo(spid, title)
                .compose(this.<Sp> bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Sp>()
                {

                    @Override
                    public void call(Sp sp)
                    {

                        mSp = sp;
                        finishGetSpInfo();
                    }
                }, new Action1<Throwable>()
                {

                    @Override
                    public void call(Throwable throwable)
                    {

                        LogUtil.all("专题数据获取失败" + throwable.getMessage());
                        mCircleProgressView.setVisibility(View.GONE);
                        mCircleProgressView.stopSpinning();
                    }
                });
    }


    /**
     * bangumi 设置为1时只返回番剧类视频
     * <p/>
     * 设置为0时只返回普通视频 不设置则返回所有视频
     */
    private void getSpVideo()
    {

        RetrofitHelper.getSpItemApi()
                .getSpItemList(spid, season_id, 1)
                .compose(this.<SpItemResult> bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<SpItemResult>()
                {

                    @Override
                    public void call(SpItemResult spItemResult)
                    {

                        spList.addAll(spItemResult.list);
                        finishGetSpVideoListTask();
                    }
                }, new Action1<Throwable>()
                {

                    @Override
                    public void call(Throwable throwable)
                    {

                        LogUtil.all("获取专题视频列表失败" + throwable.getMessage());
                        mCircleProgressView.setVisibility(View.GONE);
                        mCircleProgressView.stopSpinning();
                    }
                });
    }

    public void finishGetSpInfo()
    {
        // 专题名称
        String spTitle = mSp.title;
        // 最后更新日期
        String lastupdate_at = mSp.lastupdate_at;
        // 专题简介
        String description = mSp.description;
        // 播放次数
        int playCount = mSp.view;
        // 专题列表数量
        int count = mSp.count;
        // 专题封面
        String cover = mSp.cover;
        //收藏数量
        int favourite = mSp.favourite;
        //关注数量
        int attention = mSp.attention;

        // 初始化界面数据
        Picasso.with(this).load(cover).placeholder(R.drawable.bili_default_image_tv).into(mPreviewImage);
        mTitleText.setText(spTitle);
        mLastUpdateText.setText("最后更新日期:" + lastupdate_at);
        if (!TextUtils.isEmpty(description))
        {
            mDescText.setText(description);
        } else
        {
            mDescText.setText("该专题没有任何介绍~");
        }

        mPlayTimeText.setText(String.valueOf(playCount));
        mVideoCountText.setText(count + "话");
        mToolbar.setTitle(spTitle);
        mFavourite.setText(String.valueOf(favourite));
        mAttention.setText(String.valueOf(attention));

        getSpVideo();
    }


    public void finishGetSpVideoListTask()
    {

        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
        mRootLayout.setVisibility(View.VISIBLE);

        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setLayoutManager(new GridLayoutManager(SpecialDetailsActivity.this, 2));
        SpecialVideoRecyclerAdapter mAdapter = new SpecialVideoRecyclerAdapter(mRecyclerView, spList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new AbsRecyclerViewAdapter.OnItemClickListener()
        {

            @Override
            public void onItemClick(int position, AbsRecyclerViewAdapter.ClickableViewHolder holder)
            {

                Sp.Item item = spList.get(position);
                VideoDetailsActivity.launch(SpecialDetailsActivity.this, item.aid);
            }
        });
    }


    public static void launch(Activity activity, String spid, String title, int seasonId)
    {

        Intent mIntent = new Intent(activity, SpecialDetailsActivity.class);
        mIntent.putExtra(EXTRA_SPID, spid);
        mIntent.putExtra(EXTRA_TITLE, title);
        mIntent.putExtra(EXTRA_SEASON_ID, seasonId);
        activity.startActivity(mIntent);
    }
}
