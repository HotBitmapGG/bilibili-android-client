package com.hotbitmapgg.ohmybilibili.adapter.section;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.WeekDayBangumi;
import com.hotbitmapgg.ohmybilibili.module.home.bangumi.SpecialDetailsActivity;
import com.hotbitmapgg.ohmybilibili.widget.sectioned.StatelessSection;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hcc on 16/8/25 20:52
 * 100332338@qq.com
 * <p/>
 * 二三次元番剧专题Section
 */
public class WeekDayBangumiSection extends StatelessSection
{


    private Context mContext;

    private int iconRes;

    private String title;

    private List<WeekDayBangumi> weekDayBangumis;


    public WeekDayBangumiSection(Context context, List<WeekDayBangumi> weekDayBangumis, int iconRes, String title)
    {

        super(R.layout.layout_weekday_bangumi_head, R.layout.layout_weekday_bangumi_boby);
        this.weekDayBangumis = weekDayBangumis;
        this.mContext = context;
        this.iconRes = iconRes;
        this.title = title;
    }

    @Override
    public int getContentItemsTotal()
    {

        return weekDayBangumis.size();
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view)
    {

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position)
    {

        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        final WeekDayBangumi weekDayBangumi = weekDayBangumis.get(position);
        itemViewHolder.mTitle.setText(weekDayBangumi.title);
        if (!TextUtils.isEmpty(weekDayBangumi.cover))
        {
            Glide.with(mContext)
                    .load(Uri.parse(weekDayBangumi.cover))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.bili_default_image_tv)
                    .into(itemViewHolder.mImageView);
        } else
        {
            itemViewHolder.mImageView.setImageResource(R.drawable.bili_default_image_tv);
        }

        itemViewHolder.mCardView.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                SpecialDetailsActivity.launch(
                        (Activity) mContext,
                        weekDayBangumi.spid,
                        weekDayBangumi.title,
                        weekDayBangumi.season_id);
            }
        });
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view)
    {

        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder)
    {

        HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
        Drawable drawable = ContextCompat.getDrawable(mContext, iconRes);
        if (drawable != null)
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        headerViewHolder.mWeekDay.setCompoundDrawables(drawable, null, null, null);
        headerViewHolder.mWeekDay.setText(title);
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder
    {

        @Bind(R.id.item_weekday)
        TextView mWeekDay;

        public HeaderViewHolder(View view)
        {

            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder
    {

        @Bind(R.id.item_img)
        ImageView mImageView;

        @Bind(R.id.item_title)
        TextView mTitle;

        @Bind(R.id.card_view)
        CardView mCardView;

        public ItemViewHolder(View view)
        {

            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
