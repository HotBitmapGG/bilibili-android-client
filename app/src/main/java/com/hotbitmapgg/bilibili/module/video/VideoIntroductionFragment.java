package com.hotbitmapgg.bilibili.module.video;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hotbitmapgg.bilibili.adapter.VideoRelatedAdapter;
import com.hotbitmapgg.bilibili.base.RxLazyFragment;
import com.hotbitmapgg.bilibili.entity.video.VideoDetailsInfo;
import com.hotbitmapgg.bilibili.network.RetrofitHelper;
import com.hotbitmapgg.bilibili.utils.ConstantUtil;
import com.hotbitmapgg.bilibili.utils.NumberUtil;
import com.hotbitmapgg.bilibili.widget.UserTagView;
import com.hotbitmapgg.ohmybilibili.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 视频简介界面
 */
public class VideoIntroductionFragment extends RxLazyFragment {
    @BindView(R.id.tv_title)
    TextView mTitleText;
    @BindView(R.id.tv_play_time)
    TextView mPlayTimeText;
    @BindView(R.id.tv_review_count)
    TextView mReviewCountText;
    @BindView(R.id.tv_description)
    TextView mDescText;
    @BindView(R.id.author_tag)
    UserTagView mAuthorTagView;
    @BindView(R.id.share_num)
    TextView mShareNum;
    @BindView(R.id.coin_num)
    TextView mCoinNum;
    @BindView(R.id.fav_num)
    TextView mFavNum;
    @BindView(R.id.tags_layout)
    TagFlowLayout mTagFlowLayout;
    @BindView(R.id.recycle)
    RecyclerView mRecyclerView;
    @BindView(R.id.layout_video_related)
    RelativeLayout mVideoRelatedLayout;

    private int av;
    private VideoDetailsInfo.DataBean mVideoDetailsInfo;

    public static VideoIntroductionFragment newInstance(int aid) {
        VideoIntroductionFragment fragment = new VideoIntroductionFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ConstantUtil.EXTRA_AV, aid);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_video_introduction;
    }

    @Override
    public void finishCreateView(Bundle state) {
        av = getArguments().getInt(ConstantUtil.EXTRA_AV);
        loadData();
    }

    @Override
    protected void loadData() {
        RetrofitHelper.getBiliAppAPI()
                .getVideoDetails(av)
                .compose(this.bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(videoDetails -> {
                    mVideoDetailsInfo = videoDetails.getData();
                    finishTask();
                }, throwable -> {
                });
    }


    @Override
    protected void finishTask() {
        //设置视频标题
        mTitleText.setText(mVideoDetailsInfo.getTitle());
        //设置视频播放数量
        mPlayTimeText.setText(NumberUtil.converString(mVideoDetailsInfo.getStat().getView()));
        //设置视频弹幕数量
        mReviewCountText.setText(NumberUtil.converString(mVideoDetailsInfo.getStat().getDanmaku()));
        //设置Up主信息
        mDescText.setText(mVideoDetailsInfo.getDesc());
        mAuthorTagView.setUpWithInfo(getActivity(), mVideoDetailsInfo.getOwner().getName(),
                mVideoDetailsInfo.getOwner().getMid(), mVideoDetailsInfo.getOwner().getFace());
        //设置分享 收藏 投币数量
        mShareNum.setText(NumberUtil.converString(mVideoDetailsInfo.getStat().getShare()));
        mFavNum.setText(NumberUtil.converString(mVideoDetailsInfo.getStat().getFavorite()));
        mCoinNum.setText(NumberUtil.converString(mVideoDetailsInfo.getStat().getCoin()));
        //设置视频tags
        setVideoTags();
        //设置视频相关
        setVideoRelated();
    }

    private void setVideoRelated() {
        List<VideoDetailsInfo.DataBean.RelatesBean> relates = mVideoDetailsInfo.getRelates();
        if (relates == null) {
            mVideoRelatedLayout.setVisibility(View.GONE);
            return;
        }
        VideoRelatedAdapter mVideoRelatedAdapter = new VideoRelatedAdapter(mRecyclerView, relates);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true));
        mRecyclerView.setAdapter(mVideoRelatedAdapter);
        mVideoRelatedAdapter.setOnItemClickListener((position, holder) -> VideoDetailsActivity.launch(getActivity(),
                relates.get(position).getAid(), relates.get(position).getPic()));
    }

    private void setVideoTags() {
        List<String> tags = mVideoDetailsInfo.getTags();
        mTagFlowLayout.setAdapter(new TagAdapter<String>(tags) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView mTags = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.layout_tags_item, parent, false);
                mTags.setText(s);
                return mTags;
            }
        });
    }


    @OnClick(R.id.btn_share)
    void share() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
        intent.putExtra(Intent.EXTRA_TEXT, "来自「哔哩哔哩」的分享:" + mVideoDetailsInfo.getDesc());
        startActivity(Intent.createChooser(intent, mVideoDetailsInfo.getTitle()));
    }
}
