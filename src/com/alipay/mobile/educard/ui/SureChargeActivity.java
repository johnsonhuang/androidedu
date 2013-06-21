package com.alipay.mobile.educard.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.alipay.mobile.educard.R;

public class SureChargeActivity extends Activity {
    
    
    private Button btn ;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        
//        
        this.requestWindowFeature(Window.FEATURE_NO_TITLE) ;
//        //取消状态栏
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN) ;
//        
        
        
        setContentView(R.layout.activity_surecharge);
        
        btn = (Button)findViewById(R.id.sure_btn) ;
        btn.setOnClickListener(new ClickEvent()) ;
        
        
        
        
//        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f) ;
//        alphaAnimation.setDuration(8000) ;
//        btn.startAnimation(alphaAnimation);
        //取消标题
        
        
        
    }
    
    
    class ClickEvent implements  OnClickListener{

        @Override
        public void onClick(View v) {
            if((Button)v==btn){
                Intent intent = new Intent(SureChargeActivity.this,SuccessActivity.class);
                startActivity(intent);
            }
            
        }
        
    }
    
    
    

}
