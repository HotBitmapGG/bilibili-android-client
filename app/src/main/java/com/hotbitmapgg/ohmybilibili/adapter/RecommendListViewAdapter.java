package com.hotbitmapgg.ohmybilibili.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.model.VideoItemInfo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 */
public class RecommendListViewAdapter extends AbsRecyclerViewAdapter
{


    private ArrayList<VideoItemInfo> mList;

    public RecommendListViewAdapter(RecyclerView recyclerView, ArrayList<VideoItemInfo> list)
    {

        super(recyclerView);
        this.mList = list;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        View v = LayoutInflater.from(getContext()).inflate(R.layout.card_item_home_recommend, parent, false);
        return new CardHolder(v);
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder cvh, int position)
    {

        super.onBindViewHolder(cvh, position);
        if (cvh instanceof CardHolder)
        {
            CardHolder holder = (CardHolder) cvh;

            holder.mTitleView.setText(getVideoItem(position).title);
            holder.mPlayNum.setText(getVideoItem(position).play);
            holder.mReviewNum.setText((getVideoItem(position).video_review) + "");

            Picasso.with(getContext()).load(Uri.parse(getVideoItem(position).pic)).placeholder(R.drawable.bili_default_image_tv).into(holder.mPreviewImage);
        }
    }

    public VideoItemInfo getVideoItem(int pos)
    {

        return mList.get(pos);
    }

    @Override
    public int getItemCount()
    {

        return mList != null ? mList.size() : 0;
    }

    public class CardHolder extends ClickableViewHolder
    {

        public ImageView mPreviewImage;

        public TextView mTitleView;

        public TextView mPlayNum;

		public TextView  mReviewNum;


        public CardHolder(View itemView)
        {

            super(itemView);
            mPreviewImage = $(R.id.recommend_preview);
            mTitleView = $(R.id.recommend_title);
            mPlayNum = $(R.id.recommend__play_num);
            mReviewNum = $(R.id.recommend__review_count);
        }
    }
}
