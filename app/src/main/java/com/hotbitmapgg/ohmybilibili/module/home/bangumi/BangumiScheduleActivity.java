package com.hotbitmapgg.ohmybilibili.module.home.bangumi;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.section.BangumiScheduleSection;
import com.hotbitmapgg.ohmybilibili.base.RxBaseActivity;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiSchedule;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.ConstantUtils;
import com.hotbitmapgg.ohmybilibili.utils.ToastUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.hotbitmapgg.ohmybilibili.widget.sectioned.SectionedRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 番剧时间表界面
 */
public class BangumiScheduleActivity extends RxBaseActivity
{

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.recycle)
    RecyclerView mRecyclerView;

    @BindView(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    private List<BangumiSchedule.ResultBean> bangumiSchedules = new ArrayList<>();

    private List<BangumiSchedule.ResultBean> sundayBangumis = new ArrayList<>();

    private List<BangumiSchedule.ResultBean> mondayBangumis = new ArrayList<>();

    private List<BangumiSchedule.ResultBean> tuesdayBangumis = new ArrayList<>();

    private List<BangumiSchedule.ResultBean> wednesdayBangumis = new ArrayList<>();

    private List<BangumiSchedule.ResultBean> thursdayBangumis = new ArrayList<>();

    private List<BangumiSchedule.ResultBean> fridayBangumis = new ArrayList<>();

    private List<BangumiSchedule.ResultBean> saturdayBangumis = new ArrayList<>();

    private GridLayoutManager mLayoutManager;

    private SectionedRecyclerViewAdapter mSectionedAdapter;


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_bangumi_schedule;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        initRecyclerView();
        loadData();
    }

    @Override
    public void initRecyclerView()
    {
        mSectionedAdapter = new SectionedRecyclerViewAdapter();
    }

    @Override
    public void loadData()
    {

        RetrofitHelper.getBangumiScheduleApi()
                .getBangumiSchedules()
                .compose(bindToLifecycle())
                .doOnSubscribe(this::showProgressBar)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bangumiSchedule -> {

                    bangumiSchedules.addAll(bangumiSchedule.getResult());
                    finishTask();
                }, throwable -> {

                    hideProgressBar();
                    ToastUtil.ShortToast("加载失败啦,请重新加载~");
                });
    }


    @Override
    public void finishTask()
    {

        mLayoutManager = new GridLayoutManager(BangumiScheduleActivity.this, 3);
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

        fillData();
        hideProgressBar();
    }

    /**
     * 获取到番剧集合,在根据星期进行填充数据
     */
    private void fillData()
    {

        for (int i = 0, size = bangumiSchedules.size(); i < size; i++)
        {
            BangumiSchedule.ResultBean resultBean = bangumiSchedules.get(i);
            String weekday = resultBean.getWeekday();
            switch (weekday)
            {
                case ConstantUtils.SUNDAY_TYPE:
                    sundayBangumis.add(resultBean);
                    break;
                case ConstantUtils.MONDAY_TYPE:
                    mondayBangumis.add(resultBean);
                    break;
                case ConstantUtils.TUESDAY_TYPE:
                    tuesdayBangumis.add(resultBean);
                    break;
                case ConstantUtils.WEDNESDAY_TYPE:
                    wednesdayBangumis.add(resultBean);
                    break;
                case ConstantUtils.THURSDAY_TYPE:
                    thursdayBangumis.add(resultBean);
                    break;
                case ConstantUtils.FRIDAY_TYEP:
                    fridayBangumis.add(resultBean);
                    break;
                case ConstantUtils.SATURDAY_TYPE:
                    saturdayBangumis.add(resultBean);
                    break;
            }
        }

        mSectionedAdapter.addSection(new BangumiScheduleSection(BangumiScheduleActivity.this,
                sundayBangumis, Integer.valueOf(ConstantUtils.SUNDAY_TYPE)));
        mSectionedAdapter.addSection(new BangumiScheduleSection(BangumiScheduleActivity.this,
                mondayBangumis, Integer.valueOf(ConstantUtils.MONDAY_TYPE)));
        mSectionedAdapter.addSection(new BangumiScheduleSection(BangumiScheduleActivity.this,
                tuesdayBangumis, Integer.valueOf(ConstantUtils.TUESDAY_TYPE)));
        mSectionedAdapter.addSection(new BangumiScheduleSection(BangumiScheduleActivity.this,
                wednesdayBangumis, Integer.valueOf(ConstantUtils.WEDNESDAY_TYPE)));
        mSectionedAdapter.addSection(new BangumiScheduleSection(BangumiScheduleActivity.this,
                thursdayBangumis, Integer.valueOf(ConstantUtils.THURSDAY_TYPE)));
        mSectionedAdapter.addSection(new BangumiScheduleSection(BangumiScheduleActivity.this,
                fridayBangumis, Integer.valueOf(ConstantUtils.FRIDAY_TYEP)));
        mSectionedAdapter.addSection(new BangumiScheduleSection(BangumiScheduleActivity.this,
                saturdayBangumis, Integer.valueOf(ConstantUtils.SATURDAY_TYPE)));
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mSectionedAdapter);
    }


    @Override
    public void initToolBar()
    {

        mToolbar.setTitle("番剧时间表");
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null)
            mActionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if (item.getItemId() == android.R.id.home)
            onBackPressed();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showProgressBar()
    {

        super.showProgressBar();
        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();
    }

    @Override
    public void hideProgressBar()
    {

        super.hideProgressBar();
        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
    }
}
