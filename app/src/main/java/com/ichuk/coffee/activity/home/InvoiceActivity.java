package com.ichuk.coffee.activity.home;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;

public class InvoiceActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private ImageView ivCheckNo;
    private ImageView ivCheckYes;
    private RadioGroup rgType;
    private RadioButton rbEnterprise;
    private RadioButton rbPersonal;
    private EditText etInvoice;
    private LinearLayout llTaxId;
    private EditText etIdentifier;
    private TextView tvMoney;
    private EditText etEmail;
    private Button btnOk;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        ivCheckNo = findViewById(R.id.iv_check_no);
        ivCheckYes = findViewById(R.id.iv_check_yes);
        rgType = findViewById(R.id.rg_type);
        rbEnterprise = findViewById(R.id.rb_enterprise);
        rbPersonal = findViewById(R.id.rb_personal);
        etInvoice = findViewById(R.id.et_invoice);
        llTaxId = findViewById(R.id.ll_tax_id);
        etIdentifier = findViewById(R.id.et_identifier);
        tvMoney = findViewById(R.id.tv_money);
        etEmail = findViewById(R.id.et_email);
        btnOk = findViewById(R.id.btn_ok);
    }

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.play_invoice));
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
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
        return R.layout.activity_invoice;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
