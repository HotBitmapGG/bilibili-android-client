package com.hotbitmapgg.bilibili.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.bilibili.adapter.helper.AbsRecyclerViewAdapter;
import com.hotbitmapgg.bilibili.entity.user.UserContributeInfo;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.List;

/**
 * Created by hcc on 16/8/7 21:18
 * 100332338@qq.com
 * <p/>
 * 用户详情主页投稿adapter
 */
public class UserHomePagerContributeAdapter extends AbsRecyclerViewAdapter {
    private List<UserContributeInfo.DataBean.VlistBean> userContributes;

    public UserHomePagerContributeAdapter(RecyclerView recyclerView, List<UserContributeInfo.DataBean.VlistBean> userContributes) {
        super(recyclerView);
        this.userContributes = userContributes;
    }


    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).
                inflate(R.layout.item_video_card, parent, false));
    }


    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            UserContributeInfo.DataBean.VlistBean vlistBean = userContributes.get(position);

            Glide.with(getContext())
                    .load("http:" + vlistBean.getPic())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.bili_default_image_tv)
                    .dontAnimate()
                    .into(itemViewHolder.mVideoPic);

            itemViewHolder.mVideoTitle.setText(vlistBean.getTitle());
            itemViewHolder.mVideoPlayNum.setText(String.valueOf(vlistBean.getPlay()));
            itemViewHolder.mVideoReviewNum.setText(String.valueOf(vlistBean.getVideo_review()));
        }
        super.onBindViewHolder(holder, position);
    }


    @Override
    public int getItemCount() {
        if (userContributes.size() == 0) {
            return 0;
        } else if (userContributes.size() == 1) {
            return 1;
        } else {
            return 2;
        }
    }


    public class ItemViewHolder extends ClickableViewHolder {

        ImageView mVideoPic;
        TextView mVideoTitle;
        TextView mVideoPlayNum;
        TextView mVideoReviewNum;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mVideoPic = $(R.id.item_img);
            mVideoTitle = $(R.id.item_title);
            mVideoPlayNum = $(R.id.item_play);
            mVideoReviewNum = $(R.id.item_review);
        }
    }
}
