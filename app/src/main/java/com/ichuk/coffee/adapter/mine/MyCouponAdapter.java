package com.ichuk.coffee.adapter.mine;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.activity.mine.DonatedActivity;
import com.ichuk.coffee.activity.mine.ProductListActivity;
import com.ichuk.coffee.bean.CouponBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 *
 */

public class MyCouponAdapter extends RecyclerView.Adapter<MyCouponAdapter.ViewHolder> {

    private final List<CouponBean> mList;
    private final Context mContext;

    public MyCouponAdapter(Context context, List<CouponBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_my_coupon, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final CouponBean couponBean = mList.get(position);
        if (couponBean != null) {
            if (couponBean.getStatus() == 0) {
                holder.tvStatus.setText("即将过期");
                holder.tvDonated.setVisibility(View.VISIBLE);
                holder.tvToUse.setVisibility(View.VISIBLE);
                holder.tvStatus.setTextColor(mContext.getResources().getColor(R.color.md_white_1000));
                holder.tvStatus.setBackgroundResource(R.drawable.teste_standard_ok);
                holder.tvMoney.setTextColor(mContext.getResources().getColor(R.color.red));
                holder.tvLimit.setTextColor(mContext.getResources().getColor(R.color.md_grey_600));
                holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.md_grey_700));
                holder.tvTime.setTextColor(mContext.getResources().getColor(R.color.md_grey_600));
                holder.tvToUse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(mContext, ProductListActivity.class);
                        mContext.startActivity(intent);
                    }
                });
                holder.tvDonated.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(mContext, DonatedActivity.class);
                        intent.putExtra("page", "优惠券");
                        intent.putExtra("bean", couponBean);
                        mContext.startActivity(intent);
                    }
                });
            } else if (couponBean.getStatus() == 1){
                holder.tvStatus.setText("已使用");
                holder.tvDonated.setVisibility(View.GONE);
                holder.tvToUse.setVisibility(View.GONE);
                holder.tvStatus.setBackgroundColor(mContext.getResources().getColor(R.color.md_white_1000));
                holder.tvStatus.setTextColor(mContext.getResources().getColor(R.color.md_grey_400));
                holder.tvMoney.setTextColor(mContext.getResources().getColor(R.color.md_grey_400));
                holder.tvLimit.setTextColor(mContext.getResources().getColor(R.color.md_grey_400));
                holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.md_grey_400));
                holder.tvTime.setTextColor(mContext.getResources().getColor(R.color.md_grey_400));
            } else if (couponBean.getStatus() == 2) {
                holder.tvStatus.setText("已过期");
                holder.tvDonated.setVisibility(View.GONE);
                holder.tvToUse.setVisibility(View.GONE);
                holder.tvStatus.setTextColor(mContext.getResources().getColor(R.color.md_grey_400));
                holder.tvStatus.setBackgroundColor(mContext.getResources().getColor(R.color.md_white_1000));
                holder.tvMoney.setTextColor(mContext.getResources().getColor(R.color.md_grey_400));
                holder.tvLimit.setTextColor(mContext.getResources().getColor(R.color.md_grey_400));
                holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.md_grey_400));
                holder.tvTime.setTextColor(mContext.getResources().getColor(R.color.md_grey_400));
            }
            holder.tvMoney.setText(couponBean.getMoney());
            holder.tvLimit.setText(couponBean.getLimit());
            holder.tvTitle.setText(couponBean.getTitle());
            holder.tvTime.setText(couponBean.getTime());
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


        private TextView tvStatus;
        private TextView tvMoney;
        private TextView tvLimit;
        private TextView tvTitle;
        private TextView tvTime;
        private RelativeLayout rlBottom;
        private TextView tvToUse;
        private TextView tvDonated;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            tvStatus = itemView.findViewById( R.id.tv_status );
            tvMoney = itemView.findViewById( R.id.tv_money );
            tvLimit = itemView.findViewById( R.id.tv_limit );
            tvTitle = itemView.findViewById( R.id.tv_title );
            tvTime = itemView.findViewById( R.id.tv_time );
            rlBottom = itemView.findViewById( R.id.rl_bottom );
            tvToUse = itemView.findViewById( R.id.tv_to_use );
            tvDonated = itemView.findViewById( R.id.tv_donated );
        }
    }
}
