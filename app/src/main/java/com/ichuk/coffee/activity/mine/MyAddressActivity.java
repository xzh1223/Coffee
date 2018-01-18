package com.ichuk.coffee.activity.mine;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MyAddressActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout llNoAddress;
    private Button btnAddAddress;
    private RecyclerView rvMyAddress;
    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private List<String> mList = new ArrayList<>();

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        llNoAddress = findViewById(R.id.ll_no_address);
        btnAddAddress = findViewById(R.id.btn_add_address);
        rvMyAddress = findViewById(R.id.rv_my_address);
    }

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        if (mList.size() > 0) {
            llNoAddress.setVisibility(View.GONE);
            rvMyAddress.setVisibility(View.VISIBLE);
        } else {
            rvMyAddress.setVisibility(View.GONE);
            llNoAddress.setVisibility(View.VISIBLE);
            btnAddAddress.setOnClickListener(this);
        }
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
    }

    /**
     *  set header
     */
    private void setHeader() {
        ivBack.setVisibility(View.VISIBLE);
        tvHeaderTitle.setText(getResources().getString(R.string.my_address));
    }

    /**
     * get data from http
     */
    private void getData() {

    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_my_address;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_address:
                toActivity(MyAddressAddActivity.class);
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
