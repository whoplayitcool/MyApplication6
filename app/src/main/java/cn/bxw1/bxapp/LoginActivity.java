package cn.bxw1.bxapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import cn.bxw1.bxapp.login.RegActivity;
import cn.bxw1.bxapp.myapplication.R;


public class LoginActivity extends cn.bxw1.bxapp.base.BaseActivity implements OnClickListener, TextWatcher {

    private static final String TAG = "ALoginActivity";
    private EditText et_pwd = null;
    private EditText et_usr = null;
    private ImageButton ib_clear = null;
    private ImageButton ib_back = null;
    private TextView tv_regist = null;
    private TextView tv_title = null;
    private SharedPreferences sp = null;
    private Button bt_login = null;
    private Button bt_logout = null;
    private Button bt_getcode = null;
    private String result = null;
    private String password = null;
    private Button login = null;
    private TextView tv_reg=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.login).setOnClickListener(LoginActivity.this);
        findViewById(R.id.vlogin).setOnClickListener(LoginActivity.this);
        findViewById(R.id.flogin).setOnClickListener(LoginActivity.this);
        tv_reg = (TextView)findViewById(R.id.tv_reg);
        tv_reg.setOnClickListener(LoginActivity.this);


        Log.i(TAG, "ALoginActivity.class :: onCreate()");

        sp = getSharedPreferences("userinfo", Context.MODE_PRIVATE);

//		et_pwd = (EditText) findViewById(R.id.et_login_password);
//		et_usr = (EditText) findViewById(R.id.et_login_username);
//		ib_clear = (ImageButton) findViewById(R.id.ib_login_clear);
//		ib_back = (ImageButton) findViewById(R.id.ib_login_back);
//		tv_regist = (TextView) findViewById(R.id.tv_regist);
//		tv_title = (TextView) findViewById(R.id.tv_login_title);
//		bt_login = (Button) findViewById(R.id.bt_login);
//		bt_logout = (Button) findViewById(R.id.bt_logout);
//		bt_getcode = (Button)findViewById(R.id.bt_getcode);
//
//		ib_back.setOnClickListener(this);
//		ib_clear.setOnClickListener(this);
//		tv_title.setOnClickListener(this);
//		et_usr.addTextChangedListener(this);
//		tv_regist.setOnClickListener(this);
//		bt_login.setOnClickListener(this);
//		bt_logout.setOnClickListener(this);
//		bt_getcode.setOnClickListener(this);
//		tv_regist.setText(Html.fromHtml("<u>" + getString(R.string.login_regist) + "</u>"));
//
//		sp.getString("username", "");
    }

    @Override
    public void onClick(View v) {
//		switch (v.getId()) {
//		case R.id.ib_login_clear:
//			et_usr.setText("");
//			break;
//		case R.id.ib_login_back:
//			this.finish();
//			break;
//		case R.id.tv_regist:
//			startActivity(new Intent(this, SplashActivity.class));
//			//跳转到注册页面，暂时用SPLASH代替
//			break;
//		case R.id.tv_login_title:
//			this.finish();
//			break;
//		case R.id.bt_login:
////			actionLogin();
//			result=getSharedPreferences("user",MODE_PRIVATE).getString("result","false");
//			if(result.equals("true")) {
//				Intent intent=new Intent(ALoginActivity.this,SplashActivity.class);
//				//跳转到登录页面，暂时用SPLASH代替
//				startActivity(intent);
//				finish();
//
//
//			}else {
//				Toast.makeText(ALoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();}
//
//			break;
//			case R.id.bt_logout:
////				actionLogout();
//				break;
//			case R.id.bt_getcode:
////				actionGetcode();
//				Intent intent1=new Intent(ALoginActivity.this,SplashActivity.class);
//				//跳转到修改密码页面，暂时用SPLASH代替
//				startActivity(intent1);
//				break;
//
//		default:
//			break;
//		}
        switch (v.getId()) {
            case R.id.vlogin:
                // 获取密
                // 码之前先终止之前的注册或验证过程
              startActivity(new Intent(LoginActivity.this, cn.bxw1.bxapp.login.ALoginActivity.class));
                break;
            case R.id.flogin:
                startActivity(new Intent(LoginActivity.this, cn.bxw1.bxapp.login.OnlineFaceDemo.class));
                break;
            case R.id.login:
//                startActivity(new Intent(LoginActivity.this, OnlineFaceDemo.class));
                break;
            case R.id.tv_reg:
                startActivity(new Intent(LoginActivity.this, RegActivity.class));
                break;



                }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

//	private void actionGetcode() {
//
//		String phone=getSharedPreferences("user",Context.MODE_PRIVATE).getString("phone","");
//
//		String requestUrl = Application.SERVER + Application.ACTION_GETCODE;
//		Map<String, String> requestDataMap = new HashMap<String, String>();
//		requestDataMap.put("phone", phone);
//
//		RequestVo requestVo = new RequestVo(requestUrl, requestDataMap);
//
//		super.getDataFromServer(requestVo, new DataCallBack<JSONObject>() {
//			private String guid;
//			private String code;
//
//			@Override
//			public void doInBackground(JSONObject jo) {
//
//				guid=parsedJson(jo.toString()).getGuid();
//				code=parsedJson(jo.toString()).getCode();
//
//
//				getSharedPreferences("user",Context.MODE_PRIVATE).edit().putString("guid",guid).commit();
//				getSharedPreferences("user",Context.MODE_PRIVATE).edit().putString("code",code).commit();
//
//
//
//
//
//
//			}
//		});
//
//	}
//
//	private void actionLogout() {
//		String phone=getSharedPreferences("user",Context.MODE_PRIVATE).getString("phone","");
//
//
//
//		String requestUrl = Application.SERVER + Application.ACTION_LOGOUT;
//		Map<String, String> requestDataMap = new HashMap<String, String>();
//		requestDataMap.put("phone", phone);
////		token=Application.json.substring(Application.json.length()-38,Application.json.length()-1);
//		String token=getSharedPreferences("user",MODE_PRIVATE).getString("token","");
//		requestDataMap.put("token", token);
//		RequestVo requestVo = new RequestVo(requestUrl, requestDataMap);
//
//		super.getDataFromServer(requestVo, new DataCallBack<JSONObject>() {
//
//			@Override
//			public void doInBackground(JSONObject jo) {
//				getSharedPreferences("user",MODE_PRIVATE).edit().putString("token","");
//
//			}
//		});
//
//	}
//
//	/**
//	 * 用户登录
//	 */
//	private void actionLogin() {
//		String phone = et_usr.getText().toString().trim();
//		password = et_pwd.getText().toString().trim();
//
//		SharedPreferences preferences=getSharedPreferences("user",Context.MODE_PRIVATE);
//		SharedPreferences.Editor editor=preferences.edit();
//
//
//		editor.putString("phone", phone);
//
//		editor.commit();
//
//		String requestUrl = Application.SERVER + Application.ACTION_LOGIN;
//		Map<String, String> requestDataMap = new HashMap<String, String>();
//		requestDataMap.put("phone", phone);
//		requestDataMap.put("password", password);
//		RequestVo requestVo = new RequestVo(requestUrl, requestDataMap);
//		super.getDataFromServer(requestVo, new DataCallBack<JSONObject>() {
//			private String token;
//
//			@Override
//			public void doInBackground(JSONObject jo) {
//				token=parsedJson(jo.toString()).getToken();
//				result=parsedJson(jo.toString()).getResult();
//
//				SharedPreferences preferences=getSharedPreferences("user",Context.MODE_PRIVATE);
//				SharedPreferences.Editor editor=preferences.edit();
//
//
//				editor.putString("token", token);
//				editor.putString("result",result);
//
//
//				editor.commit();
//
//			}
//		});
//
//
//
//
//
//	}
//
//	@Override
//	public void afterTextChanged(Editable s) {
//		if (et_usr.getText().toString().trim().length() > 0) {
//			ib_clear.setVisibility(View.VISIBLE);
//		} else {
//			ib_clear.setVisibility(View.GONE);
//		}
//	}
//
//	@Override
//	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//	}
//
//	@Override
//	public void onTextChanged(CharSequence s, int start, int before, int count) {
//	}
//	private Repass parsedJson(String json) {
//
//		return JSON.parseObject(json, Repass.class);
//	}
}
