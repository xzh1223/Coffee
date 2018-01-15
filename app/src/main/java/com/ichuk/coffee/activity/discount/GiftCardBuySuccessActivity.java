package com.ichuk.coffee.activity.discount;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;

public class GiftCardBuySuccessActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvHeaderTitle;
    private ImageView ivBack;
    private TextView tvMineText;
    private TextView tvOtherText1;
    private TextView tvOtherText2;
    private LinearLayout llAccountAndPassword;
    private TextView tvAccount;
    private TextView tvPassword;
    private LinearLayout llPhone;
    private EditText etPhone;
    private TextView tvNoReceive;
    private Button btnToCenterOrResend;
    private Button btnViewOrder;
    private int mFlag = 0;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        ivBack = findViewById(R.id.iv_back);
        tvMineText = findViewById(R.id.tv_mine_text);
        tvOtherText1 = findViewById(R.id.tv_other_text_1);
        tvOtherText2 = findViewById(R.id.tv_other_text_2);
        llAccountAndPassword = findViewById(R.id.ll_account_and_password);
        tvAccount = findViewById(R.id.tv_account);
        tvPassword = findViewById(R.id.tv_password);
        llPhone = findViewById(R.id.ll_phone);
        etPhone = findViewById(R.id.et_phone);
        tvNoReceive = findViewById(R.id.tv_no_receive);
        btnToCenterOrResend = findViewById(R.id.btn_to_center_or_resend);
        btnViewOrder = findViewById(R.id.btn_view_order);


    }

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.ok_buy));
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        if (mFlag == 1) {
            btnToCenterOrResend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mFlag = 2;
                    checkShow(mFlag);
                }
            });
        }
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
        mFlag = getIntent().getIntExtra("who", -1);
        checkShow(mFlag);
    }

    /**
     * check to show
     */
    private void checkShow(int flag) {
        if (flag == 0) {
            tvMineText.setVisibility(View.VISIBLE);
            llAccountAndPassword.setVisibility(View.VISIBLE);
            btnViewOrder.setVisibility(View.VISIBLE);
            btnToCenterOrResend.setText(getResources().getString(R.string.to_personal_center));
            tvOtherText1.setVisibility(View.GONE);
            tvOtherText2.setVisibility(View.GONE);
            llPhone.setVisibility(View.GONE);
            tvNoReceive.setVisibility(View.GONE);
        } else if (flag == 1) {
            tvOtherText1.setVisibility(View.VISIBLE);
            llPhone.setVisibility(View.VISIBLE);
            btnToCenterOrResend.setText(getResources().getString(R.string.ok_send));
            tvMineText.setVisibility(View.GONE);
            tvOtherText2.setVisibility(View.GONE);
            tvNoReceive.setVisibility(View.GONE);
            llAccountAndPassword.setVisibility(View.GONE);
            btnViewOrder.setVisibility(View.GONE);
        } else if (flag == 2) {
            tvOtherText2.setVisibility(View.VISIBLE);
            tvNoReceive.setVisibility(View.VISIBLE);
            btnViewOrder.setVisibility(View.VISIBLE);
            btnToCenterOrResend.setText(getResources().getString(R.string.resend));
            tvMineText.setVisibility(View.GONE);
            tvOtherText1.setVisibility(View.GONE);
            llAccountAndPassword.setVisibility(View.GONE);
            llPhone.setVisibility(View.GONE);
        }
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_gift_card_buy_success;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                if (mFlag == 0 || mFlag == 1) {
                    finish();
                } else if (mFlag == 2) {
                    mFlag = 1;
                    checkShow(mFlag);
                }
                break;
        }
    }


}
