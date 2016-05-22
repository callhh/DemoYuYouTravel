package com.example.sample.fragment;

import java.util.List;

import com.example.model.header1.ItemList;
import com.example.sample.HomeSecondVPagerActivity;
import com.example.sample.R;
import com.example.utils.Constants;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.xinbo.utils.UILUtils;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class HomeSecondPagerFragment extends Fragment
{

	// private int position;
	/*
	 * int [] layoutID =
	 * {R.layout.home_second_banner1,R.layout.home_second_banner2,R.layout.
	 * home_second_banner3};
	 */

	private static final int GRID_COUNT = 8;
	private LayoutInflater inflater;
	private int pageNum;
	private List<ItemList> mSecondBannerItemList;
	public ImageLoader imageLoader = ImageLoader.getInstance();
	private View layout;

	public HomeSecondPagerFragment()
	{
	}
	public HomeSecondPagerFragment(int position, List<ItemList> mSecondBannerItemList)
	{
		this.pageNum = position;
		this.mSecondBannerItemList = mSecondBannerItemList;
	}


	@SuppressLint("NewApi")
	@Override
	public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
			initUI(inflater, container);
		return layout;
	}

	private void initUI(LayoutInflater inflater, ViewGroup container)
	{
		this.inflater = inflater;
		layout = inflater.inflate(R.layout.fragment_home_second_pager, container, false);
		initGridView(inflater);
	}

	private void initGridView(LayoutInflater inflater)
	{
		GridView mGridView = (GridView) layout.findViewById(R.id.gridView1);
		mGridView.setNumColumns(4);
		mGridView.setAdapter(new HomeSecondPagerGridAdapter(inflater));
		mGridView.setOnItemClickListener(new gridViewItemClickListener());
	}

	private final class gridViewItemClickListener implements OnItemClickListener
	{
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id)
		{
			// TODO 
			Intent intent = new Intent(getActivity(), HomeSecondVPagerActivity.class);
			intent.putExtra(Constants.IntentKey.HOMESECOND_PAGER_POSITION_URL, mSecondBannerItemList.get(position).getRedirectUrl());
			intent.putExtra(Constants.IntentKey.HOMESECOND_PAGER_TITLE, mSecondBannerItemList.get(position).getTitle());
			startActivity(intent);
		}
	}

	// 首页第二个ViewPager的gridview适配器
	@SuppressLint("ViewHolder")
	private final class HomeSecondPagerGridAdapter extends BaseAdapter
	{
		private final LayoutInflater inflater;

		private HomeSecondPagerGridAdapter(LayoutInflater inflater)
		{
			this.inflater = inflater;
		}

		@SuppressLint("InflateParams")
		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			int realPos = pageNum * GRID_COUNT + position;
			ItemList itemData = mSecondBannerItemList.get(realPos);
			View itemlayout = inflater.inflate(R.layout.grid_item_home_header1_pager2, null);

			ImageView imgType = (ImageView) itemlayout.findViewById(R.id.img_type);
			// 图片异步下载 缓存库类
			UILUtils.displayImage(itemData.getIconUrl(), imgType);
			TextView tvType = (TextView) itemlayout.findViewById(R.id.tv_type);
			tvType.setText(itemData.getTitle());
			return itemlayout;
		}

		@Override
		public long getItemId(int position)
		{
			return 0;
		}

		@Override
		public Object getItem(int position)
		{
			return null;
		}

		@Override
		public int getCount()
		{
			// 3个片段，第一和第二个各8个主题，第三个1个主题
			int size = mSecondBannerItemList.size();
			if (size > GRID_COUNT * (pageNum + 1))
			{
				return GRID_COUNT; // grid内容总数
			} else
			{
				return size % (GRID_COUNT * pageNum);
			}
		}
	}

}
