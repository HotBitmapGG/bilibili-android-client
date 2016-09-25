package com.hotbitmapgg.ohmybilibili.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.helper.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiRecommend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/8/6 11:51
 * 100332338@qq.com
 * <p/>
 * 首页番剧推荐Adapter
 */
public class SecondElementBangumiAdapter extends AbsRecyclerViewAdapter
{

    private List<BangumiRecommend.RecommendsBean> recommends = new ArrayList<>();

    public SecondElementBangumiAdapter(RecyclerView recyclerView, List<BangumiRecommend.RecommendsBean> recommends)
    {

        super(recyclerView);
        this.recommends = recommends;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext())
                .inflate(R.layout.item_bangumi_recommend, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            BangumiRecommend.RecommendsBean recommendsBean = recommends.get(position);

            Glide.with(getContext())
                    .load(recommendsBean.getPic())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.bili_default_image_tv)
                    .dontAnimate()
                    .into(itemViewHolder.mImage);

            itemViewHolder.mTitle.setText(recommendsBean.getTitle());
            itemViewHolder.mDesc.setText(recommendsBean.getDescription());
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return recommends.size();
    }

    private class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        public ImageView mImage;

        public TextView mTitle;

        public TextView mDesc;

        public ItemViewHolder(View itemView)
        {

            super(itemView);
            mImage = $(R.id.item_img);
            mTitle = $(R.id.item_title);
            mDesc = $(R.id.item_desc);
        }
    }
}
