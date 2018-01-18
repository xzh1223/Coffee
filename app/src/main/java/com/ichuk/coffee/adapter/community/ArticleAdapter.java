package com.ichuk.coffee.adapter.community;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ichuk.coffee.R;
import com.ichuk.coffee.bean.ArticleBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private final List<ArticleBean> mList;
    private final Context mContext;

    public ArticleAdapter(Context context, List<ArticleBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_community_article, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(ArticleAdapter.ViewHolder holder, final int position) {
        ArticleBean articleBean = mList.get(position);
        if (articleBean != null) {
            holder.tvTime.setText(articleBean.getTime());
            holder.tvTitle.setText(articleBean.getTitle());
            holder.tvName.setText(articleBean.getName());
            Glide.with(mContext).load(articleBean.getImage()).into(holder.ivImage);
            holder.rlReadAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

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
        private TextView tvTime;
        private TextView tvTitle;
        private ImageView ivImage;
        private TextView tvName;
        private RelativeLayout rlReadAll;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            tvTime = itemView.findViewById(R.id.tv_time);
            tvTitle = itemView.findViewById(R.id.tv_title);
            ivImage = itemView.findViewById(R.id.iv_image);
            tvName = itemView.findViewById(R.id.tv_name);
            rlReadAll = itemView.findViewById(R.id.rl_read_all);
        }
    }
}
