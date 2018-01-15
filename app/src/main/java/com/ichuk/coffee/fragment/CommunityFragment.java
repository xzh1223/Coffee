package com.ichuk.coffee.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.CommunityAdapter;
import com.ichuk.coffee.base.BaseFragment;
import com.ichuk.coffee.bean.CommunityBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzh on 2017/12/4.
 *
 */
public class CommunityFragment extends BaseFragment {
    private TextView tvHeaderTitle;
    private RecyclerView rvCommunity;
    private List<CommunityBean> mList = new ArrayList<>();

    /**
     * initial view
     */
    @Override
    protected void initView() {
        getData();
        findViews();
        setRecyclerView();
        setEvent();
    }

    private void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.community));
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
    }

    /**
     * initial widget
     */
    private void findViews() {
        if (getView() != null) {
            tvHeaderTitle = getView().findViewById(R.id.tv_header_title);
            rvCommunity = getView().findViewById(R.id.rv_community);
        }
    }

    /**
     * set recyclerView
     */
    private void setRecyclerView() {
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        rvCommunity.setLayoutManager(manager);
        CommunityAdapter mAdapter = new CommunityAdapter(context, mList);
        rvCommunity.setAdapter(mAdapter);
    }

    /**
     * load layout
     */
    @Override
    protected int getLayout() {
        return R.layout.fragment_community;
    }
}
