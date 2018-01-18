package com.ichuk.coffee.activity.home;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;

public class SubmitOrderActivity extends BaseActivity implements View.OnClickListener {
    private static final int COUPON = 1;
    private static final int ALLOWANCE = 2;
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
    private RelativeLayout rlCoupon;
    private ImageView ivTo;
    private TextView tvUsableCoupon;
    private RelativeLayout rlAllowance;
    private ImageView ivTo2;
    private TextView tvUsableAllowance;
    private RelativeLayout rlInvoice;
    private ImageView ivTo3;
    private TextView tvInvoice;
    private RelativeLayout rlPayWx;
    private ImageView ivWx;
    private TextView tvWxKey;
    private RelativeLayout rlPayZfb;
    private ImageView ivZfb;
    private TextView tvZfbKey;
    private RelativeLayout rlPayCzk;
    private ImageView ivGiftCard;
    private TextView tvCardKey;

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
        rlCoupon = findViewById(R.id.rl_coupon);
        ivTo = findViewById(R.id.iv_to);
        tvUsableCoupon = findViewById(R.id.tv_usable_coupon);
        rlAllowance = findViewById(R.id.rl_allowance);
        ivTo2 = findViewById(R.id.iv_to_2);
        tvUsableAllowance = findViewById(R.id.tv_usable_allowance);
        rlInvoice = findViewById(R.id.rl_invoice);
        ivTo3 = findViewById(R.id.iv_to_3);
        tvInvoice = findViewById(R.id.tv_invoice);
        rlPayWx = findViewById(R.id.rl_pay_wx);
        ivWx = findViewById(R.id.iv_wx);
        tvWxKey = findViewById(R.id.tv_wx_key);
        rlPayZfb = findViewById(R.id.rl_pay_zfb);
        ivZfb = findViewById(R.id.iv_zfb);
        tvZfbKey = findViewById(R.id.tv_zfb_key);
        rlPayCzk = findViewById(R.id.rl_pay_czk);
        ivGiftCard = findViewById(R.id.iv_gift_card);
        tvCardKey = findViewById(R.id.tv_card_key);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.submit_order));
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        rlCoupon.setOnClickListener(this);
        rlAllowance.setOnClickListener(this);
        rlInvoice.setOnClickListener(this);
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
     * get data from http
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
            case R.id.rl_coupon: {
                Intent intent = new Intent(context, SelectCouponActivity.class);
                intent.putExtra("page", "coupon");
                startActivityForResult(intent, COUPON);
                break;
            }
            case R.id.rl_allowance: {
                Intent intent = new Intent(context, SelectCouponActivity.class);
                intent.putExtra("page", "allowance");
                startActivityForResult(intent, ALLOWANCE);
                break;
            }
            case R.id.rl_invoice:
                toActivity(InvoiceActivity.class);
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case COUPON: {
                String money = "减￥"+data.getStringExtra("money");
                tvUsableCoupon.setText(money);
                break;
            }
            case ALLOWANCE: {
                String money = "减￥"+data.getStringExtra("money");
                tvUsableAllowance.setText(money);
                break;
            }
        }
    }
}
