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
import com.ichuk.coffee.adapter.OrderItemAdapter;
import com.ichuk.coffee.base.BaseActivity;
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
    private TextView tvTakeCupCode;
    private List<OrderBean> mList = new ArrayList<>();
    private AlertDialog mDialog;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        tvTakeCupCode = findViewById(R.id.tv_take_cup_code);
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
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.order_detail));
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
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
            tvTakeCupCode.setVisibility(View.GONE);
        } else if (mOrderBean.getType() == 2) {

            tvStatus.setText("订单待消费");
            rlBottom.setVisibility(View.VISIBLE);
            tvCancelOrder.setVisibility(View.GONE);
            tvToPay.setText("申请退款");
            tvTakeCupCode.setVisibility(View.VISIBLE);
            String code = "取杯码：" + 1114;
            tvTakeCupCode.setText(code);
            llRealPay.setVisibility(View.VISIBLE);
            llUseDiscount.setVisibility(View.VISIBLE);
            llRefundNum.setVisibility(View.GONE);
            llRefundAccount.setVisibility(View.GONE);
            tvToPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 判断条件
                    // 如果条件不符合
//                    showDialog();
                    // 如果条件符合
                     toActivity(RefundActivity.class);
                }
            });
        } else if (mOrderBean.getType() == 3) {
            tvStatus.setText("退款已完成");
            rlBottom.setVisibility(View.GONE);
            tvTakeCupCode.setVisibility(View.VISIBLE);
            String code = "取杯码：" + 1114;
            tvTakeCupCode.setText(code);
            llRealPay.setVisibility(View.VISIBLE);
            llUseDiscount.setVisibility(View.VISIBLE);
            llRefundNum.setVisibility(View.VISIBLE);
            llRefundAccount.setVisibility(View.VISIBLE);
        }
        tvShopName.setText(mOrderBean.getShopName());

        rvCoffee.setLayoutManager(new LinearLayoutManager(context));
        OrderItemAdapter orderItemAdapter = new OrderItemAdapter(context, mOrderBean.getCoffeeBeanList());
        rvCoffee.setAdapter(orderItemAdapter);
    }

    /**
     *  show dialog of refund tip
     */
    private void showDialog() {
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
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        getData();
    }

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
        switch (view.getId()){
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
