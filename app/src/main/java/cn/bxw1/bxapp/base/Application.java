package cn.bxw1.bxapp.base;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Application extends android.app.Application {

    public static final String SERVER = "http://192.168.3.50:8080/work/";
    public static final String ACTION_LOGIN = "login";
    public static final String ACTION_REGIST = "reg";
    public static final String ACTION_LOGOUT = "logout";
    public static final String ACTION_GETCODE = "get_code";
    public static final String ACTION_REPASS = "mod_password";
    public static final String ACTION_SIGN = "sign";
    public static final String ACTION_HIS = "getSignMonthDetail";


    public static Context context;
    public static String json;
    private AlarmManager alarmManager;
    private PendingIntent operation;


    @Override
    public void onCreate() {
        super.onCreate();
        Application.context = getApplicationContext();
        json = null;
        SpeechUtility.createUtility(context, SpeechConstant.APPID +"=58fd9386");
//        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//
//        // 创建Intent对象，action为android.intent.action.ALARM_RECEIVER
//        Intent intent = new Intent("android.intent.action.ALARM_RECEIVER");
//        operation = PendingIntent.getBroadcast(this, 0, intent, 0);
//        alarmManager.set(AlarmManager.RTC_WAKEUP, getDateMills("2016-12-21 10:10:00"),operation);

    }

    @SuppressLint("SimpleDateFormat")


    public long getDateMills(String dateStr) {
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        Date date = null;

        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();



    }
}
