package com.ichuk.coffee.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ichuk.coffee.R;
import com.ichuk.coffee.activity.mine.DonatedActivity;
import com.ichuk.coffee.bean.AllowanceBean;
import com.ichuk.coffee.utils.ToastUtil;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 *
 */

public class MyAllowanceAdapter extends RecyclerView.Adapter<MyAllowanceAdapter.ViewHolder> {

    private final List<AllowanceBean> mList;
    private final Context mContext;

    public MyAllowanceAdapter(Context context, List<AllowanceBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_allowance, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final AllowanceBean allowanceBean = mList.get(position);
        if (allowanceBean != null) {
            if (allowanceBean.getStatus() == 0) {
                holder.tvDonated.setVisibility(View.VISIBLE);
                holder.tvToUse.setVisibility(View.VISIBLE);
                holder.tvMoney.setTextColor(mContext.getResources().getColor(R.color.brown));
                holder.tvLimit.setTextColor(mContext.getResources().getColor(R.color.md_grey_400));
                holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.md_grey_700));
                holder.tvTime.setTextColor(mContext.getResources().getColor(R.color.md_grey_400));
                holder.tvToUse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ToastUtil.toast(mContext, "立即使用");
                    }
                });
                holder.tvDonated.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(mContext, DonatedActivity.class);
                        intent.putExtra("bean", allowanceBean);
                        intent.putExtra("page", "补贴");
                        mContext.startActivity(intent);
                    }
                });
            } else if (allowanceBean.getStatus() == 1) {
                holder.tvDonated.setVisibility(View.GONE);
                holder.tvToUse.setVisibility(View.GONE);
                holder.tvMoney.setTextColor(mContext.getResources().getColor(R.color.md_grey_400));
                holder.tvLimit.setTextColor(mContext.getResources().getColor(R.color.md_grey_400));
                holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.md_grey_400));
                holder.tvTime.setTextColor(mContext.getResources().getColor(R.color.md_grey_400));
            } else if (allowanceBean.getStatus() == 2) {
                holder.tvDonated.setVisibility(View.GONE);
                holder.tvToUse.setVisibility(View.GONE);
                holder.tvMoney.setTextColor(mContext.getResources().getColor(R.color.md_grey_400));
                holder.tvLimit.setTextColor(mContext.getResources().getColor(R.color.md_grey_400));
                holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.md_grey_400));
                holder.tvTime.setTextColor(mContext.getResources().getColor(R.color.md_grey_400));
            }
            holder.tvMoney.setText(allowanceBean.getMoney());
            holder.tvLimit.setText(allowanceBean.getLimit());
            holder.tvTitle.setText(allowanceBean.getTitle());
            holder.tvTime.setText(allowanceBean.getTime());
            Glide.with(mContext).load(R.mipmap.ic_launcher).into(holder.ivImage);
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
        private TextView tvLimit;
        private TextView tvTitle;
        private TextView tvTime;
        private RelativeLayout rlBottom;
        private TextView tvToUse;
        private TextView tvDonated;
        private ImageView ivImage;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ivImage = itemView.findViewById(R.id.iv_image);
            tvMoney = itemView.findViewById(R.id.tv_money);
            tvLimit = itemView.findViewById(R.id.tv_limit);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvTime = itemView.findViewById(R.id.tv_time);
            rlBottom = itemView.findViewById(R.id.rl_bottom);
            tvToUse = itemView.findViewById(R.id.tv_to_use);
            tvDonated = itemView.findViewById(R.id.tv_donated);
        }
    }
}
