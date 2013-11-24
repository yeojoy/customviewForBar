package me.yeojoy.bargraph;

import me.yeojoy.bargraph.graph.BarElementView;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    
    private EditText mEtWidth, mEtHeight;
    
    private BarElementView mBevBar;
    
    private Button mBtnSubmit;
    
    private float mDensity;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mDensity = getResources().getDisplayMetrics().density;
        
        mEtWidth = (EditText) findViewById(R.id.et_width);
        mEtHeight = (EditText) findViewById(R.id.et_height);
        
        mBevBar = (BarElementView) findViewById(R.id.bev_bar);
        
        mBtnSubmit = (Button) findViewById(R.id.btn_submit);
        mBtnSubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String w = mEtWidth.getText().toString();
                String h = mEtHeight.getText().toString();
                
                if (w == null || "".equals(w))
                    w = "90";
                if (h == null || "".equals(h))
                    h = "39";
                
                int width = Integer.parseInt(w);
                int height = Integer.parseInt(h);
                mBevBar.setViewSize(width, height);
                
                ViewGroup.LayoutParams params = mBevBar.getLayoutParams();
                params.width = width;
                params.height = height;
                mBevBar.setLayoutParams(params);
                
            }
        });
    }

    
    
}
