package com.xhuabu.huangquan.lib_utils;

/**
 * Created by hugo on 2016/5/5.
 */
public class CheckUtils {


    public static void checkForNull(Object... objects) throws IllegalStateException {

        if (objects == null) {
            throw new IllegalStateException("the object is null");
        }

        for (Object object : objects) {
            if (object == null) {
                throw new IllegalStateException("the object is null");
            }
        }

    }




    public static Boolean isNull(Object object) {
        if (object == null) {
            return true;
        }else{
            return false;
        }
    }


    public static Boolean isNull(Object... objects) {
        if (objects == null) {
            return true;
        }

        for (Object object : objects) {
            if (object == null) {
                return true;
            }
        }

        return false;
    }

    public static Boolean isNotNull(Object... objects) {
        if (objects == null) {
            return false;
        }

        for (Object object : objects) {
            if (object == null) {
               return false;
            }
        }

        return true;
    }

    public static Boolean isNotNull(Object object) {
        if (object != null) {
            return true;
        }else{
            return false;
        }
    }


    //TODO
    public static void allowNull(Object obj) {



    }
}
