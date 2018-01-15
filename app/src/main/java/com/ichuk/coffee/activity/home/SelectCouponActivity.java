package com.ichuk.coffee.activity.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.home.SelectAllowanceAdapter;
import com.ichuk.coffee.adapter.home.SelectCouponAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.AllowanceBean;
import com.ichuk.coffee.bean.CouponBean;

import java.util.ArrayList;
import java.util.List;

public class SelectCouponActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvSelectText1;
    private ImageView ivCheck;
    private TextView tvSelectText2;
    private RecyclerView rvCoupon;
    private String mPage;
    private int mFlag = 0;
    private TextView tvHeaderTitle;
    private ImageView ivBack;
    private SelectCouponAdapter selectCouponAdapter;
    private SelectAllowanceAdapter selectAllowanceAdapter;
    List<AllowanceBean> allowanceBeanList = new ArrayList<>();
    List<CouponBean> couponBeanList = new ArrayList<>();
    private int mPosition = -1;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        tvSelectText1 = findViewById(R.id.tv_select_text_1);
        ivCheck = findViewById(R.id.iv_check);
        tvSelectText2 = findViewById(R.id.tv_select_text_2);
        rvCoupon = findViewById(R.id.rv_coupon);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        ivBack = findViewById(R.id.iv_back);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        ivCheck.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        mPage = getIntent().getStringExtra("page");
        findViews();
        checkToShow();
        getData();
        setRecyclerView();
    }

    /**
     * check to show by intent
     */
    private void checkToShow() {
        if ("coupon".equals(mPage)) {
            mFlag = 0;
            tvSelectText1.setText("不使用优惠券");
            tvSelectText2.setText("个优惠券可用");
            tvHeaderTitle.setText("选择优惠券");
        } else if ("allowance".equals(mPage)) {
            mFlag = 1;
            tvSelectText1.setText("不使用补贴");
            tvSelectText2.setText("个补贴可用");
            tvHeaderTitle.setText("选择补贴");
        }
    }

    /**
     * get data from intent or http
     */
    private void getData() {
        if (mFlag == 0) {
            couponBeanList.clear();
            CouponBean couponBean = new CouponBean();
            couponBean.setMoney("￥2");
            couponBean.setTime("2017-12-18 00:00:00前使用");
            couponBean.setTitle("苏州工业园区月亮湾商业广场使用优惠券");
            couponBean.setLimit("满50元使用");
            couponBeanList.add(couponBean);
            couponBeanList.add(couponBean);
        } else if (mFlag == 1) {
            allowanceBeanList.clear();
            AllowanceBean allowanceBean = new AllowanceBean();
            allowanceBean.setMoney("￥2");
            allowanceBean.setTime("2017-12-18 00:00:00前使用");
            allowanceBean.setTitle("银联卡补贴");
            allowanceBean.setLimit("全场通用");
            allowanceBeanList.add(allowanceBean);
            allowanceBeanList.add(allowanceBean);
        }
    }

    /**
     * get data from http
     */
    private void setRecyclerView() {
        rvCoupon.setLayoutManager(new LinearLayoutManager(context));
        if (mFlag == 0) {
            selectCouponAdapter = new SelectCouponAdapter(context, couponBeanList, mPosition);
            rvCoupon.setAdapter(selectCouponAdapter);
        } else if (mFlag == 1) {
            selectAllowanceAdapter = new SelectAllowanceAdapter(context, allowanceBeanList, mPosition);
            rvCoupon.setAdapter(selectAllowanceAdapter);
        }

    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_select_coupon;
    }

    /**
     * status for  use  coupon
     */
    public void setSelected(int position) {
        ivCheck.setImageResource(R.mipmap.icon_no_selected);
        mPosition = position;
        setRecyclerView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_check:
                if (mFlag == 0) {
                    for (int i = 0; i < couponBeanList.size(); i++) {
                        couponBeanList.get(i).isSelected = false;
                    }
                } else if (mFlag == 1) {
                    for (int i = 0; i < allowanceBeanList.size(); i++) {
                        allowanceBeanList.get(i).isSelected = false;
                    }
                }
                mPosition = -1;
                setRecyclerView();
                ivCheck.setImageResource(R.mipmap.icon_selected);
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
