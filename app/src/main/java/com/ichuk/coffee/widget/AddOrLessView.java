package com.ichuk.coffee.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ichuk.coffee.R;

/**
 * Created by xzh on 2017/12/5.
 * <p>
 * custom view
 */

public class AddOrLessView extends LinearLayout implements View.OnClickListener {

    private int mFlag = 0;
    private boolean isDelete = false;

    public AddOrLessView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        LayoutInflater.from(context).inflate(R.layout.view_add_or_less, this, true);
        findViews();
        tvNum.setText("1");
        tvLess.setOnClickListener(this);
        tvAdd.setOnClickListener(this);
    }

    public AddOrLessView(Context context) {
        super(context);
    }

    public AddOrLessView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private ImageView tvLess;
    private TextView tvNum;
    private ImageView tvAdd;

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
                    textChangedListener.onTextChanged(num, isDelete);
                }
                tvLess.setImageResource(R.mipmap.icon_less);
            }
            break;
            case R.id.tv_less: {
                int num = Integer.valueOf(tvNum.getText().toString());
                if (mFlag == 1) {
                    // can not delete
                    if (num > 0) {
                        isDelete = false;
                        num = num - 1;
                        tvNum.setText(String.valueOf(num));
                        if (textChangedListener != null) {
                            textChangedListener.onTextChanged(num, isDelete);
                        }
                    }
                } else if (mFlag == 0) {
                    if (num > 1) {
                        isDelete = false;
                        if (num == 2) {
                            tvLess.setImageResource(R.mipmap.icon_delete);
                        } else {
                            tvLess.setImageResource(R.mipmap.icon_less);
                        }
                        num = num - 1;
                        tvNum.setText(String.valueOf(num));
                        if (textChangedListener != null) {
                            textChangedListener.onTextChanged(num, isDelete);
                        }
                    } else {
                        isDelete = true;
                        if (textChangedListener != null) {
                            textChangedListener.onTextChanged(num, isDelete);
                        }
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
        void onTextChanged(int num, boolean isDelete);
    }

    private TextChangedListener textChangedListener;

    public void setTextChangedListener(TextChangedListener listener) {
        textChangedListener = listener;
    }

    /**
     * set min
     */
    public void setFlag(int flag) {
        mFlag = flag;
        if (mFlag == 0) {
            if (getNum() == 1) {
                tvLess.setImageResource(R.mipmap.icon_delete);
            } else {
                tvLess.setImageResource(R.mipmap.icon_less);
            }
        } else {
            tvLess.setImageResource(R.mipmap.icon_less);
            tvNum.setText("0");
        }
    }

}
