package com.example.utils;

import com.xinbo.utils.HTTPUtils;
import com.xinbo.utils.VolleyListener;

import android.content.Context;

public class APIClient
{
//	private static final String[] mURL = new String[]
//		{ TKConstants.Url.HOT, 
//			TKConstants.Url.TUIJIAN, 
//			TKConstants.Url.KEJI,
//			TKConstants.Url.CHUANGYE,
//			TKConstants.Url.SHUMA, 
//			TKConstants.Url.JISHU, 
//			TKConstants.Url.SHEJI, 
//			TKConstants.Url.YINGXIAO 
//		};

/*	// 根据position参数不同 请求不同网址的方法--->复用
	public static void getHomeData(Context context, int position, VolleyListener listener)
	{
		HTTPUtils.get(context, mURL[position], listener);
	}*/

	// 目的地1
	public static void getMDD1(Context context, VolleyListener listener)
	{
		HTTPUtils.get(context, Constants.Url.DESTINATION1, listener);
	}
	// 目的地2
	public static void getMDD2(Context context, VolleyListener listener)
	{
		HTTPUtils.get(context, Constants.Url.DESTINATION2, listener);
	}
	
	//发现
	public static void getFind(Context context, VolleyListener listener)
	{
		HTTPUtils.get(context, Constants.Url.FIND, listener);
	}
	
	//行程
	public static void getXingCheng(Context context, VolleyListener listener)
	{
		HTTPUtils.get(context, Constants.Url.XINGCHENG, listener);
	}


}
