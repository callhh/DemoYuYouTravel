package com.example.sample;

import com.callhh.android.clearedittext.widget.ClearEditText;
import com.example.sample.fragment.DestinationFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class GlobalSearchesActivity extends Activity implements OnClickListener
{

	private ClearEditText mEdSearch;
	private ImageView mImgBack;
	private RelativeLayout mLayoutHotDestinationRecommend;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_global_searches);
		initUI();
	}

	private void initUI()
	{
		mImgBack = (ImageView) findViewById(R.id.iv_search_back);
		mEdSearch = (ClearEditText) findViewById(R.id.edt_global_search_name); //全局搜索  输入框
		mLayoutHotDestinationRecommend = (RelativeLayout) findViewById(R.id.layout_hot_destination_tuijian); //recommend 热门目的地推荐
		
		mImgBack.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		int id = v.getId();
		
		switch (id)
		{
		case R.id.iv_search_back:
			finish();
			break;
		case R.id.layout_hot_destination_tuijian: //热门目的地推荐，跳转到目的地页面
			startActivity(new Intent(this, DestinationFragment.class));
			finish();
			break;

		default:
			break;
		}
	}

}
