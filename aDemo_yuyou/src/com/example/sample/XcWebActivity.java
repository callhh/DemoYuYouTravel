package com.example.sample;


import com.example.utils.Constants;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class XcWebActivity extends Activity {

	private WebView mWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_xc_web);
		initUI();
	}

	@SuppressLint("SetJavaScriptEnabled")
	private void initUI() {
		final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		mWebView = (WebView) findViewById(R.id.webView1);
		
		WebSettings settings = mWebView.getSettings();
		settings.setJavaScriptEnabled(true);
		
		String url = getIntent().getExtras().getString(Constants.IntentKey.INTENT_XC_WEB);
		mWebView.loadUrl(url);
		mWebView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				progressBar.setProgress(newProgress);
				super.onProgressChanged(view, newProgress);
			}
		});
		mWebView.setWebViewClient(new WebViewClient());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.xc_web, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
