package com.ichuk.coffee.activity.mine;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;

public class InvoicingSubmitResultActivity extends BaseActivity implements View.OnClickListener {

    private static final int DELAY_INTENT = 0x00;
    private ImageView ivBack;
    private TextView tvHeaderTitle;

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case DELAY_INTENT:
                    finish();
                    break;
            }
            return false;
        }
    });

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.submit_success));
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        long waitTime = 3 * 1000;
        handler.sendEmptyMessageDelayed(DELAY_INTENT, waitTime);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_invoicing_submit_result;
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
