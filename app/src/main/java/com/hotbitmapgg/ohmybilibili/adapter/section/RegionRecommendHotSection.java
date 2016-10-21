package com.hotbitmapgg.ohmybilibili.adapter.section;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.entity.region.RegionRecommendInfo;
import com.hotbitmapgg.ohmybilibili.utils.NumberUtil;
import com.hotbitmapgg.ohmybilibili.widget.sectioned.StatelessSection;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hcc on 2016/10/21 23:28
 * 100332338@qq.com
 * <p>
 * 分区推荐热门推荐section
 */

public class RegionRecommendHotSection extends StatelessSection
{

    private Context mContext;

    private List<RegionRecommendInfo.DataBean.RecommendBean> recommends;

    public RegionRecommendHotSection(Context context, List<RegionRecommendInfo.DataBean.RecommendBean> recommends)
    {

        super(R.layout.layout_region_recommend_hot_head, R.layout.layout_region_recommend_card_item);
        this.recommends = recommends;
        this.mContext = context;
    }

    @Override
    public int getContentItemsTotal()
    {

        return recommends.size();
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view)
    {

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position)
    {

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
    }


    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view)
    {

        return new HeadViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder)
    {

        super.onBindHeaderViewHolder(holder);
    }

    static class HeadViewHolder extends RecyclerView.ViewHolder
    {

        public HeadViewHolder(View itemView)
        {

            super(itemView);
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder
    {

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

        public ItemViewHolder(View itemView)
        {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
