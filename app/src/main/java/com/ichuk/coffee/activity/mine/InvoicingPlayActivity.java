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
import com.ichuk.coffee.adapter.mine.InvoicingAdapter;
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
    private int mNum = 0;
    private double mAllMoney = 0;

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
        setHeader();
        getData();
        setRecyclerView();
    }

    /**
     * set header
     */
    private void setHeader() {
        ivBack.setVisibility(View.VISIBLE);
        tvHeaderTitle.setText(getResources().getString(R.string.play_invoice_by_order));
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

        MonthOrderBean.CoffeeBean coffeeBean1 = new MonthOrderBean.CoffeeBean();
        coffeeBean1.setName("xxxxxxx");
        coffeeBean1.setIngredient("xxxxxxxxxxxx");
        coffeeBean1.setPrice("50.0");
        MonthOrderBean monthOrderBean1 = new MonthOrderBean();
        monthOrderBean1.setYear("2017");
        monthOrderBean1.setMonth("11月");
        monthOrderBean1.getCoffeeBeanList().add(coffeeBean1);
        monthOrderBean1.getCoffeeBeanList().add(coffeeBean1);

        mList.add(monthOrderBean);
        mList.add(monthOrderBean1);
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
     * set all checked or unchecked
     *
     * @param isCheck
     */
    private void setCheckedAll(boolean isCheck) {
        if (isCheck) {
            for (int i = 0; i < mList.size(); i++) {
                for (int j = 0; j < mList.get(i).getCoffeeBeanList().size(); j++) {
                    mList.get(i).getCoffeeBeanList().get(j).isSelected = true;
                }
            }
        } else {
            for (int i = 0; i < mList.size(); i++) {
                for (int j = 0; j < mList.get(i).getCoffeeBeanList().size(); j++) {
                    mList.get(i).getCoffeeBeanList().get(j).isSelected = false;
                }
            }
        }
        countMoney();
        setRecyclerView();
    }

    /**
     * set selected
     */
    public void setSelected(int firstIndex, int secondIndex, boolean isSelected, MonthOrderBean.CoffeeBean coffee) {

        MonthOrderBean.CoffeeBean coffeeBean = new MonthOrderBean.CoffeeBean();
        coffeeBean.setNum(coffee.getNum());
        coffeeBean.setId(coffee.getId());
        coffeeBean.setImg(coffee.getImg());
        coffeeBean.setName(coffee.getName());
        coffeeBean.setPrice(coffee.getPrice());
        coffeeBean.setIngredient(coffee.getIngredient());
        coffeeBean.isSelected = isSelected;
        mList.get(firstIndex).getCoffeeBeanList().set(secondIndex, coffeeBean);

        countMoney();
        CheckedAll(isChecked);
        setRecyclerView();
    }

    /**
     *  count all price and show money
     */
    private void countMoney() {
        mNum = 0;
        mAllMoney = 0;
        int allNum = 0;
        for (int i = 0; i < mList.size(); i++) {
            for (int j = 0; j < mList.get(i).getCoffeeBeanList().size(); j++) {
                if (mList.get(i).getCoffeeBeanList().get(j).isSelected){
                    mNum++;
                    mAllMoney+= Double.valueOf(mList.get(i).getCoffeeBeanList().get(j).getPrice());
                }
                allNum++;
            }
        }
        if (mNum == allNum) {
            isChecked = true;
        } else {
            isChecked = false;
        }
        tvMoney.setText(mNum+"个订单 共" + mAllMoney + "元");
    }

    /**
     * adapter to do
     */
    public void CheckedAll(boolean isChecked) {
        checkboxAll.setChecked(isChecked);
    }

}
