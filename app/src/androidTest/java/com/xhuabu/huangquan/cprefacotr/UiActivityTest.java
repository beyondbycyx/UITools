package com.xhuabu.huangquan.cprefacotr;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by huangquan on 16/9/20.
 */
public class UiActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity activity;

    public UiActivityTest() {
        super(MainActivity.class);

    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(true);
        activity = getActivity();

    }


    public void testUi() throws Exception {


         Thread.currentThread().sleep(20000);

    }
}
