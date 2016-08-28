package com.hotbitmapgg.ohmybilibili.adapter;

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
import com.hotbitmapgg.ohmybilibili.entity.video.VideoAlikeInfo;
import com.hotbitmapgg.ohmybilibili.network.auxiliary.UrlHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/8/7 21:18
 * 100332338@qq.com
 * <p/>
 * 视频详情界面相关视频Adapter
 */
public class VideoAlikeListAdapter extends AbsRecyclerViewAdapter
{

    private List<VideoAlikeInfo> parts = new ArrayList<>();

    public VideoAlikeListAdapter(RecyclerView recyclerView, List<VideoAlikeInfo> parts)
    {

        super(recyclerView);
        this.parts = parts;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).
                inflate(R.layout.item_video_strip, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            VideoAlikeInfo videoAlikeInfo = parts.get(position);

            Glide.with(getContext())
                    .load(UrlHelper.getClearVideoPreviewUrl(videoAlikeInfo.pic))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(R.drawable.bili_default_image_tv)
                    .into(itemViewHolder.mVideoPic);

            itemViewHolder.mVideoTitle.setText(videoAlikeInfo.title);
            itemViewHolder.mVideoPlayNum.setText(videoAlikeInfo.play);
            itemViewHolder.mVideoReviewNum.setText(String.valueOf(videoAlikeInfo.video_review));
            itemViewHolder.mUserName.setText(videoAlikeInfo.author);
        }

        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return parts.size();
    }

    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        public ImageView mVideoPic;

        public TextView mVideoTitle;

        public TextView mVideoPlayNum;

        public TextView mVideoReviewNum;

        public TextView mUserName;

        public ItemViewHolder(View itemView)
        {

            super(itemView);

            mVideoPic = $(R.id.item_img);
            mVideoTitle = $(R.id.item_title);
            mVideoPlayNum = $(R.id.item_play);
            mVideoReviewNum = $(R.id.item_review);
            mUserName = $(R.id.item_user_name);
        }
    }
}
