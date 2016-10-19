package com.hotbitmapgg.ohmybilibili.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.entity.live.Live;
import com.hotbitmapgg.ohmybilibili.entity.live.LiveIndex;
import com.hotbitmapgg.ohmybilibili.entity.live.PartitionSub;
import com.hotbitmapgg.ohmybilibili.module.home.live.LivePlayerActivity;
import com.hotbitmapgg.ohmybilibili.widget.CircleImageView;
import com.hotbitmapgg.ohmybilibili.widget.banner.BannerEntity;
import com.hotbitmapgg.ohmybilibili.widget.banner.BannerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * B站直播Adapter
 */
public class LiveRecyclerAdapter extends RecyclerView.Adapter
{

    private Context context;

    private LiveIndex liveIndex;

    private int entranceSize;

    private List<BannerEntity> banner;

    private List<Integer> liveSizes = new ArrayList<>();

    //直播分类入口
    private static final int TYPE_ENTRANCE = 0;

    //直播Item
    private static final int TYPE_LIVE_ITEM = 1;

    //直播分类Title
    private static final int TYPE_PARTITION = 2;

    //直播页Banner
    private static final int TYPE_BANNER = 3;

    private int[] entranceIconRes = new int[]{
            R.drawable.live_home_follow_anchor,
            R.drawable.live_home_live_center,
            R.drawable.live_home_search_room,
            R.drawable.live_home_all_category
    };

    private String[] entranceTitles = new String[]{
            "关注主播",
            "直播中心",
            "搜索直播",
            "全部分类"
    };

    public LiveRecyclerAdapter(Context context)
    {

        this.context = context;
    }

    public void setLiveIndex(LiveIndex data)
    {

        this.liveIndex = data;
        entranceSize = 4;
        int partitionSize = data.partitions.size();

        banner = new ArrayList<>();
        banner.clear();
        banner = data.banner;

        liveSizes.clear();
        int tempSize = 0;
        for (int i = 0; i < partitionSize; i++)
        {
            liveSizes.add(tempSize);
            tempSize += data.partitions.get(i).lives.size();
        }
    }

    public int getSpanSize(int pos)
    {

        int viewType = getItemViewType(pos);
        switch (viewType)
        {
            case TYPE_ENTRANCE:
                return 3;
            case TYPE_LIVE_ITEM:
                return 6;
            case TYPE_PARTITION:
                return 12;
            case TYPE_BANNER:
                return 12;
        }
        return 0;
    }

    @SuppressLint("InflateParams")
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {

        View view;
        switch (viewType)
        {
            case TYPE_ENTRANCE:
                view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_live_entrance, null);
                return new LiveEntranceViewHolder(view);
            case TYPE_LIVE_ITEM:
                view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_live_partition, null);
                return new LiveItemViewHolder(view);
            case TYPE_PARTITION:
                view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_live_partition_title, null);
                return new LivePartitionViewHolder(view);
            case TYPE_BANNER:
                view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_live_banner, null);
                return new LiveBannerViewHolder(view);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {

        position -= 1;
        final Live item;
        if (holder instanceof LiveEntranceViewHolder)
        {
            ((LiveEntranceViewHolder) holder).title.setText(entranceTitles[position]);

            Glide.with(context)
                    .load(entranceIconRes[position])
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(((LiveEntranceViewHolder) holder).image);
        } else if (holder instanceof LiveItemViewHolder)
        {
            try
            {
                item = liveIndex.partitions.get(partitionCol(position))
                        .lives.get(position - 1 - entranceSize - partitionCol(position) * 5);

                Glide.with(context)
                        .load(item.cover.src)
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.bili_default_image_tv)
                        .dontAnimate()
                        .into(((LiveItemViewHolder) holder).itemLiveCover);

                ((LiveItemViewHolder) holder).itemLiveTitle.setText(item.title);
                ((LiveItemViewHolder) holder).itemLiveUser.setText(item.owner.name);

                Glide.with(context)
                        .load(item.owner.face)
                        .centerCrop()
                        .dontAnimate()
                        .placeholder(R.drawable.ico_user_default)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(((LiveItemViewHolder) holder).itemLiveUserCover);


                ((LiveItemViewHolder) holder).itemLiveCount.setText(String.valueOf(item.online));
                ((LiveItemViewHolder) holder).itemLiveLayout.setOnClickListener(v -> LivePlayerActivity.
                        launch((Activity) context, item.room_id,
                        item.title, item.online, item.owner.face,
                        item.owner.name, item.owner.mid));
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        } else if (holder instanceof LivePartitionViewHolder)
        {
            PartitionSub partition = liveIndex.partitions.get(partitionCol(position)).partition;

            Glide.with(context)
                    .load(partition.sub_icon.src)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(((LivePartitionViewHolder) holder).itemIcon);

            ((LivePartitionViewHolder) holder).itemTitle.setText(partition.name);
            SpannableStringBuilder stringBuilder = new SpannableStringBuilder("当前" + partition.count + "个直播");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(
                    context.getResources().getColor(R.color.pink_text_color));

            stringBuilder.setSpan(foregroundColorSpan, 2,
                    stringBuilder.length() - 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            ((LivePartitionViewHolder) holder).itemCount.setText(stringBuilder);
        } else if (holder instanceof LiveBannerViewHolder)
        {
            ((LiveBannerViewHolder) holder).banner.delayTime(5).build(banner);
        }
    }

    @Override
    public int getItemCount()
    {

        if (liveIndex != null)
        {
            return 1 + entranceIconRes.length
                    + liveIndex.partitions.size() * 5;
        } else
        {
            return 0;
        }
    }

    @Override
    public int getItemViewType(int position)
    {

        if (position == 0)
        {
            return TYPE_BANNER;
        }
        position -= 1;
        if (position < entranceSize)
        {
            return TYPE_ENTRANCE;
        } else if (ifPartitionTitle(position))
        {
            return TYPE_PARTITION;
        } else
        {
            return TYPE_LIVE_ITEM;
        }
    }

    /**
     * 获取当前Item在第几组中
     */
    private int partitionCol(int pos)
    {

        pos -= entranceSize;
        return pos / 5;
    }

    private boolean ifPartitionTitle(int pos)
    {

        pos -= entranceSize;
        return (pos % 5 == 0);
    }


    /**
     * 直播界面Banner ViewHolder
     */
    static class LiveBannerViewHolder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.item_live_banner)
        public BannerView banner;

        LiveBannerViewHolder(View itemView)
        {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * 直播界面Item分类 ViewHolder
     */
    static class LiveEntranceViewHolder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.live_entrance_title)
        public TextView title;

        @BindView(R.id.live_entrance_image)
        public ImageView image;

        LiveEntranceViewHolder(View itemView)
        {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * 直播界面Grid Item ViewHolder
     */
    static class LiveItemViewHolder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.item_live_cover)
        ImageView itemLiveCover;

        @BindView(R.id.item_live_user)
        TextView itemLiveUser;

        @BindView(R.id.item_live_title)
        TextView itemLiveTitle;

        @BindView(R.id.item_live_user_cover)
        CircleImageView itemLiveUserCover;

        @BindView(R.id.item_live_count)
        TextView itemLiveCount;

        @BindView(R.id.item_live_layout)
        CardView itemLiveLayout;

        LiveItemViewHolder(View itemView)
        {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * 直播界面分区类型 ViewHolder
     */
    static class LivePartitionViewHolder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.item_live_partition_icon)
        ImageView itemIcon;

        @BindView(R.id.item_live_partition_title)
        TextView itemTitle;

        @BindView(R.id.item_live_partition_count)
        TextView itemCount;

        LivePartitionViewHolder(View itemView)
        {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
