package com.hotbitmapgg.bilibili.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.bilibili.adapter.helper.AbsRecyclerViewAdapter;
import com.hotbitmapgg.bilibili.entity.user.UserChaseBangumiInfo;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.List;

/**
 * Created by hcc on 2016/9/28 20:26
 * 100332338@qq.com
 * <p>
 * 关注界面番剧Adapter
 */

public class AttentionBangumiAdapter extends AbsRecyclerViewAdapter {

  private List<UserChaseBangumiInfo.DataBean.ResultBean> chaseBangumis;


  public AttentionBangumiAdapter(RecyclerView recyclerView, List<UserChaseBangumiInfo.DataBean.ResultBean> chaseBangumis) {

    super(recyclerView);
    this.chaseBangumis = chaseBangumis;
  }


  @Override
  public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    bindContext(parent.getContext());
    return new ItemViewHolder(
        LayoutInflater.from(getContext()).inflate(R.layout.item_attention_bangumi, parent, false));
  }


  @Override
  public void onBindViewHolder(ClickableViewHolder holder, int position) {

    if (holder instanceof ItemViewHolder) {
      ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
      UserChaseBangumiInfo.DataBean.ResultBean resultBean = chaseBangumis.get(position);

      Glide.with(getContext())
          .load(resultBean.getCover())
          .centerCrop()
          .diskCacheStrategy(DiskCacheStrategy.ALL)
          .placeholder(R.drawable.bili_default_image_tv)
          .dontAnimate()
          .into(itemViewHolder.mImage);

      itemViewHolder.mTitle.setText(resultBean.getTitle());
      itemViewHolder.mDesc.setText("更新至第" + resultBean.getNewest_ep_index() + "话");
    }

    super.onBindViewHolder(holder, position);
  }


  @Override
  public int getItemCount() {

    return 3;
  }


  private class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder {

    ImageView mImage;

    TextView mTitle;

    TextView mDesc;


    public ItemViewHolder(View itemView) {

      super(itemView);
      mImage = $(R.id.item_img);
      mTitle = $(R.id.item_title);
      mDesc = $(R.id.item_desc);
    }
  }
}
