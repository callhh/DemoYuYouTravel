package com.example.utils;


//常量、静态内部类 ---> 整理分类 后期优化数据 
public class Constants
{

	public static final int TELPHONE_KEFU = 0;//客服服务
	public static final int TELPHONE_DEMESTIC_USER = 1;//国内用户
	public static final int TELPHONE_FOREIGN_USER = 2; //国外用户
	public static final int DETAIL_ACTIONBAR_MENU_MYFAVOR = 0; //我的收藏
	public static final int DETAIL_ACTIONBAR_MENU_HISTORY = 1;//浏览历史
	public static final int DETAIL_ACTIONBAR_MENU_HOME = 2; //TC鱼游首页
	public static final int PROGRESS_MAX = 100; //总进度
	
	public static final class Url
	{
//		public static final String HOST = "http://169.254.184.76:8080/tongcheng_server/";
		
		// 七牛云端存储数据
		public static final String HOST = "http://7xt68a.com2.z0.glb.clouddn.com/";
		public static final String HOME_HEADER1 = HOST + "home_header1.txt"; // 首页第一个headerView
		// 首页第2个headerView 快乐长假数据
		public static final String HOME_HEADER2_LONGHOLIDAYS = HOST + "home_header2_kuailechangjia.txt"; 
		// 首页第2个headerView 快乐短途数据
		public static final String HOME_HEADER2_SHORT_TRIP = HOST + "home_header2_kuaileduantu.txt"; 
		// 首页第2个headerView 快乐周末数据
		public static final String HOME_HEADER2_WEEKS_HAPPY = HOST + "home_header2_kuailezhoumo.txt";
		
		public static final String DESTINATION1 = HOST + "mudidi.txt"; // 目的地 左边Listview
		public static final String DESTINATION2 = HOST + "mudidi2.txt"; // 目的地 右边Listview
		public static final String FIND = HOST + "faxian.txt"; // 发现
		public static final String XINGCHENG = HOST + "xingcheng.txt"; // 行程
		public static final String MY = HOST + "mine.txt"; // 我的 页面
		
		
		public static final String MINE_SHEQU = "http://appnew.ly.com/wsq/"; // 微社区
//		public static final String MINE_SHEQU = "http://m.ly.com/selftrip/"; // 微社区
		public static final String MINE_DESCRIPTIONCOMPANY = "http://m.17u.cn/client/General/CompanyIntroduction"; //关于同程 公司介绍
		public static final String HOME_VISA = "http://m.ly.com/visa/"; //帮助与反馈
		public static final String HOME_MOVIE_TICKET = "http://m.ly.com/movie/"; //首页电影票
		public static final String HOME_PANIC_BUYING = "http://m.ly.com/panicbuying"; //抢购
		public static final String HOME_NEARBY = "http://zby.ly.com/zizhuyou/huodong.html"; //在身边
		
		public static final String HOME_SPRING_OUTING = "http://www.yiqiyou.com/pub/TCTripDay/main/index?channelid=89&cityid=tcwvscid&wvc1=1&wvc2=1&tcwvcwl&shareTag=wxfx"; //春游特惠
		public static final String HOME_TC_ZHUANXIAN = "http://app.ly.com/pub/apptopic/SpeciallyLine/index?channelid=22&cityId=tcwvcid&citysId=tcwvscid&wvc1=1&wvc2=1&tcwvcwl"; //TC专线
		public static final String HOME_TICKET_VIP = "http://m.ly.com/scenery/"; //有票专享
		public static final String HOME_SUPER_PLAYER = "http://www.yiqiyou.com/pub/Talent/Talent/index?sortid=4&channelid=136&wvc1=1&wvc2=1&cityId=tcwvcid&citysId=tcwvscid&tcwvcwl"; //超级玩咖
		public static final String HOME_TEN_YUAN = "http://qianggou.ly.com/zzyapp/firstpage.aspx?channelid=137&wvc1=1&wvc2=1"; //十元
		public static final String HOME_ONE_HUNDRED_YUAN = "http://m.ly.com/guoneiyou/zhuanti/temai?channelid=138&wvc1=1&wvc2=1"; //百元
		public static final String HOME_SALE = "http://m.ly.com/dujia/zhuanti/miaosha.html?channelid=139&memberId=tcwvmid&wvc1=1&wvc2=1"; //特卖
		public static final String HOME_CRUISE_SALE = "http://m.ly.com/youlun/cruisesale?channelid=154&lid=63&wvc1=1&wvc2=1"; //邮轮
		
		public static final String DESTINATION_XIAMEN = "http://m.ly.com/destination/toprecommended?city_name=%E5%8E%A6%E9%97%A8"; //帮助与反馈
		public static final String MINE_HELP = "http://m.ly.com/help/index.html"; //帮助与反馈
		public static final String APK_UPGRADEAPK = "http://7xszlf.com2.z0.glb.clouddn.com/upgradeapk.txt";
		
		
	}
	
	
	public static final class IntentFilter {
		public static final String UPDATA_OVERLAY_TAB1 = "overlay_tab1";
		public static final String UPDATA_OVERLAY_TAB2 = "overlay_tab2";
		public static final String UPDATA_OVERLAY_TAB3 = "overlay_tab3";
		
	}
	public static final class IntentKey {
		public static final String INTENT_XC_WEB = "listview_url";
		public static final String BANNER_POSITION_URL = "banner_position_url";
		public static final String HOMESECOND_PAGER_POSITION_URL = "homesecond_pager_position_url";
		public static final String HOMESECOND_PAGER_TITLE = "homesecond_pager_title";
		
	}
	
	
}
