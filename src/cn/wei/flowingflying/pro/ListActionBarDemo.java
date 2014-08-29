package cn.wei.flowingflying.pro;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ListActionBarDemo extends SearchTestCase3 implements OnNavigationListener{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		workWithListActionBar();
	}

	protected void workWithListActionBar(){
		ActionBar bar = getActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST );
		
		ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item,
				new String[]{"One","Two"});
		myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		bar.setListNavigationCallbacks(myAdapter, this);
	}

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		// TODO Auto-generated method stub
		showInfo("List select position " +  itemPosition + " itemId " + itemId);
		return false;
	}
	
}
