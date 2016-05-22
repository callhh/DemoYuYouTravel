package com.example.sample.usermanage;

import java.text.SimpleDateFormat;

import com.callhh.android.clearedittext.widget.ClearEditText;
import com.callhh.android.clearedittext.widget.PasswordIsHideEditText;
import com.example.sample.R;
import com.example.sample.fragment.MyTongChengFragment;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.demo.AccessTokenKeeper;
import com.sina.weibo.sdk.demo.WeiBoConstants;
import com.sina.weibo.sdk.exception.WeiboException;
import com.xinbo.utils.RegexValidateUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;
import cn.smssdk.SMSSDK;

public class LoginActivity extends FragmentActivity implements OnClickListener
{
	/**
	 * 微博SDK初始化建议放在启动页
	 */
	public static String APPID = "a9bdb76ca703caa2943f1f3d06f47baa";
	

	private TextView mTVRegist;
	private ImageView mImgBackButton;
	private TextView mTVLoginStatic;
	private TextView mTVLoginDynamic;
	private RelativeLayout mLoginModelStatic;
	private RelativeLayout mLoginModelDynamic;
	private ClearEditText mEdUser; // 静态登陆 用户(手机号或邮箱)
	private PasswordIsHideEditText mEdPasswordInput; // 静态登陆 密码
	private ClearEditText mLoginDynamicPhone,mLoginDynamicVerifyCode; // 动态登陆 手机号和验证码
	private String phString;
//	private ImageView mImgSwicthButton;
//	private boolean isHidden;  // 保存密码的输入状态是否 可见或隐藏
	private Button mBtnLoginStatic;
	private Button mBtnLoginDynamic;
	private TextView mTVDynamicSendCode;
	
	


	private ImageView mImgLoginWeiBo;
	/** 封装了 "access_token"，"expires_in"，"refresh_token"，并提供了他们的管理功能 */
	private Oauth2AccessToken mAccessToken;
	/** 注意：SsoHandler 仅当 SDK 支持 SSO 时有效 */
	private SsoHandler mSsoHandler;
	private AuthInfo mAuthInfo;


	
	public void toast(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		Bmob.initialize(getApplicationContext(), APPID);
		initUI();
		initWeiboSDK();
	}

	
	
	
	private void initUI()
	{
		mTVLoginStatic = (TextView) findViewById(R.id.tv_login_tab_static); //静态登陆模式
		mTVLoginStatic.setSelected(true);
		mTVLoginDynamic = (TextView) findViewById(R.id.tv_login_tab_dynamic); //动态登陆模式
		mTVRegist = (TextView) findViewById(R.id.tv_login_register);
		mImgBackButton = (ImageView) findViewById(R.id.img_login_back_button);
		mLoginModelStatic = (RelativeLayout) findViewById(R.id.layout_login_model_static); //静态模式登陆布局
		mLoginModelDynamic = (RelativeLayout) findViewById(R.id.layout_login_model_fast); //动态模式登陆布局
		
		mEdUser = (ClearEditText) findViewById(R.id.et_user_name); //静态手机号 输入框
		mEdPasswordInput = (PasswordIsHideEditText) findViewById(R.id.et_login_static_password_input); //静态密码 输入框
		mBtnLoginStatic = (Button) findViewById(R.id.btn_login_static_commit); // 静态登陆 提交
		
		/*-----------动态：无密码快捷登陆 start----------------*/
		mTVDynamicSendCode = (TextView) findViewById(R.id.tv_login_dynamic_code_send); //动态登陆-发送验证码
		mBtnLoginDynamic = (Button) findViewById(R.id.btn_login_dynamic_commit); // 动态登陆 提交按钮
		mLoginDynamicPhone = (ClearEditText) findViewById(R.id.et_login_dynamic_account_input); // 动态手机号2
		mLoginDynamicVerifyCode = (ClearEditText) findViewById(R.id.et_login_dynamic_verificationCode); //动态验证码
		
		/*-----------动态：无密码快捷登陆 stop----------------*/
		
		mTVLoginStatic.setOnClickListener(this);
		mTVLoginDynamic.setOnClickListener(this);
		mTVRegist.setOnClickListener(this); //注册按钮 监听
		mImgBackButton.setOnClickListener(this); // 登陆界面返回按钮监听事件
		mEdPasswordInput.setOnClickListener(this); //静态密码输入框监听
		mBtnLoginStatic.setOnClickListener(this); // 静态登陆监听事件
		mTVDynamicSendCode.setOnClickListener(this); // 动态登陆-发送验证码 监听事件
		mBtnLoginDynamic.setOnClickListener(this); // 动态登陆监听事件
		
		mImgLoginWeiBo = (ImageView) findViewById(R.id.iv_login_sina); //新浪登陆
		mImgLoginWeiBo.setOnClickListener(this); // weibo login
	}

	private void initWeiboSDK() {
		// 创建微博实例
		// mWeiboAuth = new WeiboAuth(this, Constants.APP_KEY,
		// Constants.REDIRECT_URL, Constants.SCOPE);
		// 快速授权时，请不要传入 SCOPE，否则可能会授权不成功
		mAuthInfo = new AuthInfo(this, WeiBoConstants.APP_KEY, WeiBoConstants.REDIRECT_URL, WeiBoConstants.SCOPE);
		mSsoHandler = new SsoHandler(this, mAuthInfo);
		

		// 从 SharedPreferences 中读取上次已保存好 AccessToken 等信息，
		// 第一次启动本应用，AccessToken 不可用
		mAccessToken = AccessTokenKeeper.readAccessToken(this);
		if (mAccessToken.isSessionValid()) {
			updateTokenView(true);
		}
	}

	/**
	 * 微博认证授权回调类。 1. SSO 授权时，需要在 {@link #onActivityResult} 中调用
	 * {@link SsoHandler#authorizeCallBack} 后， 该回调才会被执行。 2. 非 SSO
	 * 授权时，当授权结束后，该回调就会被执行。 当授权成功后，请保存该 access_token、expires_in、uid 等信息到
	 * SharedPreferences 中。
	 */
	class AuthListener implements WeiboAuthListener {

		@Override
		public void onComplete(Bundle values) {
			// 从 Bundle 中解析 Token
			mAccessToken = Oauth2AccessToken.parseAccessToken(values);
			// 从这里获取用户输入的 电话号码信息
			String phoneNum = mAccessToken.getPhoneNum();
			if (mAccessToken.isSessionValid()) {
				// 显示 Token
				updateTokenView(false);

				// 保存 Token 到 SharedPreferences
				AccessTokenKeeper.writeAccessToken(LoginActivity.this, mAccessToken);
				Toast.makeText(LoginActivity.this, R.string.weibosdk_demo_toast_auth_success, Toast.LENGTH_SHORT).show();
			} else {
				// 以下几种情况，您会收到 Code：
				// 1. 当您未在平台上注册的应用程序的包名与签名时；
				// 2. 当您注册的应用程序包名与签名不正确时；
				// 3. 当您在平台上注册的包名和签名与您当前测试的应用的包名和签名不匹配时。
				String code = values.getString("code");
				String message = getString(R.string.weibosdk_demo_toast_auth_failed);
				if (!TextUtils.isEmpty(code)) {
					message = message + "\nObtained the code: " + code;
				}
				Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
			}
		}

		@Override
		public void onCancel() {
			Toast.makeText(LoginActivity.this, R.string.weibosdk_demo_toast_auth_canceled, Toast.LENGTH_LONG).show();
		}

		@Override
		public void onWeiboException(WeiboException e) {
			Toast.makeText(LoginActivity.this, "Auth exception : " + e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}

	/**
	 * 显示当前 Token 信息。
	 * 
	 * @param hasExisted
	 *            配置文件中是否已存在 token 信息并且合法
	 */
	private void updateTokenView(boolean hasExisted) {
		String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
				.format(new java.util.Date(mAccessToken.getExpiresTime()));
		String format = getString(R.string.weibosdk_demo_token_to_string_format_1);
//		mTokenText.setText(String.format(format, mAccessToken.getToken(), date));

		String message = String.format(format, mAccessToken.getToken(), date);
		if (hasExisted)  // 如果已经存在
		{
			message = getString(R.string.weibosdk_demo_token_has_existed) + "\n" + message;
		}
//		mTokenText.setText(message);
	}


	/**
	 * 当 SSO 授权 Activity 退出时，该函数被调用。
	 * 
	 * @see {@link Activity#onActivityResult}
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		// SSO 授权回调
		// 重要：发起 SSO 登陆的 Activity 必须重写 onActivityResults
		if (mSsoHandler != null) {
			mSsoHandler.authorizeCallBack(requestCode, resultCode, data);
		}

	}
	
	// 静态登陆，验证用户输入账号名和密码是否合法
	private void loginStatic() {
		String account = mEdUser.getText().toString();
		if ("".equals(account)){
			mEdUser.setError("请输入手机号或邮箱");
			return;
		}
		//正则表达式 封装
		boolean isMobile = RegexValidateUtil.checkMobileNumber(account);
		boolean isEmail = RegexValidateUtil.checkEmail(account);
		if (!isMobile && !isEmail){
			mEdUser.setError("请输入正确的手机号或邮箱");
			return;
		}
		String password = mEdPasswordInput.getText().toString();
		if ("".equals(account)){
			mEdPasswordInput.setError("请输入密码");
			return;
		}
		boolean isValid = RegexValidateUtil.checkCharacter(password);
		if (!isValid){
			mEdPasswordInput.setError("请输入合法密码");
			return;
		}
		
		// 如果用户输入的账号和密码都是合法的，提交到服务器
		signIn(account, password);
		
	}
	
	// 动态登陆，验证用户输入账号名和密码是否合法
		private void loginDynamic() {
			String phone2 = mLoginDynamicPhone.getText().toString();
			if ("".equals(phone2)){
				mLoginDynamicPhone.setError("请输入手机号");
				return;
			}
			//正则表达式 封装
			boolean isMobile = RegexValidateUtil.checkMobileNumber(phone2);
			if (!isMobile){
				mLoginDynamicPhone.setError("请输入正确的手机号");
				return;
			}
			String verificationCode = mLoginDynamicVerifyCode.getText().toString();
			if ("".equals(verificationCode)){
				mLoginDynamicVerifyCode.setError("请输入验证码");
				return;
			}
			boolean isValid = RegexValidateUtil.checkCharacter(verificationCode);
			if (!isValid){  //判断是否合法
				mLoginDynamicVerifyCode.setError("请输入合法验证码");
				return;
			}
			
			// 如果用户输入的账号和密码都是合法的，提交到服务器
			signIn(phone2, verificationCode);
			
		}

	public void signIn(String account, String password) {
		final User user = new User(account, password);
		user.login(this, new SaveListener() {
			public void onSuccess() {
				toast("用户 :" + user.getUsername() + "已登陆成功!");
				finish();
			}

			@Override
			public void onFailure(int code, String msg) {
				toast("登陆失败,请重新输入!" + msg);
			}
		});
	}
	
	@Override
	public void onClick(View v)
	{
		int id = v.getId();
		Intent intent = new Intent();
		switch (id)
		{
		case R.id.img_login_back_button: // 登陆界面 返回按钮
			finish();
			break;
		case R.id.tv_login_tab_static: // 登陆界面 静态登陆（默认也是静态登陆）
			mLoginModelStatic.setVisibility(View.VISIBLE);
			mLoginModelDynamic.setVisibility(View.GONE);
			mTVLoginStatic.setSelected(true);
			mTVLoginDynamic.setSelected(false);
			break;
		case R.id.tv_login_tab_dynamic: // 登陆界面 动态登陆（无密码快捷登陆）
			mLoginModelStatic.setVisibility(View.GONE);
			mLoginModelDynamic.setVisibility(View.VISIBLE);
			mTVLoginStatic.setSelected(false);
			mTVLoginDynamic.setSelected(true);
			
			break;
			// 注册
		case R.id.tv_login_register:
//			Log.e("onClick", "R.id.tv_login_register");
			intent.setClass(this, RegistActivity.class);
			startActivity(intent);
			break;
			
		case R.id.btn_login_static_commit: // 静态登陆 提交
			loginStatic();
			break;
		case R.id.tv_login_dynamic_code_send:
			if (!TextUtils.isEmpty(mLoginDynamicPhone.getText().toString())) {
				Toast.makeText(this, "短信已发送至手机号 :" + mLoginDynamicPhone.getText().toString().trim(), 1).show();
				SMSSDK.getVerificationCode("86", mLoginDynamicPhone.getText().toString());
				phString = mLoginDynamicPhone.getText().toString();
			} else {
				Toast.makeText(this, "电话不能为空", 1).show();
			}
			break;

		case R.id.btn_login_dynamic_commit:// 动态登陆 提交
			loginDynamic();
//			SMSSDK.submitVerificationCode("86", phString, mLoginDynamicVerifyCode.getText().toString());

			break;
			//微博登陆认证  监听事件
		case R.id.iv_login_sina: 
			mSsoHandler.authorize(new AuthListener());
			
			break;
//		case R.id.img_register_step_three_hide_psd_switchbutton:
//			Log.e("onClick", "密码显示或隐藏");
//			// 设置密码的输入状态是否 可见或隐藏
//			setPasswordisHide();
//			break;

		default:
			break;
		}
		
	}

	
//	private void setPasswordisHide()
//	{
//		 if (isHidden) {
//             //设置EditText文本为可见的
//			 mEdPasswordInput.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//			 mImgSwicthButton.setImageResource(R.drawable.icon_password_show);
//         } else {
//             //设置EditText文本为隐藏的
//        	 mEdPasswordInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
//        	 mImgSwicthButton.setImageResource(R.drawable.icon_password_hide);
//         }
//         isHidden = !isHidden;
//         mEdPasswordInput.postInvalidate();
//         //切换后将EditText光标置于末尾
//         CharSequence charSequence = mEdPasswordInput.getText();
//         if (charSequence instanceof Spannable) {
//             Spannable spanText = (Spannable) charSequence;
//             Selection.setSelection(spanText, charSequence.length());
//         }
//
//	}
	
	
}
