package com.example.sample;

import com.example.utils.Constants;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class AboutCompanyActivity extends Activity implements OnClickListener
{
	private WebView mWebView;
	private ProgressBar mBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_company);
		initUI();
		}
		
		
		
		private void initUI() {
			ImageView mImgBack = (ImageView) findViewById(R.id.img_aboutcompany_back);
			mImgBack.setOnClickListener(this);
			mBar = (ProgressBar) findViewById(com.example.sample.R.id.progressbar_about_company);
			mWebView = (WebView) findViewById(R.id.webview_about_company); 
			WebSettings settings = mWebView.getSettings();
			settings.setJavaScriptEnabled(true);
//			settings.setJavaScriptCanOpenWindowsAutomatically(true); // 支持JavaScript
			// settings.setTextSize(TextSize.LARGER); // 枚举方式 设置webView字体大小

			// 2) 防止跳出到其他浏览器
			mWebView.setWebChromeClient(new WebChromeClient()
			{

				@Override
				public void onProgressChanged(WebView view, int newProgress)
				{
					// 监控 浏览器下载htm进度
					mBar.setProgress(newProgress);
					super.onProgressChanged(view, newProgress);
				}
			});
			mWebView.setWebViewClient(new WebViewClient()
			{
				@Override
				public boolean shouldOverrideUrlLoading(WebView view, String url)
				{
					// 监控网址变化
					// Log.e("WebViewClient", "UrlLoading" + url);
					return super.shouldOverrideUrlLoading(view, url);
				}
			});
			
			mWebView.loadUrl(Constants.Url.MINE_DESCRIPTIONCOMPANY); //指定的路径
			// 设置图片自适应浏览器大小 4.4版本之前有效
			mWebView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
			
		}



		@Override
		public void onClick(View v)
		{
			switch (v.getId())
			{
			case R.id.img_aboutcompany_back:
				finish();
				break;

			default:
				break;
			}
		}
		
}
