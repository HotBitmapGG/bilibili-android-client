package com.hotbitmapgg.ohmybilibili.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.entity.search.SearchResult;
import com.hotbitmapgg.ohmybilibili.network.auxiliary.UrlHelper;

import java.util.List;

/**
 * Created by hcc on 16/9/4 12:16
 * 100332338@qq.com
 * <p/>
 * 综合搜索结果Adapter
 */
public class ComprehensiveResultsAdapter extends AbsRecyclerViewAdapter
{

    private List<SearchResult.ResultBean.VideoBean> videos;

    public ComprehensiveResultsAdapter(RecyclerView recyclerView,
                                       List<SearchResult.ResultBean.VideoBean> videos)
    {

        super(recyclerView);
        this.videos = videos;
    }


    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).
                inflate(R.layout.item_video_strip, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            SearchResult.ResultBean.VideoBean videoBean = videos.get(position);

            Glide.with(getContext())
                    .load(UrlHelper.getClearVideoPreviewUrl(videoBean.getPic()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(R.drawable.bili_default_image_tv)
                    .into(itemViewHolder.mVideoPic);

            itemViewHolder.mVideoTitle.setText(videoBean.getTitle());
            itemViewHolder.mVideoPlayNum.setText(String.valueOf(videoBean.getPlay()));
            itemViewHolder.mVideoReviewNum.setText(String.valueOf(videoBean.getVideo_review()));
            itemViewHolder.mUserName.setText(videoBean.getAuthor());
        }

        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return videos.size();
    }

    public class ItemViewHolder extends ClickableViewHolder
    {

        public ImageView mVideoPic;

        public TextView mVideoTitle;

        public TextView mVideoPlayNum;

        public TextView mVideoReviewNum;

        public TextView mUserName;

        public ItemViewHolder(View itemView)
        {

            super(itemView);

            mVideoPic = $(R.id.item_img);
            mVideoTitle = $(R.id.item_title);
            mVideoPlayNum = $(R.id.item_play);
            mVideoReviewNum = $(R.id.item_review);
            mUserName = $(R.id.item_user_name);
        }
    }
}
