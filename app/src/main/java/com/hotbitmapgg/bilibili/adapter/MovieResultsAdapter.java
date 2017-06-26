package com.hotbitmapgg.bilibili.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.bilibili.adapter.helper.AbsRecyclerViewAdapter;
import com.hotbitmapgg.bilibili.entity.search.SearchMovieInfo;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.List;

/**
 * Created by hcc on 16/9/4 12:28
 * 100332338@qq.com
 * <p/>
 * 影视搜索结果Adapter
 */
public class MovieResultsAdapter extends AbsRecyclerViewAdapter {
    private List<SearchMovieInfo.DataBean.ItemsBean> movies;

    public MovieResultsAdapter(RecyclerView recyclerView, List<SearchMovieInfo.DataBean.ItemsBean> movies) {
        super(recyclerView);
        this.movies = movies;
    }


    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).
                inflate(R.layout.item_search_movie, parent, false));
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            SearchMovieInfo.DataBean.ItemsBean itemsBean = movies.get(position);

            Glide.with(getContext())
                    .load(itemsBean.getCover())
                    .centerCrop()
                    .dontAnimate()
                    .placeholder(R.drawable.ico_user_default)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(itemViewHolder.mImage);

            itemViewHolder.mTitle.setText(itemsBean.getTitle());
        }
        super.onBindViewHolder(holder, position);
    }


    @Override
    public int getItemCount() {
        return movies.size();
    }


    public class ItemViewHolder extends ClickableViewHolder {

        ImageView mImage;
        TextView mTitle;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mImage = $(R.id.item_img);
            mTitle = $(R.id.item_title);
        }
    }
}
