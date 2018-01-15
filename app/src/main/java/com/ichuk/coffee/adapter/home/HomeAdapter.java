package com.ichuk.coffee.adapter.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ichuk.coffee.R;
import com.ichuk.coffee.activity.home.CoffeeDetailActivity;
import com.ichuk.coffee.bean.CoffeeBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 *
 *  coffee list adapter
 *
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private final List<CoffeeBean> mList;
    private final Context mContext;

    public HomeAdapter(Context context, List<CoffeeBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_home, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(HomeAdapter.ViewHolder holder, int position) {
        CoffeeBean coffeeBean = mList.get(position);
        Glide.with(mContext).load(coffeeBean.getImg()).into(holder.ivCoffeeImage);
        holder.tvCoffeeName.setText(coffeeBean.getName());
        holder.tvCoffeeIngredient.setText("成分：" + coffeeBean.getIngredient());
        holder.tvCoffeePrice.setText("￥" + coffeeBean.getPrice());
        holder.tvNum.setText(coffeeBean.getNum() + "");
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CoffeeDetailActivity.class);
//                intent.putExtra("", "");
                mContext.startActivity(intent);
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
        TextView tvNum;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ivCoffeeImage = itemView.findViewById(R.id.iv_coffee_image);
            tvCoffeeName = itemView.findViewById(R.id.tv_coffee_name);
            tvCoffeeIngredient = itemView.findViewById(R.id.tv_coffee_ingredient);
            tvCoffeePrice = itemView.findViewById(R.id.tv_coffee_price);
            tvNum = itemView.findViewById(R.id.tv_num);
        }
    }

}
