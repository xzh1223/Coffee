package com.ichuk.coffee.activity.discount;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.SecondHalfAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.SecondHalfBean;

import java.util.ArrayList;
import java.util.List;

public class SecondHalfActivity extends BaseActivity {

    private ImageView ivLeft;
    private TextView tvTime;
    private RecyclerView rvCoffee;
    private List<SecondHalfBean> mList = new ArrayList<>();

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivLeft = findViewById(R.id.iv_left);
        tvTime = findViewById(R.id.tv_time);
        rvCoffee = findViewById(R.id.rv_coffee);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {

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
        SecondHalfBean secondHalfBean = new SecondHalfBean();
        secondHalfBean.setName("Coffee");
        secondHalfBean.setIngredient("成分： 速溶咖啡、水");
        secondHalfBean.setPrice("9.8");
        secondHalfBean.setSum(100);
        secondHalfBean.setNum(50);
        mList.add(secondHalfBean);
        mList.add(secondHalfBean);
        mList.add(secondHalfBean);
    }

    private void setRecyclerView() {
        rvCoffee.setLayoutManager(new LinearLayoutManager(context));
        rvCoffee.setAdapter(new SecondHalfAdapter(context, mList));
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_second_half;
    }
}
