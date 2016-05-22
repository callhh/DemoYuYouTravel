package com.example.sample.fragment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.example.model.faxian.ThemeList;
import com.example.sample.HomeNearByActivity;
import com.example.sample.R;
import com.xinbo.utils.BitmapUtils;
import com.xinbo.utils.UILUtils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class FindBannerFragment extends Fragment
{

	private int position1;
	private ArrayList<ThemeList> themelist;
	private View layout;
	private LayoutInflater inflater;
	private ImageView mBannerImage;
	private TextView title;
	private TextView subTitle;
	private static final String FILE_PATH = Environment.getExternalStorageDirectory() + "/tongcheng/cache/";

	public FindBannerFragment(int position, ArrayList<ThemeList> themelist)
	{
		this.position1 = position % 2;
		this.themelist = themelist;

	}

	public FindBannerFragment()
	{

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		if (layout == null)
		{
			this.inflater = inflater;
			layout = inflater.inflate(R.layout.fragment_find_banner, container, false);
			iniUI();
			iniData();
		}
		return layout;
	}
	
	private void iniUI()
	{
		mBannerImage = (ImageView) layout.findViewById(R.id.tu_img);
		title = (TextView) layout.findViewById(R.id.Title);
		subTitle = (TextView) layout.findViewById(R.id.subTitle);
		
	}

	private void iniData()
	{
		String imageUrl = themelist.get(position1).getImageUrl();
		 UILUtils.displayImage(imageUrl, mBannerImage);
//		new ImgTask(tu_img).execute(imageUrl);
		title.setText(themelist.get(position1).getTitle());
		subTitle.setText(themelist.get(position1).getSubTitle());
		mBannerImage.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(getContext(), HomeNearByActivity.class);
				startActivity(intent );
			}
		});
	}


	class ImgTask extends AsyncTask<String, Void, Bitmap>
	{
		private ImageView imageView;

		public ImgTask(ImageView imageView)
		{
			this.imageView = imageView;
		}

		@Override
		protected void onPostExecute(Bitmap result)
		{
			imageView.setImageBitmap(result);
		}

		@Override
		protected Bitmap doInBackground(String... params)
		{
			Bitmap bitmap = download(params);
			return bitmap;
		}

		private Bitmap download(String... params)
		{
			FileOutputStream fos = null;
			InputStream is = null;
			try
			{
				URL url = new URL(params[0]);
				is = url.openStream();
				String filename = FILE_PATH + "aaa.jpg";
				File file = new File(filename);
				if (!file.exists())
				{
					file.getParentFile().mkdirs();
				}
				fos = new FileOutputStream(filename);
				byte[] buffer = new byte[1024];
				int len;
				while (-1 != (len = is.read(buffer)))
				{
					fos.write(buffer, 0, len);
				}
				Bitmap compressBmp = BitmapUtils.compressImageFromFile(filename);
				return compressBmp;

			} catch (MalformedURLException e)
			{
				e.printStackTrace();
			} catch (IOException e)
			{
				e.printStackTrace();
			} finally
			{
				if (is != null)
				{
					try
					{
						is.close();
					} catch (IOException e)
					{
						e.printStackTrace();
					}
				}
				if (fos != null)
				{
					try
					{
						fos.close();
					} catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			}
			return null;
		}

	}

}
