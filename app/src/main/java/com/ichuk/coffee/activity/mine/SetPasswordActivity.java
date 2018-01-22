package com.ichuk.coffee.activity.mine;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;

public class SetPasswordActivity extends BaseActivity {

    private String mAccount;

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
        getDataFromIntent();
    }

    /**
     * get data from http
     */
    private void getDataFromIntent() {
        mAccount = getIntent().getStringExtra("card_code");
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_set_password;
    }
}
