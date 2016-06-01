package com.hotbitmapgg.ohmybilibili.activity;

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
import com.hotbitmapgg.ohmybilibili.api.SpApi;
import com.hotbitmapgg.ohmybilibili.base.AbsBaseActivity;
import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.Sp;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.hotbitmapgg.ohmybilibili.widget.ExpandableHeightGridView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import butterknife.Bind;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 专题视频详情界面
 *
 * @HotBitmapGG
 */
public class SpecialDetailsActivity extends AbsBaseActivity
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

    private Sp sp;

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

        Single<BasicMessage<Sp>> observable = Single.fromCallable(new Callable<BasicMessage<Sp>>()
        {

            @Override
            public BasicMessage<Sp> call() throws Exception
            {

                return SpApi.getSpInfo(spid, title);
            }
        });

        Subscription subscribe = observable.map(new Func1<BasicMessage<Sp>,Sp>()
                {

                    @Override
                    public Sp call(BasicMessage<Sp> spBasicMessage)
                    {

                        return spBasicMessage.getObject();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<Sp>()
                {

                    @Override
                    public void onSuccess(Sp value)
                    {

                        sp = value;
                        finishGetSpInfo();
                    }

                    @Override
                    public void onError(Throwable error)
                    {

                    }
                });

        compositeSubscription.add(subscribe);
    }


    /**
     * bangumi 设置为1时只返回番剧类视频
     * <p/>
     * 设置为0时只返回普通视频 不设置则返回所有视频
     */
    private void getSpVideo()
    {

        Single<BasicMessage<ArrayList<Sp.Item>>> observable = Single.fromCallable(new Callable<BasicMessage<ArrayList<Sp.Item>>>()
        {

            @Override
            public BasicMessage<ArrayList<Sp.Item>> call() throws Exception
            {

                return SpApi.getSpItem(spid, season_id, 1);
            }
        });

        Subscription subscribe = observable
                .map(new Func1<BasicMessage<ArrayList<Sp.Item>>,ArrayList<Sp.Item>>()
                {

                    @Override
                    public ArrayList<Sp.Item> call(BasicMessage<ArrayList<Sp.Item>> arrayListBasicMessage)
                    {

                        return arrayListBasicMessage.getObject();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<ArrayList<Sp.Item>>()
                {

                    @Override
                    public void onSuccess(ArrayList<Sp.Item> value)
                    {

                        if (value != null && value.size() > 0)
                        {
                            spList.addAll(value);
                            finishGetSpVideoListTask();
                        }
                    }

                    @Override
                    public void onError(Throwable error)
                    {

                        LogUtil.lsw("专题数据加载失败");
                    }
                });

        compositeSubscription.add(subscribe);
    }

    public void finishGetSpInfo()
    {
        // 专题名称
        String spTitle = sp.title;
        // 最后更新日期
        String lastupdate_at = sp.lastupdate_at;
        // 专题简介
        String description = sp.description;
        // 播放次数
        int playCount = sp.view;
        // 专题列表数量
        int count = sp.count;
        // 专题封面
        String cover = sp.cover;
        //收藏数量
        int favourite = sp.favourite;
        //关注数量
        int attention = sp.attention;

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
