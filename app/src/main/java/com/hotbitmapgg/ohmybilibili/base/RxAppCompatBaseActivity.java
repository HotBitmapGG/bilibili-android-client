package com.hotbitmapgg.ohmybilibili.base;

import android.os.Bundle;

import com.hotbitmapgg.ohmybilibili.utils.StatusBarCompat;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import rx.subscriptions.CompositeSubscription;

/**
 * 全局Activity基类
 *
 * @HotBitmapGG
 */
public abstract class RxAppCompatBaseActivity extends RxAppCompatActivity
{

    protected CompositeSubscription compositeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        //设置布局内容
        setContentView(getLayoutId());
        //初始化黄油刀控件绑定框架
        ButterKnife.bind(this);
        //初始化全局Rx订阅者
        compositeSubscription = new CompositeSubscription();
        //适配4.4系统状态栏
        StatusBarCompat.compat(this);
        //初始化控件
        initViews(savedInstanceState);
        //初始化ToolBar
        initToolBar();
        //设置全局状态栏颜色
        StatusBarCompat.compat(this);
    }

    @Override
    protected void onDestroy()
    {

        super.onDestroy();
        ButterKnife.unbind(this);
        compositeSubscription.unsubscribe();
    }

    public abstract int getLayoutId();

    public abstract void initViews(Bundle savedInstanceState);

    public abstract void initToolBar();
}
