package com.ichuk.coffee.activity.mine;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.ViewPagerActivity;
import com.ichuk.coffee.bean.CommunityBean;
import com.ichuk.coffee.fragment.mine.ArticleFragment;
import com.ichuk.coffee.fragment.mine.LeaveMessageFragment;

import java.util.ArrayList;
import java.util.List;

public class MyLeaveMessageActivity extends ViewPagerActivity implements View.OnClickListener {
    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private TextView tvArticle;
    private TextView tvLeaveMessage;
    private LinearLayout llIndicator;
    private List<CommunityBean> mList = new ArrayList<>();
    private ViewPager vpMyLeaveMessage;

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        setHeader();
        setViewPager(vpMyLeaveMessage, new ArticleFragment(), new LeaveMessageFragment());
        initIndicator(llIndicator);
        setListener(vpMyLeaveMessage, tvArticle, tvLeaveMessage);
        setDefault();
    }

    /**
     *  set default selected
     */
    private void setDefault() {
        tvArticle.setText(getResources().getString(R.string.article));
        tvLeaveMessage.setText(getResources().getString(R.string.leave_message));
        vpMyLeaveMessage.setCurrentItem(0);
    }

    /**
     *  set header
     */
    private void setHeader() {
        tvHeaderTitle.setText(getResources().getString(R.string.my_leave_message));
        ivBack.setVisibility(View.VISIBLE);
        tvArticle.setVisibility(View.VISIBLE);
        tvLeaveMessage.setVisibility(View.VISIBLE);
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
     * set recyclerView
     */
    private void setRecyclerView() {
//        rvMyLeaveMessage.setLayoutManager(new LinearLayoutManager(context));
//        rvMyLeaveMessage.setAdapter(new MyLeaveMessageAdapter(context, mList));
    }

    /**
     * findViewById
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        tvArticle = findViewById(R.id.tv_1);
        tvLeaveMessage = findViewById(R.id.tv_2);
        vpMyLeaveMessage = findViewById(R.id.viewpager);
        llIndicator = findViewById(R.id.ll_indicator);
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
            case R.id.tv_1:
                vpMyLeaveMessage.setCurrentItem(0);
                break;
            case R.id.tv_2:
                vpMyLeaveMessage.setCurrentItem(1);
                break;
        }
    }
}
