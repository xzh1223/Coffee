package com.ichuk.coffee.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.bean.MyGiftCardBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 *
 */

public class MyGiftCardAdapter extends RecyclerView.Adapter<MyGiftCardAdapter.ViewHolder> {

    private final List<MyGiftCardBean> mList;
    private final Context mContext;
    private final int mStatus;

    public MyGiftCardAdapter(Context context, List<MyGiftCardBean> mList, int mStatus) {
        this.mContext = context;
        this.mList = mList;
        this.mStatus = mStatus;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public MyGiftCardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_my_gift_card, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(MyGiftCardAdapter.ViewHolder holder, int position) {
        MyGiftCardBean myGiftCardBean = mList.get(position);
        if (myGiftCardBean != null) {
            if (mStatus == 0) {
                holder.tvDonated.setVisibility(View.VISIBLE);
                holder.rlBottom.setVisibility(View.GONE);
                if (myGiftCardBean.getType() == 0) {
                    holder.tvType.setText("自买");
                    holder.rlBackground.setBackgroundResource(R.drawable.coffee_detail_selected);
                } else if (myGiftCardBean.getType() == 1) {
                    holder.tvType.setText("他送");
                    holder.rlBackground.setBackgroundResource(R.drawable.bg_card_background);
                }
            } else if (mStatus == 1) {
                holder.tvDonated.setVisibility(View.GONE);
                holder.rlBottom.setVisibility(View.VISIBLE);
                if (myGiftCardBean.getType() == 0) {
                    holder.tvType.setText("未充值");
                    holder.rlBackground.setBackgroundResource(R.drawable.coffee_detail_selected);
                } else if (myGiftCardBean.getType() == 1) {
                    holder.tvType.setText("已充值");
                    holder.rlBackground.setBackgroundResource(R.drawable.bg_card_background);
                }
            }
            holder.tvMoney.setText("￥" + myGiftCardBean.getMoney() + "储值卡");

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
        private RelativeLayout rlBackground;
        private RelativeLayout rlBottom;
        private TextView tvType;
        private TextView tvMoney;
        private TextView tvDonated;
        private TextView tvAccount;
        private TextView tvPassword;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            rlBackground = itemView.findViewById(R.id.rl_background);
            rlBottom = itemView.findViewById(R.id.rl_bottom);
            tvType = itemView.findViewById(R.id.tv_type);
            tvMoney = itemView.findViewById(R.id.tv_money);
            tvDonated = itemView.findViewById(R.id.tv_donated);
            tvAccount = itemView.findViewById(R.id.tv_account);
            tvPassword = itemView.findViewById(R.id.tv_password);
        }
    }

}
