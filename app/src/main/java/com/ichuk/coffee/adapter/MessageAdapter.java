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
import com.ichuk.coffee.activity.mine.MessageDetailsActivity;
import com.ichuk.coffee.bean.MessageBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 *
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private final List<MessageBean> mList;
    private final Context mContext;

    public MessageAdapter(Context context, List<MessageBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_message, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(MessageAdapter.ViewHolder holder, final int position) {
        final MessageBean messageBean = mList.get(position);
        if (messageBean != null) {
            Glide.with(mContext).load(R.mipmap.ic_launcher).into(holder.ivMessageImage);
            holder.tvMessageTitle.setText(messageBean.getTitle());
            holder.tvMessageTime.setText(messageBean.getTime());
            holder.tvMessageContent.setText(messageBean.getContent());
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, MessageDetailsActivity.class);
                    intent.putExtra("content", messageBean.getContent());
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

        private ImageView ivMessageImage;
        private TextView tvMessageTitle;
        private TextView tvMessageContent;
        private TextView tvMessageTime;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ivMessageImage = itemView.findViewById(R.id.iv_message_image);
            tvMessageTitle = itemView.findViewById(R.id.tv_message_title);
            tvMessageContent = itemView.findViewById(R.id.tv_message_content);
            tvMessageTime = itemView.findViewById(R.id.tv_message_time);
        }
    }

}
