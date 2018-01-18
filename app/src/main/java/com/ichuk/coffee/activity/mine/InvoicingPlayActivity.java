package com.ichuk.coffee.activity.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.InvoicingAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.MonthOrderBean;

import java.util.ArrayList;
import java.util.List;

public class InvoicingPlayActivity extends BaseActivity implements View.OnClickListener {
    private RelativeLayout rlBottom;
    private CheckBox checkboxAll;
    private TextView tvMoney;
    private Button btnNext;
    private RecyclerView rvOrder;
    private List<MonthOrderBean> mList = new ArrayList<>();
    private boolean isChecked = false;
    private ImageView ivBack;
    private TextView tvHeaderTitle;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        rlBottom = findViewById(R.id.rl_bottom);
        checkboxAll = findViewById(R.id.checkbox_all);
        tvMoney = findViewById(R.id.tv_money);
        btnNext = findViewById(R.id.btn_next);
        rvOrder = findViewById(R.id.rv_order);
    }

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.play_invoice));
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        checkboxAll.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        getData();
        setRecyclerView();
    }

    /**
     * get data from http request
     */
    private void getData() {
        MonthOrderBean.CoffeeBean coffeeBean = new MonthOrderBean.CoffeeBean();
        coffeeBean.setName("xxxxxxx");
        coffeeBean.setIngredient("xxxxxxxxxxxx");
        coffeeBean.setPrice("60.0");
        MonthOrderBean monthOrderBean = new MonthOrderBean();
        monthOrderBean.setYear("2017");
        monthOrderBean.setMonth("12月");
        monthOrderBean.getCoffeeBeanList().add(coffeeBean);
        monthOrderBean.getCoffeeBeanList().add(coffeeBean);

        mList.add(monthOrderBean);
    }

    /**
     * set recyclerView
     */
    private void setRecyclerView() {
        rvOrder.setLayoutManager(new LinearLayoutManager(context));
        InvoicingAdapter mAdapter = new InvoicingAdapter(context, mList, isChecked);
        rvOrder.setAdapter(mAdapter);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_invoicing;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_next:
                toActivity(InvoicingSubmitActivity.class);
                break;
            case R.id.checkbox_all:
                boolean isCheck = checkboxAll.isChecked();
                setCheckedAll(isCheck);
                break;
        }
    }

    /**
     * set all checked
     */
    private void setCheckedAll(boolean isCheck) {
        isChecked = isCheck;
        setRecyclerView();
    }

    /**
     * adapter to do
     */
    public void CheckedAll(boolean isChecked) {
        checkboxAll.setChecked(isChecked);
    }


}
