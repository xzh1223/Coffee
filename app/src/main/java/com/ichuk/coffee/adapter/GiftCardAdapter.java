package com.ichuk.coffee.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ichuk.coffee.R;
import com.ichuk.coffee.activity.discount.GiftCardBuyActivity;
import com.ichuk.coffee.bean.GiftCardBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 *
 */

public class GiftCardAdapter extends RecyclerView.Adapter<GiftCardAdapter.ViewHolder> {

    private final List<GiftCardBean> mList;
    private final Context mContext;

    public GiftCardAdapter(Context context, List<GiftCardBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public GiftCardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_gift_card, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(GiftCardAdapter.ViewHolder holder, int position) {
        final GiftCardBean giftCardBean = mList.get(position);
        if (giftCardBean != null) {
            Glide.with(mContext).load(R.mipmap.ic_launcher).into(holder.ivImage);
            holder.tvTitle.setText(giftCardBean.getTitle());
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, GiftCardBuyActivity.class);
                    intent.putExtra("bean", giftCardBean);
                    mContext.startActivity(intent);
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

        View view;
        private ImageView ivImage;
        private TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ivImage = itemView.findViewById(R.id.iv_image);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }

}
