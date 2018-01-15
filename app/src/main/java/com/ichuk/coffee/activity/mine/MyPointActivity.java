package com.ichuk.coffee.activity.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.PointAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.PointBean;

import java.util.ArrayList;
import java.util.List;

public class MyPointActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private LinearLayout llPoint;
    private TextView tvPointValue;
    private LinearLayout llRecord;
    private RecyclerView rvPointExchange;
    private List<PointBean.CoffeeBean> mList = new ArrayList<>();

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        llPoint = findViewById(R.id.ll_point);
        tvPointValue = findViewById(R.id.tv_point_value);
        llRecord = findViewById(R.id.ll_record);
        rvPointExchange = findViewById(R.id.rv_point_exchange);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.my_point));
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
     * set recyclerView
     */
    private void setRecyclerView() {
        rvPointExchange.setLayoutManager(new LinearLayoutManager(context));
        PointAdapter adapter = new PointAdapter(context, mList);
        rvPointExchange.setAdapter(adapter);
    }

    /**
     * get data from request
     */
    private void getData() {
        PointBean pointBean = new PointBean();
        pointBean.setPoint("88");
        PointBean.CoffeeBean coffeeBean = new PointBean.CoffeeBean();
        coffeeBean.setImg(R.mipmap.ic_launcher);
        coffeeBean.setIngredient("速溶咖啡、水");
        coffeeBean.setName("Coffee");
        coffeeBean.setPrice("10积分");
        pointBean.getCoffeeBeanList().add(coffeeBean);
        pointBean.getCoffeeBeanList().add(coffeeBean);
        pointBean.getCoffeeBeanList().add(coffeeBean);
        pointBean.getCoffeeBeanList().add(coffeeBean);
        mList = pointBean.getCoffeeBeanList();
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_my_point;
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
