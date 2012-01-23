package com.jasonfc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class AndroidJSONTwitterActivity extends Activity {
	private EditText text;
	private Uri url;
	private String result;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		url = Uri.parse("https://twitter.com/statuses/user_timeline/jasonfungsing.json");
		HttpAsyncTask task = new HttpAsyncTask(url.toString(), result, this);
		task.execute();
	}

	protected void getResponse(String result) {
		setContentView(R.layout.main);
		StringBuilder page = new StringBuilder();
		try {
			JSONArray jsonArray = new JSONArray(result);
			Log.i(AndroidJSONTwitterActivity.class.toString(), "Number of entries " + jsonArray.length());
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				page.append(jsonObject.getString("text"));
				page.append("\n");
				Log.i(AndroidJSONTwitterActivity.class.toString(), jsonObject.getString("text"));
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		TextView vw1 = (TextView) findViewById(R.id.text_view_1);
		vw1.setText(page.toString());

	}
}