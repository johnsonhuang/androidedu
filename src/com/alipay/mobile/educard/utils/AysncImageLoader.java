package com.alipay.mobile.educard.utils;

import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;

public class AysncImageLoader {

    /**
     * @desc 申明缓存变量map对象
     */
    private Map<String, SoftReference<Drawable>> imageCache = new HashMap<String , SoftReference<Drawable>>();
    
    /**
     * @desc 获取图片的Drawable对象
     * @param urlImg
     * @param call
     * @return Drawable对象
     */
    public Drawable loadDrawable(final String urlImg,final ImageCallback call) {
        //从缓存中获取
        if(imageCache.containsKey(urlImg)){
            SoftReference<Drawable> sReference = imageCache.get(urlImg) ;
            if(sReference!=null){
                return sReference.get();
            }
        }
        
        
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                call.imageLoaded((Drawable)msg.obj) ;
            }
        };
         
        
        /**
         * @desc 新开启的线程
         */
        
        new Thread(){
           public void run(){
               System.out.println(urlImg);
               Drawable drawable = getDrawableFromImageUrl(urlImg) ;
               imageCache.put(urlImg, new SoftReference<Drawable>(drawable)) ;
               System.out.println(drawable);
               
               
               Message msgMessage =  handler.obtainMessage(0,drawable) ;
               handler.sendMessage(msgMessage) ;
           }
        }.start() ;
        
        
        
        return null;
    }
    
    
    
    /**
     * 异步加载图片
     */
    public Drawable getDrawableFromImageUrl(String imgurl) {
        try {
            //根据图片的URL，下载图片，并生成一个Drawable对象
            return Drawable.createFromStream(new URL(imgurl).openStream(), "srcImage") ;    
        } catch (Exception e) {
            e.printStackTrace() ;
        }
        
        
        
        return null ;
    }
    
    /**
     * @desc 定义一个内部接口
     * 
     * @author chao.huang@alipay.com
     * @version $Id: Utils.java, v 0.1 2013-7-8 下午3:37:15 chao Exp $
     */
    public interface ImageCallback{
        public void imageLoaded(Drawable imageDrawable);
    };
    
    
}
