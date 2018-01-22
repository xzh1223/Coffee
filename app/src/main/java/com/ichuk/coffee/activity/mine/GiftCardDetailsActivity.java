package com.ichuk.coffee.activity.mine;

import android.content.Intent;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;

public class GiftCardDetailsActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivImage;
    private TextView tvTitle;
    private TextView tvCardAccount;
    private TextView tvCardPassword;
    private TextView tvBuyMoney;
    private TextView tvLastMoney;
    private TextView tvGetOrigin;
    private TextView tvPayType;
    private TextView tvTime;
    private TextView tvHeaderTitle;
    private ImageView ivBack;
    private int mPage = 0;
    private TextView tvPayTypeKey;
    private TextView tvBuyTimeKey;
    private int mAdded = 0;
    private boolean isClicked = false;
    private int mType = 0;
    private TextView tvDonated;
    private TextView tvAdd;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        ivBack = findViewById(R.id.iv_back);
        tvDonated = findViewById(R.id.tv_donated);
        tvAdd = findViewById(R.id.tv_add);
        ivImage = findViewById(R.id.iv_image);
        tvTitle = findViewById(R.id.tv_title);
        tvCardAccount = findViewById(R.id.tv_card_account);
        tvCardPassword = findViewById(R.id.tv_card_password);
        tvBuyMoney = findViewById(R.id.tv_buy_money);
        tvLastMoney = findViewById(R.id.tv_last_money);
        tvGetOrigin = findViewById(R.id.tv_get_origin);
        tvPayType = findViewById(R.id.tv_pay_type);
        tvTime = findViewById(R.id.tv_time);
        tvPayTypeKey = findViewById(R.id.tv_pay_type_key);
        tvBuyTimeKey = findViewById(R.id.tv_buy_time_key);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setOnClickListener(this);
        tvDonated.setOnClickListener(this);
        tvAdd.setOnClickListener(this);
        tvCardPassword.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        getDataFromIntent();
        setHeader();
        getData();
        setData();
    }

    /**
     *  get data from intent
     */
    private void getDataFromIntent() {
        mPage = getIntent().getIntExtra("page", 0);
        mType = getIntent().getIntExtra("type", 0);
        mAdded = getIntent().getIntExtra("added", 0);
        if (mPage == 0) {
            if (mType == 0) {
                tvPayTypeKey.setText("支付方式");
                tvBuyTimeKey.setText("购买时间");
            } else {
                tvPayTypeKey.setText("赠送人");
                tvBuyTimeKey.setText("赠送时间");
            }
        } else {
            if (mType == 0) {
                tvPayTypeKey.setText("支付方式");
                tvBuyTimeKey.setText("购买时间");
                if (mAdded == 0) {
                    tvCardPassword.setText("1123");
                    tvCardPassword.getPaint().setFlags(0);
                    tvCardPassword.setTextColor(getResources().getColor(R.color.md_grey_600));
                    isClicked = false;
                } else {
                    tvCardPassword.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG);
                    tvCardPassword.setTextColor(getResources().getColor(R.color.red));
                    tvCardPassword.setText("请设置储值卡密码");
                    isClicked = true;
                }
            } else {
                tvPayTypeKey.setText("赠送人");
                tvBuyTimeKey.setText("赠送时间");
                tvAdd.setVisibility(View.VISIBLE);
            }
        }
        /*if (mAdded == 0) {
            tvCardPassword.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG);
            tvCardPassword.setTextColor(getResources().getColor(R.color.red));
            tvCardPassword.setText("请设置储值卡密码");
            isClicked = true;
        } else if (mAdded == 1){
            tvCardPassword.setText("1123");
            tvCardPassword.getPaint().setFlags(0);
            tvCardPassword.setTextColor(getResources().getColor(R.color.md_grey_600));
            isClicked = false;
        }
        if (mPage == 0) {
            tvPayTypeKey.setText("支付方式");
            tvBuyTimeKey.setText("购买时间");
        } else {
            tvPayTypeKey.setText("赠送人");
            tvBuyTimeKey.setText("赠送时间");
        }*/
    }

    /**
     * set data into widget
     */
    private void setData() {

    }

    /**
     * get data from http
     */
    private void getData() {

    }

    /**
     *  set header
     */
    private void setHeader() {
        ivBack.setVisibility(View.VISIBLE);
        tvHeaderTitle.setText(getResources().getString(R.string.gift_card_details));
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_gift_card_details;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_donated: {
                Intent intent = new Intent(context, DonatedActivity.class);
                intent.putExtra("page", "储值卡");
                startActivity(intent);
                break;
            }
            case R.id.tv_card_password:
                if (isClicked) {
                    Intent intent = new Intent(context, GiftCardAddActivity.class);
                    intent.putExtra("card_code", "123124124");
                    startActivity(intent);
                }
                break;
            case R.id.tv_add:

                break;
        }
    }
}
