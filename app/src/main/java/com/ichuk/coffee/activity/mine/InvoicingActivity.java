package com.ichuk.coffee.activity.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;

/**
 * Created by xzh on 2018/1/18.
 */

public class InvoicingActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout rlPlayInvoicing;
    private RelativeLayout rlPlayInvoicingRecord;
    private RelativeLayout rlPlayInvoicingAgreement;
    private TextView tvHeaderTitle;
    private ImageView ivBack;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        ivBack = findViewById(R.id.iv_back);
        rlPlayInvoicing = findViewById(R.id.rl_play_invoicing);
        rlPlayInvoicingRecord = findViewById(R.id.rl_play_invoicing_record);
        rlPlayInvoicingAgreement = findViewById(R.id.rl_play_invoicing_agreement);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setOnClickListener(this);
        rlPlayInvoicing.setOnClickListener(this);
        rlPlayInvoicingRecord.setOnClickListener(this);
        rlPlayInvoicingAgreement.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        setHeader();
    }

    /**
     *  set header
     */
    private void setHeader() {
        ivBack.setVisibility(View.VISIBLE);
        tvHeaderTitle.setText(getResources().getString(R.string.play_invoice));
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_make_invoicing;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_play_invoicing:
                toActivity(InvoicingPlayActivity.class);
                break;
            case R.id.rl_play_invoicing_record:
                toActivity(InvoicingRecordActivity.class);
                break;
            case R.id.rl_play_invoicing_agreement:

                break;
        }
    }
}
