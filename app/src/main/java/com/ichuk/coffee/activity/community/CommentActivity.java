package com.ichuk.coffee.activity.community;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.CommentAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.CommentBean;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentActivity extends BaseActivity implements View.OnClickListener {

    private List<CommentBean> mList = new ArrayList<>();
    private TextView tvHeaderTitle;
    private ImageView ivBack;
    private LinearLayout llBottom;
    private EditText etCommentContent;
    private TextView tvCommentSend;
    private CircleImageView civCommunityAvatar;
    private TextView tvCommunityNickname;
    private TextView tvCommunityTime;
    private TextView tvCommunityContent;
    private TextView tvCommentNum;
    private TextView tvLikeNum;
    private RecyclerView rvComment;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        llBottom = findViewById(R.id.ll_bottom);
        etCommentContent = findViewById(R.id.et_comment_content);
        tvCommentSend = findViewById(R.id.tv_comment_send);
        civCommunityAvatar = findViewById(R.id.civ_community_avatar);
        tvCommunityNickname = findViewById(R.id.tv_community_nickname);
        tvCommunityTime = findViewById(R.id.tv_community_time);
        tvCommunityContent = findViewById(R.id.tv_community_content);
        tvCommentNum = findViewById(R.id.tv_comment_num);
        tvLikeNum = findViewById(R.id.tv_like_num);
        rvComment = findViewById(R.id.rv_comment);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        ivBack = findViewById(R.id.iv_back);
    }


    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.comment));
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        getData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(context);
        rvComment.setLayoutManager(manager);
        CommentAdapter mAdapter = new CommentAdapter(context, mList);
        rvComment.setAdapter(mAdapter);
    }

    /**
     * get data from request
     */
    private void getData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String image = intent.getStringExtra("image");
        String time = intent.getStringExtra("time");
        String content = intent.getStringExtra("content");
        int id = intent.getIntExtra("id", 0);
        int likeNum = intent.getIntExtra("likeNum", 0);
        int commentNum = intent.getIntExtra("commentNum", 0);
        tvCommunityNickname.setText(name);
        tvCommunityTime.setText(time);
        tvCommunityContent.setText(content);
        tvLikeNum.setText("点赞 （" + likeNum + "）");
        tvCommentNum.setText("评论 （" + commentNum + "）");

        CommentBean commentBean = new CommentBean();
        commentBean.setName("xzh");
        commentBean.setTime("2017-12-07 10:00:00");
        commentBean.setContent("内容内容内容");
        mList.add(commentBean);
        mList.add(commentBean);
        mList.add(commentBean);
        mList.add(commentBean);
        mList.add(commentBean);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_comment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
