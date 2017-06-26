package com.hotbitmapgg.bilibili.adapter.section;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hotbitmapgg.bilibili.adapter.RegionRecommendTypesAdapter;
import com.hotbitmapgg.bilibili.rx.RxBus;
import com.hotbitmapgg.bilibili.widget.sectioned.StatelessSection;
import com.hotbitmapgg.ohmybilibili.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hcc on 2016/10/21 21:15
 * 100332338@qq.com
 * <p>
 * 分区推荐分类section
 */

public class RegionRecommendTypesSection extends StatelessSection {
    private Context mContext;
    private int rid;
    //番剧类型Icons
    private int[] bangumiIcons = new int[]{
            R.drawable.ic_category_t33, R.drawable.ic_category_t32,
            R.drawable.ic_category_t153, R.drawable.ic_category_t51, R.drawable.ic_category_t152
    };
    //番剧类型titles
    private String[] bangumiTitles = new String[]{"连载动画", "完结动画", "国产动画", "资讯", "官方延伸"};
    //动画类型Icons
    private int[] animationIcons = new int[]{
            R.drawable.ic_category_t24, R.drawable.ic_category_t25,
            R.drawable.ic_category_t47, R.drawable.ic_category_t27
    };
    //动画类型titles
    private String[] animationTitles = new String[]{"MAD·AMV", "MMD·3D", "短片·手书·配音", "综合"};
    //音乐类型Icons
    private int[] musicIcons = new int[]{
            R.drawable.ic_category_t31, R.drawable.ic_category_t30,
            R.drawable.ic_category_t59, R.drawable.ic_category_t54,
            R.drawable.ic_category_t28, R.drawable.ic_category_t29,
            R.drawable.ic_category_t130
    };
    //音乐类型titles
    private String[] musicTitles = new String[]{"翻唱", "VOCALOID·UTAU", "演奏", "OP/ED/OST", "原创音乐",
            "三次元音乐", "音乐选集"};
    //舞蹈类型Icons
    private int[] danceIcons = new int[]{
            R.drawable.ic_category_t20, R.drawable.ic_category_t154, R.drawable.ic_category_t156
    };
    //舞蹈类型titles
    private String[] danceTitles = new String[]{"宅舞", "三次元舞蹈", "舞蹈教程"};
    //游戏类型Icons
    private int[] gameIcons = new int[]{
            R.drawable.ic_category_t17, R.drawable.ic_category_t65,
            R.drawable.ic_category_t136, R.drawable.ic_category_t19,
            R.drawable.ic_category_t121, R.drawable.ic_category_game_center2
    };
    //游戏类型titles
    private String[] gameTitles = new String[]{"单机联机", "网游·电竞", "音游", "MUGEN", "GMV", "游戏中心"};
    //科技类型Icons
    private int[] scienceIcons = new int[]{
            R.drawable.ic_category_t37, R.drawable.ic_category_t124,
            R.drawable.ic_category_t122, R.drawable.ic_category_t96,
            R.drawable.ic_category_t95, R.drawable.ic_category_t98
    };
    //科技类型titles
    private String[] scienceTitles = new String[]{"纪录片", "趣味科普人文", "野生技术协会",
            "演讲·公开课", "星海", "数码", "机械"};
    //生活类型Icons
    private int[] lifeIcons = new int[]{
            R.drawable.ic_category_t138, R.drawable.ic_category_t21,
            R.drawable.ic_category_t76, R.drawable.ic_category_t75,
            R.drawable.ic_category_t161, R.drawable.ic_category_t162,
            R.drawable.ic_category_t163
    };
    //生活类型titles
    private String[] lifeTitles = new String[]{"搞笑", "日常", "美食圈", "动物圈", "手工", "绘画", "运动"};
    //鬼畜类型Icons
    private int[] kichikuIcons = new int[]{
            R.drawable.ic_category_t22, R.drawable.ic_category_t26,
            R.drawable.ic_category_t126, R.drawable.ic_category_t127
    };
    //鬼畜类型titles
    private String[] kichikuTitles = new String[]{"鬼畜调教", "音MAD", "人力VOCALOID", "教程演示"};
    //时尚类型Icons
    private int[] fashionIcons = new int[]{
            R.drawable.ic_category_t157, R.drawable.ic_category_t158,
            R.drawable.ic_category_t159, R.drawable.ic_category_t164
    };
    //时尚类型titles
    private String[] fashionTitles = new String[]{"美妆", "服饰", "资讯", "健身"};
    //娱乐类型Icons
    private int[] entertainmentIcons = new int[]{
            R.drawable.ic_category_t71, R.drawable.ic_category_t137, R.drawable.ic_category_t131
    };
    //娱乐类型titles
    private String[] entertainmentTitles = new String[]{"综艺", "明星", "KOREA相关"};
    //电影类型Icons
    private int[] movieIcons = new int[]{
            R.drawable.ic_category_t82, R.drawable.ic_category_t85,
            R.drawable.ic_category_t145, R.drawable.ic_category_t146,
            R.drawable.ic_category_t147, R.drawable.ic_category_t83
    };
    //电影类型titles
    private String[] movieTitles = new String[]{"电影相关", "短片", "欧美电影", "日本电影", "国产电影", "其他国家"};
    //电视剧类型Icons
    private int[] tvIcons = new int[]{
            R.drawable.ic_category_t15, R.drawable.ic_category_t34,
            R.drawable.ic_category_t86, R.drawable.ic_category_t128
    };
    //电视剧类型titles
    private String[] tvTitles = new String[]{"连载剧集", "完结剧集", "特辑·布袋戏", "电视剧相关"};

    public RegionRecommendTypesSection(Context context, int rid) {
        super(R.layout.layout_region_recommend_types, R.layout.layout_home_recommend_empty);
        this.mContext = context;
        this.rid = rid;
    }


    @Override
    public int getContentItemsTotal() {
        return 1;
    }


    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new RegionRecommendTypesSection.EmptyViewHolder(view);
    }


    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
    }


    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new RegionRecommendTypesSection.TypesViewHolder(view);
    }


    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        TypesViewHolder typesViewHolder = (TypesViewHolder) holder;
        typesViewHolder.mRecyclerView.setHasFixedSize(false);
        typesViewHolder.mRecyclerView.setNestedScrollingEnabled(false);
        setRecyclerAdapter(typesViewHolder);
    }


    private void setRecyclerAdapter(TypesViewHolder typesViewHolder) {
        RegionRecommendTypesAdapter mAdapter = null;
        switch (rid) {
            case 13:
                //番剧
                typesViewHolder.mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
                mAdapter = new RegionRecommendTypesAdapter(typesViewHolder.mRecyclerView, bangumiIcons, bangumiTitles);
                break;
            case 1:
                //动画
                typesViewHolder.mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
                mAdapter = new RegionRecommendTypesAdapter(typesViewHolder.mRecyclerView, animationIcons, animationTitles);
                break;
            case 3:
                //音乐
                typesViewHolder.mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
                mAdapter = new RegionRecommendTypesAdapter(typesViewHolder.mRecyclerView, musicIcons, musicTitles);
                break;
            case 129:
                //舞蹈
                typesViewHolder.mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
                mAdapter = new RegionRecommendTypesAdapter(typesViewHolder.mRecyclerView, danceIcons,
                        danceTitles);
                break;
            case 4:
                //游戏
                typesViewHolder.mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
                mAdapter = new RegionRecommendTypesAdapter(typesViewHolder.mRecyclerView, gameIcons, gameTitles);
                break;
            case 36:
                //科技
                typesViewHolder.mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
                mAdapter = new RegionRecommendTypesAdapter(typesViewHolder.mRecyclerView, scienceIcons, scienceTitles);
                break;
            case 160:
                //生活
                typesViewHolder.mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
                mAdapter = new RegionRecommendTypesAdapter(typesViewHolder.mRecyclerView, lifeIcons, lifeTitles);
                break;
            case 119:
                //鬼畜
                typesViewHolder.mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
                mAdapter = new RegionRecommendTypesAdapter(typesViewHolder.mRecyclerView, kichikuIcons, kichikuTitles);
                break;
            case 155:
                //时尚
                typesViewHolder.mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
                mAdapter = new RegionRecommendTypesAdapter(typesViewHolder.mRecyclerView, fashionIcons, fashionTitles);
                break;
            case 5:
                //娱乐
                typesViewHolder.mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
                mAdapter = new RegionRecommendTypesAdapter(typesViewHolder.mRecyclerView, entertainmentIcons, entertainmentTitles);
                break;
            case 23:
                //电影
                typesViewHolder.mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
                mAdapter = new RegionRecommendTypesAdapter(typesViewHolder.mRecyclerView, movieIcons, movieTitles);
                break;
            case 11:
                //电视剧
                typesViewHolder.mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
                mAdapter = new RegionRecommendTypesAdapter(typesViewHolder.mRecyclerView, tvIcons, tvTitles);
                break;
        }
        typesViewHolder.mRecyclerView.setAdapter(mAdapter);
        assert mAdapter != null;
        mAdapter.setOnItemClickListener((position, holder) -> RxBus.getInstance().post(position));
    }


    static class TypesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.types_recycler)
        RecyclerView mRecyclerView;

        TypesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class EmptyViewHolder extends RecyclerView.ViewHolder {
        EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
