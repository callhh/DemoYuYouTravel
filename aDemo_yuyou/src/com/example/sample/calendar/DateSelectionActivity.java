package com.example.sample.calendar;

import com.alipay.sdk.app.PayTask;
import com.example.sample.R;
import com.example.sample.calendar.AddAndSubView.OnNumChangeListener;
import com.example.utils.PayResult;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DateSelectionActivity extends AppCompatActivity implements android.view.View.OnClickListener
{

	private static final int SDK_PAY_FLAG = 1;
	private TextView textView2;
	private CalendarDay DataTime;
	private int priceChild = 0; // 儿童票 默认值
	private int priceAdult = 1; // 成人票 默认值
	private int SubNum;
	private Button mBtnPayNow;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_date_selection);
		iniUI();

	}

	private void iniUI()
	{
		textView2 = (TextView) findViewById(R.id.textView2);
		LinearLayout LinearView = (LinearLayout) findViewById(R.id.LinearView);
		LinearLayout LinearLayout01 = (LinearLayout) findViewById(R.id.LinearLayout01);
		ImageView day_exit = (ImageView) findViewById(R.id.day_exit);
		day_exit.setOnClickListener(this);
		final AddAndSubView addAndSubView1 = new AddAndSubView(DateSelectionActivity.this, 0);
		final AddAndSubView addAndSubView2 = new AddAndSubView(DateSelectionActivity.this, 1);
		MaterialCalendarView calendarView = (MaterialCalendarView) findViewById(R.id.calendarView);
		calendarView.setOnDateChangedListener(new OnDateSelectedListener()
		{
			@Override
			public void onDateSelected(MaterialCalendarView widget, CalendarDay date, boolean selected)
			{
				DataTime = date;
				textView2.setText("当前日期：" + date);
			}
		});
		addAndSubView1.setOnNumChangeListener(new OnNumChangeListener()
		{
			@Override
			public void onNumChange(View view, int num)
			{
				// 儿童票数
				priceChild = num;
			}
		});
		addAndSubView2.setOnNumChangeListener(new OnNumChangeListener()
		{

			@Override
			public void onNumChange(View view, int num)
			{
				// 成人票数
				priceAdult = num;
			}
		});
		LinearView.addView(addAndSubView1);
		LinearLayout01.addView(addAndSubView2);
		mBtnPayNow = (Button) findViewById(R.id.btn_paynow);
		mBtnPayNow.setOnClickListener(this);
	}

	private void payNow()
	{
		if (DataTime == null)
		{
			Toast.makeText(DateSelectionActivity.this, "请先选择日期!", Toast.LENGTH_SHORT).show();
		} else
		{
			if (priceChild == 0 && priceAdult == 1)
			{
				new AlertDialog.Builder(DateSelectionActivity.this).setTitle("订单确认")
						.setMessage("1.您的下单时间：" + DataTime + "\n" + "2.总金额为:" + 2999 + "元")
						.setPositiveButton("取消", null).setNegativeButton("支付", new OnClickListener()
						{
							@Override
							public void onClick(DialogInterface dialog, int which)
							{
								// TODO 传给服务端三个参数：商品名称、详情和价格
								// 服务端返回完整的符合支付宝参数规范的订单信息
								final String payInfo = "partner=\"2088101568358171\"&seller_id=\"xxx@alipay.com\"&out_trade_no=\"0819145412-6177\"&subject=\"测试\"&body=\"测试测试\"&total_fee=\"0.01\"&notify_url=\"http://notify.msp.hk/notify.htm\"&service=\"mobile.securitypay.pay\"&payment_type=\"1\"&_input_charset=\"utf-8\"&it_b_pay=\"30m\"&sign=\"lBBK%2F0w5LOajrMrji7DUgEqNjIhQbidR13GovA5r3TgIbNqv231yC1NksLdw%2Ba3JnfHXoXuet6XNNHtn7VE%2BeCoRO1O%2BR1KugLrQEZMtG5jmJIe2pbjm%2F3kb%2FuGkpG%2BwYQYI51%2BhA3YBbvZHVQBYveBqK%2Bh8mUyb7GM1HxWs9k4%3D\"&sign_type=\"RSA\"";
								pay(payInfo);
							}
						}).show();
				return;
			}
			window();// 对话框
		}

	}

	private void window()
	{
		Toast.makeText(DateSelectionActivity.this, "tanchu Dialog", Toast.LENGTH_SHORT).show();
		new AlertDialog.Builder(DateSelectionActivity.this)
		.setTitle("订单确认")
				.setMessage(
						"1.您的下单时间：" + DataTime + "\n" + "2.总金额为:" + ((priceChild * 2799) + (priceAdult * 2999)) + "元")
				.setPositiveButton("取消", null).setNegativeButton("支付", new OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						// TODO 传给服务端三个参数：商品名称、详情和价格
						// 服务端返回完整的符合支付宝参数规范的订单信息
						final String payInfo = "partner=\"2088101568358171\"&seller_id=\"xxx@alipay.com\"&out_trade_no=\"0819145412-6177\"&subject=\"测试\"&body=\"测试测试\"&total_fee=\"0.01\"&notify_url=\"http://notify.msp.hk/notify.htm\"&service=\"mobile.securitypay.pay\"&payment_type=\"1\"&_input_charset=\"utf-8\"&it_b_pay=\"30m\"&sign=\"lBBK%2F0w5LOajrMrji7DUgEqNjIhQbidR13GovA5r3TgIbNqv231yC1NksLdw%2Ba3JnfHXoXuet6XNNHtn7VE%2BeCoRO1O%2BR1KugLrQEZMtG5jmJIe2pbjm%2F3kb%2FuGkpG%2BwYQYI51%2BhA3YBbvZHVQBYveBqK%2Bh8mUyb7GM1HxWs9k4%3D\"&sign_type=\"RSA\"";
						pay(payInfo);
					}
				}).show();
	}

	private void pay(final String payInfo)
	{
		new Thread()
		{
			public void run()
			{
				// 构造PayTask 对象
				PayTask alipay = new PayTask(DateSelectionActivity.this);
				// 调用支付接口，获取支付结果
				String result = alipay.pay(payInfo, true);

				Message msg = new Message();
				msg.what = SDK_PAY_FLAG;
				msg.obj = result;
				mHandler.sendMessage(msg);
			}
		}.start();
	}

	private Handler mHandler = new Handler()
	{
		@SuppressWarnings("unused")
		public void handleMessage(Message msg)
		{
			switch (msg.what)
			{
			case SDK_PAY_FLAG:
			{
				PayResult payResult = new PayResult((String) msg.obj);
				/**
				 * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
				 * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
				 * docType=1) 建议商户依赖异步通知
				 */
				String resultInfo = payResult.getResult();// 同步返回需要验证的信息

				String resultStatus = payResult.getResultStatus();
				// 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
				if (TextUtils.equals(resultStatus, "9000"))
				{
					Toast.makeText(DateSelectionActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
				} else
				{
					// 判断resultStatus 为非"9000"则代表可能支付失败
					// "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
					if (TextUtils.equals(resultStatus, "8000"))
					{
						Toast.makeText(DateSelectionActivity.this, "支付结果确认中", Toast.LENGTH_SHORT).show();

					} else
					{
						// 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
						Toast.makeText(DateSelectionActivity.this, "支付失败", Toast.LENGTH_SHORT).show();

					}
				}
				break;
			}
			default:
				break;
			}
		};
	};

	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.day_exit:
			finish();
			break;
		case R.id.btn_paynow:
			payNow();
			break;

		default:
			break;
		}
	}
}
