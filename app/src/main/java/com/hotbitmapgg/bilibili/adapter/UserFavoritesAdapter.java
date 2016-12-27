package com.hotbitmapgg.bilibili.adapter;

import com.hotbitmapgg.bilibili.adapter.helper.AbsRecyclerViewAdapter;
import com.hotbitmapgg.bilibili.entity.user.UserFavoritesInfo;
import com.hotbitmapgg.bilibili.widget.FavoritesItemLayout;
import com.hotbitmapgg.ohmybilibili.R;
import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hcc on 2016/10/13 16:18
 * 100332338@qq.com
 * <p>
 * 用户收藏夹adapter
 */

public class UserFavoritesAdapter extends AbsRecyclerViewAdapter {

  private List<UserFavoritesInfo.DataBean> userFavorites;


  public UserFavoritesAdapter(RecyclerView recyclerView, List<UserFavoritesInfo.DataBean> userFavorites) {

    super(recyclerView);
    this.userFavorites = userFavorites;
  }


  @Override
  public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    bindContext(parent.getContext());
    return new ItemViewHolder(
        LayoutInflater.from(getContext()).inflate(R.layout.item_user_favorites, parent, false));
  }


  @Override
  public void onBindViewHolder(ClickableViewHolder holder, int position) {

    if (holder instanceof ItemViewHolder) {
      ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
      UserFavoritesInfo.DataBean dataBean = userFavorites.get(position);

      itemViewHolder.mFavoritesCount.setText(String.valueOf(dataBean.getCur_count()));
      itemViewHolder.mTitle.setText(dataBean.getName());
      itemViewHolder.mFavoritesItemLayout.setImages(dataBean.getVideos());
    }
    super.onBindViewHolder(holder, position);
  }


  @Override
  public int getItemCount() {

    return userFavorites.size();
  }


  private class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder {

    FavoritesItemLayout mFavoritesItemLayout;

    TextView mFavoritesCount;

    TextView mTitle;


    public ItemViewHolder(View itemView) {

      super(itemView);
      mFavoritesItemLayout = $(R.id.item_favorites);
      mFavoritesCount = $(R.id.item_favorites_count);
      mTitle = $(R.id.item_title);
    }
  }
}
