package com.ichuk.coffee.activity.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.mine.MyCouponAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.CouponBean;

import java.util.ArrayList;
import java.util.List;

public class MyCouponActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private TextView tvUnused;
    private TextView tvUsed;
    private TextView tvExpired;
    private View vUnused;
    private View vUsed;
    private View vExpired;
    private RecyclerView rvCoupon;
    private int mPosition = 0;
    private List<CouponBean> mList = new ArrayList<>();
    private MyCouponAdapter mAdapter;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        tvUnused = findViewById(R.id.tv_unused);
        tvUsed = findViewById(R.id.tv_used);
        tvExpired = findViewById(R.id.tv_expired);
        vUnused = findViewById(R.id.v_unused);
        vUsed = findViewById(R.id.v_used);
        vExpired = findViewById(R.id.v_expired);
        rvCoupon = findViewById(R.id.rv_coupon);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setOnClickListener(this);
        tvUnused.setOnClickListener(this);
        tvUsed.setOnClickListener(this);
        tvExpired.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        setHeader();
        setRecyclerView();
        checkShow(mPosition);
    }

    /**
     *  set header
     */
    private void setHeader() {
        tvHeaderTitle.setText(getResources().getString(R.string.my_coupon));
        ivBack.setVisibility(View.VISIBLE);
    }

    /**
     * set recyclerView
     */
    private void setRecyclerView() {
        rvCoupon.setLayoutManager(new LinearLayoutManager(context));
        mAdapter = new MyCouponAdapter(context, mList);
        rvCoupon.setAdapter(mAdapter);
    }

    /**
     * check to show
     */
    private void checkShow(int position) {
        setDefault();
        setSelected(position);
        getData(position);
    }

    /**
     * set clicked status
     */
    private void setSelected(int position) {
        switch (position) {
            case 0:
                tvUnused.setTextColor(getResources().getColor(R.color.brown));
                vUnused.setBackgroundColor(getResources().getColor(R.color.brown));
                break;
            case 1:
                tvUsed.setTextColor(getResources().getColor(R.color.brown));
                vUsed.setBackgroundColor(getResources().getColor(R.color.brown));
                break;
            case 2:
                tvExpired.setTextColor(getResources().getColor(R.color.brown));
                vExpired.setBackgroundColor(getResources().getColor(R.color.brown));
                break;
        }

    }

    /**
     * get data from request
     */
    private void getData(int position) {
        if (mList.size() > 0) {
            mList.clear();
        }
        switch (position) {
            case 0: {
                CouponBean couponBean = new CouponBean();
                couponBean.setMoney("￥2");
                couponBean.setStatus(0);
                couponBean.setLimit("全部商品可用");
                couponBean.setTitle("苏州工业园区月亮湾商业广场优惠券");
                couponBean.setTime("2017-12-14 23:59前可使用");
                mList.add(couponBean);
                mList.add(couponBean);
                break;
            }
            case 1: {
                CouponBean couponBean = new CouponBean();
                couponBean.setMoney("￥2");
                couponBean.setStatus(1);
                couponBean.setLimit("全部商品可用");
                couponBean.setTitle("苏州工业园区月亮湾商业广场优惠券");
                couponBean.setTime("2017-12-14 23:59前可使用");
                mList.add(couponBean);
                mList.add(couponBean);
                break;
            }
            case 2: {
                CouponBean couponBean = new CouponBean();
                couponBean.setMoney("￥2");
                couponBean.setStatus(2);
                couponBean.setLimit("全部商品可用");
                couponBean.setTitle("苏州工业园区月亮湾商业广场优惠券");
                couponBean.setTime("2017-12-13 23:59前可使用");
                mList.add(couponBean);
                mList.add(couponBean);
                break;
            }
        }
        mAdapter.notifyDataSetChanged();
    }

    /**
     * set default status
     */
    private void setDefault() {
        tvUnused.setTextColor(getResources().getColor(R.color.md_grey_600));
        tvUsed.setTextColor(getResources().getColor(R.color.md_grey_600));
        tvExpired.setTextColor(getResources().getColor(R.color.md_grey_600));
        vUnused.setBackgroundColor(getResources().getColor(R.color.md_white_1000));
        vUsed.setBackgroundColor(getResources().getColor(R.color.md_white_1000));
        vExpired.setBackgroundColor(getResources().getColor(R.color.md_white_1000));
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_my_coupon;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_unused:
                if (mPosition != 0) {
                    mPosition = 0;
                    checkShow(mPosition);
                }
                break;
            case R.id.tv_used:
                if (mPosition != 1) {
                    mPosition = 1;
                    checkShow(mPosition);
                }
                break;
            case R.id.tv_expired:
                if (mPosition != 2) {
                    mPosition = 2;
                    checkShow(mPosition);
                }
                break;
        }
    }
}
