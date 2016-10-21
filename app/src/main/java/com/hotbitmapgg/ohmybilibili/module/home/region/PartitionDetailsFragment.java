package com.hotbitmapgg.ohmybilibili.module.home.region;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.PartitionMoreRecyclerAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.helper.EndlessRecyclerOnScrollListener;
import com.hotbitmapgg.ohmybilibili.adapter.helper.HeaderViewRecyclerAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.config.Secret;
import com.hotbitmapgg.ohmybilibili.entity.region.PartitionMoreList;
import com.hotbitmapgg.ohmybilibili.entity.region.PartitionMoreVideoItem;
import com.hotbitmapgg.ohmybilibili.module.video.VideoDetailsActivity;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.ConstantUtils;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 分区对应类型列表详情界面
 */
public class PartitionDetailsFragment extends RxLazyFragment
{

    @BindView(R.id.recycle)
    RecyclerView mRecyclerView;

    @BindView(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    private PartitionMoreRecyclerAdapter mAdapter;

    private ArrayList<PartitionMoreVideoItem> items = new ArrayList<>();

    private int pageNum = 1;

    private int pageSize = 10;

    private HeaderViewRecyclerAdapter mRecyclerAdapter;

    private String tid;

    private View loadMoreView;


    public static PartitionDetailsFragment newInstance(String tid)
    {

        PartitionDetailsFragment fragment =
                new PartitionDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ConstantUtils.EXTRA_TID, tid);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_partition_details;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        tid = getArguments().getString(ConstantUtils.EXTRA_TID);

        isPrepared = true;
        lazyLoad();
    }

    @Override
    protected void lazyLoad()
    {

        if (!isPrepared || !isVisible)
            return;

        showProgressBar();
        initRecyclerView();
        loadData();
        isPrepared = false;
    }


    @Override
    protected void initRecyclerView()
    {

        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mAdapter = new PartitionMoreRecyclerAdapter(mRecyclerView, items);
        mRecyclerAdapter = new HeaderViewRecyclerAdapter(mAdapter);
        mRecyclerView.setAdapter(mRecyclerAdapter);
        createLoadMoreView();
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(mLinearLayoutManager)
        {

            @Override
            public void onLoadMore(int i)
            {

                pageNum++;
                loadData();
                loadMoreView.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    protected void loadData()
    {

        RetrofitHelper.getPartitionMoreApi()
                .getPartitionMore(tid, pageNum,
                        pageSize, 0, Secret.APP_KEY,
                        Long.toString(System.currentTimeMillis() / 1000))
                .compose(bindToLifecycle())
                .map(responseBody -> {

                    try
                    {
                        return PartitionMoreList.createFromJson(responseBody.string());
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(partitionMoreList -> {

                    if (partitionMoreList.lists.size() < pageSize)
                        loadMoreView.setVisibility(View.GONE);

                    items.addAll(partitionMoreList.lists);
                    finishTask();
                }, throwable -> {

                    loadMoreView.setVisibility(View.GONE);
                    hideProgressBar();
                });
    }

    @Override
    protected void finishTask()
    {

        loadMoreView.setVisibility(View.GONE);
        hideProgressBar();

        if (pageNum * pageSize - pageSize - 1 > 0)
            mAdapter.notifyItemRangeChanged(pageNum * pageSize - pageSize - 1, pageSize);
        else
            mAdapter.notifyDataSetChanged();

        mAdapter.setOnItemClickListener((position, holder) -> {

            PartitionMoreVideoItem bangumiMoreVideoItem = items.get(position);
            VideoDetailsActivity.launch(getSupportActivity(), bangumiMoreVideoItem.aid, bangumiMoreVideoItem.pic);
        });
    }

    private void createLoadMoreView()
    {

        loadMoreView = LayoutInflater.from(getActivity())
                .inflate(R.layout.layout_load_more, mRecyclerView, false);
        mRecyclerAdapter.addFooterView(loadMoreView);
        loadMoreView.setVisibility(View.GONE);
    }


    @Override
    protected void showProgressBar()
    {

        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();
    }

    @Override
    protected void hideProgressBar()
    {

        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
    }
}
