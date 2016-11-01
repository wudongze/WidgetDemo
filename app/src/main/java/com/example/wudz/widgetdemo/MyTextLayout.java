package com.example.wudz.widgetdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * USER：wudz on 2016/10/31 14:34
 * <p>
 * EMAIL：wudz@qianbaocard.com
 * <p>
 * 自定义控件
 */

public class MyTextLayout extends RelativeLayout {
    private TextView tvLeft, tvRight;
    private TextView line;
    private RelativeLayout relativeLayout;

    public MyTextLayout(Context context) {
        super(context);
    }

    public MyTextLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(getContext(), R.layout.text_layout, this);
        tvLeft = (TextView) findViewById(R.id.tv_left);
        tvRight = (TextView) findViewById(R.id.tv_right);
        line = (TextView) findViewById(R.id.line);
        relativeLayout = (RelativeLayout) findViewById(R.id.root);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.MyTextLayout);
        String leftText = obtainStyledAttributes.getString(R.styleable.MyTextLayout_left_text);
        String rightText = obtainStyledAttributes.getString(R.styleable.MyTextLayout_right_text);
        int lineColor = obtainStyledAttributes.getColor(R.styleable.MyTextLayout_line_color, Color.parseColor("#ffffff"));
        float leftTextSize = obtainStyledAttributes.getDimension(R.styleable.MyTextLayout_left_text_size,15.0f);
        float rightTextSize = obtainStyledAttributes.getDimension(R.styleable.MyTextLayout_right_text_size,15.0f);
        int leftTextColor = obtainStyledAttributes.getColor(R.styleable.MyTextLayout_left_text_color,Color.parseColor("#000000"));
        int rightTextColor = obtainStyledAttributes.getColor(R.styleable.MyTextLayout_right_text_color,Color.parseColor("#000000"));
        boolean isShowLine = obtainStyledAttributes.getBoolean(R.styleable.MyTextLayout_is_show_line,true);

        tvLeft.setText(leftText);
        tvRight.setText(rightText);

        tvLeft.setTextSize(leftTextSize);
        tvRight.setTextSize(rightTextSize);

        tvLeft.setTextColor(leftTextColor);
        tvRight.setTextColor(rightTextColor);

        line.setBackgroundColor(lineColor);

        if (isShowLine) line.setVisibility(isShowLine ? VISIBLE : GONE);
    }

    public MyTextLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    public void setLeftText(String leftText) {
        tvLeft.setText(leftText);
    }

    public String getLeftText() {
        return tvLeft.getText().toString();
    }

    public void setRightText(String rightText) {
        tvRight.setText(rightText);
    }

    public String getRightText() {
        return tvRight.getText().toString();
    }

    public void isShowLine(boolean flag) {
        line.setVisibility(flag ? VISIBLE : GONE);
    }

    public void setOnClickLintener(OnClickListener onClickLintener) {
        relativeLayout.setOnClickListener(onClickLintener);
    }
}
