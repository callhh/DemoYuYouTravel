package com.example.database.utils;

import com.example.sample.R;
import com.example.sample.fragment.DestinationFragment;
import com.example.sample.fragment.FindFragment;
import com.example.sample.fragment.HomeFragment;
import com.example.sample.fragment.MyTongChengFragment;
import com.example.sample.fragment.XingChengFragment;

public final class TabDB
{
	public TabDB()
	{
	};

	// public static String[] getTabsTxt(){
	// String[] tabs={"新闻","阅读","试听","发现"," 我"};
	// return tabs;
	// }
	// 获得资源文件的图片
	public static int[] getTabsImges()
	{
		int[] images =
		{ R.drawable.selector_btn_home_main, R.drawable.selector_btn_home_destination,
				R.drawable.selector_btn_home_find, R.drawable.selector_btn_home_xingcheng,
				R.drawable.selector_btn_home_mytc };
		return images;
	}

	// 获得切换的fragemnt
	@SuppressWarnings("rawtypes")
	public static Class[] getFragments()
	{
		Class[] clas =
		{ HomeFragment.class, 
				DestinationFragment.class,
				FindFragment.class, 
				XingChengFragment.class, 
				MyTongChengFragment.class };
		return clas;
	}

}
