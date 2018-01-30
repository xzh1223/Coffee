package com.ichuk.coffee.fragment.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.mine.MyLeaveMessageAdapter;
import com.ichuk.coffee.base.BaseFragment;
import com.ichuk.coffee.bean.CommunityBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzh on 2018/1/23.
 */

public class LeaveMessageFragment extends BaseFragment {
    private RecyclerView rvLeaveMessage;
    private List<CommunityBean> mList = new ArrayList<>();
    /**
     * load layout
     */
    @Override
    protected int getLayout() {
        return R.layout.fragment_gift_card_add;
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        getData();
        setRecyclerView();
    }

    /**
     * set recyclerView
     */
    private void setRecyclerView() {
        rvLeaveMessage.setLayoutManager(new LinearLayoutManager(context));
        rvLeaveMessage.setAdapter(new MyLeaveMessageAdapter(context, mList));
    }

    /**
     * get data from http
     */
    private void getData() {
        CommunityBean communityBean = new CommunityBean();
        communityBean.setName("xzh");
        communityBean.setTime("2017-12-12 00:00:00");
        communityBean.setContent("content content content content content content content");
        communityBean.setCommentNum(9);
        communityBean.setLikeNum(20);
        mList.add(communityBean);
        mList.add(communityBean);
    }

    /**
     *  initial widget
     */
    private void findViews() {
        rvLeaveMessage = getView().findViewById(R.id.recycler_view);
    }
}
