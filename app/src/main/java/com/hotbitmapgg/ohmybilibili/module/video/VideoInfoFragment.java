package com.hotbitmapgg.ohmybilibili.module.video;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.VideoAlikeListAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.config.Secret;
import com.hotbitmapgg.ohmybilibili.entity.video.VideoAlikeInfo;
import com.hotbitmapgg.ohmybilibili.entity.video.VideoAlikeResult;
import com.hotbitmapgg.ohmybilibili.entity.video.VideoDetails;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.UserTagView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
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

    @Bind(R.id.tv_created_at)
    TextView mCreatedAtText;

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
    RecyclerView mVideoPartList;

    @Bind(R.id.btn_more_video)
    TextView mMoreVideo;

    private static final String AID = "aid";

    private static final String EXTRA_INFO = "extra_info";

    private List<VideoAlikeInfo> mUserVideos = new ArrayList<>();

    private VideoAlikeListAdapter mVideoAlikeListAdapter;

    private VideoDetails mVideoDetails;

    private int av;

    public static VideoInfoFragment newInstance(VideoDetails info, int aid)
    {

        VideoInfoFragment fragment = new VideoInfoFragment();
        Bundle args = new Bundle();
        args.putInt(AID, aid);
        args.putParcelable(EXTRA_INFO, info);
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
            av = bundle.getInt(AID);
            mVideoDetails = bundle.getParcelable(EXTRA_INFO);
        }


        setVideoInfo();
    }

    private void setVideoInfo()
    {

        mTitleText.setText(mVideoDetails.getTitle());
        mPlayTimeText.setText(String.format(getString(R.string.info_play_times_format), Integer.valueOf(mVideoDetails.getPlay())));
        mReviewCountText.setText(String.format(getString(R.string.info_reviews_format), Integer.valueOf(mVideoDetails.getVideo_review())));
        mDescText.setText(mVideoDetails.getDescription());
        mCreatedAtText.setText(mVideoDetails.getCreated_at());
        mAuthorTagView.setUpWithInfo(getActivity(),
                mVideoDetails.getAuthor(),
                Integer.valueOf(mVideoDetails.getMid()), mVideoDetails.getFace());

        mShareNum.setText(mVideoDetails.getReview());
        mFavNum.setText(mVideoDetails.getFavorites());
        mCoinNum.setText(mVideoDetails.getCoins());

        mMoreVideo.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                Intent mIntent = new Intent(getActivity(), VideoPartsListMoreActivity.class);
                mIntent.putExtra("aid", av + "");
                startActivity(mIntent);
            }
        });

        setVideoTags();

        //获取该用户推荐的视频列表
        getVideoListPartsByTid(mVideoDetails.getTid() + "");
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


    public void getVideoListPartsByTid(String tid)
    {

        if (TextUtils.isEmpty(Secret.APP_KEY))
            return;

        Random random = new Random();
        int anInt = random.nextInt(50);


        RetrofitHelper.getPartitionMoreApi()
                .getPartitionMore(tid, anInt,
                        10, 0, Secret.APP_KEY,
                        Long.toString(System.currentTimeMillis() / 1000))
                .compose(this.<ResponseBody> bindToLifecycle())
                .map(new Func1<ResponseBody,VideoAlikeResult>()
                {

                    @Override
                    public VideoAlikeResult call(ResponseBody responseBody)
                    {

                        try
                        {
                            return VideoAlikeResult.createFromJson(responseBody.string());
                        } catch (IOException e)
                        {
                            e.printStackTrace();
                            return null;
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<VideoAlikeResult>()
                {

                    @Override
                    public void call(VideoAlikeResult videoAlikeResult)
                    {

                        List<VideoAlikeInfo> datas = videoAlikeResult.lists;
                        mUserVideos.addAll(datas);

                        finishPartsGetTask();
                    }
                }, new Action1<Throwable>()
                {

                    @Override
                    public void call(Throwable throwable)
                    {

                        LogUtil.all("根据类型查询相关视频失败" + throwable.getMessage());
                    }
                });
    }


    private void finishPartsGetTask()
    {

        mVideoAlikeListAdapter = new VideoAlikeListAdapter(mVideoPartList, mUserVideos);
        mVideoPartList.setHasFixedSize(false);
        mVideoPartList.setNestedScrollingEnabled(false);
        mVideoPartList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mVideoPartList.setAdapter(mVideoAlikeListAdapter);
        mVideoAlikeListAdapter.setOnItemClickListener(new AbsRecyclerViewAdapter.OnItemClickListener()
        {

            @Override
            public void onItemClick(int position, AbsRecyclerViewAdapter.ClickableViewHolder holder)
            {

                getActivity().finish();
                VideoAlikeInfo videoAlikeInfo = mUserVideos.get(position);
                VideoDetailsActivity.launch(getActivity(), videoAlikeInfo.aid,videoAlikeInfo.pic);
            }
        });
    }

    @OnClick(R.id.btn_share)
    void share()
    {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
        intent.putExtra(Intent.EXTRA_TEXT, "来自「哔哩哔哩」的分享:" + mVideoDetails.describeContents());
        startActivity(Intent.createChooser(intent, mVideoDetails.getTitle()));
    }


    @Override
    protected void lazyLoad()
    {

    }

}
