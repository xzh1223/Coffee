package com.ichuk.coffee.adapter.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.activity.home.SelectCouponActivity;
import com.ichuk.coffee.bean.CouponBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 */

public class SelectCouponAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int mIndex;
    private List<CouponBean> mCouponBeanList;
    private final Context mContext;

    public SelectCouponAdapter(Context context, List<CouponBean> mList, int index) {
        this.mContext = context;
        mCouponBeanList = mList;
        mIndex = index;
    }

    /**
     * Called when RecyclerView needs a new {@link } of the given type to represent
     * an item.
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_my_coupon, null);
        return new CouponViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        final CouponViewHolder viewHolder = (CouponViewHolder) holder;
        CouponBean couponBean = mCouponBeanList.get(position);
        if (couponBean != null) {
            if (mIndex == position && mIndex >= 0) {
                mCouponBeanList.get(position).isSelected = true;
            } else {
                mCouponBeanList.get(position).isSelected = false;
            }
            if (couponBean.isSelected) {
                viewHolder.ivSelected.setImageResource(R.mipmap.icon_selected);
            } else {
                viewHolder.ivSelected.setImageResource(R.mipmap.icon_no_selected);
            }
            mCouponBeanList.get(position).isSelected = false;
            viewHolder.tvStatus.setVisibility(View.GONE);
            viewHolder.rlSelected.setVisibility(View.VISIBLE);
            viewHolder.tvMoney.setText(couponBean.getMoney());
            viewHolder.tvLimit.setText(couponBean.getLimit());
            viewHolder.tvTitle.setText(couponBean.getTitle());
            viewHolder.tvTime.setText(couponBean.getTime());
            viewHolder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setSelected(position);
                    ((SelectCouponActivity) mContext).setSelected(position);

                }
            });
        }
    }

    private void setSelected(int position) {
        for (int i = 0; i < mCouponBeanList.size(); i++) {
            if (i == position) {
                mCouponBeanList.get(i).isSelected = true;
            } else {
                mCouponBeanList.get(i).isSelected = false;
            }
            Log.e("printBooleanByPosition", "setSelected: " + mCouponBeanList.get(i).isSelected);
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mCouponBeanList.size();
    }

    class CouponViewHolder extends RecyclerView.ViewHolder {

        private TextView tvStatus;
        private TextView tvMoney;
        private TextView tvLimit;
        private TextView tvTitle;
        private TextView tvTime;
        private RelativeLayout rlSelected;
        private ImageView ivSelected;
        View view;

        public CouponViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            tvStatus = itemView.findViewById(R.id.tv_status);
            tvMoney = itemView.findViewById(R.id.tv_money);
            tvLimit = itemView.findViewById(R.id.tv_limit);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvTime = itemView.findViewById(R.id.tv_time);
            rlSelected = itemView.findViewById(R.id.rl_selected);
            ivSelected = itemView.findViewById(R.id.iv_selected);
        }
    }
}
