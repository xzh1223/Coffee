package com.ichuk.coffee.fragment;

import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.ViewPagerFragment;
import com.ichuk.coffee.fragment.community.ArticleFragment;
import com.ichuk.coffee.fragment.community.LeaveMessageFragment;

/**
 * Created by xzh on 2017/12/4.
 */
public class CommunityFragment extends ViewPagerFragment implements /*ViewPager.OnPageChangeListener,*/ View.OnClickListener {
    private TextView tvHeaderTitle;
    private ViewPager vpCommunity;
    private TextView tvArticle;
    private TextView tvLeaveMessage;
    private int width;
    private LinearLayout.LayoutParams params;
    private Display mDisplay;
    private int pageCount = 2;
    private LinearLayout llIndicator;

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        setHeader();
        setViewPager(vpCommunity, new ArticleFragment(), new LeaveMessageFragment());
        initIndicator(llIndicator);
        setListener(vpCommunity, tvArticle, tvLeaveMessage);
        setDefault();
        setEvent();
    }

    /**
     *  set default selected
     */
    private void setDefault() {
        vpCommunity.setCurrentItem(0);
    }

    /**
     * set header
     */
    private void setHeader() {
        tvHeaderTitle.setText(getResources().getString(R.string.community));
    }

    /**
     *  set event
     */
    private void setEvent() {
        tvArticle.setOnClickListener(this);
        tvLeaveMessage.setOnClickListener(this);
    }

    /**
     * initial widget
     */
    private void findViews() {
        if (getView() != null) {
            tvHeaderTitle = getView().findViewById(R.id.tv_header_title);
            vpCommunity = getView().findViewById(R.id.viewpager);
            tvArticle = getView().findViewById(R.id.tv_1);
            tvLeaveMessage = getView().findViewById(R.id.tv_2);
            llIndicator = getView().findViewById(R.id.ll_indicator);
        }
    }

    /**
     * load layout
     */
    @Override
    protected int getLayout() {
        return R.layout.fragment_community;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_1:
                vpCommunity.setCurrentItem(0);
                break;
            case R.id.tv_2:
                vpCommunity.setCurrentItem(1);
                break;
        }
    }
}
