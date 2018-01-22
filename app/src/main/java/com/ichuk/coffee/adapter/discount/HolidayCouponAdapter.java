package com.ichuk.coffee.adapter.discount;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.bean.HolidayCouponBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 *
 */

public class HolidayCouponAdapter extends RecyclerView.Adapter<HolidayCouponAdapter.ViewHolder> {

    private final List<HolidayCouponBean> mList;
    private final Context mContext;

    public HolidayCouponAdapter(Context context, List<HolidayCouponBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public HolidayCouponAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_holiday_coupon, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(HolidayCouponAdapter.ViewHolder holder, int position) {
        HolidayCouponBean holidayCouponBean = mList.get(position);
        if (holidayCouponBean != null) {
            holder.tvMoney.setText(holidayCouponBean.getMoney());
            holder.tvCondition.setText(holidayCouponBean.getCondition());
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
        private TextView tvMoney;
        private TextView tvCondition;
        private TextView tvToReceive;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            tvMoney = itemView.findViewById(R.id.tv_money);
            tvCondition = itemView.findViewById(R.id.tv_condition);
            tvToReceive =  itemView.findViewById(R.id.tv_to_receive);
        }
    }

}
