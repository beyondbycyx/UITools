package com.xhuabu.huangquan.lib_utils;

import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

public class LOG
{
  public static boolean isDebug = true;

  public static boolean isSaveLog = false;
  public static String logPath;
  private static Calendar calendar = Calendar.getInstance();

  public static int v(String tag, String msg)
  {
    if (isSaveLog) {
      saveLogToFile(tag, msg, "V", null);
    }

    if (isDebug) {
      return Log.v(tag, msg);
    }
    return 0;
  }

  public static int v(String tag, String msg, Throwable tr)
  {
    if (isSaveLog) {
      saveLogToFile(tag, msg, "V", tr);
    }

    if (isDebug) {
      return Log.v(tag, msg, tr);
    }
    return 0;
  }

  public static int d(String tag, String msg)
  {
    if (isSaveLog) {
      saveLogToFile(tag, msg, "D", null);
    }

    if (isDebug) {
      return Log.d(tag, msg);
    }
    return 0;
  }

  public static int d(String tag, String msg, Throwable tr)
  {
    if (isSaveLog) {
      saveLogToFile(tag, msg, "D", tr);
    }

    if (isDebug) {
      return Log.d(tag, msg, tr);
    }
    return 0;
  }

  public static int i(String tag, String msg)
  {
    if (isSaveLog) {
      saveLogToFile(tag, msg, "I", null);
    }

    if (isDebug) {
      return Log.i(tag, msg);
    }
    return 0;
  }

  public static int i(String tag, String msg, Throwable tr)
  {
    if (isSaveLog) {
      saveLogToFile(tag, msg, "I", tr);
    }

    if (isDebug) {
      return Log.i(tag, msg, tr);
    }
    return 0;
  }

  public static int w(String tag, String msg)
  {
    if (isSaveLog) {
      saveLogToFile(tag, msg, "W", null);
    }

    if (isDebug) {
      return Log.w(tag, msg);
    }
    return 0;
  }

  public static int w(String tag, String msg, Throwable tr)
  {
    if (isSaveLog) {
      saveLogToFile(tag, msg, "W", tr);
    }

    if (isDebug) {
      return Log.w(tag, msg, tr);
    }
    return 0;
  }

  public static int e(String tag, String msg)
  {
    if (isSaveLog) {
      saveLogToFile(tag, msg, "E", null);
    }

    if (isDebug) {
      return Log.e(tag, msg);
    }
    return 0;
  }

  public static int e(String tag, String msg, Throwable tr)
  {
    if (isSaveLog) {
      saveLogToFile(tag, msg, "E", tr);
    }

    if (isDebug) {
      return Log.e(tag, msg, tr);
    }
    return 0;
  }

  @Deprecated
  private static void saveLogToFile(final String tag, final String msg, final String priority, final Throwable thr)
  {

  }
}
