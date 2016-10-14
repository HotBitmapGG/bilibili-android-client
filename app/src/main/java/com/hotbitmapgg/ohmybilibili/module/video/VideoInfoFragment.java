package com.hotbitmapgg.ohmybilibili.module.video;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.VideoAlikeListAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.user.UserRecommendVideoInfo;
import com.hotbitmapgg.ohmybilibili.entity.video.VideoDetails;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.ConstantUtils;
import com.hotbitmapgg.ohmybilibili.widget.UserTagView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 视频详情Fragment
 */
public class VideoInfoFragment extends RxLazyFragment
{

    @Bind(R.id.tv_title)
    TextView mTitleText;

    @Bind(R.id.tv_play_time)
    TextView mPlayTimeText;

    @Bind(R.id.tv_review_count)
    TextView mReviewCountText;

    @Bind(R.id.tv_description)
    TextView mDescText;

    @Bind(R.id.author_tag)
    UserTagView mAuthorTagView;

    @Bind(R.id.share_num)
    TextView mShareNum;

    @Bind(R.id.coin_num)
    TextView mCoinNum;

    @Bind(R.id.fav_num)
    TextView mFavNum;

    @Bind(R.id.tags_layout)
    TagFlowLayout mTagFlowLayout;

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    private List<UserRecommendVideoInfo.AuthorData> authorRecommendList = new ArrayList<>();

    private VideoDetails mVideoDetails;

    private int av;

    public static VideoInfoFragment newInstance(VideoDetails info, int aid)
    {

        VideoInfoFragment fragment = new VideoInfoFragment();
        Bundle args = new Bundle();
        args.putInt(ConstantUtils.AID, aid);
        args.putParcelable(ConstantUtils.EXTRA_INFO, info);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_video_info;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        Bundle bundle = getArguments();
        if (bundle != null)
        {
            av = bundle.getInt(ConstantUtils.AID);
            mVideoDetails = bundle.getParcelable(ConstantUtils.EXTRA_INFO);
        }


        setVideoInfo();
    }

    private void setVideoInfo()
    {

        mTitleText.setText(mVideoDetails.getTitle());
        mPlayTimeText.setText(String.format(getString(R.string.info_play_times_format), Integer.valueOf(mVideoDetails.getPlay())));
        mReviewCountText.setText(String.format(getString(R.string.info_reviews_format), Integer.valueOf(mVideoDetails.getVideo_review())));
        mDescText.setText(mVideoDetails.getDescription());
        mAuthorTagView.setUpWithInfo(getActivity(),
                mVideoDetails.getAuthor(),
                Integer.valueOf(mVideoDetails.getMid()), mVideoDetails.getFace());

        mShareNum.setText(mVideoDetails.getReview());
        mFavNum.setText(mVideoDetails.getFavorites());
        mCoinNum.setText(mVideoDetails.getCoins());

        //设置视频tags
        setVideoTags();
        //获取相关视频列表
        getVideoRelateds();
    }

    private void setVideoTags()
    {

        String tag = mVideoDetails.getTag();
        String[] tagsArray = tag.split(",");
        List<String> tags = Arrays.asList(tagsArray);

        mTagFlowLayout.setAdapter(new TagAdapter<String>(tags)
        {

            @Override
            public View getView(FlowLayout parent, int position, String s)
            {

                TextView mTags = (TextView) LayoutInflater.from(getActivity())
                        .inflate(R.layout.layout_tags_item, parent, false);
                mTags.setText(s);

                return mTags;
            }
        });
    }


    public void getVideoRelateds()
    {

        RetrofitHelper.getAuthorRecommendedApi()
                .getAuthorRecommended(av)
                .compose(this.bindToLifecycle())
                .map(userRecommend -> userRecommend.list)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(authorDatas -> {

                    authorRecommendList.addAll(authorDatas);
                    finishTask();
                }, throwable -> {

                });
    }


    private void finishTask()
    {

        VideoAlikeListAdapter mVideoAlikeListAdapter = new VideoAlikeListAdapter(
                mRecyclerView, authorRecommendList,mVideoDetails.getAuthor());
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mVideoAlikeListAdapter);
        mVideoAlikeListAdapter.setOnItemClickListener((position, holder) -> {

            getActivity().finish();
            UserRecommendVideoInfo.AuthorData authorData = authorRecommendList.get(position);
            VideoDetailsActivity.launch(getActivity(), authorData.aid, authorData.cover);
        });
    }

    @OnClick(R.id.btn_share)
    void share()
    {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
        intent.putExtra(Intent.EXTRA_TEXT, "来自「哔哩哔哩」的分享:" + mVideoDetails.getDescription());
        startActivity(Intent.createChooser(intent, mVideoDetails.getTitle()));
    }
}
