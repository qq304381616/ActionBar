package cn.wei.flowingflying.pro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView tv = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView)findViewById(R.id.main_tv);
		showInfo("" + this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.test_case_1_home:
			Intent i1 = new Intent(this,HomePressTestCase1.class);
			startActivity(i1);
			break;
		case R.id.test_case_2_action:
			Intent i2 = new Intent(this,ActionAreaTestCase2.class);
			i2.putExtra(ActionAreaTestCase2.MENU_ID, R.menu.bar1);
			startActivity(i2);
			break;
		case R.id.test_case_3_search:
			Intent i3 = new Intent(this,SearchTestCase3.class);
			startActivity(i3);
			break;
		case R.id.test_case_4_standard:
			Intent i4 = new Intent(this,StandardActionBarDemo.class);
			startActivity(i4);
			break;
		case R.id.test_case_5_tabbed:
			Intent i5 = new Intent(this,TabbedActionBarDemo.class);
			startActivity(i5);
			break;
			
		case R.id.test_case_6_list:
			Intent i6 = new Intent(this,ListActionBarDemo.class);
			startActivity(i6);
			break;
	
		default:
			break;
		}
		return true;
	}

	private void showInfo(String s){
		Log.d(getLocalClassName(),s);
		tv.append("\n" + s);
	}
}
