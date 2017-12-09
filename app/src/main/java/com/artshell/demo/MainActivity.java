package com.artshell.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.artshell.R;
import com.artshell.conditions_test.ManyToManyActivity;
import com.artshell.conditions_test.OneToManyActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 1对多
    public void oneToMany(View v) {
        startActivity(new Intent(this, OneToManyActivity.class));
    }

    // 多对多
    public void manyToMany(View v) {
        startActivity(new Intent(this, ManyToManyActivity.class));
    }
}
