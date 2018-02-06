package com.ichuk.coffee.activity.home;

import android.graphics.Paint;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.home.ShoppingCartAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.CoffeeBean;
import com.ichuk.coffee.bean.ShoppingCardBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 * <p>
 * shopping cart
 */

public class ShoppingCartActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivBack;

    private LinearLayout llBottom;
    private LinearLayout llContinueShopping;
    private ImageView ivContinueShopping;
    private TextView tvPayMoney;
    private LinearLayout llToPay;
    private RecyclerView rvShoppingCart;
    private List<ShoppingCardBean> mList = new ArrayList<>();
    private ShoppingCartAdapter mAdapter;
    private LinearLayout llUndoDelete;
    private TextView tvUndoDelete;
    private TextView tvHeaderTitle;
    private AlertDialog mDeleteDialog;
    private TextView tvDeleteNo;
    private TextView tvDeleteYes;
    private int mFirstIndex;
    private int mSecondIndex;
    private List<ShoppingCardBean> beforeDeleteList = new ArrayList<>();

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        llBottom = findViewById(R.id.ll_bottom);
        llUndoDelete = findViewById(R.id.ll_undo_delete);
        tvUndoDelete = findViewById(R.id.tv_undo_delete);
        llContinueShopping = findViewById(R.id.ll_continue_shopping);
        ivContinueShopping = findViewById(R.id.iv_continue_shopping);
        tvPayMoney = findViewById(R.id.tv_pay_money);
        llToPay = findViewById(R.id.ll_to_pay);
        rvShoppingCart = findViewById(R.id.rv_shopping_cart);
        ivBack = findViewById(R.id.iv_back);
    }

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        tvUndoDelete.setOnClickListener(this);
        llToPay.setOnClickListener(this);
        llContinueShopping.setOnClickListener(this);
        tvUndoDelete.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        getData();
        setRecyclerView();
        setHeader();
        setAllMoney();

        showDeleteDialog();
    }

    /**
     * set header title
     */
    private void setHeader() {
        tvHeaderTitle.setText("购物车");
    }

    /**
     * get data from http
     */
    private void getData() {

        CoffeeBean coffeeBean = new CoffeeBean();
        coffeeBean.setId(1);
        coffeeBean.setName("Coffee");
        coffeeBean.setImg(R.mipmap.icon_bg_1_2);
        coffeeBean.setIngredient("浓缩咖啡、水");
        coffeeBean.setPrice("9.9");
        coffeeBean.setNum(1);

        CoffeeBean coffeeBean2 = new CoffeeBean();
        coffeeBean2.setId(2);
        coffeeBean2.setName("Coffee");
        coffeeBean2.setImg(R.mipmap.icon_bg_1_2);
        coffeeBean2.setIngredient("浓缩咖啡、水");
        coffeeBean2.setPrice("9.9");
        coffeeBean2.setNum(3);

        ShoppingCardBean shoppingCardBean = new ShoppingCardBean();
        shoppingCardBean.setId(0);
        shoppingCardBean.getCoffeeBeanList().add(coffeeBean);
        shoppingCardBean.getCoffeeBeanList().add(coffeeBean2);
        shoppingCardBean.setShopName("莱弗广场店");

        CoffeeBean coffeeBean3 = new CoffeeBean();
        coffeeBean3.setId(3);
        coffeeBean3.setName("Coffee");
        coffeeBean3.setImg(R.mipmap.icon_bg_1_2);
        coffeeBean3.setIngredient("浓缩咖啡、水");
        coffeeBean3.setPrice("9.9");
        coffeeBean3.setNum(4);

        CoffeeBean coffeeBean4 = new CoffeeBean();
        coffeeBean4.setId(4);
        coffeeBean4.setName("Coffee");
        coffeeBean4.setImg(R.mipmap.icon_bg_1_2);
        coffeeBean4.setIngredient("浓缩咖啡、水");
        coffeeBean4.setPrice("9.9");
        coffeeBean4.setNum(5);

        ShoppingCardBean shoppingCardBean2 = new ShoppingCardBean();
        shoppingCardBean2.setId(1);
        shoppingCardBean2.getCoffeeBeanList().add(coffeeBean3);
        shoppingCardBean2.getCoffeeBeanList().add(coffeeBean4);
        shoppingCardBean2.setShopName("莱弗广场店");
        mList.add(shoppingCardBean);
        mList.add(shoppingCardBean2);
    }

    /**
     * set recyclerView
     */
    private void setRecyclerView() {
        rvShoppingCart.setLayoutManager(new LinearLayoutManager(context));
        mAdapter = new ShoppingCartAdapter(context, mList);
        rvShoppingCart.setAdapter(mAdapter);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_shopping_cart;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_undo_delete:
                mList.clear();
                Log.e("mList", "onClick: " + beforeDeleteList.toString());
                for (int i = 0; i < beforeDeleteList.size(); i++) {
                    mList.add(beforeDeleteList.get(i));
                }
                Log.e("mList", "onClick: " + mList.toString());
                mAdapter.notifyDataSetChanged();
                llUndoDelete.setVisibility(View.GONE);
                break;
            case R.id.ll_to_pay:
                Toast.makeText(context, "go to pay", Toast.LENGTH_SHORT).show();
                toActivity(SubmitOrderActivity.class);
                break;
            case R.id.ll_continue_shopping:
                finish();
                break;
            case R.id.tv_delete_no:
                if (mDeleteDialog != null) {
                    mDeleteDialog.dismiss();
                }
                break;
            case R.id.tv_delete_yes:
                if (mDeleteDialog != null) {
                    mDeleteDialog.dismiss();
                }
                deleteData(mFirstIndex, mSecondIndex);
                break;
        }
    }

    /**
     * set money to pay
     */
    public void setAllMoney() {
        double money = getAllMoney();
        String num = String.format("%.1f", money);
        tvPayMoney.setText(num);
    }

    /**
     * get money all
     */
    public double getAllMoney() {
        double sum = 0;
        for (int i = 0; i < mList.size(); i++) {
            for (int j = 0; j < mList.get(i).getCoffeeBeanList().size(); j++) {
                sum += Double.valueOf(mList.get(i).getCoffeeBeanList().get(j).getPrice()) *
                        Double.valueOf(mList.get(i).getCoffeeBeanList().get(j).getNum());
            }
        }
        return sum;
    }

    /**
     * show delete dialog
     */
    public void showDeleteDialog() {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dialog_delete, null);
        AlertDialog.Builder deleteDialog = new AlertDialog.Builder(context);
        deleteDialog.setView(view);
        mDeleteDialog = deleteDialog.create();

        deleteFindViews(view);
        setDeleteEvent();
    }

    /**
     * set event
     */
    private void setDeleteEvent() {
        tvDeleteNo.setOnClickListener(this);
        tvDeleteYes.setOnClickListener(this);
    }

    /**
     * findViewById (delete dialog)
     */
    private void deleteFindViews(View view) {
        tvDeleteNo = view.findViewById(R.id.tv_delete_no);
        tvDeleteYes = view.findViewById(R.id.tv_delete_yes);
    }

    /**
     * delete data from list
     *
     * @param index
     * @param position
     */
    public void deleteData(int index, int position) {
        beforeDeleteList.clear();
        for (int i = 0; i < mList.size(); i++) {
            List<CoffeeBean> coffeeBeanList = new ArrayList<>();
            for (int j = 0; j < mList.get(i).getCoffeeBeanList().size(); j++) {
                coffeeBeanList.add(mList.get(i).getCoffeeBeanList().get(j));
            }
            ShoppingCardBean shoppingCardBean = new ShoppingCardBean();
            shoppingCardBean.setCoffeeBeanList(coffeeBeanList);
            shoppingCardBean.setShopName(mList.get(i).getShopName());
            shoppingCardBean.setId(mList.get(i).getId());
            beforeDeleteList.add(shoppingCardBean);
        }
        for (int i = 0; i < mList.size(); i++) {
            int lastNum = mList.get(i).getCoffeeBeanList().size();
            for (int j = 0; j < mList.get(i).getCoffeeBeanList().size(); j++) {
                if (i == index && position == j) {
                    mList.get(i).getCoffeeBeanList().remove(j);
                    lastNum--;
                }
            }
            if (lastNum == 0) {
                mList.remove(i);
            }
        }
        mAdapter.notifyDataSetChanged();
        llUndoDelete.setVisibility(View.VISIBLE);
    }

    /**
     * set num
     *
     * @param firstIndex
     * @param secondIndex
     * @param num
     */
    public void setNum(int firstIndex, int secondIndex, int num, boolean isDelete) {

        mList.get(firstIndex).getCoffeeBeanList().get(secondIndex).setNum(num);
        mFirstIndex = firstIndex;
        mSecondIndex = secondIndex;
        if (isDelete) {
            mDeleteDialog.show();
        }
    }
}
