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
import com.hotbitmapgg.ohmybilibili.adapter.helper.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.module.home.focus.FocusOnBangumi;

import java.util.List;

/**
 * Created by hcc on 2016/9/28 20:26
 * 100332338@qq.com
 * <p>
 * 关注界面番剧Adapter
 */

public class FocusOnBangumiAdapter extends AbsRecyclerViewAdapter
{

    private List<FocusOnBangumi> focusOnBangumis;

    public FocusOnBangumiAdapter(RecyclerView recyclerView, List<FocusOnBangumi> focusOnBangumis)
    {

        super(recyclerView);
        this.focusOnBangumis = focusOnBangumis;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_focus_bangumi, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            FocusOnBangumi focusOnBangumi = focusOnBangumis.get(position);

            Glide.with(getContext())
                    .load(focusOnBangumi.getPic())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.bili_default_image_tv)
                    .dontAnimate()
                    .into(itemViewHolder.mImage);

            itemViewHolder.mTitle.setText(focusOnBangumi.getTitle());
            itemViewHolder.mDesc.setText(focusOnBangumi.getDesc());
        }

        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return focusOnBangumis.size();
    }

    private class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        ImageView mImage;

        TextView mTitle;

        TextView mDesc;

        public ItemViewHolder(View itemView)
        {

            super(itemView);
            mImage = $(R.id.item_img);
            mTitle = $(R.id.item_title);
            mDesc = $(R.id.item_desc);
        }
    }
}
