package com.ichuk.coffee.activity.discount;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.SecondHalfAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.SecondHalfBean;

import java.util.ArrayList;
import java.util.List;

public class SecondHalfActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivLeft;
    private TextView tvTime;
    private RecyclerView rvCoffee;
    private List<SecondHalfBean> mList = new ArrayList<>();
    private TextView tvHeaderTitle;
    private ImageView ivBack;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivLeft = findViewById(R.id.iv_left);
        tvTime = findViewById(R.id.tv_time);
        rvCoffee = findViewById(R.id.rv_coffee);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        ivBack = findViewById(R.id.iv_back);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setOnClickListener(this);
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
     *  set header
     */
    private void setHeader() {
        ivBack.setVisibility(View.VISIBLE);
        tvHeaderTitle.setText(getResources().getString(R.string.second_half_price));
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
