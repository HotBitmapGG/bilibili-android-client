package com.hotbitmapgg.bilibili.widget.sectioned;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by hcc on 16/8/27 11:51
 * 100332338@qq.com
 * <p/>
 * A custom RecyclerView with Sections with custom Titles.
 * Sections are displayed in the same order they were added.
 */
public class SectionedRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final static int VIEW_TYPE_HEADER = 0;
    public final static int VIEW_TYPE_FOOTER = 1;
    public final static int VIEW_TYPE_ITEM_LOADED = 2;
    public final static int VIEW_TYPE_LOADING = 3;
    public final static int VIEW_TYPE_FAILED = 4;
    private LinkedHashMap<String, Section> sections;
    private HashMap<String, Integer> sectionViewTypeNumbers;
    private int viewTypeCount = 0;
    private final static int VIEW_TYPE_QTY = 5;

    public SectionedRecyclerViewAdapter() {
        sections = new LinkedHashMap<>();
        sectionViewTypeNumbers = new HashMap<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View view;
        for (Map.Entry<String, Integer> entry : sectionViewTypeNumbers.entrySet()) {
            if (viewType >= entry.getValue() && viewType < entry.getValue() + VIEW_TYPE_QTY) {
                Section section = sections.get(entry.getKey());
                int sectionViewType = viewType - entry.getValue();
                switch (sectionViewType) {
                    case VIEW_TYPE_HEADER: {
                        Integer resId = section.getHeaderResourceId();
                        if (resId == null) {
                            throw new NullPointerException("Missing 'header' resource id");
                        }
                        view = LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
                        viewHolder = section.getHeaderViewHolder(view);
                        break;
                    }
                    case VIEW_TYPE_FOOTER: {
                        Integer resId = section.getFooterResourceId();
                        if (resId == null) {
                            throw new NullPointerException("Missing 'footer' resource id");
                        }
                        view = LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
                        viewHolder = section.getFooterViewHolder(view);
                        break;
                    }
                    case VIEW_TYPE_ITEM_LOADED: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(section.getItemResourceId(), parent, false);
                        viewHolder = section.getItemViewHolder(view);
                        break;
                    }
                    case VIEW_TYPE_LOADING: {
                        Integer resId = section.getLoadingResourceId();
                        if (resId == null) {
                            throw new NullPointerException("Missing 'loading state' resource id");
                        }
                        view = LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
                        viewHolder = section.getLoadingViewHolder(view);
                        break;
                    }
                    case VIEW_TYPE_FAILED: {
                        Integer resId = section.getFailedResourceId();
                        if (resId == null) {
                            throw new NullPointerException("Missing 'failed state' resource id");
                        }
                        view = LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
                        viewHolder = section.getFailedViewHolder(view);
                        break;
                    }
                    default:
                        throw new IllegalArgumentException("Invalid viewType");
                }
            }
        }
        return viewHolder;
    }


    /**
     * Add a section to this recyclerview.
     *
     * @param tag     unique identifier of the section
     * @param section section to be added
     */
    public void addSection(String tag, Section section) {
        this.sections.put(tag, section);
        this.sectionViewTypeNumbers.put(tag, viewTypeCount);
        viewTypeCount += VIEW_TYPE_QTY;
    }


    /**
     * Add a section to this recyclerview with a random tag;
     *
     * @param section section to be added
     * @return generated tag
     */
    public String addSection(Section section) {
        String tag = UUID.randomUUID().toString();
        addSection(tag, section);
        return tag;
    }


    /**
     * Return the section with the tag provided
     *
     * @param tag unique identifier of the section
     * @return section
     */
    public Section getSection(String tag) {
        return this.sections.get(tag);
    }


    /**
     * Remove section from this recyclerview.
     *
     * @param tag unique identifier of the section
     */
    public void removeSection(String tag) {
        this.sections.remove(tag);
    }


    /**
     * Remove all sections from this recyclerview.
     */
    public void removeAllSections() {
        this.sections.clear();
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int currentPos = 0;
        for (Map.Entry<String, Section> entry : sections.entrySet()) {
            Section section = entry.getValue();
            if (!section.isVisible()) continue;
            int sectionTotal = section.getSectionItemsTotal();
            if (position >= currentPos && position <= (currentPos + sectionTotal - 1)) {
                if (section.hasHeader()) {
                    if (position == currentPos) {
                        getSectionForPosition(position).onBindHeaderViewHolder(holder);
                        return;
                    }
                }
                if (section.hasFooter()) {
                    if (position == (currentPos + sectionTotal - 1)) {
                        getSectionForPosition(position).onBindFooterViewHolder(holder);
                        return;
                    }
                }
                getSectionForPosition(position).onBindContentViewHolder(holder, getSectionPosition(position));
                return;
            }
            currentPos += sectionTotal;
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }


    @Override
    public int getItemCount() {
        int count = 0;
        for (Map.Entry<String, Section> entry : sections.entrySet()) {
            Section section = entry.getValue();
            if (!section.isVisible()) continue;
            count += section.getSectionItemsTotal();
        }
        return count;
    }


    @Override
    public int getItemViewType(int position) {
        int currentPos = 0;
        for (Map.Entry<String, Section> entry : sections.entrySet()) {
            Section section = entry.getValue();
            if (!section.isVisible()) continue;
            int sectionTotal = section.getSectionItemsTotal();
            if (position >= currentPos && position <= (currentPos + sectionTotal - 1)) {
                int viewType = sectionViewTypeNumbers.get(entry.getKey());
                if (section.hasHeader()) {
                    if (position == currentPos) {
                        return viewType;
                    }
                }
                if (section.hasFooter()) {
                    if (position == (currentPos + sectionTotal - 1)) {
                        return viewType + 1;
                    }
                }
                switch (section.getState()) {
                    case LOADED:
                        return viewType + 2;
                    case LOADING:
                        return viewType + 3;
                    case FAILED:
                        return viewType + 4;
                    default:
                        throw new IllegalStateException("Invalid state");
                }
            }
            currentPos += sectionTotal;
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }


    /**
     * Returns the Section ViewType of an item based on the position in the adapter:
     * - SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER
     * - SectionedRecyclerViewAdapter.VIEW_TYPE_FOOTER
     * - SectionedRecyclerViewAdapter.VIEW_TYPE_ITEM_LOADED
     * - SectionedRecyclerViewAdapter.VIEW_TYPE_LOADING
     * - SectionedRecyclerViewAdapter.VIEW_TYPE_FAILED
     *
     * @param position position in the adapter
     * @return SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER, VIEW_TYPE_FOOTER,
     * VIEW_TYPE_ITEM_LOADED, VIEW_TYPE_LOADING or VIEW_TYPE_FAILED
     */
    public int getSectionItemViewType(int position) {
        int viewType = getItemViewType(position);
        return viewType % VIEW_TYPE_QTY;
    }


    /**
     * Returns the Section object for a position in the adapter
     *
     * @param position position in the adapter
     * @return Section object for that position
     */
    public Section getSectionForPosition(int position) {
        int currentPos = 0;
        for (Map.Entry<String, Section> entry : sections.entrySet()) {
            Section section = entry.getValue();
            if (!section.isVisible()) continue;
            int sectionTotal = section.getSectionItemsTotal();
            if (position >= currentPos && position <= (currentPos + sectionTotal - 1)) {
                return section;
            }
            currentPos += sectionTotal;
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }


    /**
     * Return the item position relative to the section.
     *
     * @param position position of the item in the adapter
     * @return position of the item in the section
     */
    public int getSectionPosition(int position) {
        int currentPos = 0;
        for (Map.Entry<String, Section> entry : sections.entrySet()) {
            Section section = entry.getValue();
            if (!section.isVisible()) continue;
            int sectionTotal = section.getSectionItemsTotal();
            if (position >= currentPos && position <= (currentPos + sectionTotal - 1)) {
                return position - currentPos - (section.hasHeader() ? 1 : 0);
            }
            currentPos += sectionTotal;
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }


    /**
     * Return a map with all sections of this adapter
     *
     * @return a map with all sections
     */
    public LinkedHashMap<String, Section> getSectionsMap() {
        return sections;
    }


    /**
     * A concrete class of an empty ViewHolder.
     * Should be used to avoid the boilerplate of creating a ViewHolder class for simple case
     * scenarios.
     */
    public static class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
