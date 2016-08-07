package com.hotbitmapgg.ohmybilibili.adapter.liveholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 直播界面分区类型 ViewHolder
 */
public class LivePartitionViewHolder extends RecyclerView.ViewHolder
{

    @Bind(R.id.item_live_partition_icon)
    public ImageView itemIcon;

    @Bind(R.id.item_live_partition_title)
    public TextView itemTitle;

    @Bind(R.id.item_live_partition_count)
    public TextView itemCount;

    public LivePartitionViewHolder(View itemView)
    {

        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}