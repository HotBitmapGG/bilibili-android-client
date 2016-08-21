package com.hotbitmapgg.ohmybilibili.module.bangumi;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.BangumiTimeLineRecycleAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.config.Secret;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.WeekDayBangumi;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.WeekDayBangumiResult;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.hotbitmapgg.ohmybilibili.widget.CustomEmptyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 番剧放送表界面
 */
public class WeekDayBangumiFragment extends RxLazyFragment
{

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    @Bind(R.id.empty_layout)
    CustomEmptyView mCustomEmptyView;

    private ArrayList<WeekDayBangumi> mWeekDayBangumis = new ArrayList<>();

    private BangumiTimeLineRecycleAdapter mAdapter;

    private static final String EXTRA_WEEK = "extra_week";

    private static final String EXTRA_TYPE = "extra_type";

    private int weekDay;

    private int type;

    public static WeekDayBangumiFragment newInstance(int weekDay, int type)
    {

        WeekDayBangumiFragment weekDayBangumiFragment = new WeekDayBangumiFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_WEEK, weekDay);
        bundle.putInt(EXTRA_TYPE, type);
        weekDayBangumiFragment.setArguments(bundle);

        return weekDayBangumiFragment;
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_bangumi_weekday;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        Bundle arguments = getArguments();
        if (arguments != null)
        {
            weekDay = arguments.getInt(EXTRA_WEEK);
            type = arguments.getInt(EXTRA_TYPE);
        }

        startGetBangumiTask();
    }


    private void startGetBangumiTask()
    {

        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();

        getBangumi();
    }

    public void getBangumi()
    {

        RetrofitHelper.getWeekDayBangumiApi()
                .getWeekDayBangumi(type, weekDay, Secret.APP_KEY,
                        Long.toString(System.currentTimeMillis() / 1000))
                .compose(this.<WeekDayBangumiResult> bindToLifecycle())
                .map(new Func1<WeekDayBangumiResult,List<WeekDayBangumi>>()
                {

                    @Override
                    public List<WeekDayBangumi> call(WeekDayBangumiResult weekDayBangumiResult)
                    {

                        return weekDayBangumiResult.list;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<WeekDayBangumi>>()
                {

                    @Override
                    public void call(List<WeekDayBangumi> weekDayBangumis)
                    {

                        mWeekDayBangumis.addAll(weekDayBangumis);
                        finishGetTask();
                    }
                }, new Action1<Throwable>()
                {

                    @Override
                    public void call(Throwable throwable)
                    {

                        LogUtil.all("番剧放送表加载失败" + throwable.getMessage());
                        mCircleProgressView.setVisibility(View.GONE);
                        mCircleProgressView.stopSpinning();
                        mCustomEmptyView.setVisibility(View.VISIBLE);
                        mCustomEmptyView.setEmptyImage(R.drawable.loading_failed);
                    }
                });
    }

    private void finishGetTask()
    {

        mAdapter = new BangumiTimeLineRecycleAdapter(mRecyclerView, mWeekDayBangumis);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new AbsRecyclerViewAdapter.OnItemClickListener()
        {

            @Override
            public void onItemClick(int position, AbsRecyclerViewAdapter.ClickableViewHolder holder)
            {

                WeekDayBangumi mWeekDayBangumi = mAdapter.getItem(position);
                SpecialDetailsActivity.launch(getActivity(),
                        mWeekDayBangumi.spid,
                        mWeekDayBangumi.title,
                        mWeekDayBangumi.season_id);
            }
        });

        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
    }
}
