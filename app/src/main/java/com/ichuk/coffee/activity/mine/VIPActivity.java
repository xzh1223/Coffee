package com.ichuk.coffee.activity.mine;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.MineGridBean;
import com.ichuk.coffee.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class VIPActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvLevelInfo;
    private CircleImageView civAccountPic;
    private TextView tvNickname;
    private TextView tvVipLevel;
    private TextView tvVip1;
    private ProgressBar pbLevel;
    private TextView tvVip2;
    private TextView tvVipNum;
    private GridView gvWelfare;
    private List<MineGridBean> mList = new ArrayList<>();
    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private LinearLayout llHalf;
    private LinearLayout llSecondHalf;
    private LinearLayout llBirth;
    private LinearLayout llProgress;
    private TextView tvProgress;
    private LinearLayout llPro;
    private int max = 0;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        tvLevelInfo = findViewById(R.id.tv_level_info);
        civAccountPic = findViewById(R.id.civ_account_pic);
        tvNickname = findViewById(R.id.tv_nickname);
        tvVipLevel = findViewById(R.id.tv_vip_level);
        tvVip1 = findViewById(R.id.tv_vip_1);
        pbLevel = findViewById(R.id.pb_level);
        tvVip2 = findViewById(R.id.tv_vip_2);
        tvVipNum = findViewById(R.id.tv_vip_num);
        llHalf = findViewById(R.id.ll_half);
        llSecondHalf = findViewById(R.id.ll_second_half);
        llBirth = findViewById(R.id.ll_birth);
        llProgress = findViewById(R.id.ll_progress);
        tvProgress = findViewById(R.id.tv_progress);
        llPro = findViewById(R.id.ll_pro);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvLevelInfo.setOnClickListener(this);
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
        showView();

        setPro();
    }

    /**
     * set progress
     */
    private void setPro() {
        max = 24;
        pbLevel.setMax(max);
        pbLevel.setProgress(1);
        tvProgress.setText(pbLevel.getProgress() + "");
        setPosWay1();
    }

    /**
     * show data on widget
     */
    private void showView() {
        tvNickname.setText("拿铁学徒-小明");
        tvVipLevel.setText("普金豆豆");
        tvVip1.setText("普金豆豆");
        tvVip2.setText("银金可可");
        String vimNum = "咖啡豆 " + pbLevel.getProgress() + "/" + pbLevel.getMax() + "颗";
        tvVipNum.setText(vimNum);
    }

    /**
     * get data from http
     */
    private void getData() {

    }

    /**
     * set header
     */
    private void setHeader() {
        tvHeaderTitle.setText(getResources().getString(R.string.vip_level));
        ivBack.setVisibility(View.VISIBLE);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_vip;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_level_info:
                ToastUtil.toast(context, "等级介绍");
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }

    /**
     * set progress to show location
     */
    public void setPos() {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) llPro.getLayoutParams();
        int pro = pbLevel.getProgress();
        int tW = tvProgress.getWidth();
        int wi = tvVip1.getWidth();
        int allw = pbLevel.getWidth();
        params.leftMargin = (int) (wi + (allw * pro / max) - 14);
        llPro.setLayoutParams(params);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            setPos();
        }
    }

    private void setPosWay1() {
        tvProgress.post(new Runnable() {
            @Override
            public void run() {
                setPos();
            }
        });
    }
}
