package com.ichuk.coffee.activity.home;

import android.content.Intent;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private EditText etPhone;
    private EditText etVerificationCode;
    private EditText etPassword;
    private Button btnOk;
    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private TextView tvVerificationCode;
    private int mFlag;
    private TextView tvAgreement;
    private ImageView ivShow;
    private boolean isShow = false;
    private RelativeLayout rlAgreement;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        tvAgreement = findViewById(R.id.tv_agreement);
        rlAgreement = findViewById(R.id.rl_agreement);
        etPhone = findViewById(R.id.et_phone);
        etVerificationCode = findViewById(R.id.et_verification_code);
        tvVerificationCode = findViewById(R.id.tv_verification_code);
        etPassword = findViewById(R.id.et_password);
        btnOk = findViewById(R.id.btn_ok);
        ivShow = findViewById(R.id.iv_show);
    }

    /**
     * Handle button click events
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok:
                Toast.makeText(context, "ok", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_verification_code:
                Toast.makeText(context, "get verification code", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_agreement:
                Intent intent = new Intent(context, AgreementActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_show:
                isShow = !isShow;
                showPassword(isShow);
                break;
        }
    }

    /**
     *  show or hide password
     * @param isShow
     */
    private void showPassword(boolean isShow) {
        if (isShow) {
            ivShow.setImageResource(R.mipmap.icon_show_password);
            etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            ivShow.setImageResource(R.mipmap.icon_hide_password);
            etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        btnOk.setOnClickListener(this);
        tvVerificationCode.setOnClickListener(this);
        tvAgreement.setOnClickListener(this);
        ivShow.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        getData();
        checkToShow();
        showPassword(isShow);
    }

    /**
     * get data from intent
     */
    private void getData() {
        mFlag = getIntent().getIntExtra("FLAG", 0);
    }

    /**
     * check to show view
     */
    private void checkToShow() {
        if (mFlag == 1) {
            tvHeaderTitle.setText(getResources().getString(R.string.register_account));
            rlAgreement.setVisibility(View.VISIBLE);
            etPassword.setHint(getResources().getString(R.string.input_password_1));
        } else if (mFlag == 2) {
            tvHeaderTitle.setText(getResources().getString(R.string.forget_password));
            rlAgreement.setVisibility(View.GONE);
            etPassword.setHint(getResources().getString(R.string.input_password_2));
        }
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_register;
    }
}
