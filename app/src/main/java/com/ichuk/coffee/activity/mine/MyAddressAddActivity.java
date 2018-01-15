package com.ichuk.coffee.activity.mine;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import me.next.tagview.TagCloudView;

public class MyAddressAddActivity extends BaseActivity implements TagCloudView.OnTagClickListener, View.OnClickListener {

    private EditText etName;
    private LinearLayout llAddressSelected;
    private TextView tvToSelect;
    private EditText etDetailedAddress;
    private LinearLayout llNearFamily;
    private TagCloudView tagCloudView;
    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private TextView tvSave;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        tvSave = findViewById(R.id.tv_save);
        etName = findViewById(R.id.et_name);
        llAddressSelected = findViewById(R.id.ll_address_selected);
        tvToSelect = findViewById(R.id.tv_to_select);
        etDetailedAddress = findViewById(R.id.et_detailed_address);
        llNearFamily = findViewById(R.id.ll_near_family);
        tagCloudView = findViewById(R.id.tag_cloud_view);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setVisibility(View.VISIBLE);
        tvSave.setVisibility(View.VISIBLE);
        tvHeaderTitle.setText(getResources().getString(R.string.add_address));
        tvToSelect.setText("请选择 >");

        tvToSelect.setOnClickListener(this);
        List<String> tags = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tags.add("标签" + i);
        }
        tagCloudView.setTags(tags);
        tagCloudView.setOnTagClickListener(this);
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
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_my_address_add;
    }

    @Override
    public void onTagClick(int position) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_to_select:
                ToastUtil.toast(context, "选择地址");
                break;
            case R.id.tv_save:
                ToastUtil.toast(context, "保存");
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
