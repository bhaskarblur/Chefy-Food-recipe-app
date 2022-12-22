package com.the2wizstudio.chefy;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

import com.the2wizstudio.chefy.databinding.ActivityIngredientsScannedBinding;

public class IngredientsScanned extends AppCompatActivity {
    ActivityIngredientsScannedBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityIngredientsScannedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }

        viewFunc();
        manageViews();
    }

    private void manageViews() {
        final Boolean[] switchSide = {false};
        binding.instructionSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(switchSide[0] ==false) {
                    TranslateAnimation animation1 = new TranslateAnimation(0.0f, 450.0f, 0.0f, 0.0f); // new TranslateAnimation(xFrom,xTo, yFrom,yTo)
                    animation1.setDuration(200); // animation duration
                    animation1.setFillAfter(false);
                    binding.tabBg3.setVisibility(View.VISIBLE);
                    binding.tabBg1.setVisibility(View.INVISIBLE);
                    binding.tabBg3.startAnimation(animation1);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            binding.tabBg2.setVisibility(View.VISIBLE);
                            binding.tabBg3.setVisibility(View.INVISIBLE);
                            binding.switchText2.setTextColor(getResources().getColor(R.color.white));
                            binding.switchText.setTextColor(getResources().getColor(R.color.textBlack));
                            binding.ingredientLayout.setVisibility(View.GONE);
                            binding.additionalLayout.setVisibility(View.GONE);
                            binding.instructionsLayout.setVisibility(View.VISIBLE);
                            binding.additionalLayout2.setVisibility(View.VISIBLE);
                        }
                    }, 150);

                    switchSide[0] =true;
                }
            }
        });

        binding.ingredientSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(switchSide[0] ==true) {
                    TranslateAnimation animation1 = new TranslateAnimation(450.0f, 0.0f, 0.0f, 0.0f); // new TranslateAnimation(xFrom,xTo, yFrom,yTo)
                    animation1.setDuration(200); // animation duration
                    animation1.setFillAfter(false);
                    binding.tabBg3.setVisibility(View.VISIBLE);
                    binding.tabBg1.setVisibility(View.INVISIBLE);
                    binding.tabBg3.startAnimation(animation1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            binding.tabBg1.setVisibility(View.VISIBLE);
                            binding.tabBg2.setVisibility(View.INVISIBLE);
                            binding.tabBg3.setVisibility(View.INVISIBLE);
                            binding.switchText.setTextColor(getResources().getColor(R.color.white));
                            binding.switchText2.setTextColor(getResources().getColor(R.color.textBlack));
                            binding.instructionsLayout.setVisibility(View.GONE);
                            binding.additionalLayout2.setVisibility(View.GONE);
                            binding.ingredientLayout.setVisibility(View.VISIBLE);
                            binding.additionalLayout.setVisibility(View.VISIBLE);
                        }
                    }, 150);

                    switchSide[0] =false;
                }
            }
        });

    }

    private void viewFunc() {
        binding.closeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_2,R.anim.fade);
    }
}