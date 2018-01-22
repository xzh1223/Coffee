package com.ichuk.coffee.activity.mine;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.utils.ToastUtil;

public class GiftCardAddActivity extends BaseActivity implements View.OnClickListener {

    private EditText etCardNum;
    private EditText etCardPassword;
    private Button btnAdd;
    private TextView tvHeaderTitle;
    private ImageView ivBack;
    private String mAccount = "";

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        ivBack = findViewById(R.id.iv_back);
        etCardNum = findViewById(R.id.et_card_num);
        etCardPassword = findViewById(R.id.et_card_password);
        btnAdd = findViewById(R.id.btn_add);
    }

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        getDataFromIntent();
        setHeader();
    }

    /**
     * get data from intent
     */
    private void getDataFromIntent() {
        mAccount = getIntent().getStringExtra("card_code");
    }

    /**
     * set header
     */
    private void setHeader() {
        ivBack.setVisibility(View.VISIBLE);
        if (mAccount != null || "".equals(mAccount)) {
            tvHeaderTitle.setText(getResources().getString(R.string.set_gift_card_password));
            btnAdd.setText(getResources().getString(R.string.gift_card_ok));
            etCardNum.setText(mAccount);
        } else {
            tvHeaderTitle.setText(getResources().getString(R.string.gift_card_add));
            btnAdd.setText(getResources().getString(R.string.gift_card_ok_add));
        }
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_gift_card_add;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_add:
                ToastUtil.toast(context, "add gift card");
                break;
        }
    }
}
