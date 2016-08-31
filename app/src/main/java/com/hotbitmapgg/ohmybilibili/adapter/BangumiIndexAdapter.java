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
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiIndex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 番剧索引Adapter
 */
public class BangumiIndexAdapter extends AbsRecyclerViewAdapter
{

    private List<BangumiIndex> bangumiIndexList = new ArrayList<>();

    public BangumiIndexAdapter(RecyclerView recyclerView,
                               List<BangumiIndex> bangumiIndexList)
    {

        super(recyclerView);
        this.bangumiIndexList = bangumiIndexList;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).
                inflate(R.layout.item_bangumi_index, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            BangumiIndex bangumiIndex = bangumiIndexList.get(position);

            Glide.with(getContext())
                    .load(bangumiIndex.cover)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(R.drawable.bili_default_image_tv)
                    .into(itemViewHolder.mImageView);
            itemViewHolder.mTextView.setText(bangumiIndex.title);
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return bangumiIndexList.size();
    }

    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        public ImageView mImageView;

        public TextView mTextView;

        public ItemViewHolder(View itemView)
        {

            super(itemView);
            mImageView = $(R.id.item_img);
            mTextView = $(R.id.item_title);
        }
    }
}
