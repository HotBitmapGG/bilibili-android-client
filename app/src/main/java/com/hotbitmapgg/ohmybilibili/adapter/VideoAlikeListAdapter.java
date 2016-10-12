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
import com.hotbitmapgg.ohmybilibili.entity.user.UserRecommendVideoInfo;
import com.hotbitmapgg.ohmybilibili.network.auxiliary.UrlHelper;

import java.util.List;

/**
 * Created by hcc on 16/8/7 21:18
 * 100332338@qq.com
 * <p/>
 * 视频详情界面相关视频Adapter
 */
public class VideoAlikeListAdapter extends AbsRecyclerViewAdapter
{

    private List<UserRecommendVideoInfo.AuthorData> authorRecommendList;

    private String upName;

    public VideoAlikeListAdapter(RecyclerView recyclerView, List<UserRecommendVideoInfo.AuthorData> authorRecommendList, String upName)
    {

        super(recyclerView);
        this.upName = upName;
        this.authorRecommendList = authorRecommendList;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).
                inflate(R.layout.item_video_strip, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            UserRecommendVideoInfo.AuthorData authorData = authorRecommendList.get(position);

            Glide.with(getContext())
                    .load(UrlHelper.getClearVideoPreviewUrl(authorData.cover))
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.bili_default_image_tv)
                    .dontAnimate()
                    .into(itemViewHolder.mVideoPic);

            itemViewHolder.mVideoTitle.setText(authorData.title);
            itemViewHolder.mVideoPlayNum.setText(String.valueOf(authorData.click));
            itemViewHolder.mVideoReviewNum.setText(String.valueOf(authorData.video_review));
            itemViewHolder.mUpName.setText(upName);
        }

        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return authorRecommendList.size();
    }

    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        ImageView mVideoPic;

        TextView mVideoTitle;

        TextView mVideoPlayNum;

        TextView mVideoReviewNum;

        TextView mUpName;

        public ItemViewHolder(View itemView)
        {

            super(itemView);

            mVideoPic = $(R.id.item_img);
            mVideoTitle = $(R.id.item_title);
            mVideoPlayNum = $(R.id.item_play);
            mVideoReviewNum = $(R.id.item_review);
            mUpName = $(R.id.item_user_name);
        }
    }
}
