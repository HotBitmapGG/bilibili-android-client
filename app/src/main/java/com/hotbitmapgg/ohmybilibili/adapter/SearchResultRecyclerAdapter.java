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
 * Created by hcc on 16/8/29 21:18
 * 100332338@qq.com
 * <p/>
 * 搜索列表数据Adapter
 */
public class SearchResultRecyclerAdapter extends AbsRecyclerViewAdapter
{

    private List<SearchResult.ResultBean.BangumiBean> bangumis;

    public SearchResultRecyclerAdapter(RecyclerView recyclerView, List<SearchResult.ResultBean.BangumiBean> bangumis)
    {

        super(recyclerView);
        this.bangumis = bangumis;
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
            SearchResult.ResultBean.BangumiBean bangumiBean = bangumis.get(position);

            Glide.with(getContext())
                    .load(UrlHelper.getClearVideoPreviewUrl(bangumiBean.getCover()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(R.drawable.bili_default_image_tv)
                    .into(itemViewHolder.mVideoPic);

            itemViewHolder.mVideoTitle.setText(bangumiBean.getTitle());
            itemViewHolder.mVideoPlayNum.setText(String.valueOf(bangumiBean.getPlay_count()));
            itemViewHolder.mVideoReviewNum.setText(String.valueOf(bangumiBean.getDanmaku_count()));
            itemViewHolder.mUserName.setText(bangumiBean.getStyles());
        }

        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return bangumis.size();
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
