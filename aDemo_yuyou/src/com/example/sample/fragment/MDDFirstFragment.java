package com.example.sample.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.model.mudidi2.CellItem;
import com.example.model.mudidi2.GroupList;
import com.example.sample.DestinationFirstBannerActivity;
import com.example.sample.R;
import com.example.utils.ImageLoadUtils;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class MDDFirstFragment extends Fragment
{

	int[] mImageRes = new int[]
	{ R.drawable.ic_cell1, R.drawable.ic_cell2, R.drawable.ic_cell3};
	
	private int position;

	private ArrayList<GroupList> groupLists;

	private List<CellItem> cellItem2;


	
	public MDDFirstFragment()
	{
	}
	public MDDFirstFragment(int position, List<CellItem> cellItem2)
	{
//		this.position = position%3;
		this.position = position%cellItem2.size();
		this.cellItem2 = cellItem2;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View layout = inflater.inflate(R.layout.fragment_mddfirst, container, false);
//		position %= 3;
		ImageView mImgFirstBanner = (ImageView) layout.findViewById(R.id.img_mdd_banner1);
//		mImgFirstBanner.setImageResource(mImageRes[position]);
		
		CellItem bannerList = cellItem2.get(position);
//		List<CellItem> bannerList = groupLists.get(position).getCellItem();
		String cellImage = ((CellItem) bannerList).getCellImage();
		final String cellDirectUrl = ((CellItem) bannerList).getCellDirectUrl();
		final String cellTitle = ((CellItem) bannerList).getCellTitle();
		ImageLoadUtils.displayImage(getContext(), cellImage, mImgFirstBanner);
		
		mImgFirstBanner.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(getContext(), DestinationFirstBannerActivity.class);
				intent.putExtra("bannerUrl", cellDirectUrl);
				intent.putExtra("bannerTitle", cellTitle);
				startActivity(intent );
			}
		});
		
		return layout;
	}
}
