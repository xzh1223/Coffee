package com.ichuk.coffee.adapter.community;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ichuk.coffee.R;
import com.ichuk.coffee.activity.community.CommentActivity;
import com.ichuk.coffee.activity.community.LeaveMessageActivity;
import com.ichuk.coffee.bean.CommunityBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 */

public class LeaveMessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<CommunityBean> mList;
    private final Context mContext;
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    private int currentType = TYPE_HEADER;

    public LeaveMessageAdapter(Context context, List<CommunityBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case TYPE_HEADER:
                currentType = TYPE_HEADER;
                break;
            case TYPE_NORMAL:
                currentType = TYPE_NORMAL;
                break;
            default:
                currentType = TYPE_NORMAL;
                break;
        }
        return currentType;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View itemView = View.inflate(mContext, R.layout.item_rv_community_leave_message_header, null);
            return new HeaderViewHolder(itemView);
        } else if (viewType == TYPE_NORMAL) {
            View itemView = View.inflate(mContext, R.layout.item_rv_community_leave_message, null);
            return new ViewHolder(itemView);
        }
        return null;
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position) == TYPE_HEADER) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            headerViewHolder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, LeaveMessageActivity.class);
                    mContext.startActivity(intent);
                }
            });
        } else if (getItemViewType(position) == TYPE_NORMAL) {
            ViewHolder viewHolder = (ViewHolder) holder;
            switch (position % 7) {
                case 1:
                    viewHolder.llView.setBackgroundResource(R.color.leave_message_1);
                    break;
                case 2:
                    viewHolder.llView.setBackgroundResource(R.color.leave_message_2);
                    break;
                case 3:
                    viewHolder.llView.setBackgroundResource(R.color.leave_message_3);
                    break;
                case 4:
                    viewHolder.llView.setBackgroundResource(R.color.leave_message_4);
                    break;
                case 5:
                    viewHolder.llView.setBackgroundResource(R.color.leave_message_5);
                    break;
                case 6:
                    viewHolder.llView.setBackgroundResource(R.color.leave_message_6);
                    break;
                case 0:
                    viewHolder.llView.setBackgroundResource(R.color.leave_message_7);
                    break;
            }
            final CommunityBean communityBean = mList.get(position - 1);
            Glide.with(mContext).load(R.mipmap.ic_launcher_round).into(viewHolder.civCommunityAvatar);
            viewHolder.tvCommunityNickname.setText(communityBean.getName());
            viewHolder.tvCommunityContent.setText(communityBean.getContent());
            viewHolder.tvCommunityLikeNum.setText(communityBean.getLikeNum() + "");
            viewHolder.tvCommunityCommentNum.setText(communityBean.getCommentNum() + "");
            viewHolder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, CommentActivity.class);
                    intent.putExtra("id", communityBean.getId());
                    intent.putExtra("image", communityBean.getImage());
                    intent.putExtra("name", communityBean.getName());
                    intent.putExtra("time", communityBean.getTime());
                    intent.putExtra("content", communityBean.getContent());
                    intent.putExtra("likeNum", communityBean.getLikeNum());
                    intent.putExtra("commentNum", communityBean.getCommentNum());
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
        return mList.size() + 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView civCommunityAvatar;
        TextView tvCommunityNickname;
        TextView tvCommunityContent;
        TextView tvCommunityLikeNum;
        TextView tvCommunityCommentNum;
        View view;
        LinearLayout llView;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            civCommunityAvatar = itemView.findViewById(R.id.civ_community_avatar);
            tvCommunityNickname = itemView.findViewById(R.id.tv_community_nickname);
            tvCommunityContent = itemView.findViewById(R.id.tv_community_content);
            tvCommunityLikeNum = itemView.findViewById(R.id.tv_community_like_num);
            tvCommunityCommentNum = itemView.findViewById(R.id.tv_community_comment_num);
            llView = itemView.findViewById(R.id.ll_view);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        View view;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            view = itemView;
        }
    }

}
