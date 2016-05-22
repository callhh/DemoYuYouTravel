package com.example.sample.fragment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.android.volley.VolleyError;
import com.example.model.faxian.Body;
import com.example.model.faxian.CommunityCenterList;
import com.example.model.faxian.Faxian;
import com.example.model.faxian.FreshPlayWayList;
import com.example.model.faxian.HotDestinationList;
import com.example.model.faxian.HotSaleList;
import com.example.model.faxian.ModuleContentList;
import com.example.model.faxian.ModuleContentList_;
import com.example.model.faxian.ModuleContentList__;
import com.example.model.faxian.ModuleContentList___;
import com.example.model.faxian.ModuleContentList____;
import com.example.model.faxian.ModuleContentList______;
import com.example.model.faxian.NearbyDestinationList;
import com.example.model.faxian.RecommendList;
import com.example.model.faxian.Response;
import com.example.model.faxian.ThemeList;
import com.example.sample.DestinationHotCtiyActivity;
import com.example.sample.HomeNearByActivity;
import com.example.sample.HomeSuperPlayerActivity;
import com.example.sample.HomeTenYuanTravelActivity;
import com.example.sample.R;
import com.example.sample.WeiSheQuActivity;
import com.example.sample.library.FindViewPagerindicator;
import com.example.utils.APIClient;
import com.example.utils.ImageLoadUtils;
import com.umeng.analytics.MobclickAgent;
import com.xinbo.utils.BitmapUtils;
import com.xinbo.utils.GsonUtils;
import com.xinbo.utils.VolleyListener;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 *
 */
@SuppressLint("InflateParams")
public class FindFragment extends Fragment implements OnClickListener {

	private View layout;
	private LayoutInflater inflater;
	private static final String FILE_PATH = Environment.getExternalStorageDirectory() + "/tongcheng/cache/";
	private ArrayList<ModuleContentList> module2 = new ArrayList<ModuleContentList>();
	private ArrayList<ModuleContentList_> module = new ArrayList<ModuleContentList_>();
	private ArrayList<ModuleContentList__> module1 = new ArrayList<ModuleContentList__>();
	private ArrayList<ModuleContentList___> module3 = new ArrayList<ModuleContentList___>();
	private ArrayList<ModuleContentList____> module4 = new ArrayList<ModuleContentList____>();
	private ArrayList<ModuleContentList______> module5 = new ArrayList<ModuleContentList______>();
	private ArrayList<ThemeList> themelist = new ArrayList<ThemeList>();
	private RankingGridView myGridView;
	private BaseAdapter adapter;
	private BaseAdapter myboutique;
	private BaseAdapter myBenDi;
	private BaseAdapter myZHoub;
	private BaseAdapter myShequ;
	private ViewPager mpager;
	private boolean isDragging;
	private static final int MAX_LENG = 66666;
	private int positionfirstbanner;
	private FindViewPagerindicator mIndicator;
	public FindFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (layout==null) {
			this.inflater = inflater;
			layout = inflater.inflate(R.layout.fragment_find, container, false);
			initUI();
			initData();
		}
		return layout;
	}
	
	private void initData() {
		
		APIClient.getFind(getContext(), new VolleyListener() {
			@Override
			public void onResponse(String arg0) {
				Faxian faxian = GsonUtils.parseJSON(arg0, Faxian.class);
				Response response = faxian.getResponse();
				Body body = response.getBody();
				HotSaleList hotSaleList = body.getHotSaleList();
				HotDestinationList hotDestinationList = body.getHotDestinationList();
				FreshPlayWayList freshPlayWayList = body.getFreshPlayWayList();
				RecommendList recommendList = body.getRecommendList();
				CommunityCenterList communityCenterList = body.getCommunityCenterList();
				List<ThemeList> themeList = body.getThemeList();
				List<ModuleContentList______> moduleContentList5 = communityCenterList.getModuleContentList();
				NearbyDestinationList nearbyDestinationList = body.getNearbyDestinationList();
				List<ModuleContentList____> moduleContentList4 = nearbyDestinationList.getModuleContentList();
				List<ModuleContentList___> moduleContentList3 = hotDestinationList.getModuleContentList();
				List<ModuleContentList> moduleContentList2 = recommendList.getModuleContentList();
				List<ModuleContentList__> moduleContentList = freshPlayWayList.getModuleContentList();
				List<ModuleContentList_> mcl = hotSaleList.getModuleContentList();
				themelist.clear();
				themelist.addAll(themeList);
				
				FragmentManager fm = getChildFragmentManager();
				mpager.setAdapter(new TypePagerAdapter(fm));
				module.addAll(mcl);
				module1.addAll(moduleContentList);
				module2.addAll(moduleContentList2);
				module3.addAll(moduleContentList3);
				module4.addAll(moduleContentList4);
				module5.addAll(moduleContentList5);
				
				adapter.notifyDataSetChanged();
				myGridView.notifyDataSetChanged();
				myboutique.notifyDataSetChanged();
				myBenDi.notifyDataSetChanged();
				myZHoub.notifyDataSetChanged();
				myShequ.notifyDataSetChanged();
			}
			@Override
			public void onErrorResponse(VolleyError arg0) {
				Log.e("onError", "Error = "+arg0.getMessage());
			}
		});
	}

	@SuppressLint("InflateParams")
	private void initUI() {
		ListView mListview = (ListView) layout.findViewById(R.id.listView1);
		View find_banner = inflater.inflate(R.layout.find_banner, null);
		
		mIndicator = (FindViewPagerindicator) find_banner.findViewById(R.id.viewPagerindicator1);
		mIndicator.setRealNum(2);
		mpager = (ViewPager) find_banner.findViewById(R.id.pager2);
		mpager.addOnPageChangeListener(new MyMpagerOncList1());
		mpager.setCurrentItem(MAX_LENG /2);
		RelativeLayout mFindXieMen = (RelativeLayout) find_banner.findViewById(R.id.layout_find_search_xiamen);
		mFindXieMen.setOnClickListener(this); //查看厦门攻略
		
		View hot = ReMen();//热门
		View mranking = PaiHangBang();//排行榜
		View boutique = JingPin();//精品推荐
		View local = BenDi();//本地
		View periphery = ZhouBian();//周边
		View community = SheQu();//游友社区
		MyAdpatr myAdpatr = new MyAdpatr();
		
		mListview.addHeaderView(find_banner);
		mListview.addHeaderView(mranking);
		mListview.addHeaderView(hot);
		mListview.addHeaderView(boutique);
		mListview.addHeaderView(local);
		mListview.addHeaderView(periphery);
		mListview.addHeaderView(community);
		mListview.setAdapter(myAdpatr);
		autoScroll();
	}

	// 游友社区数据
	private View SheQu() {
		View community = inflater.inflate(R.layout.find_community, null);
		GridView mCommunityGridView = (GridView) community.findViewById(R.id.community_gew1);
		myShequ = new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View commLayout = inflater.inflate(R.layout.find_community_griditem, null);
				ImageView comm_picurl = (ImageView) commLayout.findViewById(R.id.comm_picurl);
				TextView comm_Title = (TextView) commLayout.findViewById(R.id.comm_Title);
				ModuleContentList______ mocs5 = module5.get(position);
				comm_Title.setText(mocs5.getTitle());
				//解决OOM
//				new ImgTask(comm_picurl).execute(mocs5.getPicUrl());
				ImageLoadUtils.displayImage(getContext(), mocs5.getPicUrl(), comm_picurl);
				
				return commLayout;
			}
			
			@Override
			public long getItemId(int position) {
				return 0;
			}
			
			@Override
			public Object getItem(int position) {
				return null;
			}
			
			@Override
			public int getCount() {
				return module5.size();
			}
		};
		
		mCommunityGridView.setAdapter(myShequ);
		mCommunityGridView.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), WeiSheQuActivity.class));
			}
		});
		return community;
	}

	// 周边目的地
	private View ZhouBian() {
		View mNearbyLayout = inflater.inflate(R.layout.find_nearby, null);
		GridView mGridvNearby = (GridView) mNearbyLayout.findViewById(R.id.gridv_find_nearby);
		myZHoub = new BaseAdapter() {
			
			@SuppressLint("ViewHolder")
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View perLayout = inflater.inflate(R.layout.find_nearby_girditem, null);
				ImageView periphery_picurl = (ImageView) perLayout.findViewById(R.id.periphery_picurl);
				TextView periphery_Title = (TextView) perLayout.findViewById(R.id.periphery_Title);
				TextView periphery_subTitle = (TextView) perLayout.findViewById(R.id.periphery_subTitle);
				
				ModuleContentList____ mcl4 = module4.get(position);
				periphery_Title.setText(mcl4.getTitle());
				periphery_subTitle.setText(mcl4.getSubTitle());
				
				//图片异步下载 缓存
//				new ImgTask(periphery_picurl).execute(mcl4.getPicUrl()); //解决OOM
				ImageLoadUtils.displayImage(getContext(), mcl4.getPicUrl(), periphery_picurl);
				return perLayout;
			}
			
			@Override
			public long getItemId(int position) {
				return 0;
			}
			
			@Override
			public Object getItem(int position) {
				return null;
			}
			
			@Override
			public int getCount() {
				return module4.size();
			}
		};
		mGridvNearby.setAdapter(myZHoub);
		mGridvNearby.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), HomeNearByActivity.class));
			}
		});
		return mNearbyLayout;
	}

	// 本地人
	private View BenDi() {
		View layoutLocalMan = inflater.inflate(R.layout.find_local_man, null);
		GridView mGridvLocalMan = (GridView) layoutLocalMan.findViewById(R.id.gridv_find_local_man);
		myBenDi = new BaseAdapter() {
			
			@Override
			public int getCount() {
				return module3.size();
			}
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View localLayout = inflater.inflate(R.layout.find_local_man_griditem, null);
				ImageView local_picurl = (ImageView) localLayout.findViewById(R.id.local_picurl);
				TextView locanl_Title = (TextView) localLayout.findViewById(R.id.locanl_Title);
				TextView local_subTitle = (TextView) localLayout.findViewById(R.id.local_subTitle);
				ModuleContentList___ mouds = module3.get(position);
				locanl_Title.setText(mouds.getTitle());
				local_subTitle.setText(mouds.getSubTitle());
				//解决OOM
//				new ImgTask(local_picurl).execute(mouds.getPicUrl());
				ImageLoadUtils.displayImage(getContext(), mouds.getPicUrl(), local_picurl);
				return localLayout;
			}
			
			@Override
			public long getItemId(int position) {
				return 0;
			}
			
			@Override
			public Object getItem(int position) {
				return null;
			}
			
		};
		mGridvLocalMan.setAdapter(myBenDi);
		mGridvLocalMan.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), HomeSuperPlayerActivity.class));
			}
		});
		return layoutLocalMan;
	}

	private View JingPin() {
		View layoutJingXuan = inflater.inflate(R.layout.find_jingxuan, null);
		ListView mListvJingXuan = (ListView) layoutJingXuan.findViewById(R.id.listv_find_jingxuan);
		myboutique = new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View boutlayouts = inflater.inflate(R.layout.find_jingxuan_listitem, null);
				ImageView bou_picurl = (ImageView) boutlayouts.findViewById(R.id.bou_picurl);
				TextView bou_Title = (TextView) boutlayouts.findViewById(R.id.bou_Title);
				TextView bou_subTitle = (TextView) boutlayouts.findViewById(R.id.bou_subTitle);
				TextView amount = (TextView) boutlayouts.findViewById(R.id.amount);
				ModuleContentList mclis = module2.get(position);
				bou_Title.setText(mclis.getTitle());
				bou_subTitle.setText(mclis.getSubTitle());
				amount.setText(mclis.getAmount());
				//解决OOM
//				new ImgTask(bou_picurl).execute( mclis.getPicUrl());
				ImageLoadUtils.displayImage(getContext(), mclis.getPicUrl(), bou_picurl);
				return boutlayouts;
			}
			
			@Override
			public long getItemId(int position) {
				return 0;
			}
			
			@Override
			public Object getItem(int position) {
				return null;
			}
			
			@Override
			public int getCount() {
				return module2.size();
			}
		};
		mListvJingXuan.setAdapter(myboutique);
		mListvJingXuan.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), HomeTenYuanTravelActivity.class));
			}
		});
		return layoutJingXuan;
	}


	// 热门
	private View ReMen() {
		View layoutHot = inflater.inflate(R.layout.find_hot, null);
		ListView mListViewHot = (ListView) layoutHot.findViewById(R.id.listview_find_hot);
		adapter = new BaseAdapter() {
			
			@Override
			public int getCount() {
				return module1.size();
			}
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View hotlayout = inflater.inflate(R.layout.find_hot_listitem, null);
				TextView Title = (TextView) hotlayout.findViewById(R.id.Title);
				TextView subTitle = (TextView) hotlayout.findViewById(R.id.subTitle);
				ImageView Pic_urlk = (ImageView) hotlayout.findViewById(R.id.Pic_urlk);
				Title.setText(module1.get(position).getTitle());
				subTitle.setText(module1.get(position).getSubTitle());
				//解决OOM
//				new ImgTask(Pic_urlk).execute(module1.get(position).getPicUrl());
				ImageLoadUtils.displayImage(getContext(), module1.get(position).getPicUrl(), Pic_urlk);
				return hotlayout;
			}
			
			@Override
			public long getItemId(int position) {
				return 0;
			}
			
			@Override
			public Object getItem(int position) {
				return null;
			}
		
		};
		
		mListViewHot.setAdapter(adapter);
		mListViewHot.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), HomeTenYuanTravelActivity.class));
			}
		});
		return layoutHot;
	}
	

	// 排行榜
	private View PaiHangBang() {
		View mranking = inflater.inflate(R.layout.find_ranking, null);
		GridView mGridvRanking = (GridView) mranking.findViewById(R.id.gridv_find_ranking);
		myGridView = new RankingGridView();
		mGridvRanking.setAdapter(myGridView);
		mGridvRanking.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), HomeTenYuanTravelActivity.class));
			}
		});
		return mranking;
	}
	
	//排行榜GridView适配器
	class RankingGridView extends BaseAdapter
	{
		@Override
		public int getCount() {
			return module.size();
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@SuppressLint("ViewHolder")
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View giewView = inflater.inflate(R.layout.find_ranking_griditem, null);
			TextView mTitle = (TextView) giewView.findViewById(R.id.Title);
			ImageView Pic_url = (ImageView) giewView.findViewById(R.id.Pic_url);
			ModuleContentList_ moduleContentList_ = module.get(position);
			mTitle.setText(moduleContentList_.getTitle());
			//解决OOM
//			new ImgTask(Pic_url).execute(moduleContentList_.getPicUrl());
			ImageLoadUtils.displayImage(getContext(), moduleContentList_.getPicUrl(), Pic_url);
			return giewView;
		}
	}
	
	
	class MyAdpatr extends BaseAdapter
	{

		@Override
		public int getCount() {
			return 0;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View layouts = inflater.inflate(R.layout.txt_list, null);
			return layouts;
		}
		
	}
	
	// Pager指示器的监听事件
	private final class MyMpagerOncList1 implements OnPageChangeListener {
		
		
		@Override
		public void onPageSelected(int arg0) {
		}

		@Override
		public void onPageScrolled(int position, float positionOffset, int arg2) {
			position%=2;
			mIndicator.move(position, positionOffset);
		}
		@Override
		public void onPageScrollStateChanged(int state) {
			switch (state) {
			case ViewPager.SCROLL_STATE_DRAGGING:
//				Log.e("onPageScrollStateChanged", "用户拖拽");
				isDragging=true;
				break;
			case ViewPager.SCROLL_STATE_SETTLING:
//				Log.e("onPageScrollStateChanged", "复位");
				isDragging=false;
				break;
			case ViewPager.SCROLL_STATE_IDLE:
//				Log.e("onPageScrollStateChanged", "空闲");
				isDragging=false;
				break;
			default:
				break;
			}
		}
	}
	// Banner片段跳转
	private final class TypePagerAdapter extends FragmentPagerAdapter {
		private TypePagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public int getCount() {
			return MAX_LENG;
		}

		@Override
		public Fragment getItem(int position) {
			positionfirstbanner = position;
			return new FindBannerFragment(position,themelist);
		}
	}
	private void autoScroll() {
		  //自动滑动
	mpager.postDelayed(new Runnable() {
		//定时5秒自动滑动到下一页
		@Override
		public void run() {
			//定时任务一直继续
			mpager.postDelayed(this,3000);
			//如果不是手动则自动滑动
			if (!isDragging) {
				int currentItem = mpager.getCurrentItem();
				int nextItem = currentItem+1;
				mpager.setCurrentItem(nextItem);
			}
		}
	}, 3000);
}
	
	class ImgTask extends AsyncTask<String, Void, Bitmap> {
		private ImageView imageView;

		public ImgTask(ImageView imageView) {
			this.imageView = imageView;
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			imageView.setImageBitmap(result);
		}
		
		@Override
		protected Bitmap doInBackground(String... params) {
			Bitmap bitmap = download(params);
			return bitmap;
		}

		private Bitmap download(String... params) {
			FileOutputStream fos = null;
			InputStream is = null;
			try {
				URL url = new URL(params[0]);
				is = url.openStream();
				String filename = FILE_PATH + "aaa.jpg";
				File file = new File(filename);
				if (!file.exists()){
					file.getParentFile().mkdirs();
				}
				fos = new FileOutputStream(filename);
				byte[] buffer = new byte[1024];
				int len;
				while (-1 != (len = is.read(buffer))) {
					fos.write(buffer, 0, len);
				}
				Bitmap compressBmp = BitmapUtils.compressImageFromFile(filename);
				return compressBmp;
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally{
				if (is != null){
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (fos != null){
					try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return null;
		}

	}
	@Override
	public void onResume() {
		super.onResume();
		MobclickAgent.onResume(getContext());
	}
	@Override
	public void onPause() {
		super.onPause();
		MobclickAgent.onPause(getContext());
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id)
		{
		case R.id.layout_find_search_xiamen:
			startActivity(new Intent(getActivity(), DestinationHotCtiyActivity.class));
			break;

		default:
			break;
		}
		
	}

}
