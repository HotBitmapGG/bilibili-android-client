package com.hotbitmapgg.ohmybilibili.adapter;

import android.annotation.SuppressLint;
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
import com.hotbitmapgg.ohmybilibili.module.home.focus.FocusOnDynamic;
import com.hotbitmapgg.ohmybilibili.widget.CircleImageView;

import java.util.List;

/**
 * Created by hcc on 2016/9/28 20:53
 * 100332338@qq.com
 * <p>
 * 关注界面动态Adapter
 */

public class FocusOnDynamicAdapter extends AbsRecyclerViewAdapter
{

    private List<FocusOnDynamic> focusOnDynamics;

    public FocusOnDynamicAdapter(RecyclerView recyclerView, List<FocusOnDynamic> focusOnDynamics)
    {

        super(recyclerView);
        this.focusOnDynamics = focusOnDynamics;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_focus_dynamic, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            FocusOnDynamic focusOnDynamic = focusOnDynamics.get(position);

            Glide.with(getContext())
                    .load(focusOnDynamic.getPic())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.bili_default_image_tv)
                    .dontAnimate()
                    .into(itemViewHolder.mImage);

            Glide.with(getContext())
                    .load(focusOnDynamic.getAvatar())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.ico_user_default)
                    .dontAnimate()
                    .into(itemViewHolder.mAvatar);

            itemViewHolder.mName.setText(focusOnDynamic.getName());
            itemViewHolder.mTitle.setText(focusOnDynamic.getTitle());
            itemViewHolder.mPlay.setText(focusOnDynamic.getPlay());
            itemViewHolder.mReview.setText(focusOnDynamic.getDanmaku());
            itemViewHolder.mUpdateTime.setText("于" + focusOnDynamic.getUploadTime() + "投稿");
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return focusOnDynamics.size();
    }

    private class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        CircleImageView mAvatar;

        TextView mName;

        TextView mUpdateTime;

        ImageView mImage;

        TextView mTitle;

        TextView mPlay;

        TextView mReview;


        public ItemViewHolder(View itemView)
        {

            super(itemView);
            mAvatar = $(R.id.item_user_avatar);
            mName = $(R.id.item_user_name);
            mUpdateTime = $(R.id.item_update_time);
            mImage = $(R.id.item_img);
            mTitle = $(R.id.item_title);
            mPlay = $(R.id.item_play);
            mReview = $(R.id.item_review);
        }
    }
}
