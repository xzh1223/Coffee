package com.ichuk.coffee.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.bean.StringBean;

import java.util.List;

/**
 * Created by xzh on 2017/12/7.
 *
 */

public class FeedbackAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<StringBean> mList;

    public FeedbackAdapter(Context context, List<StringBean> list) {
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
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_gv_feedback, null);
            viewHolder = new ViewHolder();
            viewHolder.tvName = convertView.findViewById(R.id.tv_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (mList != null) {
            StringBean stringBean = mList.get(position);
            viewHolder.tvName.setText(stringBean.getName());
            if (stringBean.isSelected()) {
                viewHolder.tvName.setBackgroundResource(R.drawable.coffee_detail_selected);
                viewHolder.tvName.setTextColor(mContext.getResources().getColor(R.color.md_white_1000));
            } else {
                viewHolder.tvName.setBackgroundResource(R.drawable.bg_feedback);
                viewHolder.tvName.setTextColor(mContext.getResources().getColor(R.color.md_grey_600));
            }
        }
        return convertView;
    }
    static class ViewHolder {
        TextView tvName;
    }

}
