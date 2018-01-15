package com.ichuk.coffee.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;

/**
 * Created by xzh on 2017/12/5.
 * <p>
 * custom view
 */

public class AddOrLessView extends LinearLayout implements View.OnClickListener {

    public AddOrLessView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        LayoutInflater.from(context).inflate(R.layout.view_add_or_less, this, true);
        findViews();
        tvNum.setText("0");
        tvLess.setOnClickListener(this);
        tvAdd.setOnClickListener(this);
    }

    public AddOrLessView(Context context) {
        super(context);
    }

    public AddOrLessView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private TextView tvLess;
    private TextView tvNum;
    private TextView tvAdd;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        tvLess = findViewById(R.id.tv_less);
        tvNum = findViewById(R.id.tv_num);
        tvAdd = findViewById(R.id.tv_add);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_add: {
                int num = Integer.valueOf(tvNum.getText().toString());
                num = num + 1;
                tvNum.setText(String.valueOf(num));
                if (textChangedListener != null) {
                    textChangedListener.onTextChanged(num);
                }
            }
            break;
            case R.id.tv_less: {
                int num = Integer.valueOf(tvNum.getText().toString());
                if (num > 0) {
                    num = num - 1;
                    tvNum.setText(String.valueOf(num));
                    if (textChangedListener != null) {
                        textChangedListener.onTextChanged(num);
                    }
                }
            }
            break;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /**
     * get number
     */
    public int getNum() {
        return Integer.valueOf(tvNum.getText().toString());
    }

    /**
     * set number
     */
    public void setText(String string) {
        tvNum.setText(string);
    }

    public interface TextChangedListener {
        void onTextChanged(int num);
    }

    private TextChangedListener textChangedListener;

    public void setTextChangedListener(TextChangedListener listener) {
        textChangedListener = listener;
    }


}
