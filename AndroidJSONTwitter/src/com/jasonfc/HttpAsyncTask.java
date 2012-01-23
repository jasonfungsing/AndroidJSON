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
import org.apache.http.conn.params.ConnManagerPNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class HttpAsyncTask extends AsyncTask<String, Integer, String> {

	private String url;
	private String result;
	private AndroidJSONTwitterActivity ajt;
	private ProgressDialog dialog;

	public HttpAsyncTask(String url, String result, AndroidJSONTwitterActivity ajt) {
		this.url = url;
		this.result = result;
		this.ajt = ajt;
	}

	@Override
	protected String doInBackground(String... arg0) {

		StringBuilder builder = new StringBuilder();
		HttpParams httpParameters = new BasicHttpParams();
		httpParameters.setIntParameter(ConnManagerPNames.MAX_TOTAL_CONNECTIONS, 5000);
		HttpClient client = new DefaultHttpClient(httpParameters);
		HttpGet httpget = new HttpGet(url);
		try {
			HttpResponse response = client.execute(httpget);
			StatusLine statusline = response.getStatusLine();
			int statusCode = statusline.getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(content));
				String line;
				while ((line = reader.readLine()) != null) {
					builder.append(line);
				}
			} else {
				Log.e(AndroidJSONTwitterActivity.class.toString(), "Failed to download file");
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			Log.e(AndroidJSONTwitterActivity.class.toString(), "Http Async task Io exception");
			publishProgress(1);
			e.printStackTrace();
		}
		return builder.toString();
	}

	@Override
	protected void onPreExecute() {
		dialog = new ProgressDialog(ajt, ProgressDialog.STYLE_SPINNER);
		dialog.setTitle("JSON Twitter");
		dialog.setMessage("Please, wait...");
		dialog.show();
	}
	
	@Override
	protected void onProgressUpdate(Integer... progress) {
		Toast.makeText(ajt, "Can not conntection to Internet, try later",Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onPostExecute(String result) {
		dialog.dismiss();
		ajt.getResponse(result);
	}
}
