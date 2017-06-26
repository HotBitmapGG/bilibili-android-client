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
import com.hotbitmapgg.bilibili.entity.discover.ActivityCenterInfo;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.List;

/**
 * Created by hcc on 2016/10/3 16:08
 * 100332338@qq.com
 * <p>
 * 活动中心adapter
 */

public class ActivityCenterAdapter extends AbsRecyclerViewAdapter {
    private List<ActivityCenterInfo.ListBean> activityCenters;

    public ActivityCenterAdapter(RecyclerView recyclerView, List<ActivityCenterInfo.ListBean> activityCenters) {
        super(recyclerView);
        this.activityCenters = activityCenters;
    }


    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext())
                .inflate(R.layout.item_activity_center_list, parent, false));
    }


    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            ActivityCenterInfo.ListBean listBean = activityCenters.get(position);

            Glide.with(getContext())
                    .load(listBean.getCover())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.bili_default_image_tv)
                    .dontAnimate()
                    .into(itemViewHolder.mImage);

            itemViewHolder.mTitle.setText(listBean.getTitle());

            if (listBean.getState() == 1) {
                itemViewHolder.mState.setImageResource(R.drawable.ic_badge_end);
            } else {
                itemViewHolder.mState.setImageResource(R.drawable.ic_badge_going);
            }
        }
        super.onBindViewHolder(holder, position);
    }


    @Override
    public int getItemCount() {
        return activityCenters.size();
    }


    private class ItemViewHolder extends ClickableViewHolder {

        ImageView mImage;
        TextView mTitle;
        ImageView mState;


        public ItemViewHolder(View itemView) {
            super(itemView);
            mImage = $(R.id.item_image);
            mTitle = $(R.id.item_title);
            mState = $(R.id.item_state);
        }
    }
}
