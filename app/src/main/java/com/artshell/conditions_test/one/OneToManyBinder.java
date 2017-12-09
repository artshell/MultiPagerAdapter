package com.artshell.conditions_test.one;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.artshell.R;
import com.artshell.multipager.ItemPageBinder;
import com.artshell.multipager.MultiPagerAdapter.PageHolder;

/**
 * @author artshell on 29/10/2017
 */

public class OneToManyBinder extends ItemPageBinder<String, OneToManyBinder.OnePageHolder> {

    @Override
    protected OnePageHolder onCreateViewHolder(LayoutInflater inflater, ViewGroup container, int position) {
        return new OnePageHolder(inflater.inflate(R.layout.item_one_to_many, container, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull OnePageHolder holder, @NonNull String item) {
        holder.mName.setText(item);
    }

    static class OnePageHolder extends PageHolder {
        TextView mName;
        public OnePageHolder(View pageView) {
            super(pageView);
            mName = pageView.findViewById(R.id.tv_page_name);
        }
    }
}
