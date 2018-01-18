package com.ichuk.coffee.adapter.mine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ichuk.coffee.R;
import com.ichuk.coffee.bean.MineGridBean;
import com.ichuk.coffee.listener.OnItemClickListener;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 */

public class MineAdapter extends RecyclerView.Adapter<MineAdapter.ViewHolder> {

    private final List<MineGridBean> mList;
    private final Context mContext;
    private OnItemClickListener listener;

    public MineAdapter(Context context, List<MineGridBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public MineAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_gv_mine, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(MineAdapter.ViewHolder holder, final int position) {
        MineGridBean mineGridBean = mList.get(position);
        if (mineGridBean != null) {
            Glide.with(mContext).load(mineGridBean.getImage()).into(holder.ivImage);
            holder.tvName.setText(mineGridBean.getName());
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onItemClickListener(view, position);
                    }
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
        ImageView ivImage;
        TextView tvName;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ivImage = itemView.findViewById(R.id.iv_image);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}
