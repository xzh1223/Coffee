package com.ichuk.coffee.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ichuk.coffee.R;
import com.ichuk.coffee.activity.mine.OrderDetailsActivity;
import com.ichuk.coffee.bean.CoffeeBean;
import com.ichuk.coffee.bean.OrderBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 *
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private final List<OrderBean> mList;
    private final Context mContext;
    private AlertDialog mDialog;

    public OrderAdapter(Context context, List<OrderBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_order, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(OrderAdapter.ViewHolder holder, final int position) {
        final OrderBean orderBean = mList.get(position);
        if (orderBean != null) {
            Glide.with(mContext).load(R.mipmap.ic_launcher).into(holder.ivShopLogo);
            holder.tvShopName.setText(orderBean.getShopName());
            holder.tvType.setText("");
            holder.tvCoffeeNum.setText("共" + orderBean.getCoffeeBeanList().size() + "杯咖啡");
            holder.tvCoffeePrice.setText("合计：￥" + "65");
            holder.setRecyclerView(orderBean.getCoffeeBeanList());
            if (orderBean.getType() == 1) {
                // 待付款
                holder.tvToPay.setVisibility(View.VISIBLE);
                holder.tvCancelOrder.setVisibility(View.VISIBLE);
                holder.tvToPay.setText("立即付款");
                holder.tvCancelOrder.setText("取消订单");
            } else if (orderBean.getType() == 2) {
                // 申请退款
                holder.tvToPay.setVisibility(View.VISIBLE);
                holder.tvCancelOrder.setVisibility(View.VISIBLE);
                holder.tvToPay.setText("申请退款");
                holder.tvCancelOrder.setText("查看取杯码");
                holder.tvCancelOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showDialog();
                    }
                });
            } else if (orderBean.getType() == 3) {
                // 退款/售后
                holder.tvToPay.setVisibility(View.GONE);
                holder.tvCancelOrder.setVisibility(View.GONE);
            } else if (orderBean.getType() == 0) {
                // 全部
                holder.tvCancelOrder.setVisibility(View.GONE);
                holder.tvToPay.setVisibility(View.VISIBLE);
                holder.tvToPay.setText("再来一单");
            }
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (orderBean.getType() == 0) {
                        // nothing to do
                    } else {
                        Intent intent = new Intent(mContext, OrderDetailsActivity.class);
                        intent.putExtra("orderBean", orderBean);
                        mContext.startActivity(intent);
                    }
                }
            });
        }
    }

    /**
     * show dialog for  take cup code
     */
    private void showDialog() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_dialog_show_code, null);
        AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
        dialog.setView(view);
        mDialog = dialog.create();
        mDialog.show();
        TextView tvCode = view.findViewById(R.id.tv_code);
        ImageView ivEsc = view.findViewById(R.id.iv_esc);
        ivEsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDialog != null) {
                    mDialog.dismiss();
                }
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

        private ImageView ivShopLogo;
        private TextView tvShopName;
        private TextView tvType;
        private RecyclerView rvCoffee;
        private TextView tvCoffeePrice;
        private TextView tvCoffeeNum;
        private TextView tvToPay;
        private TextView tvCancelOrder;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ivShopLogo = itemView.findViewById(R.id.iv_shop_logo);
            tvShopName = itemView.findViewById(R.id.tv_shop_name);
            tvType = itemView.findViewById(R.id.tv_type);
            rvCoffee = itemView.findViewById(R.id.rv_coffee);
            tvCoffeePrice = itemView.findViewById(R.id.tv_coffee_price);
            tvCoffeeNum = itemView.findViewById(R.id.tv_coffee_num);
            tvToPay = itemView.findViewById(R.id.tv_to_pay);
            tvCancelOrder = itemView.findViewById(R.id.tv_cancel_order);
        }

        /**
         * set recyclerView
         */
        public void setRecyclerView(List<CoffeeBean> coffeeBeanList) {
            rvCoffee.setLayoutManager(new LinearLayoutManager(mContext));
            rvCoffee.setAdapter(new OrderItemAdapter(mContext, coffeeBeanList));
        }
    }

}
