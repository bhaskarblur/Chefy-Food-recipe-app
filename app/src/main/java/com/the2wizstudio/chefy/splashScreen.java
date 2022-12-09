package com.the2wizstudio.chefy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.window.SplashScreen;

public class splashScreen extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        this.getSupportActionBar().hide();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.backgroundGreen, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.backgroundGreen));
        }
        skipSplash();
    }

    private void skipSplash() {

        sharedPreferences = getSharedPreferences("onbdone", 0);
        String onbchecker = sharedPreferences.getString("onbdone", "");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (onbchecker == null) {
                    startActivity(new Intent(splashScreen.this, onBoarding.class));
                    finish();
                } else if (onbchecker.equals("yes")) {
                    //open Login
                    startActivity(new Intent(splashScreen.this, loginAsk.class));
                    finish();
                } else if (onbchecker != "yes" && !onbchecker.equals(null)) {
                    //open Login
                    startActivity(new Intent(splashScreen.this, onBoarding.class));
                    finish();
                }


            }

        }, 1500);
    }
        // this will skip the splashScreen

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_2,R.anim.fade);
    }
}

