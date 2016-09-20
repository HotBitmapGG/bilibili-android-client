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
import com.hotbitmapgg.ohmybilibili.entity.bangumi.TwoDimensional;
import com.hotbitmapgg.ohmybilibili.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/8/6 11:51
 * 100332338@qq.com
 * <p/>
 * 二次元新番Adapter
 */
public class TwoDimensionalRecyclerAdapter extends AbsRecyclerViewAdapter
{

    private List<TwoDimensional.ListBean> twoDimensionals = new ArrayList<>();

    public TwoDimensionalRecyclerAdapter(RecyclerView recyclerView, List<TwoDimensional.ListBean> twoDimensionals)
    {

        super(recyclerView);
        this.twoDimensionals = twoDimensionals;
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
            TwoDimensional.ListBean listBean = twoDimensionals.get(position);

            Glide.with(getContext())
                    .load(listBean.getCover())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.bili_default_image_tv)
                    .dontAnimate()
                    .into(itemViewHolder.mImage);

            itemViewHolder.mTitle.setText(listBean.getTitle());
            itemViewHolder.mDesc.setText(TimeUtils.friendlyTime(listBean.getLastupdate_at()) + "更新");
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return twoDimensionals.size();
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
