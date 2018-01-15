package com.ichuk.coffee.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.activity.discount.ExchangeCouponActivity;
import com.ichuk.coffee.activity.discount.GiftCardActivity;
import com.ichuk.coffee.activity.discount.HolidayActivity;
import com.ichuk.coffee.activity.discount.SecondHalfActivity;
import com.ichuk.coffee.base.BaseFragment;

/**
 * Created by xzh on 2017/12/4.
 *
 */

public class DiscountFragment extends BaseFragment implements View.OnClickListener {
    private TextView tvHeaderTitle;
    private LinearLayout llGiftCard;
    private LinearLayout llExchange;
    private LinearLayout llHoliday;
    private LinearLayout llSecondHalf;

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        setEvent();
    }

    /**
     * set event
     */
    private void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.discount));
        llGiftCard.setOnClickListener(this);
        llExchange.setOnClickListener(this);
        llHoliday.setOnClickListener(this);
        llSecondHalf.setOnClickListener(this);
    }

    /**
     *  findViewById
     */
    private void findViews() {
        if (getView() != null) {
            tvHeaderTitle = getView().findViewById(R.id.tv_header_title);
            llGiftCard = getView().findViewById(R.id.ll_gift_card);
            llExchange = getView().findViewById(R.id.ll_exchange);
            llHoliday = getView().findViewById(R.id.ll_holiday);
            llSecondHalf = getView().findViewById(R.id.ll_second_half);
        }
    }

    /**
     * load layout
     */
    @Override
    protected int getLayout() {
        return R.layout.fragment_discount;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_gift_card:
                toActivity(GiftCardActivity.class);
                break;
            case R.id.ll_exchange:
                toActivity(ExchangeCouponActivity.class);
                break;
            case R.id.ll_holiday:
                toActivity(HolidayActivity.class);
                break;
            case R.id.ll_second_half:
                toActivity(SecondHalfActivity.class);
                break;
        }
    }
}
