package com.hotbitmapgg.ohmybilibili.adapter.base;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * RecycleViewAdapter基类
 */
public abstract class AbsRecyclerViewAdapter extends
        RecyclerView.Adapter<AbsRecyclerViewAdapter.ClickableViewHolder>
{

    private Context context;

    protected RecyclerView mRecyclerView;

    protected List<RecyclerView.OnScrollListener> mListeners = new ArrayList<RecyclerView.OnScrollListener>();

    public AbsRecyclerViewAdapter(RecyclerView recyclerView)
    {

        this.mRecyclerView = recyclerView;
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
        {

            @Override
            public void onScrollStateChanged(RecyclerView rv, int newState)
            {

                for (RecyclerView.OnScrollListener listener : mListeners)
                {
                    listener.onScrollStateChanged(rv, newState);
                }
            }

            @Override
            public void onScrolled(RecyclerView rv, int dx, int dy)
            {

                for (RecyclerView.OnScrollListener listener : mListeners)
                {
                    listener.onScrolled(rv, dx, dy);
                }
            }
        });
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener listener)
    {

        mListeners.add(listener);
    }

    public interface OnItemClickListener
    {

        public void onItemClick(int position, ClickableViewHolder holder);
    }

    public interface OnItemLongClickListener
    {

        public boolean onItemLongClick(int position, ClickableViewHolder holder);
    }

    private OnItemClickListener itemClickListener;

    private OnItemLongClickListener itemLongClickListener;

    public void setOnItemClickListener(OnItemClickListener listener)
    {

        this.itemClickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener)
    {

        this.itemLongClickListener = listener;
    }

    public void bindContext(Context context)
    {

        this.context = context;
    }

    public Context getContext()
    {

        return this.context;
    }

    @Override
    public void onBindViewHolder(final ClickableViewHolder holder, final int position)
    {

        holder.getParentView().setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                if (itemClickListener != null)
                {
                    itemClickListener.onItemClick(position, holder);
                }
            }
        });
        holder.getParentView().setOnLongClickListener(new View.OnLongClickListener()
        {

            @Override
            public boolean onLongClick(View v)
            {

                if (itemLongClickListener != null)
                {
                    return itemLongClickListener.onItemLongClick(position, holder);
                } else
                {
                    return false;
                }
            }
        });
    }

    public class ClickableViewHolder extends RecyclerView.ViewHolder
    {

        private View parentView;

        public ClickableViewHolder(View itemView)
        {

            super(itemView);
            this.parentView = itemView;
        }

        public View getParentView()
        {

            return parentView;
        }

        public <T extends View> T $(@IdRes int id)
        {

            return (T) parentView.findViewById(id);
        }
    }
}