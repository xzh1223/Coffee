package com.ichuk.coffee.activity.discount;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.discount.SecondHalfAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.SecondHalfBean;

import java.util.ArrayList;
import java.util.List;

public class SecondHalfActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivLeft;

    private RecyclerView rvCoffee;
    private List<SecondHalfBean> mList = new ArrayList<>();
    private TextView tvHeaderTitle;
    private ImageView ivBack;
    private TextView tvHour;
    private TextView tvMinute;
    private TextView tvSecond;
    private String mTime = "";

    Handler mHandler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mDate--;
            if (mDate >= 0) {
                setTime(mDate);
                mHandler.postDelayed(this, 1000);
            } else {
                finish();
            }
        }
    };

    /**
     * set date into textView
     *
     * @param mDate
     */
    private void setTime(int mDate) {
        String hour = mDate / 60 / 60 > 9 ? mDate / 60 / 60 + "" : "0" + mDate / 60 / 60;
        String minute = mDate / 60 % 60 > 9 ? mDate / 60 % 60 + "" : "0" + mDate / 60 % 60;
        String second = mDate % 60 % 60 > 9 ? mDate % 60 % 60 + "" : "0" + mDate % 60 % 60;

        tvHour.setText(hour);
        tvMinute.setText(minute);
        tvSecond.setText(second);
    }

    private int mDate = 0;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivLeft = findViewById(R.id.iv_left);
        tvHour = findViewById(R.id.tv_hour);
        tvMinute = findViewById(R.id.tv_minute);
        tvSecond = findViewById(R.id.tv_second);
        rvCoffee = findViewById(R.id.rv_coffee);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        ivBack = findViewById(R.id.iv_back);
    }


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
        getData();
        getTime();
        setRecyclerView();
    }

    /**
     * get time and turn
     */
    private void getTime() {
        int endTime = 0;
        int currentTime = 0;

        String currentTimeStr = System.currentTimeMillis() + "";
        currentTimeStr = currentTimeStr.substring(0, 10);
        currentTime = Integer.valueOf(currentTimeStr);

        if (mTime.length() == 10) {
            endTime = Integer.valueOf(mTime);
        } else if (mTime.length() == 13) {
            mTime = mTime.substring(0, 10);
            endTime = Integer.valueOf(mTime);
        } else {
            endTime = currentTime;
        }

        if (currentTime <= endTime) {
            mDate = endTime - currentTime;
            setTime(mDate);
            mHandler.postDelayed(runnable, 1000);
        }
    }

    /**
     * set header
     */
    private void setHeader() {
        ivBack.setVisibility(View.VISIBLE);
        tvHeaderTitle.setText(getResources().getString(R.string.second_half_price));
    }

    /**
     * get data from http
     */
    private void getData() {
        SecondHalfBean secondHalfBean = new SecondHalfBean();
        secondHalfBean.setName("Coffee");
        secondHalfBean.setIngredient("成分： 速溶咖啡、水");
        secondHalfBean.setPrice("9.8");
        secondHalfBean.setSum(100);
        secondHalfBean.setNum(50);
        mList.add(secondHalfBean);
        mList.add(secondHalfBean);
        mList.add(secondHalfBean);

        mTime = "1518170400";
    }

    private void setRecyclerView() {
        rvCoffee.setLayoutManager(new LinearLayoutManager(context));
        rvCoffee.setAdapter(new SecondHalfAdapter(context, mList));
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_second_half;
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
