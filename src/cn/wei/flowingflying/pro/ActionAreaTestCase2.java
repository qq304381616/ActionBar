package cn.wei.flowingflying.pro;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ActionAreaTestCase2 extends HomePressTestCase1{
	private int menuId = R.menu.bar;
	public static String MENU_ID="cn.wei.flowingflying.pro.MENU_RESOURCE_ID";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		if(intent != null)
			menuId = intent.getIntExtra(MENU_ID, R.menu.bar);	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();

		inflater.inflate(menuId, menu);
		//inflater.inflate(R.menu.bar1, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		showInfo("select : " + item.getTitle());
		
		ActionBar bar = getActionBar();
		switch(item.getItemId()){
		case R.id.menu_hide:
			bar.hide();
			break;
			
		case R.id.menu_show:
			bar.show();
			break;

		case R.id.menu_action_standard:
			bar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
			bar.setTitle("Standard Mode");
			break;
		
		case R.id.menu_action_tabbed:
			bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
			bar.setTitle("Tab Mode");
			break;
		
		case R.id.menu_action_list:
			bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
			bar.setTitle("List Mode");
			break;
		default:
			break;
		}
		

		return super.onOptionsItemSelected(item);
	}
}
