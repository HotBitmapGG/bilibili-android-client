package com.hotbitmapgg.bilibili.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.bilibili.adapter.helper.AbsRecyclerViewAdapter;
import com.hotbitmapgg.bilibili.entity.bangumi.BangumiDetailsCommentInfo;
import com.hotbitmapgg.bilibili.utils.DateUtil;
import com.hotbitmapgg.bilibili.widget.CircleImageView;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.List;

/**
 * Created by hcc on 16/11/2 14:12
 * 100332338@qq.com
 * <p/>
 * 番剧详情番剧评论adapter
 */
public class BangumiDetailsCommentAdapter extends AbsRecyclerViewAdapter {
    private List<BangumiDetailsCommentInfo.DataBean.RepliesBean> replies;

    public BangumiDetailsCommentAdapter(RecyclerView recyclerView, List<BangumiDetailsCommentInfo.DataBean.RepliesBean> replies) {
        super(recyclerView);
        this.replies = replies;
    }


    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).
                inflate(R.layout.item_video_comment, parent, false));
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder mHolder = (ItemViewHolder) holder;
            BangumiDetailsCommentInfo.DataBean.RepliesBean repliesBean = replies.get(position);
            mHolder.mUserName.setText(repliesBean.getMember().getUname());

            Glide.with(getContext())
                    .load(repliesBean.getMember().getAvatar())
                    .centerCrop()
                    .dontAnimate()
                    .placeholder(R.drawable.ico_user_default)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(mHolder.mUserAvatar);

            int currentLevel = repliesBean.getMember().getLevel_info().getCurrent_level();
            checkLevel(currentLevel, mHolder);

            switch (repliesBean.getMember().getSex()) {
                case "女":
                    mHolder.mUserSex.setImageResource(R.drawable.ic_user_female);
                    break;
                case "男":
                    mHolder.mUserSex.setImageResource(R.drawable.ic_user_male);
                    break;
                default:
                    mHolder.mUserSex.setImageResource(R.drawable.ic_user_gay_border);
                    break;
            }

            mHolder.mCommentNum.setText(String.valueOf(repliesBean.getCount()));
            mHolder.mSpot.setText(String.valueOf(repliesBean.getLike()));
            String time = DateUtil.longToString(repliesBean.getCtime(), DateUtil.FORMAT_DATE_TIME);
            mHolder.mCommentTime.setText(time);
            mHolder.mContent.setText(repliesBean.getContent().getMessage());
            mHolder.mFloor.setText("#" + repliesBean.getFloor());
        }

        super.onBindViewHolder(holder, position);
    }


    private void checkLevel(int currentLevel, ItemViewHolder mHolder) {
        if (currentLevel == 0) {
            mHolder.mUserLv.setImageResource(R.drawable.ic_lv0);
        } else if (currentLevel == 1) {
            mHolder.mUserLv.setImageResource(R.drawable.ic_lv1);
        } else if (currentLevel == 2) {
            mHolder.mUserLv.setImageResource(R.drawable.ic_lv2);
        } else if (currentLevel == 3) {
            mHolder.mUserLv.setImageResource(R.drawable.ic_lv3);
        } else if (currentLevel == 4) {
            mHolder.mUserLv.setImageResource(R.drawable.ic_lv4);
        } else if (currentLevel == 5) {
            mHolder.mUserLv.setImageResource(R.drawable.ic_lv5);
        } else if (currentLevel == 6) {
            mHolder.mUserLv.setImageResource(R.drawable.ic_lv6);
        }
    }


    @Override
    public int getItemCount() {
        return replies.size();
    }


    public class ItemViewHolder extends ClickableViewHolder {

        CircleImageView mUserAvatar;
        TextView mUserName;
        ImageView mUserLv;
        ImageView mUserSex;
        TextView mFloor;
        TextView mCommentTime;
        TextView mCommentNum;
        TextView mSpot;
        TextView mContent;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mUserAvatar = $(R.id.item_user_avatar);
            mUserName = $(R.id.item_user_name);
            mUserLv = $(R.id.item_user_lever);
            mUserSex = $(R.id.item_user_sex);
            mFloor = $(R.id.item_comment_floor);
            mCommentTime = $(R.id.item_comment_time);
            mCommentNum = $(R.id.item_comment_num);
            mSpot = $(R.id.item_comment_spot);
            mContent = $(R.id.item_comment_content);
        }
    }
}
