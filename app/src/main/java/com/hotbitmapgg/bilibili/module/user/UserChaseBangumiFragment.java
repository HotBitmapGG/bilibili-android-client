package com.hotbitmapgg.bilibili.module.user;

import static com.hotbitmapgg.bilibili.utils.ConstantUtil.EXTRA_DATA;

import butterknife.BindView;
import com.hotbitmapgg.bilibili.adapter.UserChaseBangumiAdapter;
import com.hotbitmapgg.bilibili.base.RxLazyFragment;
import com.hotbitmapgg.bilibili.entity.user.UserChaseBangumiInfo;
import com.hotbitmapgg.bilibili.utils.ConstantUtil;
import com.hotbitmapgg.bilibili.widget.CustomEmptyView;
import com.hotbitmapgg.ohmybilibili.R;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by hcc on 2016/10/12 18:16
 * 100332338@qq.com
 * <p>
 * 用户详情界面的追番
 */

public class UserChaseBangumiFragment extends RxLazyFragment {

  @BindView(R.id.recycle)
  RecyclerView mRecyclerView;

  @BindView(R.id.empty_view)
  CustomEmptyView mCustomEmptyView;

  private List<UserChaseBangumiInfo.DataBean.ResultBean> userChaseBangumis = new ArrayList<>();

  private UserChaseBangumiInfo userChaseBangumiInfo;


  public static UserChaseBangumiFragment newInstance(UserChaseBangumiInfo userChaseBangumiInfo) {

    UserChaseBangumiFragment mFragment = new UserChaseBangumiFragment();
    Bundle bundle = new Bundle();
    bundle.putParcelable(ConstantUtil.EXTRA_DATA, userChaseBangumiInfo);
    mFragment.setArguments(bundle);
    return mFragment;
  }


  @Override
  public int getLayoutResId() {

    return R.layout.fragment_user_chase_bangumi;
  }


  @Override
  public void finishCreateView(Bundle state) {

    userChaseBangumiInfo = getArguments().getParcelable(EXTRA_DATA);
    initRecyclerView();
  }


  @Override
  protected void initRecyclerView() {

    userChaseBangumis.addAll(userChaseBangumiInfo.getData().getResult());
    mRecyclerView.setHasFixedSize(true);
    mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
    UserChaseBangumiAdapter mAdapter = new UserChaseBangumiAdapter(mRecyclerView,
        userChaseBangumis);
    mRecyclerView.setAdapter(mAdapter);
    mAdapter.setOnItemClickListener((position, holder) -> {

    });
    if (userChaseBangumis.isEmpty()) {
      initEmptyLayout();
    }
  }


  private void initEmptyLayout() {

    mCustomEmptyView.setEmptyImage(R.drawable.img_tips_error_space_no_data);
    mCustomEmptyView.setEmptyText("ㄟ( ▔, ▔ )ㄏ 再怎么找也没有啦");
  }
}
