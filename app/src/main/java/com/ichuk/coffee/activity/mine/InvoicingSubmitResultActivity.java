package com.ichuk.coffee.activity.mine;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;

public class InvoicingSubmitResultActivity extends BaseActivity implements View.OnClickListener {

    private static final int DELAY_INTENT = 0x00;
    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private TextView tvSecondTime;
    private int num = 3;
    Handler mHandler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            num--;
            if (num >= 0) {
                tvSecondTime.setText(num + "");
                mHandler.postDelayed(this, 1000);
            } else {
                finish();
            }
        }
    };

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setOnClickListener(this);
    }

    /**
     * time to intent
     */
    private void countdown() {
        mHandler.postDelayed(runnable, 1000);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        setHeader();
        countdown();
    }

    /**
     * set header
     */
    private void setHeader() {
        tvHeaderTitle.setText(getResources().getString(R.string.submit_success));
        ivBack.setVisibility(View.VISIBLE);
    }

    /**
     * findViewById
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        tvSecondTime = findViewById(R.id.tv_second_time);
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
