package com.hotbitmapgg.ohmybilibili.adapter.section;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiSchedule;
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
public class BangumiScheduleSection extends StatelessSection
{


    private Context mContext;

    private int weekDay;

    private List<BangumiSchedule.ResultBean> bangumiSchedules;

    private int[] weekDayIcons = new int[]{
            R.drawable.bangumi_timeline_weekday_7,
            R.drawable.bangumi_timeline_weekday_1,
            R.drawable.bangumi_timeline_weekday_2,
            R.drawable.bangumi_timeline_weekday_3,
            R.drawable.bangumi_timeline_weekday_4,
            R.drawable.bangumi_timeline_weekday_5,
            R.drawable.bangumi_timeline_weekday_6,
            };

    private String[] weekDayTitles = new String[]{
            "周日", "周一", "周二",
            "周三", "周四", "周五", "周六",
            };


    public BangumiScheduleSection(Context context, List<BangumiSchedule.ResultBean> bangumiSchedules, int weekDay)
    {

        super(R.layout.layout_bangumi_schedule_head, R.layout.layout_bangumi_schedule_boby);
        this.mContext = context;
        this.weekDay = weekDay;
        this.bangumiSchedules = bangumiSchedules;
    }

    @Override
    public int getContentItemsTotal()
    {

        return bangumiSchedules.size();
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
        BangumiSchedule.ResultBean resultBean = bangumiSchedules.get(position);
        Glide.with(mContext)
                .load(resultBean.getCover())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into(itemViewHolder.mImageView);

        itemViewHolder.mTitle.setText(resultBean.getTitle());
        itemViewHolder.mUpdate.setText("第" + resultBean.getTotal_count() + "话");
        String substring = resultBean.getLast_time().substring(10, 16);
        itemViewHolder.mTimeLine.setText(substring);
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
        setWeekDay(headerViewHolder);
        headerViewHolder.mUpdateTime.setText("");
    }

    private void setWeekDay(HeaderViewHolder headerViewHolder)
    {

        switch (weekDay)
        {
            case 0:
                //周日
                setWeekDayIconAndTitle(headerViewHolder, weekDayIcons[0], weekDayTitles[0]);
                break;
            case 1:
                //周一
                setWeekDayIconAndTitle(headerViewHolder, weekDayIcons[1], weekDayTitles[1]);
                break;
            case 2:
                //周二
                setWeekDayIconAndTitle(headerViewHolder, weekDayIcons[2], weekDayTitles[2]);
                break;
            case 3:
                //周三
                setWeekDayIconAndTitle(headerViewHolder, weekDayIcons[3], weekDayTitles[3]);
                break;
            case 4:
                //周四
                setWeekDayIconAndTitle(headerViewHolder, weekDayIcons[4], weekDayTitles[4]);
                break;
            case 5:
                //周五
                setWeekDayIconAndTitle(headerViewHolder, weekDayIcons[5], weekDayTitles[5]);
                break;
            case 6:
                //周六
                setWeekDayIconAndTitle(headerViewHolder, weekDayIcons[6], weekDayTitles[6]);
                break;
        }
    }

    private void setWeekDayIconAndTitle(HeaderViewHolder headerViewHolder, int iconRes, String title)
    {

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

        @Bind(R.id.item_update_time)
        TextView mUpdateTime;

        HeaderViewHolder(View view)
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

        @Bind(R.id.item_update)
        TextView mUpdate;

        @Bind(R.id.item_time_line)
        TextView mTimeLine;

        public ItemViewHolder(View view)
        {

            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
