package com.ichuk.coffee.adapter.mine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.bean.ExpensesRecordBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 */

public class ExpensesAdapter extends RecyclerView.Adapter<ExpensesAdapter.ViewHolder> {

    private final List<ExpensesRecordBean> mList;
    private final Context mContext;

    public ExpensesAdapter(Context context, List<ExpensesRecordBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public ExpensesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_expenses, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(ExpensesAdapter.ViewHolder holder, int position) {
        ExpensesRecordBean expensesRecordBean = mList.get(position);
        if (expensesRecordBean != null) {
            holder.tvContent.setText(expensesRecordBean.getContent());
            holder.tvTime.setText(expensesRecordBean.getTime());
            holder.tvMoney.setText(expensesRecordBean.getMoney());
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

        private TextView tvContent;
        private TextView tvTime;
        private TextView tvMoney;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            tvContent = itemView.findViewById(R.id.tv_content);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvMoney = itemView.findViewById(R.id.tv_money);
        }
    }

}
