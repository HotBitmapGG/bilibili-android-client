package com.hotbitmapgg.ohmybilibili.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.helper.AbsRecyclerViewAdapter;

import java.util.Random;

/**
 * Created by hcc on 2016/10/1 17:12
 * 100332338@qq.com
 * <p>
 * 番剧选集adapter
 */

public class BangumiDetailsSelectionAdapter extends AbsRecyclerViewAdapter
{

    private int count;

    private int layoutPosition = 0;

    private Random random = new Random();

    public BangumiDetailsSelectionAdapter(RecyclerView recyclerView, int count)
    {

        super(recyclerView);
        this.count = count;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_bangumi_selection, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.mTextView.setText(String.valueOf(position + 1));

            if (position == layoutPosition)
            {
                itemViewHolder.mCardView.setForeground(getContext().getDrawable(R.drawable.bg_selection));
            } else
            {
                itemViewHolder.mCardView.setForeground(getContext().getDrawable(R.drawable.bg_normal));
            }
        }
        super.onBindViewHolder(holder, position);
    }

    public void notifyItemForeground(int clickPosition)
    {

        layoutPosition = clickPosition;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount()
    {

        return count == 0 ? random.nextInt(20) : count;
    }

    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        CardView mCardView;

        TextView mTextView;

        public ItemViewHolder(View itemView)
        {

            super(itemView);
            mCardView = $(R.id.card_view);
            mTextView = $(R.id.tv_num);
        }
    }
}
