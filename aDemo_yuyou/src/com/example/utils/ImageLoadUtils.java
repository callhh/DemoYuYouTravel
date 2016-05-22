package com.example.utils;

import com.example.database.utils.PreferenceUtils;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.xinbo.utils.ConnectionUtils;
import com.xinbo.utils.UILUtils;

import android.content.Context;
import android.widget.ImageView;

public class ImageLoadUtils {
	/**
	 * 优化前下载图片的条件
	 * 
	 * 如果wifionly被选中，下载图片的条件为： 1) 当前联网类型为WIFI 或者 2) 有缓存
	 * 如果如果wifionly未选中，下载图片的条件为： 1) 当前有网 或者 2) 有缓存
	 */
	/**
	 * 优化后下载图片的条件
	 * 
	 * 1) 有缓存 或者 2) wifionlyselected && isWIFI 或者 3) wifionlyunselected &&
	 * isConnected
	 */
	public static void displayImage(Context context, String imgUrl, ImageView mImageView) {
		// 获得UIL库的缓存对象
		DiskCache diskCache = ImageLoader.getInstance()
			.getDiskCache();
		// diskCache.get(imgUrl)返回非null则有缓存
		boolean hasCache = diskCache.get(imgUrl) != null;
		// 获得用户设置仅wifi下载图片选项的值
		boolean wifionlyselected = PreferenceUtils.readWIFIOnly(context);
		// 判断当前网络类型是否是WIFI
		boolean isWIFI = ConnectionUtils.isWIFI(context);
		// genymotion模拟器联网状态默认是wifi，为了测试，将变量改为false，模拟手机网络
		// boolean isWIFI = true;
		// 判断当前是否联网
		boolean isConnected = ConnectionUtils.isConnected(context);
		boolean condition1 = hasCache;
		boolean condition2 = wifionlyselected && isWIFI;
		boolean condition3 = !wifionlyselected && isConnected;
		if (condition1 || condition2 || condition3) {
			UILUtils.displayImage(imgUrl, mImageView);
		}
	}

}
