package com.hotbitmapgg.ohmybilibili.adapter;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.model.video.Sp;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 */
public class SpItemAdapter extends BaseAdapter
{

	private ArrayList<Sp.Item> mList;

	private Context context;

	private LayoutInflater layoutInflater;

	public SpItemAdapter(Context context, ArrayList<Sp.Item> datas)
	{
		this.mList = datas;
		this.context = context;
		layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position)
	{
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		BangumiViewHolder mViewHolder;
		if (convertView == null)
		{
			mViewHolder = new BangumiViewHolder();
			convertView = layoutInflater.inflate(R.layout.item_sp_video, null);
			mViewHolder.mPreviewImage = (ImageView) convertView.findViewById(R.id.sp_item_preview);
			mViewHolder.mSpNum = (TextView) convertView.findViewById(R.id.sp_item_num);
			convertView.setTag(mViewHolder);
		}
		else
		{
			mViewHolder = (BangumiViewHolder) convertView.getTag();
		}

		Sp.Item item = mList.get(position);
		mViewHolder.mSpNum.setText("第" + item.episode + "话");
		String cover = item.cover;
		if(!TextUtils.isEmpty(cover))
		{
			Picasso.with(context).load(Uri.parse(cover)).placeholder(R.drawable.bili_default_image_tv).into(mViewHolder.mPreviewImage);
		}
		else
		{
			mViewHolder.mPreviewImage.setImageResource(R.drawable.bili_default_image_tv);
		}



		return convertView;
	}

	static class BangumiViewHolder
	{
		public ImageView mPreviewImage;

		public TextView mSpNum;

	}

}
