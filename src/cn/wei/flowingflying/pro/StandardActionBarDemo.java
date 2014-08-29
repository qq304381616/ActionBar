package cn.wei.flowingflying.pro;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class StandardActionBarDemo extends SearchTestCase3 implements ActionBar.TabListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		workWithTabbedActionBar();
	}

	private void workWithTabbedActionBar(){
		ActionBar bar = getActionBar();
		bar.setTitle("标准action bar"); //修改action bar的title内容
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD); //此为缺省值，可以不设置
		
		//在标准模式下，即使设置了Tab，也不能显示。
		Tab tab1 = bar.newTab();
		tab1.setText("Tab1");
		tab1.setTabListener(this);
		bar.addTab(tab1);

		Tab tab2 = bar.newTab();
		tab2.setText("Tab2");
		tab2.setTabListener(this);
		bar.addTab(tab2);
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		showInfo(tab.getText() + " onTabReselected() is called");	
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		showInfo(tab.getText() + " onTabSelected() is called");	
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		showInfo(tab.getText() + " onTabUnselected() is called");	
	}
	
	

}
