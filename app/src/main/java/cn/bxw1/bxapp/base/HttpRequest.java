package cn.bxw1.bxapp.base;

import android.util.Log;

import cn.bxw1.bxapp.vo.RequestVo;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class HttpRequest {
	public static String json;
	public static String jsont;
    private static JSONObject obj;


	private static Header[] headers = new BasicHeader[1];
	private static final String TAG = "HttpRequest";

	public static JSONObject postRequest(RequestVo requestVo) {
		// 创建httppost请求对象
		HttpPost request = new HttpPost(requestVo.requestUrl);

		Log.e(TAG, "Request Url :: " + requestVo.requestUrl);

		// 设置请求头
		request.setHeaders(headers);
		// 设置请求参数
		ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
		// 从请求参数中取出用户名和密码信息
		Map<String, String> paramsMap = requestVo.requestDataMap;

		Log.e(TAG, "Parameters' HashMap :: " + paramsMap.toString());
		try {
			if (requestVo.requestDataMap != null) {
				for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
					pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
				}
			}
			// 请求参数加入裸体内容
			HttpEntity entity = new UrlEncodedFormEntity(pairs, "utf-8");
			request.setEntity(entity);

			// 获取服务器响应
			HttpResponse response = new DefaultHttpClient().execute(request);
			int statusCode = response.getStatusLine().getStatusCode();
			Log.e(TAG, "StatusCode = " + statusCode);
			if (statusCode == HttpStatus.SC_OK) {
				 json = EntityUtils.toString(response.getEntity());

//                obj= (JSONObject) JSON.parse(json);
//                jsont=obj.getString("token");
//				Log.e(TAG, json);

				Log.e(TAG, json);

				return new JSONObject(json);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	static {
		headers[0] = new BasicHeader("appkey", "www.itechs.cn");
	}
}
