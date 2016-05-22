package com.example.sample;

import com.example.utils.Constants;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class WeiSheQuActivity extends Activity implements OnClickListener
{

	private WebView mWebView;
	private ProgressBar mBar;
	private int max = Constants.PROGRESS_MAX;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wei_she_qu);
		initUI();
		initWebView();
	}

	private void initUI()
	{
		ImageView mImgBack = (ImageView) findViewById(R.id.img_weishequ_back);
		ImageView mImgShare = (ImageView) findViewById(R.id.img_weishequ_share);

		mImgBack.setOnClickListener(this); // 返回
		mImgShare.setOnClickListener(this); // 分享

	}

	@SuppressLint("SetJavaScriptEnabled")
	public void initWebView()
	{
		final RelativeLayout mWebProgress = (RelativeLayout) findViewById(R.id.layout_web_progress);
		mBar = (ProgressBar) findViewById(com.example.sample.R.id.progressbar_weishequ);
		mBar.setMax(max );
		mWebView = (WebView) findViewById(R.id.webview_weishequ);
		WebSettings settings = mWebView.getSettings();
		settings.setJavaScriptEnabled(true);
		// settings.setJavaScriptCanOpenWindowsAutomatically(true); //
		// 支持JavaScript
		// settings.setTextSize(TextSize.LARGER); // 枚举方式 设置webView字体大小

		// 2) 防止跳出到其他浏览器
		mWebView.setWebChromeClient(new WebChromeClient()
		{

			@Override
			public void onProgressChanged(WebView view, int newProgress)
			{
				// 监控 浏览器下载htm进度
				mBar.setProgress(newProgress);
				if (newProgress == max)
				{ // 加载进度100%时，进度条加载和等待动画影藏，web内容显示出来
					mBar.setVisibility(View.GONE);
					mWebProgress.setVisibility(View.GONE);
					mWebView.setVisibility(View.VISIBLE);
				}
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

		mWebView.loadUrl(Constants.Url.MINE_SHEQU); // 指定的路径

		// 解析的路径
		// mWebView.loadDataWithBaseURL(null,
		// hotDetail.getArticle().getContent(), "text/html", "utf-8", null);
		// 设置图片自适应浏览器大小 4.4版本之前有效
		mWebView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);

	}

	@Override
	public void onClick(View v)
	{
		int id = v.getId();
		switch (id)
		{
		case R.id.img_weishequ_back:
			finish();
			break;
		case R.id.img_weishequ_share:
			// 简单分享(参考SupportV4的分享例子) ，因为mob分享在使用中会和mob短信验证起冲突
			ShareCompat.IntentBuilder b = ShareCompat.IntentBuilder.from(this);
			b.setType("text/plain").setText("I'm sharing!").startChooser();
			break;

		default:
			break;
		}

	}

}
