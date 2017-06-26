package com.hotbitmapgg.bilibili.adapter.section;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.bilibili.entity.region.RegionDetailsInfo;
import com.hotbitmapgg.bilibili.module.video.VideoDetailsActivity;
import com.hotbitmapgg.bilibili.widget.sectioned.StatelessSection;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hcc on 2016/10/22 01:46
 * 100332338@qq.com
 * <p>
 * 分区详情最新视频section
 */

public class RegionDetailsNewsVideoSection extends StatelessSection {
    private Context mContext;
    private List<RegionDetailsInfo.DataBean.NewBean> newsVideos;

    public RegionDetailsNewsVideoSection(Context context, List<RegionDetailsInfo.DataBean.NewBean> newsVideos) {
        super(R.layout.layout_region_details_news_head, R.layout.item_video_strip);
        this.mContext = context;
        this.newsVideos = newsVideos;
    }


    @Override
    public int getContentItemsTotal() {
        return newsVideos.size();
    }


    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemViewHolder(view);
    }


    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        RegionDetailsInfo.DataBean.NewBean newBean = newsVideos.get(position);

        Glide.with(mContext)
                .load(newBean.getCover())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into(itemViewHolder.mVideoPic);

        itemViewHolder.mTitle.setText(newBean.getTitle());
        itemViewHolder.mUpName.setText(newBean.getName());
        itemViewHolder.mPlay.setText(String.valueOf(newBean.getPlay()));
        itemViewHolder.mReview.setText(String.valueOf(newBean.getDanmaku()));
        itemViewHolder.mItemView.setOnClickListener(
                v -> VideoDetailsActivity.launch((Activity) mContext,
                        Integer.valueOf(newBean.getParam()), newBean.getCover()));
    }


    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeadViewHolder(view);
    }


    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        super.onBindHeaderViewHolder(holder);
    }


    static class HeadViewHolder extends RecyclerView.ViewHolder {
        public HeadViewHolder(View itemView) {
            super(itemView);
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_view)
        RelativeLayout mItemView;
        @BindView(R.id.item_img)
        ImageView mVideoPic;
        @BindView(R.id.item_title)
        TextView mTitle;
        @BindView(R.id.item_user_name)
        TextView mUpName;
        @BindView(R.id.item_play)
        TextView mPlay;
        @BindView(R.id.item_review)
        TextView mReview;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
