package com.hotbitmapgg.ohmybilibili.adapter.section;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.entity.recommended.RecommendInfo;
import com.hotbitmapgg.ohmybilibili.module.home.bangumi.BangumiIndexActivity;
import com.hotbitmapgg.ohmybilibili.module.home.bangumi.WeekDayBangumiActivity;
import com.hotbitmapgg.ohmybilibili.module.home.recommend.HotVideoIndexActivity;
import com.hotbitmapgg.ohmybilibili.module.home.live.LivePlayerActivity;
import com.hotbitmapgg.ohmybilibili.module.video.VideoDetailsActivity;
import com.hotbitmapgg.ohmybilibili.utils.DisplayUtil;
import com.hotbitmapgg.ohmybilibili.widget.sectioned.StatelessSection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hcc on 16/8/27 11:51
 * 100332338@qq.com
 * <p/>
 * 首页推荐界面Section
 */
public class HomeRecommendedSection extends StatelessSection
{

    private Context mContext;

    private int iconRes;

    private String title;

    private String type;

    private int liveCount;

    private static final String TYPE_RECOMMENDED = "recommend";

    private static final String TYPE_LIVE = "live";

    private static final String TYPE_BANGUMI = "bangumi_2";

    private static final String TYPE_WEBLINK = "weblink";

    private static final String TYPE_ACTIVITY = "activity";

    private List<RecommendInfo.ResultBean.BodyBean> datas = new ArrayList<>();

    private final Random mRandom;


    public HomeRecommendedSection(Context context, int iconRes, String title,
                                  String type, int liveCount,
                                  List<RecommendInfo.ResultBean.BodyBean> datas)
    {

        super(R.layout.layout_home_recommend_head,
                R.layout.layout_home_recommend_foot,
                R.layout.layout_home_recommend_boby);

        this.mContext = context;
        this.iconRes = iconRes;
        this.title = title;
        this.type = type;
        this.liveCount = liveCount;
        this.datas = datas;

        mRandom = new Random();
    }

    @Override
    public int getContentItemsTotal()
    {

        return datas.size();
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view)
    {

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position)
    {

        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        final RecommendInfo.ResultBean.BodyBean bodyBean = datas.get(position);

        Glide.with(mContext)
                .load(Uri.parse(bodyBean.getCover()))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .placeholder(R.drawable.bili_default_image_tv)
                .into(itemViewHolder.mVideoImg);

        itemViewHolder.mVideoTitle.setText(bodyBean.getTitle());
        itemViewHolder.mCardView.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                String gotoX = bodyBean.getGotoX();
                if (gotoX.equals(TYPE_LIVE))
                {
                    LivePlayerActivity.launch((Activity) mContext,
                            Integer.valueOf(bodyBean.getParam()), bodyBean.getTitle(),
                            bodyBean.getOnline(), bodyBean.getUpFace(), bodyBean.getUp(), 0);
                } else
                {
                    VideoDetailsActivity.launch((Activity) mContext,
                            Integer.parseInt(bodyBean.getParam()),bodyBean.getCover());
                }
            }
        });

        if (type.equals(TYPE_LIVE))
        {
            //直播item
            itemViewHolder.mLiveLayout.setVisibility(View.VISIBLE);
            itemViewHolder.mVideoLayout.setVisibility(View.GONE);
            itemViewHolder.mLiveUp.setText(bodyBean.getUp());
            itemViewHolder.mLiveOnline.setText(String.valueOf(bodyBean.getOnline()));
        } else if (type.equals(TYPE_BANGUMI))
        {
            // 番剧item
            itemViewHolder.mLiveLayout.setVisibility(View.VISIBLE);
            itemViewHolder.mVideoLayout.setVisibility(View.GONE);
            itemViewHolder.mLiveUp.setText(bodyBean.getDesc1());
        } else if (type.equals(TYPE_ACTIVITY))
        {
            ViewGroup.LayoutParams layoutParams = itemViewHolder.mCardView.getLayoutParams();
            layoutParams.height = DisplayUtil.dp2px(mContext, 200f);
            itemViewHolder.mCardView.setLayoutParams(layoutParams);
            itemViewHolder.mLiveLayout.setVisibility(View.GONE);
            itemViewHolder.mVideoLayout.setVisibility(View.GONE);
        } else
        {
            itemViewHolder.mLiveLayout.setVisibility(View.GONE);
            itemViewHolder.mVideoLayout.setVisibility(View.VISIBLE);
            itemViewHolder.mVideoPlayNum.setText(bodyBean.getPlay());
            itemViewHolder.mVideoReviewCount.setText(bodyBean.getDanmaku());
        }
    }


    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view)
    {

        return new HeaderViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder)
    {

        HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
        headerViewHolder.mTypeImg.setImageResource(iconRes);
        headerViewHolder.mTypeTv.setText(title);
        headerViewHolder.mTypeRankBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                mContext.startActivity(new Intent(mContext, HotVideoIndexActivity.class));
            }
        });

        if (type.equals(TYPE_RECOMMENDED))
        {
            headerViewHolder.mTypeMore.setVisibility(View.GONE);
            headerViewHolder.mTypeRankBtn.setVisibility(View.VISIBLE);
            headerViewHolder.mAllLiveNum.setVisibility(View.GONE);
        } else if (type.equals(TYPE_LIVE))
        {
            headerViewHolder.mTypeRankBtn.setVisibility(View.GONE);
            headerViewHolder.mTypeMore.setVisibility(View.VISIBLE);
            headerViewHolder.mAllLiveNum.setVisibility(View.VISIBLE);
            headerViewHolder.mAllLiveNum.setText("当前" + liveCount + "个直播");
        } else
        {
            headerViewHolder.mTypeRankBtn.setVisibility(View.GONE);
            headerViewHolder.mTypeMore.setVisibility(View.VISIBLE);
            headerViewHolder.mAllLiveNum.setVisibility(View.GONE);
        }
    }


    @Override
    public RecyclerView.ViewHolder getFooterViewHolder(View view)
    {

        return new FootViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindFooterViewHolder(RecyclerView.ViewHolder holder)
    {

        final FootViewHolder footViewHolder = (FootViewHolder) holder;
        footViewHolder.mDynamic.setText(String.valueOf(mRandom.nextInt(200)) + "条新动态,点这里刷新");
        footViewHolder.mRefreshBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                footViewHolder.mRefreshBtn
                        .animate()
                        .rotation(360)
                        .setInterpolator(new LinearInterpolator())
                        .setDuration(1000).start();
            }
        });

        footViewHolder.mRecommendRefresh.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                footViewHolder.mRecommendRefresh
                        .animate()
                        .rotation(360)
                        .setInterpolator(new LinearInterpolator())
                        .setDuration(1000).start();
            }
        });
        footViewHolder.mBangumiIndexBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                mContext.startActivity(new Intent(mContext, BangumiIndexActivity.class));
            }
        });
        footViewHolder.mBangumiTimelineBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                WeekDayBangumiActivity.launch((Activity) mContext, "二次元新番", 2);
            }
        });

        if (type.equals(TYPE_RECOMMENDED))
        {
            footViewHolder.mMoreBtn.setVisibility(View.GONE);
            footViewHolder.mRefreshLayout.setVisibility(View.GONE);
            footViewHolder.mBangumiLayout.setVisibility(View.GONE);
            footViewHolder.mRecommendRefreshLayout.setVisibility(View.VISIBLE);
        } else if (type.equals(TYPE_BANGUMI))
        {
            footViewHolder.mMoreBtn.setVisibility(View.GONE);
            footViewHolder.mRefreshLayout.setVisibility(View.GONE);
            footViewHolder.mRecommendRefreshLayout.setVisibility(View.GONE);
            footViewHolder.mBangumiLayout.setVisibility(View.VISIBLE);
        } else if (type.equals(TYPE_ACTIVITY))
        {
            footViewHolder.mRecommendRefreshLayout.setVisibility(View.GONE);
            footViewHolder.mBangumiLayout.setVisibility(View.GONE);
            footViewHolder.mMoreBtn.setVisibility(View.GONE);
            footViewHolder.mRefreshLayout.setVisibility(View.GONE);
        } else
        {
            footViewHolder.mRecommendRefreshLayout.setVisibility(View.GONE);
            footViewHolder.mBangumiLayout.setVisibility(View.GONE);
            footViewHolder.mMoreBtn.setVisibility(View.VISIBLE);
            footViewHolder.mRefreshLayout.setVisibility(View.VISIBLE);
        }
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder
    {

        @Bind(R.id.item_type_img)
        ImageView mTypeImg;

        @Bind(R.id.item_type_tv)
        TextView mTypeTv;

        @Bind(R.id.item_type_more)
        TextView mTypeMore;

        @Bind(R.id.item_type_rank_btn)
        TextView mTypeRankBtn;

        @Bind(R.id.item_live_all_num)
        public TextView mAllLiveNum;


        public HeaderViewHolder(View itemView)
        {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    static class ItemViewHolder extends RecyclerView.ViewHolder
    {


        @Bind(R.id.card_view)
        CardView mCardView;

        @Bind(R.id.video_preview)
        ImageView mVideoImg;

        @Bind(R.id.video_title)
        TextView mVideoTitle;

        @Bind(R.id.video_play_num)
        TextView mVideoPlayNum;

        @Bind(R.id.video_review_count)
        TextView mVideoReviewCount;

        @Bind(R.id.layout_live)
        RelativeLayout mLiveLayout;

        @Bind(R.id.layout_video)
        LinearLayout mVideoLayout;

        @Bind(R.id.item_live_up)
        TextView mLiveUp;

        @Bind(R.id.item_live_online)
        TextView mLiveOnline;


        public ItemViewHolder(View itemView)
        {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    static class FootViewHolder extends RecyclerView.ViewHolder
    {

        @Bind(R.id.item_btn_more)
        Button mMoreBtn;

        @Bind(R.id.item_dynamic)
        TextView mDynamic;

        @Bind(R.id.item_btn_refresh)
        ImageView mRefreshBtn;

        @Bind(R.id.item_refresh_layout)
        LinearLayout mRefreshLayout;

        @Bind(R.id.item_recommend_refresh_layout)
        LinearLayout mRecommendRefreshLayout;

        @Bind(R.id.item_recommend_refresh)
        ImageView mRecommendRefresh;

        @Bind(R.id.item_bangumi_layout)
        LinearLayout mBangumiLayout;

        @Bind(R.id.item_btn_bangumi_index)
        ImageView mBangumiIndexBtn;

        @Bind(R.id.item_btn_bangumi_timeline)
        ImageView mBangumiTimelineBtn;

        public FootViewHolder(View itemView)
        {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
