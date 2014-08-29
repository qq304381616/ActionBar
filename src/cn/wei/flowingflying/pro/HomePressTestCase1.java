package cn.wei.flowingflying.pro;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class HomePressTestCase1 extends Activity{
	private TextView tv = null;
	private ActionBar  bar = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.basic_test);
		tv = (TextView)findViewById(R.id.textViewId);
		tv.setMovementMethod(ScrollingMovementMethod.getInstance());
		tv.setText("");
		
		bar = getActionBar();
		bar.setDisplayHomeAsUpEnabled(true);
		//bar.setHomeButtonEnabled(true); //不显示箭头小符号，不建议使用
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		//方式三：无需代码特别处理，
		if(item.getItemId() == android.R.id.home){
			showInfo("Home is press");
			//方式一：本例直接关闭，即可返回主acitivity
			/*
			finish();
			return true; */
			
			//方式二：如果不是要回到上一个activity，而是一定要回退到主activity，又有可能终结要回退多个activity，才能推到主activity的情况。			
			Intent i = new Intent(this,MainActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			return true; 
			
			//方式三：在AndroidManifest.xml中设置parent activity，由系统按方式二的方式自动处理，无需特别代码
			//为了后面的继承类不需要每个都在manifest中设置，采用方式二。
		}
	
		return super.onOptionsItemSelected(item);
	}

	protected void showInfo(String s){
		tv.setText(s + "\n" + tv.getText());
		Log.d(getLocalClassName(),s);
	}
}
