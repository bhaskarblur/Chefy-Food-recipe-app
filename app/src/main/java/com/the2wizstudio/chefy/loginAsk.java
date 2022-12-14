package com.the2wizstudio.chefy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.the2wizstudio.chefy.databinding.ActivityLoginAskBinding;

public class loginAsk extends AppCompatActivity {
    ActivityLoginAskBinding binding;
    SharedPreferences loginCheck;
    String loggedIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginAskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.backgroundGreen, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.backgroundGreen));
        }
        loginCheck= getSharedPreferences("loginCheck",0);
        loggedIn= loginCheck.getString("loggedIn","");
        if(loggedIn.equals("yes")) {
            Intent intent=new Intent(loginAsk.this,mainActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.fade_2,R.anim.fade);
        }
        viewFunc();
    }

    private void viewFunc() {

        binding.laterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences2= getSharedPreferences("loginCheck",0);
                SharedPreferences.Editor editor2=sharedPreferences2.edit();
                editor2.putString("loggedIn","yes");
                editor2.commit();
                SharedPreferences sharedPreferences= getSharedPreferences("onbdone",0);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("onbdone","yes");
                editor.commit();
                Intent intent=new Intent(loginAsk.this,mainActivity.class);
                finish();
                startActivity(intent);
                overridePendingTransition(R.anim.fade_2,R.anim.fade);
            }
        });
        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginAsk.this,loginActivity.class));
                overridePendingTransition(R.anim.fade_2,R.anim.fade);
            }
        });

        binding.signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginAsk.this,createAccount.class));
                overridePendingTransition(R.anim.fade_2,R.anim.fade);
            }
        });
    }


    @Override
    public void onBackPressed() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this).
                    setTitle("Exit?").setMessage("Do you want to exit the app?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            builder.show();
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_2,R.anim.fade);
    }
}