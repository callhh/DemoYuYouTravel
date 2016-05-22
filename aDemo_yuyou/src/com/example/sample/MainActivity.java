package com.example.sample;

import com.example.database.utils.TabDB;
import com.umeng.analytics.MobclickAgent;
import com.igexin.sdk.PushManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity
{

	private FragmentTabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initUI();
		initData();
	}

	@SuppressLint("InflateParams")
	private void initUI()
	{
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		// 放片段 Fragment 依附在Activity上
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		LayoutInflater inflater = getLayoutInflater(); // 获得布局管理器
		for (int i = 0; i < TabDB.getTabsImges().length; i++)
		{
			View indicatorView = inflater.inflate(R.layout.indicator_item, null);
			ImageView imageView = (ImageView) indicatorView.findViewById(R.id.ima_indicator);
			imageView.setImageResource(TabDB.getTabsImges()[i]);
			// newTabSpec("simple") 设置标签 // setIndicator("Simple") 设置指示器 //
			// 设置指示器的图片
			// 可能会报非法状态异常，标签写错或者没有初始化
			mTabHost.addTab(mTabHost.newTabSpec("" + TabDB.getTabsImges()[i]).setIndicator(indicatorView),
					TabDB.getFragments()[i], null);
		}
	}

	private void initData()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// Umeng 友盟数据统计调用
	public void onResume()
	{
		super.onResume();
		MobclickAgent.onResume(this);
	}
	// Umeng 友盟数据统计调用
	public void onPause()
	{
		super.onPause();
		MobclickAgent.onPause(this);
	}

	
	long preTime;
	// 双击退出
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && 
				event.getAction() == KeyEvent.ACTION_DOWN)
		{
			if (System.currentTimeMillis() - preTime < 2000) // 在两秒内，退出
			{
				finish();
			}else
			Toast.makeText(this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
			// System.exit(0);
			preTime = System.currentTimeMillis(); // 将第一次点击的时间保存 
		}
		return true;// 拦截系统设置
	}

	
}
