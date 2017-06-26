package com.hotbitmapgg.bilibili.adapter.section;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.bilibili.entity.bangumi.BangumiAppIndexInfo;
import com.hotbitmapgg.bilibili.module.home.bangumi.SeasonNewBangumiActivity;
import com.hotbitmapgg.bilibili.utils.NumberUtil;
import com.hotbitmapgg.bilibili.widget.sectioned.StatelessSection;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hcc on 2016/10/14 19:44
 * 100332338@qq.com
 * <p>
 * 首页番剧分季新番Section
 */

public class HomeBangumiSeasonNewSection extends StatelessSection {
    private Context mContext;
    private int season;
    private List<BangumiAppIndexInfo.ResultBean.PreviousBean.ListBean> seasonNewBangumis;

    public HomeBangumiSeasonNewSection(Context context, int season, List<BangumiAppIndexInfo.ResultBean.PreviousBean.ListBean> seasonNewBangumis) {
        super(R.layout.layout_home_bangumi_season_new_head, R.layout.layout_home_bangumi_season_new_body);
        this.mContext = context;
        this.season = season;
        this.seasonNewBangumis = seasonNewBangumis;
    }


    @Override
    public int getContentItemsTotal() {
        return seasonNewBangumis.size();
    }


    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new HomeBangumiSeasonNewSection.ItemViewHolder(view);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        HomeBangumiSeasonNewSection.ItemViewHolder itemViewHolder = (HomeBangumiSeasonNewSection.ItemViewHolder) holder;
        BangumiAppIndexInfo.ResultBean.PreviousBean.ListBean listBean = seasonNewBangumis.get(position);

        Glide.with(mContext)
                .load(listBean.getCover())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into(itemViewHolder.mImage);

        itemViewHolder.mTitle.setText(listBean.getTitle());
        itemViewHolder.mPlay.setText(
                NumberUtil.converString(Integer.valueOf(listBean.getFavourites())) + "人追番");
        itemViewHolder.mCardView.setOnClickListener(v -> {
        });
    }


    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HomeBangumiSeasonNewSection.HeaderViewHolder(view);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        HomeBangumiSeasonNewSection.HeaderViewHolder headerViewHolder = (HomeBangumiSeasonNewSection.HeaderViewHolder) holder;
        setSeasonIcon(headerViewHolder);
        headerViewHolder.mAllNewBangumi.setOnClickListener(v -> mContext.startActivity(
                new Intent(mContext, SeasonNewBangumiActivity.class)));
    }


    @SuppressLint("SetTextI18n")
    private void setSeasonIcon(HomeBangumiSeasonNewSection.HeaderViewHolder headViewHolder) {
        switch (season) {
            case 1:
                //冬季
                headViewHolder.mSeasonText.setText("1月新番");
                headViewHolder.mSeasonIcon.setImageResource(R.drawable.bangumi_home_ic_season_1);
                break;
            case 2:
                //春季
                headViewHolder.mSeasonText.setText("4月新番");
                headViewHolder.mSeasonIcon.setImageResource(R.drawable.bangumi_home_ic_season_2);
                break;
            case 3:
                //夏季
                headViewHolder.mSeasonText.setText("7月新番");
                headViewHolder.mSeasonIcon.setImageResource(R.drawable.bangumi_home_ic_season_3);
                break;
            case 4:
                //秋季
                headViewHolder.mSeasonText.setText("10月新番");
                headViewHolder.mSeasonIcon.setImageResource(R.drawable.bangumi_home_ic_season_4);
                break;
        }
    }


    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_all_new_bangumi)
        TextView mAllNewBangumi;
        @BindView(R.id.iv_season)
        ImageView mSeasonIcon;
        @BindView(R.id.tv_season)
        TextView mSeasonText;

        HeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.card_view)
        LinearLayout mCardView;
        @BindView(R.id.item_img)
        ImageView mImage;
        @BindView(R.id.item_title)
        TextView mTitle;
        @BindView(R.id.item_play)
        TextView mPlay;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
