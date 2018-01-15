package com.ichuk.coffee.activity.home;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;

public class SubmitOrderActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private LinearLayout llBottom;
    private TextView tvPayMoney;
    private LinearLayout llSubmit;
    private TextView tvCoffeeStory;
    private RecyclerView rvOrder;
    private TextView tvText;
    private TextView tvMoney;
    private TextView tvScore;
    private Switch switchUseOrNot;
    private TextView tvUsableCoupon;
    private TextView tvUsableAllowance;
    private TextView tvInvoice;
    private ImageView ivWx;
    private ImageView ivCheckWx;
    private ImageView ivZfb;
    private ImageView ivCheckZfb;
    private ImageView ivGiftCard;
    private ImageView ivCheckGiftCard;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        llBottom = findViewById(R.id.ll_bottom);
        tvPayMoney = findViewById(R.id.tv_pay_money);
        llSubmit = findViewById(R.id.ll_submit);
        tvCoffeeStory = findViewById(R.id.tv_coffee_story);
        rvOrder = findViewById(R.id.rv_order);
        tvText = findViewById(R.id.tv_text);
        tvMoney = findViewById(R.id.tv_money);
        tvScore = findViewById(R.id.tv_score);
        switchUseOrNot = findViewById(R.id.switch_use_or_not);
        tvUsableCoupon = findViewById(R.id.tv_usable_coupon);
        tvUsableAllowance = findViewById(R.id.tv_usable_allowance);
        tvInvoice = findViewById(R.id.tv_invoice);
        ivWx = findViewById(R.id.iv_wx);
        ivCheckWx = findViewById(R.id.iv_check_wx);
        ivZfb = findViewById(R.id.iv_zfb);
        ivCheckZfb = findViewById(R.id.iv_check_zfb);
        ivGiftCard = findViewById(R.id.iv_gift_card);
        ivCheckGiftCard = findViewById(R.id.iv_check_gift_card);
    }

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.submit_order));
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        tvUsableCoupon.setOnClickListener(this);
        tvUsableAllowance.setOnClickListener(this);
        tvInvoice.setOnClickListener(this);
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
     *  get data from http
     */
    private void getData() {

    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_submit_order;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_usable_coupon: {
                Intent intent = new Intent(context, SelectCouponActivity.class);
                intent.putExtra("page", "coupon");
                startActivity(intent);
                break;
            }
            case R.id.tv_usable_allowance: {
                Intent intent = new Intent(context, SelectCouponActivity.class);
                intent.putExtra("page", "allowance");
                startActivity(intent);
                break;
            }
            case R.id.tv_invoice:
                toActivity(InvoiceActivity.class);
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
