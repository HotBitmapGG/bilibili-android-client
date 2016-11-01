package com.hotbitmapgg.ohmybilibili.adapter.section;

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
import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiAppIndexInfo;
import com.hotbitmapgg.ohmybilibili.module.home.bangumi.SeasonNewBangumiActivity;
import com.hotbitmapgg.ohmybilibili.utils.NumberUtil;
import com.hotbitmapgg.ohmybilibili.widget.sectioned.StatelessSection;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hcc on 2016/10/14 19:44
 * 100332338@qq.com
 * <p>
 * 首页番剧分季新番Section
 */

public class HomeBangumiSeasonNewSection extends StatelessSection
{

    private Context mContext;

    private List<BangumiAppIndexInfo.ResultBean.PreviousBean.ListBean> seasonNewBangumis;


    public HomeBangumiSeasonNewSection(Context context, List<BangumiAppIndexInfo.ResultBean.PreviousBean.ListBean> seasonNewBangumis)
    {

        super(R.layout.layout_home_bangumi_season_new_head, R.layout.layout_home_bangumi_season_new_body);
        this.mContext = context;
        this.seasonNewBangumis = seasonNewBangumis;
    }

    @Override
    public int getContentItemsTotal()
    {

        return seasonNewBangumis.size();
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view)
    {

        return new HomeBangumiSeasonNewSection.ItemViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position)
    {

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
        itemViewHolder.mPlay.setText(NumberUtil.converString(Integer.valueOf(listBean.getFavourites())) + "人追番剧");

        itemViewHolder.mCardView.setOnClickListener(v -> {

        });
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view)
    {

        return new HomeBangumiSeasonNewSection.HeaderViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder)
    {

        HomeBangumiSeasonNewSection.HeaderViewHolder headerViewHolder = (HomeBangumiSeasonNewSection.HeaderViewHolder) holder;
        headerViewHolder.mAllNewBangumi.setOnClickListener(v -> mContext.startActivity(
                new Intent(mContext, SeasonNewBangumiActivity.class)));
    }


    static class HeaderViewHolder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.tv_all_new_bangumi)
        TextView mAllNewBangumi;


        HeaderViewHolder(View itemView)
        {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.card_view)
        LinearLayout mCardView;

        @BindView(R.id.item_img)
        ImageView mImage;

        @BindView(R.id.item_title)
        TextView mTitle;

        @BindView(R.id.item_play)
        TextView mPlay;


        public ItemViewHolder(View itemView)
        {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
