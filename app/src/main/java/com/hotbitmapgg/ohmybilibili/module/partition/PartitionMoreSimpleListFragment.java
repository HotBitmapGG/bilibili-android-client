package com.hotbitmapgg.ohmybilibili.module.partition;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.PartitionMoreListViewAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.api.PartitionMoreApi;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.model.partition.PartitionMoreList;
import com.hotbitmapgg.ohmybilibili.model.partition.PartitionMoreVideoItem;
import com.hotbitmapgg.ohmybilibili.module.video.VideoDetailsActivity;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.hotbitmapgg.ohmybilibili.widget.swiperefresh.EndlessRecyclerOnScrollListener;
import com.hotbitmapgg.ohmybilibili.widget.swiperefresh.HeaderViewRecyclerAdapter;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import okhttp3.Call;

/**
 * 分区详情列表界面
 *
 * @HotBitmapGG
 */
@SuppressLint("NewApi")
public class PartitionMoreSimpleListFragment extends RxLazyFragment
{

    @Bind(R.id.bangumi_more_list)
    RecyclerView mRecyclerView;

    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Bind(R.id.bangumi_more_list_circle_progress)
    CircleProgressView mProgressView;

    private PartitionMoreListViewAdapter mListViewAdapter;

    private ArrayList<PartitionMoreVideoItem> items = new ArrayList<>();

    private int pageNum = 1;

    private HeaderViewRecyclerAdapter mRecyclerAdapter;

    private String tid;

    private static final String EXTRA_TID = "extra_tid";


    private Handler mHandler = new Handler()
    {


        public void handleMessage(android.os.Message msg)
        {

            if (msg.what == 0)
            {
                mListViewAdapter = new PartitionMoreListViewAdapter(mRecyclerView, items);
                mRecyclerView.setHasFixedSize(true);
                LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
                mRecyclerView.setLayoutManager(mLinearLayoutManager);
                mRecyclerAdapter = new HeaderViewRecyclerAdapter(mListViewAdapter);
                mRecyclerView.setAdapter(mRecyclerAdapter);
                createLoadMoreView();
                mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(mLinearLayoutManager)
                {

                    @Override
                    public void onLoadMore(int i)
                    {

                        pageNum++;
                        LoadMoreBangumiMoreList(tid, pageNum + "");
                    }
                });
                mRecyclerView.setVisibility(View.VISIBLE);
                mProgressView.setVisibility(View.GONE);
                mProgressView.stopSpinning();
                mListViewAdapter.setOnItemClickListener(new AbsRecyclerViewAdapter.OnItemClickListener()
                {

                    @Override
                    public void onItemClick(int position, AbsRecyclerViewAdapter.ClickableViewHolder holder)
                    {

                        PartitionMoreVideoItem bangumiMoreVideoItem = items.get(position);
                        int aid = bangumiMoreVideoItem.aid;
                        VideoDetailsActivity.launch(getSupportActivity(), aid);
                    }
                });
            }
        }
    };

    private View loadMoreView;


    public static PartitionMoreSimpleListFragment newInstance(String tid)
    {

        PartitionMoreSimpleListFragment fragment = new PartitionMoreSimpleListFragment();
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

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @SuppressLint("NewApi")
    @Override
    public void finishCreateView(Bundle state)
    {

        Bundle arguments = getArguments();
        if (arguments != null)
        {
            tid = arguments.getString(EXTRA_TID);
        }

        mSwipeRefreshLayout.setColorSchemeResources(R.color.top_bar_bg);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {

            @Override
            public void onRefresh()
            {

                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        getBangumiMoreList(tid, "1");
    }

    public void getBangumiMoreList(String tid, String pagenum)
    {

        String url = PartitionMoreApi.getListUrl(tid, pagenum, "10", PartitionMoreApi.ORDER_DEFAULT);
        LogUtil.lsw(url);
        OkHttpUtils.get().url(url).build().execute(new StringCallback()
        {

            @Override
            public void onError(Call call, Exception e)
            {

            }

            @Override
            public void onResponse(String response)
            {

                PartitionMoreList bangumiMoreList = PartitionMoreList.createFromJson(response);
                if (bangumiMoreList.lists != null && bangumiMoreList.lists.size() > 0)
                {
                    items.clear();
                    items.addAll(bangumiMoreList.lists);
                }

                finishGetBangumiMoreTask();
            }
        });
    }

    private void finishGetBangumiMoreTask()
    {

        mRecyclerView.setVisibility(View.GONE);
        mProgressView.setVisibility(View.VISIBLE);
        mProgressView.spin();

        mHandler.sendEmptyMessageDelayed(0, 1000);
    }


    public void LoadMoreBangumiMoreList(String tid, String pagenum)
    {

        String url = PartitionMoreApi.getListUrl(tid, pagenum, "10", PartitionMoreApi.ORDER_DEFAULT);
        OkHttpUtils.get().url(url).build().execute(new StringCallback()
        {

            @Override
            public void onError(Call call, Exception e)
            {

            }

            @Override
            public void onResponse(String response)
            {

                if (!TextUtils.isEmpty(response))
                {
                    PartitionMoreList bangumiMoreList = PartitionMoreList.createFromJson(response);
                    List<PartitionMoreVideoItem> lists = bangumiMoreList.lists;
                    int size = lists.size();
                    for (int i = 0; i < size; i++)
                    {
                        items.add(lists.get(i));
                    }
                    if (lists.size() < 10)
                    {
                        mRecyclerAdapter.notifyDataSetChanged();
                        loadMoreView.setVisibility(View.GONE);
                    }
                    mRecyclerAdapter.notifyDataSetChanged();
                } else
                {
                    mRecyclerAdapter.notifyDataSetChanged();
                    loadMoreView.setVisibility(View.GONE);
                }
            }
        });
    }


    private void createLoadMoreView()
    {

        loadMoreView = LayoutInflater.from(getActivity()).inflate(R.layout.recycle_view_foot_layout, mRecyclerView, false);
        mRecyclerAdapter.addFooterView(loadMoreView);
    }
}
