package com.hotbitmapgg.ohmybilibili.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.model.game.GameItem;
import com.hotbitmapgg.ohmybilibili.module.common.BrowserActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
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
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_game, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder mHolder = (ItemViewHolder) holder;
            final GameItem gameItem = games.get(position);
            Picasso.with(getContext()).load(gameItem.imageRes).error(R.drawable.bili_default_image_tv).into(mHolder.mImageView);
            mHolder.mTitle.setText(gameItem.name);
            mHolder.mButton.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View v)
                {

                    Intent mIntent = new Intent(getContext(), BrowserActivity.class);
                    mIntent.putExtra("url", gameItem.path);
                    mIntent.putExtra("title", gameItem.name);
                    getContext().startActivity(mIntent);
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

        public Button mButton;

        public ItemViewHolder(View itemView)
        {

            super(itemView);
            mImageView = $(R.id.game_img);
            mTitle = $(R.id.game_title);
            mButton = $(R.id.btn_download_game);
        }
    }
}
