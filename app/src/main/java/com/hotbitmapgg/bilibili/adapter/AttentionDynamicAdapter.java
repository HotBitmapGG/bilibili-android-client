package com.hotbitmapgg.bilibili.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.bilibili.adapter.helper.AbsRecyclerViewAdapter;
import com.hotbitmapgg.bilibili.entity.attention.AttentionDynamicInfo;
import com.hotbitmapgg.bilibili.utils.NumberUtil;
import com.hotbitmapgg.bilibili.utils.WeekDayUtil;
import com.hotbitmapgg.bilibili.widget.CircleImageView;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.List;

/**
 * Created by hcc on 2016/9/28 20:53
 * 100332338@qq.com
 * <p>
 * 关注界面动态Adapter
 */

public class AttentionDynamicAdapter extends AbsRecyclerViewAdapter {
    private List<AttentionDynamicInfo.DataBean.FeedsBean> dynamics;

    public AttentionDynamicAdapter(RecyclerView recyclerView, List<AttentionDynamicInfo.DataBean.FeedsBean> dynamics) {
        super(recyclerView);
        this.dynamics = dynamics;
    }


    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(
                LayoutInflater.from(getContext()).inflate(R.layout.item_attention_dynamic, parent, false));
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            AttentionDynamicInfo.DataBean.FeedsBean feedsBean = dynamics.get(position);

            Glide.with(getContext())
                    .load(feedsBean.getAddition().getPic())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.bili_default_image_tv)
                    .dontAnimate()
                    .into(itemViewHolder.mImage);

            Glide.with(getContext())
                    .load(feedsBean.getSource().getAvatar())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.ico_user_default)
                    .dontAnimate()
                    .into(itemViewHolder.mAvatar);

            itemViewHolder.mName.setText(feedsBean.getSource().getUname());
            itemViewHolder.mTitle.setText(feedsBean.getAddition().getTitle());
            itemViewHolder.mPlay.setText(NumberUtil.converString(feedsBean.getAddition().getPlay()));
            itemViewHolder.mReview.setText(
                    NumberUtil.converString(feedsBean.getAddition().getVideo_review()));
            itemViewHolder.mUpdateTime.setText(
                    WeekDayUtil.formatDate(feedsBean.getAddition().getCreate()));
        }
        super.onBindViewHolder(holder, position);
    }


    @Override
    public int getItemCount() {
        return dynamics.size();
    }


    private class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder {

        CircleImageView mAvatar;
        TextView mName;
        TextView mUpdateTime;
        ImageView mImage;
        TextView mTitle;
        TextView mPlay;
        TextView mReview;

        public ItemViewHolder(View itemView) {
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
