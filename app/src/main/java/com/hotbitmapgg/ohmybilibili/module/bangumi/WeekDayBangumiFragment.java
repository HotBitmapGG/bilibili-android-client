package com.hotbitmapgg.ohmybilibili.module.bangumi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.BangumiTimeLineRecycleAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.module.topic.SpecialDetailsActivity;
import com.hotbitmapgg.ohmybilibili.api.BangumiApi;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.model.bangumi.Bangumi;
import com.hotbitmapgg.ohmybilibili.model.base.BasicMessage;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.hotbitmapgg.ohmybilibili.widget.EmptyView;

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
    EmptyView mEmptyView;

    private ArrayList<Bangumi> mBangumis = new ArrayList<>();

    private BangumiTimeLineRecycleAdapter mAdapter;

    private static final String EXTRA_WEEK = "extra_week";

    private int weekDay;

    public static WeekDayBangumiFragment newInstance(int weekDay)
    {

        WeekDayBangumiFragment weekDayBangumiFragment = new WeekDayBangumiFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_WEEK, weekDay);
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
            weekDay = arguments.getInt(EXTRA_WEEK);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

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

        Single<BasicMessage<ArrayList<Bangumi>>> single = Single.fromCallable(new Callable<BasicMessage<ArrayList<Bangumi>>>()
        {

            @Override
            public BasicMessage<ArrayList<Bangumi>> call() throws Exception
            {

                return BangumiApi.getBangumi(BangumiApi.BTYPE_2D, weekDay);
            }
        });

        Subscription subscribe = single.map(new Func1<BasicMessage<ArrayList<Bangumi>>,ArrayList<Bangumi>>()
        {

            @Override
            public ArrayList<Bangumi> call(BasicMessage<ArrayList<Bangumi>> arrayListBasicMessage)
            {

                return arrayListBasicMessage.getObject();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<ArrayList<Bangumi>>()
                {

                    @Override
                    public void onSuccess(ArrayList<Bangumi> value)
                    {

                        if (value != null && value.size() > 0)
                        {
                            mBangumis.clear();
                            mBangumis.addAll(value);
                        }

                        finishGetTask();
                    }

                    @Override
                    public void onError(Throwable error)
                    {

                        LogUtil.lsw("二次元新番加载失败");
                        mCircleProgressView.setVisibility(View.GONE);
                        mCircleProgressView.stopSpinning();
                        mEmptyView.setVisibility(View.VISIBLE);
                        mEmptyView.setEmptyImage(R.drawable.loading_failed);
                    }
                });

        compositeSubscription.add(subscribe);
    }

    private void finishGetTask()
    {

        mAdapter = new BangumiTimeLineRecycleAdapter(mRecyclerView, mBangumis);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new AbsRecyclerViewAdapter.OnItemClickListener()
        {

            @Override
            public void onItemClick(int position, AbsRecyclerViewAdapter.ClickableViewHolder holder)
            {

                Bangumi mBangumi = mAdapter.getItem(position);
                String spid = mBangumi.spid;
                String title = mBangumi.title;
                int season_id = mBangumi.season_id;

                Intent mIntent = new Intent(getActivity(), SpecialDetailsActivity.class);
                mIntent.putExtra("spid", spid);
                mIntent.putExtra("title", title);
                mIntent.putExtra("season_id", season_id);
                startActivity(mIntent);
            }
        });

        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
    }
}
