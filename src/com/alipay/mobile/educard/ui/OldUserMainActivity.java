package com.alipay.mobile.educard.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.alipay.mobile.educard.R;

public class OldUserMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE) ;
        setContentView(R.layout.activity_oldmain);
        
    }

}
