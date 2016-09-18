package com.hotbitmapgg.ohmybilibili.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.entity.game.GameItem;
import com.hotbitmapgg.ohmybilibili.module.common.WebActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 游戏中心Adapter
 */
public class GameCentreAdapter extends AbsRecyclerViewAdapter
{

    private List<GameItem> games = new ArrayList<>();

    public GameCentreAdapter(RecyclerView recyclerView, List<GameItem> games)
    {

        super(recyclerView);
        this.games = games;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).
                inflate(R.layout.item_game_center, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder mHolder = (ItemViewHolder) holder;
            final GameItem gameItem = games.get(position);

            Glide.with(getContext())
                    .load(gameItem.imageRes)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.bili_default_image_tv)
                    .into(mHolder.mImageView);

            mHolder.mTitle.setText(gameItem.name);
            mHolder.mDesc.setText(gameItem.desc);
            mHolder.mButton.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View v)
                {

                    WebActivity.
                            launch((Activity) getContext(),
                                    gameItem.path, gameItem.name);
                }
            });
        }

        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return games.size();
    }

    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        public ImageView mImageView;

        public TextView mTitle;

        public TextView mDesc;

        public Button mButton;


        public ItemViewHolder(View itemView)
        {

            super(itemView);
            mImageView = $(R.id.item_img);
            mTitle = $(R.id.item_title);
            mDesc = $(R.id.item_desc);
            mButton = $(R.id.item_btn);
        }
    }
}
