package com.ichuk.coffee.activity.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.mine.OrderAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.CoffeeBean;
import com.ichuk.coffee.bean.OrderBean;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvOrderAll;
    private TextView tvOrderPendingPayment;
    private TextView tvOrderUsable;
    private TextView tvOrderRefund;
    private RecyclerView rvOrder;
    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private List<OrderBean> mList = new ArrayList<>();
    private int mFlag = -1;
    private static final String TAG = "OrderActivity";
    private View vAll;
    private View vPendingPayment;
    private View vUsable;
    private View vRefund;
    private OrderAdapter mAdapter;
    private TextView tvSave;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvSave = findViewById(R.id.tv_save);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        tvOrderAll = findViewById(R.id.tv_order_all);
        tvOrderPendingPayment = findViewById(R.id.tv_order_pending_payment);
        tvOrderUsable = findViewById(R.id.tv_order_usable);
        tvOrderRefund = findViewById(R.id.tv_order_refund);
        rvOrder = findViewById(R.id.rv_order);
        vAll = findViewById(R.id.v_all);
        vPendingPayment = findViewById(R.id.v_pending_payment);
        vUsable = findViewById(R.id.v_usable);
        vRefund = findViewById(R.id.v_refund);

    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setOnClickListener(this);
        tvOrderAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDefault();
                tvOrderAll.setTextColor(getResources().getColor(R.color.brown));
                vAll.setBackgroundColor(getResources().getColor(R.color.brown));
                getData(0);
                mAdapter.notifyDataSetChanged();
                tvSave.setVisibility(View.VISIBLE);
            }
        });
        tvOrderPendingPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDefault();
                tvOrderPendingPayment.setTextColor(getResources().getColor(R.color.brown));
                vPendingPayment.setBackgroundColor(getResources().getColor(R.color.brown));
                getData(1);
                mAdapter.notifyDataSetChanged();
            }
        });
        tvOrderUsable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDefault();
                tvOrderUsable.setTextColor(getResources().getColor(R.color.brown));
                vUsable.setBackgroundColor(getResources().getColor(R.color.brown));
                getData(2);
                mAdapter.notifyDataSetChanged();
            }
        });
        tvOrderRefund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDefault();
                tvOrderRefund.setTextColor(getResources().getColor(R.color.brown));
                vRefund.setBackgroundColor(getResources().getColor(R.color.brown));
                getData(3);
                mAdapter.notifyDataSetChanged();
            }
        });
        tvSave.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        setHeader();
        checkShow();
        setRecyclerView();
    }

    /**
     * set header
     */
    private void setHeader() {
        tvHeaderTitle.setText(getResources().getString(R.string.my_order));
        tvSave.setText(getResources().getString(R.string.play_invoice));
        ivBack.setVisibility(View.VISIBLE);
    }

    /**
     * show and update status by flag
     */
    private void checkShow() {
        setDefault();
        mFlag = getIntent().getIntExtra("flag", -1);
        if (mFlag == 0) {
            // all
            tvOrderAll.setTextColor(getResources().getColor(R.color.brown));
            vAll.setBackgroundColor(getResources().getColor(R.color.brown));
            tvSave.setVisibility(View.VISIBLE);
        } else if (mFlag == 1) {
            // 待付
            tvOrderPendingPayment.setTextColor(getResources().getColor(R.color.brown));
            vPendingPayment.setBackgroundColor(getResources().getColor(R.color.brown));
        } else if (mFlag == 2) {
            // 可使用
            tvOrderUsable.setTextColor(getResources().getColor(R.color.brown));
            vUsable.setBackgroundColor(getResources().getColor(R.color.brown));
        } else if (mFlag == 3) {
            // 退款
            tvOrderRefund.setTextColor(getResources().getColor(R.color.brown));
            vRefund.setBackgroundColor(getResources().getColor(R.color.brown));
        }
        getData(mFlag);
    }

    /**
     * set default status
     */
    private void setDefault() {
        tvOrderAll.setTextColor(getResources().getColor(R.color.md_grey_600));
        tvOrderPendingPayment.setTextColor(getResources().getColor(R.color.md_grey_600));
        tvOrderUsable.setTextColor(getResources().getColor(R.color.md_grey_600));
        tvOrderRefund.setTextColor(getResources().getColor(R.color.md_grey_600));
        vAll.setBackgroundColor(getResources().getColor(R.color.md_white_1000));
        vPendingPayment.setBackgroundColor(getResources().getColor(R.color.md_white_1000));
        vUsable.setBackgroundColor(getResources().getColor(R.color.md_white_1000));
        vRefund.setBackgroundColor(getResources().getColor(R.color.md_white_1000));
        tvSave.setVisibility(View.GONE);
    }

    /**
     * get data from http request
     */
    private void getData(int index) {
        mList.clear();
        if (index == 0) {
            CoffeeBean coffeeBean = new CoffeeBean();
            coffeeBean.setName("拿铁");
            coffeeBean.setNum(1);
            coffeeBean.setPrice("9.8");
            coffeeBean.setIngredient("规格：xxxxxx");
            OrderBean orderBean = new OrderBean();
            orderBean.setShopName("咖啡");
            orderBean.setType(0);
            orderBean.getCoffeeBeanList().add(coffeeBean);
            orderBean.getCoffeeBeanList().add(coffeeBean);
            mList.add(orderBean);
        } else if (index == 1) {
            CoffeeBean coffeeBean = new CoffeeBean();
            coffeeBean.setName("Coffee");
            coffeeBean.setNum(1);
            coffeeBean.setPrice("8.8");
            coffeeBean.setIngredient("规格：xxxxxx");
            OrderBean orderBean = new OrderBean();
            orderBean.setShopName("星巴克");
            orderBean.setType(1);
            orderBean.getCoffeeBeanList().add(coffeeBean);
            mList.add(orderBean);
        } else if (index == 2) {
            CoffeeBean coffeeBean = new CoffeeBean();
            coffeeBean.setName("Coffee");
            coffeeBean.setNum(1);
            coffeeBean.setPrice("8.8");
            coffeeBean.setIngredient("规格：xxxxxx");
            OrderBean orderBean = new OrderBean();
            orderBean.setShopName("星巴克");
            orderBean.setType(2);
            orderBean.getCoffeeBeanList().add(coffeeBean);
            mList.add(orderBean);
        }else if (index == 3) {
            CoffeeBean coffeeBean = new CoffeeBean();
            coffeeBean.setName("Coffee");
            coffeeBean.setNum(1);
            coffeeBean.setPrice("8.8");
            coffeeBean.setIngredient("规格：xxxxxx");
            OrderBean orderBean = new OrderBean();
            orderBean.setShopName("星巴克");
            orderBean.setType(3);
            orderBean.getCoffeeBeanList().add(coffeeBean);
            mList.add(orderBean);
        }
    }

    /**
     * set recycler view
     */
    private void setRecyclerView() {
        rvOrder.setLayoutManager(new LinearLayoutManager(context));
        mAdapter = new OrderAdapter(context, mList);
        rvOrder.setAdapter(mAdapter);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_order;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_save:
                toActivity(InvoicingActivity.class);
                break;
        }
    }
}
