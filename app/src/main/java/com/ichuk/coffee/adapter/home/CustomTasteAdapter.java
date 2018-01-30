package com.ichuk.coffee.adapter.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.activity.home.CoffeeDetailActivity;
import com.ichuk.coffee.bean.PowderOrJamBean;
import com.ichuk.coffee.utils.ToastUtil;
import com.ichuk.coffee.widget.AddOrLessView;

import java.util.List;

/**
 * Created by xzh on 2018/1/12.
 */

public class CustomTasteAdapter extends RecyclerView.Adapter<CustomTasteAdapter.ViewHolder> {

    private final List<PowderOrJamBean> mList;
    private final Context mContext;
    private final int mFlag;

    public CustomTasteAdapter(Context context, List<PowderOrJamBean> list, int flag) {
        this.mContext = context;
        this.mList = list;
        this.mFlag = flag;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.item_rv_powder_or_jam, parent, false);
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
            holder.addLess.setFlag(1);
            holder.addLess.setTextChangedListener(new AddOrLessView.TextChangedListener() {
                @Override
                public void onTextChanged(int num, boolean isDelete) {
                    boolean isMax = ((CoffeeDetailActivity) mContext).resetNum(mFlag, position, num);
                    if (isMax) {
                        holder.addLess.setText((num-1)+"");
                    } else {
                        String weightStr = num * powderOrJamBean.getWeight() + "g";
                        holder.tvWeight.setText(weightStr);
                    }
                    if (num == 0) {
                        holder.tvWeight.setText("");
                    }
                }
            });
        }
    }

    /**
     * get all num
     */
    private boolean isMax() {
        int allNum = 0;
        for (int i = 0; i < mList.size(); i++) {
            allNum += mList.get(i).num;
        }
        if (allNum > 5) {
            ToastUtil.toast(mContext, "已达到上限不可添加");
            return true;
        } else {
            return false;
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
            tvName = itemView.findViewById(R.id.tv_name);
            addLess = itemView.findViewById(R.id.add_less);
            tvWeight = itemView.findViewById(R.id.tv_weight);
        }
    }

}
