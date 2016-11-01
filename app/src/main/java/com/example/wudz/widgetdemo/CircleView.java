package com.example.wudz.widgetdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * USER：wudz on 2016/10/31 17:27
 * <p>
 * EMAIL：wudz@qianbaocard.com
 * <p>
 * TODO
 */

public class CircleView extends View {
    private static final int LEFT = 0;
    private static final int TOP = 1;
    private static final int CENTER = 2;
    private static final int RIGHT = 3;
    private static final int BOTTOM = 4;
    private int position = 2;
    float r = 0;
    Paint paint;
    float centerX = 0;
    float centerY = 0;

    public CircleView(Context context) {
        super(context);
        init();
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initParams(context, attrs);
        init();
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initParams(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
    }

    private void initParams(Context context, AttributeSet attrs) {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        if (typedArray != null) {
            r = typedArray.getDimension(R.styleable.CircleView_r, getResources().getDimension(R.dimen.activity_horizontal_margin));
            position = typedArray.getInt(R.styleable.CircleView_position, CENTER);
            typedArray.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getWidth();
        int height = getHeight();
        centerX = width / 2;
        centerY = height / 2;
        switch (position) {
            case LEFT:
                centerX = r + getPaddingLeft();
                break;
            case TOP:
                centerY = r + getPaddingTop();
                break;
            case CENTER:

                break;
            case RIGHT:
                centerX = width - r - getPaddingRight();
                break;
            case BOTTOM:
                centerY = height - r - getPaddingBottom();
                break;
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(0.5f);
        canvas.drawCircle(centerX, centerY, r, paint);
    }
}
