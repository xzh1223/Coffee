package com.ichuk.coffee.activity.mine;

import android.support.v7.app.AlertDialog;
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

public class InvoicingSubmitActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private RadioGroup rgType;
    private RadioButton rbEnterprise;
    private RadioButton rbPersonal;
    private EditText etInvoice;
    private EditText etIdentifier;
    private TextView tvMoney;
    private EditText etEmail;
    private String mType;
    private Button btnSubmit;
    private AlertDialog mDialog;
    private boolean isPersonal = true;
    private LinearLayout llTaxId;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        rgType = findViewById(R.id.rg_type);
        rbEnterprise = findViewById(R.id.rb_enterprise);
        rbPersonal = findViewById(R.id.rb_personal);
        etInvoice = findViewById(R.id.et_invoice);
        llTaxId = findViewById(R.id.ll_tax_id);
        etIdentifier = findViewById(R.id.et_identifier);
        tvMoney = findViewById(R.id.tv_money);
        etEmail = findViewById(R.id.et_email);
        btnSubmit = findViewById(R.id.btn_submit);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setOnClickListener(this);
        rgType.setOnCheckedChangeListener(this);
        btnSubmit.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        setHeader();
        checkShowTax(isPersonal);
    }

    /**
     * set header
     */
    private void setHeader() {
        tvHeaderTitle.setText(getResources().getString(R.string.write_invoice));
        ivBack.setVisibility(View.VISIBLE);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_invoicing_submit;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_submit:
                showDialog();
                break;
        }
    }

    /**
     *  show dialog
     */
    private void showDialog() {
        View view = View.inflate(context, R.layout.item_dialog_invoicing_submit, null);
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setView(view);
        mDialog = dialog.create();
        mDialog.show();
        TextView tvInvoice = view.findViewById(R.id.tv_invoice);
        TextView tvIdentifier = view.findViewById(R.id.tv_identifier);
        TextView tvEmail = view.findViewById(R.id.tv_email);
        TextView tvCancel = view.findViewById(R.id.tv_cancel);
        TextView tvSubmit = view.findViewById(R.id.tv_submit);
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDialog != null) {
                    mDialog.dismiss();
                }
            }
        });
        tvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDialog != null) {
                    mDialog.dismiss();
                }
                toActivity(InvoicingSubmitResultActivity.class);
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int id) {
        if (id == R.id.rb_personal) {
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
}
