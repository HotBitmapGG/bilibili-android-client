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
import com.hotbitmapgg.ohmybilibili.entity.user.UserRecommend;
import com.hotbitmapgg.ohmybilibili.network.auxiliary.UrlHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/8/7 21:18
 * 100332338@qq.com
 * <p/>
 * 相关视频查看更多Adapter
 */
public class VideoPartListAdapter extends AbsRecyclerViewAdapter
{

    private List<UserRecommend.AuthorData> datas = new ArrayList<>();

    public VideoPartListAdapter(RecyclerView recyclerView,
                                List<UserRecommend.AuthorData> datas)
    {

        super(recyclerView);
        this.datas = datas;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).
                inflate(R.layout.item_video_card, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder mHolder = (ItemViewHolder) holder;
            UserRecommend.AuthorData authorData = datas.get(position);

            Glide.with(getContext())
                    .load(UrlHelper.getClearVideoPreviewUrl(authorData.cover))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(R.drawable.bili_default_image_tv)
                    .into(mHolder.mVideoPic);

            mHolder.mVideoTitle.setText(authorData.title);
            mHolder.mVideoPlayNum.setText(String.valueOf(authorData.click));
            mHolder.mVideoReviewNum.setText(String.valueOf(authorData.video_review));
        }

        super.onBindViewHolder(holder, position);
    }


    @Override
    public int getItemCount()
    {

        return datas.size();
    }

    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        public ImageView mVideoPic;

        public TextView mVideoTitle;

        public TextView mVideoPlayNum;

        public TextView mVideoReviewNum;

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
