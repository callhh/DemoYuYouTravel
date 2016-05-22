package com.example.database.utils;

import android.content.Context;
import android.content.SharedPreferences;


public final class UtilsSharePerference
{
	public static void saveCity(Context context, String city)
	{
		SharedPreferences sp = context.getSharedPreferences("City",
				Context.MODE_PRIVATE);
		sp.edit().putString("city", city).commit();
	}

	public static String getCity(Context context)
	{
		SharedPreferences sp = context.getSharedPreferences("City",
				Context.MODE_PRIVATE);
		return sp.getString("city", "");
	}


}
