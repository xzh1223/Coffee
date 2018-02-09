package com.ichuk.coffee.activity.community;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.SelectPhotoActivity;
import com.ichuk.coffee.utils.ToastUtil;

public class LeaveMessageActivity extends SelectPhotoActivity implements View.OnClickListener {

    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private TextView tvSave;
    private EditText etContent;
    private LinearLayout llPhoto;
    private ImageView ivPhoto;

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setOnClickListener(this);
        tvSave.setOnClickListener(this);
        llPhoto.setOnClickListener(this);
        ivPhoto.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        setHeader();
    }

    /**
     * set header
     */
    private void setHeader() {
        tvHeaderTitle.setText(getResources().getString(R.string.leave_message));
        tvSave.setText(getResources().getString(R.string.submit));
        ivBack.setVisibility(View.VISIBLE);
        tvSave.setVisibility(View.VISIBLE);
    }

    /**
     * findViewById
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvSave = findViewById(R.id.tv_save);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        etContent = findViewById(R.id.et_content);
        llPhoto = findViewById(R.id.ll_photo);
        ivPhoto = findViewById(R.id.iv_photo);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_leave_message;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_save:
                submit();
                break;
            case R.id.ll_photo:
                selectPhoto();
                break;
            case R.id.iv_photo:
                selectPhoto();
                break;
        }
    }

    /**
     * submit content to server
     */
    private void submit() {

    }

    /**
     * send image to server and get image's url
     *
     * @param smallBitmap
     */
    @Override
    protected void sendImageToServer(Bitmap smallBitmap) {
        if (smallBitmap != null) {
            llPhoto.setVisibility(View.GONE);
            ivPhoto.setVisibility(View.VISIBLE);
            ivPhoto.setImageBitmap(smallBitmap);
        }
        ToastUtil.toast(context, "发送图片");
    }
}
