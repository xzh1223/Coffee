package com.ichuk.coffee.activity.mine;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;

public class MyGiftCardActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private TextView tvBalance;
    private LinearLayout llCard;
    private TextView tvCardNum;
    private LinearLayout llBuyRecord;
    private TextView tvBuyRecord;
    private EditText etCardNum;
    private EditText etCardPassword;
    private Button btnOk;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        tvBalance = findViewById(R.id.tv_balance);
        llCard = findViewById(R.id.ll_card);
        tvCardNum = findViewById(R.id.tv_card_num);
        llBuyRecord = findViewById(R.id.ll_buy_record);
        tvBuyRecord = findViewById(R.id.tv_buy_record);
        etCardNum = findViewById(R.id.et_card_num);
        etCardPassword = findViewById(R.id.et_card_password);
        btnOk = findViewById(R.id.btn_ok);
    }

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        tvHeaderTitle.setText(getResources().getString(R.string.my_gift_card));
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        btnOk.setOnClickListener(this);
        llCard.setOnClickListener(this);
        llBuyRecord.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        getData();
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
        return R.layout.activity_my_gift_card;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ok:

                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_card: {
                Intent intent = new Intent(context, MyGiftCardListActivity.class);
                intent.putExtra("page", "card");
                startActivity(intent);
                break;
            }
            case R.id.ll_buy_record: {
                Intent intent = new Intent(context, MyGiftCardListActivity.class);
                intent.putExtra("page", "record");
                startActivity(intent);
                break;
            }
        }
    }
}
