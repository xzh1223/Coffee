package com.ichuk.coffee.activity.mine;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.utils.ToastUtil;

public class RefundResultActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private TextView tvRefundMoney;
    private TextView tvRefundMethod;
    private Button btnOk;
    private String mMoney;
    private String mMethod;
    private String mAccount;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        tvRefundMoney = findViewById(R.id.tv_refund_money);
        tvRefundMethod = findViewById(R.id.tv_refund_method);
        btnOk = findViewById(R.id.btn_ok);
    }

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setVisibility(View.VISIBLE);
        tvHeaderTitle.setText(getResources().getString(R.string.play_refund_result));
        String money = "￥" + mMoney;
        tvRefundMoney.setText(money);
        String method = mMethod + "（" + mAccount + "）";
        tvRefundMethod.setText(method);
        ivBack.setOnClickListener(this);
        btnOk.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        mMoney = intent.getStringExtra("money");
        mMethod = intent.getStringExtra("method");
        mAccount = intent.getStringExtra("account");
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_refund_result;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ok:
                ToastUtil.toast(context, "完成");
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
