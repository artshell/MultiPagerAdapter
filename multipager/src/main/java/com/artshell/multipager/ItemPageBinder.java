package com.artshell.multipager;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.artshell.multipager.MultiPagerAdapter.PageHolder;

/**
 * @author artshell on 28/10/2017
 */

public abstract class ItemPageBinder<T, VH extends PageHolder> {

    protected abstract VH onCreateViewHolder(LayoutInflater inflater, ViewGroup container, int position);

    protected abstract void onBindViewHolder(@NonNull VH holder, @NonNull T item);

}
