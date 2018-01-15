package com.ichuk.coffee.activity.mine;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.FeedbackAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.StringBean;
import com.ichuk.coffee.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class FeedbackActivity extends BaseActivity implements View.OnClickListener, RatingBar.OnRatingBarChangeListener {

    private ImageView ivBack;
    private TextView tvHeaderTitle;

    private RatingBar rbEvaluation;
    private GridView gvType;
    private EditText etSuggest;
    private ImageView ivUploadPicture;
    private TextView tvSave;
    private List<StringBean> mList = new ArrayList<>();
    private FeedbackAdapter mAdapter;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvSave = findViewById(R.id.tv_save);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        rbEvaluation = findViewById(R.id.rb_evaluation);
        gvType = findViewById(R.id.gv_type);
        etSuggest = findViewById(R.id.et_suggest);
        ivUploadPicture = findViewById(R.id.iv_upload_picture);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setVisibility(View.VISIBLE);
        tvSave.setVisibility(View.VISIBLE);
        tvSave.setText(getResources().getString(R.string.submit));
        tvHeaderTitle.setText(getResources().getString(R.string.feedback));
        ivBack.setOnClickListener(this);
        tvSave.setOnClickListener(this);
        rbEvaluation.setOnRatingBarChangeListener(this);
        ivUploadPicture.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        getData();
        setGridView();
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

    private void setGridView() {
        mAdapter = new FeedbackAdapter(context, mList);
        gvType.setAdapter(mAdapter);
        gvType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.e("TAG", "onItemClick: " + position);
                for (int i = 0; i < mList.size(); i++) {
                    if (position == i) {//当前选中的Item改变背景颜色
                        mList.get(i).setSelected(true);
                    } else {
                        mList.get(i).setSelected(false);
                    }
                }
                mAdapter.notifyDataSetChanged();
            }
        });
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
            case R.id.iv_upload_picture:
                ToastUtil.toast(context, "go to select picture");
                break;
        }
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        ToastUtil.toast(context, String.valueOf(rating));
    }
}
