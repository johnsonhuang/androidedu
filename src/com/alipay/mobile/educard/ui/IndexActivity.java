package com.alipay.mobile.educard.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.alipay.mobile.educard.R;
import com.alipay.mobile.educard.vo.UserInfo;

public class IndexActivity extends Activity {
    private Button chargeButton = null ;
    private Button queryButton = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE) ;
        setContentView(R.layout.activity_index);
        
        chargeButton = (Button)findViewById(R.id.charge_button) ;
        queryButton = (Button)findViewById(R.id.query_button) ;
        
//        AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0.1f) ;
//        alphaAnimation.setDuration(3000) ;
//        iv.startAnimation(alphaAnimation);
//        if(isOldUser()!=null){
//            Intent intent = new Intent(this,MainActivity.class);
//            startActivity(intent);
//        }else{
//            Intent intent = new Intent(this,OldUserMainActivity.class);
//            startActivity(intent);
//        }
        
        chargeButton.setOnClickListener(new clickEvent()) ;
        queryButton.setOnClickListener(new clickEvent()) ;
        
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.index, menu);
        return true;
    }
    
    
    
    
    class clickEvent implements OnClickListener{

        @Override
        public void onClick(View v) {
            
            if(v!=null){
                if(chargeButton==(Button)v){
                    Intent intent = new Intent(IndexActivity.this,MainActivity.class);
                    IndexActivity.this.startActivity(intent);
                }else{
                    Intent intent = new Intent(IndexActivity.this,OldUserMainActivity.class);
                    IndexActivity.this.startActivity(intent);
                }
            }
        }
        
    }
    
    /**
     * @des 获取登录信息
     *  如果已登录则直接返回登录对象
     *  否则返回null
     * 
     * @return
     */
    private UserInfo isOldUser(){
        boolean isOld = false ;
        if(isOld){
            return null ;
        }else{
            /**
             * 获取登录信息
             */
            UserInfo uInfo = new UserInfo() ;
            return uInfo ;
//            return null ;
        }
    }

}
