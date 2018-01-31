package com.ichuk.coffee.activity.discount;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.activity.WebActivity;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.GiftCardBean;
import com.ichuk.coffee.utils.ToastUtil;
import com.ichuk.coffee.widget.AddOrLessView;

public class GiftCardBuyActivity extends BaseActivity implements View.OnClickListener, AddOrLessView.TextChangedListener {

    private TextView tvHeaderTitle;
    private ImageView ivBack;
    private ImageView ivImage;
    private TextView tvTitle;
    private TextView tvMoney;
    private AddOrLessView addOrLess;
    private ImageView ivWx;
    private TextView tvWxKey;
    private ImageView ivCheckWx;
    private ImageView ivZfb;
    private TextView tvZfbKey;
    private ImageView ivCheckZfb;
    private TextView tvPayOther;
    private TextView tvPayMine;
    private GiftCardBean mGiftCardBean;
    private int mNum = 1;
    private int price;
    private int mMoney = 0;
    private boolean mMethod = true;
    private CheckBox cbRule;
    private TextView tvAgreement;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        ivBack = findViewById(R.id.iv_back);
        ivImage = findViewById(R.id.iv_image);
        tvTitle = findViewById(R.id.tv_title);
        tvMoney = findViewById(R.id.tv_money);
        addOrLess = findViewById(R.id.add_or_less);
        ivWx = findViewById(R.id.iv_wx);
        tvWxKey = findViewById(R.id.tv_wx_key);
        ivCheckWx = findViewById(R.id.iv_check_wx);
        ivZfb = findViewById(R.id.iv_zfb);
        tvZfbKey = findViewById(R.id.tv_zfb_key);
        ivCheckZfb = findViewById(R.id.iv_check_zfb);
        cbRule = findViewById(R.id.cb_rule);
        tvPayOther = findViewById(R.id.tv_pay_other);
        tvPayMine = findViewById(R.id.tv_pay_mine);
        tvAgreement = findViewById(R.id.tv_agreement);
    }

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        addOrLess.setFlag(1);
        addOrLess.setText("1");
        String moneyStr = "￥" + price;
        tvMoney.setText(moneyStr);
        addOrLess.setTextChangedListener(this);
        ivBack.setOnClickListener(this);
        ivCheckWx.setOnClickListener(this);
        ivCheckZfb.setOnClickListener(this);
        tvPayMine.setOnClickListener(this);
        tvPayOther.setOnClickListener(this);
        tvAgreement.setOnClickListener(this);

    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        setHeader();
        getData();
        checkMethod(1);
        setMoney();
    }

    /**
     *  set header
     */
    private void setHeader() {
        tvHeaderTitle.setText(getResources().getString(R.string.ok_buy));
        ivBack.setVisibility(View.VISIBLE);
    }

    private void setMoney() {
        mMoney = mNum * price;
        String mineStr = "给自己购买￥" + mMoney;
        String otherStr = "给他人购买￥" + mMoney;
        tvPayMine.setText(mineStr);
        tvPayOther.setText(otherStr);
    }

    /**
     * get data from intent and http
     */
    private void getData() {
        mGiftCardBean = (GiftCardBean) getIntent().getSerializableExtra("bean");
        price = 300;
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_gift_card_buy;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_check_wx:
                if (mMethod) {
                    checkMethod(1);
                } else {
                    checkMethod(2);
                }
                break;
            case R.id.iv_check_zfb:
                if (!mMethod) {
                    checkMethod(1);
                } else {
                    checkMethod(2);
                }
                break;
            case R.id.tv_pay_mine:
                if (mMoney == 0) {
                    ToastUtil.toast(context, "请先选择数量");
                } else {
                    toPay(0);
                }
                break;
            case R.id.tv_pay_other:
                if (mMoney == 0) {
                    ToastUtil.toast(context, "请先选择数量");
                } else {
                    toPay(1);
                }
                break;
            case R.id.tv_agreement:
               Intent intent = new Intent(context, WebActivity.class);
               intent.putExtra("title", "无人咖啡机充值卡使用规则");
               intent.putExtra("url", "http://www.baidu.com");
               startActivity(intent);
                break;
        }
    }

    /**
     * pay money
     */
    private void toPay(int who) {
        // pay

        // intent
        Intent intent = new Intent(context, GiftCardBuySuccessActivity.class);
        intent.putExtra("who", who);
        startActivity(intent);
    }

    @Override
    public void onTextChanged(int num, boolean isDelete) {
        mNum = num;
        setMoney();
    }

    /**
     * pay method to check and show
     */
    private void checkMethod(int i) {
        if (i == 2) {
            ivCheckWx.setImageResource(R.mipmap.icon_unselected);
            ivCheckZfb.setImageResource(R.mipmap.icon_selected);
        } else if (i == 1) {
            ivCheckWx.setImageResource(R.mipmap.icon_selected);
            ivCheckZfb.setImageResource(R.mipmap.icon_unselected);
        }
    }
}
