package com.ichuk.coffee.activity.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.mine.MessageAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.MessageBean;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView rvMessage;
    private List<MessageBean> mList = new ArrayList<>();
    private TextView tvHeaderTitle;
    private ImageView ivBack;

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.message));
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
     *  get data from http request
     */
    private void getData() {
        MessageBean messageBean = new MessageBean();
        messageBean.setTitle("消息内容");
        messageBean.setTime("12月12日");
        messageBean.setContent("消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容消息内容");
        mList.add(messageBean);
        mList.add(messageBean);
        mList.add(messageBean);
        mList.add(messageBean);
        mList.add(messageBean);
    }

    /**
     *  set recycler view
     */
    private void setRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(context);
        rvMessage.setLayoutManager(manager);
        MessageAdapter messageAdapter = new MessageAdapter(context, mList);
        rvMessage.setAdapter(messageAdapter);
    }

    /**
     *  initial view
     */
    private void findViews() {
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        ivBack = findViewById(R.id.iv_back);
        rvMessage = findViewById(R.id.rv_message);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_message;
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
