package com.ichuk.coffee.activity.mine;

import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.mine.CodeOrderDetailsAdapter;
import com.ichuk.coffee.adapter.mine.OrderItemAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.CodeBean;
import com.ichuk.coffee.bean.OrderBean;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailsActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private RelativeLayout rlBottom;
    private TextView tvToPay;
    private TextView tvCancelOrder;
    private ImageView ivImage;
    private TextView tvStatus;
    private ImageView ivShopLogo;
    private TextView tvShopName;
    private RecyclerView rvCoffee;
    private TextView tvNumbering;
    private TextView tvPhone;
    private TextView tvTime;
    private LinearLayout llUseDiscount;
    private TextView tvDiscount;
    private LinearLayout llRealPay;
    private TextView tvRealPay;
    private LinearLayout llRefundNum;
    private TextView tvRefundNum;
    private LinearLayout llRefundAccount;
    private TextView tvRefundAccount;
    private OrderBean mOrderBean;
    //    private TextView tvTakeCupCode;
    private List<OrderBean> mList = new ArrayList<>();
    private AlertDialog mDialog;
    private RecyclerView rvCode;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
//        tvTakeCupCode = findViewById(R.id.tv_take_cup_code);
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        rlBottom = findViewById(R.id.rl_bottom);
        tvToPay = findViewById(R.id.tv_to_pay);
        tvCancelOrder = findViewById(R.id.tv_cancel_order);
        ivImage = findViewById(R.id.iv_image);
        tvStatus = findViewById(R.id.tv_status);
        ivShopLogo = findViewById(R.id.iv_shop_logo);
        tvShopName = findViewById(R.id.tv_shop_name);
        rvCoffee = findViewById(R.id.rv_coffee);
        tvNumbering = findViewById(R.id.tv_numbering);
        tvPhone = findViewById(R.id.tv_phone);
        tvTime = findViewById(R.id.tv_time);
        llUseDiscount = findViewById(R.id.ll_use_discount);
        tvDiscount = findViewById(R.id.tv_discount);
        llRealPay = findViewById(R.id.ll_real_pay);
        tvRealPay = findViewById(R.id.tv_real_pay);
        llRefundNum = findViewById(R.id.ll_refund_num);
        tvRefundNum = findViewById(R.id.tv_refund_num);
        llRefundAccount = findViewById(R.id.ll_refund_account);
        tvRefundAccount = findViewById(R.id.tv_refund_account);
        rvCode = findViewById(R.id.rv_code);
    }

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setOnClickListener(this);
    }

    /**
     * show dialog of refund tip
     */
    private void showRefundDialog(int type) {
        if (type == 0) {
            // can not to refund
            View view = LayoutInflater.from(context).inflate(R.layout.item_dialog_refund_failed, null);
            AlertDialog.Builder dialog = new AlertDialog.Builder(context);
            dialog.setView(view);
            mDialog = dialog.create();
            mDialog.show();
            ImageView ivEsc = view.findViewById(R.id.iv_esc);
            TextView tvPhone = view.findViewById(R.id.tv_phone);
            ivEsc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mDialog != null) {
                        mDialog.dismiss();
                    }
                }
            });
        } else {
            // can refund
            View view = LayoutInflater.from(context).inflate(R.layout.item_dialog_delete, null);
            AlertDialog.Builder dialog = new AlertDialog.Builder(context);
            dialog.setView(view);
            mDialog = dialog.create();
            mDialog.show();
            TextView tvTitle = view.findViewById(R.id.tv_title);
            TextView tvContent = view.findViewById(R.id.tv_content);
            TextView tvDeleteNo = view.findViewById(R.id.tv_delete_no);
            TextView tvDeleteYes = view.findViewById(R.id.tv_delete_yes);
            tvTitle.setVisibility(View.VISIBLE);
            tvContent.setText("亲，您可以推迟取咖啡哦，省的下次购买麻烦");
            tvDeleteNo.setText("坚决退款");
            tvDeleteYes.setText("还是不退款了");
            tvDeleteNo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mDialog != null) {
                        mDialog.dismiss();
                    }
                    toActivity(RefundActivity.class);
                }
            });
            tvDeleteYes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mDialog != null) {
                        mDialog.dismiss();
                    }
                }
            });
        }
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        setHeader();
        getData();
        showData();
        setRecyclerView();
    }

    /**
     * show data on widget
     */
    private void showData() {
        if (mOrderBean.getType() == 1) {
            tvStatus.setText("订单待付款");
            rlBottom.setVisibility(View.VISIBLE);
            tvCancelOrder.setVisibility(View.VISIBLE);
            tvToPay.setText("立即付款");
            tvCancelOrder.setText("取消订单");
            llRealPay.setVisibility(View.GONE);
            llRefundAccount.setVisibility(View.GONE);
            llRefundNum.setVisibility(View.GONE);
            llUseDiscount.setVisibility(View.GONE);
            rvCode.setVisibility(View.GONE);
//            tvTakeCupCode.setVisibility(View.GONE);
        } else if (mOrderBean.getType() == 2) {
            tvStatus.setText("订单未取杯");
            rlBottom.setVisibility(View.VISIBLE);
            tvCancelOrder.setVisibility(View.GONE);
            tvToPay.setText("申请退款");
            rvCode.setVisibility(View.VISIBLE);
//            tvTakeCupCode.setVisibility(View.VISIBLE);
//            String code = "取杯码：" + 1114;
//            tvTakeCupCode.setText(code);
            llRealPay.setVisibility(View.VISIBLE);
            llUseDiscount.setVisibility(View.VISIBLE);
            llRefundNum.setVisibility(View.GONE);
            llRefundAccount.setVisibility(View.GONE);
            tvToPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 判断条件
                    // 如果条件不符合
//                    if () {
//                        showRefundDialog(0);
//                    } else {
//
//                    }
                    // 如果条件符合
                    showRefundDialog(1);
//                    toActivity(RefundActivity.class);
                }
            });
        } else if (mOrderBean.getType() == 3) {
            tvStatus.setText("退款已完成");
            rlBottom.setVisibility(View.GONE);
            rvCode.setVisibility(View.VISIBLE);
//            String code = "取杯码：" + 1114;
//            tvTakeCupCode.setText(code);
            llRealPay.setVisibility(View.VISIBLE);
            llUseDiscount.setVisibility(View.VISIBLE);
            llRefundNum.setVisibility(View.VISIBLE);
            llRefundAccount.setVisibility(View.VISIBLE);
        }
        tvShopName.setText(mOrderBean.getShopName());
    }

    /**
     * set recyclerView
     */
    private void setRecyclerView() {
        rvCoffee.setLayoutManager(new LinearLayoutManager(context));
        OrderItemAdapter orderItemAdapter = new OrderItemAdapter(context, mOrderBean.getCoffeeBeanList());
        rvCoffee.setAdapter(orderItemAdapter);

        List<CodeBean> codeList = new ArrayList<>();
        CodeBean codeBean = new CodeBean();
        codeBean.setCode("取杯码1：1114");
        CodeBean codeBean1 = new CodeBean();
        codeBean1.setCode("取杯码2：1114");
        codeList.add(codeBean);
        codeList.add(codeBean1);
        rvCode.setLayoutManager(new LinearLayoutManager(context));
        int flag = 0;
        CodeOrderDetailsAdapter codeAdapter = new CodeOrderDetailsAdapter(context, codeList, flag);
        rvCode.setAdapter(codeAdapter);
    }

    /**
     * set header
     */
    private void setHeader() {
        tvHeaderTitle.setText(getResources().getString(R.string.order_detail));
        ivBack.setVisibility(View.VISIBLE);
    }

    /**
     * get data from intent
     */
    private void getData() {
        mOrderBean = (OrderBean) getIntent().getSerializableExtra("orderBean");
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_order_details;
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
