package com.hotbitmapgg.ohmybilibili.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.HotCommentAdapter;
import com.hotbitmapgg.ohmybilibili.api.VideoCommentApi;
import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.VideoComment;
import com.hotbitmapgg.ohmybilibili.network.AbsAsyncTask;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.DividerItemDecoration;

import java.util.ArrayList;

/**
 * Created by hcc on 16/3/27.
 * <p/>
 * 视频热门评论
 */
public class VideoHotCommentFragment extends LazyFragment
{

    private RecyclerView mRecyclerView;

    private ArrayList<VideoComment.HotList> hotComments = new ArrayList<>();

    private int pageNum = 1;

    private int pageSize = 20;

    private int ver = 3;

    private HotCommentAdapter mRecyclerAdapter;

    private static final  String AID = "aid";

    public static VideoHotCommentFragment newInstance(int aid)
    {

        VideoHotCommentFragment fragment = new VideoHotCommentFragment();
        Bundle args = new Bundle();
        args.putInt(AID, aid);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_video_hot_comment;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        mRecyclerView = $(R.id.comment_hot_recycle);

        new GetHotCommentListTaskAbs().execute();
    }

    public class GetHotCommentListTaskAbs extends AbsAsyncTask<Void,Void,BasicMessage<VideoComment>>
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
                ArrayList<VideoComment.HotList> hotList = videoComment.hotList;
                if (hotList != null && hotList.size() > 0)
                {
                    hotComments.addAll(hotList);

                    finishTask();
                }
            } else
            {
                LogUtil.lsw("数据为空");
            }

            super.onPostExecute(videoCommentBasicMessage);
        }
    }

    private void finishTask()
    {

        mRecyclerAdapter = new HotCommentAdapter(mRecyclerView, hotComments);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }
}
