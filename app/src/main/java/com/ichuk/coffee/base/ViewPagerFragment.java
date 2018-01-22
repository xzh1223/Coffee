package com.ichuk.coffee.base;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.community.CommunityFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzh on 2018/1/19.
 */

public abstract class ViewPagerFragment extends BaseFragment implements ViewPager.OnPageChangeListener {

    private Display mDisplay;
    private int width;
    private LinearLayout llIndicator;
    private LinearLayout.LayoutParams params;
    private TextView tvArticle;
    private TextView tvLeaveMessage;
    private int pageCount = 2;

    /**
     * set viewpager
     */
    public void setViewPager(ViewPager viewPager, Fragment fragment1, Fragment fragment2) {
        if (viewPager != null && fragment1 != null && fragment2 != null) {
            List<Fragment> fragments = new ArrayList<>();
            fragments.add(fragment1);
            fragments.add(fragment2);
            CommunityFragmentAdapter adapter = new CommunityFragmentAdapter(
                    getActivity().getSupportFragmentManager(), fragments);
            viewPager.setAdapter(adapter);
        }
    }

    /**
     * set listener
     *
     * @param viewPager
     * @param textView1
     * @param textView2
     */
    public void setListener(ViewPager viewPager, TextView textView1, TextView textView2) {
        if (viewPager != null && textView1 != null && textView2 != null) {
            tvArticle = textView1;
            tvLeaveMessage = textView2;
            viewPager.addOnPageChangeListener(this);
        }
    }

    /**
     * initial indicator
     */
    public void initIndicator(LinearLayout indicator) {
        if (indicator != null) {
            llIndicator = indicator;
            mDisplay = getActivity().getWindowManager().getDefaultDisplay();
            DisplayMetrics outMetrics = new DisplayMetrics();
            mDisplay.getMetrics(outMetrics);
            width = outMetrics.widthPixels / pageCount;
            params = (LinearLayout.LayoutParams) llIndicator.getLayoutParams();
            params.width = width;
            llIndicator.setLayoutParams(params);
        }
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
        Log.e("xxx", "onPageScrolled: " + positionOffsetPixels );
        try {
            if (positionOffset != 0 && positionOffsetPixels != 0) {
                if (params != null && llIndicator != null) {
                    params.leftMargin = positionOffsetPixels / pageCount + width * position;
                    llIndicator.setLayoutParams(params);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        try {
            if (position == 0) {
                tvArticle.setTextColor(getResources().getColor(R.color.brown));
                tvLeaveMessage.setTextColor(getResources().getColor(R.color.md_grey_700));
            } else if (position == 1) {
                tvArticle.setTextColor(getResources().getColor(R.color.md_grey_700));
                tvLeaveMessage.setTextColor(getResources().getColor(R.color.brown));
            }
        } catch (Exception e) {
            e.printStackTrace();
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
}
