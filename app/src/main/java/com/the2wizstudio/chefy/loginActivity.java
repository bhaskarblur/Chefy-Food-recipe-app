package com.the2wizstudio.chefy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.the2wizstudio.chefy.databinding.ActivityLoginBinding;

public class loginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }
        
        viewFunc();
    }

    private void viewFunc() {
        Typeface typeface = ResourcesCompat.getFont(this, R.font.montserrat_medium);
        binding.phone.setTypeface(typeface);
        binding.backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.forpassText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginActivity.this,forgotPassword.class));
                overridePendingTransition(R.anim.fade_2,R.anim.fade);
            }
        });

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_2,R.anim.fade);
    }
}