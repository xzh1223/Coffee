package com.ichuk.coffee.adapter.mine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ichuk.coffee.R;

import java.util.List;

/**
 * Created by xzh on 2018/1/18.
 */

public class CodeOrderDetailsAdapter extends RecyclerView.Adapter<CodeOrderDetailsAdapter.ViewHolder> {
    private final List<String> mList;
    private final Context mContext;
    private final int mFlag;

    public CodeOrderDetailsAdapter(Context mContext, List<String> codeList, int flag) {
        this.mContext = mContext;
        this.mList = codeList;
        this.mFlag = flag;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link #(ViewHolder, int, List)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(ViewHolder, int)
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(mContext, R.layout.item_rv_code_order_detail, null));
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link ViewHolder#getAdapterPosition()} which will
     * have the updated adapter position.
     * <p>
     * Override {@link #(ViewHolder, int, List)} instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String codeStr = mList.get(position);
        if (codeStr != null) {
            if (mFlag == 0) {
                holder.ivCheckCode.setVisibility(View.GONE);
                holder.tvUsable.setVisibility(View.VISIBLE);
            } else if (mFlag == 1){
                holder.ivCheckCode.setVisibility(View.VISIBLE);
                holder.tvUsable.setVisibility(View.GONE);
                holder.ivCheckCode.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }
            holder.tvCode.setText(codeStr);
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

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvUsable;
        TextView tvCode;
        ImageView ivCheckCode;

        public ViewHolder(View itemView) {
            super(itemView);
            tvUsable = itemView.findViewById(R.id.tv_usable);
            tvCode = itemView.findViewById(R.id.tv_code);
            ivCheckCode = itemView.findViewById(R.id.iv_check_code);
        }
    }
}
