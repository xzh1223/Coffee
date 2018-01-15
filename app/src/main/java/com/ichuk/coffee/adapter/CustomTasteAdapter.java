package com.ichuk.coffee.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.bean.PowderOrJamBean;
import com.ichuk.coffee.widget.AddOrLessView;

import java.util.List;

/**
 * Created by xzh on 2018/1/12.
 *
 */

public class CustomTasteAdapter extends RecyclerView.Adapter<CustomTasteAdapter.ViewHolder> {

    private final List<PowderOrJamBean> mList;
    private final Context mContext;

    public CustomTasteAdapter(Context context, List<PowderOrJamBean> list) {
        this.mContext = context;
        this.mList = list;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_rv_powder_or_jam, null);
        return new ViewHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final PowderOrJamBean powderOrJamBean = mList.get(position);
        if (powderOrJamBean != null) {
            String nameStr = powderOrJamBean.getName() + "(" + powderOrJamBean.getWeight() + "g)";
            holder.tvName.setText(nameStr);
            holder.addLess.setTextChangedListener(new AddOrLessView.TextChangedListener() {
                @Override
                public void onTextChanged(int num) {
                    if (num == 0) {
                        holder.tvWeight.setText("");
                    } else {
                        mList.get(position).num = num;
                        String weightStr = num * powderOrJamBean.getWeight() + "g";
                        holder.tvWeight.setText(weightStr);
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private AddOrLessView addLess;
        private TextView tvWeight;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById( R.id.tv_name );
            addLess = itemView.findViewById( R.id.add_less );
            tvWeight = itemView.findViewById( R.id.tv_weight );
        }
    }

}
