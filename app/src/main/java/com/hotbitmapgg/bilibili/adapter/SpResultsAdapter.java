package com.hotbitmapgg.bilibili.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.bilibili.adapter.helper.AbsRecyclerViewAdapter;
import com.hotbitmapgg.bilibili.entity.search.SearchSpInfo;
import com.hotbitmapgg.bilibili.utils.NumberUtil;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.List;

/**
 * Created by hcc on 16/9/4 12:28
 * 100332338@qq.com
 * <p/>
 * 专题搜索结果Adapter
 */
public class SpResultsAdapter extends AbsRecyclerViewAdapter {
    private List<SearchSpInfo.DataBean.ItemsBean> specialTopics;

    public SpResultsAdapter(RecyclerView recyclerView, List<SearchSpInfo.DataBean.ItemsBean> specialTopics) {
        super(recyclerView);
        this.specialTopics = specialTopics;
    }


    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).
                inflate(R.layout.item_search_sp, parent, false));
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            SearchSpInfo.DataBean.ItemsBean itemsBean = specialTopics.get(position);

            Glide.with(getContext())
                    .load(itemsBean.getCover())
                    .centerCrop()
                    .dontAnimate()
                    .placeholder(R.drawable.ico_user_default)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(itemViewHolder.mImage);

            itemViewHolder.mTitle.setText(itemsBean.getTitle());
            itemViewHolder.mVideo.setText("视频：" + NumberUtil.converString(itemsBean.getArchives()));
            itemViewHolder.mPlay.setText("播放：" + NumberUtil.converString(itemsBean.getPlay()));
            itemViewHolder.mDesc.setText(itemsBean.getDesc());
        }
        super.onBindViewHolder(holder, position);
    }


    @Override
    public int getItemCount() {
        return specialTopics.size();
    }


    public class ItemViewHolder extends ClickableViewHolder {

        ImageView mImage;
        TextView mTitle;
        TextView mVideo;
        TextView mPlay;
        TextView mDesc;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mImage = $(R.id.item_img);
            mTitle = $(R.id.item_title);
            mVideo = $(R.id.item_video);
            mPlay = $(R.id.item_play);
            mDesc = $(R.id.item_details);
        }
    }
}
