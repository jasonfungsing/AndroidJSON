package com.jasonfc;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class AndroidJSONActivity extends Activity {
	private Uri url;
	private String result;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		url = Uri.parse("https://www.googleapis.com/blogger/v2/blogs/3708989433942125034/posts?pp=1&key=AIzaSyC_3eypluNy--ZCY1dXX_JmfmuUAOrkH1Y");
		HttpAsyncTask task = new HttpAsyncTask(url.toString(), result, this);
		task.execute();
	}

	protected void displayResults(String result) {
		setContentView(R.layout.main);
		TextView vw1 = (TextView) findViewById(R.id.text_view_1);
		vw1.setText(result);
	}
}