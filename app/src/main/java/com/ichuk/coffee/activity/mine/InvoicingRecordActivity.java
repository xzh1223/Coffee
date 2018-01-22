package com.ichuk.coffee.activity.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.mine.InvoicingRecordAdapter;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.bean.InvoicingBean;

import java.util.ArrayList;
import java.util.List;

public class InvoicingRecordActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView rvInvoicingRecord;
    private TextView tvHeaderTitle;
    private ImageView ivBack;
    private List<InvoicingBean> mList = new ArrayList<>();

    /**
     * set event
     */
    @Override
    protected void setEvent() {
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
        setRecyclerView();
    }

    /**
     *  get data from http
     */
    private void getData() {
        InvoicingBean invoicingBean = new InvoicingBean();
        invoicingBean.setName("xxxxxxx");
        invoicingBean.setMoney("23.00");
        invoicingBean.setTime("2018-01-19 11:11:11");
        mList.add(invoicingBean);
        mList.add(invoicingBean);
        mList.add(invoicingBean);
    }

    /**
     *  set recyclerView
     */
    private void setRecyclerView() {
        rvInvoicingRecord.setLayoutManager(new LinearLayoutManager(context));
        rvInvoicingRecord.setAdapter(new InvoicingRecordAdapter(context, mList));
    }

    /**
     * set header
     */
    private void setHeader() {
        tvHeaderTitle.setText(getResources().getString(R.string.invoicing_record));
        ivBack.setVisibility(View.VISIBLE);
    }

    /**
     * findViewById
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        rvInvoicingRecord = findViewById(R.id.rv_invoicing_record);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_invoicing_record;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
