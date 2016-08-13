package com.hotbitmapgg.ohmybilibili.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.entity.user.AuthorRecommend;
import com.hotbitmapgg.ohmybilibili.network.auxiliary.UrlHelper;
import com.squareup.picasso.Picasso;

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

    private List<AuthorRecommend.AuthorData> datas = new ArrayList<>();

    public VideoPartListAdapter(RecyclerView recyclerView, List<AuthorRecommend.AuthorData> datas)
    {

        super(recyclerView);
        this.datas = datas;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_video_parts, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder mHolder = (ItemViewHolder) holder;
            AuthorRecommend.AuthorData authorData = datas.get(position);

            int click = authorData.click;
            String cover = authorData.cover;
            int favorites = authorData.favorites;
            int review = authorData.review;
            int video_review = authorData.video_review;
            String title = authorData.title;

            Picasso.with(getContext())
                    .load(UrlHelper.getClearVideoPreviewUrl(cover))
                    .placeholder(R.drawable.bili_default_image_tv)
                    .into(mHolder.mVideoPic);

            mHolder.mVideoTitle.setText(title);
            mHolder.mVideoUserFav.setText(String.valueOf(favorites));
            mHolder.mVideoPlayNum.setText(String.valueOf(click));
            mHolder.mVideoUserCommend.setText(String.valueOf(review));
            mHolder.mVideoReviewNum.setText(String.valueOf(video_review));
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

        public TextView mVideoUserFav;

        public TextView mVideoUserCommend;

        public TextView mVideoPlayNum;

        public TextView mVideoReviewNum;

        public ItemViewHolder(View itemView)
        {

            super(itemView);

            mVideoPic = $(R.id.item_img);
            mVideoTitle = $(R.id.item_title);
            mVideoUserFav = $(R.id.item_fav);
            mVideoUserCommend = $(R.id.item_commend);
            mVideoPlayNum = $(R.id.item_play);
            mVideoReviewNum = $(R.id.item_review);
        }
    }
}
