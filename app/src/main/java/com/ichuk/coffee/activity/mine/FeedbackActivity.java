package com.ichuk.coffee.activity.mine;

import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.mine.FeedbackAdapter;
import com.ichuk.coffee.base.SelectPhotoActivity;
import com.ichuk.coffee.bean.StringBean;
import com.ichuk.coffee.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class FeedbackActivity extends SelectPhotoActivity implements View.OnClickListener, RatingBar.OnRatingBarChangeListener {

    private ImageView ivBack;
    private TextView tvHeaderTitle;

    private RatingBar rbEvaluation;
    private RecyclerView rvType;
    private EditText etSuggest;
    private TextView tvSave;
    private List<StringBean> mList = new ArrayList<>();
    private FeedbackAdapter mAdapter;
    private LinearLayout llPhoto;
    private ImageView ivPhoto;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvSave = findViewById(R.id.tv_save);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        rbEvaluation = findViewById(R.id.rb_evaluation);
        rvType = findViewById(R.id.rv_type);
        etSuggest = findViewById(R.id.et_suggest);
        llPhoto = findViewById(R.id.ll_photo);
        ivPhoto = findViewById(R.id.iv_photo);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setOnClickListener(this);
        tvSave.setOnClickListener(this);
        llPhoto.setOnClickListener(this);
        ivPhoto.setOnClickListener(this);
        rbEvaluation.setOnRatingBarChangeListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        setHeader();
        getData();
        setRecyclerView();
    }

    /**
     * set recyclerView
     */
    private void setRecyclerView() {
        GridLayoutManager manager = new GridLayoutManager(context, 5);
        rvType.setLayoutManager(manager);
        mAdapter = new FeedbackAdapter(context, mList);
        rvType.setAdapter(mAdapter);
    }

    /**
     * set header
     */
    private void setHeader() {
        ivBack.setVisibility(View.VISIBLE);
        tvSave.setVisibility(View.VISIBLE);
        tvSave.setText(getResources().getString(R.string.submit));
        tvHeaderTitle.setText(getResources().getString(R.string.feedback));
    }

    private void getData() {
        mList.add(new StringBean("色", true));
        mList.add(new StringBean("香", false));
        mList.add(new StringBean("味", false));
        mList.add(new StringBean("形", false));
        mList.add(new StringBean("店铺形象", false));
        mList.add(new StringBean("美观", false));
        mList.add(new StringBean("设计", false));
        mList.add(new StringBean("消费体验", false));
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_feedback;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_save:
                ToastUtil.toast(context, "提交");
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_photo:
                selectPhoto();
                break;
            case R.id.iv_photo:
                selectPhoto();
                break;
        }
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        ToastUtil.toast(context, String.valueOf(rating));
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

    /**
     * set selected
     * @param position
     */
    public void setSelected(int position) {
        for (int i = 0; i < mList.size(); i++) {
            if (position == i) {//当前选中的Item改变背景颜色
                mList.get(i).setSelected(true);
            } else {
                mList.get(i).setSelected(false);
            }
        }
        mAdapter.notifyDataSetChanged();
    }
}
