package cn.wei.flowingflying.pro;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SearchResultActvity extends Activity {
	private static final String TAG = "SearchResultActvity";
	private TextView tv = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		setContentView(R.layout.basic_test);

		try {
			ActivityInfo info = this.getPackageManager().getActivityInfo(
					getComponentName(), PackageManager.GET_META_DATA);

			String msg = info.metaData.getString("android.app.searchable");
			System.out.println("android.app.searchable:" + msg);

		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		tv = (TextView) findViewById(R.id.textViewId);
		tv.setText("");
		Log.e(TAG, "onCreate() is called");
		showInfo("onCreate() is called");
		doSearchQuery(getIntent());
	}

	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		showInfo("onNewIntent() is called");
		Log.e(TAG, "onCreate() is called");
		super.onNewIntent(intent);
		doSearchQuery(intent);
	}

	private void doSearchQuery(Intent intent) {
		Log.e(TAG, "onCreate() is called");
		showInfo(" doSearchQuery() is called");
		if (intent == null)
			return;

		String queryAction = intent.getAction();
		if (Intent.ACTION_SEARCH.equals(queryAction)) {
			String queryString = intent.getStringExtra(SearchManager.QUERY);
			showInfo("ËÑË÷ÄÚÈÝ£º" + queryString);
		}
	}

	private void showInfo(String s) {
		tv.setText(s + "\n" + tv.getText());
		Log.d(getLocalClassName(), s);
	}
}
