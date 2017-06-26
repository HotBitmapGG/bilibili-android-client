package com.hotbitmapgg.bilibili.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.bilibili.adapter.helper.AbsRecyclerViewAdapter;
import com.hotbitmapgg.bilibili.entity.search.SearchArchiveInfo;

import java.util.List;

/**
 * Created by hcc on 16/8/29 21:18
 * 100332338@qq.com
 * <p/>
 * 综合搜索头部番剧Adapter
 */
public class ArchiveHeadBangumiAdapter extends AbsRecyclerViewAdapter {
    private List<SearchArchiveInfo.DataBean.ItemsBean.SeasonBean> seasons;

    public ArchiveHeadBangumiAdapter(RecyclerView recyclerView, List<SearchArchiveInfo.DataBean.ItemsBean.SeasonBean> seasons) {
        super(recyclerView);
        this.seasons = seasons;
    }


    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).
                inflate(R.layout.item_archive_head_bangumi, parent, false));
    }


    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            SearchArchiveInfo.DataBean.ItemsBean.SeasonBean seasonBean = seasons.get(position);

            Glide.with(getContext())
                    .load(seasonBean.getCover())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.bili_default_image_tv)
                    .dontAnimate()
                    .into(itemViewHolder.mBangumiPic);

            itemViewHolder.mBangumiTitle.setText(seasonBean.getTitle());
            if (seasonBean.getFinish() == 1) {
                itemViewHolder.mBangumiCount.setText(
                        seasonBean.getNewest_season() + "," + seasonBean.getTotal_count() + "话全");
            } else {
                itemViewHolder.mBangumiCount.setText(
                        seasonBean.getNewest_season() + "," + "更新至第" + seasonBean.getTotal_count() + "话");
            }
            itemViewHolder.mBangumiDetails.setText(seasonBean.getCat_desc());
        }

        super.onBindViewHolder(holder, position);
    }


    @Override
    public int getItemCount() {
        return seasons.size();
    }


    public class ItemViewHolder extends ClickableViewHolder {

        ImageView mBangumiPic;
        TextView mBangumiTitle;
        TextView mBangumiDetails;
        TextView mBangumiCount;


        public ItemViewHolder(View itemView) {
            super(itemView);
            mBangumiPic = $(R.id.item_img);
            mBangumiTitle = $(R.id.item_title);
            mBangumiDetails = $(R.id.item_details);
            mBangumiCount = $(R.id.item_count);
        }
    }
}
