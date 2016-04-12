package com.hotbitmapgg.ohmybilibili.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.model.SearchHistoryItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/4/10 16:40
 * 100332338@qq.com
 */
public class SearchRecycleAdapter extends BaseAdapter
{

    private List<SearchHistoryItem> items = new ArrayList<>();

    private final LayoutInflater layoutInflater;

    public SearchRecycleAdapter(Context context, List<SearchHistoryItem> items)
    {

        layoutInflater = LayoutInflater.from(context);
        this.items = items;
    }

    @Override
    public int getCount()
    {

        return items.size();
    }

    @Override
    public Object getItem(int position)
    {

        return items.get(position);
    }

    @Override
    public long getItemId(int position)
    {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        ItemViewHolder mItemViewHolder = null;
        if (convertView == null)
        {
            convertView = layoutInflater.inflate(R.layout.item_serach_history, parent , false);
            mItemViewHolder = new ItemViewHolder();
            mItemViewHolder.mIcon = (ImageView) convertView.findViewById(R.id.item_search_icon);
            mItemViewHolder.mName = (TextView) convertView.findViewById(R.id._item_search_text);

            convertView.setTag(mItemViewHolder);
        } else
        {
            mItemViewHolder = (ItemViewHolder) convertView.getTag();
        }

        SearchHistoryItem historyItem = items.get(position);
        mItemViewHolder.mIcon.setImageResource(R.drawable.ic_search_history);
        mItemViewHolder.mName.setText(historyItem.historyName);

        return convertView;
    }

    public class ItemViewHolder
    {

        public ImageView mIcon;

        public TextView mName;
    }
}
