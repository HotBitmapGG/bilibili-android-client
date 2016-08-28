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
import com.hotbitmapgg.ohmybilibili.entity.user.UserUpVideoInfo;
import com.hotbitmapgg.ohmybilibili.network.auxiliary.UrlHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/8/7 21:18
 * 100332338@qq.com
 * <p/>
 * UP主上传视频查看Adapter
 */
public class UserUpVideoAdapter extends AbsRecyclerViewAdapter
{

    private List<UserUpVideoInfo.VlistBean> parts = new ArrayList<>();

    public UserUpVideoAdapter(RecyclerView recyclerView,
                              List<UserUpVideoInfo.VlistBean> parts)
    {

        super(recyclerView);
        this.parts = parts;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext())
                .inflate(R.layout.item_video_card, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            UserUpVideoInfo.VlistBean vlistBean = parts.get(position);

            Glide.with(getContext())
                    .load(UrlHelper.getClearVideoPreviewUrl(vlistBean.getPic()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(R.drawable.bili_default_image_tv)
                    .into(itemViewHolder.mVideoPic);


            itemViewHolder.mVideoTitle.setText(vlistBean.getTitle());
            itemViewHolder.mVideoPlayNum.setText(String.valueOf(vlistBean.getPlay()));
            itemViewHolder.mVideoReviewNum.setText(String.valueOf(vlistBean.getVideo_review()));
        }

        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return parts.size();
    }

    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        ImageView mVideoPic;

        TextView mVideoTitle;

        TextView mVideoPlayNum;

        TextView mVideoReviewNum;

        public ItemViewHolder(View itemView)
        {

            super(itemView);

            mVideoPic = $(R.id.item_img);
            mVideoTitle = $(R.id.item_title);
            mVideoPlayNum = $(R.id.item_play);
            mVideoReviewNum = $(R.id.item_review);
        }
    }
}
