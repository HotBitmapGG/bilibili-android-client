package com.hotbitmapgg.ohmybilibili.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;


public class MoreLayoutAdapter extends BaseAdapter
{

    private String[] itemNames = new String[]{"番剧", "动画", "音乐", "舞蹈", "游戏", "科技", "娱乐", "鬼畜", "电影", "电视剧",};

    private int[] itemIcons = new int[]{R.drawable.ic_category_t13, R.drawable.ic_category_t1, R.drawable.ic_category_t3, R.drawable.ic_category_t129, R.drawable.ic_category_t4, R.drawable.ic_category_t36, R.drawable.ic_category_t5, R.drawable.ic_category_t119, R.drawable.ic_category_t23, R.drawable.ic_category_t11};

    private Context context;

    public MoreLayoutAdapter(Context context)
    {

        this.context = context;
    }

    @Override
    public int getCount()
    {
        // TODO Auto-generated method stub
        return itemNames.length;
    }

    @Override
    public Object getItem(int position)
    {
        // TODO Auto-generated method stub
        return itemIcons[position];
    }

    @Override
    public long getItemId(int position)
    {
        // TODO Auto-generated method stub
        return position;
    }

    @SuppressWarnings("null")
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        MoreLayoutViewHolder mViewHolder;
        if (convertView == null)
        {
            mViewHolder = new MoreLayoutViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_grid_home_more, null);
            mViewHolder.mItemPic = (ImageView) convertView.findViewById(R.id.item_more_icon);
            mViewHolder.mItemText = (TextView) convertView.findViewById(R.id.item_more_text);

            convertView.setTag(mViewHolder);
        } else
        {
            mViewHolder = (MoreLayoutViewHolder) convertView.getTag();
        }

        mViewHolder.mItemPic.setImageResource(itemIcons[position]);
        mViewHolder.mItemText.setText(itemNames[position]);

        return convertView;
    }

    static class MoreLayoutViewHolder
    {

        ImageView mItemPic;

        TextView mItemText;
    }
}
