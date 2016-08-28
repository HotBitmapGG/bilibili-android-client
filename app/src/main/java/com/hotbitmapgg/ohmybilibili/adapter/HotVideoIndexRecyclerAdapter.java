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
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
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

    public HotVideoIndexRecyclerAdapter(RecyclerView recyclerView,
                                        List<VideoItemInfo> videoItemInfos)
    {

        super(recyclerView);
        this.videoItemInfos = videoItemInfos;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext())
                .inflate(R.layout.item_video_card, parent, false));
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

            Glide.with(getContext())
                    .load(Uri.parse(videoItemInfo.pic))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(R.drawable.bili_default_image_tv)
                    .into(itemViewHolder.mVideoImg);
        }
        super.onBindViewHolder(holder, position);
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

        public ItemViewHolder(View itemView)
        {

            super(itemView);
            mVideoImg = $(R.id.item_img);
            mVideoTitle = $(R.id.item_title);
            mVideoPlayNum = $(R.id.item_play);
            mVideoReviewCount = $(R.id.item_review);
        }
    }
}
