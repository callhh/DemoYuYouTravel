package com.example.CityLocation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper
{
	// 类没有实例化,是不能用作父类构造器的参数,必须声明为静态
	private static final String name = "city"; // 数据库名称
	private static final int version = 1; // 数据库版本

	public DatabaseHelper(Context context)
	{
		super(context, name, null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		Log.e("info", "create table");
		// 创建数据库中 表格语句
		// name 字段名 ；VARCHAR 字段类型
		// 数据库name phone 又增加了int类型的imageID
		// 数据库语句：CREATE TABLE 表名 (id INTEGER PRIMARY KEY AUTOINCREMENT,name
		// VARCHAR(20),phone VARCHAR(20))

		// 执行数据库语句
		db.execSQL(
				"CREATE TABLE IF NOT EXISTS recentcity (id integer primary key autoincrement, name varchar(40), date INTEGER)");
	}

	// 版本更新时调用
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
	}
}
