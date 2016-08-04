package com.hotbitmapgg.ohmybilibili.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.model.user.UserVideoItem;
import com.hotbitmapgg.ohmybilibili.network.UrlHelper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 */
public class UpMoreCoverAdapter extends AbsRecyclerViewAdapter
{

    private List<UserVideoItem> userVideoList = new ArrayList<>();

    public UpMoreCoverAdapter(RecyclerView recyclerView, List<UserVideoItem> userVideoList)
    {

        super(recyclerView);
        this.userVideoList = userVideoList;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.list_item_up_more_video, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            UserVideoItem videoItem = userVideoList.get(position);
            String author = videoItem.author;
            String pic = videoItem.pic;
            String play = videoItem.play;
            int video_review = videoItem.video_review;
            String title = videoItem.title;

            Picasso.with(getContext()).load(UrlHelper.getClearVideoPreviewUrl(pic)).placeholder(R.drawable.bili_default_image_tv).into(itemViewHolder.mVideoPic);
            itemViewHolder.mVideoTitle.setText(title);
            itemViewHolder.mVideoUserInfo.setText(author);
            itemViewHolder.mVideoPlayNum.setText(play);
            itemViewHolder.mVideoReviewNum.setText(video_review + "");
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return userVideoList.size();
    }

    public void addData(UserVideoItem item)
    {
        userVideoList.add(item);
    }


    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        public ImageView mVideoPic;

        public TextView mVideoTitle;

        public TextView mVideoUserInfo;

        public TextView mVideoPlayNum;

        public TextView mVideoReviewNum;

        public ItemViewHolder(View itemView)
        {

            super(itemView);

            mVideoPic = $(R.id.user_video_pic);

            mVideoTitle = $(R.id.user_video_title);

            mVideoUserInfo = $(R.id.user_video_info);

            mVideoPlayNum = $(R.id.user_play_num);

            mVideoReviewNum = $(R.id.user_review_count);
        }
    }
}
