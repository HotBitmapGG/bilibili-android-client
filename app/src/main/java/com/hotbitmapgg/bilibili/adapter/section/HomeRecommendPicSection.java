package com.hotbitmapgg.bilibili.adapter.section;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.bilibili.module.video.VideoDetailsActivity;
import com.hotbitmapgg.bilibili.widget.sectioned.StatelessSection;
import com.hotbitmapgg.ohmybilibili.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hcc on 16/8/27 20:19
 * 100332338@qq.com
 * <p/>
 * 首页推荐界面图片周刊section
 */
public class HomeRecommendPicSection extends StatelessSection {
    private Context mContext;
    private String imgUrl;
    private String aid;

    public HomeRecommendPicSection(Context context, String imgUrl, String aid) {
        super(R.layout.layout_home_recommend_pic, R.layout.layout_home_recommend_empty);
        this.mContext = context;
        this.imgUrl = imgUrl;
        this.aid = aid;
    }


    @Override
    public int getContentItemsTotal() {
        return 1;
    }


    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new EmptyViewHolder(view);
    }


    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
    }


    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new TopicViewHolder(view);
    }


    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        TopicViewHolder topicViewHolder = (TopicViewHolder) holder;
        Glide.with(mContext)
                .load(imgUrl)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into(topicViewHolder.mImageView);

        topicViewHolder.mCardView.setOnClickListener(v ->
                VideoDetailsActivity.launch((Activity) mContext, Integer.valueOf(aid), imgUrl));
    }


    static class TopicViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.topic_image)
        ImageView mImageView;
        @BindView(R.id.card_view)
        CardView mCardView;

        TopicViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class EmptyViewHolder extends RecyclerView.ViewHolder {
        EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
