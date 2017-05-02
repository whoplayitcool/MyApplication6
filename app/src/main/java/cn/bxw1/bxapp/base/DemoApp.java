package cn.bxw1.bxapp.base;

import android.app.Application;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.iflytek.cloud.SpeechUtility;
import com.jude.utils.JUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import cn.bxw1.bxapp.myapplication.R;

public class DemoApp extends Application{
	@Override
	public void onCreate() {
		super.onCreate();
		
		SpeechUtility.createUtility(this, "appid=" + getString(R.string.app_id));
		JUtils.initialize(this);
		Fresco.initialize(this);
		ZXingLibrary.initDisplayOpinion(this);

		Log.e("TAG", "完成声纹初始化！");
	}
}
