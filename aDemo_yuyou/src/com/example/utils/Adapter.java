package com.example.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.sample.R;


public class Adapter {

	public Adapter() {

	}

public static List<Map<String, Object>> getspinner3data() {
		List<Map<String, Object>> spinnerdata3 = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("icon", R.drawable.icon_indicator_hotel_keyword_administration);
		map.put("listname", "我的收藏");
		spinnerdata3.add(map);

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("icon", R.drawable.icon_indicator_hotel_keyword_history);
		map2.put("listname", "浏览历史");
		spinnerdata3.add(map2);
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("icon", R.drawable.icon_indicator_hotel_keyword_hotspot);
		map3.put("listname", "鱼游首页");
		spinnerdata3.add(map3);

		return spinnerdata3;

	}

}
