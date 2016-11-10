package com.xhuabu.huangquan.lib_ui.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class InnerViewPager extends ViewPager {
    private static final java.lang.String TAG = "InnerViewPager";
    private float	mDownX;
    private float	mDownY;
    private float mIDownX;
    private float mIDownY;
    public InnerViewPager(Context context) {
        super(context);
    }
    public InnerViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     * 左右滑动-->请求父容器不拦截-->自己处理滑动
     */
    @Override public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mIDownX = ev.getRawX();
                mIDownY = ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                float moveX = ev.getRawX();
                float moveY = ev.getRawY();
                int diffX = (int) (moveX - mIDownX + .5f);
                int diffY = (int) (moveY - mIDownY + .5f);
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    //LogUtils.v(TAG, "InnerViewPager 阻断左右事件的传递");
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
            default:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
    /**
    getParent(父容器). request(请求)	Disallow(不)	Intercept(拦截)	TouchEvent(Touch事件) (true(同意))
    请求父容器不拦截(true)-->自己处理
    请求父容器不拦截(false)-->父亲处理
     */
     @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
        case MotionEvent.ACTION_DOWN:
            mDownX = ev.getRawX();
            mDownY = ev.getRawY();
            break;
        case MotionEvent.ACTION_MOVE:
            float moveX = ev.getRawX();
            float moveY = ev.getRawY();
            int diffX = (int) (moveX - mDownX + .5f);
            int diffY = (int) (moveY - mDownY + .5f);
            if (Math.abs(diffX) > Math.abs(diffY)) {// 左右
                // 请求父容器不拦截-->自己处理滑动
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            break;
        case MotionEvent.ACTION_UP:
        case MotionEvent.ACTION_CANCEL:
            break;
        default:
            getParent().requestDisallowInterceptTouchEvent(false);
            break;
        }
        return super.onTouchEvent(ev);
    }
}