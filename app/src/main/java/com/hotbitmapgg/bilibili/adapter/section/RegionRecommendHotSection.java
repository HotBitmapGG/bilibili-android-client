package com.hotbitmapgg.bilibili.adapter.section;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.bilibili.entity.region.RegionRecommendInfo;
import com.hotbitmapgg.bilibili.module.home.discover.AllAreasRankActivity;
import com.hotbitmapgg.bilibili.module.video.VideoDetailsActivity;
import com.hotbitmapgg.bilibili.utils.ConstantUtil;
import com.hotbitmapgg.bilibili.utils.NumberUtil;
import com.hotbitmapgg.bilibili.widget.sectioned.StatelessSection;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hcc on 2016/10/21 23:28
 * 100332338@qq.com
 * <p>
 * 分区推荐热门推荐section
 */

public class RegionRecommendHotSection extends StatelessSection {
    private Context mContext;
    private int rid;
    private List<RegionRecommendInfo.DataBean.RecommendBean> recommends;

    public RegionRecommendHotSection(Context context, int rid, List<RegionRecommendInfo.DataBean.RecommendBean> recommends) {
        super(R.layout.layout_region_recommend_hot_head, R.layout.layout_region_recommend_card_item);
        this.rid = rid;
        this.recommends = recommends;
        this.mContext = context;
    }


    @Override
    public int getContentItemsTotal() {
        return recommends.size();
    }


    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemViewHolder(view);
    }


    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        RegionRecommendInfo.DataBean.RecommendBean recommendBean = recommends.get(position);

        Glide.with(mContext)
                .load(recommendBean.getCover())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into(itemViewHolder.mImage);

        itemViewHolder.mTitle.setText(recommendBean.getTitle());
        itemViewHolder.mPlay.setText(NumberUtil.converString(recommendBean.getPlay()));
        itemViewHolder.mReview.setText(NumberUtil.converString(recommendBean.getDanmaku()));
        itemViewHolder.mCardView.setOnClickListener(
                v -> VideoDetailsActivity.launch((Activity) mContext,
                        Integer.valueOf(recommendBean.getParam()), recommendBean.getCover()));
    }


    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeadViewHolder(view);
    }


    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        HeadViewHolder headViewHolder = (HeadViewHolder) holder;
        if (rid == ConstantUtil.ADVERTISING_RID) {
            headViewHolder.mRankBtn.setVisibility(View.GONE);
        } else {
            headViewHolder.mRankBtn.setOnClickListener(v -> startRankActivityById());
        }
    }


    private void startRankActivityById() {
        switch (rid) {
            case 13:
                //番剧
                AllAreasRankActivity.launch((Activity) mContext, 0);
                break;
            case 1:
                //动画
                AllAreasRankActivity.launch((Activity) mContext, 1);
                break;
            case 3:
                //音乐
                AllAreasRankActivity.launch((Activity) mContext, 2);
                break;
            case 129:
                //舞蹈
                AllAreasRankActivity.launch((Activity) mContext, 3);
                break;
            case 4:
                //游戏
                AllAreasRankActivity.launch((Activity) mContext, 4);
                break;
            case 36:
                //科技
                AllAreasRankActivity.launch((Activity) mContext, 5);
                break;
            case 160:
                //生活
                AllAreasRankActivity.launch((Activity) mContext, 6);
                break;
            case 119:
                //鬼畜
                AllAreasRankActivity.launch((Activity) mContext, 7);
                break;
            case 155:
                //时尚
                AllAreasRankActivity.launch((Activity) mContext, 8);
                break;
            case 5:
                //娱乐
                AllAreasRankActivity.launch((Activity) mContext, 9);
                break;
            case 23:
                //电影
                AllAreasRankActivity.launch((Activity) mContext, 10);
                break;
            case 11:
                //电视剧
                AllAreasRankActivity.launch((Activity) mContext, 11);
                break;
        }
    }


    static class HeadViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_type_rank_btn)
        TextView mRankBtn;

        HeadViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.card_view)
        CardView mCardView;
        @BindView(R.id.item_img)
        ImageView mImage;
        @BindView(R.id.item_title)
        TextView mTitle;
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
