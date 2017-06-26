package com.hotbitmapgg.bilibili.adapter.section;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.bilibili.entity.bangumi.BangumiScheduleInfo;
import com.hotbitmapgg.bilibili.utils.ConstantUtil;
import com.hotbitmapgg.bilibili.utils.DateUtil;
import com.hotbitmapgg.bilibili.utils.WeekDayUtil;
import com.hotbitmapgg.bilibili.widget.sectioned.StatelessSection;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hcc on 16/8/25 20:52
 * 100332338@qq.com
 * <p/>
 * 番剧放送表section
 */
public class BangumiScheduleSection extends StatelessSection {
    private Context mContext;
    private String weekDay;
    private String date;
    private List<BangumiScheduleInfo.ResultBean> bangumiSchedules;

    public BangumiScheduleSection(Context context, List<BangumiScheduleInfo.ResultBean> bangumiSchedules, String weekDay, String date) {
        super(R.layout.layout_bangumi_schedule_head, R.layout.layout_bangumi_schedule_boby);
        this.mContext = context;
        this.weekDay = weekDay;
        this.date = date;
        this.bangumiSchedules = bangumiSchedules;
    }


    @Override
    public int getContentItemsTotal() {
        return bangumiSchedules.size();
    }


    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemViewHolder(view);
    }


    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        BangumiScheduleInfo.ResultBean resultBean = bangumiSchedules.get(position);
        Glide.with(mContext)
                .load(resultBean.getCover())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into(itemViewHolder.mImageView);

        itemViewHolder.mTitle.setText(resultBean.getTitle());
        itemViewHolder.mUpdate.setText("第" + resultBean.getEp_index() + "话");
        itemViewHolder.mTimeLine.setText(resultBean.getOntime());
    }


    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeaderViewHolder(view);
    }


    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
        setWeekDay(headerViewHolder);
    }


    private void setWeekDay(HeaderViewHolder headerViewHolder) {
        switch (weekDay) {
            case ConstantUtil.SUNDAY_TYPE:
                setWeekDayIconAndTitle(headerViewHolder, R.drawable.bangumi_timeline_weekday_7, "周日");
                break;
            case ConstantUtil.MONDAY_TYPE:
                setWeekDayIconAndTitle(headerViewHolder, R.drawable.bangumi_timeline_weekday_1, "周一");
                break;
            case ConstantUtil.TUESDAY_TYPE:
                setWeekDayIconAndTitle(headerViewHolder, R.drawable.bangumi_timeline_weekday_2, "周二");
                break;
            case ConstantUtil.WEDNESDAY_TYPE:
                setWeekDayIconAndTitle(headerViewHolder, R.drawable.bangumi_timeline_weekday_3, "周三");
                break;
            case ConstantUtil.THURSDAY_TYPE:
                setWeekDayIconAndTitle(headerViewHolder, R.drawable.bangumi_timeline_weekday_4, "周四");
                break;
            case ConstantUtil.FRIDAY_TYEP:
                setWeekDayIconAndTitle(headerViewHolder, R.drawable.bangumi_timeline_weekday_5, "周五");
                break;
            case ConstantUtil.SATURDAY_TYPE:
                setWeekDayIconAndTitle(headerViewHolder, R.drawable.bangumi_timeline_weekday_6, "周六");
                break;
        }
    }


    private void setWeekDayIconAndTitle(HeaderViewHolder headerViewHolder, int iconRes, String title) {
        if (date.equals(WeekDayUtil.formatDate(DateUtil.getCurrentTime("yyyy-MM-dd")))) {
            headerViewHolder.mUpdateTime.setText("今天");
            headerViewHolder.mUpdateTime.setTextColor(
                    mContext.getResources().getColor(R.color.colorPrimary));
            headerViewHolder.mWeekDayText.setTextColor(
                    mContext.getResources().getColor(R.color.colorPrimary));
            headerViewHolder.mWeekDayIcon.setImageTintList(
                    ColorStateList.valueOf(mContext.getResources().getColor(R.color.colorPrimary)));
        } else {
            headerViewHolder.mUpdateTime.setText(date);
            headerViewHolder.mUpdateTime.setTextColor(
                    mContext.getResources().getColor(R.color.black_alpha_30));
            headerViewHolder.mWeekDayText.setTextColor(mContext.getResources().getColor(R.color.gray_80));
            headerViewHolder.mWeekDayIcon.setImageTintList(
                    ColorStateList.valueOf(mContext.getResources().getColor(R.color.gray_80)));
        }
        headerViewHolder.mWeekDayIcon.setImageResource(iconRes);
        headerViewHolder.mWeekDayText.setText(title);
    }


    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_weekday_text)
        TextView mWeekDayText;
        @BindView(R.id.item_weekday_icon)
        ImageView mWeekDayIcon;
        @BindView(R.id.item_update_time)
        TextView mUpdateTime;

        HeaderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_img)
        ImageView mImageView;
        @BindView(R.id.item_title)
        TextView mTitle;
        @BindView(R.id.item_update)
        TextView mUpdate;
        @BindView(R.id.item_time_line)
        TextView mTimeLine;

        public ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
