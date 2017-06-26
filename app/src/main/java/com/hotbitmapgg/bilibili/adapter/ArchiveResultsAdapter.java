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
import com.hotbitmapgg.bilibili.utils.NumberUtil;

import java.util.List;

/**
 * Created by hcc on 16/9/4 12:16
 * 100332338@qq.com
 * <p/>
 * 综合搜索结果Adapter
 */
public class ArchiveResultsAdapter extends AbsRecyclerViewAdapter {
    private List<SearchArchiveInfo.DataBean.ItemsBean.ArchiveBean> archives;

    public ArchiveResultsAdapter(RecyclerView recyclerView, List<SearchArchiveInfo.DataBean.ItemsBean.ArchiveBean> archives) {
        super(recyclerView);
        this.archives = archives;
    }


    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).
                inflate(R.layout.item_search_archive, parent, false));
    }


    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            SearchArchiveInfo.DataBean.ItemsBean.ArchiveBean archiveBean = archives.get(position);

            Glide.with(getContext())
                    .load(archiveBean.getCover())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.bili_default_image_tv)
                    .dontAnimate()
                    .into(itemViewHolder.mVideoPic);

            itemViewHolder.mVideoTitle.setText(archiveBean.getTitle());
            itemViewHolder.mVideoPlayNum.setText(NumberUtil.converString(archiveBean.getPlay()));
            itemViewHolder.mVideoReviewNum.setText(NumberUtil.converString(archiveBean.getDanmaku()));
            itemViewHolder.mUserName.setText(archiveBean.getAuthor());
            if (archiveBean.getDuration() != null) {
                itemViewHolder.mDuration.setText(archiveBean.getDuration());
            } else {
                itemViewHolder.mDuration.setText("--:--");
            }
        }

        super.onBindViewHolder(holder, position);
    }


    @Override
    public int getItemCount() {
        return archives.size();
    }


    public class ItemViewHolder extends ClickableViewHolder {

        ImageView mVideoPic;
        TextView mVideoTitle;
        TextView mVideoPlayNum;
        TextView mVideoReviewNum;
        TextView mUserName;
        TextView mDuration;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mVideoPic = $(R.id.item_img);
            mVideoTitle = $(R.id.item_title);
            mVideoPlayNum = $(R.id.item_play);
            mVideoReviewNum = $(R.id.item_review);
            mUserName = $(R.id.item_user_name);
            mDuration = $(R.id.item_duration);
        }
    }
}
