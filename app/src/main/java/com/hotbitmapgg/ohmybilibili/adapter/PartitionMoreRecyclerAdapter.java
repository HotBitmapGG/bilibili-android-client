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
import com.hotbitmapgg.ohmybilibili.entity.partition.PartitionMoreVideoItem;

import java.util.List;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 分区列表查看Adapter
 */
public class PartitionMoreRecyclerAdapter extends AbsRecyclerViewAdapter
{


    private List<PartitionMoreVideoItem> mList;

    public PartitionMoreRecyclerAdapter(RecyclerView recyclerView, List<PartitionMoreVideoItem> list)
    {

        super(recyclerView);
        this.mList = list;
    }


    @Override
    public void onBindViewHolder(AbsRecyclerViewAdapter.ClickableViewHolder holder, int position)
    {

        super.onBindViewHolder(holder, position);
        if (holder instanceof ItemViewHolder)
        {
            try
            {
                ItemViewHolder mHolder = (ItemViewHolder) holder;
                PartitionMoreVideoItem videoItemInfo = mList.get(position);
                mHolder.mTitleView.setText(videoItemInfo.title == null ? "" : videoItemInfo.title);

                Glide.with(getContext())
                        .load(Uri.parse(videoItemInfo.pic))
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.bili_default_image_tv)
                        .dontAnimate()
                        .into(mHolder.mPreviewImage);

                String play = videoItemInfo.play;
                int video_review = videoItemInfo.video_review;
                mHolder.mPlayNum.setText(play);
                mHolder.mReviewNum.setText(String.valueOf(video_review));
                String author = videoItemInfo.author;
                mHolder.mUploadUser.setText(author);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext())
                .inflate(R.layout.item_video_strip, parent, false));
    }


    @Override
    public int getItemCount()
    {

        return mList.size();
    }


    private class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        ImageView mPreviewImage;

        TextView mTitleView;

        TextView mPlayNum;

        TextView mReviewNum;

        TextView mUploadUser;


        public ItemViewHolder(View itemView)
        {

            super(itemView);

            mPreviewImage = $(R.id.item_img);
            mTitleView = $(R.id.item_title);
            mPlayNum = $(R.id.item_play);
            mReviewNum = $(R.id.item_review);
            mUploadUser = $(R.id.item_user_name);
        }
    }
}
