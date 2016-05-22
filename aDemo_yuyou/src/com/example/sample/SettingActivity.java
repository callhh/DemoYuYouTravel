package com.example.sample;

import java.io.File;

import com.example.sample.usermanage.LoginActivity;
import com.example.sample.usermanage.User;
import com.xinbo.utils.FileUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.BmobUser;

public class SettingActivity extends Activity implements OnClickListener
{

	private TextView mTV_cache_data;
	private File cacheDir;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		initUI();
	}

	private void initUI()
	{
		RelativeLayout mSettingBack = (RelativeLayout) findViewById(R.id.layout_setting_back);
		RelativeLayout mClearCache = (RelativeLayout) findViewById(R.id.layout3_clear_img_cache);
		RelativeLayout mExit = (RelativeLayout) findViewById(R.id.shezhi_exit); // 退出登陆
		
		mSettingBack.setOnClickListener(this); // 返回 监听
		mClearCache.setOnClickListener(this); // 清除缓存
		mExit.setOnClickListener(this); // 退出登陆

		mTV_cache_data = (TextView) findViewById(R.id.tv_cache_data);
		cacheDir = getCacheDir();
		mTV_cache_data.setText("(" + FileUtils.size(cacheDir) + ")");

	}

	// @Override //不需要时去掉 否者客户端会界面会出现控件
	// public boolean onCreateOptionsMenu(Menu menu)
	// {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.settins, menu);
	// return true;
	// }
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch (id)
		{
		case R.id.action_settings:
			return true;
		case android.R.id.home: // 返回键监听
			// Intent intent = new Intent(this, MainActivity.class);
			// startActivity(intent );
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v)
	{
		int id = v.getId();
		switch (id)
		{
		case R.id.layout_setting_back: // 返回按钮 关闭页面
			finish();
			break;
		case R.id.shezhi_exit: // 退出登陆，账号注销前判断用户是否已登录
			User myUser = BmobUser.getCurrentUser(this, User.class);
			if (myUser == null)
			{
				Toast.makeText(this, "您当前未登录", Toast.LENGTH_SHORT).show();
				// 如果没登录,就跳转登录注册界面
				Intent intent = new Intent(this, LoginActivity.class);
				startActivity(intent);
			} else
			{
				// 步骤：点击退出-弹出AlertDialog对话框（取消或确认）- 点击确认，回到我的页面，提示注销成功，登陆头像和tv提示也要相应更新
				BmobUser.logOut(this);
			}
			finish();
			break;

		case R.id.layout3_clear_img_cache: // 清除图片缓存
			FileUtils.delFilesFromPath(cacheDir);
			Toast.makeText(this, "缓存清除成功", Toast.LENGTH_SHORT).show();
			mTV_cache_data.setText("(0KB)");
			break;

		// case R.id.layout2_share_setting: // 分享设置
		// startActivity(new Intent(this, SetShareActivity.class));
		// // 第一个参数是当前activity退出时的动画，第二个参数则是要跳转的activity进入时动画
		// overridePendingTransition(R.anim.activity_open_enter,R.anim.activity_close_exit);
		// break;

		default:
			break;
		}
	}

}
