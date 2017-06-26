package com.hotbitmapgg.bilibili.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.bilibili.adapter.helper.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.R;

/**
 * Created by hcc on 2016/10/21 21:55
 * 100332338@qq.com
 * <p>
 * 分区推荐页面类型分类Icons的adapter
 */

public class RegionRecommendTypesAdapter extends AbsRecyclerViewAdapter {
    private int[] icons;
    private String[] titles;

    public RegionRecommendTypesAdapter(RecyclerView recyclerView, int[] icons, String[] titles) {
        super(recyclerView);
        this.icons = icons;
        this.titles = titles;
    }


    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(
                LayoutInflater.from(getContext()).inflate(R.layout.item_types_icon, parent, false));
    }


    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.mIcon.setImageResource(icons[position]);
            itemViewHolder.mTitle.setText(titles[position]);
        }
        super.onBindViewHolder(holder, position);
    }


    @Override
    public int getItemCount() {
        return icons.length;
    }


    private class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder {

        ImageView mIcon;
        TextView mTitle;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mIcon = $(R.id.item_icon);
            mTitle = $(R.id.item_title);
        }
    }
}
