package com.ichuk.coffee.activity.discount;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.discount.HolidayCouponAdapter;
import com.ichuk.coffee.adapter.home.HomeAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.CoffeeBean;
import com.ichuk.coffee.bean.HolidayCouponBean;

import java.util.ArrayList;
import java.util.List;

public class HolidayActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private ImageView ivImage;
    private RecyclerView rvCoupon;
    private RecyclerView rvCoffee;
    private List<HolidayCouponBean> mCouponList = new ArrayList<>();
    private List<CoffeeBean> mCoffeeList = new ArrayList<>();

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        ivImage = findViewById(R.id.iv_image);
        rvCoupon = findViewById(R.id.rv_coupon);
        rvCoffee = findViewById(R.id.rv_coffee);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.holiday));
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
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
     * get data from http
     */
    private void getData() {
        {
            HolidayCouponBean holidayCouponBean = new HolidayCouponBean();
            holidayCouponBean.setMoney("3");
            holidayCouponBean.setCondition("满20元使用");
            mCouponList.add(holidayCouponBean);
            mCouponList.add(holidayCouponBean);
        }
        {
            CoffeeBean coffeeBean = new CoffeeBean();
            coffeeBean.setId(1);
            coffeeBean.setName("Coffee");
            coffeeBean.setImg(R.mipmap.ic_launcher);
            coffeeBean.setIngredient("浓缩咖啡、水");
            coffeeBean.setPrice("9.9");
            coffeeBean.setNum(1000);
            mCoffeeList.add(coffeeBean);
            mCoffeeList.add(coffeeBean);
            mCoffeeList.add(coffeeBean);
            mCoffeeList.add(coffeeBean);
            mCoffeeList.add(coffeeBean);
        }
    }

    /**
     * set recyclerView
     */
    private void setRecyclerView() {
        {
            LinearLayoutManager manager = new LinearLayoutManager(context);
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            rvCoupon.setLayoutManager(manager);
            rvCoupon.setAdapter(new HolidayCouponAdapter(context, mCouponList));
        }
        {
            rvCoffee.setLayoutManager(new LinearLayoutManager(context));
            rvCoffee.setAdapter(new HomeAdapter(context, mCoffeeList));
        }

    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_holiday;
    }

    @Override
    public void onClick(View view) {
        if (view == ivBack) {
            finish();
        }
    }
}
