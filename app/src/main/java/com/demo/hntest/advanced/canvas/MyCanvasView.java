package com.demo.hntest.advanced.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import com.demo.hntest.R;

public class MyCanvasView extends View {
    private Paint mPaint;//画笔
    private Path mPath;// 路径
    private int mDrawColor;// 画笔颜色
    private int mBackgroundColor;// 背景颜色
    private Canvas mExtraCanvas;//画布
    private Bitmap mExtraBitmaps;// 位图
    private Rect mFrame;// 边界

    private float mX , mY;
    // Don't draw every single pixel.
    // If the finger has has moved less than this distance, don't draw.
    private static final float TOUCH_TOLERANCE = 4; // 触摸容差


    public MyCanvasView(Context context) {
        this(context,null);
    }

    public MyCanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mBackgroundColor = ResourcesCompat.getColor(getResources(), R.color.purple_200, null);
        mDrawColor = ResourcesCompat.getColor(getResources(), R.color.purple_700, null);
        mPaint = new Paint();
        mPaint.setColor(mDrawColor);
        mPath = new Path();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);// 防抖
        mPaint.setStyle(Paint.Style.STROKE);// 设置画笔为空心
        mPaint.setStrokeJoin(Paint.Join.ROUND);// 设置画笔为圆角
        mPaint.setStrokeCap(Paint.Cap.ROUND);// 设置画笔为圆头
        mPaint.setStrokeWidth(12);// 设置画笔宽度
    }

    public MyCanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyCanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * Note: Called whenever the view changes size.
     * Since the view starts out with no size, this is also called after
     * the view has been inflated and has a valid size.
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //创建一个名为mExtraBitmaps的位图对象，尺寸为(w, h)，格式为ARGB_8888
        mExtraBitmaps = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
       //基于mExtraBitmaps创建一个mExtraCanvas画布对象。
        mExtraCanvas = new Canvas(mExtraBitmaps);
        mExtraCanvas.drawColor(mBackgroundColor);
        int inset = 40;
        //创建一个矩形区域mFrame，在原图基础上各边向内偏移40像素
        mFrame = new Rect(inset, inset, w - inset, h - inset);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mExtraBitmaps, 0, 0, null);
        canvas.drawRect(mFrame, mPaint);

    }

//    以下方法会考虑出不同触摸事件发生的情况：
//    由 onTouchEvent（） switch 语句确定。
//    这样将 switch 语句保留
//    简洁且更容易更改每个事件发生的情况。
    private void touchStart(float x, float y) {
        mPath.moveTo(x, y);
        mX = x;
        mY = y;
    }

    private void touchMove(float x, float y) {
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);
        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            //将给定的路径 mPath 中添加一个二次贝塞尔曲线
            //quadTo 方法用于添加一条从当前点到 (x + mX) / 2, (y + mY) / 2 的二次贝塞尔曲线。
            mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
            mX = x;
            mY = y;
            mExtraCanvas.drawPath(mPath,mPaint);

        }
    }

    private void touchUP() {
        //// Reset the path so it doesn't get drawn again.
        mPaint.reset();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchStart(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                touchMove(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                touchUP();
        }
        return true;
    }


}
