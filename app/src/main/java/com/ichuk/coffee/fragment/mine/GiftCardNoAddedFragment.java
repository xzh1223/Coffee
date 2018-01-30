package com.ichuk.coffee.fragment.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.mine.MyGiftCardAdapter;
import com.ichuk.coffee.base.BaseFragment;
import com.ichuk.coffee.bean.MyGiftCardBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzh on 2018/1/23.
 */

public class GiftCardNoAddedFragment extends BaseFragment {
    private TextView tvAddGiftCard;
    private RecyclerView rvGiftCard;
    private List<MyGiftCardBean> mList = new ArrayList<>();
    private int mStatus = 1;

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
        setEvent();
    }

    /**
     * set event
     */
    private void setEvent() {
        tvAddGiftCard.setVisibility(View.GONE);
    }

    /**
     * set recyclerView
     */
    private void setRecyclerView() {
        rvGiftCard.setLayoutManager(new LinearLayoutManager(context));
        rvGiftCard.setAdapter(new MyGiftCardAdapter(context, mList, mStatus));
    }

    /**
     * get data from http
     */
    private void getData() {
        mList.clear();
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

    /**
     * findViewById
     */
    private void findViews() {
        tvAddGiftCard = getView().findViewById(R.id.tv_add_gift_card);
        rvGiftCard = getView().findViewById(R.id.recycler_view);
    }
}
