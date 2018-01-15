package com.ichuk.coffee.activity.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.utils.ToastUtil;
import com.jungly.gridpasswordview.GridPasswordView;

public class SetPayPasswordActivity extends BaseActivity implements View.OnClickListener, GridPasswordView.OnPasswordChangedListener {

    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private GridPasswordView gpvPay;
    private TextView tvSave;

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.set_pay_password));
        ivBack.setVisibility(View.VISIBLE);
        tvSave.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        tvSave.setOnClickListener(this);
        gpvPay.setOnPasswordChangedListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
    }

    private void findViews() {
        gpvPay = findViewById(R.id.gpv_pay);
        ivBack = findViewById(R.id.iv_back);
        tvSave = findViewById(R.id.tv_save);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_set_pay_password;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_save:
                ToastUtil.toast(context, "保存");
                break;
        }
    }

    /**
     * Invoked when the password changed.
     *
     * @param psw new text
     */
    @Override
    public void onTextChanged(String psw) {

    }

    /**
     * Invoked when the password is at the maximum length.
     *
     * @param psw complete text
     */
    @Override
    public void onInputFinish(String psw) {

    }
}
