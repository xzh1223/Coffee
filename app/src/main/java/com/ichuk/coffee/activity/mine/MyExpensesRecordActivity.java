package com.ichuk.coffee.activity.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.ExpensesAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.ExpensesRecordBean;

import java.util.ArrayList;
import java.util.List;

public class MyExpensesRecordActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private RecyclerView rvExpenses;
    private List<ExpensesRecordBean> mList = new ArrayList<>();

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.my_consume_record));
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
        ExpensesRecordBean expensesRecordBean = new ExpensesRecordBean();
        expensesRecordBean.setContent("Coffee (热) + 奶油");
        expensesRecordBean.setTime("2018-12-12");
        expensesRecordBean.setMoney("-30");
        mList.add(expensesRecordBean);
        mList.add(expensesRecordBean);
        mList.add(expensesRecordBean);
    }

    /**
     *  set recyclerView
     */
    private void setRecyclerView() {

        rvExpenses.setLayoutManager(new LinearLayoutManager(context));
        rvExpenses.setAdapter(new ExpensesAdapter(context, mList));
    }

    /**
     *  findViewById
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        rvExpenses = findViewById(R.id.rv_expenses);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_my_expenses_record;
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
