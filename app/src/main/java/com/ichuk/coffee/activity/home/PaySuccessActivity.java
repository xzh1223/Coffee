package com.ichuk.coffee.activity.home;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.ShareActivity;
import com.ichuk.coffee.utils.ToastUtil;
import com.tencent.tauth.Tencent;

/**
 * Created by xzh on 2018/1/24.
 */

public class PaySuccessActivity extends ShareActivity implements View.OnClickListener {

    private ImageView ivImage;
    private TextView tvPaySuccess;
    private TextView tvPayFailed;
    private LinearLayout llNumber;
    private TextView tvNum;
    private LinearLayout llPhone;
    private EditText etPhone;
    private TextView tvNoReceive;
    private Button btnToSendOrResend;
    private Button btnViewOrder;
    private TextView tvWait;
    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private int mStatus = 0;
    private AlertDialog mDialog;
    private Dialog dialog;
    private Tencent mTencent;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        ivImage = findViewById(R.id.iv_image);
        tvPaySuccess = findViewById(R.id.tv_pay_success);
        tvPayFailed = findViewById(R.id.tv_pay_failed);
        llNumber = findViewById(R.id.ll_number);
        tvNum = findViewById(R.id.tv_num);
        llPhone = findViewById(R.id.ll_phone);
        etPhone = findViewById(R.id.et_phone);
        tvNoReceive = findViewById(R.id.tv_no_receive);
        btnToSendOrResend = findViewById(R.id.btn_to_send_or_resend);
        btnViewOrder = findViewById(R.id.btn_view_order);
        tvWait = findViewById(R.id.tv_wait);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        btnToSendOrResend.setOnClickListener(this);
        ivBack.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        setHeader();
        getStatus();
        ShowContentByStatus();
    }

    /**
     * show content by status
     */
    private void ShowContentByStatus() {
        if (mStatus == 0) {
            // not login
            llNumber.setVisibility(View.GONE);
            tvNoReceive.setVisibility(View.GONE);
            btnViewOrder.setVisibility(View.GONE);
            btnToSendOrResend.setText(getResources().getString(R.string.ok_send));
        } else if (mStatus == 1) {
            // login
            tvPaySuccess.setText("付款成功，请前往门店取杯");
            llNumber.setVisibility(View.VISIBLE);
            llPhone.setVisibility(View.GONE);
            tvNoReceive.setVisibility(View.GONE);
            btnToSendOrResend.setText("发送至手机");
            tvWait.setVisibility(View.VISIBLE);
        } else if (mStatus == 2) {
            tvPaySuccess.setText("取杯码已发送至您的手机，请前往门店取杯");
            llNumber.setVisibility(View.GONE);
            llPhone.setVisibility(View.GONE);
            tvNoReceive.setVisibility(View.VISIBLE);
            btnToSendOrResend.setText("重新发送");
            btnViewOrder.setVisibility(View.VISIBLE);
            tvWait.setVisibility(View.GONE);
        } else if (mStatus == 3) {
            tvPaySuccess.setText("付款成功，请前往门店取杯");
            llNumber.setVisibility(View.VISIBLE);
            llPhone.setVisibility(View.VISIBLE);
            tvNoReceive.setVisibility(View.GONE);
            btnToSendOrResend.setText("确认发送");
            btnViewOrder.setVisibility(View.GONE);
            tvWait.setVisibility(View.GONE);
        }
    }

    /**
     * get status for current pay status
     */
    private void getStatus() {
        mStatus = 1;
    }

    /**
     * set header
     */
    private void setHeader() {
        ivBack.setVisibility(View.VISIBLE);
        tvHeaderTitle.setText(getResources().getString(R.string.pay_success));
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_pay_success;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_to_send_or_resend:
                ToastUtil.toast(context, mStatus + "");
                if (mStatus == 0) {
                    showDialog();
                } else if (mStatus == 1) {
                    mStatus = 3;
                    ShowContentByStatus();
                } else if (mStatus == 2) {

                    // 模拟成功之后分享----------------------
                    showShareDialog();

                } else if (mStatus == 3) {
                    mStatus = 2;
                    ShowContentByStatus();
                }
                break;
            case R.id.iv_back:
                if (mStatus == 0 || mStatus == 1 || mStatus == 3) {
                    finish();
                } else if (mStatus == 2){
                    mStatus = 3;
                    ShowContentByStatus();
                }
                break;
        }
    }

    /**
     * show dialog for confirm phone
     */
    private void showDialog() {
        View view = View.inflate(context, R.layout.item_dialog_confirm_phone, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        mDialog = builder.create();
        mDialog.setView(view);
        mDialog.show();
        ImageView ivEsc = view.findViewById(R.id.iv_esc);
        TextView tvPhone = view.findViewById(R.id.tv_phone);
        TextView tvCancel = view.findViewById(R.id.tv_cancel);
        TextView tvOk = view.findViewById(R.id.tv_ok);
        tvPhone.setText("要发送至的手机号码为" +
                etPhone.getText().toString().trim() + "，请\n确认是否正确？");
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDialog != null) {
                    mDialog.dismiss();
                }
            }
        });
        tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDialog != null) {
                    mDialog.dismiss();
                }
                mStatus = 2;
                ShowContentByStatus();
            }
        });
        ivEsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDialog != null) {
                    mDialog.dismiss();
                }
            }
        });
    }

    /**
     *  after pay to show share dialog
     */
    private void showShareDialog() {
        View view = View.inflate(context, R.layout.item_dialog_share, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        mDialog = builder.create();
        mDialog.setView(view);
        mDialog.show();
        Button btnShare = view.findViewById(R.id.btn_share);
        ImageView ivEsc = view.findViewById(R.id.iv_esc);
        ivEsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDialog != null) {
                    mDialog.dismiss();
                }
            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showShareTypeDialog(PaySuccessActivity.this);
            }
        });
    }

}
