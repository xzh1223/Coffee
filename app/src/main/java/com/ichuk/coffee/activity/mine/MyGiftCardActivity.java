package com.ichuk.coffee.activity.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.mine.MyGiftCardAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.MyGiftCardBean;

import java.util.ArrayList;
import java.util.List;

public class MyGiftCardActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private TextView tvAdded;
    private TextView tvNoAdded;
    private List<MyGiftCardBean> mList = new ArrayList<>();
    // 0 已添加 1 未添加
    private int mStatus = 0;
    private ImageView ivIndicator1;
    private ImageView ivIndicator2;
    private RecyclerView rvGiftCard;
    private MyGiftCardAdapter mAdapter;
    private TextView tvAddGiftCard;
    private TextView tvSave;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvSave = findViewById(R.id.tv_save);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        tvAdded = findViewById(R.id.tv_1);
        tvNoAdded = findViewById(R.id.tv_2);
        ivIndicator1 = findViewById(R.id.iv_indicator_1);
        ivIndicator2 = findViewById(R.id.iv_indicator_2);
        rvGiftCard = findViewById(R.id.rv_gift_card);
        tvAddGiftCard = findViewById(R.id.tv_add_gift_card);
    }

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setOnClickListener(this);
        tvAdded.setOnClickListener(this);
        tvNoAdded.setOnClickListener(this);
        tvAddGiftCard.setOnClickListener(this);
        tvSave.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        getData();
        setHeader();
        setRecyclerView();
        setCurrentItem(mStatus);
    }

    /**
     * set default selected
     */
    private void setCurrentItem(int position) {
        if (position == 0) {
            ivIndicator1.setBackgroundColor(getResources().getColor(R.color.brown));
            ivIndicator2.setBackgroundColor(getResources().getColor(R.color.md_white_1000));
            tvAdded.setTextColor(getResources().getColor(R.color.brown));
            tvNoAdded.setTextColor(getResources().getColor(R.color.md_grey_600));
            tvAddGiftCard.setVisibility(View.VISIBLE);
        } else if (position == 1) {
            ivIndicator2.setBackgroundColor(getResources().getColor(R.color.brown));
            ivIndicator1.setBackgroundColor(getResources().getColor(R.color.md_white_1000));
            tvAdded.setTextColor(getResources().getColor(R.color.md_grey_600));
            tvNoAdded.setTextColor(getResources().getColor(R.color.brown));
            tvAddGiftCard.setVisibility(View.GONE);
        }
    }

    /**
     * set recyclerView
     */
    private void setRecyclerView() {
        rvGiftCard.setLayoutManager(new LinearLayoutManager(context));
        mAdapter = new MyGiftCardAdapter(context, mList, mStatus);
        rvGiftCard.setAdapter(mAdapter);
    }


    /**
     * set header
     */
    private void setHeader() {
        tvHeaderTitle.setText(getResources().getString(R.string.my_gift_card));
        ivBack.setVisibility(View.VISIBLE);
        tvSave.setVisibility(View.VISIBLE);
        tvSave.setText(getResources().getString(R.string.transaction_details));
    }

    /**
     * get data from http
     */
    private void getData() {
        mList.clear();
        if (mStatus == 0) {
            MyGiftCardBean myGiftCardBean = new MyGiftCardBean();
            myGiftCardBean.setMoney("100");
            myGiftCardBean.setType(0);
            myGiftCardBean.setStatus(0);
            myGiftCardBean.setNumber("00001");
            myGiftCardBean.setPassword("123456");
            MyGiftCardBean myGiftCardBean2 = new MyGiftCardBean();
            myGiftCardBean2.setMoney("100");
            myGiftCardBean2.setType(1);
            myGiftCardBean2.setStatus(1);
            myGiftCardBean2.setNumber("00001");
            myGiftCardBean2.setPassword("123456");
            mList.add(myGiftCardBean);
            mList.add(myGiftCardBean2);
        } else if (mStatus == 1) {
            MyGiftCardBean myGiftCardBean = new MyGiftCardBean();
            myGiftCardBean.setMoney("100");
            myGiftCardBean.setAdded(1);
            myGiftCardBean.setType(0);
            myGiftCardBean.setStatus(0);
            myGiftCardBean.setNumber("00001");
            myGiftCardBean.setPassword("123456");
            MyGiftCardBean myGiftCardBean1 = new MyGiftCardBean();
            myGiftCardBean1.setMoney("100");
            myGiftCardBean1.setAdded(0);
            myGiftCardBean1.setType(1);
            myGiftCardBean1.setStatus(0);
            myGiftCardBean1.setNumber("00001");
            myGiftCardBean1.setPassword("123456");
            mList.add(myGiftCardBean);
            mList.add(myGiftCardBean1);
        }
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_my_gift_card;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ok:

                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_1:
                mStatus = 0;
                setCurrentItem(0);
                getData();
                setRecyclerView();
                break;
            case R.id.tv_2:
                mStatus = 1;
                setCurrentItem(1);
                getData();
                setRecyclerView();
                break;
            case R.id.tv_add_gift_card:
                toActivity(GiftCardAddActivity.class);
                break;
            case R.id.tv_save:
                toActivity(TransactionDetailsActivity.class);
                break;
        }
    }
}

