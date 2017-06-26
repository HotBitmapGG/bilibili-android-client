package com.hotbitmapgg.bilibili.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.bilibili.adapter.helper.AbsRecyclerViewAdapter;
import com.hotbitmapgg.bilibili.entity.discover.OriginalRankInfo;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.List;

/**
 * Created by hcc on 2016/9/22 19:30
 * 100332338@qq.com
 * <p>
 * 原创排行榜Adapter
 */

public class OriginalRankAdapter extends AbsRecyclerViewAdapter {
    private List<OriginalRankInfo.RankBean.ListBean> originalRanks;

    public OriginalRankAdapter(RecyclerView recyclerView, List<OriginalRankInfo.RankBean.ListBean> originalRanks) {
        super(recyclerView);
        this.originalRanks = originalRanks;
    }


    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new OriginalRankAdapter.ItemViewHolder(LayoutInflater.from(getContext())
                .inflate(R.layout.item_rank_video, parent, false));
    }


    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof OriginalRankAdapter.ItemViewHolder) {
            OriginalRankAdapter.ItemViewHolder itemViewHolder
                    = (OriginalRankAdapter.ItemViewHolder) holder;
            OriginalRankInfo.RankBean.ListBean listBean = originalRanks.get(position);
            itemViewHolder.mVideoTitle.setText(listBean.getTitle());
            itemViewHolder.mVideoPlayNum.setText(String.valueOf(listBean.getPlay()));
            itemViewHolder.mVideoReviewCount.setText(String.valueOf(listBean.getVideo_review()));
            itemViewHolder.mUserName.setText(listBean.getAuthor());
            itemViewHolder.mSortNum.setText(String.valueOf(position + 1));
            setSortNumTextSize(itemViewHolder, position);

            Glide.with(getContext())
                    .load(listBean.getPic())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.bili_default_image_tv)
                    .dontAnimate()
                    .into(itemViewHolder.mVideoImg);
        }
        super.onBindViewHolder(holder, position);
    }


    private void setSortNumTextSize(OriginalRankAdapter.ItemViewHolder itemViewHolder, int position) {
        if (position == 0) {
            itemViewHolder.mSortNum.setTextSize(24);
            itemViewHolder.mSortNum.setTextColor(
                    getContext().getResources().getColor(R.color.colorPrimary));
        } else if (position == 1) {
            itemViewHolder.mSortNum.setTextSize(22);
            itemViewHolder.mSortNum.setTextColor(
                    getContext().getResources().getColor(R.color.colorPrimary));
        } else if (position == 2) {
            itemViewHolder.mSortNum.setTextSize(18);
            itemViewHolder.mSortNum.setTextColor(
                    getContext().getResources().getColor(R.color.colorPrimary));
        } else {
            itemViewHolder.mSortNum.setTextSize(16);
            itemViewHolder.mSortNum.setTextColor(
                    getContext().getResources().getColor(R.color.black_alpha_30));
        }
    }


    @Override
    public int getItemCount() {
        return originalRanks.size();
    }


    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder {

        ImageView mVideoImg;
        TextView mVideoTitle;
        TextView mVideoPlayNum;
        TextView mVideoReviewCount;
        TextView mSortNum;
        TextView mUserName;

        public ItemViewHolder(View itemView) {
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
