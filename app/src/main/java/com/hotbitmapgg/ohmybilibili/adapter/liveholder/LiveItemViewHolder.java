package com.hotbitmapgg.ohmybilibili.adapter.liveholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.widget.CircleImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LiveItemViewHolder extends RecyclerView.ViewHolder
{

    @Bind(R.id.item_live_cover)
    public ImageView itemLiveCover;

    @Bind(R.id.item_live_user)
    public TextView itemLiveUser;

    @Bind(R.id.item_live_title)
    public TextView itemLiveTitle;

    @Bind(R.id.item_live_user_cover)
    public CircleImageView itemLiveUserCover;

    @Bind(R.id.item_live_count)
    public TextView itemLiveCount;

    @Bind(R.id.item_live_layout)
    public CardView itemLiveLayout;

    public LiveItemViewHolder(View itemView)
    {

        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}