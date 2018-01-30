package com.ichuk.coffee.activity.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.mine.ExpensesAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.ExpensesRecordBean;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyExpensesRecordActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private RecyclerView rvExpenses;
    private List<ExpensesRecordBean> mList = new ArrayList<>();
    private RelativeLayout rlTree;
    private ImageView ivTree;
    private CircleImageView civAccountPic;
    private TextView tvShoppingNum;
    private int mCondition = 1;

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
        showPicture();
        setRecyclerView();
    }

    /**
     *  show tree by condition
     */
    private void showPicture() {
        switch (mCondition) {
            case 1:
                rlTree.setBackgroundResource(R.mipmap.icon_bg_1_2);
                ivTree.setImageResource(R.mipmap.icon_tree_1);
                break;
            case 2:
                rlTree.setBackgroundResource(R.mipmap.icon_bg_1_2);
                ivTree.setImageResource(R.mipmap.icon_tree_2);
                break;
            case 3:
                rlTree.setBackgroundResource(R.mipmap.icon_bg_3_5);
                ivTree.setImageResource(R.mipmap.icon_tree_3);
                break;
            case 4:
                rlTree.setBackgroundResource(R.mipmap.icon_bg_3_5);
                ivTree.setImageResource(R.mipmap.icon_tree_4);
                break;
            case 5:
                rlTree.setBackgroundResource(R.mipmap.icon_bg_3_5);
                ivTree.setImageResource(R.mipmap.icon_tree_5);
                break;
        }
    }

    /**
     * get data from http
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
     * set recyclerView
     */
    private void setRecyclerView() {
        rvExpenses.setLayoutManager(new LinearLayoutManager(context));
        rvExpenses.setAdapter(new ExpensesAdapter(context, mList));
    }

    /**
     * findViewById
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        rvExpenses = findViewById(R.id.rv_expenses);
        rlTree = findViewById(R.id.rl_tree);
        ivTree = findViewById(R.id.iv_tree);
        civAccountPic = findViewById(R.id.civ_account_pic);
        tvShoppingNum = findViewById(R.id.tv_shopping_num);
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
