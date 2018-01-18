package com.ichuk.coffee.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.community.CommunityFragmentAdapter;
import com.ichuk.coffee.base.BaseFragment;
import com.ichuk.coffee.fragment.community.ArticleFragment;
import com.ichuk.coffee.fragment.community.LeaveMessageFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzh on 2017/12/4.
 */
public class CommunityFragment extends BaseFragment implements ViewPager.OnPageChangeListener, View.OnClickListener {
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
        setViewPager();
        initIndicator();
        setDefault();
        setEvent();
    }

    /**
     *  initial indicator
     */
    private void initIndicator() {
        mDisplay = getActivity().getWindowManager().getDefaultDisplay() ;
        DisplayMetrics outMetrics = new DisplayMetrics() ;
        mDisplay.getMetrics(outMetrics);
        width = outMetrics.widthPixels / 2 ;
        params = (LinearLayout.LayoutParams) llIndicator.getLayoutParams();
        params.width = width ;
        llIndicator.setLayoutParams(params);
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
     * set viewpager (set adapter and add fragment)
     */
    private void setViewPager() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new ArticleFragment());
        fragments.add(new LeaveMessageFragment());
        CommunityFragmentAdapter adapter = new CommunityFragmentAdapter(
                getActivity().getSupportFragmentManager(), fragments);
        vpCommunity.setAdapter(adapter);
    }

    private void setEvent() {
        tvArticle.setOnClickListener(this);
        tvLeaveMessage.setOnClickListener(this);
        vpCommunity.addOnPageChangeListener(this);
    }

    /**
     * initial widget
     */
    private void findViews() {
        if (getView() != null) {
            tvHeaderTitle = getView().findViewById(R.id.tv_header_title);
            vpCommunity = getView().findViewById(R.id.vp_community);
            tvArticle = getView().findViewById(R.id.tv_article);
            tvLeaveMessage = getView().findViewById(R.id.tv_leave_message);
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

    /**
     * This method will be invoked when the current page is scrolled, either as part
     * of a programmatically initiated smooth scroll or a user initiated touch scroll.
     *
     * @param position             Position index of the first page currently being displayed.
     *                             Page position+1 will be visible if positionOffset is nonzero.
     * @param positionOffset       Value from [0, 1) indicating the offset from the page at position.
     * @param positionOffsetPixels Value in pixels indicating the offset from position.
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if(positionOffset != 0 && positionOffsetPixels != 0 ){
            params.leftMargin = positionOffsetPixels / pageCount + width * position ;
            llIndicator.setLayoutParams(params);
        }
    }

    /**
     * This method will be invoked when a new page becomes selected. Animation is not
     * necessarily complete.
     *
     * @param position Position index of the new selected page.
     */
    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
            tvArticle.setTextColor(getResources().getColor(R.color.brown));
            tvLeaveMessage.setTextColor(getResources().getColor(R.color.md_grey_700));
        } else if (position == 1) {
            tvArticle.setTextColor(getResources().getColor(R.color.md_grey_700));
            tvLeaveMessage.setTextColor(getResources().getColor(R.color.brown));
        }
    }

    /**
     * Called when the scroll state changes. Useful for discovering when the user
     * begins dragging, when the pager is automatically settling to the current page,
     * or when it is fully stopped/idle.
     *
     * @param state The new scroll state.
     * @see ViewPager#SCROLL_STATE_IDLE
     * @see ViewPager#SCROLL_STATE_DRAGGING
     * @see ViewPager#SCROLL_STATE_SETTLING
     */
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_article:
                vpCommunity.setCurrentItem(0);
                break;
            case R.id.tv_leave_message:
                vpCommunity.setCurrentItem(1);
                break;
        }
    }
}
