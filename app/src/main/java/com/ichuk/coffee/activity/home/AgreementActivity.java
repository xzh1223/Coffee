package com.ichuk.coffee.activity.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;

public class AgreementActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private TextView tvAgreement;

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
        ivBack = findViewById(R.id.iv_back);
        ivBack.setVisibility(View.VISIBLE);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        tvHeaderTitle.setText(getResources().getString(R.string.agreement_title));
        tvAgreement = findViewById(R.id.tv_agreement);
        tvAgreement.setText("协议内容");
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_agreement;
    }

    @Override
    public void onClick(View view) {
        if (view == ivBack) {
            finish();
        }
    }
}
