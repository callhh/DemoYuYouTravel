package com.example.sample;

import java.util.List;
import java.util.Map;

import com.android.volley.VolleyError;
import com.example.model.header2.kuaileduantu.HomeHeader2Kuaileduantu;
import com.example.model.header2.kuaileduantu.RecommendList;
import com.example.sample.calendar.DateSelectionActivity;
import com.example.sample.fragment.HomeFragment;
import com.example.sample.usermanage.LoginActivity;
import com.example.sample.widget.ScrollViewExtend;
import com.example.sample.widget.ScrollViewExtend.OnScrollChangeListener;
import com.example.utils.Constants;
import com.example.utils.ImageLoadUtils;
import com.xinbo.utils.GsonUtils;
import com.xinbo.utils.HTTPUtils;
import com.xinbo.utils.VolleyListener;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class HomeDetailActivity extends Activity implements OnClickListener
{

	private LinearLayout mToolbar;
	private TextView mTvTitle;
	private LinearLayout mToolbarOverlay;
	private ListView menuList;
	private PhoneAdapter mPhoneAdapter;
	private String[] menu_title =
	{ "在线客服", "国内用户", "海外用户" };
	private String[] menu_subtitle =
	{ "及时高效，快速解决您的问题", "拨打4007-997-922，不收取长途费", "+86-512-82209000" };
	int[] menu_image =
	{ R.drawable.icon_service_online, R.drawable.icon_service_common_message_rest, R.drawable.icon_service_greenphone };

	private ImageView mImageTop;
	private ImageView tlbShare;
	private ImageView tlbMore;
	private ImageView tlbBack;
	private ImageView tlbMoreol;
	private ImageView tlbShareol;
	private ImageView tlbBackol;
	private LinearLayout mOverlayTab;
	private TextView mTvBooking;
	private RelativeLayout mlayoutDateSelection;
	private GridView mGridvDetail;
	private ListView mListView;
	private LinearLayout mlayoutCallKefu;
	private RecommendAdapter recommendAdapter;
	private List<RecommendList> recommendList;
	
	private LinearLayout layout;
	private ListView listView;
	private PopupWindow popupWindow;
	private ScrollViewExtend mScrollViewExtend;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_detail);
		initUI();
		initData();
	}

	private void initUI()
	{
		mScrollViewExtend = (ScrollViewExtend) findViewById(R.id.sv_vacation_detail_frame);
		mToolbar = (LinearLayout) findViewById(R.id.ll_actionbar);
		mTvTitle = (TextView) findViewById(R.id.detail_tb_tv);
		mToolbarOverlay = (LinearLayout) findViewById(R.id.toolbar_include02);

		tlbBack = (ImageView) findViewById(R.id.detail_tb_img_back);
		tlbBackol = (ImageView) findViewById(R.id.detail_tb_img_back_ol);

		tlbMore = (ImageView) findViewById(R.id.detail_tb_img_more);
		tlbMoreol = (ImageView) findViewById(R.id.detail_tb_img_more_ol);

		tlbShare = (ImageView) findViewById(R.id.detail_tb_img_share);
		tlbShareol = (ImageView) findViewById(R.id.detail_tb_img_share_ol);
		tlbMore.setOnClickListener(this);
		tlbMoreol.setOnClickListener(this);
		tlbShare.setOnClickListener(this);
		tlbShareol.setOnClickListener(this);
		tlbBack.setOnClickListener(this);
		tlbBackol.setOnClickListener(this);

		mImageTop = (ImageView) findViewById(R.id.iv_vacation_detail_header_image);
		mImageTop.setOnClickListener(this);

		mOverlayTab = (LinearLayout) findViewById(R.id.ll_vacation_detail_overlay_tab);// 悬浮组件

		mlayoutCallKefu = (LinearLayout) findViewById(R.id.ll_vacation_detail_consultation);// 客服咨询
		mlayoutDateSelection = (RelativeLayout) findViewById(R.id.ll_vacation_detail_date);// 日期选择
		mTvBooking = (TextView) findViewById(R.id.tv_vacation_detail_book); // 预定
		mlayoutCallKefu.setOnClickListener(this);
		mlayoutDateSelection.setOnClickListener(this);
		mTvBooking.setOnClickListener(this);

		mGridvDetail = (GridView) findViewById(R.id.gridView_vacation_detail);// grideview看过还看
		LookAdapter mLookAdapter = new LookAdapter();
		mGridvDetail.setAdapter(mLookAdapter);
		mListView = (ListView) findViewById(R.id.listview_vacation_boutique_recommend);// listview精品推荐
		recommendAdapter = new RecommendAdapter();

		mScrollViewExtend.setOnScrollChangeListener(new setScrollChangeListener());

	}

	private void initData()
	{
		initListViewData();
	}

	private void initListViewData()
	{
		HTTPUtils.get(HomeDetailActivity.this, Constants.Url.HOME_HEADER2_SHORT_TRIP, new VolleyListener()
		{

			@Override
			public void onResponse(String arg0)
			{
				HomeHeader2Kuaileduantu kuaileduantu = GsonUtils.parseJSON(arg0, HomeHeader2Kuaileduantu.class);
				recommendList = kuaileduantu.getResponse().getBody().getRecommendList();
				mListView.setAdapter(recommendAdapter); // Json解析完数据在设置适配器
														// getView获得数据
				// 在ScrollView中嵌套ListView空间，无法正确的计算ListView的大小，故可以通过代码，根据当前的ListView的列表项计算列表的尺寸
				// 在设置ListView的Adapter后调用
				setListViewHeightBasedOnChildren(mListView);
				mScrollViewExtend.smoothScrollTo(0, 0); //解决ScrollView嵌套ListView，启动后会自动向下滚动
			}

			@Override
			public void onErrorResponse(VolleyError arg0)
			{
				Log.e("onErrorResponse", "error = " + arg0.getMessage());
			}
		});

	}

	private final class setScrollChangeListener implements OnScrollChangeListener
	{
		// ScrollView 滑动监听，改变actionbar背景
		@Override
		public void onScrollChange(int scrollX, int scrollY, int oldScrollX, int oldScrollY)
		{
			if (0 <= scrollY && scrollY < 100)
			{
				String tmc;
				StringBuffer buffer = new StringBuffer();
				int tm = scrollY;
				if (tm < 10)
				{
					tmc = "0" + tm;
				} else
				{
					tmc = tm + "";
				}
				String bgstring = buffer.append("#").append(tmc).append("FFFFFF").toString();
				int bgcolor = Color.parseColor(bgstring);
				int ttcolor = Color.parseColor(bgstring.replace("FFFFFF", "000000"));
				mToolbar.setBackgroundColor(bgcolor);
				mTvTitle.setTextColor(ttcolor);
				if (mToolbarOverlay.getVisibility() == View.VISIBLE)
				{// 性能问题
					mToolbarOverlay.setVisibility(View.GONE);
				}
			} else if (scrollY >= 100)
			{
				if (mToolbarOverlay.getVisibility() == View.GONE)
				{// 性能问题
					mToolbarOverlay.setVisibility(View.VISIBLE);
				}
				int bgColor = Color.parseColor("#FFFFFF");
				mToolbar.setBackgroundColor(bgColor);
				int ttColor = Color.parseColor("#000000");
				mTvTitle.setTextColor(ttColor);
			}
			// if (scrollY <= 800)
			// {
			// int colorAplha = scrollY * 0xFF / 800;
			//// mToolbar.setBackgroundColor(Color.argb(colorAplha, 0xC0, 0xC0,
			// 0xC0));
			// mToolbar.setBackgroundColor(Color.argb(colorAplha, 0xFF, 0xFF,
			// 0xFF));
			// // 绿色颜色数值：#ff33bd61---->#FFFFFFFF
			// int red = 0x33 + (0xFF - 0x33) * scrollY / 800;
			// int green = 0xbd + (0xFF - 0xbd) * scrollY / 800;
			// int blue = 0x61 + (0xFF - 0x61) * scrollY / 800;
			// mTvTitle.setTextColor(Color.argb(0xFF, red, green, blue));
			// }
		}

	}

	@SuppressLint("ViewHolder")
	class LookAdapter extends BaseAdapter
	{
		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			View layout = getLayoutInflater().inflate(R.layout.vacation_detail_griditem, null);

			return layout;
		}

		@Override
		public int getCount()
		{
			return 4;
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

	}

	// 解决ScrollView嵌套ListView，ListView只显示一行问题
	private void setListViewHeightBasedOnChildren(ListView listView)
	{
		// 获取ListView对应的Adapter
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null)
		{
			// pre-condition

			return;

		}

		int totalHeight = 0;

		for (int i = 0; i < listAdapter.getCount(); i++)
		{
			// listAdapter.getCount()返回数据项的数目
			View listItem = listAdapter.getView(i, null, listView);
			// 计算子项View 的宽高
			listItem.measure(0, 0);
			// 统计所有子项的总高度
			totalHeight += listItem.getMeasuredHeight();

		}

		ViewGroup.LayoutParams params = listView.getLayoutParams();

		params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		// listView.getDividerHeight()获取子项间分隔符占用的高度
		// params.height最后得到整个ListView完整显示需要的高度
		listView.setLayoutParams(params);

	}

	// ListView适配器
	class RecommendAdapter extends BaseAdapter
	{
		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			ViewHolder holder = null;
			if (convertView == null)
			{
				holder = new ViewHolder();
				convertView = getLayoutInflater().inflate(R.layout.vacation_detail_recommend_listitem, null);
				holder.mImageView = (ImageView) convertView.findViewById(R.id.bou_picurl);
				holder.mTvTitle = (TextView) convertView.findViewById(R.id.bou_Title);
				holder.mTvSubtitle = (TextView) convertView.findViewById(R.id.bou_subTitle);
				holder.mTvPrice = (TextView) convertView.findViewById(R.id.tv_price);
				convertView.setTag(holder);
			} else
			{
				holder = (ViewHolder) convertView.getTag();
			}
			RecommendList recommendListData = recommendList.get(position);
			ImageLoadUtils.displayImage(HomeDetailActivity.this, recommendListData.getImageUrl(), holder.mImageView);
			holder.mTvTitle.setText(recommendListData.getTitle());
			holder.mTvSubtitle.setText(recommendListData.getSubTitle());
			holder.mTvPrice.setText(recommendListData.getPriceNew());

			return convertView;
		}

		@Override
		public int getCount()
		{
			return recommendList.size();
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

	}

	// 定义一个ViewHolder，将convetView的tag设置为ViewHolder,不为空时重新使用即可
	static class ViewHolder
	{
		ImageView mImageView;
		TextView mTvTitle;
		TextView mTvSubtitle;
		TextView mTvPrice;
	}

	// 首页顶部 电话咨询适配器
	@SuppressLint(
	{ "ViewHolder", "InflateParams" })
	class PhoneAdapter extends BaseAdapter
	{

		private TextView mTvTitle;
		private TextView mTvSubTitle;
		private ImageView mImagePhone;

		@Override
		public int getCount()
		{
			return 3;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			View phonelayout = getLayoutInflater().inflate(R.layout.vacation_detail_telphone_listitem, null);
			mTvTitle = (TextView) phonelayout.findViewById(R.id.tv_title);
			mTvSubTitle = (TextView) phonelayout.findViewById(R.id.tv_subtitle);
			mImagePhone = (ImageView) phonelayout.findViewById(R.id.image_phone);
			mTvTitle.setText(menu_title[position] + "");
			mTvSubTitle.setText(menu_subtitle[position] + "");
			mImagePhone.setImageResource(menu_image[position]);
			return phonelayout;
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

	}

	@SuppressLint("InflateParams")
	private void telphoneDialogNoTitle()
	{
		View menuView = getLayoutInflater().inflate(R.layout.vacation_detail_telphone_listview_menu, null);
		// 创建AlertDialog
		final AlertDialog menuDialog = new AlertDialog.Builder(this).create();
		menuDialog.setView(menuView);

		menuList = (ListView) menuView.findViewById(R.id.listView_vacation_detail_telphone);
		mPhoneAdapter = new PhoneAdapter();
		menuList.setAdapter(mPhoneAdapter);

		menuList.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id)
			{
				switch (position)
				{
				case Constants.TELPHONE_KEFU: // 跳转web 在线客服
					Toast.makeText(HomeDetailActivity.this, "请拨打400电话在线咨询", Toast.LENGTH_SHORT).show();
					break;
				case Constants.TELPHONE_DEMESTIC_USER: // 国内用户 电话咨询
					// 添加权限
					// 拨打电话 （隐式意图）
					Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "4007995833"));
					startActivity(intent);
					break;
				case Constants.TELPHONE_FOREIGN_USER: // 海外用户 电话咨询
					// 添加权限
					// 拨打电话 （隐式意图）
					Intent intent1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "8651282209000"));
					startActivity(intent1);
					break;

				default:
					break;
				}
			}
		});
		menuDialog.show();
	}

	public void showPopupWindow(View parent) {
		//加载布局
		layout = (LinearLayout) LayoutInflater.from(HomeDetailActivity.this).inflate(
				R.layout.vacation_detail_actionbar_listview_menu, null);
		//找到布局的控件
		listView = (ListView) layout.findViewById(R.id.listView_vacation_detail_actionbar_menu);
		
		// 获取数据
		List<Map<String, Object>> spinnerdata3 = com.example.utils.Adapter.getspinner3data();
		// 设置adapter
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, spinnerdata3, R.layout.vacation_detail_actionbar_listitem2, new String[]
		{ "icon", "listname" }, new int[]
		{ R.id.img_menu_item_favor, R.id.tv_menu_item_favor });
		
		//设置适配器
		listView.setAdapter(simpleAdapter);
		// 实例化popupWindow
		popupWindow = new PopupWindow(layout, 300,500);
		//控制键盘是否可以获得焦点
		popupWindow.setFocusable(true);
		//设置popupWindow弹出窗体的背景
		popupWindow.setBackgroundDrawable(new BitmapDrawable(null,""));
		WindowManager manager=(WindowManager) getSystemService(Context.WINDOW_SERVICE);
		@SuppressWarnings("deprecation")
		//获取xoff
		int xpos=manager.getDefaultDisplay().getWidth()/2-popupWindow.getWidth()/2;
		//xoff,yoff基于anchor的左下角进行偏移。
		popupWindow.showAsDropDown(parent,xpos, 0);
		//监听
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long id) {
				switch (position)
				{
				case Constants.DETAIL_ACTIONBAR_MENU_MYFAVOR:
					startActivity(new Intent(HomeDetailActivity.this, LoginActivity.class));
					finish();
					break;
				case Constants.DETAIL_ACTIONBAR_MENU_HISTORY:
					startActivity(new Intent(HomeDetailActivity.this, LoginActivity.class));
					finish();
					break;
				case Constants.DETAIL_ACTIONBAR_MENU_HOME:
					startActivity(new Intent(HomeDetailActivity.this, HomeFragment.class));
					finish();
					break;

				default:
					break;
				}
				//关闭popupWindow
				popupWindow.dismiss();
				popupWindow = null;
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_detail, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.detail_tb_img_back:
			finish();
			break;
		case R.id.detail_tb_img_back_ol:
			finish();
			break;
		case R.id.detail_tb_img_share:
		case R.id.detail_tb_img_share_ol:
			// 简单分享(参考SupportV4的分享例子)
			ShareCompat.IntentBuilder b = ShareCompat.IntentBuilder.from(this);
			b.setType("text/plain").setText("I'm sharing!").startChooser();
			break;
		case R.id.detail_tb_img_more:
			showPopupWindow(tlbMore);
			break;
		case R.id.detail_tb_img_more_ol:
			showPopupWindow(tlbMoreol);
//			menu_press();
			break;
		case R.id.iv_vacation_detail_header_image:
			// PhotoView双击放大再双击缩小,单击退出效果
			startActivity(new Intent(this, ImageViewPagerActivity.class));
			break;

		case R.id.tv_vacation_detail_book: // 预定 -->日期选择 -->支付
			startActivity(new Intent(this, DateSelectionActivity.class));
			break;
		case R.id.ll_vacation_detail_date: // 日期选择
			startActivity(new Intent(this, DateSelectionActivity.class));
			break;
		case R.id.ll_vacation_detail_consultation: // Call Center客服咨询
			telphoneDialogNoTitle();
			break;

		default:
			break;
		}
	}
	
}
