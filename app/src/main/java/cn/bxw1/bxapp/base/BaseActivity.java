package cn.bxw1.bxapp.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONObject;

import cn.bxw1.bxapp.utils.ThreadPoolManager;
import cn.bxw1.bxapp.utils.Tools;
import cn.bxw1.bxapp.vo.RequestVo;


public class BaseActivity extends Activity {

	private static final String TAG = "BaseActivity";
	private static final int NONETWORK = 0;
	private static final int COMPLETE = 1;
	private static final int NOCONTENT = 2;
	protected ProgressDialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e(TAG, "BaseActivity.class :: onCreate()");

	}

	protected JSONObject getDataFromServer(RequestVo requestVo, DataCallBack<JSONObject> callBack) {
		BaseHandler handler = new BaseHandler(callBack);
		BaseTask task = new BaseTask(requestVo, handler);
		ThreadPoolManager.getInstance().execute(task);
		return null;
	}

	@SuppressLint("HandlerLeak")
	public class BaseHandler extends Handler {

		private DataCallBack<JSONObject> callback;


		public BaseHandler(DataCallBack<JSONObject> callBack) {
			this.callback = callBack;
		}

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);

			switch (msg.what) {
			case NONETWORK:
				Log.e("BAG", "Request failed due to no available network");
				break;
			case NOCONTENT:
				Log.e("BAG", "Request complete with no data");
				break;
			case COMPLETE:
				Log.e("BAG", "Request complete successfully");
				// TODO 返回json数据进行解析
				JSONObject obj = (JSONObject) msg.obj;
				callback.doInBackground(obj);
				break;

			default:
				break;
			}


		}

	}

	public class BaseTask implements Runnable {

		private RequestVo requestVo;
		private Handler handler;

		public BaseTask(RequestVo requestVo, Handler handler) {
			this.requestVo = requestVo;
			this.handler = handler;
		}

		@Override
		public void run() {
			// Looper.prepare();
			JSONObject jo;
			if (Tools.hasNoNetwork(BaseActivity.this)) {
				handler.sendEmptyMessage(NONETWORK);
				Log.e("BAG", "网络不通");
				jo=null;
			} else {
				 jo = HttpRequest.postRequest(requestVo);
				Log.e("BAG", "获取到的JO"+ jo);

				if (jo != null) {
					Message msg = Message.obtain();
					msg.what = COMPLETE;
					msg.obj = jo;

					cn.bxw1.bxapp.base.DemoApp.json=jo.toString();
					Log.e("BAG", "json!!!!!!!!!!!!!!!!"+ cn.bxw1.bxapp.base.DemoApp.json);
					handler.sendMessage(msg);
				} else {
					handler.sendEmptyMessage(NOCONTENT);
				}
			}
			// Looper.loop();


		}
	}

	public abstract interface DataCallBack<T> {
		public abstract void doInBackground(T jo);
	}

}
