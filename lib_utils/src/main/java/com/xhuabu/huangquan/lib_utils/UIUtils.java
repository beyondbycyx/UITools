package com.xhuabu.huangquan.lib_utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;




public class UIUtils {
/*
	*/
/**得到上下文*//*

	public static Context getContext() {
		return App.getContext();
	}

	*/
/**得到Resource对象*//*

	public static Resources getResources() {
		return getContext().getResources();
	}

	*/
/**得到String.xml中的字符*//*

	public static String getString(int resId) {
		return getResources().getString(resId);
	}

	*/
/**得到String.xml中的字符,带占位符*//*

	public static String getString(int resId, Object... formatArgs) {
		return getResources().getString(resId, formatArgs);
	}

	*/
/**得到String.xml中的字符数组*//*

	public static String[] getStringArr(int resId) {
		return getResources().getStringArray(resId);
	}

	*/
/**得到color.xml中的颜色值*//*

	public static int getColor(int resId) {
		return getResources().getColor(resId);
	}

	*/
/**得到应用程序的包名*//*

	public static String getPackageName() {
		return getContext().getPackageName();
	}

	*/
/**得到主线程的id*//*

	public static long getMainThreadId() {
		return App.getMainThreadId();
	}

	*/
/**得到主线程的hanlder*//*

	public static Handler getMainThreadHandler() {
		return App.getMainThreadHandler();
	}

	*/
/** 安全的执行一个task*//*

	public static void postTaskSafely(Runnable task) {
		// 如果当前线程是主线程==>直接执行
		// 如果当前线程是子线程==>通过消息机制发送到主线程
		long curThreadId = android.os.Process.myTid();
		long mainThreadId = getMainThreadId();
		if (curThreadId == mainThreadId) {// 在主线中
			task.run();
		} else {
			getMainThreadHandler().post(task);
		}
	}


	*/
/*view 类的赋值*//*


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
		Picasso.with(imageView.getContext()).load(imgUrl).into(imageView);
	}

	public static void bindImg(ImageView imageView, String imgUrl, int errorDrawableId) {
		Picasso.with(imageView.getContext()).load(imgUrl).error(errorDrawableId).into(imageView);
	}
*/


}
