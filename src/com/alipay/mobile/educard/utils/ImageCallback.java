package com.alipay.mobile.educard.utils;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class ImageCallback implements AysncImageLoader.ImageCallback{
    private ImageView imageView ;
    /**
     * 构造方法
     * @param iView
     */
    public ImageCallback(ImageView iView){
        super() ;
        this.imageView = iView ;
    }
    
    /**
     * 实现接口方法
     * @see com.alipay.mobile.educard.utils.AysncImageLoader.ImageCallback#imageLoaded(android.graphics.drawable.Drawable)
     */
    @Override
    public void imageLoaded(Drawable imageDrawable) {
        imageView.setImageDrawable(imageDrawable) ;
    }

    
}

