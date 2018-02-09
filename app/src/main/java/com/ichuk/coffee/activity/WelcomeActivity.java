package com.ichuk.coffee.activity;

import android.os.Handler;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;

/**
 * Created by xzh on 2018/2/8.
 */

public class WelcomeActivity extends BaseActivity {
    Handler mHandler = new Handler();

    /**
     * set event
     */
    @Override
    protected void setEvent() {

    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        intent();
    }

    /**
     * intent to main
     */
    private void intent() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toActivity(MainActivity.class);
                finish();
            }
        }, 2000);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_welcome;
    }
}
