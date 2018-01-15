package com.ichuk.coffee.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ichuk.coffee.R;
import com.ichuk.coffee.bean.CommentBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by xzh on 2017/12/5.
 */

public class CommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<CommentBean> mList;
    private final Context mContext;

    public CommentAdapter(Context context, List<CommentBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_comment, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        CommentBean commentBean = mList.get(position);
        Glide.with(mContext).load(R.mipmap.ic_launcher_round).into(viewHolder.civCommentAvatar);
        viewHolder.tvCommentNickname.setText(commentBean.getName());
        viewHolder.tvCommentTime.setText(commentBean.getTime());
        viewHolder.tvCommentContent.setText(commentBean.getContent());

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

        CircleImageView civCommentAvatar;
        TextView tvCommentNickname;
        TextView tvCommentTime;
        TextView tvCommentContent;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            civCommentAvatar = itemView.findViewById(R.id.civ_comment_avatar);
            tvCommentNickname = itemView.findViewById(R.id.tv_comment_nickname);
            tvCommentTime = itemView.findViewById(R.id.tv_comment_time);
            tvCommentContent = itemView.findViewById(R.id.tv_comment_content);
        }
    }

}
