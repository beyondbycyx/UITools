package com.xhuabu.huangquan.lib_utils;

import android.content.Context;

/**
 * Created by hq on 2015/10/28.
 */
public class DpUtils {

    private static float fontDensity;
    private static float density;


    public static int fontDp2Px(float dp) {

        checkInit();

        return (int) (fontDensity * dp + 0.5f);

    }

    public static int fontPx2Dp(float px) {

        checkInit();
        return (int) (px / fontDensity + 0.5f);
    }

    public static int viewDp2Px(float dp) {
        checkInit();
        return (int) (dp * density + 0.5f);

    }

    public static int viewPx2Dp(float px) {
        checkInit();
        return (int) (px / density + 0.5f);

    }


    public static int fontDp2Px(Context context, float dp) {

        init(context);

        return (int) (fontDensity * dp + 0.5f);

    }

    public static int fontPx2Dp(Context context, float px) {

        init(context);

        return (int) (px / fontDensity + 0.5f);
    }

    public static int viewDp2Px(Context context, float dp) {
        init(context);

        return (int) (dp * density + 0.5f);

    }

    public static int viewPx2Dp(Context context, float px) {
        init(context);
        return (int) (px / density + 0.5f);

    }

    private static void checkInit() {
        if (fontDensity == 0 | density == 0) {
            throw new RuntimeException("the DpUtils must be init !!(the init(Context app) method not  called)");
        }
    }

    public static void init(Context app) {
        if (density != 0 && fontDensity != 0) {
            return;
        }
        density = app.getResources().getDisplayMetrics().density;
        fontDensity = app.getResources().getDisplayMetrics().scaledDensity;

    }
}
