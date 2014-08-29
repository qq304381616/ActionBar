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
		//bar.setHomeButtonEnabled(true); //����ʾ��ͷС���ţ�������ʹ��
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		//��ʽ������������ر���
		if(item.getItemId() == android.R.id.home){
			showInfo("Home is press");
			//��ʽһ������ֱ�ӹرգ����ɷ�����acitivity
			/*
			finish();
			return true; */
			
			//��ʽ�����������Ҫ�ص���һ��activity������һ��Ҫ���˵���activity�����п����ս�Ҫ���˶��activity�������Ƶ���activity�������			
			Intent i = new Intent(this,MainActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			return true; 
			
			//��ʽ������AndroidManifest.xml������parent activity����ϵͳ����ʽ���ķ�ʽ�Զ����������ر����
			//Ϊ�˺���ļ̳��಻��Ҫÿ������manifest�����ã����÷�ʽ����
		}
	
		return super.onOptionsItemSelected(item);
	}

	protected void showInfo(String s){
		tv.setText(s + "\n" + tv.getText());
		Log.d(getLocalClassName(),s);
	}
}
