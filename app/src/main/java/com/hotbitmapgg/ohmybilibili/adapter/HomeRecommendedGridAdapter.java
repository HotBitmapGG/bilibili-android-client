package com.hotbitmapgg.ohmybilibili.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.model.recommended.Body;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 */
public class HomeRecommendedGridAdapter extends AbsRecyclerViewAdapter
{

    private List<Body> bodys = new ArrayList<>();

    private int pos;

    public HomeRecommendedGridAdapter(RecyclerView recyclerView, List<Body> bodys, int pos)
    {

        super(recyclerView);
        this.bodys = bodys;
        this.pos = pos;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_home_recommended_grid, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            Body body = bodys.get(position);
            Picasso.with(getContext())
                    .load(Uri.parse(body.getCover()))
                    .placeholder(R.drawable.bili_default_image_tv)
                    .into(itemViewHolder.mVideoImg);

            itemViewHolder.mVideoTitle.setText(body.getTitle());

            if (pos == 1)
            {
                itemViewHolder.mLiveLayout.setVisibility(View.VISIBLE);
                itemViewHolder.mVideoLayout.setVisibility(View.GONE);
                itemViewHolder.mLiveUp.setText(body.getUp());
                itemViewHolder.mLiveOnline.setText(body.getOnline() + "");
            } else if (pos == 2)
            {
                itemViewHolder.mLiveLayout.setVisibility(View.VISIBLE);
                itemViewHolder.mVideoLayout.setVisibility(View.GONE);
                itemViewHolder.mLiveUp.setText(body.getDesc1());
            } else if(pos == 9)
            {
                itemViewHolder.mLiveLayout.setVisibility(View.GONE);
                itemViewHolder.mVideoLayout.setVisibility(View.GONE);
            }
            else
            {
                itemViewHolder.mLiveLayout.setVisibility(View.GONE);
                itemViewHolder.mVideoLayout.setVisibility(View.VISIBLE);
                itemViewHolder.mVideoPlayNum.setText(body.getPlay());
                itemViewHolder.mVideoReviewCount.setText(body.getDanmaku());
            }
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return bodys.size();
    }

    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        public ImageView mVideoImg;

        public TextView mVideoTitle;

        public TextView mVideoPlayNum;

        public TextView mVideoReviewCount;

        public LinearLayout mVideoLayout;

        public RelativeLayout mLiveLayout;

        public TextView mLiveUp;

        public TextView mLiveOnline;

        public ItemViewHolder(View itemView)
        {

            super(itemView);
            mVideoImg = $(R.id.video_preview);
            mVideoTitle = $(R.id.video_title);
            mVideoPlayNum = $(R.id.video_play_num);
            mVideoReviewCount = $(R.id.video_review_count);
            mLiveLayout = $(R.id.layout_live);
            mVideoLayout = $(R.id.layout_video);
            mLiveOnline = $(R.id.item_live_online);
            mLiveUp = $(R.id.item_live_up);
        }
    }
}
