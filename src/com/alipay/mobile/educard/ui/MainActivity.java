package com.alipay.mobile.educard.ui;

import java.util.List;

import com.alipay.mobile.educard.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private Intent intent = new Intent() ;
	

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE) ;
        setContentView(R.layout.activity_main);
        
        SpDemo();
        
        
    }
    Spinner sp1;
    ArrayAdapter<String> adapter;
    List<String> allnum;
    private static String[] arr={"上海大学","北京大学","复旦大学"};//定义一组选项
    private static String[] Value={"上海大学","北京大学","复旦大学"};//定义选中后得到的值
	private void SpDemo() {
		//下面开始插入数据
		sp1=(Spinner)findViewById(R.id.mySpinner);
		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arr);
		//将可选内容与ArrayAdapter连接
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//设置下拉列表的风格
		sp1.setAdapter(adapter);
		//将adapter添加到Spinner中
		//插入数据结束
		//下面开始获取选中的值
		sp1.setSelection(2);
		sp1.setOnItemSelectedListener(new OnItemSelectedListener(){
			@Override
 
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, Value[arg2],10).show();
 
			}
 
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "没选中",10).show();
			}
 
		});
		
		
		CheckBox cb = (CheckBox)findViewById(R.id.smscheckbox) ;
		cb.setOnCheckedChangeListener(new CheckListenEvent()) ;
		
		
		Button nextBtn  = (Button)this.findViewById(R.id.surebtn) ;
		nextBtn.setOnClickListener(new NextClickEvent()) ;
		
		
	}
	
	
	class CheckListenEvent implements OnCheckedChangeListener{
	    EditText nubmer = (EditText)findViewById(R.id.mobile) ;
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            
            if(isChecked){
                nubmer.setVisibility(View.VISIBLE) ;
//                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f) ;
//                alphaAnimation.setDuration(3000) ;
//                nubmer.startAnimation(alphaAnimation);
            }else{
                nubmer.setVisibility(View.INVISIBLE) ;
            }
        }
	    
	}
	
	class NextClickEvent implements OnClickListener{
	    static final int PICK_CONTACT=1;
		@Override
		public void onClick(View v) {
			
			/**
			 * @author chao 通过intent来启动下一个activity
			 */
			
			
			Intent it= null ;
			it = new Intent(MainActivity.this, SureChargeActivity.class);
//			it = new Intent(MainActivity.this, InflateMainActivity.class);
//			it = new Intent(Intent.ACTION_DIAL,Uri.parse("tel://13800138000"));

			  
			/**
			 * @author chao
			 * @description 调用地图
			 */
//			Uri mapUri = Uri.parse("geo:38.899533,-77.036476");
//			it = new Intent(Intent.ACTION_VIEW, mapUri);

			startActivity(it);
			
			
			
			
			

//            Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
//            startActivityForResult(intent, PICK_CONTACT);
		}
		
	}

}
