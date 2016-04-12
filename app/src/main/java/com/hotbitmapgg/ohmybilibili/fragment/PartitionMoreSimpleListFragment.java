package com.hotbitmapgg.ohmybilibili.fragment;

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
import com.hotbitmapgg.ohmybilibili.adapter.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.PartitionMoreListViewAdapter;
import com.hotbitmapgg.ohmybilibili.api.PartitionMoreApi;
import com.hotbitmapgg.ohmybilibili.model.PartitionMoreList;
import com.hotbitmapgg.ohmybilibili.model.PartitionMoreVideoItem;
import com.hotbitmapgg.ohmybilibili.okhttp.OkHttpClientManager;
import com.hotbitmapgg.ohmybilibili.ui.PartitionMoreActivity;
import com.hotbitmapgg.ohmybilibili.ui.VideoViewActivity;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.squareup.okhttp.Request;
import com.ypy.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import cn.easydone.swiperefreshendless.EndlessRecyclerOnScrollListener;
import cn.easydone.swiperefreshendless.HeaderViewRecyclerAdapter;


@SuppressLint("NewApi")
public class PartitionMoreSimpleListFragment extends PartitionMoreBaseHomeFragment
{

    private RecyclerView mRecyclerView;

    private PartitionMoreListViewAdapter mListViewAdapter;

    private PartitionMoreList videoData;

    private ArrayList<PartitionMoreVideoItem> items;

    private CircleProgressView mProgressView;

    private int pageNum = 1;

    private HeaderViewRecyclerAdapter mRecyclerAdapter;

    private String tid;

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private Handler mHandler = new Handler()
    {


        public void handleMessage(android.os.Message msg)
        {

            if (msg.what == 0)
            {
                makeUpItems();
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
                        VideoViewActivity.launch(getSupportActivity(), aid);
                    }
                });
            }
        }


    };



    public static PartitionMoreSimpleListFragment newInstance()
    {

        PartitionMoreSimpleListFragment fragment = new PartitionMoreSimpleListFragment();
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

        mRecyclerView = $(R.id.bangumi_more_list);
        mSwipeRefreshLayout = $(R.id.swipe_refresh_layout);

        mSwipeRefreshLayout.setColorSchemeResources(R.color.top_bar_bg);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {

            @Override
            public void onRefresh()
            {


            }
        });
        mSwipeRefreshLayout.setRefreshing(true);


        mProgressView = $(R.id.bangumi_more_list_circle_progress);

        videoData = ((PartitionMoreActivity) getActivity()).getIndexData();
        makeUpItems();

    }

    private void makeUpItems()
    {

        if (videoData != null)
        {

            items = (ArrayList<PartitionMoreVideoItem>) videoData.lists;
        } else
        {
            items = new ArrayList<>();
        }
    }

    @Override
    public void scrollToTop()
    {
        //mRecyclerView.smoothScrollToPosition(0);
    }

    @SuppressLint("NewApi")
    @Override
    public boolean canScrollVertically(int direction)
    {

        return mRecyclerView != null && mRecyclerView.canScrollVertically(direction);
    }

    @Override
    public void notifyIndexDataUpdate(PartitionMoreList data)
    {

        if (data == null)
            return;
        mRecyclerView.setVisibility(View.GONE);
        mProgressView.setVisibility(View.VISIBLE);
        mProgressView.spin();
        videoData = data;
        mHandler.sendEmptyMessageDelayed(0, 500);
    }

    public void LoadMoreBangumiMoreList(String tid, String pagenum)
    {

        String url = PartitionMoreApi.getListUrl(tid, pagenum, "10", PartitionMoreApi.ORDER_DEFAULT);
        OkHttpClientManager.getAsyn(url, new OkHttpClientManager.ResultCallback<String>()
        {

            @Override
            public void onError(Request request, Exception e)
            {
                // TODO Auto-generated method stub

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
                    }
                    mRecyclerAdapter.notifyDataSetChanged();

                } else
                {
                    mRecyclerAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy()
    {
        // TODO Auto-generated method stub
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(Bundle mBundle)
    {

        if (mBundle != null)
        {
            tid = mBundle.getString("tid");
        }
    }


    private void createLoadMoreView()
    {

        View loadMoreView = LayoutInflater.from(getActivity()).inflate(R.layout.recycle_view_foot_layout, mRecyclerView, false);
        mRecyclerAdapter.addFooterView(loadMoreView);
    }
}
