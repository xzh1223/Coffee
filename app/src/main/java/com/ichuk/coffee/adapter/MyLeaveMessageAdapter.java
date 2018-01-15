package com.ichuk.coffee.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ichuk.coffee.R;
import com.ichuk.coffee.bean.CommunityBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by xzh on 2017/12/5.
 */

public class MyLeaveMessageAdapter extends RecyclerView.Adapter<MyLeaveMessageAdapter.ViewHolder> {

    private final List<CommunityBean> mList;
    private final Context mContext;

    public MyLeaveMessageAdapter(Context context, List<CommunityBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public MyLeaveMessageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_my_leave_message, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(MyLeaveMessageAdapter.ViewHolder holder, int position) {
        CommunityBean communityBean = mList.get(position);
        if (communityBean != null) {
            Glide.with(mContext).load(R.mipmap.ic_launcher_round).into(holder.civCommunityAvatar);
            holder.tvCommunityNickname.setText(communityBean.getName());
            holder.tvCommunityContent.setText(communityBean.getContent());
            holder.tvCommunityLikeNum.setText(communityBean.getLikeNum() + "");
            holder.tvCommunityCommentNum.setText(communityBean.getCommentNum() + "");
            holder.tvCommunityTime.setText(communityBean.getTime());
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

        private CircleImageView civCommunityAvatar;
        private TextView tvCommunityNickname;
        private TextView tvCommunityTime;
        private TextView tvCommunityContent;
        private TextView tvCommunityLikeNum;
        private TextView tvCommunityCommentNum;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            civCommunityAvatar = itemView.findViewById(R.id.civ_community_avatar);
            tvCommunityNickname = itemView.findViewById(R.id.tv_community_nickname);
            tvCommunityTime = itemView.findViewById(R.id.tv_community_time);
            tvCommunityContent = itemView.findViewById(R.id.tv_community_content);
            tvCommunityLikeNum = itemView.findViewById(R.id.tv_community_like_num);
            tvCommunityCommentNum = itemView.findViewById(R.id.tv_community_comment_num);
        }
    }

}
