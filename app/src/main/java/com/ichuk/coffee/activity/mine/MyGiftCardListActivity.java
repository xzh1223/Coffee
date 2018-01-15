package com.ichuk.coffee.activity.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.MyGiftCardAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.MyGiftCardBean;

import java.util.ArrayList;
import java.util.List;

public class MyGiftCardListActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private RecyclerView rvGiftCard;
    private List<MyGiftCardBean> mList = new ArrayList<>();
    private int mStatus = 0;

    /**
     * initial view
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        rvGiftCard = findViewById(R.id.rv_gift_card);
    }

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        if (mStatus == 0) {
            tvHeaderTitle.setText(getResources().getString(R.string.my_gift_card));
        } else if (mStatus == 1) {
            tvHeaderTitle.setText(getResources().getString(R.string.buy_record));
        }
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
     * get data from request
     */
    private void getData() {
        String page = getIntent().getStringExtra("page");
        if ("card".equals(page)) {
            mStatus = 0;
        } else if ("record".equals(page)) {
            mStatus = 1;
        }
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
    }

    /**
     * set recyclerView
     */
    private void setRecyclerView() {
        rvGiftCard.setLayoutManager(new LinearLayoutManager(context));
        MyGiftCardAdapter adapter = new MyGiftCardAdapter(context, mList, mStatus);
        rvGiftCard.setAdapter(adapter);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_my_gift_card_list;
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
