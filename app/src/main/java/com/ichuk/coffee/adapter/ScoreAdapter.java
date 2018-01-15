package com.ichuk.coffee.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.bean.ScoreBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 */

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ViewHolder> {

    private final List<ScoreBean.ScoreData> mList;
    private final Context mContext;

    public ScoreAdapter(Context context, List<ScoreBean.ScoreData> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_my_score, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ScoreBean.ScoreData scoreData = mList.get(position);
        if (scoreData != null) {
            holder.tvContent.setText(scoreData.getContent());
            holder.tvTime.setText(scoreData.getTime());
            holder.tvNum.setText(scoreData.getNumber());
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
        private TextView tvNum;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            tvContent = itemView.findViewById(R.id.tv_content);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvNum = itemView.findViewById(R.id.tv_num);
        }
    }

}
