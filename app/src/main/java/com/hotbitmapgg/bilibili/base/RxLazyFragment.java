package com.hotbitmapgg.bilibili.base;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.trello.rxlifecycle.components.support.RxFragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hcc on 16/8/7 21:18
 * 100332338@qq.com
 * <p/>
 * Fragment基类
 */
public abstract class RxLazyFragment extends RxFragment {

  private View parentView;

  private FragmentActivity activity;

  // 标志位 标志已经初始化完成。
  protected boolean isPrepared;

  //标志位 fragment是否可见
  protected boolean isVisible;

  private Unbinder bind;


  public abstract
  @LayoutRes
  int getLayoutResId();


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
    parentView = inflater.inflate(getLayoutResId(), container, false);
    activity = getSupportActivity();
    return parentView;
  }


  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {

    super.onViewCreated(view, savedInstanceState);
    bind = ButterKnife.bind(this, view);
    finishCreateView(savedInstanceState);
  }


  public abstract void finishCreateView(Bundle state);


  @Override
  public void onResume() {

    super.onResume();
  }


  @Override
  public void onDestroyView() {

    super.onDestroyView();
    bind.unbind();
  }


  @Override
  public void onAttach(Activity activity) {

    super.onAttach(activity);
    this.activity = (FragmentActivity) activity;
  }


  @Override
  public void onDetach() {

    super.onDetach();
    this.activity = null;
  }


  public FragmentActivity getSupportActivity() {

    return super.getActivity();
  }


  public android.app.ActionBar getSupportActionBar() {

    return getSupportActivity().getActionBar();
  }


  public Context getApplicationContext() {

    return this.activity == null
           ? (getActivity() == null ? null :
              getActivity().getApplicationContext())
           : this.activity.getApplicationContext();
  }


  /**
   * Fragment数据的懒加载
   */
  @Override
  public void setUserVisibleHint(boolean isVisibleToUser) {

    super.setUserVisibleHint(isVisibleToUser);
    if (getUserVisibleHint()) {
      isVisible = true;
      onVisible();
    } else {
      isVisible = false;
      onInvisible();
    }
  }


  protected void onVisible() {

    lazyLoad();
  }


  protected void lazyLoad() {}


  protected void onInvisible() {}


  protected void loadData() {}


  protected void showProgressBar() {}


  protected void hideProgressBar() {}


  protected void initRecyclerView() {}


  protected void initRefreshLayout() {}


  protected void finishTask() {}


  @SuppressWarnings("unchecked")
  public <T extends View> T $(int id) {

    return (T) parentView.findViewById(id);
  }
}
