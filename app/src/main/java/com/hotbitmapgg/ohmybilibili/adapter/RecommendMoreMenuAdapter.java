package com.hotbitmapgg.ohmybilibili.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;


public class RecommendMoreMenuAdapter extends BaseAdapter
{

	private Context mContext;

	String[] name = {"按新投稿查看", "按新评论查看" ,"按评论数查看","按点击数查看","按弹幕数查看","按推荐数查看","按硬币数查看"};

	public RecommendMoreMenuAdapter(Context context)
	{
		mContext = context;

	}

	@Override
	public int getCount()
	{
		return name.length;
	}

	@Override
	public Object getItem(int position)
	{
		return name[position];
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ViewHolder holder = null;
		if (convertView == null)
		{
			holder = new ViewHolder();
			LayoutInflater inflater = LayoutInflater.from(mContext);
			convertView = inflater.inflate(R.layout.item_recommend_more_menu, null);
			holder.text= (TextView) convertView.findViewById(R.id.btnname);
			convertView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}

		holder.text.setText(name[position]);
		return convertView;
	}

	static class ViewHolder
	{
		public TextView text;

	}

	@Override
	public long getItemId(int position)
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
