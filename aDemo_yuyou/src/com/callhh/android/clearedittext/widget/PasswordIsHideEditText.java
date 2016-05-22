package com.callhh.android.clearedittext.widget;

import com.example.sample.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;


/**
 * 自带清除按钮的输入框，清除按钮的作用是清空输入框的输入内容；
 * 需要注意的是，清除按钮会占据drawableRight的位置，所以设置drawableRight会无效
 * Created by liruchun on 2015/7/2.
 */
public class PasswordIsHideEditText extends EditText
{
	 /** 默认的清除按钮图标资源 */
    private static final int[] drawables = new int[]{R.drawable.icon_password_hide,R.drawable.icon_password_show};

    /** 清楚按钮的图标 */
    private Drawable drawableHidden;
    private Drawable drawableShow;
    private boolean isHidden;  // 保存密码的输入状态是否 可见或隐藏


    public PasswordIsHideEditText(Context context)
    {
        super(context);
        init(context, null);
    }

    public PasswordIsHideEditText(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context, attrs);
    }

    public PasswordIsHideEditText(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    // 自定义控件
    private void init(Context context, AttributeSet attrs)
    {
    	// 获取自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PasswordIsHideEditText);
     // 获取清除按钮图标资源
        int iconPsdHidden =
                typedArray.getResourceId(R.styleable.PasswordIsHideEditText_iconPsdHidden, drawables[0]);
        int iconPsdShow =
        		typedArray.getResourceId(R.styleable.PasswordIsHideEditText_iconPsdShow, drawables[1]);
        drawableHidden = getResources().getDrawable(iconPsdHidden);
        drawableShow = getResources().getDrawable(iconPsdShow);
        updateIconShow();
        typedArray.recycle();

     // 设置TextWatcher用于更新清除按钮显示状态
        addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
            	updateIconShow();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
//                updateIconClear();
            	
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
        	// 点击是的 x 坐标
            int xDown = (int) event.getX();
         // 清除按钮的起始区间大致为[getWidth() - getCompoundPaddingRight(), getWidth()]，
            // 点击的x坐标在此区间内则可判断为点击了清除按钮
            if (xDown >= (getWidth() - getCompoundPaddingRight()) && xDown < getWidth())
            {
            	if (isHidden) {
                    //设置EditText文本为可见的
       			 setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    //设置EditText文本为隐藏的
               	 setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
            isHidden = !isHidden;
            updateIconShow();
          //切换后将EditText光标置于末尾
            Editable text = getText();
			Selection.setSelection(text, text.length());
            
            invalidate(); // 重绘
            
        }
        return super.onTouchEvent(event);
    }

    
    private void updateIconShow()
	{
    	 Drawable[] drawables = getCompoundDrawables();
         if (isHidden) // TODO
         {
             setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], drawableShow,
                     drawables[3]);
         }
         else
         {
             setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], drawableHidden,
                     drawables[3]);
         }
	}

	/**
     * 更新清除按钮图标显示
     */
//    public void updateIconClear()
//    {
//    	 // 获取设置好的drawableLeft、drawableTop、drawableRight、drawableBottom
//        Drawable[] drawables = getCompoundDrawables();
//        if (length() > 0) //输入框有输入内容才显示删除按钮
//        {
//            setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], drawableHidden,
//                    drawables[3]);
//        }
//        else
//        {
//            setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], null,
//                    drawables[3]);
//        }
//    }

    /**
     * 设置清除按钮图标样式
     * @param resId 图标资源id
     */
    public void setIconClear(@DrawableRes int resId)
    {
    	drawableHidden = getResources().getDrawable(resId);
    	updateIconShow();
    }
}
