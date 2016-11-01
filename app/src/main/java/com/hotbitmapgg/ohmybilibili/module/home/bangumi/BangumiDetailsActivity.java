package com.hotbitmapgg.ohmybilibili.module.home.bangumi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.BangumiDetailsRecommendAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.BangumiDetailsSelectionAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxBaseActivity;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiDetailsInfo;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiDetailsRecommendInfo;
import com.hotbitmapgg.ohmybilibili.module.video.VideoDetailsActivity;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.ConstantUtil;
import com.hotbitmapgg.ohmybilibili.utils.NumberUtil;
import com.hotbitmapgg.ohmybilibili.utils.SystemBarHelper;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jp.wasabeef.glide.transformations.BlurTransformation;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/14 17:51
 * 100332338@qq.com
 * <p/>
 * 番剧详情界面
 */
public class BangumiDetailsActivity extends RxBaseActivity
{

    @BindView(R.id.nested_scroll_view)
    NestedScrollView mNestedScrollView;

    @BindView(R.id.bangumi_bg)
    ImageView mBangumiBackgroundImage;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.bangumi_pic)
    ImageView mBangumiPic;

    @BindView(R.id.bangumi_details_layout)
    LinearLayout mDetailsLayout;

    @BindView(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    @BindView(R.id.bangumi_title)
    TextView mBangumiTitle;

    @BindView(R.id.bangumi_update)
    TextView mBangumiUpdate;

    @BindView(R.id.bangumi_play)
    TextView mBangumiPlay;

    @BindView(R.id.bangumi_selection_recycler)
    RecyclerView mBangumiSelectionRecycler;

    @BindView(R.id.tags_layout)
    TagFlowLayout mTagsLayout;

    @BindView(R.id.bangumi_details_introduction)
    TextView mBangumiIntroduction;

//    @Bind(R.id.bangumi_comment_recycler)
//    RecyclerView mBangumiCommentRecycler;

    @BindView(R.id.bangumi_recommend_recycler)
    RecyclerView mBangumiRecommendRecycler;

    private int seasonId;

    private BangumiDetailsInfo.ResultBean result;

    private List<BangumiDetailsRecommendInfo.ResultBean.ListBean> bangumiRecommends = new ArrayList<>();

    @Override
    public int getLayoutId()
    {

        return R.layout.activity_bangumi_details;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        Intent intent = getIntent();
        if (intent != null)
        {
            seasonId = intent.getIntExtra(ConstantUtil.EXTRA_BANGUMI_KEY, 0);
        }

        loadData();
    }


    @Override
    public void loadData()
    {

        RetrofitHelper.getBangumiDetailsApi()
                .getBangumiDetails()
                .compose(bindToLifecycle())
                .doOnSubscribe(this::showProgressBar)
                .flatMap(new Func1<BangumiDetailsInfo,Observable<BangumiDetailsRecommendInfo>>()
                {

                    @Override
                    public Observable<BangumiDetailsRecommendInfo> call(BangumiDetailsInfo bangumiDetailsInfo)
                    {

                        result = bangumiDetailsInfo.getResult();
                        return RetrofitHelper.getBangumiDetailsRecommendApi().getBangumiDetailsRecommend();
                    }
                })
                .compose(bindToLifecycle())
                .map(bangumiDetailsRecommendInfo -> bangumiDetailsRecommendInfo.getResult().getList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listBeans -> {

                    bangumiRecommends.addAll(listBeans);
                    finishTask();
                }, throwable -> {

                    hideProgressBar();
                });
    }

    @Override
    public void finishTask()
    {

        //设置番剧封面
        Glide.with(this)
                .load(result.getCover())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into(mBangumiPic);

        //设置背景高斯模糊图片
        Glide.with(this)
                .load(result.getCover())
                .bitmapTransform(new BlurTransformation(this))
                .into(mBangumiBackgroundImage);

        //设置番剧标题
        mBangumiTitle.setText(result.getTitle());
        //设置番剧更新日期

        mBangumiUpdate.setText("连载中");
        //设置番剧播放和追番数量
        mBangumiPlay.setText("播放：" + NumberUtil.converString(Integer.valueOf(result.getPlay_count()))
                + "  " + "追番：" + NumberUtil.converString(Integer.valueOf(result.getFavorites())));
        //设置番剧简介

        mBangumiIntroduction.setText(result.getEvaluate());


        //设置标签布局
        List<BangumiDetailsInfo.ResultBean.TagsBean> tags = result.getTags();
        mTagsLayout.setAdapter(new TagAdapter<BangumiDetailsInfo.ResultBean.TagsBean>(tags)
        {

            @Override
            public View getView(FlowLayout parent, int position, BangumiDetailsInfo.ResultBean.TagsBean tagsBean)
            {


                TextView mTags = (TextView) LayoutInflater.from(BangumiDetailsActivity.this)
                        .inflate(R.layout.layout_tags_item, parent, false);
                mTags.setText(tagsBean.getTag_name());

                return mTags;
            }
        });

        //设置番剧选集和番剧推荐
        initSelectionRecycler();
        initRecommendRecycler();
        hideProgressBar();
    }

    /**
     * 初始化选集recyclerView
     */
    private void initSelectionRecycler()
    {

        List<BangumiDetailsInfo.ResultBean.EpisodesBean> episodes = result.getEpisodes();

        mBangumiSelectionRecycler.setHasFixedSize(false);
        mBangumiSelectionRecycler.setNestedScrollingEnabled(false);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mBangumiSelectionRecycler.setLayoutManager(mLinearLayoutManager);
        BangumiDetailsSelectionAdapter mBangumiDetailsSelectionAdapter = new BangumiDetailsSelectionAdapter(mBangumiSelectionRecycler, episodes);
        mBangumiSelectionRecycler.setAdapter(mBangumiDetailsSelectionAdapter);
        mBangumiDetailsSelectionAdapter.setOnItemClickListener((position, holder) -> {

            mBangumiDetailsSelectionAdapter.notifyItemForeground(holder.getLayoutPosition());
            VideoDetailsActivity.launch(BangumiDetailsActivity.this,
                    Integer.valueOf(episodes.get(position).getAv_id()), episodes.get(position).getCover());
        });
    }

    /**
     * 初始化番剧推荐recyclerView
     */
    private void initRecommendRecycler()
    {

        mBangumiRecommendRecycler.setHasFixedSize(false);
        mBangumiRecommendRecycler.setNestedScrollingEnabled(false);
        mBangumiRecommendRecycler.setLayoutManager(new GridLayoutManager(BangumiDetailsActivity.this, 3));
        BangumiDetailsRecommendAdapter mBangumiDetailsRecommendAdapter = new BangumiDetailsRecommendAdapter(
                mBangumiRecommendRecycler, bangumiRecommends);
        mBangumiRecommendRecycler.setAdapter(mBangumiDetailsRecommendAdapter);
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setTitle("番剧详情");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.setDisplayHomeAsUpEnabled(true);

        //设置Toolbar的透明度
        mToolbar.setBackgroundColor(Color.argb(0, 251, 114, 153));

        //设置StatusBar透明
        SystemBarHelper.immersiveStatusBar(this);
        SystemBarHelper.setPadding(this, mToolbar);

        //获取顶部image高度和toolbar高度
        float imageHeight = getResources().getDimension(R.dimen.bangumi_details_top_layout_height);
        float toolBarHeight = getResources().getDimension(R.dimen.action_bar_default_height);

        mNestedScrollView.setNestedScrollingEnabled(true);
        mNestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener()
        {

            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY)
            {
                //根据NestedScrollView滑动改变Toolbar的透明度
                float offsetY = toolBarHeight - imageHeight;
                //计算滑动距离的偏移量
                float offset = 1 - Math.max((offsetY - scrollY) / offsetY, 0f);
                float absOffset = Math.abs(offset);
                //如果滑动距离大于1就设置完全不透明度
                if (absOffset >= 1)
                {
                    absOffset = 1;
                }
                mToolbar.setBackgroundColor(Color.argb((int) (absOffset * 255), 251, 114, 153));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if (item.getItemId() == android.R.id.home)
            onBackPressed();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        getMenuInflater().inflate(R.menu.menu_bangumi_details, menu);
        return true;
    }

    @Override
    public void showProgressBar()
    {

        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();
        mDetailsLayout.setVisibility(View.GONE);
    }

    @Override
    public void hideProgressBar()
    {

        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
        mDetailsLayout.setVisibility(View.VISIBLE);
    }

    public static void launch(Activity activity, int seasonId)
    {

        Intent mIntent = new Intent(activity, BangumiDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(ConstantUtil.EXTRA_BANGUMI_KEY, seasonId);
        mIntent.putExtras(bundle);
        activity.startActivity(mIntent);
    }
}
