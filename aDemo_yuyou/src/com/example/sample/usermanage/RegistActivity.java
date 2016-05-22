package com.example.sample.usermanage;

import org.json.JSONObject;

import com.example.sample.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.utils.SMSLog;

public class RegistActivity extends FragmentActivity implements OnClickListener
{
	// 填写从短信SDK应用后台注册得到的APPKEY
	private static String APPKEY = "11614b90bf07e";
	// 填写从短信SDK应用后台注册得到的APPSECRET
	private static String APPSECRET = "83b63dbb265b9b0fdffbe85a5388080c";

	private Button validateButton;
	private EditText phonEditText;
	public String phString;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist);
		initUI();
		iniSMSSDK();
	}

	private void initUI()
	{
		mImgBack = (ImageView) findViewById(R.id.img_regist_step_three_back_button);
		validateButton = (Button) findViewById(R.id.btn_register_phone_submit);
		phonEditText = (EditText) findViewById(R.id.et_register_phone_input);

		mImgBack.setOnClickListener(this);
		validateButton.setOnClickListener(this);
		phonEditText.setOnClickListener(this);

		/*
		 * validateButton2 = (Button)
		 * findViewById(R.id.btn_register_Captcha_submit); phonEditText2 =
		 * (EditText) findViewById(R.id.et_register_Captcha_input);
		 * validateButton2.setOnClickListener(this);
		 * phonEditText2.setOnClickListener(this);
		 */
	}

	private void iniSMSSDK()
	{
		SMSSDK.initSDK(this, APPKEY, APPSECRET, true);
		EventHandler eh = new EventHandler()
		{
			@Override
			public void afterEvent(int event, int result, Object data)
			{
				Message msg = new Message();
				msg.arg1 = event;
				msg.arg2 = result;
				msg.obj = data;
				mHandler.sendMessage(msg);
			}
		};
		SMSSDK.registerEventHandler(eh);
	}

	private Handler mHandler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			int event = msg.arg1;
			int result = msg.arg2;
			Object data = msg.obj;
			Log.e("event", "event=" + event);
			if (result == SMSSDK.RESULT_COMPLETE)
			{
				System.out.println("--------result" + event);
				// 短信注册成功后，返回MyTongChengActivity
				if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE)
				{// 提交验证码成功
					Toast.makeText(getApplicationContext(), "提交验证码成功", Toast.LENGTH_SHORT).show();

				} else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE)
				{
					// 已经验证
					Toast.makeText(getApplicationContext(), "验证码已经发送", Toast.LENGTH_SHORT).show();
				}

			} else
			{
				int status = 0;
				try
				{
					((Throwable) data).printStackTrace();
					Throwable throwable = (Throwable) data;

					JSONObject object = new JSONObject(throwable.getMessage());
					String des = object.optString("detail");
					status = object.optInt("status");
					if (!TextUtils.isEmpty(des))
					{
						Toast.makeText(RegistActivity.this, des, Toast.LENGTH_SHORT).show();
						return;
					}
				} catch (Exception e)
				{
					SMSLog.getInstance().w(e);
				}
			}

		};
	};
	private ImageView mImgBack;

	protected void onDestroy()
	{
		super.onDestroy();
		SMSSDK.unregisterAllEventHandler();
	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
		// 获取验证码
		case R.id.btn_register_phone_submit: 
			Log.e("onClick", "R.id.btn_register_phone_submit");
			if (!TextUtils.isEmpty(phonEditText.getText().toString()))
			{
				SMSSDK.getVerificationCode("86", phonEditText.getText().toString());
				phString = phonEditText.getText().toString();
				Intent intent = new Intent(this, RegistStepTwoActivity.class);
				intent.putExtra("phoneNum", phString);
				startActivity(intent);
			} else
			{
				Toast.makeText(this, "电话不能为空", 1).show();
			}
			break;

		/*
		 * case R.id.btn_register_Captcha_submit:
		 * 
		 * SMSSDK.submitVerificationCode("86", phString,
		 * phonEditText2.getText().toString());
		 * 
		 * break;
		 */
			// actionbar返回按钮
		case R.id.img_regist_step_three_back_button:
			finish();

			break;
		}

	}

}
