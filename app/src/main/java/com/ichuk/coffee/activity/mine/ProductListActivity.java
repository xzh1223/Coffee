package com.ichuk.coffee.activity.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.home.HomeAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.CoffeeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzh on 2017/12/14.
 *
 */

public class ProductListActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private RecyclerView rvProducts;
    private List<CoffeeBean> mList = new ArrayList<>();

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.product_list));
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
        CoffeeBean coffeeBean = new CoffeeBean();
        coffeeBean.setId(1);
        coffeeBean.setName("Coffee");
        coffeeBean.setImg(R.mipmap.ic_launcher);
        coffeeBean.setIngredient("浓缩咖啡、水");
        coffeeBean.setPrice("9.9");
        coffeeBean.setNum(1000);

        CoffeeBean coffeeBean2 = new CoffeeBean();
        coffeeBean2.setId(2);
        coffeeBean2.setName("Coffee");
        coffeeBean2.setImg(R.mipmap.ic_launcher);
        coffeeBean2.setIngredient("浓缩咖啡、水");
        coffeeBean2.setPrice("9.9");
        coffeeBean2.setNum(3000);

        mList.add(coffeeBean);
        mList.add(coffeeBean2);
    }

    /**
     *  set recycler view
     */
    private void setRecyclerView() {
        rvProducts.setLayoutManager(new LinearLayoutManager(context));
        HomeAdapter adapter = new HomeAdapter(context, mList);
        rvProducts.setAdapter(adapter);
    }

    /**
     *  initial view
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        rvProducts = findViewById(R.id.rv_products);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_product_list;
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
