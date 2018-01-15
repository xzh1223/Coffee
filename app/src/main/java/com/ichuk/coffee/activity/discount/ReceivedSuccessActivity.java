package com.ichuk.coffee.activity.discount;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.activity.MainActivity;
import com.ichuk.coffee.base.BaseActivity;

public class ReceivedSuccessActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private Button btnToUse;
    private Button btnToMain;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        btnToUse = findViewById(R.id.btn_to_use);
        btnToMain = findViewById(R.id.btn_to_main);
    }

    /**
     * Handle button click events
     */
    @Override
    public void onClick(View v) {
        if (v == btnToUse) {
            // Handle clicks for btnToUse

        } else if (v == btnToMain) {
            // Handle clicks for btnToMain
            toActivity(MainActivity.class);
            finish();
        } else if (v == ivBack) {
            finish();
        }
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.receive_success));
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        btnToUse.setOnClickListener(this);
        btnToMain.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_received;
    }
}
