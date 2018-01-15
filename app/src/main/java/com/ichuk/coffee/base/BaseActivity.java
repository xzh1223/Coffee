package com.ichuk.coffee.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by xzh on 2017/12/4.
 * <p>
 * base activity
 */
public abstract class BaseActivity extends AppCompatActivity {

    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        context = this;
        initView();
        setEvent();
    }

    /**
     * set event
     */
    protected abstract void setEvent();

    /**
     * initial view
     */
    protected abstract void initView();

    /**
     * load layout
     */
    protected abstract int setLayout();

    /**
     * intent jump to target activity
     */
    public void toActivity(Class<?> c) {
        Intent intent = new Intent(context, c);
        startActivity(intent);
    }

}
