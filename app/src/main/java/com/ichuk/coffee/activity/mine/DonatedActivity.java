package com.ichuk.coffee.activity.mine;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    private LinearLayout llGiftCard;
    private ImageView ivImage;
    private TextView tvHeader;
    private AlertDialog mDialog;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        tvHeader = findViewById(R.id.tv_header);
        llCoupon = findViewById(R.id.ll_coupon);
        llAllowance = findViewById(R.id.ll_allowance);
        llGiftCard = findViewById(R.id.ll_gift_card);
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
            llGiftCard.setVisibility(View.GONE);
            tvMoney.setText(mCouponBean.getMoney());
            tvLimit.setText(mCouponBean.getLimit());
            tvTitle.setText(mCouponBean.getTitle());
            tvTime.setText(mCouponBean.getTime());
        } else if (mPosition == 1){
            tvHeaderTitle.setText(getResources().getString(R.string.refund_allowance));
            tvHeader.setText(getResources().getString(R.string.allowance));
            llGiftCard.setVisibility(View.GONE);
            llCoupon.setVisibility(View.GONE);
            llAllowance.setVisibility(View.VISIBLE);
            tvMoney2.setText(mAllowanceBean.getMoney());
            tvLimit2.setText(mAllowanceBean.getLimit());
            tvTitle2.setText(mAllowanceBean.getTitle());
            tvTime2.setText(mAllowanceBean.getTime());
        } else if (mPosition == 2) {
            tvHeaderTitle.setText(getResources().getString(R.string.refund_gift_card));
            tvHeader.setText(getResources().getString(R.string.gift_card));
            llCoupon.setVisibility(View.GONE);
            llAllowance.setVisibility(View.GONE);
            llGiftCard.setVisibility(View.VISIBLE);
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
        } else if (page.equals("储值卡")) {
            mPosition = 2;
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
                    showDialog();
                } else {
                    ToastUtil.toast(context, "号码错误");
                }
                break;
        }
    }

    /**
     * show dialog for donate
     */
    private void showDialog() {
        View view = View.inflate(context, R.layout.item_dialog_confirm_phone, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        mDialog = builder.create();
        mDialog.setView(view);
        mDialog.show();
        ImageView ivEsc = view.findViewById(R.id.iv_esc);
        TextView tvPhone = view.findViewById(R.id.tv_phone);
        TextView tvCancel = view.findViewById(R.id.tv_cancel);
        TextView tvOk = view.findViewById(R.id.tv_ok);
        tvPhone.setText("要发送至的手机号码为" +
                etPhone.getText().toString().trim() + "，请\n确认是否正确？");
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDialog != null) {
                    mDialog.dismiss();
                }
            }
        });
        tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDialog != null) {
                    mDialog.dismiss();
                }
            }
        });
        ivEsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDialog != null) {
                    mDialog.dismiss();
                }
            }
        });
    }
}
