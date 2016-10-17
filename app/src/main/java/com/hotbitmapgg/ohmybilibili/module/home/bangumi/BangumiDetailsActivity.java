package com.hotbitmapgg.ohmybilibili.module.home.bangumi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
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
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.HomeBangumiRecommend;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.MiddlewareBangumi;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.SpecialTopic;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.ConstantUtils;
import com.hotbitmapgg.ohmybilibili.utils.NumberUtil;
import com.hotbitmapgg.ohmybilibili.utils.SystemBarHelper;
import com.hotbitmapgg.ohmybilibili.utils.WeekDayUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
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
public class BangumiDetailsActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.nested_scroll_view)
    NestedScrollView mNestedScrollView;

    @Bind(R.id.bangumi_bg)
    ImageView mBangumiBackgroundImage;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.bangumi_pic)
    ImageView mBangumiPic;

    @Bind(R.id.bangumi_details_layout)
    LinearLayout mDetailsLayout;

    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    @Bind(R.id.bangumi_title)
    TextView mBangumiTitle;

    @Bind(R.id.bangumi_update)
    TextView mBangumiUpdate;

    @Bind(R.id.bangumi_play)
    TextView mBangumiPlay;

    @Bind(R.id.bangumi_selection_recycler)
    RecyclerView mBangumiSelectionRecycler;

    @Bind(R.id.tags_layout)
    TagFlowLayout mTagsLayout;

    @Bind(R.id.bangumi_details_introduction)
    TextView mBangumiIntroduction;

//    @Bind(R.id.bangumi_comment_recycler)
//    RecyclerView mBangumiCommentRecycler;

    @Bind(R.id.bangumi_recommend_recycler)
    RecyclerView mBangumiRecommendRecycler;

    private SpecialTopic mSpecialTopic;

    private MiddlewareBangumi mBangumiInfo;

    private Random random = new Random();

    private List<HomeBangumiRecommend.ResultBean.EndsBean> recommends = new ArrayList<>();

    private List<String> tags = Arrays.asList(
            "轻改", "萌系", "搞笑", "催泪", "热血",
            "机战", "后宫", "恋爱", "基腐", "百合", "伪娘", "乙女");

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
            Bundle bundle = intent.getExtras();
            mBangumiInfo = bundle.getParcelable(ConstantUtils.EXTRA_BANGUMI_KEY);
        }

        getBangumiDetails();
    }

    public void getBangumiDetails()
    {

        RetrofitHelper.getSpInfoApi()
                .getSpInfo(mBangumiInfo.getSpid(), mBangumiInfo.getTitle())
                .compose(bindToLifecycle())
                .doOnSubscribe(this::showProgressBar)
                .flatMap(new Func1<SpecialTopic,Observable<HomeBangumiRecommend>>()
                {

                    @Override
                    public Observable<HomeBangumiRecommend> call(SpecialTopic specialTopic)
                    {

                        mSpecialTopic = specialTopic;
                        return RetrofitHelper.getHomeBnagumiRecommendApi()
                                .getHomeBangumiRecommended();
                    }
                })
                .compose(bindToLifecycle())
                .map(homeBangumiRecommend -> homeBangumiRecommend.getResult().getEnds())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(endsBeans -> {

                    recommends.addAll(endsBeans);
                    finishTask();
                }, throwable -> {
                    hideProgressBar();
                });
//                .map(HomeBangumiRecommend::getRecommends)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(recommendsBeans -> {
//                    recommends.addAll(recommendsBeans);
//                    finishTask();
//                }, throwable -> {
//                    hideProgressBar();
//                });
    }

    private void finishTask()
    {

        //设置番剧封面
        Glide.with(this)
                .load(mBangumiInfo.getPic())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into(mBangumiPic);

        //设置背景高斯模糊图片
        Glide.with(this)
                .load(mBangumiInfo.getPic())
                .bitmapTransform(new BlurTransformation(this))
                .into(mBangumiBackgroundImage);

        //设置番剧标题
        mBangumiTitle.setText(mBangumiInfo.getTitle());
        //设置番剧更新日期
        int weekDay = random.nextInt(6);
        mBangumiUpdate.setText("连载中,每周" + (mBangumiInfo.getWeekday() == 0 ? WeekDayUtil.converWeekDay(weekDay) :
                WeekDayUtil.converWeekDay(mBangumiInfo.getWeekday())) + "更新");
        //设置番剧播放和追番数量
        mBangumiPlay.setText("播放: " + (mBangumiInfo.getPlay() == 0 ?
                NumberUtil.converString(mSpecialTopic.play) : NumberUtil.converString(mBangumiInfo.getPlay()))
                + "  " + "追番: " + (mBangumiInfo.getFavorites() == 0 ?
                NumberUtil.converString(mSpecialTopic.attention) : NumberUtil.converString(mBangumiInfo.getFavorites())));
        //设置番剧简介
        if (mBangumiInfo.getDescription() == null)
        {
            mBangumiIntroduction.setText(mSpecialTopic.description == null ?
                    mBangumiInfo.getTitle() : mSpecialTopic.description);
        } else
        {
            mBangumiIntroduction.setText(mBangumiInfo.getDescription());
        }

        //设置标签布局
        List<String> strings = tags.subList(0, random.nextInt(5));
        mTagsLayout.setAdapter(new TagAdapter<String>(strings)
        {

            @Override
            public View getView(FlowLayout parent, int position, String s)
            {

                TextView mTags = (TextView) LayoutInflater.from(BangumiDetailsActivity.this)
                        .inflate(R.layout.layout_tags_item, parent, false);
                mTags.setText(s);

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

        mBangumiSelectionRecycler.setHasFixedSize(false);
        mBangumiSelectionRecycler.setNestedScrollingEnabled(false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        mBangumiSelectionRecycler.setLayoutManager(gridLayoutManager);
        BangumiDetailsSelectionAdapter mBangumiDetailsSelectionAdapter = new BangumiDetailsSelectionAdapter(
                mBangumiSelectionRecycler, mBangumiInfo.getCount() == 0 ? mSpecialTopic.count : mBangumiInfo.getCount());
        mBangumiSelectionRecycler.setAdapter(mBangumiDetailsSelectionAdapter);
        mBangumiDetailsSelectionAdapter.setOnItemClickListener((position, holder) -> mBangumiDetailsSelectionAdapter.
                notifyItemForeground(holder.getLayoutPosition()));
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
                mBangumiRecommendRecycler, recommends);
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

    public void showProgressBar()
    {

        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();
        mDetailsLayout.setVisibility(View.GONE);
    }

    private void hideProgressBar()
    {

        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
        mDetailsLayout.setVisibility(View.VISIBLE);
    }

    public static void launch(Activity activity, MiddlewareBangumi bangumi)
    {

        Intent mIntent = new Intent(activity, BangumiDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(ConstantUtils.EXTRA_BANGUMI_KEY, bangumi);
        mIntent.putExtras(bundle);
        activity.startActivity(mIntent);
    }
}
