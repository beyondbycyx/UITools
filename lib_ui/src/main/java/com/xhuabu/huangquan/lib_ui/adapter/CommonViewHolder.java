package com.xhuabu.huangquan.lib_ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by hugo on 2016/5/10.
 */
public class CommonViewHolder extends RecyclerView.ViewHolder {


    public CommonViewHolder(View itemView) {
        super(itemView);

    }


    public <V extends View> V getView(int resId) {
        if (itemView.findViewById(resId) == null) {
            throw new IllegalStateException(" no View for the resId " + resId);
        }

        return (V) itemView.findViewById(resId);
    }
    public <V extends View> V getView(Object tag) {
        if (itemView.findViewWithTag(tag) == null) {
            throw new IllegalStateException(" no View for the tag " + tag);
        }

        return (V) itemView.findViewWithTag(tag);
    }
}
