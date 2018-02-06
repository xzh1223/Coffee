package com.ichuk.coffee.adapter.new_products;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ichuk.coffee.R;
import com.ichuk.coffee.bean.NewProductsBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/5.
 *
 */

public class NewProductsAdapter extends RecyclerView.Adapter<NewProductsAdapter.ViewHolder> {

    private final List<NewProductsBean> mList;
    private final Context mContext;

    public NewProductsAdapter(Context context, List<NewProductsBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public NewProductsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_rv_new_products, null);
        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @Override
    public void onBindViewHolder(NewProductsAdapter.ViewHolder holder, final int position) {
        NewProductsBean newProductsBean = mList.get(position);
        holder.tvNewProductsInfo.setText(newProductsBean.getInfo());
        holder.tvNewProductsPrice.setText(newProductsBean.getPrice());
//        Glide.with(mContext).load(R.mipmap.icon_bg_1_2).into(holder.ivNewProductsImage);
        Glide.with(mContext).load(R.mipmap.icon_bg_1_2).into(holder.ivAccessories1);
        Glide.with(mContext).load(R.mipmap.icon_bg_1_2).into(holder.ivAccessories2);
        Glide.with(mContext).load(R.mipmap.icon_bg_1_2).into(holder.ivAccessories3);
        Glide.with(mContext).load(R.mipmap.icon_bg_1_2).into(holder.ivAccessories4);
        holder.tvAccessories1.setText("Coffee");
        holder.tvAccessories2.setText("Coffee");
        holder.tvAccessories3.setText("Coffee");
        holder.tvAccessories4.setText("Coffee");
        holder.ivAddShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "添加到购物车", Toast.LENGTH_SHORT).show();
            }
        });
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

        ImageView ivNewProductsImage;
        TextView tvNewProductsInfo;
        TextView tvNewProductsPrice;
        ImageView ivAddShoppingCart;
        ImageView ivAccessories1;
        TextView tvAccessories1;
        ImageView ivAccessories2;
        TextView tvAccessories2;
        ImageView ivAccessories3;
        TextView tvAccessories3;
        ImageView ivAccessories4;
        TextView tvAccessories4;
        ImageView ivMore;

        public ViewHolder(View itemView) {
            super(itemView);
            ivNewProductsImage = itemView.findViewById(R.id.iv_new_products_image);
            tvNewProductsInfo = itemView.findViewById(R.id.tv_new_products_info);
            tvNewProductsPrice = itemView.findViewById(R.id.tv_new_products_price);
            ivAddShoppingCart = itemView.findViewById(R.id.iv_add_shopping_cart);
            ivAccessories1 = itemView.findViewById(R.id.iv_accessories_1);
            tvAccessories1 = itemView.findViewById(R.id.tv_accessories_1);
            ivAccessories2 = itemView.findViewById(R.id.iv_accessories_2);
            tvAccessories2 = itemView.findViewById(R.id.tv_accessories_2);
            ivAccessories3 = itemView.findViewById(R.id.iv_accessories_3);
            tvAccessories3 = itemView.findViewById(R.id.tv_accessories_3);
            ivAccessories4 = itemView.findViewById(R.id.iv_accessories_4);
            tvAccessories4 = itemView.findViewById(R.id.tv_accessories_4);
            ivMore = itemView.findViewById(R.id.iv_more);
        }
    }

}
