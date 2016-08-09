package com.hotbitmapgg.ohmybilibili.module.video;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.SpItemAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.entity.video.Sp;
import com.hotbitmapgg.ohmybilibili.entity.video.SpItemResult;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.hotbitmapgg.ohmybilibili.widget.ExpandableHeightGridView;
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
 * 专题详情界面
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

    @Bind(R.id.sp_video_list)
    ExpandableHeightGridView mSpVideoList;

    @Bind(R.id.tv_desc_more)
    TextView mDescMore;

    @Bind(R.id.tv_favourite)
    TextView mFavourite;

    @Bind(R.id.tv_attention)
    TextView mAttention;

    @Bind(R.id.sp_circle_progress)
    CircleProgressView mCircleProgressView;

    @Bind(R.id.sp_main)
    LinearLayout mSpMainLayout;

    private int spid;

    private String title;

    private Sp mSp;

    private int season_id;

    private ArrayList<Sp.Item> spList = new ArrayList<Sp.Item>();

    private SpItemAdapter mItemAdapter;


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
            String spidStr = intent.getStringExtra("spid");
            spid = Integer.parseInt(spidStr);
            title = intent.getStringExtra("title");
            season_id = intent.getIntExtra("season_id", 0);
        }


        startGetSpInfoTask();
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setNavigationIcon(R.drawable.action_button_back_pressed_light);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                finish();
            }
        });
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
            mDescMore.setVisibility(View.GONE);
        }

        mPlayTimeText.setText(playCount + "");
        mVideoCountText.setText(count + "话");
        mToolbar.setTitle(spTitle);
        mFavourite.setText(favourite + "");
        mAttention.setText(attention + "");

        mDescMore.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                mDescText.setEllipsize(null);
                mDescText.setSingleLine(false);
                mDescMore.setVisibility(View.GONE);
            }
        });

        getSpVideo();
    }


    public void finishGetSpVideoListTask()
    {

        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
        mSpMainLayout.setVisibility(View.VISIBLE);
        mItemAdapter = new SpItemAdapter(SpecialDetailsActivity.this, spList);
        mSpVideoList.setAdapter(mItemAdapter);
        mSpVideoList.setExpanded(true);
        mSpVideoList.setOnItemClickListener(new OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                Sp.Item mItem = (Sp.Item) mItemAdapter.getItem(position);
                int aid = mItem.aid;
                VideoDetailsActivity.launch(SpecialDetailsActivity.this, aid);
            }
        });
    }
}
