package com.ichuk.coffee.activity.discount;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.ExchangeCouponBean;

public class CouponReceiveActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private TextView tvAddress;
    private TextView tvLimit;
    private TextView tvTime;
    private TextView tvMoney;
    private TextView tvCondition;
    private Button btnOk;
    private ExchangeCouponBean mExchangeCouponBean;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        tvAddress = findViewById(R.id.tv_address);
        tvLimit = findViewById(R.id.tv_limit);
        tvTime = findViewById(R.id.tv_time);
        tvMoney = findViewById(R.id.tv_money);
        tvCondition = findViewById(R.id.tv_condition);
        btnOk = findViewById(R.id.btn_ok);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.coupon));
        tvAddress.setText(mExchangeCouponBean.getAddress());
        tvLimit.setText(mExchangeCouponBean.getVip());
        String time = mExchangeCouponBean.getStartTime() + "-" + mExchangeCouponBean.getEndTime();
        tvTime.setText(time);
        tvMoney.setText(mExchangeCouponBean.getMoney());
        tvCondition.setText(mExchangeCouponBean.getCondition());

        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        btnOk.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        getData();
    }

    /**
     * get data from intent
     */
    private void getData() {
        mExchangeCouponBean = (ExchangeCouponBean) getIntent().getSerializableExtra("bean");
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_coupon_receive;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_ok:
                toActivity(ReceivedSuccessActivity.class);
                break;
        }
    }
}
