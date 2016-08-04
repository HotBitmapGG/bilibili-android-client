package com.hotbitmapgg.ohmybilibili.module.video;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.VideoAlikeListAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.model.user.UserVideoItem;
import com.hotbitmapgg.ohmybilibili.model.user.UserVideoList;
import com.hotbitmapgg.ohmybilibili.model.video.VideoViewInfo;
import com.hotbitmapgg.ohmybilibili.network.ApiHelper;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.UserTagView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 视频详情
 *
 * @HotBitmapGG
 */
public class VideoInfoFragment extends RxLazyFragment
{


    @Bind(R.id.container_view)
    LinearLayout mContainer;

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

    @Bind(R.id.video_part_list)
    RecyclerView mVideoPartList;

    @Bind(R.id.btn_more_video)
    TextView mMoreVideo;

    @Bind(R.id.btn_share)
    LinearLayout mShare;

    @Bind(R.id.btn_coin)
    LinearLayout mCoin;

    @Bind(R.id.btn_fav)
    LinearLayout mFav;

    @Bind(R.id.btn_download)
    LinearLayout mDownload;

    private static final String AID = "aid";

    private static final String EXTRA_INFO = "extra_info";

    private List<UserVideoItem> userVideoList = new ArrayList<>();

    private VideoAlikeListAdapter mVideoAlikeListAdapter;

    private VideoViewInfo viewInfo;

    private int av;

    public static VideoInfoFragment newInstance(VideoViewInfo info, int aid)
    {

        VideoInfoFragment fragment = new VideoInfoFragment();
        Bundle args = new Bundle();
        args.putInt(AID, aid);
        args.putSerializable(EXTRA_INFO, info);
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
            viewInfo = (VideoViewInfo) bundle.getSerializable(EXTRA_INFO);
        }


        setVideoInfo();
    }


    private void setVideoInfo()
    {

        mTitleText.setText(viewInfo.title);
        mPlayTimeText.setText(String.format(getString(R.string.info_play_times_format), viewInfo.play));
        mReviewCountText.setText(String.format(getString(R.string.info_reviews_format), viewInfo.video_review));
        mDescText.setText(viewInfo.description);
        mCreatedAtText.setText(viewInfo.created_at);
        mAuthorTagView.setUpWithInfo(getActivity(), viewInfo.author, viewInfo.mid, viewInfo.face);

        mShareNum.setText(viewInfo.credit + "");
        mFavNum.setText(viewInfo.favorites + "");
        mCoinNum.setText(viewInfo.coins + "");

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
        getVideoListPartsByTid(viewInfo.tid + "");
    }

    private void setVideoTags()
    {

        String tag = viewInfo.tag;
        String[] tagsArray = tag.split(",");
        List<String> tags = Arrays.asList(tagsArray);

        mTagFlowLayout.setAdapter(new TagAdapter<String>(tags)
        {

            @Override
            public View getView(FlowLayout parent, int position, String s)
            {

                TextView mTags = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.tags_layout, parent, false);
                mTags.setText(s);

                return mTags;
            }
        });
    }


    public void getVideoListPartsByTid(String tid)
    {

        Random random = new Random();
        int anInt = random.nextInt(50);
        String url = ApiHelper.getVideoListPartsByTid(tid, anInt + "", "10", "default");
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

                UserVideoList partsList = UserVideoList.createFromJson(response);
                if (partsList != null)
                {
                    List<UserVideoItem> datas = partsList.lists;
                    userVideoList.addAll(datas);

                    finishPartsGetTask();
                }
            }
        });
    }


    private void finishPartsGetTask()
    {

        mVideoAlikeListAdapter = new VideoAlikeListAdapter(mVideoPartList, userVideoList);
        mVideoPartList.setHasFixedSize(false);
        mVideoPartList.setNestedScrollingEnabled(false);
        mVideoPartList.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mVideoPartList.setAdapter(mVideoAlikeListAdapter);
        mVideoAlikeListAdapter.setOnItemClickListener(new AbsRecyclerViewAdapter.OnItemClickListener()
        {

            @Override
            public void onItemClick(int position, AbsRecyclerViewAdapter.ClickableViewHolder holder)
            {

                getActivity().finish();
                UserVideoItem userVideoItem = userVideoList.get(position);
                int aid = userVideoItem.aid;
                VideoDetailsActivity.launch(getActivity(), aid);
            }
        });
    }

    @OnClick(R.id.btn_share)
    void share()
    {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
        intent.putExtra(Intent.EXTRA_TEXT, "来自「哔哩哔哩」的分享:" + viewInfo.offsite);
        startActivity(Intent.createChooser(intent, viewInfo.title));
    }
}
