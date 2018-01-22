package com.ichuk.coffee.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.new_products.NewProductsAdapter;
import com.ichuk.coffee.base.BaseFragment;
import com.ichuk.coffee.bean.NewProductsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzh on 2017/12/4.
 *
 */

public class NewProductsFragment extends BaseFragment {

    private RecyclerView rvNewProducts;
    private List<NewProductsBean> mList = new ArrayList<>();
    private TextView rvHeaderTitle;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        if (getView() != null) {
            rvNewProducts = getView().findViewById(R.id.rv_new_products);
            rvHeaderTitle = getView().findViewById(R.id.tv_header_title);
        }
    }


    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        getData();
        setRecyclerView();
        rvHeaderTitle.setText(getResources().getString(R.string.new_products));
    }

    /**
     * get data from http
     */
    private void getData() {
        NewProductsBean newProductsBean = new NewProductsBean();
        newProductsBean.setInfo("拿铁");
        newProductsBean.setPrice("9.8");
        mList.add(newProductsBean);
        mList.add(newProductsBean);
    }

    /**
     * set recyclerView
     */
    private void setRecyclerView() {
        rvNewProducts.setLayoutManager(new LinearLayoutManager(context));
        NewProductsAdapter mAdapter = new NewProductsAdapter(context, mList);
        rvNewProducts.setAdapter(mAdapter);
    }

    /**
     * load layout
     */
    @Override
    protected int getLayout() {
        return R.layout.fragment_new_products;
    }
}
