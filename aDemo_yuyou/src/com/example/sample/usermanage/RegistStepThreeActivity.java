package com.example.sample.usermanage;

import com.example.sample.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import cn.bmob.v3.listener.SaveListener;

public class RegistStepThreeActivity extends Activity implements OnClickListener
{

	private EditText mEdPasswordInput;
//	private boolean isHidden;  // 保存密码的输入状态是否 可见或隐藏
	private ImageView mImgBack;
private Button mBtnRegistSubmit;
private String userPhone;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist_step_three);
		initUI();
	}

	private void initUI()
	{
		Intent intent = getIntent(); // 获得意图 传来用户手机号
		userPhone = intent.getStringExtra("phone");
		mImgBack = (ImageView) findViewById(R.id.img_regist_step_three_back_button);
		mEdPasswordInput = (EditText) findViewById(R.id.et_register_step_three_password_input); //用户输入新密码
		mBtnRegistSubmit = (Button) findViewById(R.id.btn_register_step_three_submit); // 提交按钮
		
		mImgBack.setOnClickListener(this);
		mEdPasswordInput.setOnClickListener(this);
		mBtnRegistSubmit.setOnClickListener(this); // 注册提交  监听
		
		
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id)
		{
		case R.id.img_regist_step_three_back_button: // 返回按钮 返回到登录界面
			startActivity(new Intent(RegistStepThreeActivity.this, LoginActivity.class));
			finish();
			break;
			//注册 提交
		case R.id.btn_register_step_three_submit:

			final User user= new User(userPhone, mEdPasswordInput.getText().toString());
			user.signUp(RegistStepThreeActivity.this,new SaveListener(){
				@Override
				public void onSuccess() {
					Toast.makeText(RegistStepThreeActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
					Intent intent=new Intent(RegistStepThreeActivity.this,LoginActivity.class);
					// 把密码通过隐式意图传到登陆界面
					intent.putExtra("password", mEdPasswordInput.getText().toString());
					startActivity(intent);
					try {
						Thread.sleep(2000);
						finish();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				@Override
				public void onFailure(int arg0, String arg1) {
					Toast.makeText(RegistStepThreeActivity.this, "注册失败"+arg0+arg1, Toast.LENGTH_SHORT).show();
				}
			} );
		
			break;
//		case R.id.img_register_step_three_hide_psd_switchbutton:
//			// 设置密码的输入状态是否 可见或隐藏
//			setPasswordisHide();
//			break;

		default:
			break;
		}
		
	}

//	// 已用自定义控件实现此功能
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
