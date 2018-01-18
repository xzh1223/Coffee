package com.ichuk.coffee.activity.mine;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.mine.CodeOrderDetailsAdapter;
import com.ichuk.coffee.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class RefundActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private Button btnPlayRefund;
//    private TextView tvCodeKey;
//    private TextView tvCodeValue;
//    private ImageView ivCheckCode;
    private TextView tvContentKey;
    private TextView tvContentValue;
//    private TextView tvWxKey;
//    private EditText etWxValue;
//    private ImageView ivCheckWx;
//    private TextView tvZfbKey;
//    private EditText etZfbValue;
//    private ImageView ivCheckZfb;
    private TextView tvNoFind;
    private ImageView ivCheckReasonFind;
    private TextView tvDoFailed;
    private ImageView ivCheckReasonDoFailed;
    private TextView tvOther;
    private ImageView ivCheckReasonOther;
    private boolean mMethod = true;
    private boolean mReasonOne = false;
    private boolean mReasonTwo = false;
    private boolean mReasonThree = false;
    private RecyclerView rvCode;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        btnPlayRefund = findViewById(R.id.btn_play_refund);
//        tvCodeValue = findViewById(R.id.tv_code_value);
//        ivCheckCode = findViewById(R.id.iv_check_code);
        tvContentValue = findViewById(R.id.tv_content_value);
//        etWxValue = findViewById(R.id.et_wx_value);
//        ivCheckWx = findViewById(R.id.iv_check_wx);
//        etZfbValue = findViewById(R.id.et_zfb_value);
//        ivCheckZfb = findViewById(R.id.iv_check_zfb);
        tvNoFind = findViewById(R.id.tv_no_find);
        ivCheckReasonFind = findViewById(R.id.iv_check_reason_find);
        tvDoFailed = findViewById(R.id.tv_do_failed);
        ivCheckReasonDoFailed = findViewById(R.id.iv_check_reason_do_failed);
        tvOther = findViewById(R.id.tv_other);
        ivCheckReasonOther = findViewById(R.id.iv_check_reason_other);
        rvCode= findViewById(R.id.rv_code);
    }

    /**
     * set event
     */
    @Override
    protected void setEvent() {
//        ivCheckCode.setImageResource(R.mipmap.icon_checked);
//        ivCheckWx.setImageResource(R.mipmap.ic_launcher);
//        ivCheckZfb.setImageResource(R.mipmap.ic_launcher);
//        ivCheckReasonFind.setImageResource(R.mipmap.icon_check);
//        ivCheckReasonDoFailed.setImageResource(R.mipmap.icon_check);
//        ivCheckReasonOther.setImageResource(R.mipmap.icon_check);
//        ivCheckWx.setOnClickListener(this);
//        ivCheckZfb.setOnClickListener(this);
        ivCheckReasonFind.setOnClickListener(this);
        ivCheckReasonDoFailed.setOnClickListener(this);
        ivCheckReasonOther.setOnClickListener(this);
        ivBack.setOnClickListener(this);
        btnPlayRefund.setOnClickListener(this);
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
     * set recyclerView
     */
    private void setRecyclerView() {
        List<String> codeList = new ArrayList<>();
        codeList.add("取杯码1：1114");
        codeList.add("取杯码2：1114");
        rvCode.setLayoutManager(new LinearLayoutManager(context));
        int flag = 1;
        rvCode.setAdapter(new CodeOrderDetailsAdapter(context, codeList, flag));
    }

    /**
     *  set header
     */
    private void setHeader() {
        ivBack.setVisibility(View.VISIBLE);
        tvHeaderTitle.setText(getResources().getString(R.string.play_refund));
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
        return R.layout.activity_refund;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_play_refund:
                Intent intent = new Intent(context, RefundResultActivity.class);
                intent.putExtra("money", "66.0");
                intent.putExtra("method", "微信账户");
                intent.putExtra("account", "1234556");
                startActivity(intent);
                break;
//            case R.id.iv_check_wx:
//                if (mMethod) {
//                    checkMethod(1);
//                } else {
//                    checkMethod(2);
//                }
//                break;
//            case R.id.iv_check_zfb:
//                if (!mMethod) {
//                    checkMethod(1);
//                } else {
//                    checkMethod(2);
//                }
//                break;
            case R.id.iv_check_reason_find:
                mReasonOne = !mReasonOne;
                checkReason(1, mReasonOne);
                break;
            case R.id.iv_check_reason_do_failed:
                mReasonTwo = !mReasonTwo;
                checkReason(2, mReasonTwo);
                break;
            case R.id.iv_check_reason_other:
                mReasonThree = !mReasonThree;
                checkReason(3, mReasonThree);
                break;
        }
    }

    /**
     * refund method to check and show
     */
//    private void checkMethod(int i) {
//        if (i == 1) {
//            ivCheckWx.setImageResource(R.mipmap.ic_launcher_round);
//            ivCheckZfb.setImageResource(R.mipmap.ic_launcher);
//            etWxValue.setVisibility(View.VISIBLE);
//            etZfbValue.setVisibility(View.GONE);
//        } else if (i == 2) {
//            ivCheckWx.setImageResource(R.mipmap.ic_launcher);
//            ivCheckZfb.setImageResource(R.mipmap.ic_launcher_round);
//            etWxValue.setVisibility(View.GONE);
//            etZfbValue.setVisibility(View.VISIBLE);
//        }
//    }

    /**
     * refund reason to check and show
     */
    private void checkReason(int i, boolean reason) {
        if (i == 1) {
            if (reason) {
                ivCheckReasonFind.setImageResource(R.mipmap.icon_checked);
            } else {
                ivCheckReasonFind.setImageResource(R.mipmap.icon_check);
            }
        } else if (i == 2) {
            if (reason) {
                ivCheckReasonDoFailed.setImageResource(R.mipmap.icon_checked);
            } else {
                ivCheckReasonDoFailed.setImageResource(R.mipmap.icon_check);
            }
        } else if (i == 3) {
            if (reason) {
                ivCheckReasonOther.setImageResource(R.mipmap.icon_checked);
            } else {
                ivCheckReasonOther.setImageResource(R.mipmap.icon_check);
            }
        }
    }
}
