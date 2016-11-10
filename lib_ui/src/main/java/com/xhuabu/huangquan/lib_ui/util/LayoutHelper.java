package com.xhuabu.huangquan.lib_ui.util;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class LayoutHelper {

  public static final int MATCH_PARENT = -1;
  public static final int WRAP_CONTENT = -2;

  private static int getSize(float size) {
    return (int) (size < 0 ? size : DpUtils.viewDp2Px(size));
  }

  public static FrameLayout.LayoutParams createScroll(int width, int height, int gravity) {
    return new ScrollView.LayoutParams(getSize(width), getSize(height), gravity);
  }

  public static FrameLayout.LayoutParams createFrame(int width, float height, int gravity,
      float leftMargin, float topMargin, float rightMargin, float bottomMargin) {
    FrameLayout.LayoutParams layoutParams =
        new FrameLayout.LayoutParams(getSize(width), getSize(height), gravity);
    layoutParams.setMargins(DpUtils.viewDp2Px(leftMargin), DpUtils.viewDp2Px(topMargin),
        DpUtils.viewDp2Px(rightMargin), DpUtils.viewDp2Px(bottomMargin));
    return layoutParams;
  }

  public static FrameLayout.LayoutParams createFrame(int width, int height, int gravity) {
    return new FrameLayout.LayoutParams(getSize(width), getSize(height), gravity);
  }

  public static FrameLayout.LayoutParams createFrame(int width, float height) {
    return new FrameLayout.LayoutParams(getSize(width), getSize(height));
  }

  public static RelativeLayout.LayoutParams createRelative(float width, float height,
                                                           int leftMargin, int topMargin, int rightMargin, int bottomMargin, int alignParent,
                                                           int alignRelative, int anchorRelative) {
    RelativeLayout.LayoutParams layoutParams =
        new RelativeLayout.LayoutParams(getSize(width), getSize(height));
    if (alignParent >= 0) {
      layoutParams.addRule(alignParent);
    }
    if (alignRelative >= 0 && anchorRelative >= 0) {
      layoutParams.addRule(alignRelative, anchorRelative);
    }
    layoutParams.leftMargin = DpUtils.viewDp2Px(leftMargin);
    layoutParams.topMargin = DpUtils.viewDp2Px(topMargin);
    layoutParams.rightMargin = DpUtils.viewDp2Px(rightMargin);
    layoutParams.bottomMargin = DpUtils.viewDp2Px(bottomMargin);
    return layoutParams;
  }

  public static RelativeLayout.LayoutParams createRelative(int width, int height, int leftMargin,
      int topMargin, int rightMargin, int bottomMargin) {
    return createRelative(width, height, leftMargin, topMargin, rightMargin, bottomMargin, -1, -1,
        -1);
  }

  public static RelativeLayout.LayoutParams createRelative(int width, int height, int leftMargin,
      int topMargin, int rightMargin, int bottomMargin, int alignParent) {
    return createRelative(width, height, leftMargin, topMargin, rightMargin, bottomMargin,
        alignParent, -1, -1);
  }

  public static RelativeLayout.LayoutParams createRelative(float width, float height,
      int leftMargin, int topMargin, int rightMargin, int bottomMargin, int alignRelative,
      int anchorRelative) {
    return createRelative(width, height, leftMargin, topMargin, rightMargin, bottomMargin, -1,
        alignRelative, anchorRelative);
  }

  public static RelativeLayout.LayoutParams createRelative(int width, int height, int alignParent,
      int alignRelative, int anchorRelative) {
    return createRelative(width, height, 0, 0, 0, 0, alignParent, alignRelative, anchorRelative);
  }

  public static RelativeLayout.LayoutParams createRelative(int width, int height) {
    return createRelative(width, height, 0, 0, 0, 0, -1, -1, -1);
  }

  public static RelativeLayout.LayoutParams createRelative(int width, int height, int alignParent) {
    return createRelative(width, height, 0, 0, 0, 0, alignParent, -1, -1);
  }

  public static RelativeLayout.LayoutParams createRelative(int width, int height, int alignRelative,
      int anchorRelative) {
    return createRelative(width, height, 0, 0, 0, 0, -1, alignRelative, anchorRelative);
  }

  public static LinearLayout.LayoutParams createLinear(int width, int height, float weight,
                                                       int gravity, int leftMargin, int topMargin, int rightMargin, int bottomMargin) {
    LinearLayout.LayoutParams layoutParams =
        new LinearLayout.LayoutParams(getSize(width), getSize(height), weight);
    layoutParams.setMargins(DpUtils.viewDp2Px(leftMargin), DpUtils.viewDp2Px(topMargin),
        DpUtils.viewDp2Px(rightMargin), DpUtils.viewDp2Px(bottomMargin));
    layoutParams.gravity = gravity;
    return layoutParams;
  }

  public static LinearLayout.LayoutParams createLinear(int width, int height, float weight,
      int leftMargin, int topMargin, int rightMargin, int bottomMargin) {
    LinearLayout.LayoutParams layoutParams =
        new LinearLayout.LayoutParams(getSize(width), getSize(height), weight);
    layoutParams.setMargins(DpUtils.viewDp2Px(leftMargin), DpUtils.viewDp2Px(topMargin),
        DpUtils.viewDp2Px(rightMargin), DpUtils.viewDp2Px(bottomMargin));
    return layoutParams;
  }

  public static LinearLayout.LayoutParams createLinear(int width, int height, int gravity,
      int leftMargin, int topMargin, int rightMargin, int bottomMargin) {
    LinearLayout.LayoutParams layoutParams =
        new LinearLayout.LayoutParams(getSize(width), getSize(height));
    layoutParams.setMargins(DpUtils.viewDp2Px(leftMargin), DpUtils.viewDp2Px(topMargin),
        DpUtils.viewDp2Px(rightMargin), DpUtils.viewDp2Px(bottomMargin));
    layoutParams.gravity = gravity;
    return layoutParams;
  }

  public static LinearLayout.LayoutParams createLinear(int width, int height, float leftMargin,
      float topMargin, float rightMargin, float bottomMargin) {
    LinearLayout.LayoutParams layoutParams =
        new LinearLayout.LayoutParams(getSize(width), getSize(height));
    layoutParams.setMargins(DpUtils.viewDp2Px(leftMargin), DpUtils.viewDp2Px(topMargin),
        DpUtils.viewDp2Px(rightMargin), DpUtils.viewDp2Px(bottomMargin));
    return layoutParams;
  }

  public static LinearLayout.LayoutParams createLinear(int width, int height, float weight,
      int gravity) {
    LinearLayout.LayoutParams layoutParams =
        new LinearLayout.LayoutParams(getSize(width), getSize(height), weight);
    layoutParams.gravity = gravity;
    return layoutParams;
  }

  public static LinearLayout.LayoutParams createLinear(int width, int height, int gravity) {
    LinearLayout.LayoutParams layoutParams =
        new LinearLayout.LayoutParams(getSize(width), getSize(height));
    layoutParams.gravity = gravity;
    return layoutParams;
  }

  public static LinearLayout.LayoutParams createLinear(int width, int height, float weight) {
    return new LinearLayout.LayoutParams(getSize(width), getSize(height), weight);
  }

  public static LinearLayout.LayoutParams createLinear(int width, int height) {
    return new LinearLayout.LayoutParams(getSize(width), getSize(height));
  }


  public static LinearLayoutManager createLinearManager(Context context, int orientation) {
    return new LinearLayoutManager(context, orientation, false);
  }

  public static LinearLayoutManager createLinearManager(Context context, int orientation,
      boolean reverseLayout) {
    return new LinearLayoutManager(context, orientation, reverseLayout);
  }

}
