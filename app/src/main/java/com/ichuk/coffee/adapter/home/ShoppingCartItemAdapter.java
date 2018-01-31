package com.ichuk.coffee.adapter.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ichuk.coffee.R;
import com.ichuk.coffee.activity.home.ShoppingCartActivity;
import com.ichuk.coffee.bean.CoffeeBean;
import com.ichuk.coffee.widget.AddOrLessView;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 */

public class ShoppingCartItemAdapter extends RecyclerView.Adapter<ShoppingCartItemAdapter.ViewHolder> {

    private final List<CoffeeBean> mList;
    private final Context mContext;
    private final int index;
    private int mNum = 0;
    public double mAllMoney = 0;

    public ShoppingCartItemAdapter(Context mContext, List<CoffeeBean> mList, int index) {
        this.mContext = mContext;
        this.mList = mList;
        this.index = index;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public ShoppingCartItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(
                R.layout.item_rv_item_rv_shopping_cart, parent, false);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(ShoppingCartItemAdapter.ViewHolder holder, final int position) {
        final CoffeeBean coffeeBean = mList.get(position);
        Glide.with(mContext).load(coffeeBean.getImg()).into(holder.ivCoffeeImage);
        holder.tvCoffeeName.setText(coffeeBean.getName());
        holder.tvCoffeeIngredient.setText("规格：" + coffeeBean.getIngredient());
        holder.tvCoffeePrice.setText("￥" + coffeeBean.getPrice());
        holder.addOrLessView.setText(coffeeBean.getNum() + "");
        holder.addOrLessView.setFlag(0);
        holder.addOrLessView.setTextChangedListener(new AddOrLessView.TextChangedListener() {
            @Override
            public void onTextChanged(int num, boolean isDelete) {
                Log.e("position", "onTextChanged: " + index + "----" +position );
                ((ShoppingCartActivity) mContext).setNum(index, position, num, isDelete, coffeeBean);
                mAllMoney = ((ShoppingCartActivity) mContext).getAllMoney();
                ((ShoppingCartActivity) mContext).setAllMoney(mAllMoney);
            }
        });
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivCoffeeImage;
        TextView tvCoffeeName;
        TextView tvCoffeeIngredient;
        TextView tvCoffeePrice;
        AddOrLessView addOrLessView;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ivCoffeeImage = itemView.findViewById(R.id.iv_coffee_image);
            tvCoffeeName = itemView.findViewById(R.id.tv_coffee_name);
            tvCoffeeIngredient = itemView.findViewById(R.id.tv_coffee_ingredient);
            tvCoffeePrice = itemView.findViewById(R.id.tv_coffee_price);
            addOrLessView = itemView.findViewById(R.id.add_or_less);
        }

    }

}
