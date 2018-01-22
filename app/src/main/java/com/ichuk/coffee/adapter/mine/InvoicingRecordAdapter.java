package com.ichuk.coffee.adapter.mine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.activity.mine.InvoicingDetailActivity;
import com.ichuk.coffee.activity.mine.InvoicingRecordActivity;
import com.ichuk.coffee.bean.InvoicingBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 */

public class InvoicingRecordAdapter extends RecyclerView.Adapter<InvoicingRecordAdapter.ViewHolder> {

    private final Context mContext;
    private final List<InvoicingBean> mList;

    public InvoicingRecordAdapter(Context context, List<InvoicingBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public InvoicingRecordAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_invoicing_record, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(InvoicingRecordAdapter.ViewHolder holder, final int position) {
        InvoicingBean invoicingBean = mList.get(position);
        if (invoicingBean != null) {
            holder.tvMoney.setText(invoicingBean.getMoney());
            holder.tvName.setText(invoicingBean.getName());
            holder.tvTime.setText(invoicingBean.getTime());
            holder.tvPlayed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((InvoicingRecordActivity)mContext).toActivity(InvoicingDetailActivity.class);
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


        private TextView tvTime;
        private TextView tvPlayed;
        private TextView tvMoney;
        private TextView tvName;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            tvTime = itemView.findViewById( R.id.tv_time );
            tvPlayed = itemView.findViewById( R.id.tv_played );
            tvMoney = itemView.findViewById( R.id.tv_money );
            tvName = itemView.findViewById( R.id.tv_name );
        }
    }

}
