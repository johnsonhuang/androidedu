package com.alipay.mobile.educard.ui;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.alipay.mobile.educard.R;
import com.alipay.mobile.educard.utils.AysncImageLoader;
import com.alipay.mobile.educard.utils.AysncImageLoader.ImageCallback;

public class ImageMainActivity extends Activity {
    
    private AysncImageLoader loader = new AysncImageLoader() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageloader) ;
        loadImage("http://www.iteye.com/upload/logo/user/329164/45482c1f-a52e-3a75-ba5e-7cfad18bbb98.jpg?1286802847", R.id.img01) ;
        loadImage("http://soso.qstatic.com/30d/img/web/icon_safe.png", R.id.img02) ;
        loadImage("http://cache.soso.com/30d/img/web/logo130130.png", R.id.img03) ;
    }
    
    
    
    private void loadImage(final String url,final int  id){
        ImageView iView = (ImageView)findViewById(id) ;
        ImageCallback iCallback = new com.alipay.mobile.educard.utils.ImageCallback(iView) ;
        Drawable drawable = loader.loadDrawable(url, iCallback) ;
        
        if(drawable!=null){
            System.out.println("test succ");
            iView.setImageDrawable(drawable);
        }
        
        
        
    }

}
