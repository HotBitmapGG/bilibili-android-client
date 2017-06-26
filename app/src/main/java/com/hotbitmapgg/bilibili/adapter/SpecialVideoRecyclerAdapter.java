package com.hotbitmapgg.bilibili.adapter;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.bilibili.adapter.helper.AbsRecyclerViewAdapter;
import com.hotbitmapgg.bilibili.entity.bangumi.SpecialTopic;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 专题视频Adapter
 */
public class SpecialVideoRecyclerAdapter extends AbsRecyclerViewAdapter {
    private List<SpecialTopic.Item> spItems = new ArrayList<>();

    public SpecialVideoRecyclerAdapter(RecyclerView recyclerView, List<SpecialTopic.Item> spItems) {
        super(recyclerView);
        this.spItems = spItems;
    }


    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).
                inflate(R.layout.item_special_videos, parent, false));
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            SpecialTopic.Item item = spItems.get(position);
            itemViewHolder.mSpNum.setText("第" + item.episode + "话");

            Glide.with(getContext())
                    .load(Uri.parse(item.cover))
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.bili_default_image_tv)
                    .dontAnimate()
                    .into(itemViewHolder.mPreviewImage);
        }
        super.onBindViewHolder(holder, position);
    }


    @Override
    public int getItemCount() {
        return spItems.size();
    }


    private class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder {

        ImageView mPreviewImage;
        TextView mSpNum;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mPreviewImage = $(R.id.item_img);
            mSpNum = $(R.id.item_title);
        }
    }
}
