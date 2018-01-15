package com.ichuk.coffee.activity.mine;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.AllowanceBean;
import com.ichuk.coffee.bean.CouponBean;
import com.ichuk.coffee.utils.ToastUtil;

public class DonatedActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private EditText etPhone;
    private TextView tvMoney;
    private TextView tvLimit;
    private TextView tvTitle;
    private TextView tvTime;
    private TextView tvMoney2;
    private TextView tvLimit2;
    private TextView tvTitle2;
    private TextView tvTime2;
    private TextView tvToUse;
    private TextView tvDonated;
    private Button btnOk;
    private CouponBean mCouponBean;
    private AllowanceBean mAllowanceBean;
    private int mPosition = 0;
    private LinearLayout llCoupon;
    private LinearLayout llAllowance;
    private ImageView ivImage;
    private TextView tvHeader;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        tvHeader = findViewById(R.id.tv_header);
        llCoupon = findViewById(R.id.ll_coupon);
        llAllowance = findViewById(R.id.ll_allowance);
        etPhone = findViewById(R.id.et_phone);
        tvMoney = findViewById(R.id.tv_money);
        tvLimit = findViewById(R.id.tv_limit);
        tvTitle = findViewById(R.id.tv_title);
        tvTime = findViewById(R.id.tv_time);
        tvMoney2 = findViewById(R.id.tv_money_2);
        tvLimit2 = findViewById(R.id.tv_limit_2);
        tvTitle2 = findViewById(R.id.tv_title_2);
        tvTime2 = findViewById(R.id.tv_time_2);
        ivImage = findViewById(R.id.iv_image);
        tvToUse = findViewById(R.id.tv_to_use);
        tvDonated = findViewById(R.id.tv_donated);
        btnOk = findViewById(R.id.btn_ok);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        if (mPosition == 0) {
            tvHeaderTitle.setText(getResources().getString(R.string.refund_coupon));
            tvHeader.setText(getResources().getString(R.string.coupon));
            llCoupon.setVisibility(View.VISIBLE);
            llAllowance.setVisibility(View.GONE);
            tvMoney.setText(mCouponBean.getMoney());
            tvLimit.setText(mCouponBean.getLimit());
            tvTitle.setText(mCouponBean.getTitle());
            tvTime.setText(mCouponBean.getTime());
        } else {
            tvHeaderTitle.setText(getResources().getString(R.string.refund_allowance));
            tvHeader.setText(getResources().getString(R.string.allowance));
            llCoupon.setVisibility(View.GONE);
            llAllowance.setVisibility(View.VISIBLE);
            tvMoney2.setText(mAllowanceBean.getMoney());
            tvLimit2.setText(mAllowanceBean.getLimit());
            tvTitle2.setText(mAllowanceBean.getTitle());
            tvTime2.setText(mAllowanceBean.getTime());
            Glide.with(context).load(R.mipmap.ic_launcher).into(ivImage);
        }
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
     * get data from intent and http
     */
    private void getData() {
        Intent intent = getIntent();
        String page = intent.getStringExtra("page");
        if (page.equals("优惠券")) {
            mPosition = 0;
            mCouponBean = (CouponBean) intent.getSerializableExtra("bean");
        } else if (page.equals("补贴")) {
            mPosition = 1;
            mAllowanceBean = (AllowanceBean) intent.getSerializableExtra("bean");
        }

    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_donated;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_ok:
                String phoneNum = etPhone.getText().toString().trim();
                if (phoneNum.length() == 11) {
                    ToastUtil.toast(context, "确认转赠");
                } else {
                    ToastUtil.toast(context, "号码错误");
                }
                break;
        }
    }
}
