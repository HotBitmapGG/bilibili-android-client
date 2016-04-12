package com.hotbitmapgg.ohmybilibili.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.CommentAdapter;
import com.hotbitmapgg.ohmybilibili.api.VideoCommentApi;
import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.VideoComment;
import com.hotbitmapgg.ohmybilibili.network.AbsAsyncTask;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.DividerItemDecoration;

import java.util.ArrayList;

import cn.easydone.swiperefreshendless.EndlessRecyclerOnScrollListener;
import cn.easydone.swiperefreshendless.HeaderViewRecyclerAdapter;

/**
 * Created by hcc on 16/3/27.
 * <p/>
 * 视频评论
 */
public class VideoCommentFragment extends LazyFragment
{

    private RecyclerView mRecyclerView;

    private ArrayList<VideoComment.List> comments = new ArrayList<>();

    private HeaderViewRecyclerAdapter mAdapter;

    private int pageNum = 1;

    private int pageSize = 20;

    private int ver = 3;

    private CommentAdapter mRecyclerAdapter;

    private static final String AID = "aid";

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

        mRecyclerView = $(R.id.comment_list_recycle);

        new GetCommentListTaskAbs().execute();
    }

    public class GetCommentListTaskAbs extends AbsAsyncTask<Void,Void,BasicMessage<VideoComment>>
    {

        @Override
        protected BasicMessage<VideoComment> doInBackground(Void... params)
        {

            return VideoCommentApi.getVideoCommentList(getArguments().getInt(AID), pageNum, pageSize, ver);
        }

        @Override
        protected void onPostExecute(BasicMessage<VideoComment> videoCommentBasicMessage)
        {

            if (videoCommentBasicMessage != null)
            {
                VideoComment videoComment = videoCommentBasicMessage.getObject();
                ArrayList<VideoComment.List> list = videoComment.list;
                if (list != null && list.size() > 0)
                {
                    comments.addAll(list);

                    finishTask();
                }
            } else
            {
                LogUtil.lsw("数据为空");
            }

            super.onPostExecute(videoCommentBasicMessage);
        }
    }


    public class LoadMoreCommentListTaskAbs extends AbsAsyncTask<Void,Void,BasicMessage<VideoComment>>
    {

        @Override
        protected BasicMessage<VideoComment> doInBackground(Void... params)
        {

            return VideoCommentApi.getVideoCommentList(getArguments().getInt(AID), pageNum, pageSize, ver);
        }

        @Override
        protected void onPostExecute(BasicMessage<VideoComment> videoCommentBasicMessage)
        {

            if (videoCommentBasicMessage != null)
            {
                VideoComment videoComment = videoCommentBasicMessage.getObject();
                ArrayList<VideoComment.List> list = videoComment.list;
                if (list != null && list.size() > 0)
                {
                    for (int i = 0; i < list.size(); i++)
                    {
                        mRecyclerAdapter.addData(list.get(i));
                        mAdapter.notifyDataSetChanged();
                    }

                    if (list.size() < pageSize)
                    {
                        mAdapter.notifyDataSetChanged();
                    }
                } else
                {
                    mAdapter.notifyDataSetChanged();
                }
            } else
            {
                mAdapter.notifyDataSetChanged();
            }

            super.onPostExecute(videoCommentBasicMessage);
        }
    }

    private void finishTask()
    {


        mRecyclerAdapter = new CommentAdapter(mRecyclerView, comments);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
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
                new LoadMoreCommentListTaskAbs().execute();
            }
        });
    }

    private void createLoadMoreView()
    {

        View loadMoreView = LayoutInflater.from(getActivity()).inflate(R.layout.recycle_view_foot_layout, mRecyclerView, false);
        mAdapter.addFooterView(loadMoreView);
    }
}

