package com.ichuk.coffee.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ichuk.coffee.R;
import com.ichuk.coffee.bean.MineGridBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/7.
 *
 */

public class MineGridAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<MineGridBean> mList;

    public MineGridAdapter(Context context, List<MineGridBean> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_gv_mine, null);
            viewHolder = new ViewHolder();
            viewHolder.ivImage = convertView.findViewById(R.id.iv_image);
            viewHolder.tvName = convertView.findViewById(R.id.tv_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        MineGridBean mineGridBean = mList.get(position);
        if (mineGridBean != null) {
            Glide.with(mContext).load(R.mipmap.ic_launcher_round).into(viewHolder.ivImage);
            viewHolder.tvName.setText(mineGridBean.getName());
        }
        return convertView;
    }
    static class ViewHolder {
        ImageView ivImage;
        TextView tvName;
    }

}
