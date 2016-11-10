package com.xhuabu.huangquan.lib_ui.adapter;


import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ViewUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.xhuabu.huangquan.lib_ui.util.MyViewUtils;

import java.util.List;
import java.util.Objects;

import butterknife.OnClick;

/**
 * Created by hugo on 2016/5/5.
 */
public abstract    class RvAdapter<D> extends RecyclerView.Adapter<RvAdapter.ViewHolder> {


    private  int mLayoutId;
    private LayoutInflater mInflater;

    public abstract void initEvent(RvAdapter.ViewHolder holder, D object);
    public abstract void bindData(RvAdapter.ViewHolder holder , D object);




    private List<D> mDataSet ;

    public void setOnItemClick(OnItemOnClick mItemClick) {
        this.mItemClick = mItemClick;
    }

    private OnItemOnClick mItemClick;


    public RvAdapter(@NonNull Context context , @Nullable List<D> dataSet, @LayoutRes int layoutId) {

        mInflater = LayoutInflater.from(context);
        mDataSet = dataSet;
        mLayoutId = layoutId;

    }

    public void refreshDataSet(List<D> dataSet) {
        mDataSet = dataSet;
        notifyDataSetChanged();
    }

    //创建ViewHolder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = mInflater.inflate(mLayoutId, null);
        return new ViewHolder(itemView);

    }

    //绑定数据
    @Override
    public void onBindViewHolder(RvAdapter.ViewHolder holder,  int position) {
        if (mDataSet == null) {
            return;
        }

        final int adapterPosition = position;
        //set data 到 holder
        holder.setObject(mDataSet.get(adapterPosition));

        bindData(holder, mDataSet.get(adapterPosition));
        initEvent(holder,mDataSet.get(adapterPosition));

        //item onClick listener
        if (mItemClick != null) {

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClick.onClick(v,adapterPosition);

                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return mDataSet ==  null ? 0 : mDataSet.size();
    }


    public static class ViewHolder<T>  extends RecyclerView.ViewHolder{

        private T mObj;

        public void setObject (T object) {
            mObj = object;
        }
        public ViewHolder(View itemView) {
            super(itemView);
        }

        public <V extends View> V getView(@IdRes int resId) {

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

        public void bindText(@IdRes int resId, String text) {
            MyViewUtils.bindText(((TextView) getView(resId)), text);
        }


        public void bindTextWithGone(@IdRes int resId, String text) {
            MyViewUtils.bindTextWithGone(((TextView) getView(resId)), text);
        }

        public void bindImg(@IdRes int resId, String imgUrl) {

            MyViewUtils.bindImg((ImageView) getView(resId),imgUrl);
        }

        public void bindImg(@IdRes int resId, String imgUrl, @DrawableRes int errorDrawableId) {
            MyViewUtils.bindImg(((ImageView) getView(resId)), imgUrl, errorDrawableId);

        }

        public void setClickEvent(@IdRes int resId, final OnClickEvent<T> onClickEvent) {

            getView(resId).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickEvent.onClick(v,mObj);
                }
            });
        }

        public interface OnClickEvent<D>{
            void onClick(View v, D object);
        }
    }

    public interface  OnItemOnClick{

         void onClick(View itemView, int position);
    }


}
