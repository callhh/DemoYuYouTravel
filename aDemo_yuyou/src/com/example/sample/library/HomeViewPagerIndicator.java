package com.example.sample.library;


import com.example.utils.ScreenUtils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

public class HomeViewPagerIndicator extends View
{

	private float cx = 210;
	private float cy = 20;
	private float radiusSize = 7; // 半径
	private int num = 5;
	private Paint mPaintfore;
	private Paint mPaint_bg;
	private Paint mPaintStroke;
	private float mOffset; //位移
	private ViewPager mPager;

	public HomeViewPagerIndicator(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		initPaint(); // 初始化画笔
	}

	private void initPaint()
	{
		mPaintfore = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaintfore.setColor(Color.RED);
		mPaint_bg = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint_bg.setColor(Color.WHITE); // 灰色背景

		mPaintStroke = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaintStroke.setColor(Color.BLUE); // 外环颜色 蓝
		mPaintStroke.setStyle(Style.STROKE); // 画笔设置空心
		mPaintStroke.setStrokeWidth(3); // 宽度
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		// 居中 公式： screenwidth /2 - (count - 1) radius * 1.5
		int screenwidth = ScreenUtils.getScreenWidth(getContext());
		cx = (float) (screenwidth / 2 - (num - 1) * 1.5 * radiusSize);
		
		for (int i = 0; i < num; i++)
		{
			canvas.drawCircle(cx + i * 3 * radiusSize, cy, radiusSize, mPaintStroke);
			canvas.drawCircle(cx + i * 3 * radiusSize, cy, radiusSize, mPaint_bg); // 画圆
		}
		canvas.drawCircle(cx + mOffset, cy, radiusSize, mPaintfore); // 画圆

	}

	public void move(int position, float percent)
	{
		mOffset = percent * 3 * radiusSize + position * 3 * radiusSize;
		if (position == num - 1)
		{
			// 当滑动到最后一个圆时 不再向右滑动
			mOffset = position * 3 * radiusSize;
		}
		invalidate();// 重绘
	}
	
	/**
	 * 如果pager不是无限循环，调用此方法
	 * @param mPager
	 */
	public void setViewPager(ViewPager mPager) {
		this.mPager = mPager;
		num = mPager.getAdapter().getCount();
	}

	/**
	 * 如果pager是无限循环，调用此方法
	 * @param num
	 */
	public void setRealNum(int num) {
		this.num  = num;
	}
	
}
