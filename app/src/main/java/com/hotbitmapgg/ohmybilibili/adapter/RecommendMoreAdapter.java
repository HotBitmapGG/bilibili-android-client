package com.hotbitmapgg.ohmybilibili.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.model.VideoItemInfo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecommendMoreAdapter extends BaseAdapter
{
	
	private Context context;
	
	private List<VideoItemInfo> infos = new ArrayList<VideoItemInfo>();

	private LayoutInflater layoutInflater;

	
	public RecommendMoreAdapter(Context context , List<VideoItemInfo> datas)
	{
		this.context = context;
		this.infos = datas;
		layoutInflater = LayoutInflater.from(context);
	}
	
	
	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return infos.size();
	}

	@Override
	public Object getItem(int position)
	{
		// TODO Auto-generated method stub
		return infos.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		// TODO Auto-generated method stub
		return position;
	}
	
	public void addData(VideoItemInfo info)
	{
		infos.add(info);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		RecommendMoreViewHolder mViewHolder;
		if(convertView == null)
		{
			convertView = layoutInflater.inflate(R.layout.item_recommend_more, null);
			mViewHolder = new RecommendMoreViewHolder();
			
			mViewHolder.mVideoPreviewImg = (ImageView) convertView.findViewById(R.id.video_preview);
			mViewHolder.mVideoTitle = (TextView) convertView.findViewById(R.id.video_title);
			mViewHolder.mUploadUser = (TextView) convertView.findViewById(R.id.video_up);
			mViewHolder.mPlayCount = (TextView) convertView.findViewById(R.id.video_play_num);
			mViewHolder.mVideoReviewCount = (TextView) convertView.findViewById(R.id.video_review_count);
			
			convertView.setTag(mViewHolder);
		}
		else
		{
			mViewHolder = (RecommendMoreViewHolder) convertView.getTag();
		}
		
		VideoItemInfo videoItemInfo = infos.get(position);
		String author = videoItemInfo.author;
		String pic = videoItemInfo.pic;
		String play = videoItemInfo.play;
		int video_review = videoItemInfo.video_review;
		String title = videoItemInfo.title;
		
		Picasso.with(context).load(pic).placeholder(R.drawable.bili_default_image_tv).into(mViewHolder.mVideoPreviewImg);
		mViewHolder.mUploadUser.setText(author);
		mViewHolder.mVideoTitle.setText(title);
		mViewHolder.mPlayCount.setText(play);
		mViewHolder.mVideoReviewCount.setText(video_review + "");
		
		return convertView;
	}
	
	static class RecommendMoreViewHolder
	{
		ImageView mVideoPreviewImg;
		
		TextView mVideoTitle;
		
		TextView mUploadUser;
		
		TextView mPlayCount;
		
		TextView mVideoReviewCount;
	}

}
