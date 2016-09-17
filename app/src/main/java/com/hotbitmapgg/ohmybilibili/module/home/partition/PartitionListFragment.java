package com.hotbitmapgg.ohmybilibili.module.home.partition;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.PartitionMoreRecyclerAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.config.Secret;
import com.hotbitmapgg.ohmybilibili.entity.partition.PartitionMoreList;
import com.hotbitmapgg.ohmybilibili.entity.partition.PartitionMoreVideoItem;
import com.hotbitmapgg.ohmybilibili.module.video.VideoDetailsActivity;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.recyclerview_helper.EndlessRecyclerOnScrollListener;
import com.hotbitmapgg.ohmybilibili.widget.recyclerview_helper.HeaderViewRecyclerAdapter;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 分区对应类型列表详情界面
 */
public class PartitionListFragment extends RxLazyFragment
{

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private PartitionMoreRecyclerAdapter mAdapter;

    private ArrayList<PartitionMoreVideoItem> items = new ArrayList<>();

    private int pageNum = 1;

    private int pageSize = 10;

    private HeaderViewRecyclerAdapter mRecyclerAdapter;

    private String tid;

    private static final String EXTRA_TID = "extra_tid";

    private View loadMoreView;


    public static PartitionListFragment newInstance(String tid)
    {

        PartitionListFragment fragment =
                new PartitionListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_TID, tid);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_partition_more_list;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        tid = getArguments().getString(EXTRA_TID);
        showProgressBar();
        initRecyclerView();
    }

    @Override
    protected void lazyLoad()
    {

    }

    private void initRecyclerView()
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
                getPartitionMore(tid);
                loadMoreView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void showProgressBar()
    {

        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {

            @Override
            public void onRefresh()
            {

                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
        mSwipeRefreshLayout.postDelayed(new Runnable()
        {

            @Override
            public void run()
            {

                mSwipeRefreshLayout.setRefreshing(true);
                getPartitionMore(tid);
            }
        }, 500);
    }

    public void getPartitionMore(final String tid)
    {

        RetrofitHelper.getPartitionMoreApi()
                .getPartitionMore(tid, pageNum,
                        pageSize, 0, Secret.APP_KEY,
                        Long.toString(System.currentTimeMillis() / 1000))
                .compose(this.<ResponseBody> bindToLifecycle())
                .map(new Func1<ResponseBody,PartitionMoreList>()
                {

                    @Override
                    public PartitionMoreList call(ResponseBody responseBody)
                    {

                        try
                        {
                            return PartitionMoreList.createFromJson(responseBody.string());
                        } catch (IOException e)
                        {
                            e.printStackTrace();
                            return null;
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<PartitionMoreList>()
                {

                    @Override
                    public void call(PartitionMoreList partitionMoreList)
                    {

                        if (partitionMoreList.lists.size() < pageSize)
                            loadMoreView.setVisibility(View.GONE);

                        items.addAll(partitionMoreList.lists);
                        finishTask();
                    }
                }, new Action1<Throwable>()
                {

                    @Override
                    public void call(Throwable throwable)
                    {

                        LogUtil.all("分区数据获取失败" + throwable.getMessage());
                        loadMoreView.setVisibility(View.GONE);
                        mSwipeRefreshLayout.post(new Runnable()
                        {

                            @Override
                            public void run()
                            {

                                mSwipeRefreshLayout.setRefreshing(false);
                            }
                        });
                    }
                });
    }

    private void finishTask()
    {

        if (pageNum * pageSize - pageSize - 1 > 0)
            mAdapter.notifyItemRangeChanged(pageNum * pageSize - pageSize - 1, pageSize);
        else
            mAdapter.notifyDataSetChanged();

        if (mSwipeRefreshLayout.isRefreshing())
        {
            mSwipeRefreshLayout.setRefreshing(false);
        }

        mAdapter.setOnItemClickListener(new AbsRecyclerViewAdapter.OnItemClickListener()
        {

            @Override
            public void onItemClick(int position, AbsRecyclerViewAdapter.ClickableViewHolder holder)
            {

                PartitionMoreVideoItem bangumiMoreVideoItem = items.get(position);
                VideoDetailsActivity.launch(getSupportActivity(), bangumiMoreVideoItem.aid,bangumiMoreVideoItem.pic);
            }
        });
    }

    private void createLoadMoreView()
    {

        loadMoreView = LayoutInflater.from(getActivity())
                .inflate(R.layout.layout_load_more, mRecyclerView, false);
        mRecyclerAdapter.addFooterView(loadMoreView);
        loadMoreView.setVisibility(View.GONE);
    }
}
