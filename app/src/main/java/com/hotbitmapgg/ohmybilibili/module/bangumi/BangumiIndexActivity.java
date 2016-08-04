package com.hotbitmapgg.ohmybilibili.module.bangumi;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.BangumiIndexAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.model.BangumiIndex;
import com.hotbitmapgg.ohmybilibili.retrofit.BangumiIndexService;
import com.hotbitmapgg.ohmybilibili.retrofit.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 番剧索引
 *
 * @HotBitmapGG
 */
public class BangumiIndexActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    private String month = "4";

    private String year = "2016";

    private BangumiIndexService bangumiIndexService;

    private List<BangumiIndex> bangumiIndexList = new ArrayList<>();


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_bangumi_index;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        bangumiIndexService = RetrofitHelper.getBiliBili().create(BangumiIndexService.class);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(BangumiIndexActivity.this, 3));


        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();

        getBangumiIndex();
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setNavigationIcon(R.drawable.action_button_back_pressed_light);
        mToolbar.setTitle("番剧索引");
        mToolbar.setNavigationOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                finish();
            }
        });
    }

    public void getBangumiIndex()
    {

        bangumiIndexService.getBangumiIndex(year, month)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<BangumiIndex>>()
                {

                    @Override
                    public void call(List<BangumiIndex> bangumiIndices)
                    {

                        if (bangumiIndices != null)
                        {
                            bangumiIndexList.addAll(bangumiIndices);
                            finishGetBangumiIndex();
                        }
                    }
                }, new Action1<Throwable>()
                {

                    @Override
                    public void call(Throwable throwable)
                    {

                    }
                });
    }

    private void finishGetBangumiIndex()
    {

        BangumiIndexAdapter mAdapter = new BangumiIndexAdapter(mRecyclerView, bangumiIndexList);
        mRecyclerView.setAdapter(mAdapter);

        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
    }
}
