package com.hotbitmapgg.bilibili.module.home.bangumi;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.hotbitmapgg.bilibili.adapter.section.BangumiScheduleSection;
import com.hotbitmapgg.bilibili.base.RxBaseActivity;
import com.hotbitmapgg.bilibili.entity.bangumi.BangumiScheduleInfo;
import com.hotbitmapgg.bilibili.network.RetrofitHelper;
import com.hotbitmapgg.bilibili.utils.ConstantUtil;
import com.hotbitmapgg.bilibili.utils.ToastUtil;
import com.hotbitmapgg.bilibili.utils.WeekDayUtil;
import com.hotbitmapgg.bilibili.widget.CircleProgressView;
import com.hotbitmapgg.bilibili.widget.sectioned.SectionedRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 番剧时间表界面
 */
public class BangumiScheduleActivity extends RxBaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.recycle)
    RecyclerView mRecyclerView;
    @BindView(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    private SectionedRecyclerViewAdapter mSectionedAdapter;
    private List<BangumiScheduleInfo.ResultBean> bangumiSchedules = new ArrayList<>();
    private List<BangumiScheduleInfo.ResultBean> sundayBangumis = new ArrayList<>();
    private List<BangumiScheduleInfo.ResultBean> mondayBangumis = new ArrayList<>();
    private List<BangumiScheduleInfo.ResultBean> tuesdayBangumis = new ArrayList<>();
    private List<BangumiScheduleInfo.ResultBean> wednesdayBangumis = new ArrayList<>();
    private List<BangumiScheduleInfo.ResultBean> thursdayBangumis = new ArrayList<>();
    private List<BangumiScheduleInfo.ResultBean> fridayBangumis = new ArrayList<>();
    private List<BangumiScheduleInfo.ResultBean> saturdayBangumis = new ArrayList<>();


    @Override
    public int getLayoutId() {
        return R.layout.activity_bangumi_schedule;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        initRecyclerView();
        loadData();
    }

    @Override
    public void initRecyclerView() {
        mSectionedAdapter = new SectionedRecyclerViewAdapter();
        GridLayoutManager mLayoutManager = new GridLayoutManager(BangumiScheduleActivity.this, 3);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (mSectionedAdapter.getSectionItemViewType(position)) {
                    case SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER:
                        return 3;
                    default:
                        return 1;
                }
            }
        });
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mSectionedAdapter);
    }


    @Override
    public void loadData() {
        RetrofitHelper.getBangumiAPI()
                .getBangumiSchedules()
                .compose(bindToLifecycle())
                .doOnSubscribe(this::showProgressBar)
                .delay(2000, TimeUnit.MILLISECONDS)
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
    public void finishTask() {
        Observable.from(bangumiSchedules)
                .compose(bindToLifecycle())
                .forEach(this::accordingWeekGroup);

        mSectionedAdapter.addSection(new BangumiScheduleSection(BangumiScheduleActivity.this, sundayBangumis, ConstantUtil.SUNDAY_TYPE,
                saturdayBangumis.size() > 0 ? WeekDayUtil.formatDate(sundayBangumis.get(0).getPub_date()) : ""));
        mSectionedAdapter.addSection(new BangumiScheduleSection(BangumiScheduleActivity.this, mondayBangumis, ConstantUtil.MONDAY_TYPE,
                mondayBangumis.size() > 0 ? WeekDayUtil.formatDate(mondayBangumis.get(0).getPub_date()) : ""));
        mSectionedAdapter.addSection(new BangumiScheduleSection(BangumiScheduleActivity.this, tuesdayBangumis, ConstantUtil.TUESDAY_TYPE,
                tuesdayBangumis.size() > 0 ? WeekDayUtil.formatDate(tuesdayBangumis.get(0).getPub_date()) : ""));
        mSectionedAdapter.addSection(new BangumiScheduleSection(BangumiScheduleActivity.this, wednesdayBangumis, ConstantUtil.WEDNESDAY_TYPE,
                wednesdayBangumis.size() > 0 ? WeekDayUtil.formatDate(wednesdayBangumis.get(0).getPub_date()) : ""));
        mSectionedAdapter.addSection(new BangumiScheduleSection(BangumiScheduleActivity.this, thursdayBangumis, ConstantUtil.THURSDAY_TYPE,
                thursdayBangumis.size() > 0 ? WeekDayUtil.formatDate(thursdayBangumis.get(0).getPub_date()) : ""));
        mSectionedAdapter.addSection(new BangumiScheduleSection(BangumiScheduleActivity.this, fridayBangumis, ConstantUtil.FRIDAY_TYEP,
                fridayBangumis.size() > 0 ? WeekDayUtil.formatDate(fridayBangumis.get(0).getPub_date()) : ""));
        mSectionedAdapter.addSection(new BangumiScheduleSection(BangumiScheduleActivity.this, saturdayBangumis, ConstantUtil.SATURDAY_TYPE,
                saturdayBangumis.size() > 0 ? WeekDayUtil.formatDate(saturdayBangumis.get(0).getPub_date()) : ""));

        mSectionedAdapter.notifyDataSetChanged();
        hideProgressBar();
    }


    private void accordingWeekGroup(BangumiScheduleInfo.ResultBean resultBean) {
        switch (WeekDayUtil.getWeek(resultBean.getPub_date())) {
            case ConstantUtil.SUNDAY_TYPE:
                sundayBangumis.add(resultBean);
                break;
            case ConstantUtil.MONDAY_TYPE:
                mondayBangumis.add(resultBean);
                break;
            case ConstantUtil.TUESDAY_TYPE:
                tuesdayBangumis.add(resultBean);
                break;
            case ConstantUtil.WEDNESDAY_TYPE:
                wednesdayBangumis.add(resultBean);
                break;
            case ConstantUtil.THURSDAY_TYPE:
                thursdayBangumis.add(resultBean);
                break;
            case ConstantUtil.FRIDAY_TYEP:
                fridayBangumis.add(resultBean);
                break;
            case ConstantUtil.SATURDAY_TYPE:
                saturdayBangumis.add(resultBean);
                break;
        }
    }

    @Override
    public void initToolBar() {
        mToolbar.setTitle("番剧时间表");
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
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
    public void showProgressBar() {
        super.showProgressBar();
        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();
    }


    @Override
    public void hideProgressBar() {
        super.hideProgressBar();
        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
    }
}
