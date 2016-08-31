package com.hotbitmapgg.ohmybilibili.module.home.bangumi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.section.WeekDayBangumiSection;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.config.Secret;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.WeekDayBangumi;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.WeekDayBangumiResult;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.hotbitmapgg.ohmybilibili.widget.sectioned.SectionedRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 新番放送表界面
 */
public class WeekDayBangumiActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    private List<WeekDayBangumi> mOneWeekDayBangumis = new ArrayList<>();

    private List<WeekDayBangumi> mTwoWeekDayBangumis = new ArrayList<>();

    private List<WeekDayBangumi> mThreeWeekDayBangumis = new ArrayList<>();

    private List<WeekDayBangumi> mFourWeekDayBangumis = new ArrayList<>();

    private List<WeekDayBangumi> mFiveWeekDayBangumis = new ArrayList<>();

    private List<WeekDayBangumi> mSixWeekDayBangumis = new ArrayList<>();

    private List<WeekDayBangumi> mSevenWeekDayBangumis = new ArrayList<>();

    private SectionedRecyclerViewAdapter mSectionedAdapter;

    private static final String EXTRA_TITLE = "extra_title";

    private static final String EXTRA_TYPE = "extra_type";

    private int[] wids = new int[]{1, 2, 3, 4, 5, 6, 0};

    private String title;

    private int type;

    private int[] weekDayIcons = new int[]{
            R.drawable.bangumi_timeline_weekday_1,
            R.drawable.bangumi_timeline_weekday_2,
            R.drawable.bangumi_timeline_weekday_3,
            R.drawable.bangumi_timeline_weekday_4,
            R.drawable.bangumi_timeline_weekday_5,
            R.drawable.bangumi_timeline_weekday_6,
            R.drawable.bangumi_timeline_weekday_7
    };

    private String[] weekDayTitles = new String[]{
            "周一",
            "周二",
            "周三",
            "周四",
            "周五",
            "周六",
            "周日"
    };


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_weekday_bangumi;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        Intent intent = getIntent();
        title = intent.getStringExtra(EXTRA_TITLE);
        type = intent.getIntExtra(EXTRA_TYPE, 0);

        mSectionedAdapter = new SectionedRecyclerViewAdapter();
        showProgressBar();
        loadWeekDayBangumis();
    }

    /**
     * 这里因为接口是传日期的id查询对应的番剧数据
     * 并没有一起返回一个星期的数据
     * 所以只能一天一天的查询后在进行适配数据
     */
    private void loadWeekDayBangumis()
    {

        RetrofitHelper.getWeekDayBangumiApi()
                .getWeekDayBangumi(type, wids[0], Secret.APP_KEY,
                        Long.toString(System.currentTimeMillis() / 1000))
                .compose(this.<WeekDayBangumiResult> bindToLifecycle())
                .flatMap(new Func1<WeekDayBangumiResult,Observable<WeekDayBangumiResult>>()
                {

                    @Override
                    public Observable<WeekDayBangumiResult> call(WeekDayBangumiResult weekDayBangumiResult)
                    {

                        mOneWeekDayBangumis.addAll(weekDayBangumiResult.list);
                        mSectionedAdapter.addSection(new WeekDayBangumiSection(
                                WeekDayBangumiActivity.this,
                                mOneWeekDayBangumis,
                                weekDayIcons[0],
                                weekDayTitles[0]));

                        return RetrofitHelper.getWeekDayBangumiApi()
                                .getWeekDayBangumi(type, wids[1], Secret.APP_KEY,
                                        Long.toString(System.currentTimeMillis() / 1000));
                    }
                })
                .flatMap(new Func1<WeekDayBangumiResult,Observable<WeekDayBangumiResult>>()
                {

                    @Override
                    public Observable<WeekDayBangumiResult> call(WeekDayBangumiResult weekDayBangumiResult)
                    {

                        mTwoWeekDayBangumis.addAll(weekDayBangumiResult.list);
                        mSectionedAdapter.addSection(new WeekDayBangumiSection(
                                WeekDayBangumiActivity.this,
                                mTwoWeekDayBangumis,
                                weekDayIcons[1],
                                weekDayTitles[1]));

                        return RetrofitHelper.getWeekDayBangumiApi()
                                .getWeekDayBangumi(type, wids[2], Secret.APP_KEY,
                                        Long.toString(System.currentTimeMillis() / 1000));
                    }
                })
                .flatMap(new Func1<WeekDayBangumiResult,Observable<WeekDayBangumiResult>>()
                {

                    @Override
                    public Observable<WeekDayBangumiResult> call(WeekDayBangumiResult weekDayBangumiResult)
                    {

                        mThreeWeekDayBangumis.addAll(weekDayBangumiResult.list);
                        mSectionedAdapter.addSection(new WeekDayBangumiSection(
                                WeekDayBangumiActivity.this,
                                mThreeWeekDayBangumis,
                                weekDayIcons[2],
                                weekDayTitles[2]));

                        return RetrofitHelper.getWeekDayBangumiApi()
                                .getWeekDayBangumi(type, wids[3], Secret.APP_KEY,
                                        Long.toString(System.currentTimeMillis() / 1000));
                    }
                })
                .flatMap(new Func1<WeekDayBangumiResult,Observable<WeekDayBangumiResult>>()
                {

                    @Override
                    public Observable<WeekDayBangumiResult> call(WeekDayBangumiResult weekDayBangumiResult)
                    {

                        mFourWeekDayBangumis.addAll(weekDayBangumiResult.list);
                        mSectionedAdapter.addSection(new WeekDayBangumiSection(
                                WeekDayBangumiActivity.this,
                                mFourWeekDayBangumis,
                                weekDayIcons[3],
                                weekDayTitles[3]));

                        return RetrofitHelper.getWeekDayBangumiApi()
                                .getWeekDayBangumi(type, wids[4], Secret.APP_KEY,
                                        Long.toString(System.currentTimeMillis() / 1000));
                    }
                })
                .flatMap(new Func1<WeekDayBangumiResult,Observable<WeekDayBangumiResult>>()
                {

                    @Override
                    public Observable<WeekDayBangumiResult> call(WeekDayBangumiResult weekDayBangumiResult)
                    {

                        mFiveWeekDayBangumis.addAll(weekDayBangumiResult.list);
                        mSectionedAdapter.addSection(new WeekDayBangumiSection(
                                WeekDayBangumiActivity.this,
                                mFiveWeekDayBangumis,
                                weekDayIcons[4],
                                weekDayTitles[4]));

                        return RetrofitHelper.getWeekDayBangumiApi()
                                .getWeekDayBangumi(type, wids[5], Secret.APP_KEY,
                                        Long.toString(System.currentTimeMillis() / 1000));
                    }
                })
                .flatMap(new Func1<WeekDayBangumiResult,Observable<WeekDayBangumiResult>>()
                {

                    @Override
                    public Observable<WeekDayBangumiResult> call(WeekDayBangumiResult weekDayBangumiResult)
                    {

                        mSixWeekDayBangumis.addAll(weekDayBangumiResult.list);
                        mSectionedAdapter.addSection(new WeekDayBangumiSection(
                                WeekDayBangumiActivity.this,
                                mSixWeekDayBangumis,
                                weekDayIcons[5],
                                weekDayTitles[5]));

                        return RetrofitHelper.getWeekDayBangumiApi()
                                .getWeekDayBangumi(type, wids[6], Secret.APP_KEY,
                                        Long.toString(System.currentTimeMillis() / 1000));
                    }
                })
                .flatMap(new Func1<WeekDayBangumiResult,Observable<String>>()
                {

                    @Override
                    public Observable<String> call(WeekDayBangumiResult weekDayBangumiResult)
                    {

                        mSevenWeekDayBangumis.addAll(weekDayBangumiResult.list);
                        mSectionedAdapter.addSection(new WeekDayBangumiSection(
                                WeekDayBangumiActivity.this,
                                mSevenWeekDayBangumis,
                                weekDayIcons[6],
                                weekDayTitles[6]));

                        return Observable.just("success");
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>()
                {

                    @Override
                    public void call(String s)
                    {

                        finishGetTask();
                    }
                }, new Action1<Throwable>()
                {

                    @Override
                    public void call(Throwable throwable)
                    {

                        LogUtil.all("番剧放送表加载失败" + throwable.getMessage());
                        hideProgressBar();
                    }
                });
    }


    private void finishGetTask()
    {

        GridLayoutManager mLayoutManager = new GridLayoutManager(WeekDayBangumiActivity.this, 3);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup()
        {

            @Override
            public int getSpanSize(int position)
            {

                switch (mSectionedAdapter.getSectionItemViewType(position))
                {
                    case SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER:
                        return 3;
                    default:
                        return 1;
                }
            }
        });
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mSectionedAdapter);

        hideProgressBar();
    }


    @Override
    public void initToolBar()
    {

        mToolbar.setTitle(title);
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null)
        {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if (item.getItemId() == android.R.id.home)
            onBackPressed();

        return super.onOptionsItemSelected(item);
    }


    public static void launch(Activity activity, String title, int type)
    {

        Intent mIntent = new Intent(activity, WeekDayBangumiActivity.class);
        mIntent.putExtra(EXTRA_TITLE, title);
        mIntent.putExtra(EXTRA_TYPE, type);
        activity.startActivity(mIntent);
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
