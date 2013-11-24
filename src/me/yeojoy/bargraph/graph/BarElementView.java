package me.yeojoy.bargraph.graph;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


public class BarElementView extends View {

    private static final String TAG = BarElementView.class.getSimpleName();
    
    private int mWidth, mHeight;
    
    private float mDensity;
    
    @SuppressLint("Recycle")
    public BarElementView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "BarElementView()");
        
//        int[] attrArray = { android.R.attr.layout_width };
//        TypedArray ta = context.obtainStyledAttributes(attrs, attrArray);
//        
//        mWidth = ta.getDimensionPixelSize(0, 10);
        
        mDensity = context.getResources().getDisplayMetrics().density;
    }
    
    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        Log.d(TAG, "onDraw()");
        super.onDraw(canvas);
        
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        
        Rect rect = new Rect(0, 0, mWidth, mHeight);
        canvas.drawRect(rect, paint);
    }
    
    public void setViewWidth(int width) {
        Log.d(TAG, "setViewWidth(), width : " + width);
        mWidth = (int) (width * mDensity);
        invalidate();
    }
    
    public void setViewHeight(int height) {
        Log.d(TAG, "setViewHeight(), height : " + height);
        mHeight = (int) (height * mDensity);
        invalidate();
    }
    
    public void setViewSize(int width, int height) {
        Log.d(TAG, "setViewHeight(), width : " + width
                + "   height : " + height);
        mWidth = (int) (width * mDensity);
        mHeight = (int) (height * mDensity);
        invalidate();
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.d(TAG, "onMeasure() before, Width : " + widthMeasureSpec + "   Height : " + heightMeasureSpec);
        
        // set Width
        switch (MeasureSpec.getMode(widthMeasureSpec)) {
            case MeasureSpec.AT_MOST:
                mWidth = Math.min(MeasureSpec.getSize(widthMeasureSpec), mWidth);
                break;
                
            case MeasureSpec.EXACTLY:
                mWidth = MeasureSpec.getSize(widthMeasureSpec);
                break;
        }
        
        // set Height
        switch (MeasureSpec.getMode(heightMeasureSpec)) {
            case MeasureSpec.AT_MOST:
                mHeight = Math.min(MeasureSpec.getSize(heightMeasureSpec), mHeight); 
                break;
                
            case MeasureSpec.EXACTLY:
                mHeight = MeasureSpec.getSize(heightMeasureSpec);
                break;
        }
        
        Log.d(TAG, "onMeasure() after, Width : " + mWidth + "   Height : " + mHeight);
        setMeasuredDimension(mWidth, mHeight);
    }

}
