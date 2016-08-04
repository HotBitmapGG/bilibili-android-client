package com.hotbitmapgg.ohmybilibili.adapter.liveholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.widget.banner.BannerView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LiveBannerViewHolder extends RecyclerView.ViewHolder
{

    @Bind(R.id.item_live_banner)
    public BannerView banner;

    public LiveBannerViewHolder(View itemView)
    {

        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}