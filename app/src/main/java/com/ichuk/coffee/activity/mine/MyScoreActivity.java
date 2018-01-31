package com.ichuk.coffee.activity.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.activity.WebActivity;
import com.ichuk.coffee.adapter.mine.ScoreAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.ScoreBean;

import java.util.ArrayList;
import java.util.List;

public class MyScoreActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private TextView tvUseMethod;
    private TextView tvCurrentScore;
    private RecyclerView rvScoreDetails;
    private List<ScoreBean.ScoreData> mList = new ArrayList<>();
    private String mScore = "";

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        tvUseMethod = findViewById(R.id.tv_use_method);
        tvCurrentScore = findViewById(R.id.tv_current_score);
        rvScoreDetails = findViewById(R.id.rv_score_details);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.my_score));
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        tvUseMethod.setOnClickListener(this);
        tvCurrentScore.setText(mScore);
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
     * get data from http request
     */
    private void getData() {
        ScoreBean scoreBean = new ScoreBean();
        scoreBean.setScore("100");
        ScoreBean.ScoreData scoreData = new ScoreBean.ScoreData();
        scoreData.setContent("购物所赠送（商品号：201712141000）");
        scoreData.setTime("2017-12-14");
        scoreData.setNumber("+20");
        scoreBean.getScoreDataList().add(scoreData);
        scoreBean.getScoreDataList().add(scoreData);
        scoreBean.getScoreDataList().add(scoreData);
        scoreBean.getScoreDataList().add(scoreData);
        mList = scoreBean.getScoreDataList();
        mScore = scoreBean.getScore();
    }

    /**
     * set recyclerView
     */
    private void setRecyclerView() {
        rvScoreDetails.setLayoutManager(new LinearLayoutManager(context));
        ScoreAdapter adapter = new ScoreAdapter(context, mList);
        rvScoreDetails.setAdapter(adapter);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_my_score;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_use_method:
                toActivity(WebActivity.class);
                break;
        }
    }
}
