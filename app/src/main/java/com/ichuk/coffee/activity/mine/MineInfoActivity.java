package com.ichuk.coffee.activity.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.utils.ToastUtil;

import de.hdodenhof.circleimageview.CircleImageView;

public class MineInfoActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private RelativeLayout rlMineAvatar;
    private CircleImageView civAvatar;
    private RelativeLayout rlNickname;
    private TextView tvNickname;
    private RelativeLayout rlSex;
    private TextView tvSex;
    private RelativeLayout rlBirthday;
    private TextView tvBirthday;
    private RelativeLayout rlPhoneNum;
    private TextView tvPhoneNum;
    private RelativeLayout rlAddress;
    private TextView tvVip;
    private RelativeLayout rlVip;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        rlMineAvatar = findViewById(R.id.rl_mine_avatar);
        civAvatar = findViewById(R.id.civ_avatar);
        rlNickname = findViewById(R.id.rl_nickname);
        tvNickname = findViewById(R.id.tv_nickname);
        rlVip = findViewById(R.id.rl_vip);
        tvVip = findViewById(R.id.tv_vip);
        rlSex = findViewById(R.id.rl_sex);
        tvSex = findViewById(R.id.tv_sex);
        rlBirthday = findViewById(R.id.rl_birthday);
        tvBirthday = findViewById(R.id.tv_birthday);
        rlPhoneNum = findViewById(R.id.rl_phone_num);
        tvPhoneNum = findViewById(R.id.tv_phone_num);
        rlAddress = findViewById(R.id.rl_address);
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        rlMineAvatar.setOnClickListener(this);
        rlNickname.setOnClickListener(this);
        rlVip.setOnClickListener(this);
        rlSex.setOnClickListener(this);
        rlBirthday.setOnClickListener(this);
        rlPhoneNum.setOnClickListener(this);
        rlAddress.setOnClickListener(this);
        ivBack.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        getData();
        tvHeaderTitle.setText(getResources().getString(R.string.mine_info));
        tvNickname.setText("xzh");
        tvSex.setText("男");
        tvBirthday.setText("1995-12-23");
        tvPhoneNum.setText("17751146615");
    }

    /**
     * get data
     */
    private void getData() {

    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_mine_info;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_mine_avatar:
                ToastUtil.toast(context, "avatar");
                break;
            case R.id.rl_nickname:
                toActivity(UpdateNickNameActivity.class);
                break;
            case R.id.rl_vip:
                toActivity(VIPActivity.class);
                break;
            case R.id.rl_sex:
                ToastUtil.toast(context, "rl_sex");
                break;
            case R.id.rl_birthday:
                ToastUtil.toast(context, "rl_birthday");
                break;
            case R.id.rl_address:
                toActivity(MyAddressActivity.class);
                break;
            case R.id.iv_back:
                finish();
                break;

        }
    }
}
