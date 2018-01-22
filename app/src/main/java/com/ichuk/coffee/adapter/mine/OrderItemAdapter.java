package com.ichuk.coffee.adapter.mine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ichuk.coffee.R;
import com.ichuk.coffee.bean.CoffeeBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 */

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.ViewHolder> {

    private final List<CoffeeBean> mList;
    private final Context mContext;

    public OrderItemAdapter(Context context, List<CoffeeBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public OrderItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_item_rv_order, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(OrderItemAdapter.ViewHolder holder, final int position) {
        CoffeeBean coffeeBean = mList.get(position);
        if (coffeeBean != null) {
            Glide.with(mContext).load(R.mipmap.ic_launcher).into(holder.ivCoffeeImage);
            holder.tvCoffeeName.setText(coffeeBean.getName());
            holder.tvCoffeeIngredient.setText(coffeeBean.getIngredient());
            holder.tvCoffeePrice.setText("￥" + coffeeBean.getPrice());
            holder.tvCoffeeNum.setText("x" + coffeeBean.getNum());
        }
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

        View view;
        private ImageView ivCoffeeImage;
        private TextView tvCoffeeName;
        private TextView tvCoffeeIngredient;
        private TextView tvCoffeePrice;
        private TextView tvCoffeeNum;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ivCoffeeImage = itemView.findViewById(R.id.iv_coffee_image);
            tvCoffeeName = itemView.findViewById(R.id.tv_coffee_name);
            tvCoffeeIngredient = itemView.findViewById(R.id.tv_coffee_ingredient);
            tvCoffeePrice = itemView.findViewById(R.id.tv_coffee_price);
            tvCoffeeNum = itemView.findViewById(R.id.tv_coffee_num);
        }
    }

}
