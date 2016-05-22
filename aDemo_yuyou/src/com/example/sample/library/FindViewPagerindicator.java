package com.example.sample.library;

import com.example.utils.ScreenUtils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class FindViewPagerindicator extends View
{

	private Paint mPaint;
	private Paint mPaint2;
	private Paint mPaint3;
	private float cx = 60;
	private float cy = 9;
	private float radius = 6;
	private float mOffset; // 位移
	private int num = 3;

	public FindViewPagerindicator(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		Indicator();
	}

	private void Indicator()
	{
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setColor(Color.parseColor("#fb5802")); // 外层覆盖颜色：橙色

		mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint2.setColor(Color.LTGRAY);

		mPaint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint3.setColor(Color.WHITE);
		mPaint3.setStyle(Style.STROKE); // 画笔设置空心
		mPaint3.setStrokeWidth(3); // 宽度
	}

	public void move(int postion, float percent)
	{
		mOffset = percent * 3 * radius + postion * 3 * radius;
		if (postion == num - 1)
		{
			// 当滑动到最后一个圆时，不再向右滑
			mOffset = postion * 3 * radius;
		}
		// 重绘
		invalidate();
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		// 居中 公式： screenwidth /2 - (count - 1) radius * 1.5
		int screenwidth = ScreenUtils.getScreenWidth(getContext());
		cx = (float) (screenwidth / 2.7 - (num - 1) * 1.5 * radius);
		// 绘制圆形
		for (int i = 0; i < num; i++)
		{
			canvas.drawCircle(cx + i * 3 * radius, cy, radius, mPaint2);
			canvas.drawCircle(cx + i * 3 * radius, cy, radius, mPaint3);
		}
		canvas.drawCircle(cx + mOffset, cy, radius, mPaint);
	}

	public void setRealNum(int num)
	{
		this.num = num;
	}
}
