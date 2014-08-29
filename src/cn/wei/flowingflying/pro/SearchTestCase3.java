package cn.wei.flowingflying.pro;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.widget.SearchView;

public class SearchTestCase3 extends ActionAreaTestCase2 {

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		setUpSearchView(menu);
		return true;
	}

	private void setUpSearchView(Menu menu) {
		Log.e("search3", "onmenu");
		SearchView searchView = (SearchView) menu.findItem(R.id.menu_search)
				.getActionView();
		// showInfo("searchView : " + searchView);
		if (searchView == null) {
			showInfo("Fail to get Search View.");
			return;
		}
		searchView.setIconifiedByDefault(true);
		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		ComponentName cn = new ComponentName(this, SearchResultActvity.class);
		SearchableInfo info = searchManager.getSearchableInfo(cn);
		if (info == null) {
			showInfo("Fail to get search info.");
		}
		searchView.setSearchableInfo(info);
	}
}
