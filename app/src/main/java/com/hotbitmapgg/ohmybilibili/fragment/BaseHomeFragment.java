package com.hotbitmapgg.ohmybilibili.fragment;


import com.hotbitmapgg.ohmybilibili.base.AbsBaseFragment;

/**
 * 首页展示Fragment基类
 * 添加两个子类实现方法
 *
 * @HotBitmapGG
 */
public abstract class BaseHomeFragment extends AbsBaseFragment
{

    public abstract void scrollToTop();

    public abstract boolean canScrollVertically(int direction);
}
