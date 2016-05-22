package com.example.sample.fragment;

import java.util.List;

import com.android.volley.VolleyError;
import com.example.database.utils.UtilsSharePerference;
import com.example.dingwei.CitiesActivity;
import com.example.model.header1.CellList;
import com.example.model.header1.HomeHeader1;
import com.example.model.header1.ItemList;
import com.example.model.header1.Layout;
import com.example.model.header2.HomeHeader2Kuailechangjia;
import com.example.model.header2.Label;
import com.example.model.header2.RecommendList;
import com.example.model.header2.SubMenuList;
import com.example.sample.DestinationHotCtiyActivity;
import com.example.sample.GlobalSearchesActivity;
import com.example.sample.HomeDetailActivity;
import com.example.sample.HomeMoviceTicketActivity;
import com.example.sample.HomeNearByActivity;
import com.example.sample.HomePanicBuyingActivity;
import com.example.sample.HomeSuperPlayerActivity;
import com.example.sample.HomeTenYuanTravelActivity;
import com.example.sample.HomeVisaActivity;
import com.example.sample.R;
import com.example.sample.library.HomeViewPagerIndicator;
import com.example.sample.library.HomeViewPagerIndicator2;
import com.example.utils.Constants;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.umeng.analytics.MobclickAgent;
import com.xinbo.utils.GsonUtils;
import com.xinbo.utils.HTTPUtils;
import com.xinbo.utils.UILUtils;
import com.xinbo.utils.VolleyListener;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
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
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.iwgang.countdownview.CountdownView;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class HomeFragment extends Fragment implements OnClickListener
{

	private View layout;
	private LayoutInflater mInflater;
	private ListView mHomeListView;

	private boolean isDragging; // 用户是否滑动
	private ViewPager mHomeTopPager;
	private ViewPager mHomeSecondPager;
	private static final int DILAY_MILLIS = 2500; // 轮播睡眠
	private static final int MAX_LENGTH = 400000; // 轮播无限
	private PullToRefreshListView mPtrListView; // 自定义 下拉刷新组件
	public boolean isPullDown; // 保存是否下拉的状态
	private View mHeaderView1;
	private GridView mOverlayCard2;
	private LinearLayout mOverlayCard1;
	private HomeViewPagerIndicator mIndicator1;
	private HomeViewPagerIndicator2 mIndicator2;
	private List<ItemList> mSecondBannerItemList;
	private List<ItemList> mFirstBannerItemList;
	private FragmentManager fm;
	private List<ItemList> mActivityThemeData; //主题活动版块的数据解析
	private TextView mTvActivityTheme1_title;
	private TextView mTvActivityTheme1_subTitle;
	private ImageView mImgActivityTheme1;
	private TextView mTvActivityTheme2_title;
	private TextView mTvActivityTheme2_subTitle;
	private ImageView mImgActivityTheme2;
	private TextView mTvActivityTheme3_title;
	private TextView mTvActivityTheme3_subTitle;
	private ImageView mImgActivityTheme3;
	private TextView mTvActivityTheme4_title;
	private TextView mTvActivityTheme4_subTitle;
	private ImageView mImgActivityTheme4;
	
	private List<SubMenuList> subMenuListLongHoliday; //快乐长假  子菜单列表数据
	private List<RecommendList> recommendListLongHoliday; // 首页Listview数据   快乐长假     推荐列表
	private TextView tvSubMenuTitle;
	private SubMenuList subMenuData;
	private GridView mGvLongHolidaySubtitle;
	private ListView menuList;
	private PhoneAdapter mPhoneAdapter;
	private String[] menu_title = { "在线客服", "国内用户", "海外用户" };
	private String[] menu_subtitle = { "及时高效，快速解决您的问题", "拨打4007-997-922，不收取长途费", "+86-512-82209000" };
	int[] menu_image= {R.drawable.icon_service_online,R.drawable.icon_service_common_message_rest,R.drawable.icon_service_greenphone};
	private LinearLayout mlayout_kl_longHoliday;
	private LinearLayout mlayout_kl_weeks;
	private LinearLayout mlayout_kl_shortTrip;
	private LinearLayout mOverlay1_kl_weeks;
	private LinearLayout mOverlay1_kl_shortTrip;
	private LinearLayout mOverlay1_kl_longHoliday;
	private MyReceiver receiver; // 广播接收
	private TextView mTvCtiy_LBS;
	private TextView mTvTop_Search;
	
	public HomeFragment()
	{
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{

		if (layout == null)
		{
			initUI(inflater, container);
			initDataHeader1();
			initDataHeader2();
		}
		return layout;
	}


	private void initDataHeader1()
	{
		HTTPUtils.get(getContext(), Constants.Url.HOME_HEADER1, new VolleyListener()
		{

			@Override
			public void onResponse(String arg0)
			{
				HomeHeader1 homeHeader1 = GsonUtils.parseJSON(arg0, HomeHeader1.class);
				List<Layout> layout2 = homeHeader1.getResponse().getBody().getLayout();
				List<CellList> cellList = layout2.get(0).getCellList();
				mFirstBannerItemList = cellList.get(0).getItemList();
				
				CellList cellType = cellList.get(1); //第二个banner数据
				mSecondBannerItemList = cellType.getItemList();
				
				mHomeTopPager.setAdapter(new BannerAdapter(fm));
				mHomeSecondPager.setAdapter(new SecondPagerAdapter(fm));
				
				CellList cellActivityTheme = cellList.get(6);
				mActivityThemeData = cellActivityTheme.getItemList();//主题活动版块的数据解析
				ItemList mListDataTheme1 = mActivityThemeData.get(0); 
				mTvActivityTheme1_title.setText(mListDataTheme1.getTitle()); // 解析设置标题
//				mTvActivityTheme1_title.setTextColor(Color.parseColor(mListDataTheme1.getTitleColor()));// 设置标题颜色
				mTvActivityTheme1_subTitle.setText(mListDataTheme1.getSubTitle()); // 解析设置副标题
				UILUtils.displayImage(mListDataTheme1.getIconUrl(), mImgActivityTheme1); // 解析显示图片
				
				ItemList mListDataTheme2 = mActivityThemeData.get(1); 
				mTvActivityTheme2_title.setText(mListDataTheme2.getTitle()); // 解析设置标题
//				mTvActivityTheme2_title.setTextColor(Color.parseColor(mListDataTheme2.getTitleColor()));// 设置标题颜色
				mTvActivityTheme2_subTitle.setText(mListDataTheme2.getSubTitle()); // 解析设置副标题
				UILUtils.displayImage(mListDataTheme2.getIconUrl(), mImgActivityTheme2); // 解析显示图片
				
				ItemList mListDataTheme3 = mActivityThemeData.get(2); 
				mTvActivityTheme3_title.setText(mListDataTheme3.getTitle()); // 解析设置标题
//				mTvActivityTheme3_title.setTextColor(Color.parseColor(mListDataTheme3.getTitleColor()));// 设置标题颜色
				mTvActivityTheme3_subTitle.setText(mListDataTheme3.getSubTitle()); // 解析设置副标题
				UILUtils.displayImage(mListDataTheme3.getIconUrl(), mImgActivityTheme3); // 解析显示图片
				
				ItemList mListDataTheme4 = mActivityThemeData.get(3); 
				mTvActivityTheme4_title.setText(mListDataTheme4.getTitle()); // 解析设置标题
//				mTvActivityTheme4_title.setTextColor(Color.parseColor(mListDataTheme4.getTitleColor()));// 设置标题颜色
				mTvActivityTheme4_subTitle.setText(mListDataTheme4.getSubTitle()); // 解析设置副标题
				UILUtils.displayImage(mListDataTheme4.getIconUrl(), mImgActivityTheme4); // 解析显示图片
				
			}
			
			@Override
			public void onErrorResponse(VolleyError arg0)
			{
				Log.e("onErrorResponse", "error = " + arg0.getMessage());
			}
		});
		
	}

	private void initDataHeader2()
	{
		HTTPUtils.get(getContext(), Constants.Url.HOME_HEADER2_LONGHOLIDAYS, new VolleyListener()
		{
			

			@Override
			public void onResponse(String arg0)
			{
				HomeHeader2Kuailechangjia homeHeader2Kuailechangjia = GsonUtils.parseJSON(arg0, HomeHeader2Kuailechangjia.class);
				subMenuListLongHoliday = homeHeader2Kuailechangjia.getResponse().getBody().getSubMenuList();
				mOverlayCard2.setAdapter(new OverlayLongHolidaySubtitleGridAdapter());
				mGvLongHolidaySubtitle.setAdapter(new LongHolidaySubtitleGridAdapter());
				// 首页Listview数据     快乐长假  推荐列表
				recommendListLongHoliday = homeHeader2Kuailechangjia.getResponse().getBody().getRecommendList();
				mHomeListView.setAdapter(new HomeAdapter()); // 为首页ListView设置适配器
				
			}
			
			@Override
			public void onErrorResponse(VolleyError arg0)
			{
				Log.e("onErrorResponse", "error = " + arg0.getMessage());
			}
		});
	}
	
	
	private void initUI(LayoutInflater inflater, ViewGroup container)
	{
		mInflater = inflater;
		layout = inflater.inflate(R.layout.fragment_home, container, false);
		ImageView mImgPhoneCall = (ImageView) layout.findViewById(R.id.img_home_top_phone);
		mImgPhoneCall.setOnClickListener(this); //首页顶部 电话客服
		mTvCtiy_LBS = (TextView) layout.findViewById(R.id.tv_home_top_city);
		mTvCtiy_LBS.setOnClickListener(this); //首页顶部 城市选择-定位
		mTvTop_Search = (TextView) layout.findViewById(R.id.tv_home_top_search);
		mTvTop_Search.setOnClickListener(this); //首页顶部 全局搜索
		
	        
		View headview = initListView(mInflater);
		initBannerUI(headview);

	}

	private View initListView(LayoutInflater mInflater)
	{
		// 下拉刷新组件
		mPtrListView = (PullToRefreshListView) layout.findViewById(R.id.pull_refresh_list);
		mHomeListView = mPtrListView.getRefreshableView();
		mOverlayCard1 = (LinearLayout) layout
				.findViewById(R.id.home_overlay_card1);//首页悬浮组件1
		mOverlay1_kl_weeks = (LinearLayout) mOverlayCard1.findViewById(R.id.ll_tab1_overlay1); // 悬浮tab1 快乐周末
		mOverlay1_kl_shortTrip = (LinearLayout) mOverlayCard1.findViewById(R.id.ll_tab2_overlay1);// 悬浮tab2 快乐短途
		mOverlay1_kl_longHoliday = (LinearLayout) mOverlayCard1.findViewById(R.id.ll_tab3_overlay1);// 悬浮tab3 快乐长假
		mOverlay1_kl_weeks.setOnClickListener(this); // 悬浮tab1 快乐周末 监听事件
		mOverlay1_kl_shortTrip.setOnClickListener(this);
		mOverlay1_kl_longHoliday.setOnClickListener(this);
		mOverlay1_kl_longHoliday.setSelected(true);
		
		mOverlayCard2 = (GridView) layout
				.findViewById(R.id.gridview_home_overlay_card2);
		mOverlayCard2.setNumColumns(5); //设置悬浮组件GridView列数
		
		// 为侧滑菜单添加HeaderView和FooterView 要在调用listview的setAdapter()之前
		View mHeaderView = initHeaderView(mInflater);
		mPtrListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>()
		{
			public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView)
			{
				isPullDown = true;
				new GetDataTask().execute();
			}

			public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView)
			{
				isPullDown = false;
				new GetDataTask().execute();
			}
		});
		// 首页ListView点击事件监听
		mHomeListView.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				// TODO Auto-generated method stub
				position = position -mHomeListView.getHeaderViewsCount();
				// 如果有为ListView添加HeaderView 要调整一下position
				if (position < 0)
				{
					return;	
				}
					startActivity(new Intent(getActivity(), HomeDetailActivity.class));
//				switch (position)
//				{
////				case 0:
////					startActivity(new Intent(getActivity(), DestinationHotCtiyActivity.class));
////					break;
////				case 1:
////					startActivity(new Intent(getActivity(), HomeTenYuanTravelActivity.class));
////					break;
//
//				default:
//					break;
//				}
			}
		});
		
		return mHeaderView;
	}

	private View initHeaderView(LayoutInflater mInflater)
	{
		
		initHeader1(mInflater); // 初始化HeaderView1  控件
		initHeader2(mInflater); // 初始化HeaderView2  控件
		initHeader3(mInflater); // 初始化HeaderView3  控件
		
		View mHeaderView4 = mInflater.inflate(R.layout.headerview4_home, null);
		mHomeListView.addHeaderView(mHeaderView4);
		mGvLongHolidaySubtitle = (GridView) mHeaderView4.findViewById(R.id.gridview_home_theme_trip_kl_subtitle);
		mGvLongHolidaySubtitle.setNumColumns(5);
		
		
		// 为首页ListView设置滑动监听事件
		mHomeListView.setOnScrollListener(new OnScrollListener()
		{
			int lastVisiblePosition = 0;
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
			{
			/*	if (firstVisibleItem >= 3)
				{
					mOverlayCard1.setVisibility(View.VISIBLE);
					if (firstVisibleItem >= 3)
					{
						if (firstVisibleItem >= 5)
						{
							mOverlayCard2.setVisibility(View.GONE);
						}else
						{
							mOverlayCard2.setVisibility(View.VISIBLE);
						}
//						mOverlayCard2.setVisibility(View.VISIBLE);
					} else
					{
						mOverlayCard2.setVisibility(View.GONE);
					}
				} else
				{
					mOverlayCard1.setVisibility(View.GONE);
				}*/
				
				if (firstVisibleItem > 2)
				{
					mOverlayCard1.setVisibility(View.VISIBLE);
					mOverlayCard2.setVisibility(View.VISIBLE);
					if (firstVisibleItem > 4)
					{
						mOverlayCard2.setVisibility(View.GONE);
						if (firstVisibleItem < lastVisiblePosition)
						{
							mOverlayCard2.setVisibility(View.VISIBLE);
							return;
						}
					}
				} else
				{
					mOverlayCard1.setVisibility(View.GONE);
					mOverlayCard2.setVisibility(View.GONE);
				}
				lastVisiblePosition = firstVisibleItem;
			}
		});
//		gridAdapter = new MyGridAdapter(); // 为GridView设置适配器
//		mOverlayCard2.setAdapter(gridAdapter);
		return mHeaderView1;
	}

	private void initHeader1(LayoutInflater mInflater)
	{
		mHeaderView1 = mInflater.inflate(R.layout.headerview1_home, null);
		mHomeListView.addHeaderView(mHeaderView1);
		
		CountdownView mCvCountdownViewTest1 = (CountdownView)mHeaderView1.findViewById(R.id.cv_countdownViewTest2);
		mCvCountdownViewTest1.setTag("test1"); // 倒计时
        long time1 = (long)5 * 60 * 60 * 1000;
        mCvCountdownViewTest1.start(time1);
        for (int time=0; time<1000; time++) {
        	mCvCountdownViewTest1.updateShow(time);
		}
        RelativeLayout mLayoutPanicBuying = (RelativeLayout) mHeaderView1.findViewById(R.id.layout_home_xianshi_qianggou);
        
		RelativeLayout mLayoutHaiWaiWanLe = (RelativeLayout) mHeaderView1.findViewById(R.id.layout_home_haiwaiwanle);
		RelativeLayout mLayoutVisa = (RelativeLayout) mHeaderView1.findViewById(R.id.layout_home_qianzheng);
		RelativeLayout mLayoutWifi = (RelativeLayout) mHeaderView1.findViewById(R.id.layout_home_allworld_wifi);
		RelativeLayout mLayoutMovieTicket = (RelativeLayout) mHeaderView1.findViewById(R.id.layout_home_movie_ticket);
		RelativeLayout mLayoutLiCai = (RelativeLayout) mHeaderView1.findViewById(R.id.layout_home_licai);
		RelativeLayout mLayoutCarTicket = (RelativeLayout) mHeaderView1.findViewById(R.id.layout_home_car_ticket);
		mLayoutPanicBuying.setOnClickListener(this); //抢购
		mLayoutHaiWaiWanLe.setOnClickListener(this); //海外玩乐  监听事件
		mLayoutVisa.setOnClickListener(this); //签证  监听事件
		mLayoutWifi.setOnClickListener(this); //全球wifi  监听事件
		mLayoutMovieTicket.setOnClickListener(this); //电影票  监听事件
		mLayoutLiCai.setOnClickListener(this); //理财  监听事件
		mLayoutCarTicket.setOnClickListener(this); //汽车票  监听事件
		
	}

	private void initHeader2(LayoutInflater mInflater)
	{
		View mHeaderView2 = mInflater.inflate(R.layout.headerview2_home, null);
		mHomeListView.addHeaderView(mHeaderView2);
		RelativeLayout mLayoutWoShenBian = (RelativeLayout) mHeaderView2.findViewById(R.id.layout_home_lbs_my_shenbian);
		mLayoutWoShenBian.setOnClickListener(this); //我身边控件监听事件
		
		// header2 主题活动1
		RelativeLayout mLayoutActivityTheme1 = (RelativeLayout) mHeaderView2.findViewById(R.id.layout_home_activity_theme1);
		mTvActivityTheme1_title = (TextView) mHeaderView2.findViewById(R.id.tv_home_activity_theme1_title);
		mTvActivityTheme1_subTitle = (TextView) mHeaderView2.findViewById(R.id.tv_home_activity_theme1_subtitle);
		mImgActivityTheme1 = (ImageView) mHeaderView2.findViewById(R.id.img_home_activity_theme1);
		mLayoutActivityTheme1.setOnClickListener(this); //主题活动1 控件监听事件
		
		// header2 主题活动2
		RelativeLayout mLayoutActivityTheme2 = (RelativeLayout) mHeaderView2.findViewById(R.id.layout_home_activity_theme2);
		mTvActivityTheme2_title = (TextView) mHeaderView2.findViewById(R.id.tv_home_activity_theme2_title);
		mTvActivityTheme2_subTitle = (TextView) mHeaderView2.findViewById(R.id.tv_home_activity_theme2_subtitle);
		mImgActivityTheme2 = (ImageView) mHeaderView2.findViewById(R.id.img_home_activity_theme2);
		mLayoutActivityTheme2.setOnClickListener(this); //主题活动2 控件监听事件
		
		// header2 主题活动3
		RelativeLayout mLayoutActivityTheme3 = (RelativeLayout) mHeaderView2.findViewById(R.id.layout_home_activity_theme3);
		mTvActivityTheme3_title = (TextView) mHeaderView2.findViewById(R.id.tv_home_activity_theme3_title);
		mTvActivityTheme3_subTitle = (TextView) mHeaderView2.findViewById(R.id.tv_home_activity_theme3_subtitle);
		mImgActivityTheme3 = (ImageView) mHeaderView2.findViewById(R.id.img_home_activity_theme3);
		mLayoutActivityTheme3.setOnClickListener(this); //主题活动3 控件监听事件
		
		// header2 主题活动4
		RelativeLayout mLayoutActivityTheme4 = (RelativeLayout) mHeaderView2.findViewById(R.id.layout_home_activity_theme4);
		mTvActivityTheme4_title = (TextView) mHeaderView2.findViewById(R.id.tv_home_activity_theme4_title);
		mTvActivityTheme4_subTitle = (TextView) mHeaderView2.findViewById(R.id.tv_home_activity_theme4_subtitle);
		mImgActivityTheme4 = (ImageView) mHeaderView2.findViewById(R.id.img_home_activity_theme4);
		mLayoutActivityTheme4.setOnClickListener(this); //主题活动4 控件监听事件
		
		// header2 主题活动5
		RelativeLayout mLayoutActivityTheme5 = (RelativeLayout) mHeaderView2.findViewById(R.id.layout_home_theme_activity_10yuan);
		mLayoutActivityTheme5.setOnClickListener(this);
		// header2 主题活动6
		RelativeLayout mLayoutActivityTheme6 = (RelativeLayout) mHeaderView2.findViewById(R.id.layout_home_theme_activity_100yuan);
		mLayoutActivityTheme6.setOnClickListener(this);
		// header2 主题活动7
		RelativeLayout mLayoutActivityTheme7 = (RelativeLayout) mHeaderView2.findViewById(R.id.layout_home_theme_activity_temai_quanqiu);
		mLayoutActivityTheme7.setOnClickListener(this);
		// header2 主题活动8
		RelativeLayout mLayoutActivityTheme8 = (RelativeLayout) mHeaderView2.findViewById(R.id.layout_home_theme_activity_temai_youlun);
		mLayoutActivityTheme8.setOnClickListener(this);
	}

	@SuppressLint("InflateParams")
	private void initHeader3(LayoutInflater mInflater)
	{
		View mHeaderView3 = mInflater.inflate(R.layout.headerview3_home, null);
		mHomeListView.addHeaderView(mHeaderView3);
		mlayout_kl_weeks = (LinearLayout) mHeaderView3.findViewById(R.id.kl_tab1);
		mlayout_kl_shortTrip = (LinearLayout) mHeaderView3.findViewById(R.id.kl_tab2);
		mlayout_kl_longHoliday = (LinearLayout) mHeaderView3.findViewById(R.id.kl_tab3);
		mlayout_kl_weeks.setOnClickListener(this); //快乐周末  监听事件
		mlayout_kl_shortTrip.setOnClickListener(this); //快乐短途  监听事件
		mlayout_kl_longHoliday.setOnClickListener(this); //快乐长假  监听事件
		mlayout_kl_longHoliday.setSelected(true); //默认选中
	}
	
	private void initBannerUI(View mHeaderView1)
	{
		// 片段里面嵌套片段要调getChildFragmentManager()方法
		fm = getChildFragmentManager();
		
		initPagerUI(mHeaderView1, fm);
		initIndicatorUI(mHeaderView1);
		autoScroll();
	}

	private void initPagerUI(View mHeaderView1, FragmentManager fm)
	{
		mHomeTopPager = (ViewPager) mHeaderView1.findViewById(R.id.pager_home_top);
		mHomeSecondPager = (ViewPager) mHeaderView1.findViewById(R.id.pager_home_second);
		
		mHomeTopPager.setCurrentItem(MAX_LENGTH / 2); // 初始化时设置Pager显示中间页面
		// 手动自动的冲突问题
		mHomeTopPager.addOnPageChangeListener(new FirstBannerPagerListent());
		mHomeSecondPager.addOnPageChangeListener(new SecondBannerPagerListent());
	}

	private void initIndicatorUI(View mHeaderView1)
	{
		mIndicator1 = (HomeViewPagerIndicator) mHeaderView1.findViewById(R.id.viewPagerIndicator1);
		mIndicator1.setRealNum(6);
		mIndicator2 = (HomeViewPagerIndicator2) mHeaderView1.findViewById(R.id.viewPagerIndicator_second);
		// 如果ViewPager是无限循环就调用setRealNum()方法设置指示器循环个数
		mIndicator2.setRealNum(3);
	}


	private final class FirstBannerPagerListent implements OnPageChangeListener
	{
		@Override
		public void onPageSelected(int position)
		{
			// 在页面选择
		}

		@Override
		public void onPageScrolled(int position, float positionOffset, int arg2)
		{
			// 在页面滚动
			// 增加自定义指示器：在ViewPager适配器的方法中触发indicator动态刷新
			position %= 6;
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
		mHomeTopPager.postDelayed(new Runnable()
		{
			// 定时每2.5秒自动滑到下一页
			public void run()
			{
				// 定时任务一直持续
				mHomeTopPager.postDelayed(this, DILAY_MILLIS); // 持续自动轮播
				if (!isDragging) // 没有拖拽滑块，自动下一页
				{
					int currentItem = mHomeTopPager.getCurrentItem();
					int nextItem = currentItem + 1;
					mHomeTopPager.setCurrentItem(nextItem);
				}
			}
		}, DILAY_MILLIS);
	}
	
	private final class SecondBannerPagerListent implements OnPageChangeListener
	{
		@Override
		public void onPageSelected(int position)
		{
			// 在页面选择
		}

		@Override
		public void onPageScrolled(int position, float positionOffset, int arg2)
		{
			// 在页面滚动
			// 增加自定义指示器：在ViewPager适配器的方法中触发indicator动态刷新
			position %= 3;
			mIndicator2.move(position, positionOffset);
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
	
	

	// 第一个BannerViewPager 自动轮播
	private final class BannerAdapter extends FragmentPagerAdapter
	{
		private BannerAdapter(FragmentManager fm)
		{
			super(fm);
		}

		@Override
		public int getCount()
		{
			// 无限循环 修改Pager适配器的getCount()返回400000
			return MAX_LENGTH;
		}

		@Override
		public Fragment getItem(int position)
		{

			return new HomeFirstPagerFragment(position,mFirstBannerItemList);
		}
	}

	// 第2个BannerViewPager 无自动轮播
	private final class SecondPagerAdapter extends FragmentPagerAdapter
	{
		private SecondPagerAdapter(FragmentManager fm)
		{
			super(fm);
		}

		@Override
		public int getCount()
		{
			// 没有无限循环 修改Pager适配器的getCount()返回3
			return 3;
		}

		@Override
		public Fragment getItem(int position)
		{
			// 返回到第二个Pager片段
			return new HomeSecondPagerFragment(position,mSecondBannerItemList);
		}
	}

	// 首页ListView 适配器
	class HomeAdapter extends BaseAdapter
	{

		@Override
		public int getCount()
		{
			return recommendListLongHoliday.size(); // 快乐长假 推荐列表的容器长度 
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

		@SuppressLint("ViewHolder")
		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			View layout = mInflater.inflate(R.layout.home_longholiday_listitem, null);
			ImageView mImageView = (ImageView) layout.findViewById(R.id.img_home_longholiday_list_zhutu);
			TextView mTvJingXuan = (TextView) layout.findViewById(R.id.tv_home_longholiday_list_jingxuan);
			TextView mTvPrice = (TextView) layout.findViewById(R.id.tv_home_longholiday_list_price);
			
			TextView mTvTitle = (TextView) layout.findViewById(R.id.tv_home_longholiday_list_title);
			TextView mTvSubTitle = (TextView) layout.findViewById(R.id.tv_home_longholiday_list_subtitle);
			TextView mTvlabel1 = (TextView) layout.findViewById(R.id.tv_home_longholiday_list_label1);
			TextView mTvlabel2 = (TextView) layout.findViewById(R.id.tv_home_longholiday_list_label2);
			TextView mTvlabel3 = (TextView) layout.findViewById(R.id.tv_home_longholiday_list_label3);
			TextView mTvlabel4 = (TextView) layout.findViewById(R.id.tv_home_longholiday_list_label4);
			TextView mTvlabel5 = (TextView) layout.findViewById(R.id.tv_home_longholiday_list_label5);
			
			RecommendList recommendListData = recommendListLongHoliday.get(position);
			UILUtils.displayImage(recommendListData.getImageUrl(), mImageView);
			mTvJingXuan.setText(recommendListData.getLabelName());
			mTvPrice.setText(recommendListData.getPriceNew());
			mTvTitle.setText(recommendListData.getTitle());
			mTvSubTitle.setText(recommendListData.getSubTitle());
			
			List<Label> labelList = recommendListData.getLabel();
			if (labelList.size() == 1)
			{
				mTvlabel1.setText(labelList.get(0).getTitle());
				
			}else if (labelList.size() == 2)
			{
				mTvlabel1.setText(labelList.get(0).getTitle());
				mTvlabel2.setText(labelList.get(1).getTitle());
			}else if (labelList.size() == 3)
			{
				mTvlabel1.setText(labelList.get(0).getTitle());
				mTvlabel2.setText(labelList.get(1).getTitle());
				mTvlabel3.setText(labelList.get(2).getTitle());
			}else if (labelList.size() == 4)
			{
				mTvlabel1.setText(labelList.get(0).getTitle());
				mTvlabel2.setText(labelList.get(1).getTitle());
				mTvlabel3.setText(labelList.get(2).getTitle());
				mTvlabel4.setText(labelList.get(3).getTitle());
			}else if (labelList.size() == 5)
			{
				mTvlabel1.setText(labelList.get(0).getTitle());
				mTvlabel2.setText(labelList.get(1).getTitle());
				mTvlabel3.setText(labelList.get(2).getTitle());
				mTvlabel4.setText(labelList.get(3).getTitle());
				mTvlabel5.setText(labelList.get(4).getTitle());
			}
			
			return layout;
		}

	}

	private class GetDataTask extends AsyncTask<Void, Void, String>
	{
		protected String doInBackground(Void... params)
		{
			try
			{
				Thread.sleep(2000);
			} catch (InterruptedException e)
			{
			}
			return "aaa";
		}

		protected void onPostExecute(String result)
		{
			// if (isPullDown) {
			// mData.add(0, "pullDown");
			// } else {
			// mData.add("pullUp");
			// }
			// mAdapter.notifyDataSetChanged();
			mPtrListView.onRefreshComplete();

		}
	}

	// 首页HeaderView4  快乐长假的gridview适配器
		@SuppressLint("ViewHolder")
		private final class LongHolidaySubtitleGridAdapter extends BaseAdapter
		{

			@Override
			public int getCount() {
				return subMenuListLongHoliday.size();
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
//				ItemList itemData = mSecondBannerItemList.get(realPos);
				View itemlayout = mInflater.inflate(R.layout.home_header4_gridview_item, null);
				
				tvSubMenuTitle = (TextView) itemlayout.findViewById(R.id.tv_home_header4_subMenuTitle);
				subMenuData = subMenuListLongHoliday.get(position);
				tvSubMenuTitle.setText(subMenuData.getTitle());
				return itemlayout;
			}

			@Override
			public long getItemId(int position) {
				return 0;
			}

			@Override
			public Object getItem(int position) {
				return null;
			}

		}
		// 首页HeaderView4  快乐长假的gridview适配器
		@SuppressLint("ViewHolder")
		private final class OverlayLongHolidaySubtitleGridAdapter extends BaseAdapter
		{
			
			private TextView tvOverlaySubMenuTitle;
			private SubMenuList overlaySubMenuData;

			@Override
			public int getCount() {
				return subMenuListLongHoliday.size();
			}
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
//				ItemList itemData = mSecondBannerItemList.get(realPos);
				View itemlayout = mInflater.inflate(R.layout.home_overlay_card2_gridview_item, null);
				tvOverlaySubMenuTitle = (TextView) itemlayout.findViewById(R.id.tv_home_overlay_card2_gridview_subMenuTitle);
				overlaySubMenuData = subMenuListLongHoliday.get(position);
//				Log.e("OverlayLongHolidaySubtitleGridAdapter", "getView");
				tvOverlaySubMenuTitle.setText(overlaySubMenuData.getTitle());
				return itemlayout;
			}
			
			@Override
			public long getItemId(int position) {
				return 0;
			}
			
			@Override
			public Object getItem(int position) {
				return null;
			}
			
		}
	// 首页顶部  电话咨询适配器
		@SuppressLint({ "ViewHolder", "InflateParams" })
		class PhoneAdapter extends BaseAdapter
		{

			private TextView mTvTitle;
			private TextView mTvSubTitle;
			private ImageView mImagePhone;

			@Override
			public int getCount() {
				return 3;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View phonelayout = mInflater.inflate(R.layout.list_phone_trim, null);
				mTvTitle = (TextView) phonelayout.findViewById(R.id.tv_title);
				mTvSubTitle = (TextView) phonelayout.findViewById(R.id.tv_subtitle);
				mImagePhone = (ImageView) phonelayout.findViewById(R.id.image_phone);
				mTvTitle.setText(menu_title[position]+"");
				mTvSubTitle.setText(menu_subtitle[position]+"");
				mImagePhone.setImageResource(menu_image[position]);
				return phonelayout;
			}
			
			@Override
			public Object getItem(int position) {
				return null;
			}

			@Override
			public long getItemId(int position) {
				return 0;
			}

		}
	private void initData()
	{

	}

    @SuppressLint("InflateParams")
	private void PhoneCallDialogNoTitle() {	
    	View menuView = mInflater.inflate(R.layout.listview_menu, null);
	// 创建AlertDialog
    	final AlertDialog menuDialog = new AlertDialog.Builder(getActivity()).create();
    	menuDialog.setView(menuView);
	
    	menuList = (ListView) menuView.findViewById(R.id.listView_phone);
    	mPhoneAdapter = new PhoneAdapter();
    	menuList.setAdapter(mPhoneAdapter);
	
    	menuList.setOnItemClickListener(new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long id) {
			switch (position)
			{
			case Constants.TELPHONE_KEFU: // 跳转web 在线客服
				Toast.makeText(getContext(), "请拨打400电话在线咨询", Toast.LENGTH_SHORT).show();
				break;
			case Constants.TELPHONE_DEMESTIC_USER: // 国内用户 电话咨询
				// 添加权限
				// 拨打电话    （隐式意图）
				Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "4007995833"));
				startActivity(intent );
				break;
			case Constants.TELPHONE_FOREIGN_USER: // 海外用户 电话咨询
				// 添加权限
				// 拨打电话    （隐式意图）
				Intent intent1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "8651282209000"));
				startActivity(intent1 );
				break;

			default:
				break;
			}
			}
    	});
    			menuDialog.show();
    	}
    
    @Override
	public void onStart()
	{
    	String city = UtilsSharePerference.getCity(getActivity());
    	mTvCtiy_LBS.setText(city);
    	
		receiver = new MyReceiver();
		IntentFilter filter = new IntentFilter();
		filter.addAction(Constants.IntentFilter.UPDATA_OVERLAY_TAB1); // 设置过滤条件   悬浮按钮tab1的同步选中
		filter.addAction(Constants.IntentFilter.UPDATA_OVERLAY_TAB2); // 过滤条件  设置 悬浮按钮tab2的同步选中
		filter.addAction(Constants.IntentFilter.UPDATA_OVERLAY_TAB3); // 过滤条件  设置 悬浮按钮tab3的同步选中  
		getActivity().registerReceiver(receiver, filter); // 注册广播
		super.onStart();
	}
	

	@Override
	public  void onStop(){

		getActivity().unregisterReceiver(receiver); // 注销广播
		super.onStop();
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
    
 // 界面接收到广播时，开始更新控件
 	class MyReceiver extends BroadcastReceiver
 	{
 		@Override
 		public void onReceive(Context context, Intent intent)
 		{
 			// 接收广播  更新控件 
 			String action = intent.getAction();
 			switch (action)
 			{
 			case Constants.IntentFilter.UPDATA_OVERLAY_TAB1:
 				mlayout_kl_weeks.setSelected(true);
 				mlayout_kl_longHoliday.setSelected(false);
 				mlayout_kl_shortTrip.setSelected(false);
 				
 				mOverlay1_kl_weeks.setSelected(true);
 				mOverlay1_kl_longHoliday.setSelected(false);
 				mOverlay1_kl_shortTrip.setSelected(false);
 				break;
 			case Constants.IntentFilter.UPDATA_OVERLAY_TAB2:
 				mlayout_kl_shortTrip.setSelected(true);
 				mlayout_kl_longHoliday.setSelected(false);
 				mlayout_kl_weeks.setSelected(false);
 				
 				mOverlay1_kl_shortTrip.setSelected(true);
 				mOverlay1_kl_longHoliday.setSelected(false);
 				mOverlay1_kl_weeks.setSelected(false);
 				break;
 			case Constants.IntentFilter.UPDATA_OVERLAY_TAB3:
 				mlayout_kl_longHoliday.setSelected(true);
 				mlayout_kl_shortTrip.setSelected(false);
 				mlayout_kl_weeks.setSelected(false);
 				
 				mOverlay1_kl_longHoliday.setSelected(true);
 				mOverlay1_kl_weeks.setSelected(false);
 				mOverlay1_kl_shortTrip.setSelected(false);
 				break;
 			
 				
 			default:
 				break;
 			}
 			
 			
 		}
 	}
    
	@Override
	public void onClick(View v)
	{
		// TODO 
		Intent intent = new Intent();
		int id = v.getId();
		switch (id)
		{
		case R.id.tv_home_top_city: //首页顶部城市选择定位
			intent.setClass(getActivity(), CitiesActivity.class);
			startActivity(intent);
			break;
		case R.id.tv_home_top_search: //首页顶部  global search 全局搜索
			intent.setClass(getActivity(), GlobalSearchesActivity.class);
			startActivity(intent);
			break;
		case R.id.img_home_top_phone: //首页顶部电话寻求帮助
			PhoneCallDialogNoTitle(); 
			break;
		case R.id.layout_home_haiwaiwanle: //海外玩乐
			intent.setClass(getActivity(), HomeVisaActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_home_qianzheng: //签证
			intent.setClass(getActivity(), HomeVisaActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_home_allworld_wifi: //全球wifi
			intent.setClass(getActivity(), HomeVisaActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_home_movie_ticket: //电影票
			intent.setClass(getActivity(), HomeMoviceTicketActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_home_licai: //理财
			intent.setClass(getActivity(), HomeMoviceTicketActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_home_car_ticket: //汽车票
			intent.setClass(getActivity(), HomeMoviceTicketActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_home_xianshi_qianggou: //抢购
			intent.setClass(getActivity(), HomePanicBuyingActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_home_lbs_my_shenbian: //在身边
			intent.setClass(getActivity(), HomeNearByActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_home_activity_theme1: //主题活动1  春游特惠
			intent.setClass(getActivity(), HomeSuperPlayerActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_home_activity_theme2: //主题活动2  TC专线
			intent.setClass(getActivity(), HomeSuperPlayerActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_home_activity_theme3: //主题活动3  有票专享
			intent.setClass(getActivity(), HomeSuperPlayerActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_home_activity_theme4: //主题活动4 超级玩咖
			intent.setClass(getActivity(), HomeSuperPlayerActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_home_theme_activity_10yuan: //主题活动5  十元周末
			intent.setClass(getActivity(), HomeTenYuanTravelActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_home_theme_activity_100yuan: //主题活动6  百元中国
			intent.setClass(getActivity(), HomeTenYuanTravelActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_home_theme_activity_temai_quanqiu: //主题活动7  特卖全球
			intent.setClass(getActivity(), HomeTenYuanTravelActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_home_theme_activity_temai_youlun: //主题活动8  邮轮特卖
			intent.setClass(getActivity(), HomeTenYuanTravelActivity.class);
			startActivity(intent);
			break;
			
		case R.id.kl_tab1: // 快乐周末
			intent.setAction(Constants.IntentFilter.UPDATA_OVERLAY_TAB1);
			getActivity().sendBroadcast(intent);
			Toast.makeText(getContext(), "快乐周末~", Toast.LENGTH_SHORT).show();
			break;
		case R.id.kl_tab2: // 快乐短途
			intent.setAction(Constants.IntentFilter.UPDATA_OVERLAY_TAB2);
			getActivity().sendBroadcast(intent);
			Toast.makeText(getContext(), "快乐短途~", Toast.LENGTH_SHORT).show();
			break;
		case R.id.kl_tab3: // 快乐长假
			intent.setAction(Constants.IntentFilter.UPDATA_OVERLAY_TAB3);
			getActivity().sendBroadcast(intent);
			break;
		case R.id.ll_tab1_overlay1: // 悬浮组件tab1 快乐周末
			intent.setAction(Constants.IntentFilter.UPDATA_OVERLAY_TAB1);
			getActivity().sendBroadcast(intent);
			Toast.makeText(getContext(), "快乐周末~", Toast.LENGTH_SHORT).show();
			break;
		case R.id.ll_tab2_overlay1: // 悬浮组件tab2 快乐短途
			intent.setAction(Constants.IntentFilter.UPDATA_OVERLAY_TAB2);
			getActivity().sendBroadcast(intent);
			Toast.makeText(getContext(), "快乐短途~", Toast.LENGTH_SHORT).show();
			break;
		case R.id.ll_tab3_overlay1: // 悬浮组件tab3 快乐长假
			intent.setAction(Constants.IntentFilter.UPDATA_OVERLAY_TAB3);
			getActivity().sendBroadcast(intent);
			break;

		default:
			break;
		}
		
	}

}
