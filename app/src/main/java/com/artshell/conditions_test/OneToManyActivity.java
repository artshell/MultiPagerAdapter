package com.artshell.conditions_test;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.artshell.R;
import com.artshell.conditions_test.one.OneToManyBinder;
import com.artshell.multipager.MultiPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class OneToManyActivity extends AppCompatActivity {
    private static final String TAG = "OneToManyActivity";

    private ViewPager mPager;
    private List<String> mItems = new ArrayList<>();
    private MultiPagerAdapter mAdapter = new MultiPagerAdapter(mItems);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_to_many);
        init();
    }

    private void init() {
        mPager = findViewById(R.id.layout_pager);
        mAdapter.register(String.class, new OneToManyBinder());
        mPager.setAdapter(mAdapter);
    }

    // 常规使用
    public void normal(View v) {
        mItems.clear();
        mItems.add("Page 1");
        mItems.add("Page 2");
        mItems.add("Page 3");
        mItems.add("Page 4");
        mAdapter.notifyDataSetChanged();
    }

    // 改变页面个数
    public void changeCount(View v) {
        mItems.remove(1);
        mAdapter.notifyDataSetChanged();
    }

    // 变化item数据顺序
    public void changeOrder(View v) {
        mItems.clear();
        mItems.add("Page 3");
        mItems.add("Page 1");
        mItems.add("Page 4");
        mItems.add("Page 2");
        mAdapter.notifyDataSetChanged();
    }
}
