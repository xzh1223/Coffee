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
import com.ichuk.coffee.bean.AllowanceBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 */

public class SelectAllowanceAdapter extends RecyclerView.Adapter<SelectAllowanceAdapter.ViewHolder> {

    private final int mIndex;
    private List<AllowanceBean> mAllowanceBeanList;
    private final Context mContext;

    public SelectAllowanceAdapter(Context context, List<AllowanceBean> mList, int index) {
        this.mContext = context;
        mAllowanceBeanList = mList;
        this.mIndex = index;
    }

    /**
     * Called when RecyclerView needs a new {@link } of the given type to represent
     * an item.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_allowance, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        AllowanceBean allowanceBean = mAllowanceBeanList.get(position);
        if (allowanceBean != null) {
            if (mIndex == position && mIndex >= 0) {
                mAllowanceBeanList.get(position).isSelected = true;
            } else {
                mAllowanceBeanList.get(position).isSelected = false;
            }
            if (mAllowanceBeanList.get(position).isSelected) {
                holder.ivSelected.setImageResource(R.mipmap.icon_selected);
            } else {
                holder.ivSelected.setImageResource(R.mipmap.icon_no_selected);
            }
            holder.rlBottom.setVisibility(View.GONE);
            holder.rlSelected.setVisibility(View.VISIBLE);
            holder.tvMoney.setText(allowanceBean.getMoney());
            holder.tvLimit.setText(allowanceBean.getLimit());
            holder.tvTitle.setText(allowanceBean.getTitle());
            holder.tvTime.setText(allowanceBean.getTime());
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setSelected(position);
                    ((SelectCouponActivity) mContext).setSelected(position);
                }
            });
        }

    }

    private void setSelected(int position) {
        for (int i = 0; i < mAllowanceBeanList.size(); i++) {
            if (i == position) {
                mAllowanceBeanList.get(i).isSelected = true;
            } else {
                mAllowanceBeanList.get(i).isSelected = false;
            }
            Log.e("printBooleanByPosition", "setSelected: " + mAllowanceBeanList.get(i).isSelected);
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mAllowanceBeanList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivImage;
        private TextView tvTitle;
        private TextView tvLimit;
        private TextView tvMoney;
        private TextView tvTime;
        private RelativeLayout rlSelected;
        private RelativeLayout rlBottom;
        private ImageView ivSelected;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ivImage = itemView.findViewById(R.id.iv_image);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvLimit = itemView.findViewById(R.id.tv_limit);
            tvMoney = itemView.findViewById(R.id.tv_money);
            tvTime = itemView.findViewById(R.id.tv_time);
            rlBottom = itemView.findViewById(R.id.rl_bottom);
            rlSelected = itemView.findViewById(R.id.rl_selected);
            ivSelected = itemView.findViewById(R.id.iv_selected);
        }
    }

}
