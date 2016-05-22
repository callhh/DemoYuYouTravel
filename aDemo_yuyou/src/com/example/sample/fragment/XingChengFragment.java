package com.example.sample.fragment;

import java.util.ArrayList;
import java.util.List;

import com.android.volley.VolleyError;
import com.example.model.xingcheng.RecommendList;
import com.example.model.xingcheng.Xingcheng;
import com.example.sample.R;
import com.example.sample.XcWebActivity;
import com.example.utils.Constants;
import com.gc.materialdesign.views.ButtonFloat;
import com.xinbo.utils.GsonUtils;
import com.xinbo.utils.HTTPUtils;
import com.xinbo.utils.ToastUtils;
import com.xinbo.utils.UILUtils;
import com.xinbo.utils.VolleyListener;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author 行程界面
 */
public class XingChengFragment extends Fragment implements OnClickListener
{

	public XingChengFragment()
	{
		// Required empty public constructor
	}

	private LayoutInflater mInflater;
	private View layout;
	private ListView mListView;
	private List<RecommendList> mListData = new ArrayList<RecommendList>();
	private ListViewAdapter mAdapter;
	private int color = Color.parseColor("#2ebd59");
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		if (layout == null)
		{
			mInflater = inflater;
			initUI(inflater);
			initData();
		}
		return layout;
	}


	private void initData()
	{
		HTTPUtils.get(getActivity(), Constants.Url.XINGCHENG, new VolleyListener()
		{

			@Override
			public void onResponse(String arg0)
			{
				Xingcheng xingcheng = GsonUtils.parseJSON(arg0, Xingcheng.class);
				List<RecommendList> recommendList = xingcheng.getResponse().getBody().getRecommendList();
				// TODO 探索 · 旅行灵感
				String tansuo = xingcheng.getResponse().getBody().getTravelAssistanttitle();
				mListData.addAll(recommendList);
				mListView.setOnItemClickListener(new ListViewOnItemClickListener());
				mListView.setAdapter(mAdapter);
				mAdapter.notifyDataSetChanged();
			}

			@Override
			public void onErrorResponse(VolleyError arg0)
			{
				Log.e("onErrorResponse", "Error = :" + arg0.getMessage());
			}
		});
	}

	@SuppressLint("InflateParams")
	private void initUI(LayoutInflater inflater)
	{
		layout = mInflater.inflate(R.layout.fragment_xing_cheng, null);
		// FloatActionButton 动画弹出按钮
		ButtonFloat fankui_ButtonFloat = (ButtonFloat) layout.findViewById(R.id.buttonFloat_xingcheng);
		fankui_ButtonFloat.setBackgroundColor(color);
		fankui_ButtonFloat.setOnClickListener(this);
		
		mListView = (ListView) layout.findViewById(R.id.listView1);
		View header_login = inflater.inflate(R.layout.header_xc, null);
		mListView.addHeaderView(header_login, null, false);
		mAdapter = new ListViewAdapter();
	}

	private final class ListViewOnItemClickListener implements OnItemClickListener
	{
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id)
		{
			Intent intent = new Intent(getActivity(), XcWebActivity.class);

			String jumpUrl = mListData.get(position - 1).getJumpUrl();
			intent.putExtra(Constants.IntentKey.INTENT_XC_WEB, jumpUrl);

			startActivity(intent);
		}
	}

	class ListViewAdapter extends BaseAdapter
	{

		private ImageView img_icon;
		private TextView tv_Title;
		private TextView tv_Subtitle;

		@Override
		public int getCount()
		{
			return mListData.size();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			View layout = mInflater.inflate(R.layout.xingcheng_listitem, null);
			img_icon = (ImageView) layout.findViewById(R.id.img_xc_list_icon);
			tv_Title = (TextView) layout.findViewById(R.id.tv_xc_list_title);
			tv_Subtitle = (TextView) layout.findViewById(R.id.tv_xc_list_subtitle);
			// 解决OOM
			// new ImgTask(mimg_url).execute(recommendList.getImgUrl());
			UILUtils.displayImage(mListData.get(position).getImgUrl(), img_icon);
			tv_Title.setText(mListData.get(position).getMainTitle());
			tv_Subtitle.setText(mListData.get(position).getSubTitle());
			return layout;
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

	@Override
	public void onClick(View v) {
		// TODO 
		int id = v.getId();
		switch (id) {
		case R.id.buttonFloat_xingcheng:
			ToastUtils.showToast(getContext(), "hello , buttonFloat !");
			break;

		default:
			break;
		}
		
	}

}
