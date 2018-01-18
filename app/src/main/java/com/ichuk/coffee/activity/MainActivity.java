package com.ichuk.coffee.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.base.BaseFragment;
import com.ichuk.coffee.fragment.CommunityFragment;
import com.ichuk.coffee.fragment.DiscountFragment;
import com.ichuk.coffee.fragment.HomeFragment;
import com.ichuk.coffee.fragment.MineFragment;
import com.ichuk.coffee.fragment.NewProductsFragment;
import com.jauker.widget.BadgeView;

import java.util.ArrayList;

/**
 * Main
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout llHome;
    private ImageView ivMainHome;
    private TextView tvMainHome;
    private LinearLayout llNewProducts;
    private ImageView ivMainNewProducts;
    private TextView tvMainNewProducts;
    private LinearLayout llDiscount;
    private ImageView ivMainDiscount;
    private TextView tvMainDiscount;
    private LinearLayout llCommunity;
    private ImageView ivMainCommunity;
    private TextView tvMainCommunity;
    private LinearLayout llMine;
    private ImageView ivMainMine;
    private TextView tvMainMine;
    private FrameLayout flFragment;
    private ArrayList<BaseFragment> fragments;
    private int position = 0;
    private Fragment tempFragment;


    /**
     * initial widget
     */
    private void findViews() {
        llHome = findViewById(R.id.ll_home);
        ivMainHome = findViewById(R.id.iv_main_home);
        tvMainHome = findViewById(R.id.tv_main_home);
        llNewProducts = findViewById(R.id.ll_new_products);
        ivMainNewProducts = findViewById(R.id.iv_main_new_products);
        tvMainNewProducts = findViewById(R.id.tv_main_new_products);
        llDiscount = findViewById(R.id.ll_discount);
        ivMainDiscount = findViewById(R.id.iv_main_discount);
        tvMainDiscount = findViewById(R.id.tv_main_discount);
        llCommunity = findViewById(R.id.ll_community);
        ivMainCommunity = findViewById(R.id.iv_main_community);
        tvMainCommunity = findViewById(R.id.tv_main_community);
        llMine = findViewById(R.id.ll_mine);
        ivMainMine = findViewById(R.id.iv_main_mine);
        tvMainMine = findViewById(R.id.tv_main_mine);
        flFragment = findViewById(R.id.fl_fragment);
    }


    /**
     * initial fragment
     */
    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new NewProductsFragment());
        fragments.add(new DiscountFragment());
        fragments.add(new CommunityFragment());
        fragments.add(new MineFragment());
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        llHome.setOnClickListener(this);
        llNewProducts.setOnClickListener(this);
        llDiscount.setOnClickListener(this);
        llCommunity.setOnClickListener(this);
        llMine.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        initFragment();
        setBottom();
        setBadgeView();
    }

    /**
     * set badgeView
     */
    private void setBadgeView() {
        BadgeView badgeView = new BadgeView(this);
        badgeView.setTargetView(ivMainMine);
//        badgeView.setBadgeGravity(Gravity.RIGHT);
        badgeView.setHideOnNull(true);
        badgeView.setBadgeCount(0);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                position = 0;
                break;
            case R.id.ll_new_products:
                position = 1;
                break;
            case R.id.ll_discount:
                position = 2;
                break;
            case R.id.ll_community:
                position = 3;
                break;
            case R.id.ll_mine:
                position = 4;
                break;
            default:
                position = 0;
                break;
        }
        setBottom();
    }

    /**
     * set bottom and fragment
     */
    private void setBottom() {
        setClicked(position);
        BaseFragment baseFragment = getFragment(position);
        switchFragment(tempFragment, baseFragment);
    }

    /**
     * after click ,the text and image changed
     */
    private void setClicked(int position) {
        setDefault();
        switch (position) {
            case 0:
                tvMainHome.setTextColor(getResources().getColor(R.color.brown));
                ivMainHome.setImageResource(R.mipmap.icon_home_selected);
                updateStatus(1);
                setStatusTextColor(1);
//                getWindow().getDecorView().findViewById(android.R.id.content).setPadding(0, 0, 0, CommonUtils.navigationHeight);
                break;
            case 1:
                tvMainNewProducts.setTextColor(getResources().getColor(R.color.brown));
                ivMainNewProducts.setImageResource(R.mipmap.icon_new_products_selected);
                updateStatus(1);
                setStatusTextColor(1);
                break;
            case 2:
                tvMainDiscount.setTextColor(getResources().getColor(R.color.brown));
                ivMainDiscount.setImageResource(R.mipmap.icon_discount_selected);
                updateStatus(1);
                setStatusTextColor(1);
                break;
            case 3:
                tvMainCommunity.setTextColor(getResources().getColor(R.color.brown));
                ivMainCommunity.setImageResource(R.mipmap.icon_community_selected);
                updateStatus(1);
                setStatusTextColor(1);
                break;
            case 4:
                tvMainMine.setTextColor(getResources().getColor(R.color.brown));
                ivMainMine.setImageResource(R.mipmap.icon_mine_selected);
                updateStatus(0);
                setStatusTextColor(0);
                break;
        }
    }

    /**
     * set default text and image
     */
    private void setDefault() {
        tvMainHome.setTextColor(getResources().getColor(R.color.md_grey_600));
        tvMainNewProducts.setTextColor(getResources().getColor(R.color.md_grey_600));
        tvMainDiscount.setTextColor(getResources().getColor(R.color.md_grey_600));
        tvMainCommunity.setTextColor(getResources().getColor(R.color.md_grey_600));
        tvMainMine.setTextColor(getResources().getColor(R.color.md_grey_600));
        ivMainHome.setImageResource(R.mipmap.icon_home);
        ivMainNewProducts.setImageResource(R.mipmap.icon_new_products);
        ivMainDiscount.setImageResource(R.mipmap.icon_discount);
        ivMainCommunity.setImageResource(R.mipmap.icon_community);
        ivMainMine.setImageResource(R.mipmap.icon_mine);
    }

    /**
     * get Fragment by position
     */
    private BaseFragment getFragment(int position) {
        if (fragments != null && fragments.size() > 0) {
            return fragments.get(position);
        }
        return null;
    }

    /**
     * from last fragment and to next fragment
     */
    private void switchFragment(Fragment fromFragment, BaseFragment toFragment) {
        if (tempFragment != toFragment) {
            tempFragment = toFragment;
            if (toFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if (!toFragment.isAdded()) {
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id.fl_fragment, toFragment).commit();
                } else {
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(toFragment).commit();
                }
            }
        }
    }
}
