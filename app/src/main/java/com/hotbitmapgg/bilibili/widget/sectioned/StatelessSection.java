package com.hotbitmapgg.bilibili.widget.sectioned;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by hcc on 16/8/27 11:51
 * 100332338@qq.com
 * <p/>
 * Abstract Section with no States.
 */
public abstract class StatelessSection extends Section {

    /**
     * Create a Section object with loading/failed states but no header and footer
     *
     * @param itemResourceId layout resource for its items
     */
    public StatelessSection(int itemResourceId) {
        super();
        this.itemResourceId = itemResourceId;
    }


    /**
     * Create a Section object with loading/failed states, a custom header but no footer
     *
     * @param headerResourceId layout resource for its header
     * @param itemResourceId   layout resource for its items
     */
    public StatelessSection(int headerResourceId, int itemResourceId) {
        this(itemResourceId);
        this.headerResourceId = headerResourceId;
        this.hasHeader = true;
    }


    /**
     * Create a Section object with loading/failed states, a custom header and footer
     *
     * @param headerResourceId layout resource for its header
     * @param footerResourceId layout resource for its footer
     * @param itemResourceId   layout resource for its items
     */
    public StatelessSection(int headerResourceId, int footerResourceId, int itemResourceId) {
        this(headerResourceId, itemResourceId);
        this.footerResourceId = footerResourceId;
        this.hasFooter = true;
    }


    @Override
    public final void onBindLoadingViewHolder(RecyclerView.ViewHolder holder) {
        super.onBindLoadingViewHolder(holder);
    }


    @Override
    public final RecyclerView.ViewHolder getLoadingViewHolder(View view) {
        return super.getLoadingViewHolder(view);
    }


    @Override
    public final void onBindFailedViewHolder(RecyclerView.ViewHolder holder) {
        super.onBindFailedViewHolder(holder);
    }


    @Override
    public final RecyclerView.ViewHolder getFailedViewHolder(View view) {
        return super.getFailedViewHolder(view);
    }
}
