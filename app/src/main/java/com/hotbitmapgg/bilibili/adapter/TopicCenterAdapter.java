package com.hotbitmapgg.bilibili.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.bilibili.adapter.helper.AbsRecyclerViewAdapter;
import com.hotbitmapgg.bilibili.entity.discover.TopicCenterInfo;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.List;

/**
 * Created by hcc on 2016/10/3 16:08
 * 100332338@qq.com
 * <p>
 * 话题中心adapter
 */

public class TopicCenterAdapter extends AbsRecyclerViewAdapter {
    private List<TopicCenterInfo.ListBean> topicCenters;

    public TopicCenterAdapter(RecyclerView recyclerView, List<TopicCenterInfo.ListBean> topicCenters) {
        super(recyclerView);
        this.topicCenters = topicCenters;
    }


    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(
                LayoutInflater.from(getContext()).inflate(R.layout.item_topic_center, parent, false));
    }


    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            TopicCenterInfo.ListBean listBean = topicCenters.get(position);

            Glide.with(getContext())
                    .load(listBean.getCover())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.bili_default_image_tv)
                    .dontAnimate()
                    .into(itemViewHolder.mImage);

            itemViewHolder.mTitle.setText(listBean.getTitle());
        }
        super.onBindViewHolder(holder, position);
    }


    @Override
    public int getItemCount() {
        return topicCenters.size();
    }


    private class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder {

        ImageView mImage;
        TextView mTitle;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mImage = $(R.id.item_image);
            mTitle = $(R.id.item_title);
        }
    }
}
