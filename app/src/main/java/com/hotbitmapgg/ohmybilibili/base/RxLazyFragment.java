package com.hotbitmapgg.ohmybilibili.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.ButterKnife;
import rx.subscriptions.CompositeSubscription;

/**
 * 全区Fragment基类
 *
 * @HotBitmapGG
 */
public abstract class RxLazyFragment extends RxFragment
{

    private View parentView;

    private FragmentActivity activity;

    private LayoutInflater inflater;

    protected CompositeSubscription compositeSubscription;

    public abstract
    @LayoutRes
    int getLayoutResId();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state)
    {

        this.inflater = inflater;
        parentView = inflater.inflate(getLayoutResId(), container, false);
        activity = getSupportActivity();
        return parentView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {

        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        compositeSubscription = new CompositeSubscription();
        finishCreateView(savedInstanceState);
    }

    public abstract void finishCreateView(Bundle state);

    @Override
    public void onResume()
    {

        super.onResume();
    }

    @Override
    public void onDestroyView()
    {

        super.onDestroyView();
        compositeSubscription.unsubscribe();
    }

    @Override
    public void onAttach(Activity activity)
    {

        super.onAttach(activity);
        this.activity = (FragmentActivity) activity;
    }

    @Override
    public void onDetach()
    {

        super.onDetach();
        this.activity = null;
    }

    public FragmentActivity getSupportActivity()
    {

        return (FragmentActivity) super.getActivity();
    }

    public android.app.ActionBar getSupportActionBar()
    {

        return getSupportActivity().getActionBar();
    }

    public Context getApplicationContext()
    {

        return this.activity == null ? (getActivity() == null ? null : getActivity().getApplicationContext()) : this.activity.getApplicationContext();
    }

    protected LayoutInflater getLayoutInflater()
    {

        return inflater;
    }

    protected View getParentView()
    {

        return parentView;
    }

    public <T extends View> T $(int id)
    {

        return (T) parentView.findViewById(id);
    }
}
