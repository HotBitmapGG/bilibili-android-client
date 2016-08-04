package com.hotbitmapgg.ohmybilibili.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.liveholder.LiveBannerViewHolder;
import com.hotbitmapgg.ohmybilibili.adapter.liveholder.LiveEntranceViewHolder;
import com.hotbitmapgg.ohmybilibili.adapter.liveholder.LiveItemViewHolder;
import com.hotbitmapgg.ohmybilibili.adapter.liveholder.LivePartitionViewHolder;
import com.hotbitmapgg.ohmybilibili.model.live.Banner;
import com.hotbitmapgg.ohmybilibili.model.live.Live;
import com.hotbitmapgg.ohmybilibili.model.live.LiveIndex;
import com.hotbitmapgg.ohmybilibili.model.live.PartitionSub;
import com.hotbitmapgg.ohmybilibili.module.video.BiliBiliLivePlayerActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 */
public class LiveFragmentAdapter extends RecyclerView.Adapter
{

    private Context context;

    private LiveIndex liveIndex;

    private int entranceSize;

    private int partitionSize;

    private List<Banner> banner;

    private static final int TYPE_ENTRANCE = 0;     //快速入口

    private static final int TYPE_LIVE_ITEM = 1;    //直播Item

    private static final int TYPE_PARTITION = 2;    //分类Title

    private static final int TYPE_BANNER = 3;       //直播页Banner

    public LiveFragmentAdapter(Context context)
    {

        this.context = context;
    }

    //    private int[] liveSize = new int[];
    private List<Integer> liveSizes = new ArrayList<>();

    private int tempSize;

    public void setLiveIndex(LiveIndex data)
    {

        this.liveIndex = data;
        entranceSize = data.entranceIcons.size();
        partitionSize = data.partitions.size();

        banner = new ArrayList<>();
        banner.clear();
        banner = data.banner;

        liveSizes.clear();
        tempSize = 0;
        for (int i = 0; i < partitionSize; i++)
        {
            liveSizes.add(tempSize);
            tempSize += data.partitions.get(i).lives.size();
//            liveSize[i] = tempSize;
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

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {

        View view;
        switch (viewType)
        {
            case TYPE_ENTRANCE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_live_entrance, null);
                return new LiveEntranceViewHolder(view);
            case TYPE_LIVE_ITEM:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_live_partition, null);
                return new LiveItemViewHolder(view);
            case TYPE_PARTITION:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_live_partition_title, null);
                return new LivePartitionViewHolder(view);
            case TYPE_BANNER:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_live_banner, null);
                return new LiveBannerViewHolder(view);
        }
        return null;
    }

    private PartitionSub partition;

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {

        position -= 1;
        final Live item;
        if (holder instanceof LiveEntranceViewHolder)
        {
            ((LiveEntranceViewHolder) holder).title.setText(liveIndex.entranceIcons.get(position).name);
            Picasso.with(context).load(liveIndex.entranceIcons.get(position).entrance_icon.src).into(((LiveEntranceViewHolder) holder).image);
            //((LiveEntranceViewHolder) holder).image.setUrl(liveIndex.entranceIcons.get(position).entrance_icon.src);
        } else if (holder instanceof LiveItemViewHolder)
        {
            try
            {
                item = liveIndex.partitions.get(partitionCol(position)).lives.get(position - 1 - entranceSize - partitionCol(position) * 5);

            //((LiveItemViewHolder) holder).itemLiveCover.setUrl(item.cover.src);
            Picasso.with(context).load(item.cover.src).placeholder(R.drawable.bili_default_image_tv).into(((LiveItemViewHolder) holder).itemLiveCover);
            ((LiveItemViewHolder) holder).itemLiveTitle.setText(item.title);
            ((LiveItemViewHolder) holder).itemLiveUser.setText(item.owner.name);
            Picasso.with(context).load(item.owner.face).into(((LiveItemViewHolder) holder).itemLiveUserCover);
            //((LiveItemViewHolder) holder).itemLiveUserCover.avatar().setUrl(item.owner.face);
            ((LiveItemViewHolder) holder).itemLiveCount.setText(item.online + "");
            ((LiveItemViewHolder) holder).itemLiveLayout.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View v)
                {

                    Intent intent = new Intent(context, BiliBiliLivePlayerActivity.class);
                    intent.putExtra("cid", item.room_id);
                    intent.putExtra("title", item.title);
                    intent.putExtra("online", item.online);
                    intent.putExtra("face", item.owner.face);
                    intent.putExtra("name", item.owner.name);
                    intent.putExtra("mid", item.owner.mid);
                    context.startActivity(intent);
                }
            });
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        } else if (holder instanceof LivePartitionViewHolder)
        {
            partition = liveIndex.partitions.get(partitionCol(position)).partition;
            Picasso.with(context).load(partition.sub_icon.src).into(((LivePartitionViewHolder) holder).itemIcon);
            //((LivePartitionViewHolder) holder).itemIcon.setUrl(partition.sub_icon.src);
            ((LivePartitionViewHolder) holder).itemTitle.setText(partition.name);
            ((LivePartitionViewHolder) holder).itemCount.setText("当前" + partition.count + "个直播");
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
            return 1 + liveIndex.entranceIcons.size()
                    + liveIndex.partitions.size() * 5;
//                    + tempSize;
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
}
