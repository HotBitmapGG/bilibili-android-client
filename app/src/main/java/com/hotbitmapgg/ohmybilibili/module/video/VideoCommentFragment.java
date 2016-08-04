package com.hotbitmapgg.ohmybilibili.module.video;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.CommentAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.HotCommentAdapter;
import com.hotbitmapgg.ohmybilibili.api.VideoCommentApi;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.model.base.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.video.VideoComment;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.swiperefresh.EndlessRecyclerOnScrollListener;
import com.hotbitmapgg.ohmybilibili.widget.swiperefresh.HeaderViewRecyclerAdapter;

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
 * 视频评论
 *
 * @HotBitmapGG
 */
public class VideoCommentFragment extends RxLazyFragment
{

    @Bind(R.id.comment_list_recycle)
    RecyclerView mRecyclerView;

    private ArrayList<VideoComment.List> comments = new ArrayList<>();

    private ArrayList<VideoComment.HotList> hotComments = new ArrayList<>();

    private HeaderViewRecyclerAdapter mAdapter;

    private int pageNum = 1;

    private int pageSize = 20;

    private int ver = 3;

    private CommentAdapter mRecyclerAdapter;

    private static final String AID = "aid";

    private View loadMoreView;

    public static VideoCommentFragment newInstance(int aid)
    {

        VideoCommentFragment fragment = new VideoCommentFragment();
        Bundle args = new Bundle();
        args.putInt(AID, aid);
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

        getCommentList();
    }

    public void getCommentList()
    {

        Single<BasicMessage<VideoComment>> single = Single.fromCallable(new Callable<BasicMessage<VideoComment>>()
        {

            @Override
            public BasicMessage<VideoComment> call() throws Exception
            {

                return VideoCommentApi.getVideoCommentList(getArguments().getInt(AID), pageNum, pageSize, ver);
            }
        });

        Subscription subscribe = single.map(new Func1<BasicMessage<VideoComment>,VideoComment>()
        {

            @Override
            public VideoComment call(BasicMessage<VideoComment> videoCommentBasicMessage)
            {

                return videoCommentBasicMessage.getObject();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<VideoComment>()
                {

                    @Override
                    public void onSuccess(VideoComment value)
                    {

                        ArrayList<VideoComment.List> list = value.list;
                        ArrayList<VideoComment.HotList> hotList = value.hotList;
                        if (list != null && list.size() > 0 && hotList != null && hotList.size() > 0)
                        {
                            comments.addAll(list);
                            hotComments.addAll(hotList);
                            finishTask();
                        }
                    }

                    @Override
                    public void onError(Throwable error)
                    {

                        LogUtil.lsw("评论数据加载失败");
                    }
                });

        compositeSubscription.add(subscribe);
    }


    public void loadMoreCommentList()
    {

        Single<BasicMessage<VideoComment>> single = Single.fromCallable(new Callable<BasicMessage<VideoComment>>()
        {

            @Override
            public BasicMessage<VideoComment> call() throws Exception
            {

                return VideoCommentApi.getVideoCommentList(getArguments().getInt(AID), pageNum, pageSize, ver);
            }
        });

        Subscription subscribe = single.map(new Func1<BasicMessage<VideoComment>,VideoComment>()
        {

            @Override
            public VideoComment call(BasicMessage<VideoComment> videoCommentBasicMessage)
            {

                return videoCommentBasicMessage.getObject();
            }
        })
                .map(new Func1<VideoComment,ArrayList<VideoComment.List>>()
                {

                    @Override
                    public ArrayList<VideoComment.List> call(VideoComment videoComment)
                    {

                        return videoComment.list;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<ArrayList<VideoComment.List>>()
                {

                    @Override
                    public void onSuccess(ArrayList<VideoComment.List> value)
                    {

                        if (value != null && value.size() > 0)
                        {
                            for (int i = 0; i < value.size(); i++)
                            {
                                mRecyclerAdapter.addData(value.get(i));
                                mAdapter.notifyDataSetChanged();
                            }

                            if (value.size() < pageSize)
                            {
                                loadMoreView.setVisibility(View.GONE);
                                mAdapter.notifyDataSetChanged();
                            }
                        } else
                        {
                            loadMoreView.setVisibility(View.GONE);
                            mAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onError(Throwable error)
                    {

                        LogUtil.lsw("加载更多评论数据失败");
                        loadMoreView.setVisibility(View.GONE);
                        mAdapter.notifyDataSetChanged();
                    }
                });

        compositeSubscription.add(subscribe);
    }

    private void finishTask()
    {

        mRecyclerAdapter = new CommentAdapter(mRecyclerView, comments);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mAdapter = new HeaderViewRecyclerAdapter(mRecyclerAdapter);
        mRecyclerView.setAdapter(mAdapter);
        createLoadMoreView();
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(mLinearLayoutManager)
        {

            @Override
            public void onLoadMore(int i)
            {

                pageNum++;
                loadMoreCommentList();
            }
        });
    }

    private void createLoadMoreView()
    {

        View headView = LayoutInflater.from(getActivity()).inflate(R.layout.video_hot_comment_head_layout, mRecyclerView, false);
        loadMoreView = LayoutInflater.from(getActivity()).inflate(R.layout.recycle_view_foot_layout, mRecyclerView, false);


        mAdapter.addHeaderView(headView);
        mAdapter.addFooterView(loadMoreView);

        initHeadView(headView);
    }

    private void initHeadView(View headView)
    {

        RecyclerView mHotRecyclerView = (RecyclerView) headView.findViewById(R.id.hot_recycle);
        mHotRecyclerView.setHasFixedSize(false);
        mHotRecyclerView.setNestedScrollingEnabled(false);
        mHotRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        HotCommentAdapter mHotCommentAdapter = new HotCommentAdapter(mHotRecyclerView, hotComments);
        mHotRecyclerView.setAdapter(mHotCommentAdapter);
    }
}

