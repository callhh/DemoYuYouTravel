package com.example.sample.fragment;

import java.util.List;

import com.example.model.header1.ItemList;
import com.example.sample.HomeBannerActivity;
import com.example.sample.R;
import com.example.utils.Constants;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.xinbo.utils.UILUtils;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class HomeFirstPagerFragment extends Fragment
{
	// 设置第一个banner数据 写死
	// private int[] mImagRes = new
	// int[]{R.drawable.ic_home_viewpager1,R.drawable.ic_home_viewpager2,R.drawable.ic_home_viewpager3,R.drawable.ic_home_viewpager4,R.drawable.ic_home_viewpager5,R.drawable.ic_home_viewpager6};
	private int position;
	private List<ItemList> mFirstBannerItemList;
	public ImageLoader imageLoader = ImageLoader.getInstance();
	private ImageView mImageView;

	public HomeFirstPagerFragment()
	{
	}
	public HomeFirstPagerFragment(int position, List<ItemList> mFirstBannerItemList)
	{
		this.mFirstBannerItemList = mFirstBannerItemList;
		// Log.e("构造方法", "position =" + position);
		this.position = position;

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		imageLoader.init(ImageLoaderConfiguration.createDefault(getContext()));

		View layout = inflater.inflate(R.layout.fragment_home_first_pager, container, false);
		mImageView = (ImageView) layout.findViewById(R.id.img_home_banner1);
		position %= mFirstBannerItemList.size(); // 图片的数组长度 循环
		final ItemList itemData = mFirstBannerItemList.get(position);
		UILUtils.displayImage(itemData.getIconUrl(), mImageView);
		// mImageView.setImageResource(mImagRes[position]); // 写死

		mImageView.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// Log.e("onCreateView", "position: " + position);
				Intent intent = new Intent(getActivity(), HomeBannerActivity.class);
				intent.putExtra(Constants.IntentKey.BANNER_POSITION_URL, itemData.getRedirectUrl());
				startActivity(intent);
			}
		});
		return layout;
	}

}
