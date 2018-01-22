package com.ichuk.coffee.adapter.mine;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.bean.MonthOrderBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 *
 */

public class InvoicingAdapter extends RecyclerView.Adapter<InvoicingAdapter.ViewHolder> {

    private final List<MonthOrderBean> mList;
    private final Context mContext;
    private final boolean isCheckedAll;

    public InvoicingAdapter(Context context, List<MonthOrderBean> mList, boolean isCheckedAll) {
        this.mContext = context;
        this.mList = mList;
        this.isCheckedAll = isCheckedAll;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public InvoicingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_invoicing, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(InvoicingAdapter.ViewHolder holder, final int position) {
        MonthOrderBean monthOrderBean = mList.get(position);
        if (monthOrderBean != null) {
            holder.tvMonth.setText(monthOrderBean.getMonth());
            if (position == 0) {
                holder.tvInfo.setVisibility(View.VISIBLE);
            } else {
                holder.tvInfo.setVisibility(View.GONE);
            }
            holder.setRecyclerView(monthOrderBean.getCoffeeBeanList());
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
        TextView tvMonth;
        TextView tvInfo;
        RecyclerView rvCoffee;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            tvMonth = itemView.findViewById(R.id.tv_month);
            tvInfo = itemView.findViewById(R.id.tv_info);
            rvCoffee = itemView.findViewById(R.id.rv_coffee);
        }

        /**
         * set recyclerView
         */
        public void setRecyclerView(List<MonthOrderBean.CoffeeBean> coffeeBeanList) {
            rvCoffee.setLayoutManager(new LinearLayoutManager(mContext));
            rvCoffee.setAdapter(new InvoicingItemAdapter(mContext, coffeeBeanList, isCheckedAll));
        }
    }

}
