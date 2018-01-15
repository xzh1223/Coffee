package com.ichuk.coffee.activity.community;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;

public class LeaveMessageActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private TextView tvSave;
    private EditText etContent;
    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.leave_message));
        tvSave.setText(getResources().getString(R.string.submit));
        ivBack.setVisibility(View.VISIBLE);
        tvSave.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        tvSave.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
    }

    /**
     *  findViewById
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvSave = findViewById(R.id.tv_save);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        etContent = findViewById(R.id.et_content);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_leave_message;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_save:
                submit();
                break;
        }
    }

    /**
     *  submit content to server
     */
    private void submit() {

    }
}
