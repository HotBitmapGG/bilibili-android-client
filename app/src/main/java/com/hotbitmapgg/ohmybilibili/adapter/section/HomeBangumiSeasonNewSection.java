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
import com.hotbitmapgg.ohmybilibili.entity.bangumi.SeasonNewBangumi;
import com.hotbitmapgg.ohmybilibili.module.home.bangumi.SeasonNewBangumiActivity;
import com.hotbitmapgg.ohmybilibili.widget.sectioned.StatelessSection;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    private List<SeasonNewBangumi.ListBean> seasonNewBangumis;

    private Random random = new Random();

    private List<String> texts = Arrays.asList("247.9万人追番", "213.4万人追番", "122.7万人追番", "74.5万人追番", "50.4万人追番");


    public HomeBangumiSeasonNewSection(Context context, List<SeasonNewBangumi.ListBean> seasonNewBangumis)
    {

        super(R.layout.layout_home_bangumi_season_new_head, R.layout.layout_home_bangumi_season_new_body);
        this.mContext = context;
        this.seasonNewBangumis = seasonNewBangumis;
    }

    @Override
    public int getContentItemsTotal()
    {

        return 3;
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

        SeasonNewBangumi.ListBean listBean = seasonNewBangumis.get(position);
        Glide.with(mContext)
                .load(listBean.getImageurl())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into(itemViewHolder.mImage);

        itemViewHolder.mTitle.setText(listBean.getTitle());
        itemViewHolder.mPlay.setText(texts.get(random.nextInt(texts.size())));

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
