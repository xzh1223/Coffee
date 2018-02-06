package com.ichuk.coffee.adapter.home;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.bean.ShoppingCardBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 */

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ViewHolder> {

    private final List<ShoppingCardBean> mList;
    private final Context mContext;
    private int mNum = 0;
    public double mAllMoney = 0;
    private static final String TAG = "ShoppingCartAdapter";

    public ShoppingCartAdapter(Context context, List<ShoppingCardBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public ShoppingCartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(
                R.layout.item_rv_shopping_cart, parent, false);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(ShoppingCartAdapter.ViewHolder holder, final int position) {
        ShoppingCardBean shoppingCardBean = mList.get(position);
        if (shoppingCardBean != null) {
            holder.tvCoffeeStory.setText(shoppingCardBean.getShopName());
            holder.setRecyclerView(position);
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

        TextView tvCoffeeStory;
        RecyclerView rvCoffee;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            tvCoffeeStory = itemView.findViewById(R.id.tv_coffee_story);
            rvCoffee = itemView.findViewById(R.id.rv_coffee);
        }

        /**
         * set recyclerView
         */
        public void setRecyclerView(int position) {
            rvCoffee.setLayoutManager(new LinearLayoutManager(mContext));
            rvCoffee.setAdapter(new ShoppingCartItemAdapter(mContext, mList.get(position).getCoffeeBeanList(), position));
        }
    }

}
