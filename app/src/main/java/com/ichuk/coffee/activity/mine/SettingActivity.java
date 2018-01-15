package com.ichuk.coffee.activity.mine;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.activity.home.LoginActivity;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.utils.ClearCacheUtil;
import com.ichuk.coffee.utils.ToastUtil;

public class SettingActivity extends BaseActivity implements View.OnClickListener {

    private static final int CLEAR_SUCCESS = 0x00;
    private RelativeLayout rlMineInfo;
    private RelativeLayout rlUpdateLoginPassword;
    private RelativeLayout rlSetPayPassword;
    private TextView tvCurrentVersion;
    private RelativeLayout rlClearCache;
    private RelativeLayout rlFeedback;
    private RelativeLayout rlAboutUs;
    private Button btnEsc;

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case CLEAR_SUCCESS:
                    ToastUtil.toast(context, getResources().getString(R.string.clear_cache_success));
                    try {
                        tvCache.setText(ClearCacheUtil.getTotalCacheSize(getApplicationContext()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
            return false;
        }
    });
    private TextView tvCache;
    private ImageView ivBack;
    private TextView tvHeaderTitle;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        rlMineInfo = findViewById(R.id.rl_mine_info);
        rlUpdateLoginPassword = findViewById(R.id.rl_update_login_password);
        rlSetPayPassword = findViewById(R.id.rl_set_pay_password);
        tvCurrentVersion = findViewById(R.id.tv_current_version);
        tvCache = findViewById(R.id.tv_cache);
        rlClearCache = findViewById(R.id.rl_clear_cache);
        rlFeedback = findViewById(R.id.rl_feedback);
        rlAboutUs = findViewById(R.id.rl_about_us);
        btnEsc = findViewById(R.id.btn_esc);
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
    }

    /**
     * Handle button click events
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_mine_info:
                toActivity(MineInfoActivity.class);
                break;
            case R.id.rl_update_login_password:
                toActivity(UpdateLoginPasswordActivity.class);
                break;
            case R.id.rl_set_pay_password:
                toActivity(SetPayPasswordActivity.class);
                break;
            case R.id.rl_clear_cache:
                // clear cache
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ClearCacheUtil.clearAllCache(getApplicationContext());
                            handler.sendEmptyMessage(CLEAR_SUCCESS);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
            case R.id.rl_feedback:
                toActivity(FeedbackActivity.class);
                break;
            case R.id.rl_about_us:
                toActivity(AboutUsActivity.class);
                break;
            case R.id.btn_esc:
                toActivity(LoginActivity.class);
                break;

        }
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        btnEsc.setOnClickListener(this);
        rlMineInfo.setOnClickListener(this);
        rlUpdateLoginPassword.setOnClickListener(this);
        rlSetPayPassword.setOnClickListener(this);
        rlClearCache.setOnClickListener(this);
        rlFeedback.setOnClickListener(this);
        rlAboutUs.setOnClickListener(this);
        ivBack.setVisibility(View.VISIBLE);

    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        tvHeaderTitle.setText(getResources().getString(R.string.setting));
        try {
            tvCache.setText(ClearCacheUtil.getTotalCacheSize(getApplicationContext()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String version = "V" + getVersionName();
        tvCurrentVersion.setText(version);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_setting;
    }

    /**
     * get current version
     */
    private String getVersionName() {
        // 获取packageManager的实例
        PackageManager packageManager = getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo;
        try {
            packInfo = packageManager.getPackageInfo(getPackageName(), 0);
            return packInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

}
