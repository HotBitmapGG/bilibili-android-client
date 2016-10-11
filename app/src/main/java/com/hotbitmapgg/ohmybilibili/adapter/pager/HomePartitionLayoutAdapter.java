package com.hotbitmapgg.ohmybilibili.adapter.pager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 首页分区Adapter
 */
public class HomePartitionLayoutAdapter extends BaseAdapter
{

    private Context context;

    private String[] itemNames = new String[]{
            "直播", "番剧", "动画",
            "音乐", "舞蹈", "游戏",
            "科技", "生活", "鬼畜",
            "时尚", "广告", "娱乐",
            "电影", "电视剧", "游戏中心",
            };

    private int[] itemIcons = new int[]{
            R.drawable.ic_category_live,
            R.drawable.ic_category_t13,
            R.drawable.ic_category_t1,
            R.drawable.ic_category_t3,
            R.drawable.ic_category_t129,
            R.drawable.ic_category_t4,
            R.drawable.ic_category_t36,
            R.drawable.ic_category_t160,
            R.drawable.ic_category_t119,
            R.drawable.ic_category_t155,
            R.drawable.ic_category_t165,
            R.drawable.ic_category_t5,
            R.drawable.ic_category_t23,
            R.drawable.ic_category_t11,
            R.drawable.ic_category_game_center
    };


    public HomePartitionLayoutAdapter(Context context)
    {

        this.context = context;
    }

    @Override
    public int getCount()
    {

        return itemNames.length;
    }

    @Override
    public Object getItem(int position)
    {

        return itemIcons[position];
    }

    @Override
    public long getItemId(int position)
    {

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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_home_more_grid, parent, false);
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

    private static class MoreLayoutViewHolder
    {

        ImageView mItemPic;

        TextView mItemText;
    }
}
