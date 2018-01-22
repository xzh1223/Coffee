package com.ichuk.coffee.activity.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.mine.ScoreAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.ScoreBean;

import java.util.ArrayList;
import java.util.List;

public class MyPointRecordActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView rvPointRecord;
    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private List<ScoreBean.ScoreData> mList = new ArrayList<>();
    private int mPage;

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
        getData();
        setHeader();
        setRecyclerView();
    }

    /**
     * get data from http
     */
    private void getData() {
        mPage = getIntent().getIntExtra("page", 0);
    }

    /**
     * set recyclerView
     */
    private void setRecyclerView() {
        ScoreBean.ScoreData scoreData = new ScoreBean.ScoreData();
        scoreData.setContent("购物所赠送（商品号：201712141000）");
        scoreData.setTime("2017-12-14");
        scoreData.setNumber("+20");
        mList.add(scoreData);
        mList.add(scoreData);
        mList.add(scoreData);
        rvPointRecord.setLayoutManager(new LinearLayoutManager(context));
        rvPointRecord.setAdapter(new ScoreAdapter(context, mList));
    }

    /**
     *  set header
     */
    private void setHeader() {
        ivBack.setVisibility(View.VISIBLE);
        if (mPage == 0) {
            tvHeaderTitle.setText(getResources().getString(R.string.point_record));
        } else {
            tvHeaderTitle.setText(getResources().getString(R.string.point_detail));
        }
    }

    /**
     *  findViewById
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        rvPointRecord = findViewById(R.id.rv_point_record);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_my_point_record;
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
