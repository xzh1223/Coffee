package com.ichuk.coffee.fragment.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.mine.ExpensesAdapter;
import com.ichuk.coffee.base.BaseFragment;
import com.ichuk.coffee.bean.ExpensesRecordBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzh on 2018/1/23.
 */

public class DonatedDetailsFragment extends BaseFragment {
    private RecyclerView rvDonatedDetails;
    private List<ExpensesRecordBean> mList = new ArrayList<>();

    /**
     * load layout
     */
    @Override
    protected int getLayout() {
        return R.layout.fragment_gift_card_add;
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
        rvDonatedDetails.setLayoutManager(new LinearLayoutManager(context));
        rvDonatedDetails.setAdapter(new ExpensesAdapter(context, mList));
    }

    /**
     * get data from http
     */
    private void getData() {
        mList.clear();
        ExpensesRecordBean expensesRecordBean = new ExpensesRecordBean();
        expensesRecordBean.setContent("Coffee (热) + 奶油");
        expensesRecordBean.setTime("2018-12-12");
        expensesRecordBean.setMoney("-30");
        mList.add(expensesRecordBean);
        mList.add(expensesRecordBean);
        mList.add(expensesRecordBean);
    }

    /**
     * findViewById
     */
    private void findViews() {
        rvDonatedDetails = getView().findViewById(R.id.recycler_view);
    }
}
