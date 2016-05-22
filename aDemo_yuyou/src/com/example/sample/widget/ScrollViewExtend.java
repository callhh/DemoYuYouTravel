package com.example.sample.widget;
//widget组件包
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

// 设计者  创建一个类继承ScrollView  
// 重写2个以上的构造方法	; 
// 创建监听机制三步  1）创建一个接口	2）创建接口类型的成员变量	3）创建注册监听事件的方法
public class ScrollViewExtend extends ScrollView
{

	private OnScrollChangeListener mListener; // 2）创建接口类型的成员变量

	public ScrollViewExtend(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}
	
	//1）创建一个接口
	public interface OnScrollChangeListener{
		// 改变滚动条方法
		public void onScrollChange(int scrollX, int scrollY, int oldScrollX, int oldScrollY);

	}
	
	// 3）创建注册监听事件的方法
	public void setOnScrollChangeListener(OnScrollChangeListener l)
	{
		mListener = l;
	}
	
		
	// 3) 在某个时机下，调用接口对象的方法，发出事件通知
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt)
	{
		// 当事件发生时  通知接口实现的子类
		super.onScrollChanged(l, t, oldl, oldt);
		if (mListener != null)
		{
			mListener.onScrollChange(l, t, oldl, oldt);
		}
	}
	
}
