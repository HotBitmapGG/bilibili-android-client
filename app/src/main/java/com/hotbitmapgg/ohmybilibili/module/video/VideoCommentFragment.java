package com.hotbitmapgg.ohmybilibili.module.video;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.VideoCommentAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.video.VideoComment;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.recyclerview_helper.EndlessRecyclerOnScrollListener;
import com.hotbitmapgg.ohmybilibili.widget.recyclerview_helper.HeaderViewRecyclerAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 视频评论界面
 */
public class VideoCommentFragment extends RxLazyFragment
{

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    private ArrayList<VideoComment.List> comments = new ArrayList<>();

    private HeaderViewRecyclerAdapter mAdapter;

    private int pageNum = 1;

    private int pageSize = 20;

    private int ver = 3;

    private VideoCommentAdapter mRecyclerAdapter;

    private static final String AID = "aid";

    private View loadMoreView;

    private int aid;

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

        aid = getArguments().getInt(AID);
        initRecyclerView();
        getCommentList();
    }

    @Override
    protected void lazyLoad()
    {

    }

    private void initRecyclerView()
    {

        mRecyclerAdapter = new VideoCommentAdapter(mRecyclerView, comments);
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
                getCommentList();
                loadMoreView.setVisibility(View.VISIBLE);
            }
        });
    }

    public void getCommentList()
    {

        RetrofitHelper.getVideoCommentApi()
                .getVideoComment(aid, pageNum, pageSize, ver)
                .compose(this.<VideoComment> bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<VideoComment>()
                {

                    @Override
                    public void call(VideoComment videoComment)
                    {

                        ArrayList<VideoComment.List> list = videoComment.list;
                        if (list.size() < pageSize)
                            loadMoreView.setVisibility(View.GONE);

                        comments.addAll(list);
                        finishTask();
                    }
                }, new Action1<Throwable>()
                {

                    @Override
                    public void call(Throwable throwable)
                    {

                        LogUtil.all("视频评论数据获取失败" + throwable.getMessage());
                        loadMoreView.setVisibility(View.GONE);
                    }
                });
    }

    private void finishTask()
    {

        if (pageNum * pageSize - pageSize - 1 > 0)
            mAdapter.notifyItemRangeChanged(pageNum * pageSize - pageSize - 1, pageSize);
        else
            mAdapter.notifyDataSetChanged();
    }

    private void createLoadMoreView()
    {

        loadMoreView = LayoutInflater.from(getActivity())
                .inflate(R.layout.layout_load_more, mRecyclerView, false);
        mAdapter.addFooterView(loadMoreView);
        loadMoreView.setVisibility(View.GONE);
    }
}

