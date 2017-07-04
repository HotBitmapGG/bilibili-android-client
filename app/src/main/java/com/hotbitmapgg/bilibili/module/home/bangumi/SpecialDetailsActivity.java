package com.hotbitmapgg.bilibili.module.home.bangumi;

import android.annotation.SuppressLint;
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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.bilibili.adapter.SpecialVideoRecyclerAdapter;
import com.hotbitmapgg.bilibili.base.RxBaseActivity;
import com.hotbitmapgg.bilibili.entity.bangumi.SpecialTopic;
import com.hotbitmapgg.bilibili.entity.bangumi.SpecialTopicIResult;
import com.hotbitmapgg.bilibili.module.video.VideoDetailsActivity;
import com.hotbitmapgg.bilibili.utils.ConstantUtil;
import com.hotbitmapgg.bilibili.widget.CircleProgressView;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.bilibili.network.RetrofitHelper;

import java.util.ArrayList;

import butterknife.BindView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 专题详情界面
 */
public class SpecialDetailsActivity extends RxBaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.sp_preview)
    ImageView mPreviewImage;
    @BindView(R.id.sp_title)
    TextView mTitleText;
    @BindView(R.id.sp_last_update_at)
    TextView mLastUpdateText;
    @BindView(R.id.sp_desc)
    TextView mDescText;
    @BindView(R.id.tv_play_time)
    TextView mPlayTimeText;
    @BindView(R.id.tv_video_count)
    TextView mVideoCountText;
    @BindView(R.id.recycle)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_favourite)
    TextView mFavourite;
    @BindView(R.id.tv_attention)
    TextView mAttention;
    @BindView(R.id.circle_progress)
    CircleProgressView mCircleProgressView;
    @BindView(R.id.root_layout)
    LinearLayout mRootLayout;

    private int spid;
    private String title;
    private int season_id;
    private SpecialTopic mSpecialTopic;
    private ArrayList<SpecialTopic.Item> spList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_special_details;
    }


    @Override
    public void initViews(Bundle savedInstanceState) {
        Intent intent = getIntent();
        if (intent != null) {
            spid = Integer.parseInt(intent.getStringExtra(ConstantUtil.EXTRA_SPID));
            title = intent.getStringExtra(ConstantUtil.EXTRA_TITLE);
            season_id = intent.getIntExtra(ConstantUtil.EXTRA_SEASON_ID, 0);
        }
        loadData();
    }


    @Override
    public void initToolBar() {
        mToolbar.setTitle("专题详情");
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
        RetrofitHelper.getBiliAPI()
                .getSpInfo(spid, title)
                .compose(this.bindToLifecycle())
                .doOnSubscribe(this::showProgressBar)
                .flatMap(new Func1<SpecialTopic, Observable<SpecialTopicIResult>>() {
                    @Override
                    public Observable<SpecialTopicIResult> call(SpecialTopic specialTopic) {
                        mSpecialTopic = specialTopic;
                        return RetrofitHelper.getBiliAPI()
                                .getSpItemList(spid, season_id, 1);
                    }
                })
                .compose(bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(specialTopicIResult -> {
                    spList.addAll(specialTopicIResult.list);
                    finishTask();
                }, throwable -> {
                    hideProgressBar();
                });
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void finishTask() {
        hideProgressBar();
        mRootLayout.setVisibility(View.VISIBLE);
        // 专题名称
        String spTitle = mSpecialTopic.title;
        // 最后更新日期
        String lastupdate_at = mSpecialTopic.lastupdate_at;
        // 专题简介
        String description = mSpecialTopic.description;
        // 播放次数
        int playCount = mSpecialTopic.view;
        // 专题列表数量
        int count = mSpecialTopic.count;
        // 专题封面
        String cover = mSpecialTopic.cover;
        //收藏数量
        int favourite = mSpecialTopic.favourite;
        //关注数量
        int attention = mSpecialTopic.attention;
        // 初始化界面数据
        Glide.with(SpecialDetailsActivity.this)
                .load(cover)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into(mPreviewImage);
        mTitleText.setText(spTitle);
        mLastUpdateText.setText("最后更新日期:" + lastupdate_at);
        if (!TextUtils.isEmpty(description)) {
            mDescText.setText(description);
        } else {
            mDescText.setText("该专题没有任何介绍~");
        }
        mPlayTimeText.setText(String.valueOf(playCount));
        mVideoCountText.setText(count + "话");
        mFavourite.setText(String.valueOf(favourite));
        mAttention.setText(String.valueOf(attention));
        //设置专题视频
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setLayoutManager(new GridLayoutManager(SpecialDetailsActivity.this, 2));
        SpecialVideoRecyclerAdapter mAdapter = new SpecialVideoRecyclerAdapter(mRecyclerView, spList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((position, holder) -> {
            SpecialTopic.Item item = spList.get(position);
            VideoDetailsActivity.launch(SpecialDetailsActivity.this, item.aid, item.cover);
        });
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


    public static void launch(Activity activity, String spid, String title, int seasonId) {
        Intent mIntent = new Intent(activity, SpecialDetailsActivity.class);
        mIntent.putExtra(ConstantUtil.EXTRA_SPID, spid);
        mIntent.putExtra(ConstantUtil.EXTRA_TITLE, title);
        mIntent.putExtra(ConstantUtil.EXTRA_SEASON_ID, seasonId);
        activity.startActivity(mIntent);
    }
}
