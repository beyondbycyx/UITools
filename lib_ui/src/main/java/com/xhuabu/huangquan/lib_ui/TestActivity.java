package com.xhuabu.huangquan.lib_ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.xhuabu.huangquan.lib_ui.holder.BannerHolder;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        String[] strs = {"http://bpic.588ku.com/element_origin_min_pic/00/00/00/005695020616b43.jpg","http://bpic.588ku.com/element_origin_min_pic/16/07/12/165784a7855b0a3.jpg","http://bpic.588ku.com/element_origin_min_pic/00/16/04/15571065a19acde.jpg"};

        BannerHolder holder = new BannerHolder(this, R.layout.item_home_banner);

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(-1, -2);
        addContentView(holder.getHolderView(), params);

    }
}
