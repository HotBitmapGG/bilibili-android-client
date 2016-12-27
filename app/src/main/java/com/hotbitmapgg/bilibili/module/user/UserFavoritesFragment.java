package com.hotbitmapgg.bilibili.module.user;

import butterknife.BindView;
import com.hotbitmapgg.bilibili.adapter.UserFavoritesAdapter;
import com.hotbitmapgg.bilibili.base.RxLazyFragment;
import com.hotbitmapgg.bilibili.entity.user.UserFavoritesInfo;
import com.hotbitmapgg.bilibili.utils.ConstantUtil;
import com.hotbitmapgg.bilibili.widget.CustomEmptyView;
import com.hotbitmapgg.ohmybilibili.R;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by hcc on 2016/10/12 18:13
 * 100332338@qq.com
 * <p>
 * 用户详情界面的收藏夹
 */

public class UserFavoritesFragment extends RxLazyFragment {

  @BindView(R.id.recycle)
  RecyclerView mRecyclerView;

  @BindView(R.id.empty_view)
  CustomEmptyView mCustomEmptyView;

  private List<UserFavoritesInfo.DataBean> userFavorites = new ArrayList<>();

  private UserFavoritesInfo userFavoritesInfo;


  public static UserFavoritesFragment newInstance(UserFavoritesInfo userFavoritesInfo) {

    UserFavoritesFragment mFragment = new UserFavoritesFragment();
    Bundle bundle = new Bundle();
    bundle.putParcelable(ConstantUtil.EXTRA_DATA, userFavoritesInfo);
    mFragment.setArguments(bundle);
    return mFragment;
  }


  @Override
  public int getLayoutResId() {

    return R.layout.fragment_user_favorites;
  }


  @Override
  public void finishCreateView(Bundle state) {

    userFavoritesInfo = getArguments().getParcelable(ConstantUtil.EXTRA_DATA);
    initRecyclerView();
  }


  @Override
  protected void initRecyclerView() {

    userFavorites.addAll(userFavoritesInfo.getData());
    mRecyclerView.setHasFixedSize(true);
    mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    UserFavoritesAdapter mAdapter = new UserFavoritesAdapter(mRecyclerView, userFavorites);
    mRecyclerView.setAdapter(mAdapter);
    if (userFavorites.isEmpty()) {
      initEmptyLayout();
    }
  }


  private void initEmptyLayout() {

    mCustomEmptyView.setEmptyImage(R.drawable.img_tips_error_space_no_data);
    mCustomEmptyView.setEmptyText("ㄟ( ▔, ▔ )ㄏ 再怎么找也没有啦");
  }
}
