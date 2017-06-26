package com.hotbitmapgg.bilibili.adapter.section;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.bilibili.entity.bangumi.BangumiAppIndexInfo;
import com.hotbitmapgg.bilibili.module.common.BrowserActivity;
import com.hotbitmapgg.bilibili.widget.sectioned.StatelessSection;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hcc on 16/8/27 14:06
 * 100332338@qq.com
 * <p/>
 * 首页番剧界面内容Section
 */
public class HomeBangumiBobySection extends StatelessSection {
    private Context mContext;
    private List<BangumiAppIndexInfo.ResultBean.AdBean.BodyBean> bangumibobys;

    public HomeBangumiBobySection(Context context, List<BangumiAppIndexInfo.ResultBean.AdBean.BodyBean> bangumibobys) {
        super(R.layout.layout_home_bangumi_boby, R.layout.layout_home_recommend_empty);
        this.mContext = context;
        this.bangumibobys = bangumibobys;
    }


    @Override
    public int getContentItemsTotal() {
        return 1;
    }


    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new EmptyViewHolder(view);
    }


    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
    }


    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new BangumiBobyViewHolder(view);
    }


    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        BangumiBobyViewHolder bangumiBobyViewHolder = (BangumiBobyViewHolder) holder;

        Glide.with(mContext)
                .load(bangumibobys.get(0).getImg())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into(bangumiBobyViewHolder.mBobyImage);

        bangumiBobyViewHolder.mCardView.setOnClickListener(v -> BrowserActivity.launch(
                (Activity) mContext, bangumibobys.get(0).getLink(), bangumibobys.get(0).getTitle()));
    }


    static class EmptyViewHolder extends RecyclerView.ViewHolder {
        EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }

    static class BangumiBobyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.home_bangumi_boby_image)
        ImageView mBobyImage;
        @BindView(R.id.card_view)
        CardView mCardView;

        BangumiBobyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
