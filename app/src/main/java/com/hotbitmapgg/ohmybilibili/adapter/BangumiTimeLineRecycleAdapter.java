package com.hotbitmapgg.ohmybilibili.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.WeekDayBangumi;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 番剧放送表Adapter
 */
public class BangumiTimeLineRecycleAdapter extends AbsRecyclerViewAdapter
{


    private ArrayList<WeekDayBangumi> mList;

    public BangumiTimeLineRecycleAdapter(RecyclerView recyclerView, ArrayList<WeekDayBangumi> list)
    {

        super(recyclerView);
        this.mList = list;
    }

    @Override
    public AbsRecyclerViewAdapter.ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        View v = LayoutInflater.from(getContext()).inflate(R.layout.card_item_bangumi_horizontal, parent, false);
        return new CardHolder(v);
    }

    @Override
    public void onBindViewHolder(AbsRecyclerViewAdapter.ClickableViewHolder cvh, int position)
    {

        super.onBindViewHolder(cvh, position);
        if (cvh instanceof CardHolder)
        {
            CardHolder holder = (CardHolder) cvh;

            holder.mTitleView.setText(getItem(position).title);
            holder.mWeekdayView.setText(String.format(getContext().getString(R.string.weekday_update), getContext().getResources().getStringArray(R.array.weekdays)[getItem(position).weekday])
            );

            if (!TextUtils.isEmpty(getItem(position).cover))
            {
                Picasso.with(getContext()).load(Uri.parse(getItem(position).cover)).placeholder(R.drawable.bili_default_image_tv).error(R.drawable.bili_default_image_tv).into(holder.mPreviewImage);
            } else
            {
                holder.mPreviewImage.setImageResource(R.drawable.bili_default_image_tv);
            }
        }
    }

    public WeekDayBangumi getItem(int pos)
    {

        return mList.get(pos);
    }

    @Override
    public int getItemCount()
    {

        return Math.min(10, mList != null ? mList.size() : 0);
    }

    public class CardHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        public ImageView mPreviewImage;

        public TextView mTitleView, mWeekdayView;

        public CardHolder(View itemView)
        {

            super(itemView);
            mPreviewImage = $(R.id.bangumi_preview);
            mTitleView = $(R.id.bangumi_title);
            mWeekdayView = $(R.id.bangumi_weekday);
        }
    }
}
