package cn.bxw1.bxapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import cn.bxw1.bxapp.myapplication.R;


public class SplashActivity extends Activity {
    private ImageView iv_splash;
    private boolean firstin=true;
    private String token;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        SharedPreferences sp=getSharedPreferences("mihui",MODE_PRIVATE);
//        firstin=sp.getBoolean("firstin",true);
//
//        if(firstin) {
//            Intent intent=new Intent(SplashActivity.this,GuidActivity.class);
//            startActivity(intent);
//
//        }
        setContentView(R.layout.activity_splash);
        iv_splash = (ImageView) findViewById(R.id.iv_splash);
//        RotateAnimation ra = new RotateAnimation(0, 1000, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        ScaleAnimation sa=new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f,
                Animation.RELATIVE_TO_SELF, 0.7f, Animation.RELATIVE_TO_SELF, 0.6f);
        sa.setDuration(2500);
        sa.setFillAfter(true);
        sa.start();

        iv_splash.setAnimation(sa);
        sa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                  Intent intent=new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();




            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



    }



}