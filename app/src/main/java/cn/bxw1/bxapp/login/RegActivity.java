package cn.bxw1.bxapp.login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.bxw1.bxapp.base.BaseActivity;
import cn.bxw1.bxapp.base.DemoApp;
import cn.bxw1.bxapp.modle.bean.GetCodeCallbackModel;
import cn.bxw1.bxapp.myapplication.R;
import cn.bxw1.bxapp.vo.RequestVo;

import static cn.bxw1.bxapp.base.HttpRequest.json;

public class RegActivity extends BaseActivity implements View.OnClickListener {
    private Button bt_getverifycode;
    private String mobile = "";
    private Button bt_reg;
    private String vercode;
    private String password;
    private String name;
    private boolean prompt = false;
    private boolean checkUpResult = true;
    private EditText et_vercode;
    private EditText et_password;
    private EditText et_mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        bt_getverifycode = (Button) findViewById(R.id.bt_getverifycode);
        bt_getverifycode.setOnClickListener(RegActivity.this);
        bt_reg = (Button) findViewById(R.id.bt_reg);
        bt_reg.setOnClickListener(RegActivity.this);
        et_vercode = (EditText) findViewById(R.id.et_vercode);
        et_password = (EditText) findViewById(R.id.et_password);
        et_mobile = (EditText) findViewById(R.id.et_mobile);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_getverifycode:
                getveriFycode();
                Log.e("BAG", "发送获取验证码请求");

                break;
            case R.id.bt_reg:
                Log.e("BAG", "发送注册请求");
                sendReg();
                break;
        }

    }

    private void sendReg() {
        Log.e("BAG", "进入注册方法");
        mobile = et_mobile.getText().toString().trim();
        password = et_password.getText().toString().trim();
        vercode = et_vercode.getText().toString().trim();
        name = "default";

        if (mobile.equals("") && prompt) {
            Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
            checkUpResult = false;
            prompt = false;
        }

        if (!checkPhoneNumber(mobile) && prompt) {
            Toast.makeText(this, "手机号格式不正确", Toast.LENGTH_SHORT).show();
            checkUpResult = false;
            prompt = false;
        }


        if (password.equals("") && prompt) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            checkUpResult = false;
            prompt = false;
        }
        if (checkUpResult) {
            String requestUrl = DemoApp.SERVER + DemoApp.ACTION_REGIST; // 请求地址
            HashMap<String, String> requestDataMap = new HashMap<String, String>(); // 请求参数
            requestDataMap.put("mobile", mobile);
            requestDataMap.put("password", password);
            requestDataMap.put("name", name);
            requestDataMap.put("vercode", vercode);
            RequestVo requestVo = new RequestVo(requestUrl, requestDataMap);
            Log.e("BAG", "注册请求信息是" + requestVo.toString());
            super.getDataFromServer(requestVo, new DataCallBack<JSONObject>() {


                @Override
                public void doInBackground(JSONObject jo) {
                    Log.e("BAG", "获取用户注册服务器返回信息++++++++" + parsedJson(jo.toString()).getRetmsg());


                }
            });


        }

    }


    private void getveriFycode() {
        Log.e("BAG", "进入获取验证码请求方法");
        mobile = et_mobile.getText().toString().trim();
        if (mobile.equals("") && prompt) {
            Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
            checkUpResult = false;
            prompt = false;
        }

        if (!checkPhoneNumber(mobile) && prompt) {
            Toast.makeText(this, "手机号格式不正确", Toast.LENGTH_SHORT).show();
            checkUpResult = false;
            prompt = false;
        }
        if (checkUpResult) {
            // TODO 信息校验通过，提交到服务器进行注册
            String requestUrl = DemoApp.SERVER + DemoApp.ACTION_GETVCODE; // 请求地址

            HashMap<String, String> requestDataMap = new HashMap<String, String>(); // 请求参数
            requestDataMap.put("mobile", mobile);


            RequestVo requestVo = new RequestVo(requestUrl, requestDataMap);
            Log.e("BAG", "获取验证码请求信息是" + requestVo.toString());


            // 发送请求处理数据
            super.getDataFromServer(requestVo, new DataCallBack<JSONObject>() {


                @Override
                public void doInBackground(JSONObject jo) {
                    Log.e("BAG", "获取验证码服务器返回信息:++++++++++" + parsedJson(jo.toString()).getRetmsg());


                }
            });

        }


    }

    private GetCodeCallbackModel parsedJson(String s) {
        return JSON.parseObject(json, GetCodeCallbackModel.class);
    }

    public static boolean checkPhoneNumber(String mobiles) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // 验证手机号
        m = p.matcher(mobiles);
        b = m.matches();
        return b;
    }


}

