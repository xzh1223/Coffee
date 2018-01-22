package com.ichuk.coffee.activity.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;

public class InvoicingDetailActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvType;
    private TextView tvTime;
    private TextView tvFind;
    private TextView tvEmail;
    private TextView tvInvoiceHeader;
    private TextView tvTaxId;
    private TextView tvInvoiceContent;
    private TextView tvInvoiceMoney;
    private TextView tvInvoiceTime;
    private ImageView ivBack;
    private TextView tvHeaderTitle;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        tvType = findViewById(R.id.tv_type);
        tvTime = findViewById(R.id.tv_time);
        tvFind = findViewById(R.id.tv_find);
        tvEmail = findViewById(R.id.tv_email);
        tvInvoiceHeader = findViewById(R.id.tv_invoice_header);
        tvTaxId = findViewById(R.id.tv_tax_id);
        tvInvoiceContent = findViewById(R.id.tv_invoice_content);
        tvInvoiceMoney = findViewById(R.id.tv_invoice_money);
        tvInvoiceTime = findViewById(R.id.tv_invoice_time);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        setHeader();
        getData();
    }

    /**
     *  get data from http
     */
    private void getData() {

    }

    /**
     *  set header
     */
    private void setHeader() {
        ivBack.setVisibility(View.VISIBLE);
        tvHeaderTitle.setText(getResources().getString(R.string.invoicing_detail));
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_invoicing_detail;
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
