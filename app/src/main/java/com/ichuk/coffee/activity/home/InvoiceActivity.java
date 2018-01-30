package com.ichuk.coffee.activity.home;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;

public class InvoiceActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
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
    private RelativeLayout rlUnused;
    private RelativeLayout rlUsed;
    private LinearLayout llMakeInvoice;
    private int mPosition = 0;
    private boolean isPersonal = true;

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
        rlUnused = findViewById(R.id.rl_unused);
        rlUsed = findViewById(R.id.rl_used);
        llMakeInvoice = findViewById(R.id.ll_make_invoice);
    }

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.play_invoice));
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        rlUnused.setOnClickListener(this);
        rlUsed.setOnClickListener(this);
        rgType.setOnCheckedChangeListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        selected(mPosition);
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
                back();
                break;
            case R.id.rl_unused:
                mPosition = 0;
                selected(mPosition);
                break;
            case R.id.rl_used:
                mPosition = 1;
                selected(mPosition);
                break;
        }
    }

    /**
     *  back to last activity
     */
    private void back() {
        Intent intent = getIntent();
        if (mPosition == 0) {
            intent.putExtra("invoice", "不需要发票");
        } else {
            intent.putExtra("invoice", "苏州爱察信息技术有限公司");
        }
        setResult(RESULT_OK, intent);
        finish();
    }

    /**
     *  select to used or unused invoice
     */
    private void selected(int position) {
        if (position == 0) {
            // unused
            llMakeInvoice.setVisibility(View.GONE);
            ivCheckNo.setImageResource(R.mipmap.icon_selected);
            ivCheckYes.setImageResource(R.mipmap.icon_unselected);
        } else if (position == 1) {
            // used
            llMakeInvoice.setVisibility(View.VISIBLE);
            ivCheckNo.setImageResource(R.mipmap.icon_unselected);
            ivCheckYes.setImageResource(R.mipmap.icon_selected);

            checkShowTax(isPersonal);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.rb_personal) {
            isPersonal = true;
            checkShowTax(isPersonal);
        } else {
            isPersonal = false;
            checkShowTax(isPersonal);
        }
    }

    /**
     *  check personal orr enterprise
     */
    private void checkShowTax(boolean isPersonal) {
        if (isPersonal) {
            llTaxId.setVisibility(View.GONE);
        } else {
            llTaxId.setVisibility(View.VISIBLE);
        }
    }

    /**
     *  back key
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            back();
            return false;
        }else {
            return super.onKeyDown(keyCode, event);
        }

    }

}
