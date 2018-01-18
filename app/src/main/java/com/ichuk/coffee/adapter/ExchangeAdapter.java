package com.ichuk.coffee.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.activity.discount.CouponReceiveActivity;
import com.ichuk.coffee.bean.ExchangeCouponBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 */

public class ExchangeAdapter extends RecyclerView.Adapter<ExchangeAdapter.ViewHolder> {

    private final List<ExchangeCouponBean> mList;
    private final Context mContext;

    public ExchangeAdapter(Context context, List<ExchangeCouponBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public ExchangeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_exchange_coupon, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(ExchangeAdapter.ViewHolder holder, int position) {
        final ExchangeCouponBean exchangeCouponBean = mList.get(position);
        if (exchangeCouponBean != null) {
            holder.tvMoney.setText(exchangeCouponBean.getMoney());
            holder.tvCondition.setText(exchangeCouponBean.getCondition());
            holder.tvAddress.setText(exchangeCouponBean.getAddress());
//            holder.tvLimit.setText(exchangeCouponBean.getVip());
//            holder.tvTime.setText(exchangeCouponBean.getStartTime() + "-" + exchangeCouponBean.getEndTime());
//            holder.llToReceive.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(mContext, CouponReceiveActivity.class);
//                    intent.putExtra("bean", exchangeCouponBean);
//                    mContext.startActivity(intent);
//                }
//            });
            holder.tvToReceive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, CouponReceiveActivity.class);
                    intent.putExtra("bean", exchangeCouponBean);
                    mContext.startActivity(intent);
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

        private TextView tvMoney;
        private TextView tvCondition;
        private TextView tvAddress;
//        private TextView tvLimit;
//        private TextView tvTime;
//        private LinearLayout llToReceive;
        private TextView tvToReceive;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            tvMoney = itemView.findViewById(R.id.tv_money);
            tvCondition = itemView.findViewById(R.id.tv_condition);
            tvAddress = itemView.findViewById(R.id.tv_address);
//            tvLimit = itemView.findViewById(R.id.tv_limit);
//            tvTime = itemView.findViewById(R.id.tv_time);
//            llToReceive = itemView.findViewById(R.id.ll_to_receive);
            tvToReceive = itemView.findViewById(R.id.tv_to_receive);
        }
    }

}
