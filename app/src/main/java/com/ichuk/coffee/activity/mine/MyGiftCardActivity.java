package com.ichuk.coffee.activity.mine;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.ViewPagerActivity;
import com.ichuk.coffee.fragment.mine.GiftCardAddedFragment;
import com.ichuk.coffee.fragment.mine.GiftCardNoAddedFragment;

public class MyGiftCardActivity extends ViewPagerActivity implements View.OnClickListener {

    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private TextView tvSave;
    private ViewPager vpGiftCard;
    private TextView tvAdded;
    private TextView tvNoAdded;
    private LinearLayout llIndicator;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvSave = findViewById(R.id.tv_save);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        vpGiftCard = findViewById(R.id.viewpager);
        tvAdded = findViewById(R.id.tv_1);
        tvNoAdded = findViewById(R.id.tv_2);
        llIndicator = findViewById(R.id.ll_indicator);
    }

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setOnClickListener(this);
        tvSave.setOnClickListener(this);
        tvAdded.setOnClickListener(this);
        tvNoAdded.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        setHeader();
        setViewPager(vpGiftCard, new GiftCardAddedFragment(), new GiftCardNoAddedFragment());
        initIndicator(llIndicator);
        setListener(vpGiftCard, tvAdded, tvNoAdded);
        setDefault();
    }

    /**
     *  set default selected
     */
    private void setDefault() {
        tvAdded.setText(getResources().getString(R.string.git_card_added));
        tvNoAdded.setText(getResources().getString(R.string.git_card_no_added));
        vpGiftCard.setCurrentItem(0);
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
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_my_gift_card;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_1:
               vpGiftCard.setCurrentItem(0);
                break;
            case R.id.tv_2:
                vpGiftCard.setCurrentItem(1);
                break;
            case R.id.tv_save:
                toActivity(TransactionDetailsActivity.class);
                break;
        }
    }
}

