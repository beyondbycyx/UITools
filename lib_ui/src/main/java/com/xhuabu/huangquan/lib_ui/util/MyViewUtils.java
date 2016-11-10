package com.xhuabu.huangquan.lib_ui.util;

import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by huangquan on 16/9/21.
 */
public class MyViewUtils {

    public static void bindText(TextView tv, String text) {

        if (tv == null) {
            return ;
        }

        tv.setVisibility(View.VISIBLE);
        tv.setText(text);

    }

    public static void bindTextWithGone(TextView tv, String text) {

        if (tv == null) {
            return ;
        }

        if (TextUtils.isEmpty(text)) {
            tv.setVisibility(View.GONE);
        }else{
            tv.setVisibility(View.VISIBLE);
            tv.setText(text);
        }
    }

    public static void bindImg(ImageView imageView, String imgUrl) {
        Glide.with(imageView.getContext()).load(imgUrl).into(imageView);
    }

    public static void bindImg(ImageView imageView, String imgUrl, @DrawableRes int errorDrawableId) {
        Glide.with(imageView.getContext()).load(imgUrl).error(errorDrawableId).into(imageView);
    }
}
