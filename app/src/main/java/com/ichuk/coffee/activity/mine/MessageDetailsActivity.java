package com.ichuk.coffee.activity.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;

public class MessageDetailsActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvHeaderTitle;
    private ImageView ivBack;
    private String mContent;
    private TextView tvMessageContent;

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.message_detail));
        tvMessageContent.setText(mContent);
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
    }

    /**
     *  get data from intent and request
     */
    private void getData() {
        mContent = getIntent().getStringExtra("content");
    }

    /**
     *  initial view
     */
    private void findViews() {
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        ivBack = findViewById(R.id.iv_back);
        tvMessageContent = findViewById(R.id.tv_message_content);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_message_details;
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
