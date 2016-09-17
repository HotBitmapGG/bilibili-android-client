package com.hotbitmapgg.ohmybilibili.adapter.section;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.entity.rank.AllRankInfo;
import com.hotbitmapgg.ohmybilibili.module.video.VideoDetailsActivity;
import com.hotbitmapgg.ohmybilibili.widget.sectioned.StatelessSection;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hcc on 16/9/12 21:23
 * 100332338@qq.com
 * <p/>
 * 全区排行榜section
 */
public class AllRankItemSection extends StatelessSection
{

    private Context mContext;

    private List<AllRankInfo.Videos> allRankVideos;

    private String title;

    private int imgRes;

    public AllRankItemSection(Context context, List<AllRankInfo.Videos> allRankVideos, String title, int imgRes)
    {

        super(R.layout.layout_all_rank_head, R.layout.layout_all_rank_boby);
        this.mContext = context;
        this.allRankVideos = allRankVideos;
        this.title = title;
        this.imgRes = imgRes;
    }

    @Override
    public int getContentItemsTotal()
    {

        return allRankVideos.size();
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
        final AllRankInfo.Videos videos = allRankVideos.get(position);

        Glide.with(mContext)
                .load(videos.getPic())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .into(itemViewHolder.mImageView);
        itemViewHolder.mTitle.setText(videos.getTitle());
        itemViewHolder.mPlay.setText(String.valueOf(videos.getPlay()));
        itemViewHolder.mReview.setText(String.valueOf(videos.getReview()));
        itemViewHolder.mCardView.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                VideoDetailsActivity.launch((Activity) mContext,
                        Integer.valueOf(videos.getAid()),videos.getPic());
            }
        });
    }


    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view)
    {

        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder)
    {

        HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
        headerViewHolder.mTypeImage.setImageResource(imgRes);
        headerViewHolder.mTypeText.setText(title + "区排行榜");
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder
    {

        @Bind(R.id.item_type_img)
        ImageView mTypeImage;

        @Bind(R.id.item_type_tv)
        TextView mTypeText;

        public HeaderViewHolder(View itemView)
        {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder
    {

        @Bind(R.id.card_view)
        CardView mCardView;

        @Bind(R.id.item_img)
        ImageView mImageView;

        @Bind(R.id.item_title)
        TextView mTitle;

        @Bind(R.id.item_play)
        TextView mPlay;

        @Bind(R.id.item_review)
        TextView mReview;


        public ItemViewHolder(View itemView)
        {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
