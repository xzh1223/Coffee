package com.ichuk.coffee.activity.discount;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.GiftCardAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.GiftCardBean;

import java.util.ArrayList;
import java.util.List;

public class GiftCardActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private RecyclerView rvGiftCard;
    private List<GiftCardBean> mList = new ArrayList<>();

    private void findViews() {
        rvGiftCard = findViewById(R.id.rv_gift_card);
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
    }

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.buy_gift_card));
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
     * get data from http
     */
    private void getData() {
        GiftCardBean giftCardBean = new GiftCardBean();
        giftCardBean.setTitle("给最好的你");
        mList.add(giftCardBean);
        mList.add(giftCardBean);
        mList.add(giftCardBean);
        mList.add(giftCardBean);
        mList.add(giftCardBean);
    }

    /**
     * set recyclerView
     */
    private void setRecyclerView() {
        rvGiftCard.setFocusable(false);
        rvGiftCard.setLayoutManager(new GridLayoutManager(context, 2));
        GiftCardAdapter adapter = new GiftCardAdapter(context, mList);
        rvGiftCard.setAdapter(adapter);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_gift_card;
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
