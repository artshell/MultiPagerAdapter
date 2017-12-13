/*
 * Copyright 2017 artshell. https://github.com/artshell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.artshell.multipager;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artshell.multipager.utils.Numbers;
import com.artshell.multipager.utils.Objects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author artshell on 27/10/2017
 * @see PagerAdapter
 */
public class MultiPagerAdapter extends PagerAdapter {

    private List<?> items;
    private List<CharSequence> titles;
    private Map<Class<?>, ItemPageBinder<?, ?>> mapper = new HashMap<>();

    public MultiPagerAdapter() {}

    public MultiPagerAdapter(@NonNull List<?> items) {
        this.items = items;
    }

    public MultiPagerAdapter(@NonNull List<?> items, @NonNull List<CharSequence> titles) {
        this.items = items;
        this.titles = titles;
    }

    public void setItems(@NonNull List<?> items) {
        this.items = items;
    }

    public void setTitles(@NonNull List<CharSequence> titles) {
        this.titles = titles;
    }

    public List<?> getItems() {
        return items;
    }

    public List<CharSequence> getTitles() {
        return titles;
    }

    public <T> void register(@NonNull Class<? extends T> clz, @NonNull ItemPageBinder<T, ?> binder) {
        mapper.put(clz, binder);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return items != null ? items.size() : 0;
    }

    /**
     * Create the page for the given position.  The adapter is responsible
     * for adding the view to the container given here, although it only
     * must ensure this is done by the time it returns from
     * {@link #finishUpdate(ViewGroup)}.
     *
     * @param container The containing View in which the page will be shown.
     * @param position The page position to be instantiated.
     * @return Returns an Object representing the new page.  This does not
     * need to be a View, but can be some other container of the page.
     */
    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Object item = items.get(position);
        Class<?> target = item.getClass();

        Numbers.requireNonNegative(mapper.size(), "You should registering ItemPageBinder by register()");
        ItemPageBinder binder = mapper.get(target);
        if (binder == null) {
            for (Class<?> clazz : mapper.keySet()) {
                if (clazz.isAssignableFrom(target)) {
                    binder = mapper.get(clazz);
                    break;
                }
            }
        }

        binder = Objects.requireNonNull(binder, "not found ItemPageBinder");
        PageHolder holder = Objects.requireNonNull(binder.onCreateViewHolder(LayoutInflater.from(container.getContext()), container, position), "binder.onCreateViewHolder() = null");
        holder.setAdapterPosition(position);
        binder.onBindViewHolder(holder, item);

        container.addView(holder.getPageView());

        return holder.getPageView();
    }

    /**
     * Determines whether a page View is associated with a specific key object
     * as returned by {@link #instantiateItem(ViewGroup, int)}. This method is
     * required for a PagerAdapter to function properly.
     *
     * @param view Page View to check for association with <code>object</code>
     * @param object Object to check for association with <code>view</code>
     * @return true if <code>view</code> is associated with the key object <code>object</code>
     */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    /**
     * Remove a page for the given position.  The adapter is responsible
     * for removing the view from its container, although it only must ensure
     * this is done by the time it returns from {@link #finishUpdate(ViewGroup)}.
     *
     * @param container The containing View from which the page will be removed.
     * @param position The page position to be removed.
     * @param object The same object that was returned by
     * {@link #instantiateItem(View, int)}.
     */
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    /**
     * Called when the host view is attempting to determine if an item's position
     * has changed. Returns {@link #POSITION_UNCHANGED} if the position of the given
     * item has not changed or {@link #POSITION_NONE} if the item is no longer present
     * in the adapter.
     * <p>
     * The default implementation assumes that items will never
     * change position and always returns {@link #POSITION_UNCHANGED}.
     * </p>
     * @param object Object representing an item, previously returned by a call to {@link #instantiateItem(View, int)}.
     * @return object's new position index from [0, {@link #getCount()}),
     * {@link #POSITION_UNCHANGED} if the object's position has not changed, or {@link #POSITION_NONE} if the item is no longer present.
     */
    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    /**
     * This method may be called by the ViewPager to obtain a title string
     * to describe the specified page. This method may return null
     * indicating no title for this page. The default implementation returns
     * null.
     *
     * @param position The position of the title requested
     * @return A title for the requested page
     */
    @Override
    public CharSequence getPageTitle(int position) {
        if (titles == null || titles.size() == 0 || items.size() == 0 || titles.size() != items.size()) {
            throw new IllegalStateException("You should apply titles and titles.size() the same with items.size()");
        }
        return titles.get(position);
    }

    /**
     * Returns the proportional width of a given page as a percentage of the
     * ViewPager's measured width from (0.f-1.f]
     *
     * @param position The position of the page requested
     * @return Proportional width for the given page position
     */
    @Override
    public float getPageWidth(int position) {
        return super.getPageWidth(position);
    }

    /**
     * @author artshell on 28/10/2017
     */
    public static abstract class PageHolder {
        private final View pageView;
        private int adapterPosition = -1;

        public PageHolder(@NonNull View pageView) {
            this.pageView = pageView;
        }

        /**
         * @return ViewGroup
         * @see MultiPagerAdapter#instantiateItem(ViewGroup, int)
         */
        public View getPageView() {
            return pageView;
        }

        /**
         * @param position
         * @see MultiPagerAdapter#instantiateItem(ViewGroup, int)
         */
        private void setAdapterPosition(int position) {
            this.adapterPosition = position;
        }

        /**
         * @return adapter position
         */
        public int getAdapterPosition() {
            Numbers.requireNonNegative(adapterPosition, "PageHolder " + this + " not attached to MultiPagerAdapter. " + "You should not call the method before registering the ItemPageBinder.");
            return adapterPosition;
        }
    }
}
