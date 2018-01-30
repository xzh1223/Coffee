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
import com.ichuk.coffee.adapter.home.CustomTasteAdapter;
import com.ichuk.coffee.base.ShareActivity;
import com.ichuk.coffee.bean.PowderOrJamBean;
import com.ichuk.coffee.utils.ToastUtil;
import com.ichuk.coffee.widget.AddOrLessView;
import com.jauker.widget.BadgeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 */

public class CoffeeDetailActivity extends ShareActivity implements View.OnClickListener {

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
    private LinearLayout llBottom1;
    private LinearLayout llBottom2;
    private LinearLayout llShow1;
    private LinearLayout llShow2;
    private String mPage = "";
    List<PowderOrJamBean> mPowderList = new ArrayList<>();
    List<PowderOrJamBean> mJamList = new ArrayList<>();

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
        showCoffeeInfoAll(isShowAll);
        setHeader();
        getDataFromIntent();
        if ("MY_POINT_ACTIVITY".equals(mPage)) {
            llShow2.setVisibility(View.VISIBLE);
            llShow1.setVisibility(View.GONE);
            llBottom2.setVisibility(View.VISIBLE);
            llBottom1.setVisibility(View.GONE);
            ivShoppingCart.setVisibility(View.GONE);
        } else {
            llShow1.setVisibility(View.VISIBLE);
            llShow2.setVisibility(View.GONE);
            llBottom1.setVisibility(View.VISIBLE);
            llBottom2.setVisibility(View.GONE);
            ivShoppingCart.setVisibility(View.VISIBLE);
            setBadgeView(1);
            selectCaffeine(0);
            selectTaste(2);
        }
        selectTemperature(4);
    }

    /**
     * get data from intent
     */
    private void getDataFromIntent() {
        mPage = getIntent().getStringExtra("page");
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

        llBottom1 = findViewById(R.id.ll_bottom_1);
        llBottom2 = findViewById(R.id.ll_bottom_2);
        llShow1 = findViewById(R.id.ll_show_1);
        llShow2 = findViewById(R.id.ll_show_2);

    }

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        addOrLess.setTextChangedListener(new AddOrLessView.TextChangedListener() {
            @Override
            public void onTextChanged(int num, boolean isDelete) {
                // sum all price
            }
        });
        addOrLess.setFlag(1);
        tvCoffeeTasteStandard.setOnClickListener(this);
        tvCoffeeTasteCustom.setOnClickListener(this);
        tvCoffeeCaffeineLow.setOnClickListener(this);
        tvCoffeeCaffeineHigh.setOnClickListener(this);
        tvCoffeeHot.setOnClickListener(this);
        tvCoffeeCool.setOnClickListener(this);
        ivBack.setOnClickListener(this);
        rlShowAll.setOnClickListener(this);
        ivShoppingCart.setOnClickListener(this);
        llBottom2.setOnClickListener(this);
        llAddCart.setOnClickListener(this);
        llPay.setOnClickListener(this);
        ivBtn.setOnClickListener(this);
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
    private void setBadgeView(int num) {
        BadgeView badgeView = new BadgeView(context);
        badgeView.setTargetView(ivShoppingCart);
        badgeView.setHideOnNull(true);
        badgeView.setBadgeCount(num);
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
            case R.id.iv_shopping_cart: {
                Intent intent = new Intent(context, ShoppingCartActivity.class);
                startActivity(intent);
                break;
            }
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
            case R.id.ll_bottom_2:
                ToastUtil.toast(context, "立即兑换");
                break;
            case R.id.ll_add_cart:
                // add into cart
                setBadgeView(1 + 2);
                break;
            case R.id.ll_pay: {
                Intent intent = new Intent(context, SubmitOrderActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.iv_btn:
                showShareTypeDialog(CoffeeDetailActivity.this);
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
     * set custom recyclerView (powder and jam)
     */
    private void setRecyclerView() {
        mPowderList.clear();
        mJamList.clear();
        PowderOrJamBean powderOrJamBean = new PowderOrJamBean();
        powderOrJamBean.setName("香草粉");
        powderOrJamBean.setWeight(5);
        PowderOrJamBean powderOrJamBean1 = new PowderOrJamBean();
        powderOrJamBean1.setName("肉桂粉");
        powderOrJamBean1.setWeight(5);
        PowderOrJamBean powderOrJamBean2 = new PowderOrJamBean();
        powderOrJamBean2.setName("巧克力粉");
        powderOrJamBean2.setWeight(5);
        mPowderList.add(powderOrJamBean);
        mPowderList.add(powderOrJamBean1);
        mPowderList.add(powderOrJamBean2);

        PowderOrJamBean powderOrJamBean3 = new PowderOrJamBean();
        powderOrJamBean3.setName("巧克力酱");
        powderOrJamBean3.setWeight(5);
        PowderOrJamBean powderOrJamBean4 = new PowderOrJamBean();
        powderOrJamBean4.setName("焦糖糖浆");
        powderOrJamBean4.setWeight(5);
        PowderOrJamBean powderOrJamBean5 = new PowderOrJamBean();
        powderOrJamBean5.setName("奶油");
        powderOrJamBean5.setWeight(5);
        mJamList.add(powderOrJamBean3);
        mJamList.add(powderOrJamBean4);
        mJamList.add(powderOrJamBean5);
        rvPowder.setLayoutManager(new LinearLayoutManager(context));
        rvPowder.setAdapter(new CustomTasteAdapter(context, mPowderList, 1));

        rvJam.setLayoutManager(new LinearLayoutManager(context));
        rvJam.setAdapter(new CustomTasteAdapter(context, mJamList, 2));
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
        ivEsc.setOnClickListener(this);

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
        ivEsc = view.findViewById(R.id.iv_esc);
    }

    /**
     * reset selected num
     */
    public boolean resetNum(int flag, int position, int num) {
        int maxNum = 0;
        int maxPowder = 0;
        int maxJam = 0;
        if (flag == 1) {
            for (int i = 0; i < mPowderList.size(); i++) {
                if (position == i) {
                    mPowderList.get(i).num = num;
                }
            }
        } else if (flag == 2) {
            for (int i = 0; i < mJamList.size(); i++) {
                if (position == i) {
                    mJamList.get(i).num = num;
                }
            }
        }
        for (int i = 0; i < mPowderList.size(); i++) {
            maxPowder += mPowderList.get(i).num;
        }
        for (int i = 0; i < mJamList.size(); i++) {
            maxJam += mJamList.get(i).num;
        }
        maxNum = maxPowder + maxJam;
        if (maxNum > 5) {
            showNoMakeOrLimitDialog(1);
            return true;
        } else {
            return false;
        }
    }
}
