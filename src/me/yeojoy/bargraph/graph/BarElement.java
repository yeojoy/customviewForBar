package me.yeojoy.bargraph.graph;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class BarElement extends LinearLayout {

    private static final int MAX_WEIGHT = 10;
    
    private int mLayoutWidth = 0;
    
    private ImageView mIvElement;
    private Context mContext;
    
    public BarElement(Context context, int weight) {
        super(context);
        mContext = context;
        
        init();
    }
    
    public BarElement(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        
        int[] attrArray = {
                android.R.attr.layout_weight,
                android.R.attr.layout_width
        };
        
        TypedArray ta = context.obtainStyledAttributes(attrs, attrArray);
        mLayoutWidth = ta.getDimensionPixelSize(1, 0);
        
        init();
    }

    private void init() {
        mIvElement = new ImageView(mContext);
        
        drawBar();
    }

    private void drawBar() {
        
    }
    
    
}
