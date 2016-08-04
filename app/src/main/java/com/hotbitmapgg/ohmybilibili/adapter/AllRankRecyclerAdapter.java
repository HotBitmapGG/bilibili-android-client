package com.hotbitmapgg.ohmybilibili.adapter;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.model.index.Index;
import com.hotbitmapgg.ohmybilibili.model.video.VideoItemInfo;
import com.hotbitmapgg.ohmybilibili.module.video.VideoDetailsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 全区排行itemAdapter
 */
public class AllRankRecyclerAdapter extends AbsRecyclerViewAdapter
{

    private List<Index.FuckList> indexs = new ArrayList<>();

    private Activity activity;

    private int[] icons = new int[]{
            R.drawable.ic_category_t13, R.drawable.ic_category_t1,
            R.drawable.ic_category_t3, R.drawable.ic_category_t129,
            R.drawable.ic_category_t5, R.drawable.ic_category_t119,
            R.drawable.ic_category_t4, R.drawable.ic_category_t23,
            R.drawable.ic_category_t36, R.drawable.ic_category_t11
    };

    private String[] titles = new String[]{
            "番剧区排行", "动画区排行", "音乐区排行", "舞蹈区排行", "娱乐区排行",
            "鬼畜区排行", "游戏区排行", "电影区排行", "科技区排行", "电视剧区排行"
    };

    public AllRankRecyclerAdapter(RecyclerView recyclerView, List<Index.FuckList> indexs, Activity activity)
    {

        super(recyclerView);
        this.indexs = indexs;
        this.activity = activity;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_all_rank, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, final int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.mTypeImg.setImageResource(icons[position]);
            itemViewHolder.mTypeTv.setText(titles[position]);
            Index.FuckList fuckList = indexs.get(position);
            final List<VideoItemInfo> videoItemInfos = setVideoItemInfos(fuckList);
            itemViewHolder.mItemRecycle.setHasFixedSize(true);
            itemViewHolder.mItemRecycle.setNestedScrollingEnabled(false);
            itemViewHolder.mItemRecycle.setLayoutManager(new GridLayoutManager(getContext(), 2));
            AllRankGridAdapter allRankGridAdapter = new AllRankGridAdapter(itemViewHolder.mItemRecycle, videoItemInfos);
            itemViewHolder.mItemRecycle.setAdapter(allRankGridAdapter);
            allRankGridAdapter.setOnItemClickListener(new OnItemClickListener()
            {

                @Override
                public void onItemClick(int position, ClickableViewHolder holder)
                {

                    VideoDetailsActivity.launch(activity, videoItemInfos.get(position));
                }
            });
        }

        super.onBindViewHolder(holder, position);
    }

    private List<VideoItemInfo> setVideoItemInfos(Index.FuckList fuckList)
    {

        List<VideoItemInfo> videoItemInfos = new ArrayList<>();

        VideoItemInfo item0 = fuckList.item0;
        VideoItemInfo item1 = fuckList.item1;
        VideoItemInfo item2 = fuckList.item2;
        VideoItemInfo item3 = fuckList.item3;
        VideoItemInfo item4 = fuckList.item4;
        VideoItemInfo item5 = fuckList.item5;
        VideoItemInfo item6 = fuckList.item6;
        VideoItemInfo item7 = fuckList.item7;
        VideoItemInfo item8 = fuckList.item8;

        videoItemInfos.add(item0);
        videoItemInfos.add(item1);
        videoItemInfos.add(item2);
        videoItemInfos.add(item3);
        videoItemInfos.add(item4);
        videoItemInfos.add(item5);
        videoItemInfos.add(item6);
        videoItemInfos.add(item7);
        videoItemInfos.add(item8);

        return videoItemInfos;
    }

    @Override
    public int getItemCount()
    {

        return indexs.size();
    }


    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        public RecyclerView mItemRecycle;

        public ImageView mTypeImg;

        public TextView mTypeTv;

        public ItemViewHolder(View itemView)
        {

            super(itemView);
            mItemRecycle = $(R.id.item_list);
            mTypeImg = $(R.id.type_img);
            mTypeTv = $(R.id.type_tv);
        }
    }
}
