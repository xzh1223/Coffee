package com.ichuk.coffee.activity.discount;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.ExchangeAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.ExchangeCouponBean;

import java.util.ArrayList;
import java.util.List;

public class ExchangeCouponActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView rvExchange;
    private List<ExchangeCouponBean> mList = new ArrayList<>();
    private TextView tvHeaderTitle;
    private ImageView ivBack;
    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.q_x_q_y));
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
     *  get data from http
     */
    private void getData() {
        ExchangeCouponBean exchangeCouponBean = new ExchangeCouponBean();
        exchangeCouponBean.setMoney("2");
        exchangeCouponBean.setCondition("满50使用");
        exchangeCouponBean.setAddress("月亮湾商务广场店");
        exchangeCouponBean.setVip("全部会员");
        exchangeCouponBean.setStartTime("2017/12/18 09:30:00");
        exchangeCouponBean.setEndTime("2017/12/18 10:00:00");
        mList.add(exchangeCouponBean);
        mList.add(exchangeCouponBean);
        mList.add(exchangeCouponBean);
    }

    /**
     *  set recyclerView
     */
    private void setRecyclerView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        rvExchange.setLayoutManager(gridLayoutManager);
        ExchangeAdapter exchangeAdapter = new ExchangeAdapter(context, mList);
        rvExchange.setAdapter(exchangeAdapter);
    }

    /**
     *  findViewsById
     */
    private void findViews() {
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        ivBack = findViewById(R.id.iv_back);
        rvExchange = findViewById(R.id.rv_exchange);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_exchange_coupon;
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
