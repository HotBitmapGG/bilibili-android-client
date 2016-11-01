package com.hotbitmapgg.ohmybilibili.module.video;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.VideoCommentAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.VideoHotCommentAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.helper.EndlessRecyclerOnScrollListener;
import com.hotbitmapgg.ohmybilibili.adapter.helper.HeaderViewRecyclerAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.video.VideoComment;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.ConstantUtil;

import java.util.ArrayList;

import butterknife.BindView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 视频评论界面
 */
public class VideoCommentFragment extends RxLazyFragment
{

    @BindView(R.id.recycle)
    RecyclerView mRecyclerView;

    private ArrayList<VideoComment.List> comments = new ArrayList<>();

    private ArrayList<VideoComment.HotList> hotComments = new ArrayList<>();

    private HeaderViewRecyclerAdapter mAdapter;

    private int pageNum = 1;

    private int pageSize = 20;

    private View loadMoreView;

    private int aid;

    private VideoHotCommentAdapter mVideoHotCommentAdapter;

    private View headView;

    public static VideoCommentFragment newInstance(int aid)
    {

        VideoCommentFragment fragment = new VideoCommentFragment();
        Bundle args = new Bundle();
        args.putInt(ConstantUtil.AID, aid);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_video_comment;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        aid = getArguments().getInt(ConstantUtil.AID);
        initRecyclerView();
        loadData();
    }

    @Override
    protected void initRecyclerView()
    {

        VideoCommentAdapter mRecyclerAdapter = new VideoCommentAdapter(mRecyclerView, comments);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mAdapter = new HeaderViewRecyclerAdapter(mRecyclerAdapter);
        mRecyclerView.setAdapter(mAdapter);
        createHeadView();
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

        int ver = 3;
        RetrofitHelper.getVideoCommentApi()
                .getVideoComment(aid, pageNum, pageSize, ver)
                .compose(this.bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(videoComment -> {

                    ArrayList<VideoComment.List> list = videoComment.list;
                    ArrayList<VideoComment.HotList> hotList = videoComment.hotList;
                    if (list.size() < pageSize)
                    {
                        loadMoreView.setVisibility(View.GONE);
                        mAdapter.removeFootView();
                    }
                    comments.addAll(list);
                    hotComments.addAll(hotList);
                    finishTask();
                }, throwable -> {

                    loadMoreView.setVisibility(View.GONE);
                    headView.setVisibility(View.GONE);
                });
    }

    @Override
    protected void finishTask()
    {

        loadMoreView.setVisibility(View.GONE);
        mVideoHotCommentAdapter.notifyDataSetChanged();

        if (pageNum * pageSize - pageSize - 1 > 0)
            mAdapter.notifyItemRangeChanged(pageNum * pageSize - pageSize - 1, pageSize);
        else
            mAdapter.notifyDataSetChanged();
    }

    private void createHeadView()
    {

        headView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_video_hot_comment_head,
                mRecyclerView, false);
        RecyclerView mHotCommentRecycler = (RecyclerView) headView.findViewById(R.id.hot_comment_recycler);
        mHotCommentRecycler.setHasFixedSize(false);
        mHotCommentRecycler.setNestedScrollingEnabled(false);
        mHotCommentRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mVideoHotCommentAdapter = new VideoHotCommentAdapter(mHotCommentRecycler, hotComments);
        mHotCommentRecycler.setAdapter(mVideoHotCommentAdapter);
        mAdapter.addHeaderView(headView);
    }

    private void createLoadMoreView()
    {

        loadMoreView = LayoutInflater.from(getActivity())
                .inflate(R.layout.layout_load_more, mRecyclerView, false);
        mAdapter.addFooterView(loadMoreView);
        loadMoreView.setVisibility(View.GONE);
    }
}

