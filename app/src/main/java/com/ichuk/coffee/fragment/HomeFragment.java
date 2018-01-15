package com.ichuk.coffee.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ichuk.coffee.R;
import com.ichuk.coffee.activity.home.LoginActivity;
import com.ichuk.coffee.activity.home.ShoppingCartActivity;
import com.ichuk.coffee.adapter.home.HomeAdapter;
import com.ichuk.coffee.application.LocationApplication;
import com.ichuk.coffee.base.BaseFragment;
import com.ichuk.coffee.bean.CoffeeBean;
import com.jauker.widget.BadgeView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzh on 2017/12/4.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private Banner banner;
    //    private EditText etOnlineNum;
    private RecyclerView rvHomeCoffee;
    private List<Integer> imageList = new ArrayList<>();
    private List<CoffeeBean> mList = new ArrayList<>();
//    private FloatingActionButton fabGoods;
    private TextView tvToLogin;
    private TextView tvLocation;
    private ImageView ivShoppingCart;

    /**
     * initial widget
     */
    private void findViews() {
        if (getView() != null) {
            tvLocation = getView().findViewById(R.id.tv_location);
            banner = getView().findViewById(R.id.banner);

            ivShoppingCart = getView().findViewById(R.id.iv_shopping_cart);
//        etOnlineNum = (EditText) getView().findViewById(R.id.et_online_num);
            tvToLogin = getView().findViewById(R.id.tv_to_login);
            rvHomeCoffee = getView().findViewById(R.id.rv_home_coffee);
//            fabGoods = getView().findViewById(R.id.fab_goods);
        }
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        sendRequest();
        setBanner();
        setRecyclerView();
        setEvent();
    }

    /**
     * set event and listener
     */
    private void setEvent() {
        setLocation();
        setBadgeView();
        tvToLogin.setOnClickListener(this);
        ivShoppingCart.setOnClickListener(this);
    }

    /**
     *  get Location
     */
    private void setLocation() {
        final LocationApplication app = (LocationApplication) getActivity().getApplication();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                tvLocation.setText(app.getLocationStr());
            }
        }, 1000);
    }

    /**
     *  set badge view
     */
    private void setBadgeView() {
        BadgeView badgeView = new BadgeView(context);
        badgeView.setTargetView(ivShoppingCart);
        badgeView.setHideOnNull(true);
        badgeView.setBadgeCount(12);
    }

    /**
     * send request and get data
     */
    private void sendRequest() {
        CoffeeBean coffeeBean = new CoffeeBean();
        coffeeBean.setId(1);
        coffeeBean.setName("Coffee");
        coffeeBean.setImg(R.mipmap.ic_launcher);
        coffeeBean.setIngredient("浓缩咖啡、水");
        coffeeBean.setPrice("9.9");
        coffeeBean.setNum(1000);

        CoffeeBean coffeeBean2 = new CoffeeBean();
        coffeeBean2.setId(2);
        coffeeBean2.setName("Coffee");
        coffeeBean2.setImg(R.mipmap.ic_launcher);
        coffeeBean2.setIngredient("浓缩咖啡、水");
        coffeeBean2.setPrice("9.9");
        coffeeBean2.setNum(3000);

        CoffeeBean coffeeBean3 = new CoffeeBean();
        coffeeBean3.setId(3);
        coffeeBean3.setName("Coffee");
        coffeeBean3.setImg(R.mipmap.ic_launcher);
        coffeeBean3.setIngredient("浓缩咖啡、水");
        coffeeBean3.setPrice("8.9");
        coffeeBean3.setNum(4000);

        CoffeeBean coffeeBean4 = new CoffeeBean();
        coffeeBean4.setId(4);
        coffeeBean4.setName("Coffee");
        coffeeBean4.setImg(R.mipmap.ic_launcher);
        coffeeBean4.setIngredient("浓缩咖啡、水");
        coffeeBean4.setPrice("8.9");
        coffeeBean4.setNum(4000);

        CoffeeBean coffeeBean5 = new CoffeeBean();
        coffeeBean5.setId(5);
        coffeeBean5.setName("Coffee");
        coffeeBean5.setImg(R.mipmap.ic_launcher);
        coffeeBean5.setIngredient("浓缩咖啡、水");
        coffeeBean5.setPrice("8.9");
        coffeeBean5.setNum(4000);
        mList.add(coffeeBean);
        mList.add(coffeeBean2);
        mList.add(coffeeBean3);
        mList.add(coffeeBean4);
        mList.add(coffeeBean5);
    }

    /**
     * set list
     */
    private void setRecyclerView() {
        rvHomeCoffee.setFocusable(false);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        rvHomeCoffee.setLayoutManager(manager);
        HomeAdapter adapter = new HomeAdapter(context, mList);
        rvHomeCoffee.setAdapter(adapter);

    }

    /**
     * set banner
     */
    private void setBanner() {
        imageList.add(R.mipmap.ic_launcher_round);
        imageList.add(R.mipmap.ic_launcher_round);
        imageList.add(R.mipmap.ic_launcher_round);
        // 设置加载器
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });
        // 设置相关属性
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);//设置原点
        banner.setDelayTime(3000);//设置轮播时间
        banner.setImages(imageList);//设置图片源
        banner.start();
//        banner.setOnBannerListener(this);
    }

    /**
     * load layout
     */
    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void onStart() {
        super.onStart();
        //start
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //stop
        banner.stopAutoPlay();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_shopping_cart: {
                Intent intent = new Intent(context, ShoppingCartActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.tv_to_login: {
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
                break;
            }

        }
    }
}
