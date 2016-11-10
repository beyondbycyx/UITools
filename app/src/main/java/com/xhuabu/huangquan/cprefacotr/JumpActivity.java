package com.xhuabu.huangquan.cprefacotr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xhuabu.huangquan.lib_utils.LOG;

public class JumpActivity extends AppCompatActivity {

    private static final String INTENT_KEY_LINK = "banner_link";
    private static final String INTENT_KEY_TITLE = "banner_title";
    private static final String TAG = JumpActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);
        String link = getIntent().getStringExtra(INTENT_KEY_LINK);
        String title = getIntent().getStringExtra(INTENT_KEY_TITLE);
        LOG.v(TAG, "link=" + link + ",title=" + title);
    }
}
