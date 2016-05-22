package com.example.sample;

import com.example.utils.Constants;
import com.xinbo.upgrade.UpgradeUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AboutYuYouActivity extends Activity implements OnClickListener
{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_yu_you);
		initUI();
	}
		private void initUI() {
			ImageView mImgBack = (ImageView) findViewById(R.id.img_weishequ_back);
			mImgBack.setOnClickListener(this);
			ImageView mImgShare = (ImageView) findViewById(R.id.img_about_yuyou_share);
			mImgShare.setOnClickListener(this);
			LinearLayout layout_DesCa = (LinearLayout) findViewById(R.id.ll_gytc);
			layout_DesCa.setOnClickListener(this);
			LinearLayout layout_Upgrade = (LinearLayout) findViewById(R.id.ll_more_update);
			layout_Upgrade.setOnClickListener(this);
		}
		
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.img_weishequ_back:
				finish();
				break;
			case R.id.img_about_yuyou_share:
				// 简单分享(参考SupportV4的分享例子) ，因为mob分享在使用中会和mob短信验证起冲突
				ShareCompat.IntentBuilder b = ShareCompat.IntentBuilder.from(this);
				b.setType("text/plain").setText("I'm sharing!").startChooser();
				break;
			// 关于公司介绍
			case R.id.ll_gytc:
				Intent intent= new Intent(this,AboutCompanyActivity.class);
				startActivity(intent);
				// 第一个参数是当前activity退出时的动画，第二个参数则是要跳转的activity进入时动画
				overridePendingTransition(R.anim.activity_open_enter,R.anim.activity_close_exit);
		
				break;
				
				//检查更新
			case R.id.ll_more_update:
				UpgradeUtils.checkUpgrade(this, Constants.Url.APK_UPGRADEAPK); 
				break;
				
			default:
				break;
			}
		}
	
	
}
