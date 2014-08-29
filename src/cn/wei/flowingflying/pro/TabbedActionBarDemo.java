package cn.wei.flowingflying.pro;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class TabbedActionBarDemo extends SearchTestCase3 implements ActionBar.TabListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		workWithTabbedActionBar();
	}

	private void workWithTabbedActionBar(){
		ActionBar bar = getActionBar();
		bar.setTitle("Tabbed action bar"); //ÐÞ¸Äaction barµÄtitleÄÚÈÝ
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
				

		Tab tab1 = bar.newTab();
		tab1.setText("Tab1");
		tab1.setTabListener(this);
		bar.addTab(tab1);

		bar.addTab(bar.newTab()
				.setText("Tab2")
				.setTabListener(this));	
	}

	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		showInfo(tab.getText() + " onTabReselected() is called");		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		showInfo(tab.getText() + " onTabSelected() is called");		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		showInfo(tab.getText() + " onTabUnselected() is called");
	}
	
	
}
