package com.ichuk.coffee.adapter.discount;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ichuk.coffee.R;
import com.ichuk.coffee.bean.SecondHalfBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 */

public class SecondHalfAdapter extends RecyclerView.Adapter<SecondHalfAdapter.ViewHolder> {

    private final List<SecondHalfBean> mList;
    private final Context mContext;

    public SecondHalfAdapter(Context context, List<SecondHalfBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public SecondHalfAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_second_half, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(SecondHalfAdapter.ViewHolder holder, int position) {
        SecondHalfBean secondHalfBean = mList.get(position);
        Glide.with(mContext).load(R.mipmap.ic_launcher).into(holder.ivCoffeeImage);
        holder.tvCoffeeName.setText(secondHalfBean.getName());
        holder.tvCoffeeIngredient.setText("成分：" + secondHalfBean.getIngredient());
        holder.tvCoffeePrice.setText("￥" + secondHalfBean.getPrice());
        holder.sbSold.setEnabled(false);
        holder.sbSold.setMax(secondHalfBean.getSum());
        holder.sbSold.setProgress(secondHalfBean.getNum());
        holder.tvSold.setText("已售50%");

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

        private ImageView ivCoffeeImage;
        private TextView tvCoffeeName;
        private TextView tvCoffeeIngredient;
        private TextView tvCoffeePrice;
        private SeekBar sbSold;
        private TextView tvSold;
        private TextView tvToBuy;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ivCoffeeImage = itemView.findViewById(R.id.iv_coffee_image);
            tvCoffeeName = itemView.findViewById(R.id.tv_coffee_name);
            tvCoffeeIngredient = itemView.findViewById(R.id.tv_coffee_ingredient);
            tvCoffeePrice = itemView.findViewById(R.id.tv_coffee_price);
            sbSold = itemView.findViewById(R.id.sb_sold);
            tvSold = itemView.findViewById(R.id.tv_sold);
            tvToBuy = itemView.findViewById(R.id.tv_to_buy);
        }
    }

}
