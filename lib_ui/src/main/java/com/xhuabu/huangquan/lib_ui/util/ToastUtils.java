package com.xhuabu.huangquan.lib_ui.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by huangquan on 16/9/21.
 */
public class ToastUtils {

    public static  void show(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
