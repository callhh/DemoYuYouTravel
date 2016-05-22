package com.example.sample.fragment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.android.volley.VolleyError;
import com.example.model.mudidi1.Body;
import com.example.model.mudidi1.CategoryList;
import com.example.model.mudidi1.Mudidi1;
import com.example.model.mudidi1.Response;
import com.example.model.mudidi2.CellItem;
import com.example.model.mudidi2.GroupList;
import com.example.model.mudidi2.Mudidi2;
import com.example.sample.DestinationHotCtiyActivity;
import com.example.sample.R;
import com.example.sample.library.MDDViewPagerindicator;
import com.example.utils.APIClient;
import com.example.utils.ImageLoadUtils;
import com.umeng.analytics.MobclickAgent;
import com.xinbo.utils.BitmapUtils;
import com.xinbo.utils.GsonUtils;
import com.xinbo.utils.VolleyListener;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class DestinationFragment extends Fragment
{

	private View layout;
	private LayoutInflater inflater;
	private ArrayList<CategoryList> catelist1 = new ArrayList<CategoryList>();
	private ArrayList<GroupList> GroupLists = new ArrayList<GroupList>();
	private ViewPager mpager;
	private boolean isDragging;
	private MDDViewPagerindicator mIndicator1;
	private LeftAdapter leftadapter;
	private RightAdapter rightadapter;
	private final static int MAX_LENG = 400000;
	private static final String FILE_PATH = Environment.getExternalStorageDirectory() + "/tongcheng/cache/";
	// 注意：Fragment嵌套Fragment，必须使用childFragmentMananger
	// 不能使用getSupportFragmentManager()
//	private FragmentManager fm = getChildFragmentManager();
	private List<CellItem> cellItem2;
	public DestinationFragment()
	{
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		if (layout == null)
		{
			initUI(inflater, container);
			initData();
		}
		return layout;
	}

	@SuppressLint("InflateParams")
	private void initUI(LayoutInflater inflater, ViewGroup container)
	{
		this.inflater = inflater;
		layout = inflater.inflate(R.layout.fragment_destination, container, false);
		View mDestinaBanner1 = inflater.inflate(R.layout.destina_banner1, null);
//		FragmentManager fm = getChildFragmentManager();
		mIndicator1 = (MDDViewPagerindicator) mDestinaBanner1.findViewById(R.id.viewPagerindicator1);
		// 如果ViewPager是无限循环就调用setRealNum()方法设置指示器循环个数
		mIndicator1.setRealNum(3);

		mpager = (ViewPager) mDestinaBanner1.findViewById(R.id.pager2);
		mpager.setCurrentItem(MAX_LENG / 2);
		mpager.addOnPageChangeListener(new MyPagerOnClickListener1());

		ListView mListView1 = (ListView) layout.findViewById(R.id.listView1);
		ListView mListView2 = (ListView) layout.findViewById(R.id.listView2);
		mListView1.setTextFilterEnabled(true); //是否全屏
		// 设置listview的选中状态
		mListView1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		mListView1.setItemChecked(1, true);
		
		leftadapter = new LeftAdapter();
		rightadapter = new RightAdapter();
		// 为ListView添加HeaderView和FooterView 要在调用listview的setAdapter()之前
		mListView2.addHeaderView(mDestinaBanner1);
		mListView1.setAdapter(leftadapter);
		mListView2.setAdapter(rightadapter);
		mListView2.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				startActivity(new Intent(getContext(), DestinationHotCtiyActivity.class));
			}
		});
		autoScroll();
	}

	private void initData()
	{
		APIClient.getMDD1(getContext(), new VolleyListener()
		{
			@Override
			public void onResponse(String arg0)
			{
				Mudidi1 parseJSON = GsonUtils.parseJSON(arg0, Mudidi1.class);
				Response response = parseJSON.getResponse();
				Body body = response.getBody();
				List<CategoryList> categoryList = body.getCategoryList();
				catelist1.addAll(categoryList);
				leftadapter.notifyDataSetChanged();
			}

			@Override
			public void onErrorResponse(VolleyError arg0)
			{
				Log.e("onError", "Error = " + arg0.getMessage());
			}
		});
		// 解析目的地页面右边ListView数据
		APIClient.getMDD2(getContext(), new VolleyListener()
		{

			

			@Override
			public void onResponse(String arg0)
			{
				Mudidi2 parseJSON = GsonUtils.parseJSON(arg0, Mudidi2.class);
				com.example.model.mudidi2.Response response = parseJSON.getResponse();
				com.example.model.mudidi2.Body body = response.getBody();
				List<com.example.model.mudidi2.GroupList> groupList = body.getGroupList();

				cellItem2 = groupList.get(0).getCellItem();
				FragmentManager fm = getChildFragmentManager();
				mpager.setAdapter(new TypePagerAdapter(fm));
				
				GroupLists.addAll(groupList);
				rightadapter.notifyDataSetChanged(); // 通知适配器更新
			}

			@Override
			public void onErrorResponse(VolleyError arg0)
			{
				Log.e("onError", "Error = " + arg0.getMessage());
			}
		});
		
	}

	class LeftAdapter extends BaseAdapter
	{

		@Override
		public int getCount()
		{
			return catelist1.size();
		}

		@Override
		public Object getItem(int position)
		{
			return null;
		}

		@Override
		public long getItemId(int position)
		{
			return 0;
		}

		@SuppressLint(
		{ "ViewHolder", "ResourceAsColor", "InflateParams" })
		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			View layout = inflater.inflate(R.layout.destina_listitem1, null);
			View mlayoutR = layout.findViewById(R.id.layoutR);
			TextView mcateName = (TextView) layout.findViewById(R.id.cateName);
//			if (position == 0)
//			{
//				mlayoutR.setBackgroundResource(R.color.white);
//				mcateName.setTextColor(0xff228B22);
//			}else {
////				mlayoutR.setBackgroundResource(R.color.bg_destination_listitem);
////				mcateName.setTextColor(0xff333333);
//				
//			}
			CategoryList categoryList = catelist1.get(position);
			mcateName.setText(categoryList.getCategoryName());
			return layout;
		}

	}

	// 右边ListView适配器
	class RightAdapter extends BaseAdapter
	{
		@Override
		public int getCount()
		{
			return GroupLists.size() * 3;
		}

		@Override
		public Object getItem(int position)
		{
			return null;
		}

		@Override
		public long getItemId(int position)
		{
			return 0;
		}

		@Override
		public int getViewTypeCount()
		{
			return 3;
		}

		public int getItemViewType(int position)
		{
			GroupList groupList = GroupLists.get(position / 4 + 1);
			String groupName = groupList.getGroupName();
			if (position % 4 == 0)
			{
				return 0;
			} else if (groupName.equals("精品热销"))
			{
				return 2;
			} else
			{
				return 1;
			}
		};

		@SuppressLint("InflateParams")
		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			View layoutu = null;
			GroupList groupList = GroupLists.get(position / 4 + 1);
			String groupName2 = groupList.getGroupName();
			List<CellItem> cellItem = groupList.getCellItem();
			if (position % 4 == 0)
			{
				layoutu = inflater.inflate(R.layout.destina_listitem3, null);
				TextView groupName = (TextView) layoutu.findViewById(R.id.groupName);
				groupName.setText(GroupLists.get(position / 4 + 1).getGroupName());
			} else if (groupName2.equals("精品热销"))
			{
				layoutu = inflater.inflate(R.layout.destina_listitem4, null);
				TextView mcel_Title = (TextView) layoutu.findViewById(R.id.cel_Title);
				TextView msub_Title = (TextView) layoutu.findViewById(R.id.sub_Title);
				TextView mprice = (TextView) layoutu.findViewById(R.id.price);
				ImageView mcell_img = (ImageView) layoutu.findViewById(R.id.cell_img);
				mcel_Title.setText(cellItem.get(position % 4 - 1).getCellTitle());
				msub_Title.setText(cellItem.get(position % 4 - 1).getCellSubTitle());
				mprice.setText(cellItem.get(position % 4 - 1).getCellPrice());
				// 解决OOM
				// new ImgTask(mcell_img).execute(cellItem.get(position % 4 -
				// 1).getCellImage());
				ImageLoadUtils.displayImage(getContext(), cellItem.get(position % 4 - 1).getCellImage(), mcell_img);
			} else
			{
				layoutu = inflater.inflate(R.layout.destina_listitem2, null);
				TextView mcel_Title = (TextView) layoutu.findViewById(R.id.cel_Title);
				TextView mPretext = (TextView) layoutu.findViewById(R.id.Pretext);
				TextView mcel_Valu = (TextView) layoutu.findViewById(R.id.cel_Valu);
				TextView mcel_Pretext = (TextView) layoutu.findViewById(R.id.cel_Pretext);
				ImageView mprog_img = (ImageView) layoutu.findViewById(R.id.prog_img);
				ImageView mcell_img = (ImageView) layoutu.findViewById(R.id.cell_img);

				mcel_Title.setText(cellItem.get(position % 4 - 1).getCellTitle());
				mPretext.setText(cellItem.get(position % 4 - 1).getCellProgressPreText());
				mcel_Pretext.setText(cellItem.get(position % 4 - 1).getCellRankPreText());
				mcel_Valu.setText(cellItem.get(position % 4 - 1).getCellProgressValue());
				// 解决OOM
				// new ImgTask(mprog_img).execute(cellItem.get(position % 4 -
				// 1).getCellProgressImgUrl());
				// new ImgTask(mcell_img).execute(cellItem.get(position % 4 -
				// 1).getCellImage());
				ImageLoadUtils.displayImage(getContext(), cellItem.get(position % 4 - 1).getCellProgressImgUrl(),
						mprog_img);
				ImageLoadUtils.displayImage(getContext(), cellItem.get(position % 4 - 1).getCellImage(), mcell_img);
			}
			return layoutu;
		}

	}

	private final class TypePagerAdapter extends FragmentPagerAdapter
	{

		private TypePagerAdapter(FragmentManager fm)
		{
			super(fm);
		}

		@Override
		public int getCount()
		{
			return MAX_LENG;
		}

		@Override
		public Fragment getItem(int position)
		{
			// TODO Auto-generated method stub
			return new MDDFirstFragment(position, cellItem2);
		}
	}

	private final class MyPagerOnClickListener1 implements OnPageChangeListener
	{

		@Override
		public void onPageSelected(int arg0)
		{
		}

		@Override
		public void onPageScrolled(int position, float positionOffset, int arg2)
		{
			position %= 3;
			mIndicator1.move(position, positionOffset);
		}

		@Override
		public void onPageScrollStateChanged(int state)
		{
			switch (state)
			{
			case ViewPager.SCROLL_STATE_DRAGGING:
				// Log.e("onPageScrollStateChanged", "用户拖拽");
				isDragging = true;
				break;
			case ViewPager.SCROLL_STATE_SETTLING:
				// Log.e("onPageScrollStateChanged", "复位");
				isDragging = false;
				break;
			case ViewPager.SCROLL_STATE_IDLE:
				// Log.e("onPageScrollStateChanged", "空闲");
				isDragging = false;
				break;
			default:
				break;
			}
		}
	}

	private void autoScroll()
	{
		// 自动滑动
		mpager.postDelayed(new Runnable()
		{
			// 定时3秒自动滑动到下一页
			@Override
			public void run()
			{
				// 定时任务一直继续
				mpager.postDelayed(this, 4000);
				// 如果不是手动则自动滑动
				if (!isDragging)
				{
					int currentItem = mpager.getCurrentItem();
					int nextItem = currentItem + 1;
					mpager.setCurrentItem(nextItem);
				}
			}
		}, 3000);
	}

	// 图片异步下载 解决OOM 体验不好
	class ImgTask extends AsyncTask<String, Void, Bitmap>
	{
		private ImageView imageView;

		public ImgTask(ImageView imageView)
		{
			this.imageView = imageView;
		}

		@Override
		protected void onPostExecute(Bitmap result)
		{
			imageView.setImageBitmap(result);
		}

		@Override
		protected Bitmap doInBackground(String... params)
		{
			Bitmap bitmap = download(params);
			return bitmap;
		}

		private Bitmap download(String... params)
		{
			FileOutputStream fos = null;
			InputStream is = null;
			try
			{
				URL url = new URL(params[0]);
				is = url.openStream();
				String filename = FILE_PATH + "aaa.jpg";
				File file = new File(filename);
				if (!file.exists())
				{ // 判断是否有文件夹
					file.getParentFile().mkdirs();
				}
				fos = new FileOutputStream(filename);
				byte[] buffer = new byte[1024];
				int len;
				while (-1 != (len = is.read(buffer)))
				{
					fos.write(buffer, 0, len);
				}
				Bitmap compressBmp = BitmapUtils.compressImageFromFile(filename);
				return compressBmp;

			} catch (MalformedURLException e)
			{
				e.printStackTrace();
			} catch (IOException e)
			{
				e.printStackTrace();
			} finally
			{
				if (is != null)
				{
					try
					{
						is.close();
					} catch (IOException e)
					{
						e.printStackTrace();
					}
				}
				if (fos != null)
				{
					try
					{
						fos.close();
					} catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			}
			return null;
		}

	}

	@Override
	public void onResume()
	{
		super.onResume();
		MobclickAgent.onResume(getContext());
	}

	@Override
	public void onPause()
	{
		super.onPause();
		MobclickAgent.onPause(getContext());
	}

	@Override
	public void onDetach()
	{
		// TODO Auto-generated method stub
		super.onDetach();
	        try {  
	            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");  
	            childFragmentManager.setAccessible(true);  
	            childFragmentManager.set(this, null);  
	  
	        } catch (NoSuchFieldException e) {  
	            throw new RuntimeException(e);  
	        } catch (IllegalAccessException e) {  
	            throw new RuntimeException(e);  
	        }  
	}
	
}
