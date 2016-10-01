package com.hotbitmapgg.ohmybilibili.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.helper.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.SeasonNewBangumi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by hcc on 2016/9/25 14:38
 * 100332338@qq.com
 * <p>
 * 分季新番adapter
 */

public class SeasonNewBangumiAdapter extends AbsRecyclerViewAdapter
{

    private List<SeasonNewBangumi.ListBean> seasonNewBangumis = new ArrayList<>();

    private List<String> texts = Arrays.asList("247.9万人追番", "213.4万人追番", "122.7万人追番", "74.5万人追番", "50.4万人追番");

    private Random random = new Random();

    private boolean isShowAll = false;

    public SeasonNewBangumiAdapter(RecyclerView recyclerView, List<SeasonNewBangumi.ListBean> seasonNewBangumis, boolean isShowAll)
    {

        super(recyclerView);
        this.seasonNewBangumis = seasonNewBangumis;
        this.isShowAll = isShowAll;
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            SeasonNewBangumi.ListBean listBean = seasonNewBangumis.get(position);
            Glide.with(getContext())
                    .load(listBean.getImageurl())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.bili_default_image_tv)
                    .dontAnimate()
                    .into(itemViewHolder.mImage);

            itemViewHolder.mTitle.setText(listBean.getTitle());
            itemViewHolder.mPlay.setText(texts.get(random.nextInt(texts.size())));
            itemViewHolder.mPlay.setVisibility(isShowAll ? View.GONE : View.VISIBLE);
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext())
                .inflate(R.layout.item_season_new_bangumi, parent, false));
    }

    @Override
    public int getItemCount()
    {

        return isShowAll ? seasonNewBangumis.size() : 3;
    }

    private class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        ImageView mImage;

        TextView mTitle;

        TextView mPlay;


        public ItemViewHolder(View itemView)
        {

            super(itemView);
            mImage = $(R.id.item_img);
            mTitle = $(R.id.item_title);
            mPlay = $(R.id.item_play);
        }
    }
}
