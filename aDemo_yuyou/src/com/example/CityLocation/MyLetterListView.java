package com.example.CityLocation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyLetterListView extends View
{

	private static final int ALL_LETTER = 30;
	OnTouchingLetterChangedListener onTouchingLetterChangedListener;
	String[] indexList =
	{ "定位", "最近", "热门", "全部", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
			"S", "T", "U", "V", "W", "X", "Y", "Z" };
	int choose = -1;
	Paint paint = new Paint();
	boolean isPressed = false;

	public MyLetterListView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
	}

	public MyLetterListView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public MyLetterListView(Context context)
	{
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		if (isPressed)
		{// 背景颜色改变
			canvas.drawColor(Color.parseColor("#40000000"));
		} else
		{ // 背景颜色恢复
			canvas.drawColor(Color.TRANSPARENT);
		}
		int height = getHeight();  // 获得当前控件的高度
		int width = getWidth();
		// int singleHeight = height / b.length;
		int singleHeight = height / ALL_LETTER;// 固定值 可以让居上显示
		for (int i = 0; i < indexList.length; i++)
		{
			paint.setColor(Color.parseColor("#32b9aa"));
			if (indexList[i].length() > 1)
			{
				paint.setTextSize(16);

			} else
			{
				paint.setTextSize(22);
			}
			// paint.setTypeface(Typeface.DEFAULT_BOLD);
			paint.setAntiAlias(true);
			/*
			 * if (i == choose) { paint.setColor(Color.parseColor("#3399ff"));
			 * paint.setFakeBoldText(true); }
			 */
			float xPos = width / 2 - paint.measureText(indexList[i]) / 2;
			float yPos = singleHeight * i + singleHeight;
			canvas.drawText(indexList[i], xPos, yPos, paint);
			paint.reset();
		}
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event)
	{
		final int action = event.getAction();
		final float y = event.getY(); // 用MotionEvent对象去获取X\Y轴的坐标
		final int oldChoose = choose;
		final OnTouchingLetterChangedListener listener = onTouchingLetterChangedListener;
		final int c = (int) (y / getHeight() * indexList.length);
		switch (action)
		{
		case MotionEvent.ACTION_DOWN: // 按下
			isPressed = true;
			if (oldChoose != c && listener != null)
			{
				if (c >= 0 && c < indexList.length)
				{
					listener.onTouchingLetterChanged(indexList[c]);
					choose = c;
				}
			}
			break;
		case MotionEvent.ACTION_MOVE: // 移动
			if (oldChoose != c && listener != null)
			{
				if (c >= 0 && c < indexList.length)
				{
					listener.onTouchingLetterChanged(indexList[c]);
					choose = c;
				}
			}
			break;
		case MotionEvent.ACTION_UP: // 抬起
			isPressed = false;
			choose = -1;
			break;
		}
		invalidate(); // 重绘 // return super.onTouchEvent(event);
		return true;// 要修改为true 否者报错
	}

	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		return super.onTouchEvent(event);
	}

	public void setOnTouchingLetterChangedListener(OnTouchingLetterChangedListener onTouchingLetterChangedListener)
	{
		this.onTouchingLetterChangedListener = onTouchingLetterChangedListener;
	}

	public interface OnTouchingLetterChangedListener
	{
		public void onTouchingLetterChanged(String s);
	}
}
