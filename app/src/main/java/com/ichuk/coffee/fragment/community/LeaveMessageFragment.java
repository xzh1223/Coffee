package com.ichuk.coffee.fragment.community;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.community.LeaveMessageAdapter;
import com.ichuk.coffee.base.BaseFragment;
import com.ichuk.coffee.bean.CommunityBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzh on 2018/1/16.
 */

public class LeaveMessageFragment extends BaseFragment {
    private RecyclerView rvLeaveMessage;
    private List<CommunityBean> mList = new ArrayList<>();

    /**
     * load layout
     */
    @Override
    protected int getLayout() {
        return R.layout.fragment_community_item_leave_message;
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
     *  initial widget
     */
    private void findViews() {
        rvLeaveMessage = getView().findViewById(R.id.rv_leave_message);
    }


    /**
     * set recyclerView
     */
    private void setRecyclerView() {
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        rvLeaveMessage.setLayoutManager(manager);
        LeaveMessageAdapter mAdapter = new LeaveMessageAdapter(context, mList);
        rvLeaveMessage.setAdapter(mAdapter);
    }

    /**
     * get data from http
     */
    private void getData() {
        CommunityBean communityBean = new CommunityBean();
        communityBean.setName("name");
        communityBean.setContent("社区内容社区内容社区内容社区内容社区内容社区内容社区内容");
        communityBean.setLikeNum(10);
        communityBean.setCommentNum(30);

        CommunityBean communityBean2 = new CommunityBean();
        communityBean2.setName("name");
        communityBean2.setContent("社区内容社区内容社区内容社区内容社区内容社区内容社区内容社区" +
                "内容社区内容社区内容社区内容社区内容社区内容社区内容");
        communityBean2.setLikeNum(14);
        communityBean2.setCommentNum(7);
        mList.add(communityBean);
        mList.add(communityBean2);
        mList.add(communityBean2);
        mList.add(communityBean);
        mList.add(communityBean);
        mList.add(communityBean2);
        mList.add(communityBean2);
        mList.add(communityBean);
        mList.add(communityBean2);
    }
}
