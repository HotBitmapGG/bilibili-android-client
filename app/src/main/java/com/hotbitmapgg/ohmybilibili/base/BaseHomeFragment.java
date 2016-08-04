package com.hotbitmapgg.ohmybilibili.base;


import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;

/**
 * 首页展示Fragment基类
 * 添加两个子类实现方法
 *
 * @HotBitmapGG
 */
public abstract class BaseHomeFragment extends RxLazyFragment
{

    public abstract void scrollToTop();

    public abstract boolean canScrollVertically(int direction);
}
