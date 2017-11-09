package com.zonsim.login;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class LoginActivity extends AppCompatActivity {
    
    private MyOnGlobalLayoutListener mOnGlobalLayoutListener;
    private View mRootView;
    private ScrollView mScrollView;
    private RelativeLayout mViewById;
    private RelativeLayout mEtlayout1;
    private RelativeLayout mEtLayout2;
    private EditText mEditText1;
    private EditText mEditText2;
    private Window mRootWindow;
    private Button mButton;
    private int mRootBottom;
    private RelativeLayout mViewById1;
    private ImageView mViewById2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_login);
        
        mButton = (Button) findViewById(R.id.bt_login);
        mViewById1 = (RelativeLayout) findViewById(R.id.rl0);
        
        mViewById2 = (ImageView) findViewById(R.id.image);
        
        mRootWindow = getWindow();
        mRootView = mRootWindow.getDecorView().findViewById(android.R.id.content);
        mRootView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        Rect r = new Rect();
                        View view = mRootWindow.getDecorView();
                        view.getWindowVisibleDisplayFrame(r);
                        // r.left, r.top, r.right, r.bottom
                        
                        System.out.println(r.left);
                        System.out.println(r.top);
                        System.out.println(r.right);
                        System.out.println(r.bottom);
                        
                        mRootBottom = Math.max(mRootBottom, r.bottom);
                        
                        if (mRootBottom - r.bottom > 100) {
                            System.out.println("---------------------------");
                            mViewById2.setPadding(0, 0, 0, 0);
                        } else if (mRootBottom - r.bottom == 0) {
                            mViewById2.setPadding(0, 0, 0, 200);
                        }
                        
                        
                    }
                });
        
    }
    
    
}
