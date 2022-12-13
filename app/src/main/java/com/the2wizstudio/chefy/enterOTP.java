package com.the2wizstudio.chefy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.the2wizstudio.chefy.databinding.ActivityEnterOtpBinding;

public class enterOTP extends AppCompatActivity {
    ActivityEnterOtpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityEnterOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }

        ManageUI();
        viewFunc();
    }

    private void viewFunc() {

        binding.backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.resendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(enterOTP.this,enterOTP.class));
                overridePendingTransition(R.anim.fade_2,R.anim.fade);
            }
        });

        binding.confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=getIntent();
                Bundle bundle=intent.getExtras();
                String action=bundle.getString("action");
                if(action.toString().equals("forgotPassword")) {
                    startActivity(new Intent(enterOTP.this,resetPassword.class));
                    overridePendingTransition(R.anim.fade_2,R.anim.fade);
                    finish();
                }
                else if(action.toString().equals("createAccount")) {
                    // create new account;
                    startActivity(new Intent(enterOTP.this,selectInterest.class));
                    overridePendingTransition(R.anim.fade_2,R.anim.fade);
                    finish();

                }
                else if(action.toString().equals("login")) {
                    // login to Home;
                    SharedPreferences sharedPreferences2= getSharedPreferences("loginCheck",0);
                    SharedPreferences.Editor editor2=sharedPreferences2.edit();
                    editor2.putString("loggedIn","yes");
                    editor2.commit();
                    SharedPreferences sharedPreferences= getSharedPreferences("onbdone",0);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("onbdone","yes");
                    editor.commit();
                    startActivity(new Intent(enterOTP.this,mainActivity.class));
                    overridePendingTransition(R.anim.fade_2,R.anim.fade);
                    finish();
                }

            }
        });

    }

    private void ManageUI() {

        binding.otpbox1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    binding.otpbox2.requestFocus();
                }
            }
        });

        binding.otpbox2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    binding.otpbox3.requestFocus();
                } else {
                    binding.otpbox1.requestFocus();
                }
            }
        });

        binding.otpbox3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    binding.otpbox4.requestFocus();
                } else {
                    binding.otpbox2.requestFocus();
                }
            }
        });

        binding.otpbox4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    // send api call & check otp here;
                    binding.confirm.requestFocus();
                } else {
                    binding.otpbox3.requestFocus();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(binding.otpbox4.isFocused()) {
            binding.otpbox3.requestFocus();
        }
        else  if(binding.otpbox3.isFocused()) {
            binding.otpbox2.requestFocus();
        }
        else  if(binding.otpbox2.isFocused()) {
            binding.otpbox1.requestFocus();
        }
        else if(binding.otpbox1.isFocused()) {
           finish();
        }
        else{
            finish();
        }

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_2,R.anim.fade);
    }
}