package cn.bxw1.bxapp.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.iflytek.cloud.SpeechUtility;
import com.jude.utils.JUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import cn.bxw1.bxapp.myapplication.R;

public class DemoApp extends Application{
	public static final String SERVER = "http://192.168.1.8:8080/bxwShopINF/";
	public static final String ACTION_LOGIN = "login";
	public static final String ACTION_REGIST = "app/member/register.do";
	public static final String ACTION_LOGOUT = "logout";
	public static final String ACTION_GETVCODE = "sms/getVercode.do";
	public static final String ACTION_REPASS = "mod_password";
	public static final String ACTION_SIGN = "sign";
	public static final String ACTION_HIS = "getSignMonthDetail";
	public static Context context;
	public static String json;
	@Override
	public void onCreate() {
		super.onCreate();
		
		SpeechUtility.createUtility(this, "appid=" + getString(R.string.app_id));
		JUtils.initialize(this);
		Fresco.initialize(this);
		DemoApp.context = getApplicationContext();
		json = null;
		ZXingLibrary.initDisplayOpinion(this);

		Log.e("TAG", "完成声纹初始化！");
	}
}
