package com.hotbitmapgg.ohmybilibili.adapter.liveholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.widget.banner.BannerView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 直播界面Banner ViewHolder
 */
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