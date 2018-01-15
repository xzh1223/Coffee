package com.ichuk.coffee.activity.home;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.CustomTasteAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.PowderOrJamBean;
import com.ichuk.coffee.widget.AddOrLessView;
import com.jauker.widget.BadgeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 */

public class CoffeeDetailActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "CoffeeDetailActivity";
    private ImageView ivCoffeeImage;
    private TextView tvCoffeeName;
    private TextView tvCoffeeTaste;
    private TextView tvCoffeePrice;
    private TextView tvCoffeeInfo;
    private AddOrLessView addOrLess;
    private TextView tvCoffeeCaffeineLow;
    private TextView tvCoffeeCaffeineHigh;
    private TextView tvCoffeeTasteStandard;
    private TextView tvCoffeeTasteCustom;
    private TextView tvCoffeeHot;
    private TextView tvCoffeeCool;
    private AppCompatSpinner spinnerStore;
    private TextView tvCoffeeTime1;
    private TextView tvCoffeeTime5;
    private AppCompatSpinner spinnerTime;
    private LinearLayout llPay;
    private TextView tvCoffeeMoney;
    private LinearLayout llAddCart;
    private ImageView ivBtn;
    private TextView tvHeaderTitle;
    private AlertDialog mCustomDialog;
    private ImageView ivEsc;
    private TextView tvTitle;
    private TextView tvOk;
    private TextView tvMoney;
    private int position = 0;
    private ImageView ivBack;
    private RelativeLayout rlShowAll;
    private ImageView ivAll;
    private boolean isShowAll = false;
    private AlertDialog mNoMakeDialog;
    private TextView tvKnow;
    private ImageView ivShoppingCart;
    private TextView tvContent;
    private RecyclerView rvPowder;
    private RecyclerView rvJam;


    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_coffee_detail;
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        setHeader();
        setBadgeView();
        showCoffeeInfoAll(isShowAll);
        selectCaffeine(0);
        selectTaste(2);
        selectTemperature(4);
    }

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        ivCoffeeImage = findViewById(R.id.iv_coffee_image);
        tvCoffeeName = findViewById(R.id.tv_coffee_name);
        tvCoffeeTaste = findViewById(R.id.tv_coffee_taste);
        tvCoffeePrice = findViewById(R.id.tv_coffee_price);
        tvCoffeeInfo = findViewById(R.id.tv_coffee_info);
        ivAll = findViewById(R.id.iv_all);
        rlShowAll = findViewById(R.id.rl_show_all);
        addOrLess = findViewById(R.id.add_or_less);
        tvCoffeeCaffeineLow = findViewById(R.id.tv_coffee_caffeine_low);
        tvCoffeeCaffeineHigh = findViewById(R.id.tv_coffee_caffeine_high);
        tvCoffeeTasteStandard = findViewById(R.id.tv_coffee_taste_standard);
        tvCoffeeTasteCustom = findViewById(R.id.tv_coffee_taste_custom);
        tvCoffeeHot = findViewById(R.id.tv_coffee_hot);
        tvCoffeeCool = findViewById(R.id.tv_coffee_cool);
        spinnerStore = findViewById(R.id.spinner_store);
        tvCoffeeTime1 = findViewById(R.id.tv_coffee_time_1);
        tvCoffeeTime5 = findViewById(R.id.tv_coffee_time_5);
        spinnerTime = findViewById(R.id.spinner_time);
        llPay = findViewById(R.id.ll_pay);
        tvCoffeeMoney = findViewById(R.id.tv_coffee_money);
        llAddCart = findViewById(R.id.ll_add_cart);
        ivBtn = findViewById(R.id.iv_btn);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        ivShoppingCart = findViewById(R.id.iv_shopping_cart);
    }

    /**
     * set event
     */
    @Override
    protected void setEvent() {

        addOrLess.setTextChangedListener(new AddOrLessView.TextChangedListener() {
            @Override
            public void onTextChanged(int num) {
                // sum all price
            }
        });
        tvCoffeeTasteStandard.setOnClickListener(this);
        tvCoffeeTasteCustom.setOnClickListener(this);
        tvCoffeeCaffeineLow.setOnClickListener(this);
        tvCoffeeCaffeineHigh.setOnClickListener(this);
        tvCoffeeHot.setOnClickListener(this);
        tvCoffeeCool.setOnClickListener(this);
        ivBack.setOnClickListener(this);
        rlShowAll.setOnClickListener(this);
        ivShoppingCart.setOnClickListener(this);

    }

    /**
     * set header title and others
     */
    private void setHeader() {
        ivBtn.setVisibility(View.VISIBLE);
        ivBack.setVisibility(View.VISIBLE);
        tvHeaderTitle.setText("Coffee");
        ivBtn.setImageResource(R.mipmap.icon_share);
    }

    /**
     * set badgeView
     */
    private void setBadgeView() {
        BadgeView badgeView = new BadgeView(context);
        badgeView.setTargetView(ivShoppingCart);
        badgeView.setHideOnNull(true);
        badgeView.setBadgeCount(1);
    }

    /**
     * show all coffee info or don't show all
     */
    private void showCoffeeInfoAll(boolean isShowAll) {
        if (isShowAll) {
            tvCoffeeInfo.setMaxLines(100);
            ivAll.setImageResource(R.mipmap.icon_not_show_all);
        } else {
            tvCoffeeInfo.setMaxLines(4);
            ivAll.setImageResource(R.mipmap.icon_show_all);
        }
    }

    /**
     * select temperature (hot or cold)
     */
    private void selectTemperature(int position) {
        if (position == 4) {
            tvCoffeeHot.setTextColor(getResources().getColor(R.color.md_white_1000));
            tvCoffeeHot.setBackgroundResource(R.drawable.coffee_detail_selected);
            tvCoffeeCool.setTextColor(getResources().getColor(R.color.md_grey_600));
            tvCoffeeCool.setBackgroundResource(R.drawable.bg_coffee_detail);
        } else if (position == 5) {
            tvCoffeeCool.setTextColor(getResources().getColor(R.color.md_white_1000));
            tvCoffeeCool.setBackgroundResource(R.drawable.coffee_detail_selected);
            tvCoffeeHot.setTextColor(getResources().getColor(R.color.md_grey_600));
            tvCoffeeHot.setBackgroundResource(R.drawable.bg_coffee_detail);
        }
    }

    /**
     * select taste ( standard or custom )
     */
    private void selectTaste(int position) {
        if (position == 2) {
            tvCoffeeTasteStandard.setTextColor(getResources().getColor(R.color.md_white_1000));
            tvCoffeeTasteStandard.setBackgroundResource(R.drawable.coffee_detail_selected);
            tvCoffeeTasteCustom.setTextColor(getResources().getColor(R.color.md_grey_600));
            tvCoffeeTasteCustom.setBackgroundResource(R.drawable.bg_coffee_detail);
        } else if (position == 3) {
            tvCoffeeTasteCustom.setTextColor(getResources().getColor(R.color.md_white_1000));
            tvCoffeeTasteCustom.setBackgroundResource(R.drawable.coffee_detail_selected);
            tvCoffeeTasteStandard.setTextColor(getResources().getColor(R.color.md_grey_600));
            tvCoffeeTasteStandard.setBackgroundResource(R.drawable.bg_coffee_detail);
        }
    }

    /**
     * select caffeine ( low or high )
     */
    private void selectCaffeine(int position) {
        if (position == 0) {
            tvCoffeeCaffeineLow.setTextColor(getResources().getColor(R.color.md_white_1000));
            tvCoffeeCaffeineLow.setBackgroundResource(R.drawable.coffee_detail_selected);
            tvCoffeeCaffeineHigh.setTextColor(getResources().getColor(R.color.md_grey_600));
            tvCoffeeCaffeineHigh.setBackgroundResource(R.drawable.bg_coffee_detail);
        } else if (position == 1) {
            tvCoffeeCaffeineHigh.setTextColor(getResources().getColor(R.color.md_white_1000));
            tvCoffeeCaffeineHigh.setBackgroundResource(R.drawable.coffee_detail_selected);
            tvCoffeeCaffeineLow.setTextColor(getResources().getColor(R.color.md_grey_600));
            tvCoffeeCaffeineLow.setBackgroundResource(R.drawable.bg_coffee_detail);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_shopping_cart:
                Intent intent = new Intent(context, ShoppingCartActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_esc:
                if (mCustomDialog != null) {
                    mCustomDialog.dismiss();
                }
                break;
            case R.id.tv_coffee_caffeine_low:
                position = 0;
                selectCaffeine(position);
                break;
            case R.id.tv_coffee_caffeine_high:
                position = 1;
                selectCaffeine(position);
                break;
            case R.id.tv_coffee_taste_standard:
                position = 2;
                selectTaste(position);
                break;
            case R.id.tv_coffee_taste_custom:
                position = 3;
                selectTaste(position);
                showCustomDialog();
                break;
            case R.id.tv_coffee_hot:
                position = 4;
                selectTemperature(position);
                break;
            case R.id.tv_coffee_cool:
                position = 5;
                selectTemperature(position);
                break;
            case R.id.rl_show_all:
                isShowAll = !isShowAll;
                showCoffeeInfoAll(isShowAll);
                break;
            case R.id.tv_know:
                if (mNoMakeDialog != null) {
                    mNoMakeDialog.dismiss();
                }
                break;
        }
    }

    /**
     * show custom dialog
     */
    private void showCustomDialog() {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dialog_teste_custom, null);
        AlertDialog.Builder customDialog = new AlertDialog.Builder(context);
        customDialog.setView(view);
        mCustomDialog = customDialog.create();
        mCustomDialog.show();

        customFindViews(view);
        setRecyclerView();
        setCustomClick();
    }

    /**
     *  set custom recyclerView (powder and jam)
     */
    private void setRecyclerView() {
        List<PowderOrJamBean> mPowderList = new ArrayList<>();
        List<PowderOrJamBean> mJamList = new ArrayList<>();
        rvPowder.setLayoutManager(new LinearLayoutManager(context));
        rvPowder.setAdapter(new CustomTasteAdapter(context, mPowderList));

        rvJam.setLayoutManager(new LinearLayoutManager(context));
        rvJam.setAdapter(new CustomTasteAdapter(context, mJamList));
    }

    /**
     * findViewById (custom dialog)
     */
    private void customFindViews(View view) {
        ivEsc = view.findViewById(R.id.iv_esc);
        tvTitle = view.findViewById(R.id.tv_title);
        tvOk = view.findViewById(R.id.tv_ok);
        tvMoney = view.findViewById(R.id.tv_money);
        rvPowder = view.findViewById(R.id.rv_powder);
        rvJam = view.findViewById(R.id.rv_jam);
    }

    /**
     * set custom view's event
     */
    private void setCustomClick() {
        ivEsc.setOnClickListener(this);
    }

    /**
     * show dialog  ( can not make or reach limit )
     */
    public void showNoMakeOrLimitDialog(int flag) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dialog_no_make, null);
        AlertDialog.Builder noMakeDialog = new AlertDialog.Builder(context);
        noMakeDialog.setView(view);
        mNoMakeDialog = noMakeDialog.create();
        mNoMakeDialog.show();

        noMakeOrLimitFindViews(view);
        setNoMakeOrLimitEvent(flag);
    }

    /**
     * set can not make click event
     */
    private void setNoMakeOrLimitEvent(int flag) {
        tvKnow.setOnClickListener(this);

        if (flag == 0) {
            // show can not make
            tvContent.setText(getResources().getString(R.string.no_make));
        } else {
            // show reach limit
            tvContent.setText(getResources().getString(R.string.reach_limit));
        }
    }

    /**
     * findViewById ( can not make dialog )
     */
    private void noMakeOrLimitFindViews(View view) {
        tvKnow = view.findViewById(R.id.tv_know);
        tvContent = view.findViewById(R.id.tv_content);
    }

}
