package com.example.sample.fragment;

import com.example.sample.AboutYuYouActivity;
import com.example.sample.HelpAndFeedbackActivity;
import com.example.sample.R;
import com.example.sample.SettingActivity;
import com.example.sample.WeiSheQuActivity;
import com.example.sample.usermanage.LoginActivity;
import com.example.sample.usermanage.User;
import com.umeng.analytics.MobclickAgent;
import com.zxing.activity.CaptureActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.BmobUser;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class MyTongChengFragment extends Fragment implements OnClickListener
{

	private View layout;
	private LayoutInflater inflater;
	private RelativeLayout mLayout_MyTC_Login,mLayoutMyWallet,mLayoutAllOrders;
	private ImageView mImgQR_Code;
	private ImageView mImgLoginTX;
	private TextView mTvLoginToast;
	private RelativeLayout mLayoutSheQu, mLayoutGuwen, mLayoutWeiDian;
	private RelativeLayout mLayouComment,mLayouMyFavor,mLayouBrowsingHistory,mLayouCommonInfo;
	private RelativeLayout mLayouSetting,mLayouFeedback,mLayouTiYanDian,mLayouAboutYuyou;

	public MyTongChengFragment()
	{
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{

		if (layout == null)
		{
			initUI(inflater, container);

		}
		return layout;
	}

	@Override
	public void onStart()
	{
		super.onStart();
		User myUser = BmobUser.getCurrentUser(getActivity(), User.class);
		if (myUser == null)
		{
			mTvLoginToast.setText("您还没有登录,点击登录");
			mImgLoginTX.setImageResource(R.drawable.travel_xb_head);
		} else
		{
			mImgLoginTX.setImageResource(R.drawable.icon_abouttongcheng_common);
			mTvLoginToast.setText(myUser.getUsername());
		}
	}

	private void initUI(LayoutInflater inflater, ViewGroup container)
	{
		this.inflater = inflater;
		layout = inflater.inflate(R.layout.fragment_my_tong_cheng, container, false);
		mLayout_MyTC_Login = (RelativeLayout) layout.findViewById(R.id.layout_my_login); // 登陆
		mTvLoginToast = (TextView) layout.findViewById(R.id.tv_my_login_toast); // Textview登陆提示
		mImgLoginTX = (ImageView) layout.findViewById(R.id.img_my_head_portrait); // 登陆头像
		mLayoutAllOrders = (RelativeLayout) layout.findViewById(R.id.layout_my_all_orders); // 全部订单
		mLayoutMyWallet = (RelativeLayout) layout.findViewById(R.id.layout_my_wallet_button); // 我的钱包

		mLayoutSheQu = (RelativeLayout) layout.findViewById(R.id.layout_yuyou_bbs); // 鱼游 微社区
		mLayoutGuwen = (RelativeLayout) layout.findViewById(R.id.layout_yuyou_guwen); // 鱼游 顾问
		mLayoutWeiDian = (RelativeLayout) layout.findViewById(R.id.layout_yuyou_vshop); // 鱼游 微店
		mLayouComment = (RelativeLayout) layout.findViewById(R.id.layout_my_comment); // 我的点评
		mLayouCommonInfo = (RelativeLayout) layout.findViewById(R.id.layout_common_info); // 常用信息
		mLayouMyFavor = (RelativeLayout) layout.findViewById(R.id.layout_my_favor); // 我的收藏
		mLayouBrowsingHistory = (RelativeLayout) layout.findViewById(R.id.layout_browsing_history); // 浏览历史
		
		mLayouSetting = (RelativeLayout) layout.findViewById(R.id.layout_setting); // 设置
		mLayouFeedback = (RelativeLayout) layout.findViewById(R.id.layout_help_or_feedback); // 帮助与反馈
		mLayouTiYanDian = (RelativeLayout) layout.findViewById(R.id.layout_yuyou_tiyan_shop); // 鱼游 tiyan店
		mLayouAboutYuyou = (RelativeLayout) layout.findViewById(R.id.layout_about_yuyou); // 关于鱼旅

		mImgQR_Code = (ImageView) layout.findViewById(R.id.img_my_qr_code); // 二维码
		mLayout_MyTC_Login.setOnClickListener(this);
		mImgQR_Code.setOnClickListener(this); // 二维码监听
		
		mLayoutAllOrders.setOnClickListener(this); // 我的钱包
		mLayoutMyWallet.setOnClickListener(this); // 我的钱包

		mLayoutSheQu.setOnClickListener(this);
		mLayoutGuwen.setOnClickListener(this);
		mLayoutWeiDian.setOnClickListener(this);
		mLayouTiYanDian.setOnClickListener(this);
		
		mLayouComment.setOnClickListener(this);
		mLayouCommonInfo.setOnClickListener(this);
		mLayouMyFavor.setOnClickListener(this);
		mLayouBrowsingHistory.setOnClickListener(this);
		
		mLayouSetting.setOnClickListener(this);
		mLayouFeedback.setOnClickListener(this);
		mLayouAboutYuyou.setOnClickListener(this);

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		// 处理扫描结果（在界面上显示）
		if (resultCode == Activity.RESULT_OK)
		{
			Bundle bundle = data.getExtras();
			String scanResult = bundle.getString("result");
			// mTextView.setText(scanResult);
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
	public void onClick(View v)
	{
		int id = v.getId();
		Intent intent = new Intent();
		switch (id)
		{
		case R.id.layout_my_login: // 登陆
			User myUser = BmobUser.getCurrentUser(getActivity(), User.class);
			if (myUser == null)
			{
				// 如果没登录,就跳转登录注册界面
				intent.setClass(getContext(), LoginActivity.class);
				startActivity(intent);
			} else
			{
				mTvLoginToast.setText(myUser.getUsername());
				// TODO 如果登录了就跳转到用户个人信息界面
				// Intent intentUserInfo = new Intent(getActivity(),
				// UserInfoActivity.class);
				// startActivity(intentUserInfo);
			}

			break;
		case R.id.img_my_qr_code: // 扫描二维码
			// 打开扫描界面扫描条形码或二维码
			Intent openCameraIntent = new Intent(getContext(), CaptureActivity.class);
			startActivityForResult(openCameraIntent, 0);
			break;
		case R.id.layout_my_all_orders: // 全部订单
			intent.setClass(getContext(), LoginActivity.class);
			startActivity(intent);
			
			break;
		case R.id.layout_my_wallet_button: // 我的钱包
			intent.setClass(getContext(), LoginActivity.class);
			startActivity(intent);
			
			break;
		case R.id.layout_yuyou_bbs: // 鱼游微社区
			intent.setClass(getContext(), WeiSheQuActivity.class);
			startActivity(intent);
			// 第一个参数是当前activity退出时的动画，第二个参数则是要跳转的activity进入时动画
//			overridePendingTransition(R.anim.activity_open_enter,R.anim.activity_close_exit);
			
			break;
		case R.id.layout_yuyou_guwen: // 鱼游顾问
			intent.setClass(getContext(), WeiSheQuActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_yuyou_vshop: // 鱼游微店
			intent.setClass(getContext(), WeiSheQuActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_yuyou_tiyan_shop: // 鱼游体验店
			intent.setClass(getContext(), WeiSheQuActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_my_comment: // 我的点评
			intent.setClass(getContext(), LoginActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_common_info: // 常用信息
			intent.setClass(getContext(), LoginActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_my_favor: // TODO 我的收藏
			Toast.makeText(getContext(), "暂时没有收藏", Toast.LENGTH_SHORT).show();
			break;
		case R.id.layout_browsing_history: // 浏览历史
			intent.setClass(getContext(), LoginActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_setting: // 设置
			intent.setClass(getContext(), SettingActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_help_or_feedback: // 帮助与反馈
			intent.setClass(getContext(), HelpAndFeedbackActivity.class);
			startActivity(intent);
			break;
		case R.id.layout_about_yuyou: // 关于TC鱼旅
			intent.setClass(getContext(), AboutYuYouActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

}
