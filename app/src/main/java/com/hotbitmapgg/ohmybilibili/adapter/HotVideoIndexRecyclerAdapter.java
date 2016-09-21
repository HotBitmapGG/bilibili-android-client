package com.hotbitmapgg.ohmybilibili.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.helper.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.entity.video.VideoItemInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 9个分区热门视频查看Adapter
 */
public class HotVideoIndexRecyclerAdapter extends AbsRecyclerViewAdapter
{

    List<VideoItemInfo> videoItemInfos = new ArrayList<>();

    public HotVideoIndexRecyclerAdapter(RecyclerView recyclerView, List<VideoItemInfo> videoItemInfos)
    {

        super(recyclerView);
        this.videoItemInfos = videoItemInfos;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext())
                .inflate(R.layout.item_rank_video, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            VideoItemInfo videoItemInfo = videoItemInfos.get(position);
            itemViewHolder.mVideoTitle.setText(videoItemInfo.title);
            itemViewHolder.mVideoPlayNum.setText(videoItemInfo.play);
            itemViewHolder.mVideoReviewCount.setText(String.valueOf(videoItemInfo.video_review));
            itemViewHolder.mUserName.setText(videoItemInfo.author);
            itemViewHolder.mSortNum.setText(String.valueOf(position + 1));
            setSortNumTextSize(itemViewHolder, position);

            Glide.with(getContext())
                    .load(Uri.parse(videoItemInfo.pic))
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.bili_default_image_tv)
                    .dontAnimate()
                    .into(itemViewHolder.mVideoImg);
        }
        super.onBindViewHolder(holder, position);
    }

    private void setSortNumTextSize(ItemViewHolder itemViewHolder, int position)
    {

        if (position == 0)
        {
            itemViewHolder.mSortNum.setTextSize(28);
            itemViewHolder.mSortNum.setTextColor(getContext().getResources().getColor(R.color.colorPrimary));
        } else if (position == 1)
        {
            itemViewHolder.mSortNum.setTextSize(24);
            itemViewHolder.mSortNum.setTextColor(getContext().getResources().getColor(R.color.colorPrimary));
        } else if (position == 2)
        {
            itemViewHolder.mSortNum.setTextSize(18);
            itemViewHolder.mSortNum.setTextColor(getContext().getResources().getColor(R.color.colorPrimary));
        } else
        {
            itemViewHolder.mSortNum.setTextSize(16);
            itemViewHolder.mSortNum.setTextColor(getContext().getResources().getColor(R.color.black_alpha_30));
        }
    }

    @Override
    public int getItemCount()
    {

        return videoItemInfos.size();
    }


    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        public ImageView mVideoImg;

        public TextView mVideoTitle;

        public TextView mVideoPlayNum;

        public TextView mVideoReviewCount;

        public TextView mSortNum;

        public TextView mUserName;

        public ItemViewHolder(View itemView)
        {

            super(itemView);
            mVideoImg = $(R.id.item_img);
            mVideoTitle = $(R.id.item_title);
            mVideoPlayNum = $(R.id.item_play);
            mVideoReviewCount = $(R.id.item_review);
            mSortNum = $(R.id.item_sort_num);
            mUserName = $(R.id.item_user_name);
        }
    }
}
