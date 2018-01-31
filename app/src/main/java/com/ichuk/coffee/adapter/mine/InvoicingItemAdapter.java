package com.ichuk.coffee.adapter.mine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ichuk.coffee.R;
import com.ichuk.coffee.activity.mine.InvoicingPlayActivity;
import com.ichuk.coffee.bean.MonthOrderBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 */

public class InvoicingItemAdapter extends RecyclerView.Adapter<InvoicingItemAdapter.ViewHolder> {

    private final List<MonthOrderBean.CoffeeBean> mList;
    private final Context mContext;
    private final boolean isCheckedAll;
    private final int index;
    private boolean isSelected = false;

    public InvoicingItemAdapter(Context context, List<MonthOrderBean.CoffeeBean> mList, boolean isCheckedAll, int index) {
        this.mContext = context;
        this.mList = mList;
        this.isCheckedAll = isCheckedAll;
        this.index = index;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public InvoicingItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_item_rv_invoicing, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(final InvoicingItemAdapter.ViewHolder holder, final int position) {
        final MonthOrderBean.CoffeeBean coffeeBean = mList.get(position);
        if (coffeeBean != null) {
            Glide.with(mContext).load(R.mipmap.ic_launcher).into(holder.ivCoffeeImage);
            if (mList.get(position).isSelected) {
                holder.cbStatus.setChecked(true);
            } else {
                holder.cbStatus.setChecked(false);
            }
            holder.tvCoffeeName.setText(coffeeBean.getName());
            holder.tvCoffeeIngredient.setText(coffeeBean.getIngredient());
            holder.tvMoney.setText(coffeeBean.getPrice());
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("position", "onClick: " + position );
                    if (mList.get(position).isSelected) {
//                        holder.cbStatus.setChecked(false);
                        ((InvoicingPlayActivity) mContext).setSelected(index, position, false,coffeeBean);
                    } else {
//                        holder.cbStatus.setChecked(true);
                        ((InvoicingPlayActivity) mContext).setSelected(index, position, true,coffeeBean);
                    }
                }
            });
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
        private CheckBox cbStatus;
        private ImageView ivCoffeeImage;
        private TextView tvCoffeeName;
        private TextView tvCoffeeIngredient;
        private TextView tvMoney;
        boolean selected;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            cbStatus = itemView.findViewById(R.id.cb_status);
            ivCoffeeImage = itemView.findViewById(R.id.iv_coffee_image);
            tvCoffeeName = itemView.findViewById(R.id.tv_coffee_name);
            tvCoffeeIngredient = itemView.findViewById(R.id.tv_coffee_ingredient);
            tvMoney = itemView.findViewById(R.id.tv_money);
        }
    }

}
