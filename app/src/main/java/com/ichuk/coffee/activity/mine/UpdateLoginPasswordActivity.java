package com.ichuk.coffee.activity.mine;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.utils.ToastUtil;

public class UpdateLoginPasswordActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivBack;
    private TextView tvHeaderTitle;

    private EditText etOldPassword;
    private EditText etNewPassword;
    private EditText etRepeatNewPassword;
    private Button btnUpdateOk;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        etOldPassword = findViewById(R.id.et_old_password);
        etNewPassword = findViewById(R.id.et_new_password);
        etRepeatNewPassword = findViewById(R.id.et_repeat_new_password);
        btnUpdateOk = findViewById(R.id.btn_update_ok);
    }

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        btnUpdateOk.setOnClickListener(this);
        tvHeaderTitle.setText(getResources().getString(R.string.update_login_password));
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();

    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_update_login_password;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_update_ok:
                checkInput();
                break;
        }
    }

    /**
     * check input and submit to http
     */
    private void checkInput() {
        ToastUtil.toast(context, "确认修改");
    }
}
