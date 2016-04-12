package com.hotbitmapgg.ohmybilibili.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.model.PartitionMoreVideoItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PartitionMoreListViewAdapter extends AbsRecyclerViewAdapter
{



	private ArrayList<PartitionMoreVideoItem> mList;

	public PartitionMoreListViewAdapter(RecyclerView recyclerView , ArrayList<PartitionMoreVideoItem> list)
	{

		super(recyclerView);
		this.mList = list;
	}


	@Override
	public void onBindViewHolder(AbsRecyclerViewAdapter.ClickableViewHolder holder, int position)
	{

		super.onBindViewHolder(holder, position);
		if(holder instanceof  ItemViewHolder)
		{
			try
			{
				ItemViewHolder mHolder = (ItemViewHolder) holder;

				PartitionMoreVideoItem videoItemInfo = mList.get(position);

				mHolder.mTitleView.setText(videoItemInfo.title == null ? "" : videoItemInfo.title);

				Picasso.with(getContext()).load(Uri.parse(videoItemInfo.pic)).placeholder(R.drawable.bili_default_image_tv).into(mHolder.mPreviewImage);

				String play = videoItemInfo.play;

				int video_review = videoItemInfo.video_review;

				mHolder.mPlayNum.setText(play);

				mHolder.mReviewNum.setText(video_review + "");

				String author = videoItemInfo.author;

				mHolder.mUploadUser.setText(author);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{

		bindContext(parent.getContext());
		return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_partition_more_list, parent , false));
	}


	@Override
	public int getItemCount()
	{

		return mList.size();
	}


	private class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
	{
		public ImageView mPreviewImage;

		public TextView mTitleView;

		public TextView mPlayNum;

		public TextView mReviewNum;

		public TextView mUploadUser;


		public ItemViewHolder(View itemView)
		{

			super(itemView);

			mPreviewImage = $(R.id.bangumi_more_list_video_pic);
			mTitleView =  $(R.id.bangumi_more_list_video_title);
			mPlayNum =  $(R.id.bangumi_more_list_play_num);
			mReviewNum =  $(R.id.bangumi_more_list_review_count);
			mUploadUser =  $(R.id.bangumi_more_list_video_info);

		}
	}
}
