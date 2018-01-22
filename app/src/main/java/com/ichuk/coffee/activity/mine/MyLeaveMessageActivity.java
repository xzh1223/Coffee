package com.ichuk.coffee.activity.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.mine.MyLeaveMessageAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.CommunityBean;

import java.util.ArrayList;
import java.util.List;

public class MyLeaveMessageActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private RecyclerView rvMyLeaveMessage;
    private List<CommunityBean> mList = new ArrayList<>();

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.my_leave_message));
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
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
     *  set recyclerView
     */
    private void setRecyclerView() {
        rvMyLeaveMessage.setLayoutManager(new LinearLayoutManager(context));
        rvMyLeaveMessage.setAdapter(new MyLeaveMessageAdapter(context, mList));
    }

    /**
     *  findViewById
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        rvMyLeaveMessage = findViewById(R.id.rv_my_leave_message);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_my_leave_message;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
