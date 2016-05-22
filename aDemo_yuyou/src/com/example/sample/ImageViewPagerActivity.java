package com.example.sample;

import java.util.ArrayList;

import com.example.sample.widget.HackyViewPager;
import com.xinbo.utils.UILUtils;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class ImageViewPagerActivity extends Activity
{

	private static ArrayList<String> arrayList = new ArrayList<String>();
	
	private com.example.sample.widget.HackyViewPager mViewPager;
	private static int[] photoes =
	{ R.drawable.ic_detail_zhutu, R.drawable.ic_detail_photoview2, R.drawable.ic_detail_photoview3,
			R.drawable.ic_detail_photoview4 };
	private TextView indicator;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_view_pager);
		
		// HackyViewPager 继承于viewpager 可以和photoView一起使用,实现相册图片的左右滑动,放大缩小
		mViewPager = (HackyViewPager) findViewById(R.id.hackyViewPager1);
		SamplePagerAdapter adapter = new SamplePagerAdapter();
		mViewPager.setAdapter(adapter);
		indicator = (TextView) findViewById(R.id.tv_indicator);

		// 设置图片序号
		indicator.setText(1 + "/" + photoes.length);

		adapter.notifyDataSetChanged();
		// viewpager滑动监听
		mViewPager.setOnPageChangeListener(new OnPageChangeListener()
		{

			@Override
			public void onPageSelected(int arg0)
			{

			}

			@Override
			public void onPageScrolled(int position, float arg1, int arg2)
			{
				indicator.setText(position + 1 + "/" + photoes.length);
			}

			@Override
			public void onPageScrollStateChanged(int arg0)
			{

			}
		});
	}

	class SamplePagerAdapter extends PagerAdapter
	{

		@Override
		public int getCount()
		{
			return photoes.length;
		}

		@Override
		public View instantiateItem(ViewGroup container, int position)
		{
			PhotoView photoView = new PhotoView(container.getContext());
			// UILUtils.displayImage(arrayList.get(position), photoView);
			
			photoView.setImageResource(photoes[position]);
			container.addView(photoView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			// Log.e("position:", "" + position);

			// 用户单击的时候 退出浏览器
			photoView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener()
			{
				@Override
				public void onPhotoTap(View view, float x, float y)
				{
					finish();
				}
			});

			return photoView;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object)
		{
			container.removeView((View) object);
		}

		@Override
		public boolean isViewFromObject(View view, Object object)
		{
			return view == object;
		}
	}

	private boolean isViewPagerActive()
	{
		return (mViewPager != null && mViewPager instanceof HackyViewPager);
	}

	@Override
	protected void onSaveInstanceState(@NonNull Bundle outState)
	{
		super.onSaveInstanceState(outState);
	}
}
