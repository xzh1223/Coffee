package com.ichuk.coffee.activity.mine;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.ViewPagerActivity;
import com.ichuk.coffee.bean.ExpensesRecordBean;
import com.ichuk.coffee.fragment.mine.BuyCardDetailsFragment;
import com.ichuk.coffee.fragment.mine.DonatedDetailsFragment;

import java.util.ArrayList;
import java.util.List;

public class TransactionDetailsActivity extends ViewPagerActivity implements View.OnClickListener {

    private TextView tvBuyCardDetails;
    private TextView tvDonatedDetails;
    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private int mStatus = 0;
    private ViewPager vpTransactionDetails;
    private List<ExpensesRecordBean> mList = new ArrayList<>();
    private LinearLayout llIndicator;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        tvBuyCardDetails = findViewById(R.id.tv_1);
        tvDonatedDetails = findViewById(R.id.tv_2);
        llIndicator = findViewById(R.id.ll_indicator);
        vpTransactionDetails = findViewById(R.id.viewpager);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setOnClickListener(this);
        tvBuyCardDetails.setOnClickListener(this);
        tvDonatedDetails.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        setHeader();
        setViewPager(vpTransactionDetails, new BuyCardDetailsFragment(), new DonatedDetailsFragment());
        initIndicator(llIndicator);
        setListener(vpTransactionDetails, tvBuyCardDetails, tvDonatedDetails);
        setDefault();
    }

    /**
     *  set default selected
     */
    private void setDefault() {
        tvBuyCardDetails.setText(getResources().getString(R.string.buy_card_details));
        tvDonatedDetails.setText(getResources().getString(R.string.donated_details));
        vpTransactionDetails.setCurrentItem(0);
    }

    /**
     *  set recyclerView
     */
    /*private void setRecyclerView() {
        rvTransactionDetails.setLayoutManager(new LinearLayoutManager(context));
        rvTransactionDetails.setAdapter(new ExpensesAdapter(context, mList));
    }*/

    /**
     *  get data from http
     */
    private void getData() {
        mList.clear();
        if (mStatus == 0) {
            ExpensesRecordBean expensesRecordBean = new ExpensesRecordBean();
            expensesRecordBean.setContent("Coffee (热) + 奶油");
            expensesRecordBean.setTime("2018-12-12");
            expensesRecordBean.setMoney("-30");
            mList.add(expensesRecordBean);
            mList.add(expensesRecordBean);
            mList.add(expensesRecordBean);
        } else if (mStatus == 1) {
            ExpensesRecordBean expensesRecordBean = new ExpensesRecordBean();
            expensesRecordBean.setContent("Coffee (热) + 奶油");
            expensesRecordBean.setTime("2018-12-12");
            expensesRecordBean.setMoney("-30");
            mList.add(expensesRecordBean);
            mList.add(expensesRecordBean);
            mList.add(expensesRecordBean);
        }
    }

    /**
     *  set header
     */
    private void setHeader() {
        ivBack.setVisibility(View.VISIBLE);
        tvHeaderTitle.setText(getResources().getString(R.string.transaction_details));
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_transaction_details;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_1:
                vpTransactionDetails.setCurrentItem(0);
                break;
            case R.id.tv_2:
                vpTransactionDetails.setCurrentItem(1);
                break;
        }
    }
}
