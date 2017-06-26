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
import com.hotbitmapgg.bilibili.entity.bangumi.NewBangumiSerialInfo;
import com.hotbitmapgg.bilibili.utils.NumberUtil;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/8/6 14:31
 * 100332338@qq.com
 * <p/>
 * 首页番剧新番连载Adapter
 */
public class NewBangumiSerialAdapter extends AbsRecyclerViewAdapter {
    private List<NewBangumiSerialInfo.ListBean> newBangumiSerials = new ArrayList<>();
    private boolean isShowAll = false;

    public NewBangumiSerialAdapter(RecyclerView recyclerView, List<NewBangumiSerialInfo.ListBean> newBangumiSerials, boolean isShowAll) {
        super(recyclerView);
        this.newBangumiSerials = newBangumiSerials;
        this.isShowAll = isShowAll;
    }


    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext())
                .inflate(R.layout.item_recommend_bangumi, parent, false));
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            NewBangumiSerialInfo.ListBean listBean = newBangumiSerials.get(position);

            Glide.with(getContext())
                    .load(listBean.getCover())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.bili_default_image_tv)
                    .dontAnimate()
                    .into(itemViewHolder.mImage);

            itemViewHolder.mTitle.setText(listBean.getTitle());
            itemViewHolder.mPlay.setText(NumberUtil.converString(listBean.getPlay_count()) + "人在看");
            itemViewHolder.mUpdate.setText("更新至第" + listBean.getBgmcount() + "话");
        }
        super.onBindViewHolder(holder, position);
    }


    @Override
    public int getItemCount() {
        return isShowAll ? newBangumiSerials.size() : 6;
    }


    private class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder {

        ImageView mImage;
        TextView mTitle;
        TextView mPlay;
        TextView mUpdate;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mImage = $(R.id.item_img);
            mTitle = $(R.id.item_title);
            mPlay = $(R.id.item_play);
            mUpdate = $(R.id.item_update);
        }
    }
}
