package com.example.sample;


import com.example.database.utils.UtilsSharePerference;
import com.example.dingwei.CitiesActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity
{
	Handler handler = new Handler();
	private boolean isFirst; // 保存是否第一次启动页面
	private SharedPreferences sp;
	private Editor edit;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		initActivity(); // 初始化界面
	}

	private void initActivity()
	{
		sp = getSharedPreferences("isFirst", 0);
		edit = sp.edit();

		isFirst = sp.getBoolean("isFirst", true);
		handler.postDelayed(new Runnable()
		{
			Intent intent = new Intent();

			public void run()
			{
				if (isFirst)
				{
					intent.setClass(SplashActivity.this, ProductTourActivity.class);
					edit.putBoolean("isFirst", false);
					edit.commit(); // 提交
					finish();
				} else
				{
					String city = UtilsSharePerference.getCity(SplashActivity.this);
					if (city == null)
					{
						intent.setClass(SplashActivity.this, CitiesActivity.class);
					}else
					{
						intent.setClass(SplashActivity.this, MainActivity.class);
						finish();
					}

				}

				overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
				startActivity(intent);
				
			}
		}, 2000);
	}

}
