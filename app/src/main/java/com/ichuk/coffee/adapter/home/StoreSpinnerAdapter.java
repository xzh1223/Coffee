package com.ichuk.coffee.adapter.home;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.bean.StoreShopBean;

import java.util.List;

/**
 * Created by xzh on 2018/2/1.
 */

public class StoreSpinnerAdapter implements SpinnerAdapter {
    private final List<StoreShopBean> mList;
    private final Context mContext;

    public StoreSpinnerAdapter(Context context, List<StoreShopBean> storeList) {
        this.mContext = context;
        this.mList = storeList;
    }

    /**
     * Set the expanded layout
     *
     * @param i
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.item_spinner_store, viewGroup, false);
            holder.tvShopName = view.findViewById(R.id.tv_shop_name);
            holder.tvShopLocation = view.findViewById(R.id.tv_shop_location);
            holder.tvShopDistance = view.findViewById(R.id.tv_shop_distance);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        StoreShopBean shopBean = mList.get(i);
        if (shopBean != null) {
            holder.tvShopName.setText(shopBean.getShopName());
            holder.tvShopLocation.setText(shopBean.getShopLocation());
            holder.tvShopDistance.setText(shopBean.getShopDistance());
        }
        return view;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    /**
     * Set the unexpanded layout
     *
     * @param i
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        StoreShopBean shopBean = mList.get(i);
        view = LayoutInflater.from(mContext).inflate(android.R.layout.simple_spinner_item, viewGroup, false);
        TextView textView = view.findViewById(android.R.id.text1);
        textView.setText(shopBean.getShopName());
        return view;
    }

    @Override
    public int getItemViewType(int i) {
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return mList.size() == 0;
    }

    class ViewHolder {
        TextView tvShopName;
        TextView tvShopLocation;
        TextView tvShopDistance;
    }

}
